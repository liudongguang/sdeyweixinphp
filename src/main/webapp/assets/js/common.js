var basePath = $("#basePath").val();
var jumpPageLayerNum = null;

function jumpPageForWXNoAjax(pageUrl) {
	location.href = basePath + pageUrl;
}
// 微信跳转页面
function jumpPageForWX(pageUrl, jq_container) {
	// /
	var param = {
		paramurl : basePath + 'weixinConfig/jumpPage',
		paramdata : {
			pageUrl : pageUrl
		},
		dataType : 'html',
		callbackFun : function(data) {
			var dataobj = isJson(data);
			if (dataobj) {// 是json格式
				if (dataobj.errorCode != 0) {					
					layer.close(ii);
					layer.alert(dataobj.errorMsg);
					return false;
				}
			}
			layer.alert("处理成功！");
			jq_container.empty().html(data);
		}
	}
	ajaxRun(param);
	// //
}
// 跳转页面
function jumpPage(pageUrl, jq_container) {
	// /
	var param = {
		paramurl : basePath + 'sdeymanager/jumpPage',
		paramdata : {
			pageUrl : pageUrl
		},
		dataType : 'html',
		callbackFun : function(data) {
			var dataobj = isJson(data);
			if (dataobj) {// 是json格式
				if (dataobj.errorCode != 0) {
					layer.close(ii);
					layer.alert(dataobj.errorMsg);
					return false;
				}
			}
			jq_container.empty().html(data);
		}
	}
	ajaxRun(param);
	// //
}
// 弹出窗口
function layerWindow(pageUrl, title, width, height) {
	var param = {
		paramurl : basePath + 'sdeymanager/jumpPage',
		paramdata : {
			pageUrl : pageUrl
		},
		dataType : 'html',
		callbackFun : function(data) {
			var dataobj = isJson(data);
			if (dataobj) {// 是json格式
				if (dataobj.errorCode != 0) {
					layer.alert(dataobj.errorMsg);
					return false;
				}
			}
			jumpPageLayerNum = layer.open({
				type : 1,
				title : title,
				skin : 'layui-layer-rim', // 加上边框
				area : [ width + 'px', height + 'px' ], // 宽高
				content : data,
				success : function(index, layero) {
					// do something
					// layer.close(index); // 如果设定了yes回调，需进行手工关闭
					// layer.close(ii);
				}
			});
		}
	}
	ajaxRun(param);
	// /////////////////////////
}
// //初始化分页的连接 ajax化
function initAjaxPage(pagedivID,jq_ThisContent) {
	var jqa = $("#" + pagedivID + " a[href!='javascript:;']");
	jqa.click(function() {
		var thisA = $(this);
		var pageUrl = thisA.attr("href");
		jumpPageForWX(pageUrl,jq_ThisContent);
		return false;
	});
}

