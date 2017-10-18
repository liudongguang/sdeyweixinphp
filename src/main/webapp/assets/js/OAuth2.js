jQuery(document).ready(function() {
	var codeIDVal = $("#codeID").val();
	var basePath = $("#basePath").val();
	var wxuserNameVal = $("#wxuserName").val();
	if (wxuserNameVal) {
		initPageData();
		return false;
	}
	var ii = layer.load(0, {
		shade : [ 0.8, '#fff' ]
	// 0.1透明度的白色背景
	});
	if (codeIDVal) {
		$.post(basePath + '/wxsq/getUserInfo', {
			'code' : codeIDVal
		}, function(data) {
			if (data.errorCode == 0) {
				// data = data.data;
				// var userid = data.openid;
				// var name = data.nickname;
				// var avatar = data.headimgurl;
				// $("#avatarID").attr("src", avatar);
				// $("#nameID").text(name);
				initPageData();
				layer.close(ii);// 关闭遮罩层
			} else {
				layer.msg("无此用户！");
				layer.close(ii);// 关闭遮罩层
			}
		}, 'json');
	} else {
		layer.msg("无code！");
		layer.close(ii);// 关闭遮罩层
	}
});