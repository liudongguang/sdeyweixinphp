<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld"%>
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
<title>增加素材</title>
<link rel="stylesheet"
	href="assets/bootstrapfileinput/css/fileinput.css" />
</head>
<body>
	<style>
.form_st {
	margin-bottom: 15px;
	overfloaw: auto;
	height: 34px;
	line-height: 34px;
}

.form_st label {
	text-align: right
}
</style>
	<button id="backBT" class="btn btn-primary" style="margin: 5px;">返回</button>
	<form id="submitForm" action="weixinConfig/uploadSuCai" role="form"
		method="post" enctype="multipart/form-data">
		<input type="hidden" name="id" value="${param.id}" />
		<input type="hidden" name="imgpath" value="${param.imgpath}" />
		<div class="form-group form_st">
			<label for="firstname" class="col-sm-2 control-label">标题</label>
			<div class="col-sm-6">
				<input type="text" class="form-control" name="title" maxlength="10"
					value="${param.title }" placeholder="请输入标题 10字以内">
			</div>
		</div>
		<div class="form-group form_st">
			<label for="lastname" class="col-sm-2 control-label">介绍</label>
			<div class="col-sm-6">
				<input type="text" class="form-control" name="jianjie"
					value="${param.jianjie }" maxlength="20" placeholder="请输入介绍 20字以内">
			</div>
		</div>
		<div class="form-group form_st">
			<label for="lastname" class="col-sm-2 control-label">连接</label>
			<div class="col-sm-6">
				<input type="text" class="form-control" name="linkurl"
					value="${param.linkurl}" maxlength="1000" placeholder="请输入连接地址">
			</div>
		</div>

		<div class="form-group form_st">
			<label for="inputfile" class="col-sm-2 control-label">上传图片</label>
			<c:if test="${param.imgpath!=null}">
				<img width="150px" height="100px" alt="" src="${param.imgpath}" />
			</c:if>
			<div class="col-sm-6">
				建议图片尺寸为900*500（必填） <input id="inputfile" name="inputdim1"
					type="file" class="file-loading" accept="image/jpeg,image/png" />
			</div>
		</div>
	</form>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button id="submitBTID" type="button" class="btn btn-default">提交</button>
		</div>
	</div>
	<script type="text/javascript"
		src="assets/bootstrapfileinput/js/fileinput.js"></script>
	<script type="text/javascript"
		src="assets/bootstrapfileinput/js/locales/zh.js"></script>
	<script type="text/javascript" src="assets/js/ajaxForm.js"></script>
	<script type="text/javascript"
		src="assets/js/houtaimanager/wxmenu/addsucai.js"></script>
</body>
</html>