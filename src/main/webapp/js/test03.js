//遍历数组：
function foreachArr() {
    $.each([1,2,3,4,5,'小胖'],function (i,item) {
        window.alert(i+' '+item)
    })
}

//遍历对象：
function foreachObj(){
    $.each({name:'Admin',age:'18',password:'123456'},function (i,item) {
        //window.alert(i+' '+item)                    //正序排列
        $.messager.alert('提示',i+' '+item,'info')    //倒叙排列
    })
}