// /////让form ajax提交
function initAjaxForm(excuteResponse) {
	// 禁止回车提交
	$("#submitForm").submit(function() {
		return false;
	});
	var zzcid = null;
	$(
			'#submitForm input[type="text"], .login-form input[type="password"], .login-form textarea')
			.on('focus', function() {
				$(this).removeClass('input-error');
			});
	function showResponse(data) {
		// $("#realContentId").empty().html(data);
		if (data.errorCode&&data.errorCode != 0) {
			layer.close(zzcid);
			layer.alert(data.errorMsg);
			return false;
		} else {
			excuteResponse(data);
			layer.close(zzcid);
			layer.close(jumpPageLayerNum);
		}
	}
	function showRequest() {
		var validate = true;
		$("#submitForm").find(
				'input[type="text"], input[type="password"], textarea').each(
				function() {
					if ($(this).val() == "") {
						var thisValidate = $(this);
						thisValidate.addClass('input-error');
						var tishi = thisValidate.attr("placeholder");
						layer.alert(tishi, {
							skin : 'layui-layer-error', // 样式类名
							title : '错误提示',
							closeBtn : 0,
							shadeClose : true,
							yes : function(index, layero) {
								layer.close(zzcid);
								layer.close(index);
							}
						});
						validate = false;
						return false;
					} else {
						$(this).removeClass('input-error');
					}
				});
		return validate;
	}
	function formSubError(errorData) {
		layer.close(zzcid);
		layer.close(jumpPageLayerNum);
		layer.alert("服务器出错！");
	}
	var options = {
		// target : '#mydiv', // 需要刷新的区域
		beforeSubmit : showRequest, // 提交前调用的方法
		success : showResponse, // 成功回调方法
		error : formSubError
	// 提交form失败调用的函数

	// other available options:
	// url : 'test/testTransaction', // 提交的URL, 默认使用FORM ACTION
	// type: type // 'get' or 'post', override for form's 'method' attribute
	// dataType : 'json' // 'xml', 'script', or 'json' (expected server
	// response type)
	// clearForm: true // 是否清空form
	// resetForm: true // 是否重置form

	// $.ajax options can be used here too, for example:
	// timeout: 3000
	}
	$("#submitBTID").click(function() {
		zzcid = layer.load(0, {
			shade : [ 0.8, '#fff' ]
		// 0.1透明度的白色背景
		});
		$("#submitForm").ajaxSubmit(options);
		return false;
	});
}
// //////////////////////////////////显示图片
function initDisplayImg(inputFileID, imageDIVID) {
	var input = document.getElementById(inputFileID); // 获取选择图片的input元素
	var imgdiv = document.getElementById(imageDIVID); // 获取显示图片的div元素
	// 这边是判断本浏览器是否支持这个API。
	if (typeof FileReader === 'undefined') {
		imgdiv.innerHTML = "抱歉，你的浏览器不支持 FileReader";
		input.setAttribute('disabled', 'disabled');
	} else {
		input.addEventListener('change', readFile, false); // 如果支持就监听改变事件，一旦改变了就运行readFile函数。
	}
	function readFile() {
		var file = this.files[0]; // 获取file对象
		// 判断file的类型是不是图片类型。
		if (!/image\/\w+/.test(file.type)) {
			alert("文件必须为图片！");
			return false;
		}
		var reader = new FileReader(); // 声明一个FileReader实例
		reader.readAsDataURL(file); // 调用readAsDataURL方法来读取选中的图像文件
		// 最后在onload事件中，获取到成功读取的文件内容，并以插入一个img节点的方式显示选中的图片
		reader.onload = function(e) {
			imgdiv.innerHTML = '<img src="' + this.result
					+ '" alt="" style="width: 200px;height: 200px;"/>'
		}
	}
}
function initTable(jq_ThisContent) {
	// 隔行换色
	$("tr:odd").css("background-color", "#eeeeee");
	$("tr:even").css("background-color", "#ffffff");
	// 鼠标经过颜色变换
	$("tr").bind("mouseover", function() {
		var jq_this = $(this);
		var oldColor = jq_this.css("background-color");
		jq_this.attr("oldcolor", oldColor);
		jq_this.css("background-color", "#BCD2EE");
	});
	$("tr").bind("mouseout", function() {
		var oldColor = $(this).attr("oldcolor");
		$(this).css("background-color", oldColor);
	});
	// ////初始化增加按钮操作
	$("button[tanchu]").click(function() {
		var href = $(this).attr("myurl");
		var title = $(this).attr("title");
		var width = $(this).attr("width");
		var height = $(this).attr("height");
		layerWindow(href, title, width, height);
		return false;
	});
	$("button[notTanchu]").click(function() {
		var href = $(this).attr("myurl");
		jumpPageForWX(href, $("#neirong"));
		return false;
	});

	$("button[notTanchu_title]").click(function() {
		var href = $(this).attr("myurl");
		var titleVal = $(this).attr("title");
		$("#titleID").text(titleVal);
		jumpPageForWX(href, jq_ThisContent);
		return false;
	});

	// ///初始化page按钮
	initAjaxPage('pageDIV',jq_ThisContent);
	// ///初始化编辑，使用的layer弹出框
	$("a[ajax]").click(function() {
		var href = $(this).attr("href");
		var title = $(this).attr("title");
		var width = $(this).attr("width");
		var height = $(this).attr("height");
		layerWindow(href, title, width, height);
		return false;
	})

	// ///
	$("a[ajaxdel]").click(function() {
		var hrefurl = $(this).attr("href");
		layer.confirm('确定删除吗？', {
			btn : [ '确定' ]
		// 按钮
		}, function(index) {
			jumpPageForWX(hrefurl, jq_ThisContent);
			layer.close(index)
		});
		return false;
	})

	// /// 当前主页面打开
	$("a[ajaxthispage]").click(function() {
		var href = $(this).attr("href");
		jumpPageForWX(href,jq_ThisContent);
		return false;
	})
	// /// 当前主页面打开，附带标题
	$("a[ajaxthispage_title]").click(function() {
		var href = $(this).attr("href");
		var titleVal = $(this).attr("title");
		$("#titleID").text(titleVal);
		jumpPageForWX(href, jq_ThisContent);
		return false;
	})
}
function initSelect() {
	var jq_selects = $("select");
	jq_selects.each(function() {
		var jq_select = $(this);
		var name = jq_select.attr("name");
		var ajaxURL = jq_select.attr("ajaxURL");
		var jq_select_inputVal = $("#" + name + "_input").val();
		// /
		var param = {
			paramurl : ajaxURL,
			paramdata : null,
			dataType : 'json',
			callbackFun : function(data) {
				if (data.errorCode != 0) {
					layer.close(ii);
					layer.alert(dataobj.errorMsg);
					return false;
				}
				var list = data.data.list;
				var jq_opt = $("<option></option>");
				jq_opt.val('');
				jq_opt.text('---请选择---');
				jq_select.append(jq_opt);
				for (var i = 0; i < list.length; i++) {
					var obj = list[i];
					var jq_opt = $("<option></option>");
					jq_opt.val(obj.id);
					jq_opt.text(obj.name);
					jq_select.append(jq_opt);
				}
				if (jq_select_inputVal) { // 赋值操作
					jq_select.val(jq_select_inputVal);
				}
			}
		}
		ajaxRun(param);
		// //
	});
}
// 是否是json，是的话返回json对象
function isJson(data) {
	if (typeof (data) == 'object') {
		return data;
	}
	try {
		var jsonObj = jQuery.parseJSON(data);
		return jsonObj;
	} catch (e) {
		// alert(e.message);
		return null;
	}
	return null;
}
// ajax方式请求
function ajaxRun(param) {
	var ii = layer.load(0, {
		shade : [ 0.8, '#fff' ]
	// 0.1透明度的白色背景
	});
	var paramurl = param.paramurl;
	var paramdata = param.paramdata;
	var callbackFun = param.callbackFun;
	var serverDataType = param.serverDataType;
	// /////////////////////////
	var request = $.ajax({
		url : paramurl,
		data : paramdata,
		method : "POST",
		dataType : serverDataType,
		statusCode : {
			404 : function() {
				layer.alert("无此页面");

			},
			500 : function() {
				layer.alert("代码出错");
			}
		}
	});
	request.done(function(data) {
		callbackFun(data);
		layer.close(ii);
	});
	request.fail(function(jqXHR, textStatus) {
		layer.alert("Request failed: " + textStatus);
		layer.close(ii);
	});
	// ///////////////
}
// 对Date的扩展，将 Date 转化为指定格式的String
// 月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符，
// 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)
// 例子：
// (new Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423
// (new Date()).Format("yyyy-M-d h:m:s.S") ==> 2006-7-2 8:9:4.18
Date.prototype.format = function(fmt)   
{ // author: meizz
var o = {   
 "M+" : this.getMonth()+1,                 // 月份
 "d+" : this.getDate(),                    // 日
 "h+" : this.getHours(),                   // 小时
 "m+" : this.getMinutes(),                 // 分
 "s+" : this.getSeconds(),                 // 秒
 "q+" : Math.floor((this.getMonth()+3)/3), // 季度
 "S"  : this.getMilliseconds()             // 毫秒
};   
if(/(y+)/.test(fmt))   
 fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));   
for(var k in o)   
 if(new RegExp("("+ k +")").test(fmt))   
fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));   
return fmt;   
} 
function fmtDateByHaomiao(haomiao){
	var myDate=new Date()
	myDate.setTime(haomiao);
	return myDate.format("yyyy-MM-dd");
}
