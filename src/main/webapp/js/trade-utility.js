/**
 * call系统方法
 * 
 * @param pageId
 *            方法所在PAGE_ID
 * @param methodName
 *            方法Name
 * @param data
 *            参数
 */
function callMethod(pageId, methodName, field, value) {
	return $sunrise.callmethod(pageId, methodName, field, value);
}
/**
 * 权限控制
 * 
 * @param perType
 *            M：页面菜单下的所有按钮；F：单独的按钮
 * @param perCode
 *            type为M时送页面菜单权限码，为F时送具体按钮权限码
 * @param hover
 *            将按钮设置为disable or enable
 */
function initOperatePermission(perType, perCode, hover) {
	if ('M' == perType) {
		$sunrise.parse(getPermissionChildren(perCode), hover);
	} else if ('F' == perType) {
		$sunrise.parse(getPermissionByCode(perCode), hover);
	}
}
/**
 * 页面按钮权限控制
 * 
 * @param hover
 *            将按钮设置为disable or enable
 * @param permissionCodes
 *            权限码数组[permissionCodes]
 */
function initPagePermissions(hover, permissionCodes) {
	for (i in permissionCodes) {
		$sunrise.parse(getPermissionByCode(permissionCodes[i]), hover);
	}
}

/**
 * 通话中转IVR按钮可点击
 * 
 * @param btnId
 *            IVR按钮id
 */
function initIVRBtn(btnId) {
	try {
		if (isTalk()) {
			$('#' + btnId).linkbutton('enable');
		} else {
			$('#' + btnId).linkbutton('disable');
		}
	} catch (e) {
		$.messager.alert('提示', '通话状态异常：' + e, 'info');
	}

}
/**
 * 查询datagrid
 * 
 * @param elementid
 *            需展示table ID
 * @param PermID
 *            路径ID
 * @param obj
 *            传参对象
 * @param reqType
 *            请求方式 post or get
 */
function queryDatagrid(elementid, PermID, obj, formId, reqType) {
	if(!tradeIntercepter(obj)){
		$.messager.alert('提示','非通话状态不允许进行此类交易','info');
		return;
	}
	var url = getPermissionUrl(PermID);
	if(''==url||null==url){
		$.messager.alert('提示','未得到此权限码的授权：'+PermID);
		return;
	}
	var isValid = $('#' + formId).form('validate');
	if (formId != null && formId != "") {
		if (!isValid) {
			$.messager.alert('提示', "您的输入有误，请注意输入框提示！", 'info');
			return isValid;
		} else {
			obj = convertData(obj, formId);
			obj.permCode = PermID;
		}
	}
	var win = $.messager.progress({
		title : '请稍等',
		msg : '数据加载中...',
		text : ''
	});
	if ('undefined' == typeof reqType)
		reqType = 'post';
	$.ajax({
		type : reqType,
		url : url,
		dataType : 'json',
		data : obj,
		success : function(response) {
			$.messager.progress('close');
			if (response.returnCode == ReturnCode.success) {
				if (response.rows == "" || response.rows == null) {
					response['total'] = 0;
					$('#' + elementid).datagrid('loadData', response);
					$.messager.alert('交易成功', "没有查到数据。", 'info');
				} else {
					if(obj.page=='1'){
						$('#'+elementid).datagrid('getPager').pagination({
							pageNumber:1,
							showPageList: false,		
							showRefresh: false,
							total:0}); 
					}					
					
					$('#' + elementid).datagrid('loadData', response);
				}
			} else {
				response['total'] = 0;
				response['rows'] = "";
				$('#' + elementid).datagrid('loadData', response);
				$.messager.alert('交易结果', '返回码（' + response.returnCode
						+ "）:返回信息（" + response.returnMessage + "）", 'info');
			}
		},
		error : function(xhr, errorText, errorStatus) {
			$.messager.progress('close');
			$.messager.alert('错误', "错误码（" + errorStatus + "）:错误信息（" + errorText + "）", 'error');
		}
	});
}

