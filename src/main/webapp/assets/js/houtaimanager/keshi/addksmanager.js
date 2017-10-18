jQuery(document).ready(
		function() {
			// 回调方法
			function excuteResponse(data) {
				var ksName = $("#jksName").val();
				var keshiID = $("#jkeshiID").val();
				// 刷新列表
				jumpPage('/hospitalmanager/getKeshiManagerList?keshiID='
						+ keshiID + '&ksName=' + ksName, $("#neirong"));
			}
			initAjaxForm(excuteResponse);
		});
