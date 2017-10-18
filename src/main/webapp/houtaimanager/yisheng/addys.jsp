<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld"%>
<div class=" paddingTop45">
	<form id="submitForm" class="form-inline"
		action="hospitalmanager/addDoctor" method="post"
		enctype="multipart/form-data">
		<input type="hidden" name="id" value="${obj.id}" />
		<div class="form-group">
			<label class="mytext1">姓名</label> <input type="text"
				placeholder="请输入医生姓名" value="${obj.name}" name="name"
				class="form-control ldgtext2" />
		</div>
		<div class="form-group">
			<label class="mytext1">工号</label> <input type="text"
				placeholder="请输入医生工号" value="${obj.gonghao}" name="gonghao"
				class="form-control ldgtext2" />
		</div>
		<div class="form-group">
			<label class="mytext1">职称</label> <input type="text"
				placeholder="请输入医生职称" value="${obj.zhicheng}" name="zhicheng"
				class="form-control ldgtext2" />
		</div>
		<br />
		<div class="form-group">
			<label class="mytext1">职务</label> <input type="text"
				placeholder="请输入医生职称" value="${obj.zhiwu}" name="zhiwu"
				class="form-control ldgtext2" />
		</div>
		<div class="form-group">
			<label class="mytext1">社会兼职</label> <input type="text"
				placeholder="请输入社会兼职" value="${obj.shjz}" name="shjz"
				class="form-control" />
		</div>
		<div class="form-group">
			<label class="mytext1">职业特长</label> <input type="text"
				placeholder="请输入职业特长" value="${obj.zysc}" name="zysc"
				class="form-control" />
		</div>
		<br />
		<div class="form-group">
			<label class="mytext1">详细内容</label>
			<textarea rows="" cols="" placeholder="请输入详细内容！" id="myeditor"
				name="xxnr">${obj.xxnr}</textarea>
		</div>
		<br />
		<div class="form-group">
			<label class="mytext1">头像</label> <input type="file" placeholder="头像"
				name="x" id="file_input" class="form-control ldgtext2" />
		</div>
	</form>
	<button id="submitBTID" class="btn btn-info addbutton">保存</button>
	<c:if test="${obj.headimg!=null}">
		<img width="200px" height="200px" alt="" src="${obj.headimg}" />
	</c:if>
	<div id="imgDIV"></div>
	<script type="text/javascript" src="assets/js/ajaxForm.js"></script>
	<!-- ckeditor start -->
	<script type="text/javascript" src="assets/ckeditor/ckeditor.js"></script>
	<script type="text/javascript" src="assets/ckeditor/config.js"></script>
	<script type="text/javascript" src="assets/ckeditor/adapters/jquery.js"></script>
	<script type="text/javascript" src="assets/js/myCkeditor.js"></script>
	<!-- ckeditor send -->
	<script type="text/javascript"
		src="assets/js/houtaimanager/yisheng/add.js"></script>
</div>