/**
 * 交易明细类交易处理
 * 
 * @param PermID
 *            地址ID
 * @param obj
 *            参数对象
 */
function queryDetail(PermID, obj, formId) {
	if(!tradeIntercepter(obj)){
		$.messager.alert('提示','非通话状态不允许发送此类交易','info');
		return;
	}
	var isValid = $('#' + formId).form('validate');
	if (formId != null && formId != "") {
		if (!isValid) {
			$.messager.alert('提示', "您的输入有误，请注意输入框提示！", 'info');
			return isValid;
		} else {
			obj = convertData(obj, formId);
			obj.permCode = PermID;
		}
	}
	var win = $.messager.progress({
		title : '请稍等',
		msg : '数据加载中...',
		text : ''
	});
	$.ajax({
		type : 'POST',
		url : getPermissionUrl(PermID),
		dataType : 'json',
		data : obj,
		success : function(response) {
			$.messager.progress('close');
			if (response.returnCode == ReturnCode.success) {
				setFieldValues(response);
			} else {
				$.messager.alert('交易错误', "返回码（" + response.returnCode
						+ "）:错误信息（" + response.returnMessage + "）", 'info');
			}
		},
		error : function(xhr, errorText, errorStatus) {
			$.messager.progress('close');
			$.messager.alert('警告', "错误码（" + errorStatus + "）:错误信息（" + errorText
					+ "）", 'warning');
		}
	});
}
/**
 * 更改操作
 * 
 * @param formid
 *            form表单ID
 * @param PermID
 *            路径 ID
 * @param obj
 *            传参对象
 */
function executeTrade(PermID, obj, formId, bussType, btnelementid, alertFlag) {
	if(!tradeIntercepter(obj)){
		$.messager.alert('提示','非通话状态不允许发送此类交易','info');
		return;
	}
	var isValid = $('#' + formId).form('validate');
	if (formId != null && formId != "") {
		if (!isValid) {
			$.messager.alert('提示', "您的输入有误，请注意输入框提示！", 'info');
			return isValid;
		} else {
			obj = convertData(obj, formId);
			obj.permCode = PermID;
		}
	}
	var win = $.messager.progress({
		title : '请稍等',
		msg : '数据提交中...',
		text : ''
	});
	$.ajax({
		type : 'POST',
		url : getPermissionUrl(PermID),
		dataType : 'json',
		data : obj,
		success : function(response) {
			$.messager.progress('close');
			if (undefined == alertFlag || alertFlag == "" || alertFlag == null) {
				if (response.returnCode == ReturnCode.success) {
					$.messager.alert('交易成功', response.returnMessage, 'info');
				} else {
					$.messager.alert('交易错误', "返回码（" + response.returnCode + "）:错误信息（" + response.returnMessage + "）", 'info');
				}
			}
		},
		error : function(xhr, errorText, errorStatus) {
			$.messager.progress('close');
			$.messager.alert('警告', "错误码（" + errorStatus + "）:错误信息（" + errorText + "）", 'warning');
		}
	});
}

function convertData(obj, formId) {
	var elements = $('#' + formId).find(':input[name]');
	var value;
	for (var i = 0; i < elements.length; i++) {
		var e = elements[i];
		if (e.name == "beginDate" || e.name == "endDate"
				|| e.name == "executeDate") {
			value = e.value.replace(/\-/g, "");
		} else {
			value = $.trim(e.value);
		}
		obj[e.name] = value;
	}
	return obj;
}
/**
 * 组装原始数据
 * 
 * @param obj
 *            需要提交的数据
 * @param formId
 *            需要提交的表单Id
 * @returns
 */
function convertUOMPData(obj, formId) {
	var elements = $('#' + formId).find(':input[name]');
	for (var i = 0; i < elements.length; i++) {
		var e = elements[i];
		obj[e.name] = e.value;
	}
	return obj;
}

/**
 * 实现导出Excel
 * 
 * @param PermID
 *            路径ID
 * @param obj
 *            传参对象
 * @param formId
 *            formId
 */
