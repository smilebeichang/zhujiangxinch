function queryQcItem() {
    $('#query_list_qcItem').datagrid({
        method:"post",
        url: getHost(HostAddress.robot)+'/qcItem/getQcItemPageByBean',
        queryParams:{
            itemType:$('#itemType').textbox('getValue'),
            status:$('#status').textbox('getValue'),
            itemContent:$('#itemContent').textbox('getValue')
        }
    });
}

function saveOrUpdateQcItem(flag) {
    $('#editForm').form('reset');
    if(flag){
        //修改
        var row = $('#query_list_qcItem').datagrid('getSelected');
        if(row){
            $('#editForm').form('load',row);
        }else{
            $.messager.alert('提示','请选择要修改的数据','info')
            return;
        }
    }
    //新增
    $('#openWin').dialog('open').dialog('center');
    if(flag=="2"){
        $('#itemSubmit').hide();
    }else{
        $('#itemSubmit').show();
    }
}

function saveQcItem(){

    var  code = $('#code').textbox('getValue');
    var  itemType = $('#itemType2').textbox('getValue');
    var  status = $('#status_edit').textbox('getValue');
    var  maxScore = $('#maxScore').textbox('getValue');
    var  passScore = $('#passScore').textbox('getValue');
    var  minScore = $('#minScore').textbox('getValue');
    var  scoreLevela = $('#scoreLevela').textbox('getValue');
    var  descLevela = $('#descLevela').textbox('getValue');

    var  scoreLevelb = $('#scoreLevelb').textbox('getValue');
     var  descLevelb = $('#descLevelb').textbox('getValue');
     var  scoreLevelc = $('#scoreLevelc').textbox('getValue');
     var  descLevelc = $('#descLevelc').textbox('getValue');
     var  scoreLeveld = $('#scoreLeveld').textbox('getValue');
     var  descLeveld = $('#descLeveld').textbox('getValue');
    var  itemContent = $('#itemContent_edit').textbox('getValue');

    var  remark = $('#remark').textbox('getValue');

    //ajax的url已经执行，但之后走error
    $.ajax({
        type : "post",
        url : getHost(HostAddress.robot)+'/qcItem/saveOrUpdateQcItem',
        data : {
            code:code,
            itemType:itemType,
            status:status,
            maxScore:maxScore,
            passScore:passScore,
            minScore:minScore,
            scoreLevela:scoreLevela,
            descLevela:descLevela,
            scoreLevelb:scoreLevelb,
            descLevelb:descLevelb,
            scoreLevelc:scoreLevelc,
            descLevelc:descLevelc,
            scoreLeveld:scoreLeveld,
            descLeveld:descLeveld,
            itemContent:itemContent,
            remark:remark
        },
        dataType: "json",
        success : function(data) {
            $.messager.progress('close');  //进度条
            $('#openWin').dialog('close');
            queryQcItem();
        },
        error:function(e){
            $.messager.alert('提示','网络异常，请联系管理员','info');
        }
    });
}

function deleteQcItem() {
    var row = $('#query_list_qcItem').datagrid('getSelected');
    if(row){
        $.ajax({
            type : "post",
            url : getHost(HostAddress.robot)+'/qcItem/deleteQcItem',
            data : {
                code:row.code
            },
            dataType: "json",
            success : function(data) {
                $.messager.progress('close');  //进度条
                queryQcItem();
            },
            error:function(e){
                $.messager.alert('提示','网络异常，请联系管理员','info');
            }
        });
    }else{
        $.messager.alert('提示','请选择要失效的数据','info')
        return;
    }
}

function ajax() {
    $.ajax({
        type:"post",
        url:getHost(HostAddress.robot)+"/qcItem/getQcItemPageByBean",
        data:{
            itemContent:'哈哈'
        },
        dataType:"json",
        success:function (data) {
            console.log(data);
        },
        error:function (e) {
            $.message.alert('提示','执行失败','info')
        }

    })
}

function timestamp() {
    var timestamp1 = Date.parse( new Date());
    var timestamp2 = new Date().getTime();
    $.messager.alert('时间戳','当前秒数：'+timestamp1+'  当前毫秒数:'+timestamp2,'info')

}