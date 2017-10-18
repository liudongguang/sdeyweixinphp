<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld"%>
<div class="padding20">
	<input id="jkeshiID" type="hidden" value="${param.keshiID}" /> <input
		id="jksName" type="hidden" value=" ${param.ksName}" />

	<form id="submitForm" action="hospitalmanager/addKSInfoManager"
		method="post" enctype="multipart/form-data">
		<input type="hidden" id="form_keshiID" name="ksofficeid"
			value="${param.keshiID}" /> <input type="hidden" name="id"
			value="${obj.id}" />
		<div class="form-group">
			<label>管理员姓名</label> <input type="text" placeholder="请输入管理员姓名"
				value="${obj.name}" name="name" class="form-control" />
		</div>
		<div class="form-group">
			<label>管理员登陆名</label> <input type="text" placeholder="请输入管理员登陆名"
				value="${obj.username}" name="username" class="form-control" />
		</div>
		<div class="form-group">
			<label>管理员密码</label> <input type="text" placeholder="请输入管理员密码"
				value="${obj.psd}" name="psd" class="form-control" />
		</div>
	</form>
	<div id="imgDIV"></div>
	<button id="submitBTID" class="btn btn-info addbutton">保存</button>
	<script type="text/javascript" src="assets/js/ajaxForm.js"></script>
	<script type="text/javascript"
		src="assets/js/houtaimanager/keshi/addksmanager.js"></script>
</div>