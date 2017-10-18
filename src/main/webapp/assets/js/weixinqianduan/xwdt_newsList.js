var basePath = $("#basePath").val();
$(document).ready(function() {
	params = {
		pullDownAction : function(myScroll) {
			if (checkLast()) {
				return false;
			}
			getMoreData(myScroll);
		},
		pullUpAction : function(myScroll) {
			if (checkLast()) {
				return false;
			}
			getMoreData(myScroll);
		}
	}
	loaded(params);
});
// 最后的记录
function checkLast() {
	var pageNum = $("#pageNum").val();
	var pages = $("#pages").val();
	if (pageNum == pages) {
		layer.msg("无更多信息！");
		return true;
	}
	return false;
}
// 获取新的数据
function getMoreData(myScroll) {
	var pageNum = $("#pageNum").val();
	var ksid = $("#ksid").val();
	var nextPageNum = parseInt(pageNum) + 1;
	var url = basePath + "/wxpage/getXwdtPageData";
	var param = {
		paramurl : url,
		paramdata : {
			ksofficeid : ksid,
			pageNum : nextPageNum
		},
		dataType : 'json',
		callbackFun : function(data) {
			var jq_list = $("#list");
			var dlist = data.data.list;
			for (var i = 0; i < dlist.length; i++) {
				var obj = dlist[i];
				var id = obj.id;
				var title = obj.title;
				var createtime = obj.createtime;
				var lihtml = '<li><a href=' + basePath
						+ '/wxpage/getXwdtByID?id=' + id
						+ '><span	class="point">•</span>' + title
						+ '</a> <span class="n_time">'
						+ fmtDateByHaomiao(createtime) + '</span></li>';
				jq_list.append(lihtml);
			}
			$("#pageNum").val(nextPageNum);
			myScroll.refresh();
		}
	}
	ajaxRun(param);
}
