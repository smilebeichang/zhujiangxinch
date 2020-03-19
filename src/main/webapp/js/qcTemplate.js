
/**
 * 单表CRUD
 * */
function queryQcTemplate() {
    var TEMPL_NAME = $('#TEMPL_NAME').textbox('getValue');
    var STATUS =  $('#STATUS').textbox('getValue');
    var TEMPL_TYPE =  $('#TEMPL_TYPE').combobox('getValue');
    $('#query_list_qcTemplate').datagrid({
        method:'post',
        url:'http://127.0.0.1:8083/qcTemplate/queryQcTemplate',    //requestMapper('')
        queryParams:{
            TEMPL_NAME:TEMPL_NAME,
            STATUS:STATUS,
            TEMPL_TYPE:TEMPL_TYPE
        },
        onLoadSuccess : function(data) {
            $('#query_list_qcTemplate').datagrid('appendRow', {
                templ_TYPE : '合计',
                remark : 'totalPercent',
                templ_NAME : 'totalMaxScore',
                status : 'totalPassScore'
            });
        }
    })
}

function saveORUpdateQcTemplate(flag) {
    $('#edit_form').form('reset');
    if(flag){
        var row = $("#query_list_qcTemplate").datagrid('getSelected');
        if(row){
            $('#edit_form').form('load',row);
        }else{
            $.messager.alert('提示','请选择要修改的行');
        }
    }
    $('#openWin').dialog('open').dialog('center');
}

function addOrUpdate() {

    var CODE = $('#CODE').textbox('getValue');
    var TEMPL_TYPE2 = $('#TEMPL_TYPE2').textbox('getValue');
    var STATUS2 = $('#STATUS2').textbox('getValue');
    var TEMPL_NAME2 = $('#TEMPL_NAME2').textbox('getValue');
    $.ajax({
        method:'post',
        url:'http://127.0.0.1:8083/qcTemplate/addOrUpdate',
        data:{
            CODE:CODE,
            TEMPL_TYPE:TEMPL_TYPE2,
            STATUS:STATUS2,
            TEMPL_NAME:TEMPL_NAME2
        },
        success:function (data) {
            $.messager.alert('提示','addOrUpdate成功')
        },
        error:function (e) {
            $.messager.alert('提示','addOrUpdate失败')
        }
    })

}

function deleteQcTemplate() {
    var row = $("#query_list_qcTemplate").datagrid('getSelected');
    if(row){
        $.ajax({
            method:'post',
            url:'http://127.0.0.1:8083/qcTemplate/deleteQcTemplate',
            data:{
                CODE:row.code
            },
            success:function (data) {
                $.messager.alert('提示','delete成功')
            },
            error:function (e) {
                $.messager.alert('提示','delete失败')
            }
        })
    }
}

function clean() {
    $('#query_list_qcTemplate').datagrid('loadData',{total:0,rows:[]});
}

/**
 * 第二张表CRUD
 * */
function linkQuery(index, row) {
    queryQcTaskList(row)
}

function queryQcTaskList(row) {
    $('#unchooseitemlist').datagrid('loadData',{total:0,rows:[]});
    $.ajax({
        method:'post',                              //判断关联任务，uomp_qc_task  template_code = #{templateCode}
        url:'http://127.0.0.1:8083/qcTemplate/qcTask/getQcTaskListByBean',    //这么长的url是因为tomcat自带一个
        data:{
            templateCode:row.code
        },
        success:function (data) {
            $.messager.alert('提示','此模板有关联任务','info')
            queryCheckItems();// 查询已关联指标  /qcItem/queryCheckQcTemplateItems
            queryUnCheckQcItem();// 查询未关联指标  /qcItem/getUnCheckQcItemPageByBean
        },
        error:function (e) {
            $.messager.alert('提示','选择行查询失败','info')
        }
    })

}

function queryUnCheckQcItem() {
    $('#unchooseitemlist').datagrid('loadData',{total:0,rows:[]});
    var row = $('#query_list_qcTemplate').datagrid('getSelected');

    $('#unchooseitemlist').datagrid({
        method:"post",
        url: 'http://127.0.0.1:8082/qcItem/getUnCheckQcItemPageByBean',
        queryParams:{
            templCode:row.code
        }
    });
    
}

function queryCheckItems(){
    $('#itemlist').datagrid('loadData',{total:0,rows:[]});
    var row = $('#query_list_qcTemplate').datagrid('getSelected');
    $('#itemlist').datagrid({
        method:'get',
        url:'http://127.0.0.1:8083/qcTemplate/qcTemplate/QcTemplateItem/queryCheckItems',
        queryParams:{
            templCode:row.code
        }
    })
}

/**
 * 关联表的查询+删除
 * */
function deleteQcTemplateItem() {
    var row = $("#itemlist").datagrid('getSelected');
    if(row){
        $.ajax({
            method:'post',
            url:'http://127.0.0.1:8083/qcTemplate/qcTemplate/QcTemplateItem/deleteQcTemplateItem',
            data:{
                templCode:row.templCode
            },
            success:function (data) {
                $.messager.alert('提示','delete成功')
            },
            error:function (e) {
                $.messager.alert('提示','delete失败')
            }
        })
    }
}