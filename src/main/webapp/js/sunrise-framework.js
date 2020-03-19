//结果吗枚举数据
 var ReturnCode = {};
 ReturnCode.success = "0000";
 ReturnCode.nodata="F990";
//-----------------结束--- 
function Map() {
	this.elements = new Array();
	// 获取MAP元素个数
	this.size = function() {
		return this.elements.length;
	};
	// 判断MAP是否为空
	this.isEmpty = function() {
		return (this.elements.length < 1);
	};
	// 删除MAP所有元素
	this.clear = function() {
		this.elements = new Array();
	};
	// 向MAP中增加元素（key, value)
	this.put = function(_key, _value) {
		this.remove(_key);//删除存在的元素
		this.elements.push({
			key : _key,
			value : _value
		});
	};
	// 删除指定KEY的元素，成功返回True，失败返回False
	this.remove = function(_key) {
		var bln = false;
		try {
			for (var i = 0; i < this.elements.length; i++) {
				if (this.elements[i].key == _key) {
					this.elements.splice(i, 1);
					return true;
				}
			}
		} catch (e) {
			bln = false;
		}
		return bln;
	};
	// 获取指定KEY的元素值VALUE，失败返回NULL
	this.get = function(_key) {
		try {
			for (var i = 0; i < this.elements.length; i++) {
				if (this.elements[i].key == _key) {
					return this.elements[i].value;
				}
			}
		} catch (e) {
			return null;
		}
	};
	// 获取指定索引的元素（使用element.key，element.value获取KEY和VALUE），失败返回NULL
	this.element = function(_index) {
		if (_index < 0 || _index >= this.elements.length) {
			return null;
		}
		return this.elements[_index];
	};
	// 判断MAP中是否含有指定KEY的元素
	this.containsKey = function(_key) {
		var bln = false;
		try {
			for (var i = 0; i < this.elements.length; i++) {
				if (this.elements[i].key == _key) {
					bln = true;
				}
			}
		} catch (e) {
			bln = false;
		}
		return bln;
	};
	// 判断MAP中是否含有指定VALUE的元素
	this.containsValue = function(_value) {
		var bln = false;
		try {
			for (var i = 0; i < this.elements.length; i++) {
				if (this.elements[i].value == _value) {
					bln = true;
				}
			}
		} catch (e) {
			bln = false;
		}
		return bln;
	};
	// 获取MAP中所有VALUE的数组（ARRAY）
	this.values = function() {
		var arr = new Array();
		for (var i = 0; i < this.elements.length; i++) {
			arr.push(this.elements[i].value);
		}
		return arr;
	};
	// 获取MAP中所有KEY的数组（ARRAY）
	this.keys = function() {
		var arr = new Array();
		for (var i = 0; i < this.elements.length; i++) {
			arr.push(this.elements[i].key);
		}
		return arr;
	};
}
/**
 * js实现list
 * 
 */
function List() {
	this.values = [];
	/* 添加 */
	this.add = function(obj) {
		return this.values.push(obj);
	};
	/* 大小 */
	this.size = function() {
		return this.values.length;
	};
	/* 返回指定索引的值 */
	this.get = function(index) {
		return this.values[index];
	};
	/* 删除指定索引的值 */
	this.remove = function(index) {
		this.values.splice(index, 1);
		return this.values;
	};
	/* 删除全部值 */
	this.removeAll = function() {
		return this.values = [];
	};
	/* 是否包含某个对象 */
	this.constains = function(obj) {
		for ( var i in this.values) {
			if (obj == this.values[i]) {
				return true;
			} else {
				continue;
			}
		}
		return false;
	};

	/* 是否包含某个对象 */
	this.getAll = function() {
		var allInfos = '';
		for ( var i in this.values) {
			if (i != (this.values.length - 1)) {
				allInfos += this.values[i] + ",";
			} else {
				allInfos += this.values[i];
			}
		}
		return allInfos += this.values[i] + ",";
	};
	this.getAllValue=function(){
		return this.values;
	};
}
/**
 * 按orderNo排序
 * @param lis
 * @returns
 */
function sortByorderNo(lis){
	var tem=[];//临时放置列表
	var target=[];//转后列表
	if(lis.length>0){
		for(var j = 0; j < lis.length; j++){
			var object=target.pop();//
			var o=lis[j];//数据
			if(object!=null){
				while(true){
					if(object.orderNo>o.orderNo){
						tem.push(object);
						object=target.pop();
						if(object==null)break;	
					}else{
						target.push(object);
						break;
					}
				}
				target.push(o);
				for (var int = 0; int < tem.length; int++) {
					target.push(tem[int]);
				}
				tem=[];
			}else{
				target.push(o);
			}	
		}
		return target;
	}else{
		return lis;
	}
}
function GridData(){}
GridData.total=0;
GridData.rows=[];

