/**
 * easyui分页类方法
 * 自定义分页扩展方法
 * 与datagrid分页属性初始化方法
 */
/**
 * 初始化翻页，主要是 将argsfunction 回调的函数返回的参数进行追加 翻页参数，page 和 rows
 * @param target grid元素
 * @param perCode 权限码
 * @param page 当前页面，window或者 this
 * @param callback 回调函数（该回调函数 参数是 target, perCode
 * @param argsfunction 请求参数回调方法，返回的是grind的查询参数对象
 */
function definedPagination(target,perCode,page,callback,argsfunction,formId){
	var pager = $('#'+target).datagrid('getPager');	// get the pager of datagrid
	pager.pagination({
		showRefresh:false,
		showPageList: false,
		iconAlign:'right',
		onSelectPage:function(pageNumber, pageSize){
			var fn = page.eval(callback);
			var argsf=page.eval(argsfunction);
			var arg=argsf.apply(page,null);
	   		arg.page=(pageNumber-1)*pageSize+1;
	   		arg.rows=pageSize;
	   		var args = [];
	   		args.push(target);
	   		args.push(perCode);
	   		args.push(arg);
	   		args.push(formId);
	   		fn.apply(page,args);
		}
	});		
}
/**
 * 初始化翻页，主要是 将argsfunction 回调的函数返回的参数进行追加 翻页参数，page 和 rows
 * @param target grid元素
 * @param perCode 权限码
 * @param page 当前页面，window或者 this
 * @param callback 回调函数（该回调函数 参数是 target, perCode
 * @param argsfunction 请求参数回调方法，返回的是grind的查询参数对象
 */
function definedDataBasePagination(target,perCode,page,callback,argsfunction,formId){
	var pager = $('#'+target).datagrid('getPager');	// get the pager of datagrid
	pager.pagination({
		showRefresh:false,
		showPageList: false,
		iconAlign:'right',
		onSelectPage:function(pageNumber, pageSize){
			var fn = page.eval(callback);
			var argsf=page.eval(argsfunction);
			var arg=argsf.apply(page,null);
	   		arg.page=pageNumber;
	   		arg.rows=pageSize;
	   		var args = [];
	   		args.push(target);
	   		args.push(perCode);
	   		args.push(arg);
	   		args.push(formId);
	   		fn.apply(page,args);
		}
	});		
}
/**
 * 使用当前页最后一行数据作为查询条件的翻页器
 * (广农商)
 * @param target
 * @param page
 * @param callback
 * @param argsfunction	
 * @param lastRowsArray	翻页条件数组
 * @param pageNum	当前页码
 * @param pageSz	当前页返回条数
 * @param indexSize	接口默认翻页条数
 */
function lastRowDefinedPagination(target,page,callback,argsfunction,lastRowsArray,pageNum,pageSz,indexSize){
	var pager = $('#'+target).datagrid('getPager');
	var total = lastRowsArray.length*indexSize + pageSz;//当前明确的条数+下一页的最大条数
	var queryTotal = (pageNum-1)*indexSize+pageSz;//当前已查询出的记录数
	pager.pagination({
		total: total,
		pageNumber: pageNum,
		pageSize: indexSize,
		showRefresh: false,
		showPageList: false,
		iconAlign:'right',
		layout:['sep','first','prev','manual','next'],
		afterPageText: '页',
		displayMsg:'显示 '+(queryTotal-pageSz+1)+'到 '+queryTotal+'条记录',
		//displayMsg:'',
		onSelectPage:function(pageNumber,pageSize){
			pageNum = pageNumber;
			var fn = page.eval(callback);
			var argsf=page.eval(argsfunction);
			var arg=argsf.apply(page,null);
			if(1==pageNumber){
				arg.hasPages='0';
			}else{
				var nextPageRow = lastRowsArray[pageNumber-2];
				for(i in nextPageRow){
					arg[i] = nextPageRow[i];
				}
				arg.hasPages='1';
			}
	   		var args = [];
	   		args.push(arg);
	   		args.push(pageNum);
	   		fn.apply(page,args);
		}
	});
}
/**
 * 初始化页面
 * @param elementid	展示table ID
 * @param toolbarid	工具栏ID（选择当前页数及页面总数展示工具栏）
 * @param pageflag	是否展示分页组件
 * @param pageNumber 起始页
 * @param pageSize	页面总行数
 * @param singleSelect	选择单行或多行,true或者false
 * @param rownumbers	显示一个行号列,true或者false.
 * @param fitColumns,   收缩列的大小，以适应网格的宽度，防止水平滚动。true或者false.
 */
