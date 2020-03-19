/**
 * 系统定义的对象
 * 
 */
//客户信息对象
function Customer(data){
	var customer= cloneObject(data);//克隆数据
	customer.name=data.custName;
	customer.acctNo=data.acctNo;	//账号 Cd302
	customer.comlinkMan=data.linkMan;//对公联系人
	customer.linkMan=data.conName1+','+data.conName2;//联系人1+联系人2 Cd302
	//customer.workAddrName=data.workAddrName+','+data.companyName;	//单位地址Cd303*+名称Cd302
	customer.companyName=data.companyName;
	//自扣还款账号Cd301*
	customer.autoRpy=data.autoRpy;
	//自扣还款方式Cd301*customer.autoType
	//customer.isUsePwd=data.isUsePwd;//是否使用消费密码 Cd304*
	customer.phone=data.phone;
	customer.custNo=data.custNo;
	customer.custName=data.custName;
	customer.custIdCardNo=data.idCard;
	customer.custIdCardType=data.idCardType;
	customer.sex=data.sex;
	customer.birthday=toDate(data.birthday);
	customer.workTel=data.workTel;
	customer.workAddr=data.add;
	customer.homeTel=data.homeTel;
	customer.homeAddr=data.homeAddr;
	customer.email=data.email;
	customer.custLeavel=data.custLeavel==undefined?0:data.custLeavel;
	customer.custAccInfo=data.custAccInfo;
	customer.operations=new List();
	return customer;
}

function custAccInfo(data){
	var custAccInfo= cloneObject(data);//克隆数据
	custAccInfo.acctNo=data.acctNo;
	custAccInfo.cardNo=data.acctNo;
	custAccInfo.cardStatus=data.status;
	custAccInfo.validateLevel=data.validateLevel==undefined?0:data.validateLevel;
	custAccInfo.cardType=data.acctType;
	custAccInfo.openDate=data.enddate;
	custAccInfo.openBranchNo=data.clearCode;
	custAccInfo.openBranchName=data.instName;
	custAccInfo.validPeriodDate=data.cardNo;
	custAccInfo.billDate=data.billDate;
	custAccInfo.creditLimit=data.creditLimit;
	custAccInfo.autoRepayCard=data.autoRepayCard;
	custAccInfo.tempData=new Map();
	custAccInfo.detail=null;
	return custAccInfo;
}
function cardInfo(data){
	var cardInfo= cloneObject(data);//克隆数据
	cardInfo.acctNo=data.acctNo;
	cardInfo.custName=data.custName;
	cardInfo.onCardName=data.onCardName;
	cardInfo.fstActDt=data.fstActDt;
	cardInfo.cardType=data.cardType;
	return cardInfo;
}
/**
 * 用户上下文信息
 */
function CustomerContent() {
	this.customer = null;// 客户信息
	this.card = new Map();// card信息
	this.account = null;// 当前卡账户
	this.setCustomer = function(customer) {
		this.customer = customer;
	};
	this.setCard = function(card) {
		this.card = card;
	};
	this.getCustAccInfo = function(cardNo) {
		this.card.get(cardNo);
	};
	this.setCustAccInfo = function(cardNo, data) {
		this.card.put(cardNo, data);
	};
	//切换卡片
	this.switCard = function(cardNo, data) {
		if(this.account!=null){
			if(this.account.cardNo==cardNo) return ;
		}
		if (this.card.containsKey(cardNo)) {
			this.card.put(this.account.cardNo, this.account);
			this.account = this.card.get(cardNo);
		} else {
			if (this.account != null) {
				this.card.remove(this.account.cardNo);// 移除
				this.card.put(this.account.cardNo, this.account);
			}
			this.account = custAccInfo(data);
		}
	};
	//获取当前账户信息
	this.getCurrentAccount = function() {
		return this.account;
	};
	//获取当前客户信息
	this.getCustomer = function() {
		return this.customer;
	};
	//获取当前卡片信息
}

/**
 * 获取坐席对象
 * @returns
 */
function getUser(){
	var token=$sunrise.getStore("sessionID",'tophome');
	if(token!=null&&token!=undefined){
		var cache=$sunrise.getStore(token,'tophome');
		if(cache!=null&&cache!=undefined){
			var emp=cache.accountCache.emp;//可能要修改为返回emp
			return emp;
		}else{
			$.messager.alert("提示","缓存为空！","info");
			return null;
		}
	}else{
		return null;
	}
}
function getBpeValidateLevelListUrl(){
	return getHost('UOMP') + '/uomp/bpe/getBpeValidateLevelList';
}
function getBpeValidateLevelInfoUrl(){
	return getHost('UOMP') + '/uomp/bpe/getBpeValidateLevelInfo';
}
/**
 * 获取验证等级列表
 * @returns
 */
function getBpeValidateLevelList(){
	var returnValue;
	$.ajax({
		type : "GET",
		url : getBpeValidateLevelListUrl(),
		cache : false,
		async : false,
		success : function(data) {
			if(data.returnCode == ReturnCode.success){
				returnValue=data.rows;
			}
		}
	});
	return returnValue;
}
/**
 * 根据验证等级编码获取对象
 * @param level
 * @returns
 */
