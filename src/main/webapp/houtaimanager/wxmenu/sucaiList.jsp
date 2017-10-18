<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="page" uri="/WEB-INF/tld/pagerForBootStrap.tld"%>
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
<title>素材列表</title>

</head>
<body>
	<button class="btn btn-primary" id="addSCBT">增加素材</button>
	<br />
	<br />
	<table class="table  table-bordered">
		<thead>
			<tr>
				<th>标题</th>
				<th>简介</th>
				<th>图片</th>
				<th>关联菜单</th>
				<th width="10%">连接</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page.list}" var="l">
				<tr>
					<td>${l.title}</td>
					<td>${l.jianjie}</td>
					<td><img width="100px" height="50px" alt="" src="${l.imgpath}"></td>
					<td>${l.menukey}</td>
					<td><div style="width:200px; white-space:nowrap;overflow:hidden;text-overflow:ellipsis;">${l.linkurl}</div></td>
					<td><a class="aa" title="编辑" ajaxthispage
						href="/houtaimanager/wxmenu/addSucai.jsp?id=${l.id}&imgpath=${l.imgpath}&title=${l.title}&jianjie=${l.jianjie}&linkurl=${l.linkurl}"><span>编辑</span></a>&nbsp;&nbsp;&nbsp;&nbsp;
						<a class="aa" title="删除" ajaxdel
						href="/weixinConfig/delSCByID?id=${l.id}&imgpath=${l.imgpath}"><span>删除</span></a>&nbsp;&nbsp;&nbsp;&nbsp;<a
						guanlian class="aa" title="关联"
						href="/weixinConfig/guanlianSCByID?id=${l.id}"><span>关联</span></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div id="pageDIV" class="text-center">
		<c:if test="${page!=null}">
			<page:createPager pages="${page.pages}" pageSize="${page.pageSize}"
				url="/weixinConfig/getSuCaiList" total="${page.total}"
				pageNum="${page.pageNum}"></page:createPager>
		</c:if>
	</div>
	<script type="text/javascript"
		src="assets/js/houtaimanager/wxmenu/sucaiList.js"></script>
</body>
</html>