<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld"%>
<div class="padding20">
	<form id="submitForm" action="sdeymanager/addHospitalAndSuperManager"
		method="post">
		<input type="hidden" name="managerId" value="${huvo.managerId}" />
		<div class="form-group">
			<label>医院名称</label> <input type="text" placeholder="请输入医院名称"
				<c:if test="${huvo.managerId!=null}">readonly="readonly"</c:if>
				value="${huvo.hospitalName}" name="hospitalName"
				class="form-control" />
		</div>
		<div class="form-group">
			<label>管理员姓名</label> <input type="text" placeholder="请输入管理员姓名"
				value="${huvo.managerName}" name="managerName" class="form-control" />
		</div>
		<div class="form-group">
			<label>管理员登陆名</label> <input type="text" placeholder="请输入管理员登陆名"
				value="${huvo.managerUserName}" name="managerUserName"
				class="form-control" />
		</div>
		<div class="form-group">
			<label>管理员密码</label> <input type="text" placeholder="请输入管理员密码"
				value="${huvo.userPsd}" name="userPsd" class="form-control" />
		</div>
	</form>
	<button id="submitBTID" class="btn btn-info addbutton">保存</button>
	<script type="text/javascript" src="assets/js/ajaxForm.js"></script>
	<script type="text/javascript" src="assets/js/houtaimanager/jigou/addInfo.js"></script>
</div>