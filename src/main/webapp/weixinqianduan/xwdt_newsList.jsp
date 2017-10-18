<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>新闻动态</title>
<meta name="description" content="">
<meta name="keywords" content="">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta name="renderer" content="webkit">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/assets/bootstrap/css/bootstrap.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/assets/bootstrap/css/bootstrap-theme.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/assets/iscroll/iscroll.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/assets/css/xwdt_newsList.css" />
</head>
<body>
	<div class="col-xs-12">
		<h4 class="n_title">
			<span class="n_title_span">新闻动态</span>
		</h4>
	</div>
	<div class="banner col-xs-12">
		<img
			src="${pageContext.request.contextPath }/assets/images/HospitalImage.jpg"
			class="img-responsive" alt="Responsive image">
	</div>
	<div id="wrapper">
		<div id="scroller">
			<div id="pullDown" style="display: none;">
				<span>下拉刷新…</span>
			</div>
			<ul id="list" class="list-unstyled news_items">
				<c:forEach items="${requestScope.obj.list}" var="obj">
					<li><a
						href="${pageContext.request.contextPath }/wxpage/getXwdtByID?id=${obj.id}"><span
							class="point">•</span>${obj.title}</a> <span class="n_time"><fmt:formatDate
								value="${obj.createtime}" pattern=" yyyy-MM-dd" /></span></li>
				</c:forEach>
			</ul>
			<div id="pullUp" style="display: none;">
				<span>上拉加载更多…</span>
			</div>
		</div>
	</div>
	<footer>
		<div class="col-xs-12">
			<img class="img-responsive"
				src="${pageContext.request.contextPath}/assets/images/bot.jpg">
		</div>
	</footer>

	<input id="ksid" type="hidden" value="${requestScope.ksid}" />
	<input id="pageNum" type="hidden" value="${requestScope.obj.pageNum}" />
	<input id="pages" type="hidden" value="${requestScope.obj.pages}" />
	<input id="basePath" type="hidden"
		value="${pageContext.request.contextPath }" />
</body>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/assets/iscroll/iscroll-probe.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/assets/js/jquery3.1.0.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/assets/iscroll/iscrollComm.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/assets/layer/layer.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/assets/js/common.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/assets/js/weixinqianduan/xwdt_newsList.js"></script>
</html>
