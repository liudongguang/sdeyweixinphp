<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld"%>
<!doctype html>
<html class="no-js">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>专家主页</title>
<meta name="description" content="">
<meta name="keywords" content="">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/assets/css/amazeui/amazeui.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/assets/css/amazeui/app.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/assets/css/amazeui/app_style2.css">
</head>
<body style="background-color: #f2f2f2">
	<!--用户部分开始-->
	<div
		style="background-color: #f2f2f2; position: absolute; width: 100%; height: 100%">
		<ul class="am-list">
			<li
				class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-left bord_top">
				<div class="am-u-sm-3 am-list-thumb">
					<c:if test="${obj.headimg==null}">
						<a href="javascript:;" class=""> <img
							style="display: inline-block; margin-left: 15px !important; border-radius: 50%"
							src="${pageContext.request.contextPath }/assets/images/yslistimg.png"
							alt="${obj.name}" />
						</a>
					</c:if>
					<c:if test="${obj.headimg!=null}">
						<a href="javascript:;" class=""> <img class="img_sty"
							style="display: inline-block; margin-left: 15px !important; border-radius: 50%"
							src="${pageContext.request.contextPath }/${obj.headimg}"
							alt="${obj.name}" />
						</a>
					</c:if>

				</div>
				<div class=" am-u-sm-9 am-list-main" style="color: #666 !important;">
					<a href="#" class="a_sty2"><span class="am-list-item-hd">${obj.name}</span><span
						class="am-list-item-text dbml">${obj.zhicheng}</span><br /> <span
						class="am-list-item-text">${obj.hospitalName}</span><span
						class="am-list-item-text dbml">${obj.keshiName}</span> </a>
				</div>
			</li>
		</ul>
		<div class="bot_div"></div>
		<section style="background-color: #fff" data-am-widget="accordion"
			class="am-accordion am-accordion-gapped" data-am-accordion='{  }'>
			<dl class="am-accordion-item">
				<dt class="am-accordion-title">社会兼职</dt>
				<dd class="am-accordion-bd am-collapse ">
					<div class="am-accordion-content">${obj.shjz}</div>
				</dd>
			</dl>
			<div class="fast_find_list"></div>
			<dl class="am-accordion-item">
				<dt class="am-accordion-title">专业擅长</dt>
				<dd class="am-accordion-bd am-collapse ">
					<div class="am-accordion-content">${obj.zysc}</div>
				</dd>
			</dl>
			<div class="fast_find_list"></div>
			<dl class="am-accordion-item">
				<dt class="am-accordion-title">详细介绍</dt>
				<dd class="am-accordion-bd am-collapse ">
					<div class="am-accordion-content">${obj.xxnr}</div>
				</dd>
			</dl>
		</section>
		<!--垫一下菜单空缺-->
		<!--<div style="width: 100%;height: 50px;position: absolute;background-color: #f2f2f2"></div>-->
	</div>
	<!--用户部分结束-->
	<script src="${pageContext.request.contextPath }/assets/js/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath }/assets/js/amazeui.min.js"></script>
	<script>
		$(".date_block").click(function() {
			$(this).css("background", "#009cda");
			$(this).css("color", "#fff");
		})
	</script>
</body>
</html>