function getBpeValidateLevelInfo(level){
	var returnValue;
	$.ajax({
		type : "GET",
		url : getBpeValidateLevelInfoUrl(),
		data : {
			level:level
		},
		cache : false,
		async : false,
		success : function(data) {
			if(data.returnCode == ReturnCode.success){
				returnValue=data.bean;
			}
		}
	});
	return returnValue;
}

/**
 * 获取坐席对象empCode
 * @returns
 */
function getEmpCode(){
	var token=$sunrise.getStore("sessionID",'tophome');
	if(token!=null&&token!=undefined){
		var cache=$sunrise.getStore(token,'tophome');
		if(cache!=null&&cache!=undefined){
			var emp=cache.accountCache.emp;//可能要修改为返回emp
			return emp.code;
		}else{
			$.messager.alert("提示","缓存为空！","info");
			return null;
		}
	}else{
		return null;
	}
}
/**
 *<li> ajax 请求公共请求信息
 *<li>当前设置值
 *<li>token： 会话token
 *<li>serviceid： 服务流水id
 *<li>sumNo： 总结编号
 *<li>connectId： connectId
 * @returns 
 */
function getComPostData(bussType){
	bussType=(bussType==null)?getcsrBussType():bussType;
	var postData=new Object();
	postData.token=$sunrise.getStore("token","tophome");
	var menu= $sunrise.callmethod('csrhome','getselectMenu');
	if(menu!=null){
		var servicelog=$sunrise.getStore(menu.permissionCode,'tophome');
		if(servicelog!=null)postData.serviceid=servicelog.id;
		postData.menuCode = menu.id;
		postData.menuName = menu.text;
		postData.permCode = menu.permissionCode;
	}
	var connectId=getconnectionId();
	if(connectId!=''||connectId!=undefined){
		 postData.connectId=connectId;
	}else{
		var worksum=$sunrise.getStore('worksum','tophome');
		if(worksum!=null){
			postData.sumNo=worksum.sumNo;
			postData.connectId=worksum.connectId;
		}
	}
	var account=getAccount();
	postData.callNo=getCallNo();
	postData.accountCode=account!=null?account.accountCode:"";
	postData.agentId=account!=null?account.agentId:"";
	postData.chanel='C';
	var currentCustomer=getCurrentCustomer(bussType);
	if(currentCustomer!=null){
		var customer=currentCustomer.customer;
		if(customer!=null){
			var currentAccount=customer.getCurrentAccount;
			postData.custIdCardNo=customer.custIdCardNo;
			postData.custIdCardType=customer.custIdCardType;
			postData.acctNo=currentAccount!=null?currentAccount.acctNo:"";
			postData.currCode=currentAccount!=null?currentAccount.currCode:"";
			postData.custName=customer.custName;
			postData.businessType=bussType;
			//TODO
			var account = currentCustomer.account;
			if(account!=null&&account!=''){
				var custType;
				if(bussType=='debit'){	//借记卡取客户类型
					custType = getCustType(account.accTypeNo);
					postData.custType = custType;
				}else if(bussType=='credit'){
					var detail = account.detail;
					if(detail!=null&&detail!=''){
						switch(detail.custLevel){
						case "0":{
							custType = "10";
							break;
						}
						case "20":{
							custType = "11";
							break;
						}
						case "30":{
							custType = "12";
							break;
						}
						case "40":{
							custType = "13";
							break;
						}
						case "50":{
							custType = "14";
							break;
						}
						default:{
							custType = detail.custLevel;
							break;
						}
						}				
					}
					postData.custType = custType;
				}
			}
		}
	}
	return postData;
}

/**
 * 脱离帐卡列表获取日志信息
 * @returns
 */

function getDebitLogInfo(){
	var postData = new Object();
		postData.chanel = "C";
		postData.callNo=getCallNo();
	var connectId=getconnectionId();
	if(connectId!=''||connectId!=undefined){
		 postData.connectId=connectId;
	}else{
		var worksum=$sunrise.getStore('worksum','tophome');
		if(worksum!=null){
			postData.sumNo=worksum.sumNo;
			postData.connectId=worksum.connectId;
		}
	}	
	return postData;
}
/**
 * 翻译客户类型
 * @param acctTypeNo
 * @returns {String}
 */
function getCustType(acctTypeNo){
	var t;
	if(undefined == typeof acctTypeNo){
		t="";
	}else if(acctTypeNo==""){
		t = "00";
	}else if(acctTypeNo.startsWith('YB')){
		t = "00";
		if ("YBJGC99002"==acctTypeNo) {//YBJGC99002-紫金卡
			t = "02";
		} else if ("YBJGC99003"==acctTypeNo) {//YBJGC99003-黄金卡
			t = "03";
		} else if ("YBJGC99011"==acctTypeNo) {//YBJGC99011-纪念卡
			t = "01";
		} else if ("YBJGC99004"==acctTypeNo) {//YBJGC99004-白金卡
			t = "04";
		}			
	}else if(acctTypeNo.endsWith("0")){//信用卡部分
		t = "10";
		if ("20"==acctTypeNo) {
			t = "11";
		} else if ("30"==acctTypeNo) {
			t = "12";
		} else if ("40"==acctTypeNo) {
			t = "13";
		} else if ("50"==acctTypeNo) {
			t = "14";
		} 
	}	
	return t;
}

