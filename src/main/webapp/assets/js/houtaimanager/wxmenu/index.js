jQuery(document).ready(function() {
	var basePath = $("#basePath").val();
	var ii = layer.load(0, {
		shade : [ 0.8, '#fff' ]
	// 0.1透明度的白色背景
	});
	$.post(basePath + 'weixinConfig/getCaiDanList', {}, function(data) {
		init(data);
		initPage();
		layer.close(ii);
		$("#saveBT").click(function() {
			var ii2 = layer.load(0, {
				shade : [ 0.8, '#fff' ]
			// 0.1透明度的白色背景
			});
			var sdata = $('#jstree').jstree(true).get_json();
			$.ajax({
				url : basePath + 'weixinConfig/saveMenuData',
				type : "POST",
				data : JSON.stringify(sdata),
				dataType : 'json',
				contentType : 'application/json;charset=UTF-8',
				success : function(result) {
					layer.close(ii2);
					if (result.errcode == 0) {
						layer.alert("保存成功！");
					} else {
						layer.alert("保存失败！");
					}
				}
			});
		});
	}, 'json');
});
function initPage() {
	jumpPageForWX("/weixinConfig/getSuCaiList", $("#mainDIVID"));
}
function init(data) {
	$.jstree.defaults.core.themes.variant = "large";
	$.jstree.defaults.contextmenu.items = {
		"mcreate" : {
			"label" : "新建菜单",
			"action" : function(data) {
				var inst = jQuery.jstree.reference(data.reference), obj = inst
						.get_node(data.reference);
				console.log(inst.get_json())
				var thisLevel = obj.li_attr.level;
				if (thisLevel == 1 && obj.id == 'xxx') {
					if (obj.children.length == 3) {
						layer.alert("主菜单最多三个！");
						return false;
					}
				}
				if (thisLevel == 2) {
					if (obj.children.length == 5) {
						layer.alert("子菜单最多5个！");
						return false;
					}
				}
				if (thisLevel == 3) {
					layer.alert("不允许添加！");
					return false;
				}
				var newID = inst.create_node(obj, {
					"type" : "text",
					"text" : "新建菜单",
					"li_attr" : {
						"level" : thisLevel + 1
					}
				});
				inst.open_node(obj);
				// 生成就编辑
				var newObj = inst.get_node(newID);
				inst.edit(newObj);
			}
		},
		"mdelete" : {
			"label" : "删除菜单",
			"action" : function(data) {
				var inst = jQuery.jstree.reference(data.reference), obj = inst
						.get_node(data.reference);
				if (obj.id == 'xxx') {
					layer.alert("不允许删除！");
					return false;
				}
				// ///
				layer.confirm('删除菜单?', {
					icon : 3,
					title : '会删除关联子菜单'
				}, function(index) {
					// do something
					inst.delete_node(obj);
					layer.close(index);
				});
			}
		},
		"mrename" : {
			"label" : "重命名",
			"action" : function(data) {
				var ref = $('#jstree').jstree(true), sel = ref.get_selected();
				if (sel[0] == 'xxx') {
					layer.alert("不允许改名！");
					return false;
				}
				if (!sel.length) {
					return false;
				}
				sel = sel[0];
				ref.edit(sel);
			}
		}
	};
	$('#jstree').jstree({
		"core" : {
			"check_callback" : true,
			'data' : data
		},
		"plugins" : [ "contextmenu" ]
	});
	$('#jstree').on("select_node.jstree", function(event, node) {
		var rnode = node.node;
		var id = rnode.id;
		var name = rnode.text;
		var level = rnode.li_attr.level;
		$("#levelID").val(level);
		$("#caidanID").val(name);
	})
}