function exportXls(PermID, obj, formId) {
	obj.returnType = "excel";
	var url = getPermissionUrl(PermID);
	if (formId != null && formId != "") {
		var elements = $('#' + formId).find(':input[name]');
		for (var i = 0; i < elements.length; i++) {
			var e = elements[i];
			if (e.name == "beginDate" || e.name == "endDate"
					|| e.name == "executeDate") {
				obj[e.name] = e.value.replace(/\-/g, "");
			} else {
				obj[e.name] = e.value;
			}
		}
	}

	if (obj != null && obj != "") {
		url += '?'
		for (i in obj) {
			url += i + "=" + obj[i] + "&";
		}
		url = url.substring(0, url.length - 1);
	}
	//TODO tomcat 需要使用
	//var encodeUrl = encodeURI(url);
	window.open(url);
}

/**
 * 遍历参数data bean节点属性 给当前页等于data属性的id节点赋值
 * 
 * @param obj
 */
function setFieldValues(data) {
	if (data.bean)
		data = data.bean;
	try {
		if (null != data) {
			for (i in data) {
				var o = $('#' + i);
				if (o[0]) {
					if ('INPUT' == o[0].tagName) {
						var classAttr = o.attr('class');
						if (undefined == classAttr)
							o.val(data[i]);
						else if (classAttr.indexOf('easyui-textbox') >= 0)
							o.textbox('setValue', data[i]);
						else if (classAttr.indexOf('easyui-combobox') >= 0)
							o.combobox('select', data[i]);
						else if (classAttr.indexOf('easyui-datebox') >= 0)
							o.datebox('setValue', data[i]);
						else if (classAttr.indexOf('easyui-numberbox') >= 0)
							o.numberbox('setValue', data[i]);
						else if (classAttr.indexOf('easyui-combogrid') >= 0)
							o.combogrid('setValue', data[i]);
						else if (o.attr('type') == 'checkbox')
							o.attr('checked', true);
					} else {
						o.text(data[i]);
					}
				}
			}
		} else {
			$.messager.alert('提示', '交易成功,但返回数据为空', 'info')
			return false;
		}
	} catch (e) {
		$.messager.alert('提示', 'BUGGGGGGGGGGGGGGG', 'info')
	}
}

/**
 * 获取交易返回数据
 * 
 * @param PermID
 *            权限ID
 * @param obj
 *            参数
 * @param formid
 *            formId
 * @returns
 */
function getTradeData(PermID, obj, formid) {
	if(!tradeIntercepter(obj)){
		$.messager.alert('提示','非通话状态不允许发送此类交易','info');
		return;
	}
	var result;
	var win = $.messager.progress({
		title : '请稍等',
		msg : '数据提交中...',
		text : ''
	});
	if (formid != null && formid != "") {
		var isValid = $("#" + formid).form('validate');
		if (!isValid) {
			$.messager.alert('提示', "您的输入有误，请注意输入框提示！", 'info');
			return isValid;
		}
		obj.permCode = PermID;
		var form = document.getElementById(formid);
		for (var i = 0; i < form.length; i++) {
			var element = form[i];
			if (element.name != "" && element.name != null
					&& element.name != "undefined") {
				obj[element.name] = element.value;
			}
		}
	}
	$.ajax({
		type : 'POST',
		url : getPermissionUrl(PermID),
		dataType : 'json',
		data : obj,
		async : false,
		success : function(response) {
			$.messager.progress('close');
			if (response.returnCode == ReturnCode.success) {
				result = response;
			}
		},
		error : function(xhr, errorText, errorStatus) {
			$.messager.progress('close');
			$.messager.alert('错误', "错误码（" + errorStatus + "）:错误信息（" + errorText
					+ "）", 'error');
		}
	});
	return result;
}

/**
 * 拦截查询表单(校验查询条件不能全为空)
 * @param formId 提交的条件表单
 * @param filterArray 不计入校验范围的属性
 */
