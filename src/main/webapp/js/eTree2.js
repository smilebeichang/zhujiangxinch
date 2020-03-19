var chanelArr = [];var node = [];
$(function () {
   $.ajax({
       method:'get',
       url:getHost(HostAddress.robot)+'/config/getConfig',
       data:{},
       success:function (data) {
           chanelArr = data;
           $('#chanel1').combobox('loadData',data);
           $('#chanel2').combobox('loadData',data);
       }
   });

    $.ajax({
        method:'get',
        url:getHost(HostAddress.robot)+'/eTree/getRobotNavigationTree',
        data:{},
        success:function (data) {
            node.push(data);
            console.log(node);
            $('#eTree').tree('loadData',node);
            //展开所有节点
            $('#eTree').tree('expandAll');
        },
        error:function (e) {
            $.messager.alert('提示','eTree查询失败')
        }
    })

});

//easyui-menu权限控制(show)+触发事件：onNodeClik(node)
function permissionMenu(e, node) {
    e.preventDefault();
    switch (node.parentCode){
        case null:{
            var item = $('#pm').menu('findItem','新增权限');
            $('#pm').menu('enableItem',item.target);
            var item = $('#pm').menu('findItem','修改权限');
            $('#pm').menu('disableItem',item.target);
            var item = $('#pm').menu('findItem','删除权限');
            $('#pm').menu('disableItem',item.target);

        }
        case '0':{
            var item = $('#pm').menu('findItem','新增权限');
            $('#pm').menu('enableItem',item.target);
            var item = $('#pm').menu('findItem','修改权限');
            $('#pm').menu('disableItem',item.target);
            var item = $('#pm').menu('findItem','删除权限');
            $('#pm').menu('disableItem',item.target);

        }
        default:{
            var item = $('#pm').menu('findItem','新增权限');
            $('#pm').menu('enableItem',item.target);
            var item = $('#pm').menu('findItem','修改权限');
            $('#pm').menu('enableItem',item.target);
            var item = $('#pm').menu('findItem','删除权限');
            $('#pm').menu('disableItem',item.target);

        }
    }
    onNodeClik(node);
    $('#pm').menu('show', {
        left: e.pageX,
        top: e.pageY
    });
}


function onNodeClik(node){
    $("#dg").form("reset");
    $("#dg").form("load", node);
    $('#answer').html(node.content);
    for(var i = 0; i<chanelArr.length;i++){
        if(chanelArr[i].chanel == node.channelNo){
            return chanelArr[i].name;
        }
    }
}
