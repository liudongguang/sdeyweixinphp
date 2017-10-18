jQuery(document).ready(function() {
	var jqa = $("div[class^='panel-collapse collapse']").find("a");
	jqa.click(function() {
		var thisA = $(this);
		var pageUrl = thisA.attr("href");
		var aText = thisA.text();
		$("#titleID").text(aText);
		jumpPage(pageUrl, $("#neirong"));
		return false;
	});
});