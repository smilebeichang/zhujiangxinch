function __CreateJSPath(js) {
    var scripts = document.getElementsByTagName("script");
    var path = "";
    for (var i = 0, l = scripts.length; i < l; i++) {
        var src = scripts[i].src;
        if (src.indexOf(js) != -1) {
            var ss = src.split(js);
            path = ss[0];
            break;
        }
    }
    var href = location.href;
    href = href.split("#")[0];
    href = href.split("?")[0];
    var ss = href.split("/");
    ss.length = ss.length - 1;
    href = ss.join("/");
    if (path.indexOf("https:") == -1 && path.indexOf("http:") == -1 && path.indexOf("file:") == -1 && path.indexOf("\/") != 0) {
        path = href + "/" + path;
    }
    return path;
}
var HostAddress={};
//赋值给HostAddress.uomp,然后在其他js页面可以直接调用
HostAddress.uomp="UOMP";
HostAddress.ui="UI";
HostAddress.bpro="BPRO";
HostAddress.omnichat="CHAT";
HostAddress.rount="ROUNT";
HostAddress.message="MESSAGE";
HostAddress.report="REPORT";
HostAddress.files="FILES";
HostAddress.kbms="KBMS";
HostAddress.batch="BATCH";
HostAddress.robot="ROBOT";
HostAddress.robot2="ROBOT2";
HostAddress.train="TRAIN";
HostAddress.monitor="MONITOR";
HostAddress.outcall="OUTCALL";
HostAddress.vet = "VET";
HostAddress.audio = "AUDIO";
HostAddress.kbmsHtml="KBMSHTML";
HostAddress.statics="static";
HostAddress.core = "CORE";
//bootPath
var bootPATH = __CreateJSPath("sunriseui.js");
//debugger,此变量用来区别ajax请求是否弹出alert来提示交互错误
mini_debugger = true;   
window['sunriseui_model']=window['sunriseui_model']||'min';
//easyUI
//document.write('<link href="' + bootPATH + '/common/js/insdep/insdep.easyui.min.css" rel="stylesheet" type="text/css" />');
////document.write('<link href="' + bootPATH + '/common/js/insdep/reset.min.css" rel="stylesheet" type="text/css" />');
////document.write('<link href="' + bootPATH + '/common/js/insdep/easyui_full.css" rel="stylesheet" type="text/css" />');
//document.write('<link href="' + bootPATH + '/common/js/insdep/icon.css" rel="stylesheet" type="text/css" />');
//document.write('<link href="' + bootPATH + '/common/js/insdep/plugin/animate-3.5.2/animate-3.5.2.css" rel="stylesheet" type="text/css" />');
//document.write('<script src="' + bootPATH + '/common/js/insdep/jquery-1.11.3.min.js" type="text/javascript"></script>');
//document.write('<script src="' + bootPATH + '/common/js/insdep/jquery.easyui-1.5.2.min.js" type="text/javascript"></script>');
//document.write('<script src="' + bootPATH + '/common/js/insdep/insdep-extend.min.js" type="text/javascript"></script>');
//
//document.write('<script src="' + bootPATH + '/common/js/json2.js" type="text/javascript"></script>');
//document.write('<script src="' + bootPATH + '/common/js/sunrise-framework.js" type="text/javascript"></script>');
//document.write('<script src="' + bootPATH + '/common/js/sunrise.js" type="text/javascript"></script>');
//document.write('<script src="' + bootPATH + '/common/js/easyui-extend.js" type="text/javascript"></script>');//easyui扩展校验js
//document.write('<script src="' + bootPATH + '/common/js/trade-utility.js" type="text/javascript"></script>');//业务公共js
//document.write('<script src="' + bootPATH + '/common/js/formatter-utility.js" type="text/javascript"></script>');//格式化方法公共js
//document.write('<script src="' + bootPATH + '/common/js/pagination-extend.js" type="text/javascript"></script>');//分页类方法公共js
//document.write('<script src="' + bootPATH + '/common/js/validateBpe.js" type="text/javascript"></script>');//BPE方法公共js
//document.write('<script src="' + bootPATH + '/common/js/socket/sockjs-0.3.min.js" type="text/javascript"></script>');//sockjs公共js
//skin
var skin = getCookie("miniuiSkin");
if (skin) {
	// document.write('<link href="' + bootPATH + 'miniui/themes/' + skin + '/skin.css" rel="stylesheet" type="text/css" />');
}

