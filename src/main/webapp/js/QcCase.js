function queryQaCase() {
    $('#query_list_QcCase').datagrid({
        method:'get',
        url:getHost(HostAddress.robot)+'/QcCase/getQcCaseByBean',
        queryParams:{
            reason:$('#reason').textbox('getValue'),
            caseType:$('#caseType').combobox('getValue')
        }
    })
}

function deleteQaCase() {
    var row = $('#query_list_QcCase').datagrid('getSelected');
    if(row != null && row!=''){
        $.ajax({
            method:'post',
            url:getHost(HostAddress.robot)+'/QcCase/deleteQcCaseByBean',
            data:row,
            success:function () {
                $.messager.alert('提示','删除成功','info');
                queryQaCase()
            },
            error:function () {
                $.messager.alert('提示','删除成功','info');
                queryQaCase()
            }
        })
    }else{
        $.messager.alert('提示','请选择要删除的信息','info')
    }
}

function saveOrUpdateQaCase(flag) {
    $('#editFormQcCase').form('reset');
    if(flag){
        var row = $('#query_list_QcCase').datagrid('getSelected');
        if(row != null && row!=''){
            $('#editFormQcCase').form('load',row)
        }else{
            $.messager.alert('提示','请选择要修改的信息','info')
        }
    }
    $('#openWinQcCase').dialog('open').dialog('center');

}

function saveQcCase() {
    var caseType = $('#caseType2').combobox('getValue');
    var uniqueSerialNo = $('#codeQcCase').textbox('getValue');
    var custName = $('#custName').textbox('getValue');
    var createName = $('#createName').textbox('getValue');
    $.ajax({
        method:'post',
        url:getHost(HostAddress.robot)+'/QcCase/saveOrUpdateQcCaseByBean',
        data:{
            caseType:caseType,
            uniqueSerialNo:uniqueSerialNo,
            custName:custName,
            recorderName:createName
        },
        success:function (data) {
            $.messager.alert('提示','成功','info');
            $('#openWinQcCase').dialog('close')
            queryQaCase()
        },
        error:function (e) {
            $.messager.alert('提示','失败','info');
        }
    })

}