/**
 * 内管UOMP请求数据
 * @returns {___anonymous4763_4770}
 */
function getUOMPPostData(){
	var postData=new Object();
	postData.token=$sunrise.getStore("token","tophome");
	return postData;
}
function getcsrBussType(){
	return $sunrise.callmethod('csrhome','getCurrBussType');//call客户360
}
//获取登录账户信息
function getAccount(){
    var token=$sunrise.getStore("sessionID",'tophome');
    if(token!=null&&token!=undefined){
        var cache=$sunrise.getStore(token,'tophome');
        if(cache!=null&&cache!=undefined){
            return cache.accountCache;//返回账号对象
        }else{
            return null;
        }
    }else{
        return null;
    }
}
/**
 * 从软电话中获取到connectionId
 */
function getconnectionId(){
	var callData= $sunrise.getStore("callData",'tophome');
	return callData==null?'':callData.CallID;
	//return "connectionId0001";
}

function getCurrentCustomer(bussType){
	return  $sunrise.getStore(bussType,'tophome');
}

/**
 * 获取权限关系对象
 * @returns
 */
function getPermissionrelations(){
	var token=$sunrise.getStore("sessionID",'tophome');
	if(token!=null&&token!=undefined){
		var cache=$sunrise.getStore(token,'tophome');
		if(cache!=null&&cache!=undefined){
			var permissionrelations=cache.store.permissionrelations;
			return eval("("+permissionrelations+")");
		}else{
			//alert("权限关系对象缓存为空！");
			return null;
		}
	}else{
		return null;
	}
}
/**
 * 获取用户当前角色的权限列表中，类型为 permissiontype 的权限列表,传 null 返回所有的权限
 * @param permissiontype
 * @returns {Array}
 */
function getPermission(permissiontype){
	var lis=[];
	var permissions=getAccount();
	if(permissions!=null){
		permissions=permissions.permissions;
	}else{
		console.log("无法获取角色信息");
		//alert("无法获取角色信息");
	}
	
	if(permissiontype==null){
		return permissions;
	}else{
	for (var i = 0; i < permissions.length; i++) {
		if (permissions[i].type == permissiontype) {
			lis.push(permissions[i]);
		} else {
			continue;
		}
	}
	return lis;
	}
}
/**
 * 获取某类型的菜单
 * @param menuType null 返回菜单集合
 * @returns
 */
function getMenus(menuType){
	var lis=[];
	var account=getAccount();
	if(account==null){
		console.log("无法获取账号信息！");
	}else if(menuType==null){
		return account.menu.menus;
	}else{
		for (var i = 0; i < account.menu.menus.length; i++) {
			var menu=account.menu.menus[i];
			if (menu.type == menuType) {
				lis.push(menu);
			} else {
				continue;
			}
		}
		return lis;
	}
}
/**
 * 获取某个菜单点（不包括子菜单）
 * @param menuCode
 * @returns
 */
function getMenu(menuCode){
	var account=getAccount();
	if(account==null){
		console.log("无法获取账号信息！");
		return null;
	}else if(menuCode==null){
		return null;
	}else{
	for (var i = 0; i < account.menu.menus.length; i++) {
		var menu=account.menu.menus[i];
		if (menu.code == menuCode) {
			return menu;
			break;
		} else {
			continue;
		}
	}
	}
}
/**
 * 获取根菜单
 * @returns {Array}
 */
function getMenuRoot(){
	var lis=[];
	var account=getAccount();
	if(account==null){
		console.log("无法获取账号信息！");
		return lis;
	}else{
		for (var i = 0; i < account.menu.menus.length; i++) {
			var menu=account.menu.menus[i];
			if (null==menu.parentCode || ''==menu.parentCode) {
				if(getPermissionByCode(menu.permissionCode)!=null) lis.push(menu);
			} else {
				continue;
			}
		}
		return lis;
	}
}
/**
 * 获取子菜单
 * @param menuCode
 * @returns
 */
function getMenuChildren(menuCode){
	var lis=[];
	var menus=getMenus(null);
	if(menus==null){
		return lis;
	}else{
	for (var i = 0; i <menus.length; i++) {
		var menu=menus[i];
		if (menu.parentCode == menuCode) {
			if(getPermissionByCode(menu.permissionCode)!=null) lis.push(menu);
		} else {
			continue;
		}
	}
	return lis;
	}
}
/**
 * 获取菜单编号menuCode 下的子菜单列表，包括其子的子菜单
 * @param menuCode 菜单编号
 * @param type  s: 显示的；h：隐藏的； a: all所有 
 * @param menus 菜单集合
 */
