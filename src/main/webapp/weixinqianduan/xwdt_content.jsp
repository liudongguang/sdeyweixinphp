<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
<!doctype html>
<html class="no-js">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>就诊流程</title>
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
	href="${pageContext.request.contextPath }/assets/css/amazeui/app_style1.css">
<style>
.divout {
	padding: 15px;
}

.p_tit {
	text-align: left;
	color: #5b5b5b;
	font-size: 18px;
	font-family: 宋体, SimSun;
}

.p_lit {
	text-align: left;
	color: #909090;
	font-size: 12px;
}

.div_pic {
	padding: 5px 0 10px 0;
}

.img_pic {
	width: 100%;
	border-radius: 5px;
}

.p_txt {
	color: #7f7f7f;
	/*border: dashed 3px #c0c8d1;*/
	/*border-radius: 5px;*/
	/*background-color: #efefef;*/
	padding: 5px;
	text-align: justify;
	text-justify: inter-ideograph;
	font-size: 14px;
}

.p_txt_span {
	font-family: 等线;
	font-size: 14px;
}
</style>
</head>
<body style="background-color: #f2f2f2">
	<div class="divout">
		<p>
			<span class="p_tit">${obj.title}</span>
		</p>
		<p>
			<span class="p_lit"><fmt:formatDate value="${obj.createtime}"
					pattern=" yyyy-MM-dd" /></span>
		</p>
		<div>${obj.content}</div>
	</div>
</body>
</html>