function searchInterrupter(formId,filterArray){
	var data = $('#'+formId).serializeArray();
	var hasValue = false;
	if(null!=filterArray){
		for(i in data){
			if(''!=data[i].value&&null!=data[i].value){
				var eq = false;
				for(j in filterArray){
					if(data[i].name==filterArray[j]){
						eq = true;
						break;
					}
				}
				if(!eq){
					hasValue = true;
					break;
				}
			}
		}
	}else{
		for(i in data){
			if(''!=data[i].value&&null!=data[i].value){
				hasValue = true;
				break;
			}
		}
	}
	return hasValue;
}

/**
 * 提交表单，追加post数据
 * 
 * @param permissionCode	权限码
 * @param page 当前页this	对象
 * @param successfully 		交易成功回调函数 null时提示
 * @param error 		交易失败回调函数 null时提示
 * @param obj 			追加postData
 * @param formId 		提交表单id 可为NUll
 * @param progress 		是否显示进度条默认true
 */
function submitFormCallback(permissionCode, page, successfully, error, obj, formId, progress) {
	var url = getPermissionUrl(permissionCode);
	if (null != url) {
		obj.permCode = permissionCode;
		postFormCallback(url, page, successfully, error, obj, formId, progress);
	} else {
		$.messager.alert('提示', '无' + permissionCode + '权限', 'warning');
		return;
	}
}
/**
 * 提交表单，追加post数据
 * 
 * @param url
 * @param page 当前页this对象
 * @param successfully  交易成功回调函数 null时提示
 * @param error  交易失败回调函数 null时提示
 * @param obj 追加postData
 * @param formId  提交表单id 可为NUll
 * @param progress 是否显示进度条默认true
 */
function postFormCallback(url, page, successfully, error, obj, formId, progress) {
	var subForm = $('#' + formId);
	if (formId != null && subForm[0]) {
		var isValid = subForm.form('validate');
		if (!isValid) {
			$.messager.alert('提示', "您的输入有误，请注意输入框提示！", 'info');
			return isValid;
		} else {
			convertData(obj, formId);
		}
	}
	postDataCallback(url, page, successfully, error, obj, progress);
}
/**
 * 提交数据
 * 
 * @param url
 * @param page 当前页this对象
 * @param successfully  交易成功回调函数 null时提示
 * @param error  交易失败回调函数 null时提示
 * @param obj 追加postData
 * @param progress  是否显示进度条默认true
 */
function postDataCallback(url, page, successfully, error, obj, progress) {
//20180703 注释 原因：现阶段需求 根据用户不同来决定是否通话状态才能发送交易
//	if(!tradeIntercepter(obj)){
//		$.messager.alert('提示','非通话状态不允许发送此类交易','info');
//		return;
//	}
	if ('undefined' == typeof progress || progress){
		$.messager.progress({
			title : '请稍等',
			msg : '数据交互中...',
			text : ''
		});	
	}
	$.ajax({
		type : 'post',
		url : url,
		data : obj,
		cache : false,
		/*dataType : 'json',*/
		dataType : 'text',
		success : function(jsonstr) {
			var json=eval("("+jsonstr+")");
			if ('undefined' == typeof progress || progress){
				$.messager.progress('close');
			}
			if (json.returnCode == ReturnCode.success) {
				if (null != successfully) {
					if ('function' == typeof (successfully)) {
						var fn = page.eval(successfully);
						var args = [];
						args.push(json);
						args.push(obj);
						fn.apply(page, args);
					} else if (successfully.indexOf('(') > 0) {
						page.eval(successfully);
					} else {
						var fn = page.eval(successfully);
						var args = [];
						args.push(json);
						args.push(obj);
						fn.apply(page, args);
					}
				} else {
					$.messager.alert('交易结果', '交易结果：' + json.returnMessage,
							'info');
				}
			} else {
				if (null != error) {
					var fn = page.eval(error);
					var args = [];
					args.push(json);
					args.push(obj);
					fn.apply(page, args);
				} else {
					$.messager.alert('交易结果', "错误码（" + json.returnCode
							+ "）:错误信息（" + json.returnMessage + "）", 'warning');
				}
			}
		}
	});
}
/**
 * 从页面缓存获取数据
 * 
 * @param type
 *            业务类型，个人debit、信用卡业务credit
 * @param level
 *            处理等级 客户信息custInfo、账户信息acctInfo
 * @returns
 */
