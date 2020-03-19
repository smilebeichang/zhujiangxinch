function getTreeUrl() {
    return getHost(HostAddress.robot) + '/robotNavigation/getRobotNavigationTree';
}

//获取config
let chanelComboboxList = [];
$(function () {
    $.ajax({
        method:'POST',
        url:getHost(HostAddress.robot)+'/config/getConfig',
        data:{},
        success:function (data) {
            chanelComboboxList = data;
            $('#channelNo').combobox('loadData',data);
            $('#chanelS').combobox('loadData',data);
        },
        error:function (e) {
            $.messager.alert('eTree提示','查找config失败')
        }
    })
});

//获取导航树
$(function () {
    getAllNavigation();
});


function getAllNavigation(){
    let navigationTree = [];
    $.ajax({
        type : 'get',
        url : getTreeUrl(),
        data : {},
        cache : false,
        dataType : 'json',
        success : function(data) {
            console.log("+++对象data+++++");
            console.log(data);
            navigationTree.push(data);
            console.log("++++数组navigationTree+++++");
            console.log(navigationTree);
            //加载数据，并展开所有节点
            $('#eTree').tree('loadData',navigationTree).tree('expandAll');
        }
    });
}


/**
 * 树节点右键菜单
 * @param e
 * @param node
 */
function treeContextMenu(e, node) {
    //意思是加上他  这个事件不会被污染  ul标签里面的方法不会执行  只执行标签绑定的事件，阻止默认行为
    e.preventDefault();
    let addItem = $('#mm').menu('findItem', '新增导航');
    let updateItem = $('#mm').menu('findItem', '修改导航');
    let deleteItem = $('#mm').menu('findItem', '删除导航');
    switch(node.parentCode){
        case null:{
            //一级菜单
            $('#mm').menu('enableItem', addItem.target);
            $('#mm').menu('enableItem', updateItem.target);
            $('#mm').menu('enableItem', deleteItem.target);
            break;
        }
        case '0':{
            //二级菜单
            $('#mm').menu('enableItem', addItem.target);
            $('#mm').menu('disableItem', updateItem.target);
            $('#mm').menu('disableItem', deleteItem.target);
            break;
        }
        default:{
            $('#mm').menu('disableItem', addItem.target);
            $('#mm').menu('disableItem', updateItem.target);
            $('#mm').menu('disableItem', deleteItem.target);
            break;
        }
    }
    //这一步是联动操作
    onNodeClik(node);
    // 显示快捷菜单
    $('#mm').menu('show', {
        left : e.pageX,
        top : e.pageY
    });
}


/**
 * 节点点击事件
 * @param node
 */
function onNodeClik(node) {
    $("#answer").html('');
    $("#answer").html(node.answer);      //则一步可以运行
    $("#dg").form("reset");
    $("#dg").form("load", node);
}