/**
 * 页面数据
 */
function  winData(){
		this.map=new Map(),//key：数据的键：value ：数据，对象请放 JSON数据字符串
		this.list=new List(),
		this.hasKey=function(key){
			return this.map.containsKey(key);
		};
	}

// ----------------------------------------------------------------上下文对象定义--单例模式----------------------------------
(function($) {
	if (!$) {
		return;
	}
	
	var $sunrise={
		vision:1.0
	};
	
	//全局数据对象
	var storeData={
		map:new Map(),//存放winData的MAP key： winname；value ：winData
		hasWin:function(winName){
			return this.map.containsKey(winName);
		}
	};
	
	/****************定义基础方法********************************/
	var PAGE_ID=window['PAGE_ID'];
	var events={};
	var o = $({});//观察者对象
	$.extend($sunrise,{
		/**
		*@desc 获取store中存储的数据
		*@param key 用于存储数据的key值
		*@param winName 页面的名称，用于区分不同的页面
		*/
		getStore : function(key, winName) {
			if ($sunrise.isTopWindow()) {
				var data=new Map();
				winName = winName||PAGE_ID;
				if(winName){
					data=storeData.map.get(winName);
					if(!data){
						return null;
					}
				}
				return data.map.get(key);//返回上下文保存的数据
			} else {
				winName = winName || PAGE_ID;
				return $sunrise.getTopSC().getStore(key, winName);
			}
		},
		/**
		 * 获取所有的缓存对象
		 */
		getAllStore : function(winName) {
			if ($sunrise.isTopWindow()) {
				var data=new Map();
				if(winName==null){
					data= storeData.map;
				}else{
					winName = winName||PAGE_ID;
					if(winName){
						data=storeData.map.get(winName);
						if(!data){
							return null;
						}
					}else{
						data= storeData.map;
					}
				}
				
				return data;//返回上下文保存的数据
			} else {
				if(winName!=null)winName = winName || PAGE_ID;
				return $sunrise.getTopSC().getAllStore(winName);
			}
		},
		/**
		*@desc 设置store中存储的数据
		*@param key 用于存储数据的key值
		*@param value 需要存储的数据，请存储成string，如果是对象，请存储成json字符串
		*@param winName 页面的名称，用于区分不同的页面
		*/
		setStore:function(key,value,winName){
			//顶层页面
			if($sunrise.isTopWindow()){
				winName = winName||PAGE_ID;
				if(winName){
					var windata=storeData.map.get(winName);//获取页面winName数据
					if(windata!=null&&windata!=undefined){
						 windata.map.put(key, value);//设置存在则替换
					}else{
						//第一次加入
						windata=new winData();
						windata.map.put(key, value);
						storeData.map.put(winName, windata);//设置存在则替换
					}
				}
				//非顶层页面
			}else{
				winName=winName||PAGE_ID;//设置数据时，默认添加PAGE_ID
				$sunrise.getTopSC().setStore(key,value,winName);
			}
		},
		/**
		*@desc 删除当前页面的缓存数据
		*/
		delStoreByWinName:function(winName){
			if($sunrise.isTopWindow()){
				storeData.map.remove(winName);
			}else{
				winName=winName||PAGE_ID;//设置数据时，默认添加PAGE_ID
				$sunrise.getTopSC().delStoreByWinName(winName);
			}
		},
		/**
		*@desc 删除数据
		*@param key key
		*@param winName 页面名称
		*/
		delStore:function(key,winName){
			if($sunrise.isTopWindow()){
				var windata=storeData.map.get(winName);
				if(windata!=null){
					windata.map.remove(key);
				}
			}else{
				$sunrise.getTopSC().delStore(key,winName);
			}
		},
		/**根据权限赋值权限页面对象是否可访问
		 * permission 权限对象或者权限对象的数组
		 * disOren：disable 或者enable 的值
		 */
     parse:function(permission,disOren){
       if(permission!=null&&permission!=undefined){
        if(permission.length==undefined){
          switch(permission.type){
          case 'F':
            $('#'+permission.code).linkbutton(disOren);
            break;
          case 'M':
            $('#'+permission.code).linkbutton(disOren);
            break;
          }
        }else{
          $.each(permission,function(i,perm){
            switch(perm.type){
            case 'F':
              $('#'+perm.code).linkbutton(disOren);
              break;
            case 'M':
              $('#'+perm.code).linkbutton(disOren);
              break;
            }
  
          });
        }
  
       }else{
         //权限对象为空
       }
      },
		/**
		*@desc 获取顶层框架
		*/
		getTopSC:function(){
			var topWin=$sunrise.getTopWindow();
			return topWin[globalName];
		},
		/**
		 * 调用页面方法 
		 * @winName 页面ID EY_PAGE_ID
		 * @methodName 方法名
		 */
		callmethod:function (winName,methodName){
			//顶层页面
			if($sunrise.isTopWindow()){
				winName = winName||PAGE_ID;
				if(winName){
					var iframe=getiframe(winName);
					if(iframe!=null&&iframe!=undefined){
						var args=[];
						if(arguments.length>0){
							for(var i=2;i<arguments.length;i++){
								args.push(arguments[i]);
							}
						}
						if(methodName!=undefined){
						if(methodName.indexOf('(')>0){
							return iframe.eval(methodName);
						}else{
							var  fn=iframe.eval(methodName);
							if(fn){
								return fn.apply(iframe, args);  
							}else{
								return undefined;
							}
						}
						}
						
					}else{
						return undefined;
					}
				}
				//非顶层页面
			}else{
				winName=winName||PAGE_ID;//设置数据时，默认添加PAGE_ID
				return $sunrise.getTopSC().callmethod.apply(this,arguments);
			}
			},
		/**
		*@desc js继承
		*/
		extendObject:function(e){
			if(!e)return TypeError();
			if(Object.create)
				return Object.create(e);
			function f(){}
			f.prototype = e;
			return new f();
		}
	});
	
	/**@desc 获取最顶层的非跨域的top
	*
	*/
	$sunrise.getTopWindow=function(check){
		var win=window;
		while(true){
			if(win.parent!=win){
				try{
					if(!win.parent[globalName]){
						break;
					}
				}catch(e){
					break;
				}
			}else{
				break;
			}
			win=win.parent;
		}
		return win;
	};
	
	
	$sunrise.isTopWindow=function(win){
		var topWin=$sunrise.getTopWindow();
		win=win||window;
		return win==topWin;
	};
	
	var globalName = 'sunrise';
	window['$sunrise'] = window[globalName] = $sunrise;
})(jQuery);


