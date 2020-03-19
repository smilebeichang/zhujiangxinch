
function saveOrUpdateCustomDictionary2(flag) {

    let row = $('#query_list_customDictionary').datagrid('getSelected')
    //清空
    $('#editForm').form('reset');
    if(flag){
        if(row!=null && row!=''){
            //回填
            $('#editForm').form('load',row);
            $('#openWin').dialog('open').dialog('center')
        }else{
            $.messager.alert('提示','请选择行','info')
        }
    }
    if(flag==0){
        $('#openWin').dialog('open').dialog('center')
    }
}

function formatteroldname(value,row,index) {
    if(row.status!='2'){
        return '<a href="#" onclick="updateIndex(\''+row.code+'\')">更新索引</a>'
    }else{
        return "无操作"
    }

}
let q = HostAddress.report
/*
    属性批量新增   遍历$.each(confs,function(i,n){}
    postFormCallback  提交表单，追加post数据
*/

function saveCustomDictionary2() {

    var code=$('#code').val();
    var url=getHost(HostAddress.robot)+'/customDictionary2/saveCustomDictionary2';
    var object=new Object();
    var confs=$('#patternConfig').combogrid('getValues');
    var patternconf='';
    $.each(confs,function(i,n){
        if(n!='') patternconf=patternconf+n+',';
    });
    object.patternconf=patternconf;
    postFormCallback(url, this, successfully, error,object, 'editForm', false);
}

function successfully(data){
    $.messager.alert('提示',data.returnMessage);
    $('#openWin').dialog('close');
}

function error(data){
    $.messager.alert('提示',data.returnMessage);
}