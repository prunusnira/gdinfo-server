/*****************************************************
 * GITADORA Info Server
 * Developed by Tae Jun Kang a.k.a Prunus Nira
 * (c) Nira 2016
 *
 * 1. This project is protected under GNU AGPL v3.0
 *    Please refer to LICENSE file on root
 * 2. Also, products and libraries used to implement
 *    this server are on USED-LIBRARIES file on root
 *****************************************************/
function scrShot(tableid, filename) {
	if(isCanvasSupported()) {
		html2canvas(document.querySelector(tableid))
		.then(function(canvas) {
        	var a = document.createElement('a');
	        a.href = canvas.toDataURL("image/jpeg");
	        a.download = filename;
			a.click();
        });
	}
	else {
		alert(text.other.canvas[lang]);
	}
}

// Check html5 canvas support
function isCanvasSupported(){
	// check os and browser
	var agent = navigator.userAgent.toLowerCase();
	var os;
	var browser;
	
	if(agent.indexOf("android") > -1) os = "Android";
	if(agent.indexOf("iphone") > -1) os = "iOS";
	if(agent.indexOf("ipad") > -1) os = "iOS";
	if(agent.indexOf("ipod") > -1) os = "iOS";
	if(agent.indexOf("windows") > -1) os = "Windows";
	if(agent.indexOf("x11") > -1) os = "Linux";
	if(agent.indexOf("Mac") > -1) os = "MacOS";
	
    // Opera 8.0+
	var isOpera = (!!window.opr && !!opr.addons) || !!window.opera || navigator.userAgent.indexOf(' OPR/') >= 0;
	// Firefox 1.0+
	var isFirefox = typeof InstallTrigger !== 'undefined';
    // At least Safari 3+: "[object HTMLElementConstructor]"
	var isSafari = Object.prototype.toString.call(window.HTMLElement).indexOf('Constructor') > 0;
    // Internet Explorer 6-11
	var isIE = /*@cc_on!@*/false || !!document.documentMode;
    // Edge 20+
	var isEdge = !isIE && !!window.StyleMedia;
    // Chrome 1+
	var isChrome = !!window.chrome && !!window.chrome.webstore;
    // Blink engine detection
	var isBlink = (isChrome || isOpera) && !!window.CSS;
	/*var elem = document.createElement('canvas');
	return !!(elem.getContext && elem.getContext('2d'));*/
	
	if(isOpera) browser = "Opera";
	if(isFirefox) browser = "FireFox";
	if(isSafari) browser = "Safari";
	if(isIE) browser = "IE";
	if(isEdge) browser = "Edge";
	if(isChrome) browser = "Chrome";
	if(isBlink) browser = "Others";
	
	if(isIE || isEdge) return false;
	else {
		return true;
	}
}