/**
 * 根据 winName 获取页面iframe对象
 *  直接调用会从当前页面查询开始
 * @param winName
 * @returns {@G}
 */
function getiframe(winName){
	if(window['PAGE_ID']==winName){
		return this;
		}else{
		var iframes=document.getElementsByTagName('iframe');
		var target=null;
		for(var i=0;i<iframes.length;i++){
			var iframe=iframes[i];
			try {
				if(typeof(iframe.contentWindow.getiframe)=='function'){
					target= iframe.contentWindow.getiframe(winName);
				}
				if(target==null) continue; else{
					return target;
				}
			} catch (e) {
				
			}
			
			}
	}
	
}
/**
 * 扩展jQuery的观察者模式
 */
(function ($) {

  var o = $({});

  $.subscribe = function () {
      o.on.apply(o, arguments);
  };

  $.unsubscribe = function () {
      o.off.apply(o, arguments);
  };

  $.publish = function () {
      o.trigger.apply(o, arguments);
  };

} (jQuery));


function changeTreeChildenCss(target,css,css1){
  for(var i=0;i<target.length;i++){
    var a=target[i];
    jQuery(a).addClass(css);
    var childers=jQuery(a).children("ul");
    changeTreeChildenCss(childers,css1);
  }
}
//对象和数组的深拷贝 
Object.clone = function(sObj){  
    function Clone(){}  
    Clone.prototype = obj;  
    var o = new Clone();  
    for(var a in o){  
        if(typeof o[a] == "object") {  
            o[a] = cloneObject(o[a]);  
        }  
    }  
    return o;  
};
 //对象扩展，tObj被扩展对象，sObj扩展对象  
   Object.extend = function(tObj,sObj){
	   function Clone(){}  
	    Clone.prototype = sObj;  
	    var o = new Clone();  
        for(var i in o){
        	var name=i;
        	tObj[name]=sObj[i]; 
        } 
   };
/**
 * 克隆函数
 * @param obj
 * @returns {Clone}
 */