function getMenuTree(menuCode,type,menus){
	 var array = [];
         $.each(menus, function(i, m) {
        	 switch(type){
        	 case "s":{
        		 if (m.visible==1&&m.parentCode == menuCode) {
                	 if(getPermissionByCode(m.permissionCode)!=null){
                		 var treenode =  new cloneObject(m);
                         treenode.id = m.code;
                         treenode.text = m.name;
                         treenode.children =getMenuTree(m.code,type,menus);
                         array.push(treenode);
                	 }
                	 
                 } 
        		 break;
        	 }
        	 case "h":{
        		 if (m.visible==0&&m.parentCode == menuCode) {
                	 if(getPermissionByCode(m.permissionCode)!=null){
                		 var treenode =  new cloneObject(m);
                         treenode.id = m.code;
                         treenode.text = m.name;
                         treenode.children =getMenuTree(m.code,type,menus);
                         array.push(treenode);
                	 }
                	 
                 } 
        		 break;
        	 }
        	 case "a":{
        		 if (m.parentCode == menuCode) {
                	 if(getPermissionByCode(m.permissionCode)!=null){
                		 var treenode =  new cloneObject(m);
                         treenode.id = m.code;
                         treenode.text = m.name;
                         treenode.children =getMenuTree(m.code,type,menus);
                         array.push(treenode);
                	 }
                	 
                 } 
        		 break;
        	 }
        	 }
         });
	return sortByorderNo(array);
}
/**
 * 获取权限编码为perCode 对应的值URL
 * @param perCode
 */
function getPermissionUrl(perCode){
	var permission=getPermissionByCode(perCode);
	console.log("permission.hostAddressSign:"+getHost(permission.hostAddressSign));
	console.log("permission.url:"+permission.url);
	return permission==null?null:getHost(permission.hostAddressSign)+permission.url;
}
/**
 * 根据权限对象获取权限URL路径
 * @param permission
 * @returns
 */
function getUrlByPermission(permission){
	return permission==null?null:getHost(permission.hostAddressSign)+permission.url;
}
/**
 * 根据权限码获取权限对象
 * @param perCode
 * @returns
 */
function getPermissionByCode(perCode){
  var permissions=getPermission(null);
  var permission=null;
  if(permissions!=null&& permissions.length!=undefined){
  for (var i = 0; i < permissions.length; i++) {
    if (permissions[i]!=null&&permissions[i].code == perCode) {
      permission= permissions[i]; break;
    } else {
      continue;
    }
  }
  }
  return permission;
}
/**
 * 获取公共业务中bpro请求URL
 */
function getBproUrl(){
	return getHost(HostAddress.bpro)+"/bpro/sunrise.bpro";
}
/**
 * 开启或者关闭权限
 * @param perCode 权限码，多个用逗号隔开
 * @param disOrenable disable或者 enable
 */
function disOrenablePermission(perCode,disOrenable){
  var code=perCode.split(";");
  for (var i = 0; i < code.length; i++) {
    $sunrise.parse(getPermissionByCode(code[i]),disOrenable);
  }
}


function getPermissionChildren(permissionid){
	var relation=getPermission(null);
	var children=[];
	for(var i=0;i < relation.length; i++){
		if(relation[i].parentCode==permissionid){
			children.push(relation[i]);	
		}
	}
	return children;
}
/**
 * 
 * @param permissionid 权限码
 * @param type 权限类型
 * @returns {Array}
 */
function getPermissionChildrenSorByType(permissionid,type){
	var relation=getPermission();
	var children=[];
	for(var i=0;i < relation.length; i++){
		if(relation[i].parentCode==permissionid&&relation[i].type==type){
			children.push(relation[i]);	
		}
	}
	return children;
}


function changeTitle(target,titlevalue){
  $('#'+target).panel({title: titlevalue});
}
/**
 * 根据用户的序列获取相关的模块权限
 * @returns {Array}
 */
function getportalLisrt(list,childdrens){
	var data=[];
	var key=null;
	for(var j=0;j<list.length;j++){
		 key=list[j];
	for(var i=0;i<childdrens.length;i++){
		if(key==childdrens[i].code){
			data.push(childdrens[i]);
		}
	}
	}
	return data;
}
/**
 * 获取当前客户的所有缓存数据
 * @param uuid 进线号码,sessionid,roomid
 */
function getCurrentUserData(uuid){
	
}
/**
 * 获取当前的UUID
 * @returns
 */
function getUuid(){
	return $sunrise.getStore("uuid",'tophome');
}
/**
 * 生产随机的 数字与英文组合串
 * @param len 长度
 * @param radix
 * @returns
 */
function uuid(len, radix) {
	var chars = '0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz'
			.split('');
	var uuid = [], i;
	radix = radix || chars.length;



	if (len) {
		for (i = 0; i < len; i++)
			uuid[i] = chars[0 | Math.random() * radix];
	}



	else {
		// rfc4122, version 4 form
		var r;

		// rfc4122 requires these characters
		uuid[8] = uuid[13] = uuid[18] = uuid[23] = '-';
		uuid[14] = '4';

		// Fill in random data.  At i==19 set the high bits of clock sequence as
		// per rfc4122, sec. 4.1.5
		for (i = 0; i < 36; i++) {
			if (!uuid[i]) {
				r = 0 | Math.random() * 16;
				uuid[i] = chars[(i == 19) ? (r & 0x3) | 0x8 : r];
			}
		}
	}

	return uuid.join('');
}

/**
 * 根据账号获取业务类型
 * @param accno
 */
function getBussTypeByAccNo(accno){
	//TODO 
	var type=accno.substring(0,6);
	switch(type){
	case '622439':{
		return 'debit';
		break;
	}
	case '625080':{
		return 'credit';
		break;
	}
	
	}
}
/**
 * 获取当前坐席操作的卡片，没有时返回null
 */