function getCacheData(bussType, level) {
	try {
		var customerData = $sunrise.getStore(bussType, 'tophome');
		if ("custInfo" == level) {
			return customerData.getCustomer();
		} else if ("acctInfo" == level) {
			return customerData.getCurrentAccount();
		} else {
			$.messager.alert('警告', "缓存类型输入错误！", 'warning');
			return;
		}
	} catch (e) {
		return null;
	}
}
/**
 * 在页面set数据
 * 
 * @param type
 *            业务类型，个人debit、信用卡业务credit
 * @param level
 *            处理等级 客户信息custInfo、账户信息acctInfo
 * @param value
 *            等级对象
 * @returns
 */
function setCacheData(bussType, level, value) {
	var customerData = $sunrise.getStore(bussType, 'tophome');
	if ("custInfo" == level) {// 刷新客户信息
		customerData.setCustomer(value);
	} else if ("acctInfo" == level) {// 刷新账户信息
		var account = customerData.getCurrentAccount();
		account.detail = value;
	} else {
		$.messager.alert('警告', "缓存类型输入错误！", 'warning');
		return;
	}
}
/**
 * 从页面缓存获取数据在页面展示
 * 
 * @param type
 *            业务类型，个人debit、信用卡业务credit
 * @param level
 *            处理等级 客户信息custInfo、账户信息acctInfo
 */
function queryDetailCache(bussType, level) {
	var returnVal = getCacheData(bussType, level);
	var obj = new Object();
	obj.bean = returnVal;
	setFieldValues(obj);
}
/**
 * 提交表单，追加post数据
 * 
 * @param permissionCode
 *            权限码
 * @param page
 *            当前页this对象
 * @param successfully
 *            交易成功回调函数 null时提示
 * @param error
 *            交易失败回调函数 null时提示
 * @param obj
 *            追加postData 也可为Null
 * @param formId
 *            提交表单id 可为NUll
 * @param reqType
 *            请求类型 不填默认post
 * @param progress
 *            是否显示进度条默认true
 */
function submitUOMPCallback(permissionCode, page, successfully, error, obj,
		formId, reqType, progress) {
	var url = getPermissionUrl(permissionCode);
	if (null != url) {
		obj.permCode = permissionCode;
		postUOMPCallback(url, page, successfully, error, obj, formId, reqType,
				progress);
	} else {
		$.messager.alert('提示', '无' + permissionCode + '权限', 'warning');
		return;
	}
}
/**
 * 提交表单，追加post数据
 * 
 * @param url
 * @param page
 *            当前页this对象
 * @param successfully
 *            交易成功回调函数 null时提示
 * @param error
 *            交易失败回调函数 null时提示
 * @param obj
 *            追加postData
 * @param reqType
 *            请求类型 不填默认post
 * @param progress
 *            是否显示进度条默认true
 */
function postUOMPCallback(url, page, successfully, error, obj, formId, reqType, progress) {
	var subForm = $('#' + formId);
	if (formId != null && subForm[0]) {
		var isValid = subForm.form('validate');
		if (!isValid) {
			$.messager.alert('提示', "您的输入有误，请注意输入框提示！", 'info');
			return isValid;
		} else {
			var elements = subForm.find(':input[name]');
			for (var i = 0; i < elements.length; i++) {
				var e = elements[i];
				obj[e.name] = e.value;
			}
		}
	}
	if (progress)
		$.messager.progress({
			title : '请稍等',
			msg : '数据交互中...',
			text : ''
		});
	$.ajax({
		type : reqType,
		url : url,
		data : obj,
		cache : false,
		dataType : 'json',
		success : function(json) {
			if (progress)
			$.messager.progress('close');
			if (json.returnCode == ReturnCode.success) {
				if (null != successfully) {
					var fn = page.eval(successfully);
					var args = [];
					args.push(json);
					args.push(obj);
					fn.apply(page, args);
				}
			} else {
				if (null != error) {
					var fn = page.eval(error);
					var args = [];
					args.push(json);
					args.push(obj);
					fn.apply(page, args);
				}
			}
		}
	});
}
/**
 * 从缓存获取当前账号信息单列展示
 * 
 * @param elementid
 *            展示table ID
 */
