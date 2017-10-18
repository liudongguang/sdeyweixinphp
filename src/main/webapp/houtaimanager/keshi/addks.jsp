<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld"%>
<div class="paddingTop45">
	<form id="submitForm" action="hospitalmanager/addKSInfo" method="post"
		enctype="multipart/form-data">
		<input type="hidden" name="id" value="${obj.id }" />
		<div class="form-group">
			<label>科室名称</label> <input type="text" placeholder="请输入科室名称"
				value="${obj.name}" name="name" class="form-control" />
		</div>
		<div class="form-group">
			<label>科室详情(上传照片不可大于600K)</label>
			<textarea rows="" cols="" placeholder="请输入文章内容！" id="myeditor"
				name="xq">${obj.xq}</textarea>
		</div>
		<div class="form-group">
			<label>科室照片(不可大于5M)</label> <input type="file" placeholder="请输入科室详情"
				name="x" id="file_input" class="form-control" />
		</div>
	</form>
	<c:if test="${obj.photo!=null}">
		<img width="200px" height="200px" alt="" src="${obj.photo}" />
	</c:if>
	<div id="imgDIV"></div>
	<button id="submitBTID" class="btn btn-info addbutton">保存</button>
	<script type="text/javascript" src="assets/js/ajaxForm.js"></script>
	<!-- ckeditor start -->
	<script type="text/javascript" src="assets/ckeditor/ckeditor.js"></script>
	<script type="text/javascript" src="assets/ckeditor/config.js"></script>
	<script type="text/javascript" src="assets/ckeditor/adapters/jquery.js"></script>
	<script type="text/javascript" src="assets/js/myCkeditor.js"></script>
	<!-- ckeditor send -->
	<script type="text/javascript"
		src="assets/js/houtaimanager/keshi/addKSInfo.js"></script>
</div>