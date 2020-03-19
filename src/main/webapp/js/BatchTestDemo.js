let channelsArr = [];
$(function(){
    $.ajax({
        method:'post',
        url:getHost(HostAddress.robot)+'/config/getConfig',
        data:{},
        success:function (data) {
            channelsArr=data;
            $('#channelQueryConfig').combobox('loadData',data);
        },error:function () {
           $.messager.alert('提示','查询config失败','info')
        }
    })
});

function formatChanel(value,row,index) {
    for(let i = 0; i<channelsArr.length;i++){
        if(channelsArr[i].chanel == value){
            return channelsArr[i].name;
        }
    }
}

let parameter = 'root/BusinessPara/robot/batchTestStatus';
let statusArr = [];
$(function(){
    $.ajax({
        url:getHost(HostAddress.robot)+'/dictionary/getDictionaryValuesMap',
        method:'get',
        data:{codePath:parameter},
        success:function (data) {
            statusArr=data;
            //$('#status').combobox('loadData',data);
        },error:function () {
            $.messager.alert('提示','查询dictionary失败','info')
        }
    })
});

function formatStatus(value,row,index) {
    for(var i = 0; i<statusArr.length;i++){
        if(statusArr[i].code == value){
            return statusArr[i].value;
        }
    }
}





//时间格式转换   先分别获得年月日，然后用-拼接。形成了年-月-日  然后再切割一次
function myformatter(date){
    let y = date.getFullYear();
    let m = date.getMonth()+1;
    let d = date.getDate();
    return y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d);   //三元表达式
}
function myparser(s){
    if (!s) return new Date();   //2019-11-22
    let ss = (s.split('-'));
    let y = parseInt(ss[0],10);
    let m = parseInt(ss[1],10);
    let d = parseInt(ss[2],10);
    if (!isNaN(y) && !isNaN(m) && !isNaN(d)){
        return new Date(y,m-1,d);   //2019:11:22
    } else {
        return new Date();
    }
}

//命中率
function formatHitRate(value,row,index){
    if(row.questionNum == 0){
        return "0";
    }else{
        return (row.hitNum/row.questionNum).toFixed(2)*100+'%';
    }
}


function  openDetail(){
    let row=$('#query_list').datagrid('getSelected');
    if(row!=null){
        $('#detail').dialog('open').dialog('center');
        queryDetail();
    }else{
        $.messager.alert('警告','请选择批次');
    }
}


function queryDetail(){
    let row=$('#query_list').datagrid('getSelected');
    $('#detail_question_List').datagrid({
        method:"get",
        url:HostAddress.robot+ "/batchTest/getBatchTestDetailPage",
        queryParams:{
            code: row.code
            /*question: $('#question').textbox('getValue'),
             isHit:$('#isHit').combobox('getValue')*/
        }
    });
}

//onchange()先不管
 function openImportWin2(){
     $('#editFormBT').form('reset');
     $('#fileInput').html("<input type=\"file\" id=\"files\" name=\"files\"\n" +
     "onchange=\"fileChange(this)\"><a onclick='downLoadTemp()' herf='#'>模板下载</a>");

     //新增
     $('#openWinBT').dialog('open');
 }

/*window.open（）实现下载*/   //http://127.0.0.1:80
function downLoadTemp(){   //F:\song\five\day11\ssm\src\main\webapp\batchTest.xlsx
    window.open(getHost(HostAddress.ui)+"/main/webapp/batchTest.xlsx");
}

function upLoadFile() {
    let channelNo = $('#channelNo2').combobox("getValue");
    let name = $("#name2").val();
    let fileName = $("#files").val();                        //文件名,js的由来
    if(fileName == null ||  fileName === ""){
        $.messager.alert('提示', '请选择上传文件！', 'error');
        return;
    }
    $.messager.progress({title:'请稍等',msg:'正在提交...'});
    $.ajaxFileUpload({                                     //ajaxFileUpload上传
        method : "post",
        url : getHost(HostAddress.robot)+"",  //BatchTEstBean和BeanTestDetailBean两张表的批量导入
        contentType:'application/json;charset=utf-8',
        secureuri : false, // 是否需要安全协议，一般设置为false
        data:{
            channelNo:channelNo,
            name:name
        },                   //一个obj参数就够了吗？
        fileElementId : 'files', // 文件上传域的ID
        dataType : 'json', // 返回值类型
        async : false,
        success : function(resultData) // 服务器成功响应处理函数
        {
            $.messager.progress('close');
            $.messager.alert('提示', '操作成功！', 'info');
            $('#openWinBT').dialog('close');
            $('#query_list').datagrid('reload');
        },
        error : function(data) {
            $.messager.progress('close');
        }
    });


}