function showCurrentCard(elementid) {
	var customerData = $sunrise.getStore("debit", 'tophome'); // 获取缓存
	var currentAccount = customerData.getCurrentAccount();
	if (currentAccount != null) {
		currentAccount['transType'] = currentAccount.detail.transType;
		$('#' + elementid).datagrid('appendRow', currentAccount);
	} else {
		$.messager.alert('警告', "没有账号详细信息！", 'warning');
	}
}
/**
 * 增加新页签
 * 
 * @param busiType
 *            业务类型 credit debit
 * @param perId
 *            permissionCode
 * @param title
 *            页签title
 * @param obj
 *            需要传入新页签的参数对象
 */
function openTab(busiType, perId, title, obj) {
	var url = getPermissionUrl(perId);
	if (obj != null && obj != "") {
		url += '?';
		for (i in obj) {
			url += i + "=" + obj[i] + "&";
		}
		url = url.substring(0, url.length - 1);
	}
	$sunrise.callmethod('tophome', 'addcurrTab', busiType, title, url, 'iframe', perId);
}

/**
 * 增加内管打开页面
 * @param perId
 * @param title
 * @param obj
 */
function openManageTab(perId,title,obj){
	var url = getPermissionUrl(perId);
	if(obj!=null&&obj!=""){
		url += '?'
		for (i in obj) {
			url += i+"="+obj[i]+"&";
		}
		url = url.substring(0,url.length-1);
	}	
	$sunrise.callmethod('tophome','addcurrTab',null, title,url,'iframe',perId);
}


/**
 * 查看反欺诈是否打开
 * 
 * @param code
 *            反欺诈编号
 */
function prevent(code) {
	var result;
	var obj = new Object();
	obj.TranCode = "Ls5002";
	obj.code = code;
	var data = getTradeData('F_0031', obj);
	if (data != null && data != '')
		result = data.name;
	return result;
}
/**
 * 反欺诈交易 data中必须已包含交易返回的 returnCode 与 returnMessage
 */
function preventFake(bussType, data) {
	var customer = getCacheData(bussType, 'custInfo');
	data.acctNo = customer.acctNo;
	data.idCardType = customer.custIdCardType;
	data.idCard = customer.custIdCardNo;
	// data.callNo = getCallDataBykey('ANI');
	data.returnRews = '';
	postDataCallback(getBproUrl(), this, null, null, data, false);
}
/**
 * 获取来电/去电号码(广农商)
 */
function getCallNo() {
	try {
		
		//var callNo=getCallDataBykey('ANI');
		// TODO 修改来电号
		var callNo='12345678';
		if('9'==callNo.substring(0,1))
			callNo = callNo.substring(1);
		if('0'==callNo.substring(0,1))
			callNo = callNo.substring(1);
		return callNo;
	} catch (e) {
		// $.messager.alert('提示','获取进线号码失败','info');
		return '';
	}
}

/**
 * 交易拦截
 * 出现异常的情况下返回true避免出现意外导致系统无法使用
 */
