<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld"%>
<div style="text-align: center;">
	<h3 class="am-header-title" style="color: #000 !important;">${obj.name}</h3>
</div>
<div style="padding: 0; text-align: center;">
	<c:if test="${obj.photo==null}">
		<img style="height: 160px !important; width: 100%"
			src="${pageContext.request.contextPath }/assets/images/wall.jpg">
	</c:if>
	<c:if test="${obj.photo!=null}">
		<img style="height: 160px !important; width: 100%" src="${obj.photo}">
	</c:if>
</div>
<div style="padding: 10px 0">
	<div
		style="border: solid 2px #0192c9; padding: 5px !important;">
		<div style=" border: solid 1px #0192c9">
			<span style="display: inline-block; padding: 15px; text-indent: 2em">${obj.xq}</span>
		</div>
	</div>
</div>