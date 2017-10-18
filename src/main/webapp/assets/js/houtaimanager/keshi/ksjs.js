jQuery(document).ready(
		function() {
			// 回调方法
			function excuteResponse(data) {
				layer.alert("修改完成！", {
					yes : function(index, layero) {
						// 刷新列表
						jumpPage('/hospitalmanager/getKeshiByID?type=1&id='
								+ $("#managerKSID").val(), $("#neirong"));
						layer.close(index);
					}
				});
			}
			initAjaxForm(excuteResponse);
			// /////////////////////////////////////////////////////////////////////////////////////
			initDisplayImg('file_input', 'imgDIV');
		});