function tradeIntercepter(postData){/*
	try {
		var istalk = isTalk();
		if (istalk || undefined == postData.TranCode) {
			return true;
		} else {
			var tranCode = postData.TranCode;
			var tradeType = tranCode.substring(0, 1);
			//非通话状态禁止使用信用卡、借记卡、积分、基金、旧系统存储过程类交易（Cd301，Ds030，Ds031，Ds125工单与360查询客户信息例外,Ds129人民币外汇牌价查询,Ds071人民币汇率查询）
			if ('C' == tradeType && 'Cd301' != tranCode || 'D' == tradeType
					&& 'Ds030' != tranCode && 'Ds125' != tranCode
					&& 'Ds031' != tranCode && 'Ds129' != tranCode && 'Ds071' != tranCode 
					|| 'I' == tradeType || 'F' == tradeType || 'P' == tradeType) {
				return false;
			} else {
				return true;
			}
		}
	} catch (e) {
		return true;
	}
*/
	return true;
	}

/**
 * 增加新页签
 * 
 * @param busiType
 *            业务类型 credit debit
 * @param url
 *            页面URL
 * @param title
 *            页签title
 * @param obj
 *            需要传入新页签的参数对象
 * @param type
 *            数据类型 年 月 日
 * @param urls
 * 			  type 为X 其他url
 */
function openTabByUrl(busiType, title, obj,type,urls) {
	var url=null;
	if(type=="M")
		url=getHost(HostAddress.ui)+"/sunriseui/report/pages/business/month_report_query.html"
	else if(type=="Y")
		url=getHost(HostAddress.ui)+"/sunriseui/report/pages/business/year_report_query.html"
	else if(type=="D")
		url=getHost(HostAddress.ui)+"/sunriseui/report/pages/business/day_report_query.html"
	else if(type=="X")
		url=urls;
	else{
		if(urls!='' && urls!=null && urls!=undefined){
		url=urls;
		}else{
			console.log("跳转页面url为空！");
			return ;
		}
	}
	if (obj != null && obj != "") {
		url += '?';
		for (i in obj) {
			url += i + "=" + obj[i] + "&";
		}
		url = url.substring(0, url.length - 1);
	}
	console.log(url);
	$sunrise.callmethod('tophome', 'addcurrTab', busiType, title, url, 'iframe', '');
}

/**
 * 打开dialog 根据权限码
 * @param perId
 * @param title
 * @param width
 * @param height
 * @param shadow
 * @param obj
 * @returns
 */
function showMessageDialog(perId, title, width, height, shadow,obj) {
	var url =  getPermissionUrl(perId);
	console.log(url);
	if (obj != null && obj != "") {
		url += '?';
		for (i in obj) {
			url += i + "=" + obj[i] + "&";
		}
		url = url.substring(0, url.length - 1);
	}
	console.log(url);
    var content = '<iframe src="' + url + '" width="100%" height="99%" frameborder="0" scrolling="no"></iframe>';
    var boarddiv = '<div id="msgwindow" title="' + title + '"></div>'//style="overflow:hidden;"可以去掉滚动条
    $(document.body).append(boarddiv);
    var win = $('#msgwindow').dialog({
        content: content,
        width: width,
        height: height,
        modal: shadow,
        title: title,
        onClose: function () {
            $(this).dialog('destroy');//后面可以关闭后的事件
        }
    });
    win.dialog('open');
}

/**
 * 打开dialog 根据URL
 * @param url
 * @param title
 * @param width
 * @param height
 * @param shadow
 * @param obj
 * @returns
 */
function showMessageDialogByUrl(url, title, width, height, shadow,obj) {
	if (obj != null && obj != "") {
		url += '?';
		for (i in obj) {
			url += i + "=" + obj[i] + "&";
		}
		url = url.substring(0, url.length - 1);
	}
    var content = '<iframe src="' + url + '" width="100%" height="99%" frameborder="0" scrolling="no"></iframe>';
    var boarddiv = '<div id="msgwindow" title="' + title + '"></div>'//style="overflow:hidden;"可以去掉滚动条
    $(document.body).append(boarddiv);
    var win = $('#msgwindow').dialog({
        content: content,
        width: width,
        height: height,
        modal: shadow,
        title: title,
        onClose: function () {
            $(this).dialog('destroy');//后面可以关闭后的事件
        }
    });
    win.dialog('open');
}

