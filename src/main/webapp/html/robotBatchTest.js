inntParameter(['root/BusinessPara/robot/batchTestStatus','root/BusinessPara/robot/batchTestResult']);
var channels= [];
$(function() {
    initDialog('detail','批量测试明细','','icon-switch');
    initEmptyGrid('detail_question_List', 'tb-trans2', true, 1, 10, true, true, true);/* 初始化带分页器的空datagrid */
    initEmptyGrid('query_list', 'tb-trans', true, 1, 20,true,
        true, true);/* 初始化带分页器的空datagrid */
    initDialog('openWin','导入','winTools','icon-info');//dialog初始化
    $.ajax({
        type :'post',
        url : getHost(HostAddress.robot)+"/robot/config/getConfigs",
        data : {
            rows:1000,
            page:1
        },
        cache : false,
        dataType : 'json',
        success : function(data) {
            if(data.returnCode = "0000"){
                if(data.rows != null && data.rows.length > 0){
                    channels = data.rows;
                    $('#channelNo').combobox('loadData',data.rows);
                    $('#channelQuery').combobox('loadData',data.rows);
                }
            }
        }
    });
});

function query(){
    $('#query_list').datagrid({
        method:"get",
        url: getHost(HostAddress.robot)+"/robot/batchTest/getBatchTestPage",
        queryParams:{
            name: $('#queryName').textbox('getValue'),
            channelNo:$('#channelQuery').combobox('getValue'),
            /*获取时间*/
            beginTime:($('#beginTime').textbox('getValue')!=null & $('#beginTime').textbox('getValue')  !='')?($('#beginTime').textbox('getValue')+ " 00:00:00"):(null),
            endTime:($('#endTime').textbox('getValue')!=null & $('#endTime').textbox('getValue')  !='')?($('#endTime').textbox('getValue')+ " 23:59:59"):(null)

        }
    });
}

function openImportWin(){
    $('#fileName').textbox('setValue','');
    $('#editForm').form('reset');
    $('#fileInput').html("<input type=\"file\" id=\"files\" name=\"files\"\n" +
        "    onchange=\"fileChange(this)\"><a onclick='downLoadTemp()' herf='#'>模板下载</a>");
    //新增
    $('#openWin').dialog('open');
}

function downLoadTemp(){
    window.open(getHost(HostAddress.ui)+"/sunriseui/robot/pages/robottest/batchTest.xlsx");
}

//文件大小判断
function fileChange(target){
    var file = $("#files").val();
    var arr = file.split('.');
    var str = arr[arr.length-1];
    str=str.toLowerCase();
    if(str != "xls" && str != "xlsx"){
        $.messager.alert('警告','请选择Excel！','warning');
        document.getElementById('files').value = null;
        return;
    }
    var fileSize = 0;
    if(!target.files){
        var filePath = target.value;
        var fileSystem = new ActiveXObject("Scriting.FileSystemObject");
        var file = fileSystem.GetFile(filePath);
        fileSize = file.Size;
    }else{
        fileSize = target.files[0].size;
        console.log(target.files[0]);

    }
    var size = fileSize/1024/1024;
    if(size>10){
        $.messager.alert('警告','文件大小超过10M!请重新选择！','warning');
        document.getElementById('files').value = null;
        return;
    }
}

function saveRobotFile(){
    var obj  = new Object();
    var account = getAccount();
    obj.name = $('#name').textbox('getValue');
    if(obj.name == null || obj.name == ""){
        $.messager.alert('提示', '批次名称不能为空！', 'error');
        return;
    }
    obj.channelNo = $('#channelNo').combobox("getValue");
    obj.createAccountCode = account.accountCode;
    var fileName = $("#files").val();
    if(fileName == null ||  fileName == ""){
        $.messager.alert('提示', '请选择上传文件！', 'error');
        return;
    }
    $.messager.progress({title:'请稍等',msg:'正在提交...'});
    $.ajaxFileUpload({
        type : "POST",
        url : getHost(HostAddress.robot)+"/robot/batchTest/saveBatchTestInfo",
        secureuri : false, // 是否需要安全协议，一般设置为false
        data:obj,
        fileElementId : 'files', // 文件上传域的ID
        dataType : 'json', // 返回值类型 一般设置为json
        async : false,
        success : function(resultData) // 服务器成功响应处理函数
        {
            $.messager.progress('close');
            if (resultData.returnCode == ReturnCode.success) {
                $.messager.alert('提示', '操作成功！', 'info');
                $('#openWin').dialog('close');
                $('#query_list').datagrid('reload');
            } else {
                $.messager.alert('提示', resultData.returnMessage, 'info');
            }
        },
        error : function(data) {
            $.messager.progress('close');
        }
    });
}

function formatChannel(value){
    for(var i=0;i < channels.length;i++){
        if(channels[i].chanel == value ){
            /*console.log("channels[i].name:"+channels[i].name);
            console.log("channels[i].chanel:"+value);*/
            return channels[i].name;
        }
    }
}



/**
 * 导出质检任务当前页查询结果
 */
function exportQcTask() {
    var row=$('#query_list').datagrid('getSelected');
    if(row == null){
        $.messager.alert('警告','请选择状态为处理完毕的批次');
        return;
    }
    if(row.status != '3'){
        $.messager.alert('警告','请选择状态为处理完毕的批次');
        return;
    }
    $('#exportForm').form('load',row);
    document.getElementById("exportForm").action = getHost(HostAddress.uomp) + '/uomp/robotFile/exportRobotBatchTest';;
    document.getElementById("exportForm").submit();
}

function formatHitRate(value,row,index){
    if(row.status == '3'){
        if(row.questionNum == 0){
            return "0";
        }else{
            return (row.hitNum/row.questionNum).toFixed(2)*100+'%';
        }
    }
}