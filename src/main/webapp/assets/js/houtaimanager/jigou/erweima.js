jQuery(document).ready(function() {
	var basePath = $("#basePath").val();
	var hospitalid = $("#hospitalid").val();
	var param = {
		paramurl : basePath + "/hospitalmanager/hospitalerweima",
		paramdata : {
			hospitalid : hospitalid
		},
		dataType : 'json',
		callbackFun : function(data) {
			if (data.errorCode != 0) {
				layer.close(ii);
				layer.alert(dataobj.errorMsg);
				return false;
			}
			var ewmurl = data.data;
			$("#erweimaIMGID").attr("src", ewmurl);
		}
	}
	ajaxRun(param);
});