/**
 * 动态加载JS
 */
function loads(jsdirs){
	var ds=jsdirs.split(',');
	for(var i=0;i<ds.length;i++){
		load(ds[i]);
	}
}
function load(jsdir){
	switch(jsdir){
		case 'sunrise':{
			//<!-- jQuery2.2.4 -->
			document.write('<script src="' + bootPATH + '/common/bootstrap/vendors/jquery/dist/jquery.min.js"></script>');

			document.write('<script src="' + bootPATH + '/common/js/json2.js" type="text/javascript"></script>');
			document.write('<script src="' + bootPATH + '/common/js/sunrise-framework.js" type="text/javascript"></script>');
			document.write('<script src="' + bootPATH + '/common/js/sunrise.js" type="text/javascript"></script>');
			document.write('<script src="' + bootPATH + '/common/js/socket/sockjs-0.3.min.js" type="text/javascript"></script>');//sockjs公共js
			break;
		}
		case 'insdep':{
			//easyUI
			document.write('<link href="' + bootPATH + '/common/js/insdep/insdep.easyui.min.css" rel="stylesheet" type="text/css" />');
			//document.write('<link href="' + bootPATH + '/common/js/insdep/reset.min.css" rel="stylesheet" type="text/css" />');
			//document.write('<link href="' + bootPATH + '/common/js/insdep/easyui_full.css" rel="stylesheet" type="text/css" />');
			document.write('<link href="' + bootPATH + '/common/js/insdep/icon.css" rel="stylesheet" type="text/css" />');
			document.write('<link href="' + bootPATH + '/common/js/insdep/plugin/animate-3.5.2/animate-3.5.2.css" rel="stylesheet" type="text/css" />');
			document.write('<script src="' + bootPATH + '/common/js/insdep/jquery-1.11.3.min.js" type="text/javascript"></script>');
			document.write('<script src="' + bootPATH + '/common/js/insdep/jquery.easyui-1.5.2.min.js" type="text/javascript"></script>');
			document.write('<script src="' + bootPATH + '/common/js/insdep/insdep-extend.min.js" type="text/javascript"></script>');

			document.write('<script src="' + bootPATH + '/common/js/json2.js" type="text/javascript"></script>');
			document.write('<script src="' + bootPATH + '/common/js/sunrise-framework.js" type="text/javascript"></script>');
			document.write('<script src="' + bootPATH + '/common/js/sunrise.js" type="text/javascript"></script>');
			document.write('<script src="' + bootPATH + '/common/js/easyui-extend.js" type="text/javascript"></script>');//easyui扩展校验js
			document.write('<script src="' + bootPATH + '/common/js/trade-utility.js" type="text/javascript"></script>');//业务公共js
			document.write('<script src="' + bootPATH + '/common/js/formatter-utility.js" type="text/javascript"></script>');//格式化方法公共js
			document.write('<script src="' + bootPATH + '/common/js/pagination-extend.js" type="text/javascript"></script>');//分页类方法公共js
			document.write('<script src="' + bootPATH + '/common/js/validateBpe.js" type="text/javascript"></script>');//BPE方法公共js
			document.write('<script src="' + bootPATH + '/common/js/socket/sockjs-0.3.min.js" type="text/javascript"></script>');//sockjs公共js
			break;
		}
		case 'bootstrap-css':{
			//<!-- Bootstrap -->
			document.write('<link href="' + bootPATH + '/common/bootstrap/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">');
			//<!-- Font Awesome -->
			document.write('<link href="' + bootPATH + '/common/bootstrap/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">');
			//<!-- NProgress -->
			document.write('<link href="' + bootPATH + '/common/bootstrap/vendors/nprogress/nprogress.css" rel="stylesheet">');
			//<!-- iCheck -->
			document.write('<link href="' + bootPATH + '/common/bootstrap/vendors/iCheck/skins/flat/green.css" rel="stylesheet">');
			//<!-- bootstrap-progressbar -->
			document.write('<link href="' + bootPATH + '/common/bootstrap/vendors/bootstrap-progressbar/css/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet">');
			//<!-- JQVMap -->
			document.write('<link href="' + bootPATH + '/common/bootstrap/vendors/jqvmap/dist/jqvmap.min.css" rel="stylesheet"/>');
			//<!-- bootstrap-daterangepicker -->
			document.write('<link href="' + bootPATH + '/common/bootstrap/vendors/bootstrap-daterangepicker/daterangepicker.css" rel="stylesheet">');
			//<!-- Custom Theme Style -->
			document.write('<link href="' + bootPATH + '/common/bootstrap/build/css/custom.min.css" rel="stylesheet">');
			break;
		}
		case 'bootstrap-js':{
			//<!-- jQuery2.2.4 -->
//			document.write('<script src="' + bootPATH + '/common/bootstrap/vendors/jquery/dist/jquery.min.js"></script>');
			//<!-- Bootstrap -->
			document.write('<script src="' + bootPATH + '/common/bootstrap/vendors/bootstrap/dist/js/bootstrap.min.js"></script>');
			//<!-- FastClick -->
			document.write('<script src="' + bootPATH + '/common/bootstrap/vendors/fastclick/lib/fastclick.js"></script>');
			//<!-- NProgress -->
			document.write('<script src="' + bootPATH + '/common/bootstrap/vendors/nprogress/nprogress.js"></script>');
			//<!-- Chart.js -->
			document.write('<script src="' + bootPATH + '/common/bootstrap/vendors/Chart.js/dist/Chart.min.js"></script>');
			//<!-- gauge.js -->
			document.write('<script src="' + bootPATH + '/common/bootstrap/vendors/gauge.js/dist/gauge.min.js"></script>');
			//<!-- bootstrap-progressbar -->
			document.write('<script src="' + bootPATH + '/common/bootstrap/vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>');
			//<!-- iCheck -->
			document.write('<script src="' + bootPATH + '/common/bootstrap/vendors/iCheck/icheck.min.js"></script>');
			//<!-- Skycons -->
			document.write('<script src="' + bootPATH + '/common/bootstrap/vendors/skycons/skycons.js"></script>');
			//<!-- Flot -->
			document.write('<script src="' + bootPATH + '/common/bootstrap/vendors/Flot/jquery.flot.js"></script>');
			document.write('<script src="' + bootPATH + '/common/bootstrap/vendors/Flot/jquery.flot.pie.js"></script>');
			document.write('<script src="' + bootPATH + '/common/bootstrap/vendors/Flot/jquery.flot.time.js"></script>');
			document.write('<script src="' + bootPATH + '/common/bootstrap/vendors/Flot/jquery.flot.stack.js"></script>');
			document.write('<script src="' + bootPATH + '/common/bootstrap/vendors/Flot/jquery.flot.resize.js"></script>');
			//<!-- Flot plugins -->
			document.write('<script src="' + bootPATH + '/common/bootstrap/vendors/flot.orderbars/js/jquery.flot.orderBars.js"></script>');
			document.write('<script src="' + bootPATH + '/common/bootstrap/vendors/flot-spline/js/jquery.flot.spline.min.js"></script>');
			document.write('<script src="' + bootPATH + '/common/bootstrap/vendors/flot.curvedlines/curvedLines.js"></script>');
			//<!-- DateJS -->
			document.write('<script src="' + bootPATH + '/common/bootstrap/vendors/DateJS/build/date.js"></script>');
			//<!-- JQVMap -->
			document.write('<script src="' + bootPATH + '/common/bootstrap/vendors/jqvmap/dist/jquery.vmap.js"></script>');
			document.write('<script src="' + bootPATH + '/common/bootstrap/vendors/jqvmap/dist/maps/jquery.vmap.world.js"></script>');
			document.write('<script src="' + bootPATH + '/common/bootstrap/vendors/jqvmap/examples/js/jquery.vmap.sampledata.js"></script>');
			//<!-- bootstrap-daterangepicker -->
			document.write('<script src="' + bootPATH + '/common/bootstrap/vendors/moment/min/moment.min.js"></script>');
			document.write('<script src="' + bootPATH + '/common/bootstrap/vendors/bootstrap-daterangepicker/daterangepicker.js"></script>');
			//<!-- Custom Theme Scripts -->
			document.write('<script src="' + bootPATH + '/common/bootstrap/build/js/custom.min.js"></script>');
			
//			document.write('<script src="' + bootPATH + '/common/js/json2.js" type="text/javascript"></script>');
//			document.write('<script src="' + bootPATH + '/common/js/sunrise-framework.js" type="text/javascript"></script>');
//			document.write('<script src="' + bootPATH + '/common/js/sunrise.js" type="text/javascript"></script>');
//			document.write('<script src="' + bootPATH + '/common/js/socket/sockjs-0.3.min.js" type="text/javascript"></script>');//sockjs公共js
			break;
		}
		case 'fullcalendar':{
			document.write('<script src="' + bootPATH + '/common/js/fullcalendar-2.3.2/lib/moment.min.js" type="text/javascript"></script>');
			document.write('<script src="' + bootPATH + '/common/js/fullcalendar-2.3.2/fullcalendar.js" type="text/javascript"></script>');
			document.write('<script src="' + bootPATH + '/common/js/fullcalendar-2.3.2/lang/zh-cn.js" type="text/javascript"></script>');
			document.write('<link href="' + bootPATH + '/common/js/fullcalendar-2.3.2/fullcalendar.css" rel="stylesheet" type="text/css" />');
			document.write('<link href="' + bootPATH + '/common/js/fullcalendar-2.3.2/fullcalendar.print.css" rel="stylesheet" media="print" />');
			break;
		}
		case 'kindeditor':{
			document.write('<script src="' + bootPATH + '/common/js/kindeditor-4.1.10/kindeditor-all.js" type="text/javascript"></script>');
			document.write('<script src="' + bootPATH + '/common/js/kindeditor-4.1.10/lang/zh_CN.js" type="text/javascript"></script>');
			break;
		}
		case 'd3':{
			document.write('<script src="' + bootPATH + '/common/d3/d3.v4.min.js" type="text/javascript"></script>');
			document.write('<script src="' + bootPATH + '/common/d3/dagre-d3.js" type="text/javascript"></script>');
			break;
		}
		case 'highcharts':{
			document.write('<script src="' + bootPATH + '/common/js/highcharts-4.1.6/js/highcharts.js" type="text/javascript"></script>');
			document.write('<script src="' + bootPATH + '/common/js/highcharts-4.1.6/js/highcharts-3d.js" type="text/javascript"></script>');
			document.write('<script src="' + bootPATH + '/common/js/highcharts-4.1.6/js/highcharts-more.js" type="text/javascript"></script>');
			document.write('<script src="' + bootPATH + '/common/js/highcharts-4.1.6/js/modules/exporting.js" type="text/javascript"></script>');
			document.write('<script src="' + bootPATH + '/common/js/highcharts-4.1.6/js/highcharts-zh_CN.js" type="text/javascript"></script>');
			break;
		}
		case 'portal':{
			document.write('<script src="' + bootPATH + '/common/js/easyui1.4.4/jquery.portal.js" type="text/javascript"></script>');
			document.write('<link href="' + bootPATH + '/common/js/easyui1.4.4/themes/portal.css" rel="stylesheet" type="text/css" />');
			break;
		}
		case 'tablecloth':{
			document.write('<script src="' + bootPATH + '/common/js/tablecloth/tablecloth.js" type="text/javascript"></script>');
			document.write('<link href="' + bootPATH + '/common/js/tablecloth/tablecloth.css" rel="stylesheet" type="text/css" />');
			break;
		}
		case 'datagrid-detailview':{
			document.write('<script src="' + bootPATH + '/common/js/easyui1.4.4/datagrid-detailview.js" type="text/javascript"></script>');
			break;
		}
		case 'dwrengine':{
			document.write('<script src="' + omnichatPATH + '/omnichat/dwr/engine.js" type="text/javascript"></script>');
			document.write('<script src="' + omnichatPATH + '/omnichat/dwr/util.js" type="text/javascript"></script>');
			break;
		}
		case 'agentConsole':{
			document.write('<script src="' + omnichatPATH + '/omnichat/dwr/interface/AgentConsole.js" type="text/javascript"></script>');
			break;
		}
		case 'agentwebchat':{
			document.write('<script src="' + omnichatPATH + '/omnichat/dwr/interface/AgentScript.js" type="text/javascript"></script>');
			break;
		}
		case 'ajaxfileupload':{
			document.write('<script src="/js/ajaxfileupload.js" type="text/javascript"></script>');
			break;
		}

		case 'security':{
			document.write('<script src="' + bootPATH + '/common/js/rsa/security.js" type="text/javascript"></script>');
			break;
		}
		case 'ueditor':{
            document.write('<script src="'  + '../js/ueditor/ueditor.config.js" type="text/javascript"></script>');
            document.write('<script src="'  + '../js/ueditor/ueditor.all.min.js" type="text/javascript"></script>');
            document.write('<script src="'  + '../js/ueditor/lang/zh-cn/zh-cn.js" type="text/javascript"></script>');
            break;
        }
		case 'echarts':{
//			document.write('<script src="' + bootPATH + '/common/js/echarts/echarts.common.min.js" type="text/javascript"></script>');
//			document.write('<script src="' + bootPATH + '/common/js/echarts/echarts.js" type="text/javascript"></script>');
			document.write('<script src="' + bootPATH + '/common/js/echarts/echarts.min.js" type="text/javascript"></script>');
//			document.write('<script src="' + bootPATH + '/common/js/echarts/echarts.simple.min.js" type="text/javascript"></script>');
			break;
		}
		default:{
			break;
		}
	}
}
/**
 根据hostAddressSign 获取到 hostAddress
 */
