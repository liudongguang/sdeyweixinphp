<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="page" uri="/WEB-INF/tld/pagerForBootStrap.tld"%>
<div class="containtH800">
	<button class="btn btn-success addbutton" title="新增${param.ksName}管理员"
		tanchu width="300" height="400"
		myurl="/houtaimanager/keshi/addksnanager.jsp?keshiID=${param.keshiID}&ksName=${param.ksName}">新增</button>
	<table class="table  table-bordered">
		<thead>
			<tr>
				<th>姓名</th>
				<th>帐号</th>
				<th>创建时间</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page.list}" var="l">
				<tr>
					<td>${l.name}</td>
					<td>${l.username}</td>
					<td><fmt:formatDate value="${l.createtime}"
							pattern=" yyyy-MM-dd HH:mm:ss" /></td>
					<td>
						<div class="ldg_table_btdiv">
							<a ajax title="修改管理员" width="300" height="400"
								href="/hospitalmanager/getKSManagerByID?id=${l.id}&keshiID=${param.keshiID}&ksName=${param.ksName}"><span
								class="aa">编辑</span></a><a ajaxdel class="aa ldg_tableA"
								href="/hospitalmanager/delKeshiManagerByID?id=${l.id}&ksID=${param.keshiID}"><span>删除</span></a>
						</div>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div id="pageDIV" class="text-center">
		<c:if test="${page!=null}">
			<page:createPager pages="${page.pages}" pageSize="${page.pageSize}"
				url="/hospitalmanager/getKeshiManagerList?keshiID=${param.keshiID}&ksName=${param.ksName}"
				total="${page.total}" pageNum="${page.pageNum}"></page:createPager>
		</c:if>
	</div>
	<!-- 设置显示列表的样式与添加事件 -->
	<script type="text/javascript"
		src="assets/js/houtaimanager/tableset.js"></script>
</div>