function getCurrentDebitCard(){
	var customerData = $sunrise.getStore("debit", 'tophome');
	if(customerData!=null && customerData!=undefined && customerData!=''){
		var currentAccount=customerData.getCurrentAccount();
		if(currentAccount!=null){
			return currentAccount.cardNo;
		}
	}
}
/**
 * 获取当前信用卡
 * @returns
 */
function getCurrentCreditCard(){
	var customerData = $sunrise.getStore("credit", 'tophome');
	if(customerData!=null && customerData!=undefined && customerData!=''){
		var currentAccount=customerData.getCurrentAccount();
		if(currentAccount!=null){
			return currentAccount.cardNo;
		}
	}
}
/**
 * 获取当前对公业务卡
 * @returns
 */
function getCurrentCompanyCard(){
	var customerData = $sunrise.getStore("company", 'tophome');
	if(customerData!=null && customerData!=undefined && customerData!=''){
		var currentAccount=customerData.getCurrentAccount();
		if(currentAccount!=null){
			return currentAccount.cardNo;
		}
	}
}
/**
 * 获取当前储蓄卡客户信息
 * @returns
 */
function getCurrentDebitCustomer(){
	var customerData = $sunrise.getStore("debit", 'tophome');
	if(customerData!=null){
		return customerData.customer;
	}else{
		return null;
	}
}
/**
 * 刷新客户缓存信息
 * @returns
 */
function reflashCurrentDebitCustomer(debitCustomer){
	var customerData = $sunrise.getStore("debit", 'tophome');
	if(customerData!=null){
		for(var i in debitCustomer){
			try {
				customerData.customer[i]=debitCustomer[i];
			} catch (e) {
				// TODO: handle exception
			}
			
		}
		return true;
	}else{
		return false;
	}

}
/**
 * 获取当前信用卡客户信息
 * @returns
 */
function getCurrentCreditCustomer(){
	var customerData = $sunrise.getStore("credit", 'tophome');
	if(customerData!=null){
		return customerData.customer;
	}else{
		return null;
	}
}
/**
 * 根据KEY获取debit客户上下文数据
 * @param key  如：customer.name
 * @returns 
 */
function getDebitCustomerContentData(key){
	//var key="customer.name";
	if(key==null){
		return "无";
	}
	var customerData = $sunrise.getStore('debit', 'tophome');
	var value=eval("customerData."+key);
	value =value==undefined?"无":value;
	return value;
}
/**
 * 根据KEY获取company客户上下文数据
 * @param key  如：customer.name
 * @returns 
 */
function getCompanyCustomerContentData(key){
	//var key="customer.name";
	if(key==null){
		return "无";
	}
	var customerData = $sunrise.getStore('company', 'tophome');
	var value=eval("customerData."+key);
	value =value==undefined?"无":value;
	return value;
}
/**
 * 根据KEY获取客户上下文数据
 *  @param tabid  页签ID 
 * @param key  如：customer.name
 * @returns 
 */
function getCustomerContentData(tabid,key){
	//var key="customer.name";
	if(tabid==null||key==null){
		return null;
	}else{
		tabid=tabid.toLowerCase();
		var value=null;
		var customerData = $sunrise.getStore(tabid, 'tophome');
		try {
			value=eval("customerData."+key);
			value =value==undefined?null:value;
		} catch (e) {
			value=null;
		}
		
		return value;	
	}
}
/**
 * 获取客户上下文
 * @param tabid 值为：debit、credit、company 不区分大小写
 * @returns
 */
function getCustomerContent(tabid){
	//var key="customer.name";
	if(tabid==null){
		return null;
	}else{
		tabid=tabid.toLowerCase();
		var value=null;
		return $sunrise.getStore(tabid, 'tophome');
		return value;	
	}
	
}
/**
 * 根据KEY获取 credit信用卡客户上下文数据
 * @param key
 * @returns
 */
function getCreditCustomerContentData(key){
	//var key="customer.name";
	if(key==null){
		return "无";
	}
	var customerData = $sunrise.getStore("credit", 'tophome');
	var value=eval("customerData."+key);
	value =value==undefined?"无":value;
	return value;
}
/**
 * 缓存参数的子参数
 * @param codes,多个参数用逗号隔开
 */
function inntParameter(codes){
	Console.log("codes:"+codes);
	$.messager.alert(codes)

		var url='http://127.0.0.1:8083/qcTemplate/dictionary/getDictionaryValuesMap';
		$.ajax({
			url : url,
			data : {
                codes : 'root/BusinessPara/UOMP/qcmg/templType'
			},
			cache : false,
			async : false,
			dataType : 'json',

		});

	

}
/**
 * 获取参数组type 下code 对应的值
 * @param type
 * @param code
 */
function getParameterValue(type,code){
	var parameters = $sunrise.getStore(type, 'tophome');
	var value=code;
	if(parameters!=null){
		for(var i=0;i<parameters.length;i++){
			var parameter=parameters[i];
			if(parameter.code==code){
				value=parameter.value;
				break;
			}
		}
	}
	return value;
}
/**
 * 获取参数列表
 * @param type
 * @returns {Array}
 */
