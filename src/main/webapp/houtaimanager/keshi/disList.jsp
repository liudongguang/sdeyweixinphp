<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="page" uri="/WEB-INF/tld/pagerForBootStrap.tld"%>
<div class="containtH800">
	<button class="btn btn-success addbutton" notTanchu_title
		myurl="/houtaimanager/keshi/addks.jsp" title="新增科室" width="700"
		height="650">新增</button>
	<table class="table  table-bordered">
		<thead>
			<tr>
				<th>科室名称</th>
				<th>创建时间</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page.list}" var="l">
				<tr>
					<td>${l.name}</td>
					<td><fmt:formatDate value="${l.createtime}"
							pattern=" yyyy-MM-dd HH:mm:ss" /></td>
					<td>
						<div class="ldg_table_btdiv">
							<a ajaxthispage_title class="aa" width="700" height="650"
								title="科室修改" href="/hospitalmanager/getKeshiByID?id=${l.id}"><span>编辑</span></a>
							<a ajaxthispage_title class="aa ldg_tableA"
								title="${l.name}管理员列表"
								href="/hospitalmanager/getKeshiManagerList?keshiID=${l.id}&ksName=${l.name}"><span>管理员</span></a>
							<a ajaxdel class="aa ldg_table3"
								href="/hospitalmanager/delKeshiByID?id=${l.id}"><span>删除</span></a>
						</div>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div id="pageDIV" class="text-center">
		<c:if test="${page!=null}">
			<page:createPager pages="${page.pages}" pageSize="${page.pageSize}"
				url="/hospitalmanager/getKeshiList" total="${page.total}"
				pageNum="${page.pageNum}"></page:createPager>
		</c:if>
	</div>
	<!-- 设置显示列表的样式与添加事件 -->
	<script type="text/javascript"
		src="assets/js/houtaimanager/tableset.js"></script>
</div>