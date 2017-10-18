jQuery(document).ready(function() {
	$("#addSCBT").click(function() {
		jumpPageForWX("/houtaimanager/wxmenu/addSucai.jsp", $("#mainDIVID"));
	});
	initTable($("#mainDIVID"));

	$("a[guanlian]").click(function() {
		var level = $("#levelID").val();
		var cdid = $("#caidanID").val();
		if (level) {
			if (level == 3) {
				$("#levelID").val("");
				$("#caidanID").val("");
				$('#jstree').jstree(true).deselect_all();
				var hrefurl = $(this).attr("href");
				hrefurl += "&cdid=" + cdid;
				jumpPageForWX(hrefurl, $("#mainDIVID"));
			} else {
				layer.alert("必须选择最底层菜单！");
			}
		} else {
			layer.alert("请选择菜单！");
		}
		return false;
	});
});