function cloneObject(obj){  
    function Clone(){}  
    Clone.prototype = obj;  
    var o = new Clone();  
    for(var a in o){  
        if(typeof o[a] == "object") {  
            o[a] = cloneObject(o[a]);  
        }  
    }  
    return o;  
}  


//根据orderNo 进行排序

function refer(arr,i,j){
	var change=(aee[i].orderNo-arr[i-j].orderNo)<0?true:false,value;
	if(change){
		value=arr[i];
		arr[i]=arr[i-j];
		arr[i-j]=value;
		return arguments.callee(arr,i-j,j);
	}else{
		return arr;
	}
}

/**
 * s希尔排序
 * @param array
 */
function shellSort(array){
	var length=array.length,value;
	for(var i=Math.floor(length/2);i>0;i=Math.floor(i/2)){
		for(var j=i;j<length;j++){
			if(array[j].orderNo<array[j=i].orderNo){
				refer(array,j,i);
			}else{
				continue;
			}
		}
	}return array;
}

//-----------------------UI部分-------------
/**
 *chart图 
 */
function createhighcharts(target,data,type){
	switch(type){
	case 'polar-spider':{//蛛网图
		 $(target).highcharts({
		        chart: {
		            polar: true,
		            type: 'line'
		        },

		        title: {
		            text: data.title,
		            x: -80
		        },

		        pane: {
		            size: '100%'
		        },

		        xAxis: {
		            categories: data.categories,
		            tickmarkPlacement: 'on',
		            lineWidth: 0
		        },

		        yAxis: {
		            gridLineInterpolation: 'polygon',
		            lineWidth: 0,
		            min: 0
		        },

		        tooltip: {
		            shared: true,
		            //pointFormat: '<span style="color:{series.color}">{series.name}: <b>${point.y:,.0f}</b><br/>'
					pointFormat: '<span style="color:{series.color}">{series.name}: <b>{point.y:,.0f}</b><br/>'
		        },

		        legend: {
		            align: 'right',
		            verticalAlign: 'top',
		            y: 70,
		            layout: 'vertical'
		        },

		        series: data.series

		    });
		break;
	}
	case 'bar-basic':{//标准柱形
		$(target).highcharts(
		{
	        chart: {
	            type: 'bar'
	        },
	        title: {
	            text: data.title
	        },
	        xAxis: {
	            categories: data.categories
	        },
	        yAxis: {
	            min: 0,
	            title: {
	                text: data.title
	            }
	        },
	        legend: {
	            reversed: true
	        },
	        plotOptions: {
	            series: {
	                stacking: 'normal'
	            },
	            bar:{
	            	dataLabels:{
	            		 enabled:true
	            	}	
	            }
	        },
	        series: data.series
	    }
		
		); 
	break;
	}
	case 'pie-legend':{
        $(target).highcharts({
            chart: {
                plotBackgroundColor: null,
                plotBorderWidth: null,
                plotShadow: false
            },
            title: {
                text: '考试与培训'
            },
            tooltip: {
                pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
            },
            plotOptions: {
                pie: {
                    allowPointSelect: true,
                    cursor: 'pointer',
                    dataLabels: {
                        enabled: false
                    },
					point:{
						events : {
							click:function(){
								alert(this.options.name);
							}
						}
					},
                    showInLegend: true
                }
            },
            series: [{
                type: 'pie',
                name: '考试与培训',
                data: [
                    ['完成的考试',   45.0],
                    ['未完成的考试',  26.8],
					['未完成的培训',  4.8],
                    ['已完成的培训',  8.5]
                ]
            }]
        });
        break;
	}
	
	}
	
}
/**
 * 获取菜单树对象
 * @param code
 * @param collection 子集合
 * @returns {treeMenu}
 */
function getTreeMenu(code,collection){
    var array = [];
    if (code != '' && code != null && code != undefined) {
        $.each(collection, function(i, permission) {
            if (permission.type == "F") {
            
            } else if (permission.parentCode == code) {
                var children = getTreeMenu(permission.code, collection);
                var treenode =  new cloneObject(permission);
                treenode.id = permission.code;
                treenode.text = permission.name;
                treenode.children = children;
                array.push(treenode);
            }
        });
    }
    return array;

}

function getAllTreeMenu(code,collection){
    var array = [];
    if (code != '' && code != null && code != undefined) {
        $.each(collection, function(i, permission) {
             if (permission.parentCode == code) {
                var children = getAllTreeMenu(permission.code, collection);
                var treenode =  new cloneObject(permission);
                treenode.id = permission.code;
                treenode.text = permission.name;
                treenode.children = children;
                array.push(treenode);
            }
        });
    }
    return array;

}
/**
 * 组装角色树形结构
 * @param data
 * @returns {Array}
 */
