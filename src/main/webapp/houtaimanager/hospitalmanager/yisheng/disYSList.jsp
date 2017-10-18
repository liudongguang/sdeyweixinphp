<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="page" uri="/WEB-INF/tld/pagerForBootStrap.tld"%>
<div class="containtH800">
	<button class="btn btn-success addbutton" notTanchu_title
		myurl="/houtaimanager/hospitalmanager/yisheng/addys.jsp" title="新增医生" width="800"
		height="400">新增</button>
	<table class="table  table-bordered">
		<thead>
			<tr>
				<th>医生名字</th>
				<th>医生工号</th>
				<th>所在科室</th>
				<th>创建时间</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page.list}" var="l">
				<tr>
					<td>${l.ysname}</td>
					<td>${l.gonghao}</td>
					<td>${l.ksname}</td>
					<td><fmt:formatDate value="${l.createtime}"
							pattern=" yyyy-MM-dd HH:mm:ss" /></td>
					<td>
						<div class="ldg_table_btdiv">
							<a ajaxthispage_title class="aa" title="修改医生" width="800" height="400"
								href="/hospitalmanager/getDoctorByID?id=${l.id}"><span>编辑</span></a>
							<a ajaxdel class="aa ldg_tableA"
								href="/hospitalmanager/delDoctorByID?id=${l.id}"><span>删除</span></a>
						</div>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div id="pageDIV" class="text-center">
		<c:if test="${page!=null}">
			<page:createPager pages="${page.pages}" pageSize="${page.pageSize}"
				url="/hospitalmanager/getDoctorListForHospitalManager" total="${page.total}"
				pageNum="${page.pageNum}"></page:createPager>
		</c:if>
	</div>
	<!-- 设置显示列表的样式与添加事件 -->
	<script type="text/javascript"
		src="assets/js/houtaimanager/tableset.js"></script>
</div>