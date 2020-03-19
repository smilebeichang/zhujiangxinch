function querySynonym() {
    $('#query_list_synonym').datagrid({
        method:"post",
        url: getHost(HostAddress.robot)+"/synonym/getRbSynonymConfigs",
        queryParams:{
            words: $('#searchworks').textbox('getValue')
        }
    });
}

var editFlag = 1;
function saveOrupdateSynonym(flag) {
    editFlag = flag;
    $('#Synonymff').form('reset');
    //window.alert("reset")
    if(editFlag==0){
        var row = $('#query_list_synonym').datagrid('getSelected');
        if(null != row && '' != row){
            $('#Synonymdlg').form('load',row);
            $('#code').val(row.code);
            console.log(row.code);
        }else{
            $.messager.alert('提示','请选择要修改的数据','info');
            return
        }
    }
    $('#Synonymdlg').dialog('open').dialog('center');
}


function addSynonym() {
    $.ajax({
        data:{
            code:$('#codeSy').textbox('getValue'),
            words:$('#words').textbox('getValue'),
            method:$('#method').textbox('getValue')
        },
        type : "get",
        url : "http://127.0.0.1:8080"+"/synonym/saveOrUpdateRbSynonymConfig",
        //dataType: "json",
        success : function(data) {
            $.messager.progress('close');  //进度条
            $('#Synonymdlg').dialog('close');
            querySynonym();
        },
        error:function(e){
            $.messager.alert('提示','网络异常，请联系管理员','info');
        }
    });
}

function deleteSynonym() {
    var row = $('#query_list_synonym').datagrid('getSelected');
    if(null != row && '' != row){
        $.messager.confirm('确认', '确认删除该数据?', function(r) {
            if(r){
                $.ajax({
                    type: "post",
                    data: "code=" + row.code,
                    url: "http://127.0.0.1:8080" + "/synonym/deleteSynonym",
                    success: function (data) {
                        $.messager.progress('close');  //进度条
                        querySynonym();
                    },
                    error: function (e) {
                        $.messager.alert('提示', '网络异常，请联系管理员', 'info');
                    }
                });
            }
        });
    }else{
        $.messager.alert('提示','请选择要删除的数据','info');
        return
    }




}