function getRoleTreeData(data) {
    var roots = [];
    var array = [];
    if (data != null) {
        if (data.returnCode == ReturnCode.success) {
        	$.each(data.map.roots,function(i,rootp){
            var treenode = new cloneObject(rootp);
                treenode.id = rootp.code;
                treenode.text = rootp.name;
                treenode.children=getTreeMenu(rootp.code, data.rows);
                array.push(treenode);
            
        	});
        } else {
            alert(data.returnMessage);
        }
    }
    return array;
}
/**
 * 组装权限树形数据
 * @param data
 * @returns {Array}
 */
function getPermissionTreeData(data) {
    var roots = [];
    var array = [];
    if (data != null) {
        if (data.returnCode == ReturnCode.success) {
        	$.each(data.map.roots,function(i,rootp){
            var treenode = new cloneObject(rootp);
                treenode.id = rootp.code;
                treenode.text = rootp.name;
                treenode.children=getAllTreeMenu(rootp.code, data.rows);
                array.push(treenode);
            
        	});
        } else {
            alert(data.returnMessage);
        }
    }
    return array;
}
/**
 * 
 * @param target 树DOM ID
 */
function clearTreeCheckNode(target){
	var nodes = $('#'+target).tree('getChecked');	// get checked nodes
	$.each(nodes,function(i,node){
		$('#'+target).tree('uncheck',node.target);
	});
}
/**
 * 菜单搜索
 * @param treetarget 树元素
 * @param value
 * @param name
 * @param pluginName
 */
var searchindex=0;
var searchcout=0;
var oldevalue="";
var matchCount=0;
function searchMenu(treetarget, name,value,pluginName,keyField) {
	var idField = '';
	if(keyField){
		idField = keyField;
	}
	if (value == '' || value == undefined) {
		value="-+_-";
		$('#'+treetarget).parent().scrollTop(0);
		matchCount=0;
	} 
	var roots =null;
	switch(pluginName){
		case 'treegrid':
			roots=$('#'+treetarget).treegrid('getRoots');
			break;
		default:
			roots=$('#'+treetarget).tree('getRoots');
		break;
	}
	if(oldevalue!=value){
		matchCount=0;
		for (var j = 0; j < roots.length; j++) {
			matchNode(treetarget,roots[j],name, value,pluginName,idField);// 树根包括子节点
			oldevalue=value;
		}
		searchindex=0;
	}else{
		searchcout=searchindex;//计数器
		for (var j = 0; j < roots.length; j++) {
			var flage=searchagain(treetarget,roots[j],name, value,pluginName,idField);// 树根包括子节点
			if(flage) break;
		}
		searchindex=searchindex+1;
		searchindex=searchindex>matchCount?0:searchindex;//已经搜索到最后的一个，重置查询索引
	}
}
function matchNode(treetarget, node, name, value, pluginName, idField) {
	try {
		var property=node[name];
		if (property.indexOf(value) != -1) {
			var tnode;
			switch(pluginName){
				case 'treegrid':
					$('#'+treetarget).treegrid('expandTo', node[idField]);
					$('#'+treetarget).treegrid('scrollTo', node[idField]);
					$('[node-id="'+node[idField]+'"]').find('.tree-title').addClass("searchMenu"); 
					break;
				default:
					tnode = $('#'+treetarget).tree('find', node.id);
					$('#'+treetarget).tree('expandTo', tnode.target);
					$('#'+treetarget).tree('scrollTo', tnode.target);
					$('#'+tnode.target.id).find('.tree-title').addClass("searchMenu");
					break;
			}
			matchCount=matchCount+1;//统计符合的个数
		}else{
			var tnode ;
			switch(pluginName){
				case 'treegrid':
					$('[node-id="'+node[idField]+'"]').find('.tree-title').removeClass("searchMenu").removeClass("searchMenunext"); 
					break;
				default:
					tnode = $('#'+treetarget).tree('find', node.id);
					$('#'+tnode.target.id).find('.tree-title').removeClass("searchMenu").removeClass("searchMenunext"); 
			}
			
		} 
		if (node.children != undefined) {
			for (var k = 0; k < node.children.length; k++) {
				matchNode(treetarget,node.children[k],name, value,pluginName,idField);
			}
		}
	} catch (e) {
		console.log(e);
	}
}

