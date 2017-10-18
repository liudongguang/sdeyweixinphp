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
<title>医生列表</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/assets/css/amazeui/app_style2.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/assets/css/amazeui/amazeui.min.css" />
</head>
<body>
	<div style="background-color: #f2f2f2">
		<div
			style="background-color: #f2f2f2; position: absolute; width: 100%; height: 100%">
			<div class="now_room">
				<a class="am-list-item-hd">当前科室：</a><a class="am-list-item-text">${requestScope.ksName}</a>
				<a class="am-fr" style="margin-right: 25px !important;"
					href="${pageContext.request.contextPath }/wxpage/zjjsKSList"> <span style="color: #00bb9c;">切换科室</span>
				</a>
			</div>
			<ul class="am-list">
				<c:forEach items="${requestScope.obj}" var="obj">
					<div class="fast_find_list">
						<a name="ZM-${obj.key }">${obj.key}</a>
					</div>
					<c:forEach items="${obj.value}" var="val">
						<li
							class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-left bord_top">
							<div class="am-u-sm-3 am-list-thumb">
								<c:if test="${val.headimg!=null}">
									<a href="javascript:;" class=""> <img class="img_sty"
										src="${pageContext.request.contextPath }/${val.headimg}"
										alt="${requestScope.ksName}" />
									</a>
								</c:if>
								<c:if test="${val.headimg==null}">
									<a href="javascript:;" class=""> <img class="img_sty"
										src="${pageContext.request.contextPath }/assets/images/yslistimg.png"
										alt="${requestScope.ksName}" />
									</a>
								</c:if>
							</div>
							<div class=" am-u-sm-9 am-list-main"
								style="color: #666 !important;">
								<a ajaxdiv
									href="${pageContext.request.contextPath }/wxpage/getysxqbyYSID?ysid=${val.id}"
									class="a_sty"><span class="am-list-item-hd">${val.name}</span><span
									class="am-list-item-text dbml">${val.zhicheng}</span><br /> <span
									class="am-list-item-text">科室：</span><span
									class="am-list-item-text">${requestScope.ksName}</span><br />
									<span class="am-list-item-text">擅长：</span><span
									class="am-list-item-text">${val.zysc}</span> </a>
							</div>
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