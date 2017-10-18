<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta name="format-detection" content="telephone=no">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新闻动态</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/bootstrap/css/bootstrap.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/bootstrap/css/bootstrap-theme.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/index.css" />
</head>
<body>
	<input value="${pageContext.request.contextPath }/" type="hidden"
		id="basePath" />
	<input type="hidden" value="${sessionScope.wxuser.nickname}"
		id="wxuserName" />
	<input type="hidden" value="${sessionScope.wxuser.openid}"
		id="openidID" />
	<input type="hidden" value="${param.code}" id="codeID" />
	<div id="containtDIV"></div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/jquery3.1.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/assets/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/assets/layer/layer.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/common.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/assets/js/weixinqianduan/xwdt.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/OAuth2.js"></script>
</html>