function searchagain(treetarget,node, name,value,pluginName,idField){
	try {
		switch(pluginName){
			case 'treegrid':
				var property=node[name];
				if (property.indexOf(value) != -1) {
					$('[node-id="'+node[idField]+'"]').find('.tree-title').addClass("searchMenu"); 
					if(searchcout==0){
						$('[node-id="'+node[idField]+'"]').find('.tree-title').removeClass("searchMenu").addClass("searchMenunext"); 
						$('#'+treetarget).treegrid('scrollTo', node[idField]);
						return true;
					}else{
						$('[node-id="'+node[idField]+'"]').find('.tree-title').removeClass("searchMenunext").addClass("searchMenu"); 
						searchcout=searchcout-1;
					}
				}else{
					$('[node-id="'+node[idField]+'"]').find('.tree-title').removeClass("searchMenu").removeClass("searchMenunext"); 
				} 
				if (node.children != undefined) {
					for (var k = 0; k < node.children.length; k++) {
						var flage=searchagain(treetarget,node.children[k],name, value,pluginName, idField);
						if(flage) return flage;
					}
				}
			break;
			default:
				var property=node[name];
				if (property.indexOf(value) != -1) {
					var tnode = $('#'+treetarget).tree('find', node.id);
					$('#'+tnode.target.id).find('.tree-title').addClass("searchMenu"); 
					if(searchcout==0){
						$('#'+tnode.target.id).find('.tree-title').removeClass("searchMenu").addClass("searchMenunext"); 
						var parent=$('#'+treetarget).parent();
						var locat=$('#'+tnode.target.id);
						var higth=locat.offset().top-parent.offset().top+parent.scrollTop()-50;
						$('#'+treetarget).parent().scrollTop(higth);
						return true;
					}else{
						$('#'+tnode.target.id).find('.tree-title').removeClass("searchMenunext").addClass("searchMenu"); 
						searchcout=searchcout-1;
					}
				}else{
					var tnode = $('#'+treetarget).tree('find', node.id);
					$('#'+tnode.target.id).find('.tree-title').removeClass("searchMenu").removeClass("searchMenunext"); 
				} 
				if (node.children != undefined) {
					for (var k = 0; k < node.children.length; k++) {
						var flage=searchagain(treetarget,node.children[k],name, value, idField);
						if(flage) return flage;
					}
				}
				break;
		}
	
	} catch (e) {
		//console.log(e);
	}
}

/**
 * 添加tab标签
 * @param targetid tab控件的ID
 * @param bussType 业务类型
 * @param title 标题
 * @param tabtype type 页面类型 div 或者 iframe
 * @param perId 一般传递permission的code
 * @param url URL 
 * @param selected 是否选中  true 选中，false 不选中
 */
function addTab(targetid,bussType,title,url,tabtype,perId,selected) {
	bussType=bussType==null? getCurrBussType():bussType;
	var id='#'+targetid;
	if ($(id).tabs('exists', title)) {
		$(id).tabs('close', title);
	} 
		var content = createFrame(url,tabtype,perId);
		$(id).tabs('add', {
			id:perId+'_'+bussType,
			title : title,
			content : content,
			closable : true,
			selected:(selected==undefined||selected==null)?true:selected
		});
	
	tabClose(targetid);//绑定右键
	$(id).tabs('resize');//重新刷新布局
}


/**
 * 创建tab页面
 * @param url (当type 为 div 时，url 传递为DIV的ID )
 *  @param type 页面类型 div 或者 iframe
 * @returns {String}
 */
function createFrame(url,type,name) {
	var s='';
	switch (type){
		case 'div':{
			s= '<div id='+url+'></div>';
			break;
		}
		case 'iframe':{
			s= '<iframe id="'+name+'" name="'+name+'" scrolling="no" frameborder="0"  src="' + url
			+ '" style="width:100%;height:100%;"></iframe>';
			break;
		}
	}
	return s;
}

/**
 * 
 * @param status 任务状态
 * 返回对应的颜色
 */
function getcolorBystatus(status){
	var color="#ADFF2F";
	switch(status){
	case "Created":{ color="#ADFF2F";break;}
	case "Ready":{ color="#ADFF2F";break;}
	case "Reserved":{ color="#CDCD00";break;}
	case "InProgress":{ color="#A2CD5A";break;}
	case "Completed":{ color="#ADFF2F";break;}
	case "Failed":{ color="#8B8386";break;}
	case "Obsolete":{ color="#8A8A8A";break;}
	case "Exited":{ color="#B03060";break;}
	case "Error":{ color="#CD5555";break;}
	}
	return color;
}
/**
 * 初始化权限
 * @param permissions
 */
