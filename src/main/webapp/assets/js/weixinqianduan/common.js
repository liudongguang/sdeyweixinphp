jQuery(document).ready(function() {
	var jq_a = $("ul[class='am-list']").find("a[ajaxdiv]");
	jq_a.each(function() {
		var jq_this = $(this);
		jq_this.click(function() {
			var hrefurl = jq_this.attr("href");
			jumpPageForWX(hrefurl, $("#containtDIV"));
			return false;
		})
	})
});