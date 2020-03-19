/*$(function() {
    initEmptyGrid('query_list', 'tb-trans', true, 1, 20,true,true, true);/!* 初始化带分页器的空datagrid *!/
    initDialog('openWin','编辑素材','winTools','icon-info');//dialog初始化
    initDialog('openUrlWin','分享地址','','icon-info');//dialog初始化
})*/
function packageData() {
    var postData = getUOMPPostData();
    return convertUOMPData(postData, 'query_form');
}

function query_file(){
    $('#query_list_file').datagrid({
                method:"get",
                //url: getHost(HostAddress.uomp)+"/uomp/robotFile/selectRobotFilePageByBean",
                url: getHost(HostAddress.robot)+"/robotFile/selectRobotFilePageByBean",
                queryParams:{
                    fileName:'fileName',
                    startDate:'startDate',
                    endDate:'endDate'
                },
                onLoadSuccess: function (data) {
                    $('.button-delete').linkbutton({
                    });
                    $('.button-edit').linkbutton({
                    });
        }
    });
}

function getFileName(o){
    var pos=o.lastIndexOf("\\");
    return o.substring(pos+1);
}

//文件大小判断
function fileChange(target){
    var file = $("#files").val();
    var fileName = getFileName(file);
    if($("#fileName").textbox('getValue') == ""){
        $("#fileName").textbox('setValue',fileName)
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
    if(size>200){
        $.messager.alert('警告','文件大小超过200M!请重新选择！','warning');
        document.getElementById('files').value = null;
        return;
    }
}
var winType = "";
/*修改和新增都是打开这个openDetail(type)---$('#openWin').dialog('open');*/
function openDetail_file(type){
    winType = type;
    $('#fileName').textbox('setValue','');
    $('#fileInput').html("<input type=\"file\" id=\"files\" name=\"files\"\n" +
        "    onchange=\"fileChange(this)\"><span style='color: Red'>(文件大小不超过200M)</span>");
    if(type == "add"){
        //新增
        $('#openWin').dialog('open');
    }else{
        //修改#query_list 是datagrid的id
        var row = $('#query_list').datagrid('getSelected');
        if(''==row||null==row){
            $.messager.alert('提示','请选择需要修改的素材','info');
            return;
        }
        $('#fileName').textbox('setValue',row.fileName);
        $('#openWin').dialog('open');
    }
}

function saveRobotFile(){
    var obj  = new Object();
    var account = getAccount();
    obj.fileName = $('#fileName').textbox('getValue');
    if(obj.fileName == null || obj.fileName == ""){
        $.messager.alert('提示', '文件名不能为空！', 'error');
        return;
    }
    obj.updateAccountCode = account.accountCode;
    obj.createAccountCode = account.accountCode;
    var fileName = $("#files").val();
    if(fileName == null ||  fileName == ""){
        if(winType == 'add'){
            $.messager.alert('提示', '请选择上传文件！', 'error');
            return;
        }
        obj.hasFile = false;
    }else{
        obj.hasFile = true;
    }
    if(winType == 'edit'){
        obj.id = $('#query_list').datagrid('getSelected').id;
    }
    $.messager.progress({title:'请稍等',msg:'正在提交...'});
    $.ajaxFileUpload({
        type : "POST",
        url : getHost(HostAddress.uomp)+"/uomp/robotFile/saveRobotFileInfo",
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
                $.messager.alert('提示', '操作失败！', 'info');
            }
        },
        error : function(data) {
            $.messager.progress('close');
        }
    });
}

function addButton(value,row,index) {
    var btn = '<a class="button-delete button-green" onclick="ShowDetail(\'' +encodeURIComponent(row.publicNetworkUrl)+'\',\''+encodeURIComponent(row.lanUrl) + '\')"  href="javascript:void(0)">分享地址</a>';
    console.log(btn);
    return btn;
}

function ShowDetail(publicNetworkUrl,lanUrl){
    console.log(publicNetworkUrl);
    $('#openUrlWin').dialog('open');
    $('#publicNetworkUrl').textbox('setValue',decodeURIComponent(publicNetworkUrl));
    $('#lanUrl').textbox('setValue',decodeURIComponent(lanUrl));
}

function  deleteFile(){
    var row = $('#query_list').datagrid('getSelected');
    if(''==row||null==row){
        $.messager.alert('提示','请选择需要删除的素材','info');
        return;
    }
    $.messager.confirm('确认','您确认删除['+row.fileName+']？',function(r){
        if (r){
            var obj = new Object();
            obj.id = row.id;
            obj.filePath = row.filePath;
            postUOMPCallback(getHost(HostAddress.uomp)+"/uomp/robotFile/deleteRobotFileInfo",window,'returnSuccess','returnSuccess',obj,null,'post',true);
        }
    });
}

function returnSuccess(data){
    if(data.returnCode==ReturnCode.success){
        $.messager.alert('提示','操作成功!','info');
        $('#openWin').dialog('close');
        $('#query_list').datagrid('reload');
    }else{
        $.messager.alert('提示',data.returnMessage,'info');
    }
}