function initButtonPermissions(permissions){
	for(var i=0;i<permissions.length;i++){
		var per=permissions[i];
		try {
			$('#'+per.permissioncode).linkbutton('enable');
		} catch (e) {
			// TODO: handle exception
		}
	}
}
/**
 * TAB 选卡右键事件
 */
function tabClose(tabsid) {
	if($('#mm').length>0){
	/*双击关闭TAB选项卡*/
	$(".tabs-inner").dblclick(function(){
		var subtitle = $(this).children(".tabs-closable").text();
		$('#'+tabsid).tabs('close',subtitle);
	});
	/*为选项卡绑定右键*/
	$(".tabs-inner").bind('contextmenu',function(e){
		$('#mm').menu('show', {
			left: e.pageX,
			top: e.pageY
		});

		var subtitle =$(this).children(".tabs-closable").text();
		$('#mm').data("currtab",subtitle);
		$('#'+tabsid).tabs('select',subtitle);
		return false;
	});
	}
}
/**
 * 绑定右键菜单事件
 * @param tabsid
 */
function tabCloseEven(tabsid) {
	//刷新
	$('#mm-tabupdate').click(function(){
		var currTab = $('#'+tabsid).tabs('getSelected');
		var url = $(currTab.panel('options').content).attr('src');
		if(url != undefined && currTab.panel('options').title != 'Home') {
			$('#'+tabsid).tabs('update',{
				tab:currTab,
				options:{
					content:createFrame(url,'iframe')
				}
			});
		}
	});
	//关闭当前
	$('#mm-tabclose').click(function(){
		var currtab_title = $('#mm').data("currtab");
		$('#'+tabsid).tabs('close',currtab_title);
	});
	//全部关闭
	$('#mm-tabcloseall').click(function(){
		$('.tabs-inner span').each(function(i,n){
			var t = $(n).text();
			$('#'+tabsid).tabs('close',t);
		});
	});
	//关闭除当前之外的TAB
	$('#mm-tabcloseother').click(function(){
		var prevall = $('.tabs-selected').prevAll();
		var nextall = $('.tabs-selected').nextAll();		
		if(prevall.length>0){
			prevall.each(function(i,n){
				var t=$('a:eq(0) span',$(n)).text();
					$('#'+tabsid).tabs('close',t);
			});
		}
		if(nextall.length>0) {
			nextall.each(function(i,n){
				var t=$('a:eq(0) span',$(n)).text();
					$('#'+tabsid).tabs('close',t);
			});
		}
		return false;
	});
	//关闭当前右侧的TAB
	$('#mm-tabcloseright').click(function(){
		var nextall = $('.tabs-selected').nextAll();
		if(nextall.length==0){
			//msgShow('系统提示','后边没有啦~~','error');
			alert('后边没有啦~~');
			return false;
		}
		nextall.each(function(i,n){
			var t=$('a:eq(0) span',$(n)).text();
			$('#'+tabsid).tabs('close',t);
		});
		return false;
	});
	//关闭当前左侧的TAB
	$('#mm-tabcloseleft').click(function(){
		var prevall = $('.tabs-selected').prevAll();
		if(prevall.length==0){
			alert('到头了，前边没有啦~~');
			return false;
		}
		prevall.each(function(i,n){
			var t=$('a:eq(0) span',$(n)).text();
			$('#'+tabsid).tabs('close',t);
		});
		return false;
	});

	//退出
	$("#mm-exit").click(function(){
		$('#mm').menu('hide');
	});
}
/**
 * 根据面板列数初始DIV
 * @param target
 * @param count
 * @returns 初始化面板列数
 */
 function innitPortal(target,count) {
	var width=window.screen.width;
	if(count<=3){
		var w=parseInt(100/count);
		for(var i=0;i<count;i++){
			$('#'+target).append('<div style="width: '+w+'%"></div>'); 
		}
		return count;
	}else{
		if(width>1280){
			var w=parseInt(100/4);
			for(var i=0;i<4;i++){
				$('#'+target).append('<div style="width: '+w+'%"></div>'); 
			}
			return 4;
		}else{
			var w=parseInt(100/3);
			for(var i=0;i<3;i++){
				$('#'+target).append('<div style="width: '+w+'%"></div>'); 
			}
			return 3;
		}
	}
}
/////////////////////////通用处理方法
function checklogin(){
	var requestParm = getRequestParam("sessionID");
	var host=getRequestParam("host");
    $sunrise.setStore("sessionID", requestParm, 'tophome');
    $.ajax({
        type : 'POST',
        url : getHost(HostAddress.uomp) + '/uomp/login/checklogin',
        data : {
            sessionID : requestParm,
            host:host
        },
        cache : false,
        async : false,
        dataType : 'json',
        success : function(json) {
            if (json.returnCode == ReturnCode.success) {
                $sunrise.setStore(requestParm, json.bean, 'tophome');
            } else {
                $.messager.confirm('提示', json.returnMessage+'重新登录?', function(r) {
                    if (r) {
                        location.href = "../index/index.html";
                    }
                });
            }
        }
    });
} 
/**
 *将HTML中DOM 的form对象转换成JS对象返回 
 */
 function serializeObject(form) {
                var o = {};
                $.each(form.serializeArray(), function(index) {
                    if (o[this['name']]) {
                        o[this['name']] = o[this['name']] + "," + this['value'];
                    } else {
                        o[this['name']] = this['value'];
                    }
                });
                return o;
            }