function initEmptyGrid(elementid,toolbarid,pageflag,pageNumber,pageSize,singleSelect,rownumbers,fitColumns){
	$('#'+elementid).datagrid({
		pageList: [10,20,50,100],		//添加页面展示条数
	    pagination:pageflag,    		//是否在DataGrid控件底部显示分页工具栏。
	    pagePosition:'bottom',    		//定义分页工具栏的位置。可用的值有：'top','bottom','both'。
	    fit:true,						//自适应
	    pageNumber:pageNumber,  		//在设置分页属性的时候初始化页码。
	    pageSize:pageSize,      		//在设置分页属性的时候初始化页面大小。
	    fitColumns : fitColumns,      	//收缩列的大小，以适应网格的宽度，防止水平滚动。	
	    remoteSort:false,       		//定义从服务器对数据进行排序。
	    striped:true,	        		//是否显示斑马线效果。       
	    loadMsg : '加载中...',
	    rownumbers : rownumbers,      	//显示一个行号列,true或者false.
	    singleSelect : singleSelect,    //选择单行或多行,true或者false.
	    border: false,					//边框默认无
	    toolbar: '#'+toolbarid  		//工具条
	})
	//初始化页码
	$('#'+elementid).datagrid('getPager').pagination({
		showPageList: false,			//不显示pageList
		showRefresh: false,
		total:0}); 
}
/**
 * 初始化页面
 * @param elementid	展示table ID
 * @param toolbarid	工具栏ID（选择当前页数及页面总数展示工具栏）
 * @param pageflag	是否展示工具栏
 * @param pageNumber起始页
 * @param pageSize	页面总行数
 * @param pageList	页面选择展示条数（数据）
 */
function initIntegralEmptyGrid(elementid,toolbarid,pageflag,pageNumber,pageSize,pageList){
	$('#'+toolbarid).show(); 
	$('#'+elementid).datagrid({   
	    pagination:pageflag,
//	    pageNumber:pageNumber,
	    pageSize:pageSize,
	    pageList:pageList,
	    fitColumns : true,	
	    remoteSort:false,
	    striped:true,	        
	    loadMsg : '玩命加载中...',
	    rownumbers : true,
	    toolbar: '#'+toolbarid
	}); 
}

/**
 * 初始化dialog窗属性
 * @param elementid	dialog窗口id
 * @param title		dialog窗口名称
 * @param buttonDiv	绑定按钮id
 * @param iconCls	窗口图标
 */
function initDialog(elementid,title,buttonDiv,iconCls){
	$('#'+elementid).dialog({
		iconCls:iconCls,
		title:title,
		maximizable:false,
	    closed: true,
	    cache: false,
		modal:true,
		buttons:'#'+buttonDiv
	});
}
/**
 * 初始化dialog窗属性 非模式化窗口
 * @param elementid	dialog窗口id
 * @param title		dialog窗口名称
 * @param buttonDiv	绑定按钮id
 * @param iconCls	窗口图标
 */
function initModalDialog(elementid,title,buttonDiv,iconCls){
	$('#'+elementid).dialog({
		iconCls:iconCls,
		title:title,
		maximizable:false,
	    closed: true,
	    cache: false,
		modal:false,
		buttons:'#'+buttonDiv
	});
}

function resetPagination(elementid){
	$('#'+elementid).datagrid('getPager').pagination({
		pageNumber:1,
		showPageList: false,		
		showRefresh: false,
		total:0});
}