function getParameters(type,defCode,defValue){
	var parameters = $sunrise.getStore(type, 'tophome');
	var value=[];
	if(defCode!=null&&defValue!=undefined){
		var str={};
		str.code=defCode;
		str.value = defValue;
		value.push(str);
	}
	if(parameters!=null){
		$.each(parameters,function(i,p){
			if('1'==p.status)//保留参数状态为“有效”的参数
				value.push(p);
		});
	}
	return value;
}
/**
 * 来电总结数据
 */
var worksumid=null;
function getworksumid(){
	if(worksumid!=null){
		return worksumid;
	}else{
		var url=getHost(HostAddress.bpro)+'/bpro/getseq.bpro';
		$.ajax({
 			type : 'get',
 			url : url,
 			data : {
 				seqName  : 'WORKSUM'
 			},
 			cache : false,
 			async : false,
 			dataType : 'json',
 			success : function(data) {
 				worksumid=data;
			}
 		});
		
	}
}

function clearworksumid(){
	worksumid=null;
}
/**
 * 来电总结数据结束
 * */

/**
 * 获取所有的随路数据
 */
function getCallData(){
	return $sunrise.getStore("callData",'tophome');
}
/**
 * 设置随路数据
 * @param key
 * @param value
 * @returns
 */
function setCallData(key,value){
	 $sunrise.callmethod('softphone','setAttachData',key,value);
}
/**
 * 获取随路数据的某个值
 * @param key
 * @returns
 */
function getCallDataBykey(key){
	//20160704 HWC
	var value = "";
	try {
		value = $sunrise.callmethod('softphone', 'getAttachData', key);
	} catch (e) {
	}
	return value;
}
/**
 * 获取话机状态
 * @returns
 */
function getPhoneStats() {
	return $sunrise.callmethod('softphone','getphoneStats');
}
/**
 * 获取坐席状态
 * @returns
 */
function getAgentStatus(){
	return $sunrise.callmethod('softphone','getagentStatus');
}
/**
 * 获取通话状态
 * @returns
 */
function isTalk(){
	return $sunrise.getStore('istalk','csrhome')!=null;
}
/**
 * 检查在线状态(弹出提示)
 */
function checkOnlineForBPE(){
	var online=false;
	if(!isTalk()){
		$.messager.alert('提示', '非在线状态，不允许操作。', 'warning');
		$.messager.progress('close');
	}else{
		online=true;
	}
	return online;
}


/**
 * 
 * @param PAGE_ID 页面 PAGE_ID
 * @param callback 回调方法名，会议后回调
 */
function conferenceIVR(PAGE_ID,callback){
	var ivrVdn=getParameterValue('root/SystemConf/CTI', 'ivrVdn');
	if(ivrVdn!=null){
		if(PAGE_ID!=null){
			 $sunrise.setStore('modepage',PAGE_ID, 'tophome');
			 $sunrise.setStore('callback',callback, 'tophome');
			 $sunrise.callmethod('softphone','conference2ivr',ivrVdn);
		}else{
			$.messager.alert("PAGE_ID 未设置！");
		}
		
	}else{
		$.messager.alert("无法获取VDN:root/SystemConf/CTI/ivrVdn");
	}
}
/**
 * transfer 到IVR
 * @param vdn 从参数 获取getParameterValue('root/SystemConf/CTI', 'vdn')
 */
function transferIVR(vdn){
	if(vdn!=null){
		$sunrise.callmethod('softphone','Transfer',vdn);
	}else{
		$.messager.alert("vdn为空！");
	}
}
/**
 * 开始模式化窗口
 */
function startwinMode(){
	$.messager.progress({
		title:'转接IVR',
		msg:'请稍后...',
		text:''
	});
}
/**
 * 结束模式化窗口
 */
function endwinMode(){
	$.messager.progress('close');
	//回调函数
	var  callback=$sunrise.getStore('callback', 'tophome');
	var pageid= $sunrise.getStore('modepage', 'tophome');
	 $sunrise.callmethod(pageid,callback);
	$sunrise.delStore('callback', 'tophome');//清除回调函数
}
/**
 * 寻找页面上菜单树的权限码为 permCode 的菜单点并模拟点击打开
 * @param treetarget
 * @param permCode
 */
function clickTreeNode(treetarget,permCode){
	if(permCode!=null){
		var node=getTreeNodeByPermCode(treetarget,permCode);
		if(node!=null){
			$('#'+treetarget).tree('expandTo',node.target);
			$(node.target).trigger("click");
			 $sunrise.delStore('menupermCode','tophome');
		}else{
			$.messager.alert("警告","没有找到权限码为：["+permCode+"]的菜单，请联系管理员",'warning');
		}
	}
}
/**
 * 根据权限码找到菜单点
 * @param treetarget
 * @param permCode
 */
function getTreeNodeByPermCode(treetarget,permCode){
	var roots=$('#'+treetarget).tree('getRoots');
	if(roots!=null&&roots.length>0){
		return getTreeNodeChidren(treetarget,roots,permCode);
	}else{
		return null;
	}
}
//getTreeNodeByPermCode 循环回调
function getTreeNodeChidren(treetarget,nodes,permCode){
	var node=null;
	for(var i=0;i<nodes.length;i++){
		var tnode=nodes[i];
		if(tnode.permissionCode==permCode){
			node= tnode;
			break;
		}else{
			var childrens=$('#'+treetarget).tree("getChildren",tnode.target); 
			if(childrens.length>0){
				var onode= getTreeNodeChidren(treetarget,childrens,permCode);
				if(onode!=null){
					node=onode;
					break;
				}
			}
		}
	}
	return node;
	
}
/**
 * 选定tab页或者关闭tab页
 * @param targetid 标签元素ID
 * @param bussType 业务类型 debit credit company common
 * @param perId 权限码
 * @param selected true 选择，false 关闭 
 */