function query(){
    $('#query_list').datagrid({
        method:"get",
        url: "http://127.0.0.1:8082"+"/batchTest/getBatchTestPage",
        queryParams:{name:$('#name').textbox('getValue'),channelNo:$('#channelNo').textbox('getValue'),beginTime:$('#beginTime').datebox('getValue'),endTime:$('#endTime').datebox('getValue')}
       /* queryParams:{
            channelNo:$('#channelNo').textbox('getValue'),
            /!*获取时间*!/
            beginTime:($('#beginTime').textbox('getValue')!=null & $('#beginTime').textbox('getValue')  !='')?($('#beginTime').textbox('getValue')+ " 00:00:00"):(null),
            endTime:($('#endTime').textbox('getValue')!=null & $('#endTime').textbox('getValue')  !='')?($('#endTime').textbox('getValue')+ " 23:59:59"):(null)
        }*/
    });
}

function toInsert(){
    $('#insertBt').dialog('open').dialog('center');
}

function Insert(){
    //ajax的url已经执行，但之后走error
    $.ajax({data:{
        code:$('#code2').textbox('getValue'),
        channelNo:$('#channelNo').textbox('getValue')
    },
        type : "POST",
        url : "http://127.0.0.1:8082"+"/batchTest/insert",

        dataType: "json",
        success : function(data) {
            $.messager.progress('close');  //进度条
            $('#insertBt').dialog('close');
            query();
        },
        error:function(e){
            $.messager.alert('提示','网络异常，请联系管理员','info');
        }
    });

}



/*质检员维护*/

function query2(){
    $('#query_list2').datagrid({
        method:"get",
        url: "http://127.0.0.1:8082"+"/qcOfficer/getQcOfficerPageByBean",
        //不会这个就是data数据吧
        queryParams:{
            officerCode:$('#officerCode').textbox('getValue'),
            officerName:$('#officerName').textbox('getValue')
        }
    });
}


var editFlag = false;
function openInsertQc(flag){
    editFlag = flag;
    $('#insertFormQc').form('reset');
    if(editFlag){
        var row = $('#query_list2').datagrid('getSelected');
        if(null != row && '' !=row){
            $('#insertFormQc').form('load',row);
            console.log(row);
        }else{
            $.messager.alert('提示','请选择要修改的数据','info')
            return;
        }
    }
    $('#insertQc').dialog('open').dialog('center');
}

function InsertQc(){
    var  code = $('#code').textbox('getValue');
    var  officerName = $('#officerName2').textbox('getValue');
    var  officerType = $('#officerType2').textbox('getValue');
    var  remark = $('#remark').textbox('getValue');

    console.log("officerType:   "+officerType);
    //ajax的url已经执行，但之后走error
    $.ajax({
        type : "get",
        url : "http://127.0.0.1:8082"+"/qcOfficer/insertQC",
        data : "officerType="+officerType+"&remark="+remark+"&officerName="+officerName+"&code="+code,
        dataType: "json",
        success : function(data) {
            $.messager.progress('close');  //进度条
            $('#insertQc').dialog('close');
            query2();
        },
        error:function(e){
            $.messager.alert('提示','网络异常，请联系管理员','info');
        }
    });
}

function delete2(){
    $.messager.confirm('确认', '确认删除该质检员?', function(r) {
        if (r) {
            var row = $('#query_list2').datagrid('getSelected');
            console.log(row.code);
            if (null != row && '' != row) {
                $.ajax({
                    type: "get",
                    data: "code=" + row.code,
                    url: "http://127.0.0.1:8082" + "/qcOfficer/deleteQc",
                    success: function (data) {
                        $.messager.progress('close');  //进度条
                        query2();
                    },
                    error: function (e) {
                        $.messager.alert('提示', '网络异常，请联系管理员', 'info');
                    }
                });
            } else {
                $.messager.alert('提示', '请选择要删除的数据', 'info')
                return;
            }
        }
    })
}


