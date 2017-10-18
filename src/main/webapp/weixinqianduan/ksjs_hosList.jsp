<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/assets/css/amazeui/app_style.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/assets/css/amazeui/amazeui.min.css" />
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
						href="/wxpage/getksjsbyID?ksid=${val.id}"
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
<script type="text/javascript"
	src="${pageContext.request.contextPath }/assets/js/weixinqianduan/common.js"></script>