function selectOrcloseTab(targetid, bussType, perId, selected) {
	var  node=getTreeNodeByPermCode('trees',perId);
	bussType=bussType==null?getCurrBussType():bussType;
	var idp=node==null?(perId + '_' + bussType):(node.id + '_' + bussType);
	var id = '#' + targetid;
	var tabs = $(id).tabs('tabs');
	for (var i = (tabs.length - 1); i >= 0; i--) {
		var tab = tabs[i];
		var tabid = tab.panel('options').id;// 获取页签的ID
		if (tabid == idp) {
			if (selected) {
				$(id).tabs('select', i);
			} else {
				$(id).tabs('close', i);
			}
		}
	}

}
/**
 * 在系统中的菜单找到权限点对应的菜单，并模拟点击打开
 * @param nav 1： 我的工作台；2 运营管理，3：业务处理
 * @param permCode
 */
function menuTreeClick(nav,permCode){
	switch(nav){
		case 1:{//我的工作台
			 $('#imgN1_0003').trigger("click"); //打开页面
			 var ok=$sunrise.callmethod('userIndex','clickTreeNode','trees',permCode);
			 if(ok==undefined){
				 $sunrise.setStore('menupermCode', permCode,'tophome');
			 }
			 break;
		}
		case 2:{//运营管理
			$('#LV_R_N003').trigger("click"); //打开页面
			 var ok=$sunrise.callmethod('managehome','clickTreeNode','trees',permCode);
			 if(ok==undefined){
				 $sunrise.setStore('menupermCode', permCode,'tophome');}
			 break;
		}
		case 3:{//业务处理
			 $('#imgN1_0002').trigger("mouseenter");
			 $('#imgN2_0004').trigger("click"); //打开页面
			 var ok=$sunrise.callmethod('csrhome','clickTreeNode','trees',permCode);
			 if(ok==undefined){
				 $sunrise.setStore('menupermCode', permCode,'tophome');
			 }
			 break;
		}
		case 5:{
			$('#imgN1_0002').trigger("mouseenter");
			 $('#imgN2_0007').trigger("click"); //打开页面
			 var ok=$sunrise.callmethod('vtahome','clickTreeNode','trees',permCode);
			 if(ok==undefined){
				 $sunrise.setStore('menupermCode', permCode,'tophome'); }
			 break;
		}
		case 4:{//业务处理》业务类型页面主页切换
			 $('#imgN1_0002').trigger("mouseenter");
			 $('#'+permCode).trigger("click"); //打开页面
		}
	}
}

/**
 * 在线事件
 */