/**
 * 获取请求的参数为code 对于的值
 * @param code 参数
 */
function getRequestParam(code){
    var searchStr = decodeURI(location.search);
     var value=null;
     var request = [];
     request = searchStr.substr(1).split("&");
     for (var i = 0; i < request.length; i++) {
         switch (request[i].split("=")[0]) {
             case code:
                 value = request[i].split("=")[1];
                 break;
             default:
                 break;
         }
     }
return value;
}
/**
 * 获取请求URL的所有请求
 */
function getRequestParams(){
    var searchStr = decodeURI(location.search);
    
return searchStr.substr(1);
}
/**
 * 获取请求的参数code
 * @param url
 * @param code
 * @returns
 */
function geturlParm(url,code){
    var searchStr = url.substring(url.indexOf('?')+1, url.length);
     var value=null;
     var request = [];
     request = searchStr.split("&");
     //alert(request);
     for (var i = 0; i < request.length; i++) {
         switch (request[i].split("=")[0]) {
             case code:
                 value = request[i].split("=")[1];
                 break;
             default:
                 break;
         }
     }
return value;
}
/**
 * 去空格函数
 * @param str 需要去空格的字符串
 * @param is_global 规则 g 表示去掉所有空格包括 中间的空格
 * @returns
 */

function Trim(str,is_global){
	if(null==str||''==str)return;
    var result;
    result = str.replace(/(^\s+)|(\s+$)/g,"");
    if(is_global.toLowerCase()=="g")
    {
        result = result.replace(/\s/g,"");
     }
    return result;
}
/**
 * 将X 转换成16 进制  主要是用于背景颜色转换
 * @param x
 * @returns
 */
function hex(x){return("0"+parseInt(x).toString(16)).slice(-2);}
/**
 * 获取页面的事件
 * @returns
 */
function getEvent() {
	if (document.all) {
		return window.event;// 如果是ie
	}
	func = getEvent.caller;
	while (func != null) {
		var arg0 = func.arguments[0];
		if (arg0) {
			if ((arg0.constructor == Event || arg0.constructor == MouseEvent)
					|| (typeof (arg0) == "object" && arg0.preventDefault && arg0.stopPropagation)) {
				return arg0;
			}
		}
		func = func.caller;
	}
	return null;
}
/**
 * 获取颜色的16 进制代码，带#号
 * @param rgb
 * @returns {String}
 */
function getHexColor(rgb){
	rgb=rgb.match(/^rgb\((\d+),\s*(\d+),\s*(\d+)\)$/);
	return('#'+hex(rgb[1])+hex(rgb[2])+hex(rgb[3]));
}
/**
 * 当其颜色已经是其color 对应的颜色时将会重置为 白色
 * @param target
 * @param color 带#号的颜色代码
 */
function changbackgroundcolor(target,color){
	$(target).css("background-color", color);
}
/*******************************************************************************
 * 功能：判断字符串是否为空 输入：ParseString 字符串 输出：是则返回true，否则返回false
 ******************************************************************************/
function strIsEmpty(ParseString) {
    if (ParseString == null || ParseString == '' || ParseString == 'undefined') {
        return true;
    } else {
        return false;
    }
}

/**
 * 反序列化
 * @param str
 */
function unserialize(str){
    var res = {};
    if(!str){
        return res;
    }
    $.each(str.split("&"), function(i, v){
        var param = v.split('=');
        res[param[0]] = param[1];
    });
    return res;
}
