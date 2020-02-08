/**
 * Created by songb on 2020/2/8.
 */

function getSearchUserInfoUrl() {
    return getHost(HostAddress.robot2)+'/navigation/userInfo/searchUserInfo'
}

function getDeleteUserInfoUrl() {
    return getHost(HostAddress.robot2)+'/navigation/userInfo/deleteUserInfo'
}


function getAddOrUpdateUserInfoUrl() {
    return getHost(HostAddress.robot2)+'/navigation/userInfo/addOrUpdateUserInfo'
}

var A = [];
var genderCodePath = 'root/BusinessPara/UOMP/gender';
$(function(){
    $.ajax({
        method:'get',
        url:getHost(HostAddress.robot2)+'/navigation/dictionary/getDictionaryValuesMap',
        data:{codePath:genderCodePath},
        success:function (data) {
            A=data.rows;
            A.push({'code':'',value:'请选择'});
            $('#userGender').combobox('loadData',A);
        }
    });
});

function searchUserInfo() {
    /*$.ajax({
        method:'POST',
        url:getSearchUserInfoUrl(),
        data:null,
        success:function (data) {
            $.messager.alert('提示','查询成功','info');
            $('#list_userInfoTable').datagrid('loadData',data.rows)
        },
        error:function (e) {
            $.messager.alert('提示','查询失败','error')
        }
    })*/

    $('#list_userInfoTable').datagrid({
        method:'post',
        url:getSearchUserInfoUrl(),
        queryParams:{}
        /*,
        onLoadSuccess:function (data) {
            alert('onLoadSuccess');
        },
        onLoadError:function (e) {
            alert('onLoadError');
        }*/
    })
}


function updateOrAddUserInfo(flag) {
    $('#open_form').form('reset');
    var row = $('#list_userInfoTable').datagrid('getSelected');
    if(flag){
        if (row) {
            $('#open_form').form('load', row);
            $('#openDialog').dialog('open').dialog('center')
        } else {
            $.messager.alert('提示', '请选择要修改的行', 'info')
        }
    }else{
        $('#openDialog').dialog('open').dialog('center')
    }

}

function saveUserInfo() {
    var userCode = $('#userCode').val();
    var userName = $('#userName').textbox('getValue');
    var userStatus = $('#userStatus').textbox('getValue');
    var userAge = $('#userAge').textbox('getValue');
    $.ajax({
        method:'POST',
        url:getAddOrUpdateUserInfoUrl(),
        data:{
            userCode:userCode,
            userName:userName,
            userStatus:userStatus,
            userAge:userAge
        },
        success:function (data) {
            $.messager.alert('提示', '编辑成功', 'info');
            $('#openDialog').dialog('close');
            searchUserInfo();
        },
        error:function (e) {
            $.messager.alert('提示', '编辑失败', 'error')
        }
    })
}

/*删除*/
function deleteUserInfo() {
    var row = $('#list_userInfoTable').datagrid('getSelected');
    if(row){
        $.ajax({
            method:'POST',
            url:getDeleteUserInfoUrl(),
            data:{
                userCode:row.userCode
            },
            success:function(data){
                $.messager.alert('提示',data.returnMessage,'info');
                searchUserInfo();
            },
            error:function(e){
                $.messager.alert('提示',e.returnMessage,'error')
            }
        })
    }else {
        $.messager.alert('提示','请选择要删除的行','info')
    }

}


function formatterGender(value) {
    var gender = value;
    if(gender=='女'){
        return '女';
    }else{
        return '男';
    }
}

function formatterStatus(value) {
    if(value=='0'){
        return '无效';
    }else{
        return '有效';
    }
}

function formatterOption(value,row) {
    var btn = '<a class="button-delete button-blue" onclick="ShowDetail(\''+row.userStatus+'\')"  href="javascript:void(0)">详细信息</a>';
    return btn;
}

function ShowDetail(userStatus) {
    $.messager.alert('提示',userStatus,'info');
}
