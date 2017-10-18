<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld"%>
<div class="paddingTop45">
	<form id="submitForm" action="hospitalmanager/addKSInfo" method="post"
		enctype="multipart/form-data">
		<input type="hidden" name="id" value="${obj.id}" /> <input
			type="hidden" name="type" value="1" /> <input type="hidden"
			id="managerKSID" name="type"
			value="${sessionScope.loginManager.ksofficeid}" />
		<div class="form-group">
			<h5>科室名称：${obj.name}</h5>
		</div>
		<div class="form-group">
			<label>科室详情</label>
			<textarea rows="" cols="" placeholder="请输入文章内容！" id="myeditor"
				name="xq">${obj.xq}</textarea>
		</div>
		<div class="form-group">
			<label>科室照片</label> <input type="file" placeholder="请输入科室详情" name="x"
				id="file_input" class="form-control" />
		</div>
	</form>
	<c:if test="${obj.photo!=null}">
		<img width="200px" height="200px" alt="科室图片" src="${obj.photo}" />
	</c:if>
	<div id="imgDIV"></div>
	<button id="submitBTID" class="btn btn-info addbutton">保存</button>
	<!-- ckeditor start -->
	<script type="text/javascript" src="assets/ckeditor/ckeditor.js"></script>
	<script type="text/javascript" src="assets/ckeditor/config.js"></script>
	<script type="text/javascript" src="assets/ckeditor/adapters/jquery.js"></script>
	<script type="text/javascript" src="assets/js/myCkeditor.js"></script>
	<!-- ckeditor send -->
	<script type="text/javascript" src="assets/js/ajaxForm.js"></script>
	<script type="text/javascript"
		src="assets/js/houtaimanager/keshi/ksjs.js"></script>
</div>