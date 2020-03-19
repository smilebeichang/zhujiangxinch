function searchTemplate() {
    var type_template = $('#type_template').combobox('getValue');
    var status_template = $('#status_template').combobox('getValue');
    var name_template = $('#name_template').textbox('getValue');
    $('#list_template').datagrid({
        method:'post',
        url:getHost(HostAddress.kbms)+'/qcTemplate/template/searchTemplate',
        queryParams:{
            templateType:type_template,
            status:status_template,
            item_content:name_template
        }
    })
}

function deleteTemplate() {
    var row = $('#list_template').datagrid('getSelected');
    if(row!=null && ''!=row){
        $.ajax({
            type: "POST",
            url:getHost(HostAddress.kbms)+'/qcTemplate/template/deleteTemplate',
            data:{
                code:row.code
            },
            success:function(data){
                if(data==0){
                    $.messager.alert('提示','删除失败，index==0','info')
                }
                $.messager.alert('提示','删除成功','info')
                searchTemplate();
            },
            error:function (e) {
                $.messager.alert('提示','删除失败，请联系管理员','info')
            }
        })
    }else{
        $.messager.alert('提示','请选择删除行','info')
    }

}

function saveOrUpdateTemplate(flag) {
    //表格信息清空
    $('#form').form('reset');
    if(flag){
        //修改  信息回填
        var row = $('#list_template').datagrid('getSelected');
        if(row!=null &&''!=row){
            $('#form').form('load',row)
            $('#openWin').dialog('open');
        }else{
            $.messager.alert('提示','请选中要修改的行','info');
        }
    }else {
        //新增  openWin.daialog
        $('#openWin').dialog('open');
    }

}

function saveTemplate() {
    var code = $('#id1').textbox('getValue');
    var templateName = $('#templateName1').textbox('getValue');
    $.ajax({
        method:'post',
        url:getHost(HostAddress.kbms)+'/qcTemplate/template/saveTemplate',
        data:{
            code:code,
            templateName:templateName
        }
    })
}

/**
 * 多表操作
 * 这个row真的能传过去吗,那为什么下面的row的重新个体Selected一遍
 * */
function link(index, row) {
    searchTemplateItem(row);
    searchItem(row);
}
//支持模糊查询
function searchTemplateItem(row){
    var row = $('#list_template').datagrid('getSelected');
    var type_templateItem = $('#type_templateItem').combobox('getValue');
    $('#list_template_item').datagrid({
        method:'get',
        url:getHost(HostAddress.kbms)+'/qcTemplate/templateItem/searchTemplateItem',
        queryParams:{
            itemType:type_templateItem,
            templCode:row.code
        }
    })
}

function searchItem(row) {
    //var row = $('#list_template').datagrid('getSelected');
    var type_templateItem = $('#type_templateItem').combobox('getValue');
    $('#list_item').datagrid({
        method:'get',
        url:getHost(HostAddress.kbms)+'/qcTemplate/item/searchItem',
        queryParams:{
            itemType:type_templateItem,
            code:row.code
        }
    })
}

function deleteTemplateItem(){
    var row = $('#list_template_item').datagrid('getSelected');
    if(row!=null && ''!=row){
        $.ajax({
            method:'post',
            url:getHost(HostAddress.kbms)+'/qcTemplate/templateItem/deleteTemplateItem',
            data:{
                templCode:row.templCode,
                itemCode:row.itemCode
            },
            success:function (data) {
                $.messager.alert('info','删除已关联指标成功');
                searchTemplateItem();
                searchItem();
            },
            error:function(e){
                $.messager.alert('info','删除已关联指标失败');
            }
        })
    }else{
        $.messager.alert('info','请选中要删除的关联指标');
    }

}