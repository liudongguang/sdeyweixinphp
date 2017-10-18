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
<link rel="stylesheet" href="assets/css/index.css" />
</head>
<body>
	<input value="${pageContext.request.contextPath }/" type="hidden"
		id="basePath" />
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<span class="navbar-brand">微信后台管理系统</span>
			</div>
			<div class="floatRight navbar-brand font14">
				<span class="text-primary">欢迎登陆,${sessionScope.loginManager.name}</span>
				<a href="sdeymanager/login_out"> <span
					class="text-danger marginLeft20">退出</span></a>
			</div>
		</div>
	</nav>
	<div class="container top70">
		<div class="row">
			<div class="col-md-3">
				<div class="panel-group" id="accordion">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h4 class="panel-title">
								<a href="#collapse1" data-toggle="collapse"
									data-parent="#accordion">微信管理</a>
							</h4>
						</div>
						<div id="collapse1" class="panel-collapse collapse in">
							<div class="panel-body">
								<!-- start -->
								<div class="list-group">
									<a class="list-group-item list-group-item-info marginBottom3"
										href="/weixinConfig/getCaiDanList">自定义菜单</a>
								</div>
								<!-- end -->
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-9">
				<div class="ldgMainTitle">
					<h4 id="titleID"></h4>
				</div>
				<div id="neirong"></div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="assets/js/jquery3.1.0.min.js"></script>
<script type="text/javascript" src="assets/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript" src="assets/layer/layer.js"></script>
<script type="text/javascript" src="assets/js/common.js"></script>
<script type="text/javascript" src="assets/js/houtaimanager/index.js"></script>
<script type="text/javascript" src="assets/js/ajaxsessiontimeout.js"></script>
</html>