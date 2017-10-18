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
<title>专家科室列表</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/assets/css/amazeui/app_style.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/assets/css/amazeui/amazeui.min.css" />
</head>
<body>
	<div style="background-color: #f2f2f2">
		<div
			style="background-color: #f2f2f2; position: absolute; width: 100%; height: 100%">
			<ul class="am-list">
				<c:forEach items="${requestScope.obj}" var="obj">
					<div class="fast_find_list">
						<a name="ZM-${obj.key }">${obj.key}</a>
					</div>
					<c:forEach items="${obj.value}" var="val">
						<li
							class="am-g am-list-item-dated sy_ul_li_border border_bottom_show">
							<a ajaxdiv
							href="${pageContext.request.contextPath }/wxpage/getXwdtListbyKSID?ksid=${val.id}&ksName=${val.name}"
							class="am-list-item-hd sy_wo_li_a">${val.name}</a>
						</li>
					</c:forEach>
				</c:forEach>
			</ul>
			<div class="fast_find">
				<c:forEach items="${requestScope.obj}" var="zmobj">
					<span><a href="#ZM-${zmobj.key}">${zmobj.key}</a></span>
					<br />
				</c:forEach>
			</div>
		</div>
	</div>
</body>
</html>