var event={};
event.REQUEST_CHECK_IN="REQUEST_CHECK_IN";
event.ON_CHECK_IN_SUCCESS="ON_CHECK_IN_SUCCESS";
event.ON_CHECK_IN_FAILE="ON_CHECK_IN_FAILE";
event.REQUEST_CHECK_OUT="REQUEST_CHECK_OUT";
event.ON_CHECK_OUT_SUCCESS="ON_CHECK_OUT_SUCCESS";
event.ON_CHECK_OUT_FAILE="ON_CHECK_OUT_FAILE";
event.REQUEST_READY="REQUEST_READY";
event.ON_READY_SUCCESS="ON_READY_SUCCESS";
event.ON_READY_FAILE="ON_READY_FAILE";
event.REQUEST_REST="REQUEST_REST";
event.ON_REST_SUCCESS="ON_REST_SUCCESS";
event.ON_REST_FAILE="ON_REST_FAILE";
event.REQUEST_WORKING="REQUEST_WORKING";
event.ON_WORKING_SUCCESS="ON_WORKING_SUCCESS";
event.ON_WORKING_FAILE="ON_WORKING_FAILE";
event.REQUEST_RELEASE="REQUEST_RELEASE";
event.ON_RELEASE_SUCCESS="ON_RELEASE_SUCCESS";
event.ON_RELEASE_FAILE="ON_RELEASE_FAILE";
event.REQUEST_TRANS_TO_AGENT="REQUEST_TRANS_TO_AGENT";
event.ON_TRANS_TO_AGENT_SUCCESS="ON_TRANS_TO_AGENT_SUCCESS";
event.ON_TRANS_TO_AGENT_FAILE="ON_TRANS_TO_AGENT_FAILE";
event.REQUEST_TRANS_TO_QUEUE="REQUEST_TRANS_TO_QUEUE";
event.ON_TRANS_TO_QUEUE_SUCCESS="ON_TRANS_TO_QUEUE_SUCCESS";
event.ON_TRANS_TO_QUEUE_FAILE="ON_TRANS_TO_QUEUE_FAILE";
event.REQUEST_GET_BACK="REQUEST_GET_BACK";
event.ON_GET_BACK_SUCCESS="ON_GET_BACK_SUCCESS";
event.ON_GET_BACK_FAILE="ON_GET_BACK_FAILE";
event.REQUEST_CONFERENCE="REQUEST_CONFERENCE";
event.ON_CONFERENCE_SUCCESS="ON_CONFERENCE_SUCCESS";
event.ON_CONFERENCE_FAILE="ON_CONFERENCE_FAILE";
event.REQUEST_SYN="REQUEST_SYN";
event.ON_SYN_SUCCESS="ON_SYN_SUCCESS";
event.ON_SYN_FAILE="ON_SYN_FAILE";
event.REQUEST_RELEASE_CONFERENCE="REQUEST_RELEASE_CONFERENCE";
event.ON_RELEASE_CONFERENCE_SUCCESS="ON_RELEASE_CONFERENCE_SUCCESS";
event.ON_RELEASE_CONFERENCE_FAILE="ON_RELEASE_CONFERENCE_FAILE";
event.REQUEST_RINGING="REQUEST_RINGING";
event.ON_RINGING_SUCCESS="ON_RINGING_SUCCESS";
event.ON_RINGING_FAILE="ON_RINGING_FAILE";
event.REQUEST_ANSWER="REQUEST_ANSWER";
event.ON_ANSWER_SUCCESS="ON_ANSWER_SUCCESS";
event.ON_ANSWER_FAILE="ON_ANSWER_FAILE";
event.REQUEST_TALKING="REQUEST_TALKING";
event.ON_TALKING_SUCCESS="ON_TALKING_SUCCESS";
event.ON_TALKING_FAILE="ON_TALKING_FAILE";
event.REQUEST_ACW="REQUEST_ACW";
event.ON_ACW_SUCCESS="ON_ACW_SUCCESS";
event.ON_ACW_FAILE="ON_ACW_FAILE";
event.ON_AGENT_STATUS_CHANGE="ON_AGENT_STATUS_CHANGE";
event.REQUEST_SET_MAX_CONNECT="REQUEST_SET_MAX_CONNECT";
event.ON_SET_MAX_CONNECT_SUCCESS="ON_SET_MAX_CONNECT_SUCCESS";
event.ON_SET_MAX_CONNECT_FAILE="ON_SET_MAX_CONNECT_FAILE";
event.REQUEST_ONESELF="REQUEST_ONESELF";
event.ON_ONESELF_SUCCESS="ON_ONESELF_SUCCESS";
event.ON_ONESELF_FAILE="ON_ONESELF_FAILE";
event.REQUEST_V_RELEASE="REQUEST_V_RELEASE";
event.ON_V_RELEASE_SUCCESS="ON_V_RELEASE_SUCCESS";
event.ON_V_RELEASE_FAILE="ON_V_RELEASE_FAILE";
event.REQUEST_V_ANSWER="REQUEST_V_ANSWER";
event.ON_V_ANSWER_SUCCESS="ON_V_ANSWER_SUCCESS";
event.ON_V_ANSWER_FAILE="ON_V_ANSWER_FAILE";
event.REQUEST_V_RINGING="REQUEST_V_RINGING";
event.ON_V_RINGING_SUCCESS="ON_V_RINGING_SUCCESS";
event.ON_V_RINGING_FAILE="ON_V_RINGING_FAILE";
event.REQUEST_V_ACW="REQUEST_V_ACW";
event.ON_V_ACW_SUCCESS="ON_V_ACW_SUCCESS";
event.ON_V_ACW_FAILE="ON_V_ACW_FAILE";
event.REQUEST_V_SYN="REQUEST_V_SYN";
event.ON_V_SYN_SUCCESS="ON_V_SYN_SUCCESS";
event.ON_V_SYN_FAILE="ON_V_SYN_FAILE";
event.WORKING="WORKING";
/**
 * 在线软电话随路数据
 */
function OnlineEvent(){
	this.accode="";
	this.event="";
	this.data=new Map();
}
function IVR_NUMBER(){
	return getParameterValue("root/SystemConf/CTI", 'ivrVdn');
}
/**
 * 关闭弹出的窗口
 */
function closeWin(){
	$sunrise.callmethod('tophome','closedefaultWin');
}
/**
 * 振铃类型与后台枚举类RoomRingSign 一致
 */
var RoomRingSign={};
RoomRingSign.NORMAL="NORMAL";
RoomRingSign.TRANS="TRANS";
RoomRingSign.CONFERENCE="CONFERENCE";
RoomRingSign.SYN="SYN";
RoomRingSign.MONITOR="MONITOR";
//-----------在线结束

//设置菜单码缓存信息
function setMenuCodesCache(data){
	$sunrise.setStore('MenuCodes',data.rows,'tophome');
}
//获取菜单码缓存信息
function getMenuCodesCache(){
	return $sunrise.getStore('MenuCodes','tophome');
}

/**
 * 在线座席状态
 */
var chatAgentStatus={};
chatAgentStatus.AGENT_STATUS_CHECKIN="0";
chatAgentStatus.AGENT_STATUS_READY="1";
chatAgentStatus.AGENT_STATUS_WORKING="2";
chatAgentStatus.AGENT_STATUS_REST="3";
chatAgentStatus.AGENT_STATUS_CHECKOUT="9";