function getHost(hostAddressSign){
    switch(hostAddressSign){
    	case 'UOMP':{
	        return "http://10.132.4.108:8080";
	        break;
    	}
	    case 'IQC':{
	    	return "${host.url.iqc}";
	        break;
	    }
	    case 'TRAIN':{
			return "${host.url.train}";
            break;
        }
	    case 'BATCH':{
            return "${host.url.batch}";
            break;
        }
        case 'KBMS':{
        	return "http://127.0.0.1:8083";
            break;
        }
        case 'BPRO':{
        	return "${host.url.bpro}";
            break;
        }
        case 'MONITOR':{
        	return "${host.url.monitor}";
            break;
        }
        case 'ROBOT':{
        	return "http://127.0.0.1:8082";
            break;
        }
        case 'ROBOT2':{
            return "http://127.0.0.1:8087";
            break;
        }
        case 'MESSAGE':{
        	return "${host.url.message}";
            break;
        }
        case 'CHAT':{
        	return "${host.url.chat}";
            break;
        }
        case 'ROUNT':{
        	return "${host.url.rount}";
            break;
        }
        case 'UI':{
            return "http://127.0.0.1:80";
            break;
        }
        case 'REPORT':{
            return "${host.url.report}";
            break;
        }
		case 'VET': {
			return "${host.url.vet}";
			break;
		}
		case 'AUDIO': {
			return "${host.url.audio}";
			break;
		}
		case 'KBMSHTML': {
			return "${host.url.kbmsHtml}";
			break;
		}
		case 'static': {
			return "${host.url.static}";
			break;
		}
		case 'CORE': {
			return "${host.url.core}";
			break;
		}
    }
}

////////////////////////////////////////////////////////////////////////////////////////
function getCookie(sName) {
    var aCookie = document.cookie.split("; ");
    var lastMatch = null;
    for (var i = 0; i < aCookie.length; i++) {
        var aCrumb = aCookie[i].split("=");
        if (sName == aCrumb[0]) {
            lastMatch = aCrumb;
        }
    }
    if (lastMatch) {
        var v = lastMatch[1];
        if (v === undefined) return v;
        return unescape(v);
    }
    return null;
}
function showEvent(message){
	console.log(message);
}
//window['nui']=window['mini'];