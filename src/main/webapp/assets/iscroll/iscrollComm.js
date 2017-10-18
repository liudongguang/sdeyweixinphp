var myScroll;
var pullDownFlag, pullUpFlag;
var pullDown, pullUp;
var realPullDownAction, realPullUpAction;
function loaded(params) {
	pullDownFlag = 0;
	pullUpFlag = 0;
	pullDown = document.getElementById("pullDown");
	pullUp = document.getElementById("pullUp");
	myScroll = new IScroll("#wrapper", {
		probeType : 3,
		// momentum: false,//关闭惯性滑动
		mouseWheel : true,// 鼠标滑轮开启
		scrollbars : true,// 滚动条可见
		fadeScrollbars : true,// 滚动条渐隐
		interactiveScrollbars : true,// 滚动条可拖动
		shrinkScrollbars : 'scale', // 当滚动边界之外的滚动条是由少量的收缩
		useTransform : true,// CSS转化
		useTransition : true,// CSS过渡
		bounce : true,// 反弹
		freeScroll : false,// 只能在一个方向上滑动
		startX : 0,
		startY : 0,
		preventDefaultException : {
			tagName : /^(INPUT|TEXTAREA|BUTTON|SELECT|A)$/
		}
	// snap: "li",//以 li 为单位
	});
	if (params) {
		realPullDownAction = params.pullDownAction;
		realPullUpAction = params.pullUpAction;
	}
	myScroll.on('scroll', positionJudge);
	myScroll.on("scrollEnd", action);
}
function positionJudge() {
	if (this.y > 40) { // 判断下拉
		pullDown.style.display = 'block';
		pullDown.innerHTML = "放开刷新页面";
		pullDownFlag = 1;
	} else if (this.y < (this.maxScrollY - 40)) { // 判断上拉
		pullUp.style.display = 'block';
		pullUp.innerHTML = "放开刷新页面";
		pullUpFlag = 1;
	}
}

function action() {
	if (pullDownFlag == 1) {
		pullDown.style.display = 'none';
		pullDownAction();
		pullDownFlag = 0;
	} else if (pullUpFlag == 1) {
		pullUp.style.display = 'none';
		pullUpAction();
		pullUpFlag = 0;
	}
}

function pullDownAction() {
	if (realPullDownAction) {
		realPullDownAction(myScroll);
	}

}

function pullUpAction() {
	if (realPullUpAction) {
		realPullUpAction(myScroll);
	}
}
document.addEventListener('touchmove', function(e) {
	e.preventDefault();
}, false);