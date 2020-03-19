function saveOrUpdateCustomDictionary(flag) {
    $('#configff').form('reset');
    if(flag){
        //修改
        var row = $('#query_list_CustomDictionary').datagrid('getSelected');
        if(row){
            $('#configff').form('load',row);
        }else{
            $.messager.alert('提示','请选择要修改的数据','info')
            return;
        }
    }
    //新增
    $('#configdlg').dialog('open').dialog('center');
}

function formatteroldname(value,row,index) {
    if(row.status!="2"){
        return '<a id="btn" href="#" onclick=" updteIndex(\''+row.code+'\')">更新索引</a> ';
    }else{
        return "无操作";
    }
}

function updteIndex(code) {
    $.messager.alert('警告','当前code:'+code,'info')
}

function addConfig() {
    $.ajax({
        type:'post',
        url:getHost(HostAddress.robot)+"/customDictionary/addConfig",
        data:{
            code:$('#code_CustomDictionary').textbox('getValue'),
            name:$('#name').textbox('getValue'),
            nature:$('#nature').textbox('getValue'),
            patternconf:$('#patternconf').textbox('getValue')
        },
        dataType:'json',
        success:function (data) {
            //console.log(data)
            window.alert('ajax执行成功')
            $.ajax({
                type: 'get',
                url:getHost(HostAddress.robot)+'/customDictionary/getCustomDictionarys',
                success: function (data) {
                    $.messager.progress('close');  //进度条
                    //$.messager.alert('提示', '修改成功，刷新数据成功', 'info');
                    //window.location.href=getHost(HostAddress.robot)+":63342/ssm/src/main/webapp/qcItem.html"
                    //refresh();
                },
                error: function (e) {
                    $.messager.alert('提示', '刷新数据失败', 'info');
                }
            });
            $('#configdlg').dialog('close');

        },
        error:function (e) {
            window.alert('ajax执行失败')
        }
    })
    window.location.href="../html/qcItem.html";
}


function deleteCustomDictionary() {
    var row = $('#query_list_CustomDictionary').datagrid('getSelected');
    if(row){
        $.ajax({
            type: "post",
            data: "code=" + row.code,
            url: "http://127.0.0.1:8080" + "/customDictionary/deleteCustomDictionary",
            success: function (data) {
                $.messager.progress('close');  //进度条
                $.ajax({
                    type: 'get',
                    url:getHost(HostAddress.robot)+'/customDictionary/getCustomDictionarys',
                    success: function (data) {
                        $.messager.progress('close');  //进度条
                        $.messager.alert('提示', '删除成功，刷新数据成功', 'info');
                        refresh();
                    },
                    error: function (e) {
                        $.messager.alert('提示', '删除成功，刷新数据失败', 'info');
                    }
                });
                $('#configdlg').dialog('close');
            },
            error: function (e) {
                $.messager.alert('提示', '删除异常，请联系管理员', 'info');
            }
        });
    }else{
        $.messager.alert('提示','请选择要删除的行','info')
    }
}
/*刷新页面*/
function refresh(){
    window.location.reload();
    setTimeout(refresh , 1000);
}
function reload() {
    window.location.href = window.location.href;
}

function formatterCreate(value,row,index) {
    if(row.name=="测试"){
        return '<a id="btnCreate" href="#" onclick="CreateAccountCode(\''+row.name+'\')">超级管理员111</a> ';
    }else{
        return "其他";
    }
}



function CreateAccountCode(createAccountCode) {
    window.alert(createAccountCode);
}


function formatterTest(value,row,index) {
    if(row.name=="死亡表"){
        return '<a id="test" href="#" onclick="test(\''+row.name+'\')">测试</a>';
    }else{
        return "hahahah";
    }
}

function test(name) {
    window.alert(name);
}

function formatterTest2(value,row,index) {
    if(row.name=="死亡表"){
        return '<a id="test" href="#" onclick="test('+row.name+')">测试</a>';
    }else{
        return "转义";
    }
}

function test2(name) {
    window.alert(name);
}

