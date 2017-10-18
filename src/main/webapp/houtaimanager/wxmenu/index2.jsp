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
<title>首页</title>
<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.css" />
<link rel="stylesheet" href="assets/bootstrap/css/bootstrap-theme.css" />
<link rel="stylesheet" href="assets/css/default/style.css" />
<script type="text/javascript" src="assets/js/jquery3.1.0.min.js"></script>
<script type="text/javascript" src="assets/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript" src="assets/layer/layer.js"></script>
<script type="text/javascript" src="assets/js/jstree3.3.3.js"></script>
</head>
<body>
<body>
	<!-- 3 setup a container element -->
	<div id="jstree">
		<!-- in this example the tree is populated from inline HTML -->
		<ul>
			<li>Root node 1
				<ul>
					<li id="child_node_1">Child node 1</li>
					<li>Child node 2</li>
				</ul>
			</li>
			<li>Root node 2</li>
		</ul>
	</div>
	<button>demo button</button>
	<script>
		$(function() {
			// 6 create an instance when the DOM is ready
			$('#jstree').jstree();
			// 7 bind to events triggered on the tree
			$('#jstree').on("changed.jstree", function(e, data) {
				console.log(data.selected);
			});
			// 8 inter act with the tree - either way is OK
			$('button').on('click', function() {
				var v1=$('#jstree').jstree(true).select_node(['child_node_1']);
				var v2=$('#jstree').jstree('select_node', 'child_node_1');
				var v3=$.jstree.reference('#jstree').select_node('child_node_1');
				console.log("----------");
				console.log(v1);
				console.log(v2);
				console.log(v3);
				console.log("----------");
			});
		});
	</script>
</body>
</html>