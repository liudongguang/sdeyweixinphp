<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<!-- http://www.codeweblog.com/summernote-%E2%80%93-%E5%9F%BA%E4%BA%8E-bootstrap-%E7%9A%84%E6%96%87%E6%9C%AC%E7%BC%96%E8%BE%91%E5%99%A8/ -->
<!-- http://www.pingshu8.com/play_155747.html   31中 -->
<base href="${pageContext.request.contextPath }/" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="format-detection" content="telephone=no">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.css" />
<link rel="stylesheet" href="assets/bootstrap/css/bootstrap-theme.css" />
<link rel="stylesheet" href="assets/summernote/summernote.css" />
</head>
<body>
	<div id="editor"></div>
	<button id="getCode">getCode</button>
</body>
<script type="text/javascript" src="assets/js/jquery3.1.0.min.js"></script>
<script type="text/javascript" src="assets/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript" src="assets/summernote/summernote.js"></script>
<script type="text/javascript"
	src="assets/summernote/summernote-zh-CN.js"></script>
<script type="text/javascript">
	var jq_summernote = $('#editor')
			.summernote(
					{
						lang : 'zh-CN',
						placeholder : '科室新闻',
						minHeight : 300,
						dialogsFade : true,// Add fade effect on dialogs
						dialogsInBody : true,// Dialogs can be placed in body, not in
						// summernote.
						disableDragAndDrop : false,// default false You can disable drag
						// and drop
						///重写上传方法
						callbacks : {
							onImageUpload : function(files) {
								// upload image to server and create imgNode...
								//$summernote.summernote('insertNode', imgNode);
								//上传图片到服务器，使用了formData对象，至于兼容性...据说对低版本IE不太友好
								var formData = new FormData();
								formData.append('file', files[0]);
								$
										.ajax({
											url : '${pageContext.request.contextPath }/summernot/uploadImg',//后台文件上传接口
											type : 'POST',
											data : formData,
											dataType : 'json',
											processData : false,
											contentType : false,
											success : function(data) {
												jq_summernote.summernote(
														'insertImage',
														data.data);
											}
										});
							}
						}
					});
	$("#getCode").click(function() {
		console.log(jq_summernote)
		console.log(jq_summernote.summernote('code'));
	})
</script>
</html>