/*机器人聊天记录*/
function querySessionLog(){
    /*var likeNum =  $('#likeNum').checkbox('getValue');
     console.log(likeNum);*/
    $('#query_list_sessionLog').datagrid({
        method:"post",
        url: "http://127.0.0.1:8082"+"/sessionLog/selectSessionLogByBean",
        queryParams:{
            custName:$('#custName').textbox('getValue'),
            nickName:$('#nickName').textbox('getValue'),
            channelNo:$('#channelQuerySessionLog').textbox('getValue'),
            beginTime:($('#beginTimeSessionLog').textbox('getValue')!=null & $('#beginTimeSessionLog').textbox('getValue')  !='')?($('#beginTimeSessionLog').textbox('getValue')+ " 00:00:00"):(null),
            endTime:($('#endTimeSessionLog').textbox('getValue')!=null & $('#endTimeSessionLog').textbox('getValue')  !='')?($('#endTimeSessionLog').textbox('getValue')+ " 23:59:59"):(null),
            openId:$('#openId').textbox('getValue')
            //noAnswerNum:$('#noAnswerNum').checkbox('getValue')>0?1:0,
            //likeNum:$('#likeNum').checkbox('getValue')>0?1:0,
            //treadNum:$('#treadNum').checkbox('getValue')>0?1:0
        }
    });
}

function operation(value,row,index){
    console.log(11112222);
    return '<a style="color:blue" href="#">'+row+'</a>';
    //return '<a href="#" onclick="javascript:chatwin(\''+row.code+'\')">查看聊天记录</a>';
}


var sessionID;

function chatwin(){
    var row = $('#query_list_sessionLog').datagrid('getSelected');
    if(null != row && '' !=row){
        $('#win').window('open');
        sessionID=row.code;
        console.log("row.code: "+row.code);
        onRefresh(1, 10);
    }else{
        $.messager.alert('提示','请选择要查看的数据','info')
        return;
    }

}

function onRefresh(pageNumber, pageSize){
    var url='http://127.0.0.1:8082/sessionLog/getSessionLogs';
    $.ajax({
        url : url,
        type:'GET',
        data : {
            sessionID:sessionID,
            page:pageNumber,
            rows:pageSize
        },
        cache : false,
        dataType : 'json',
        /*根据context来判断客服发送信息，*/
        success : function(data) {
            $("#content").empty();
            $('#pp').pagination('refresh',{	// 改变选项并刷新分页栏信息
                total: data.total,
                pageNumber: pageNumber
            });
            $("#content").append("客户信息id："+data.code);

            /*$.each(data.rows,function(i,row){
             //客户发送
             console.log("客户发送："+row.custSent);
             var pat=JSON.parse(row.custSent);
             if(row.requestType==1){
             appendright("用户点击："+pat.content);
             }else{
             appendright(pat.content);
             }
             if(row.responseType==4){
             formatterPatternType(JSON.parse(row.answerContent));
             }else{
             if(row.satisfiedType != undefined && row.satisfiedType != null){
             formatterMenu(JSON.parse(row.answerContent),row.satisfiedType);
             }else{
             formatterMenu(JSON.parse(row.answerContent));
             }
             }

             });*/

        }
    });
}

function appendright(msg){
    var iurl = imgurl;
    if(!iurl){
        iurl = '/zzlc/assets/images/user.png';
    }
    var html =
        '<div class="message message-right">'+
        '<img class="avatar" alt="" src="'+iurl+'">'+
        '<div class="message-out">'+
        '<div class="message-content">'+
        msg +
        '</div>'+
        '</div>'+
        '</div>';
    appendhtml(html);
}

