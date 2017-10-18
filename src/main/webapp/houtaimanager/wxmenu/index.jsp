<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld"%>
<!DOCTYPE>
<html>
<head>
<base href="${pageContext.request.contextPath }/" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="format-detection" content="telephone=no">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.css" />
<link rel="stylesheet" href="assets/bootstrap/css/bootstrap-theme.css" />
<link rel="stylesheet" href="assets/css/default/style.css" />
<style>
.content {
	width: 100%;
	padding: 20px;
	background: #eee;
	overflow: auto;
}

.side_l {
	float: left;
	width: 220px;
}

.side_r {
	margin-left: 250px;
}
</style>
</head>
<body>
<input type="hidden" value="" id="levelID"/>
<input type="hidden" value="" id="caidanID"/>
	<div class="content">
		<div class="side_l">
			<button id="saveBT" class="btn btn-primary" style="margin: 2px;">保存菜单</button>
			<input id="basePath" type="hidden"
				value="${pageContext.request.contextPath }/" />
			<div id="jstree" style="margin: 20px;"></div>
		</div>
		<div id="mainDIVID" class="side_r"></div>
	</div>
</body>
<script type="text/javascript" src="assets/js/jquery3.1.0.min.js"></script>
<script type="text/javascript" src="assets/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript" src="assets/layer/layer.js"></script>
<script type="text/javascript" src="assets/js/jstree3.3.3.js"></script>
<script type="text/javascript" src="assets/js/common.js"></script>
<script type="text/javascript"
	src="assets/js/houtaimanager/wxmenu/index.js"></script>
</html>