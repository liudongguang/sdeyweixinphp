<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld"%>
<div class="paddingTop45">
	<form id="submitForm" action="hospitalmanager/addKsNews" method="post"
		enctype="multipart/form-data">
		<input type="hidden" name="id" value="${obj.id}" />
		<div class="form-group">
			<label>标题</label> <input type="text" placeholder="请输入新闻标题"
				value="${obj.title}" name="title" class="form-control" />
		</div>
		<br />
		<div class="form-group">
			<textarea rows="" cols="" placeholder="请输入文章内容！" id="myeditor"
				name="content">${obj.content}</textarea>
		</div>
	</form>
	<button id="submitBTID" class="btn btn-info addbutton">保存</button>
	<script type="text/javascript" src="assets/js/ajaxForm.js"></script>
	<!-- ckeditor start -->
	<script type="text/javascript" src="assets/ckeditor/ckeditor.js"></script>
	<script type="text/javascript" src="assets/ckeditor/config.js"></script>
	<script type="text/javascript" src="assets/ckeditor/adapters/jquery.js"></script>
	<script type="text/javascript" src="assets/js/myCkeditor.js"></script>
	<!-- ckeditor send -->
	<script type="text/javascript"
		src="assets/js/houtaimanager/ksnews/add.js"></script>
</div>