//格式化菜单
function formatterPatternType(data) {
    var menus=data.rows;
    var html ='';
    html = '你咨询以下:<div class="nav_question"><ol>'
    for (var i = 0; i < menus.length; i++) {
        var menu = menus[i];
        if (menu == null)
            continue;
        if(menu.content!=null&&menu.content!=undefined){
            html = html+'<li><a  href="#" onclick="javascript:getPattern(\''+
                (menu.parentCode==undefined ? menu.code:menu.parentCode)+'\',\''+data.map.orginContent+'\')" code="' + (menu.parentCode==undefined ? menu.code:menu.parentCode) + '">'+menu.content+'</a></li>';
        }
    }
    html =html+'</ol></div>相关问题？';
    if(html!='')appendleft(html);
}

function formatterMenu(data,satisfiedType){
    //判断 文字还是语音回答
    var menus=data.rows;
    var html ='';
    var returnType=getRequestParam("returnType");
    if(returnType!=null){// 存在则使用语音回答
        var audid=uuid(8, 60);
        if(menus.length==0){
            html = html+((data.map.config!=undefined&&data.map.config.presentence!=undefined)?data.map.config.presentence:'')+
                data.map.config.nomatch+
                ((data.map.config!=undefined&&data.map.config.sufsentence!=undefined)?data.map.config.sufsentence:'');
            if(html!='')appendleft(html);
        }else if(menus.length==1){
            if(data.returnCode==ReturnCode.nodata){}
            var menu=menus[0];
            if(menu.categoryCode=="B"){
                html = html+menu.answercontent;
            }else{
                if(menu.answercontent!=undefined){
                    html = html+'<li>'+menu.answercontent+'<br>'
                        +(data.map.config.sufsentence!=undefined?data.map.config.sufsentence:'');

                }else{
                    html = html+data.map.config.presentence+ '您是要了解:'+menu.content;
                }


            }
            if(html!='')appendleft(html);
        }else{
            html = '你咨询以下问题?'
            for (var i = 0; i < menus.length; i++) {
                var menu = menus[i];
                if (menu == null)
                    continue;
                if(menu.content!=null&&menu.content!=undefined){
                    html = html+ '<div class="nav_question" onclick="javascript:getNextMenu(\''+
                        (menu.parentCode==undefined ? menu.code:menu.parentCode)+'\',\''+menu.content+'\')" code="' + (menu.parentCode==undefined ? menu.code:menu.parentCode) + '">'+menu.content+'</div>';
                }
            }
            if(html!='')appendleft(html);
        }

    }else{
        if(menus.length==0){
            html = html+((data.map.config!=undefined&&data.map.config.presentence!=undefined)?data.map.config.presentence:'')+
                data.map.config.nomatch+
                ((data.map.config!=undefined&&data.map.config.sufsentence!=undefined)?data.map.config.sufsentence:'');

        }else if(menus.length==1){
            var menu=menus[0];
            if(menu.categoryCode=="B"){
                html = html+menu.answercontent;
            }else{
                if(menu.answercontent!=undefined){
                    html = html+menu.answercontent;
                    if(satisfiedType != undefined){
                        if(satisfiedType == "1"){
                            html = html+"<font color='#40B251'>有用</font>";
                        }else{
                            html = html+"<font color='#ff4500'>无用</font>";
                        }

                    }

                }else{
                    html = '您是要了解:'+menu.content;
                }


            }

        }else{
            html = '你咨询以下问题?'
            for (var i = 0; i < menus.length; i++) {
                var menu = menus[i];
                if (menu == null)
                    continue;
                if(menu.content!=null&&menu.content!=undefined){
                    html = html+ '<div class="nav_question" onclick="javascript:getNextMenu(\''+
                        (menu.parentCode==undefined ? menu.code:menu.parentCode)+'\',\''+menu.content+'\')" code="' + (menu.parentCode==undefined ? menu.code:menu.parentCode) + '">'+menu.content+'</div>';
                }
            }
        }
        if(html!='')appendleft(html);
    }
}

function appendhtml(html){
    $("#content").append(html);
}

function appendleft(msg){
    var html =
        '<div class="message message-left">'+
        '<img class="avatar" alt="" src="/sunriseui/common/js/insdep/plus/chat/images/zhujiang.png">'+
        '<div class="message-out">'+
        '<div class="triangle"></div>'+
        '<div class="message-content">'+
        msg+
        '</div>'+
        '</div>'+
        '</div>';
    appendhtml(html);
}










