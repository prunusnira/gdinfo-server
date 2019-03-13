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
function updateColor() {
	$('.gskill').each(function() {
		changeColor($(this));
	});
	$('.dskill').each(function() {
		changeColor($(this));
	});
	$('.skill').each(function() {
		changeColor($(this));
	});
	$('.allskill').each(function() {
		changeColor2X($(this));
	});
}

function changeColor(div) {
	var skill = div[0].innerHTML;
	color(div, skill);
}

function changeColor2X(div) {
	var skill = div[0].innerHTML;
	color2x(div, skill);
}

function changeColorForTotal(div) {
	var skill = div[0].innerHTML;
	colorTotal(div, skill);
}

function color(div, skill) {
	if(skill < 1000) {
		$(div[0]).addClass("s0");
	}
	else if(skill >= 1000 && skill < 1500) {
		$(div[0]).addClass("s1");
	}
	else if(skill >= 1500 && skill < 2000) {
		$(div[0]).addClass("s2");
	}
	else if(skill >= 2000 && skill < 2500) {
		$(div[0]).addClass("s3");
	}
	else if(skill >= 2500 && skill < 3000) {
		$(div[0]).addClass("s4");
	}
	else if(skill >= 3000 && skill < 3500) {
		$(div[0]).addClass("s5");
	}
	else if(skill >= 3500 && skill < 4000) {
		$(div[0]).addClass("s6");
	}
	else if(skill >= 4000 && skill < 4500) {
		$(div[0]).addClass("s7");
	}
	else if(skill >= 4500 && skill < 5000) {
		$(div[0]).addClass("s8");
	}
	else if(skill >= 5000 && skill < 5500) {
		$(div[0]).addClass("s9");
	}
	else if(skill >= 5500 && skill < 6000) {
		$(div[0]).addClass("s10");
	}
	else if(skill >= 6000 && skill < 6500) {
		$(div[0]).addClass("s11");
	}
	else if(skill >= 6500 && skill < 7000) {
		$(div[0]).addClass("s12");
	}
	else if(skill >= 7000 && skill < 7500) {
		$(div[0]).addClass("s13");
	}
	else if(skill >= 7500 && skill < 8000) {
		$(div[0]).addClass("s14");
	}
	else if(skill >= 8000 && skill < 8500) {
		$(div[0]).addClass("s15");
	}
	else if(skill >= 8500 && skill < 9000) {
		$(div[0]).addClass("color-text-flow");
		$(div[0]).html(function(i, html) {
			var chars = $.trim(html).split("");
		  
			return '<span>' + chars.join('</span><span>') + '</span>';
		});
		/*colors: ['#FF0000', '#FF8C00', '#FFFF00', '#80FF00']*/
	}
	else if(skill >= 9000 && skill < 9500) {
		$(div[0]).addClass("color-text-flow");
		$(div[0]).html(function(i, html) {
			var chars = $.trim(html).split("");
		  
			return '<span>' + chars.join('</span><span>') + '</span>';
		});
		/*colors: ['#80FF00', '#58ACFA', '#0101DF']*/
	}
	else if(skill >= 9500) {
		$(div[0]).addClass("color-text-flow");
		$(div[0]).html(function(i, html) {
			var chars = $.trim(html).split("");
		  
			return '<span>' + chars.join('</span><span>') + '</span>';
		});
		/*colors: ['#5858FA', '#FF0040']*/
	}
}

function color2x(div, skill) {
	if(skill < 2000) {
		$(div[0]).addClass("s0");
	}
	else if(skill >= 2000 && skill < 3000) {
		$(div[0]).addClass("s1");
	}
	else if(skill >= 3000 && skill < 4000) {
		$(div[0]).addClass("s2");
	}
	else if(skill >= 4000 && skill < 5000) {
		$(div[0]).addClass("s3");
	}
	else if(skill >= 5000 && skill < 6000) {
		$(div[0]).addClass("s4");
	}
	else if(skill >= 6000 && skill < 7000) {
		$(div[0]).addClass("s5");
	}
	else if(skill >= 7000 && skill < 8000) {
		$(div[0]).addClass("s6");
	}
	else if(skill >= 8000 && skill < 9000) {
		$(div[0]).addClass("s7");
	}
	else if(skill >= 9000 && skill < 10000) {
		$(div[0]).addClass("s8");
	}
	else if(skill >= 10000 && skill < 11000) {
		$(div[0]).addClass("s9");
	}
	else if(skill >= 11000 && skill < 12000) {
		$(div[0]).addClass("s10");
	}
	else if(skill >= 12000 && skill < 13000) {
		$(div[0]).addClass("s11");
	}
	else if(skill >= 13000 && skill < 14000) {
		$(div[0]).addClass("s12");
	}
	else if(skill >= 14000 && skill < 15000) {
		$(div[0]).addClass("s13");
	}
	else if(skill >= 15000 && skill < 16000) {
		$(div[0]).addClass("s14");
	}
	else if(skill >= 16000 && skill < 17000) {
		$(div[0]).addClass("s15");
	}
	else if(skill >= 17000 && skill < 18000) {
		$(div[0]).addClass("color-text-flow");
		$(div[0]).html(function(i, html) {
			var chars = $.trim(html).split("");
		  
			return '<span>' + chars.join('</span><span>') + '</span>';
		});
	}
	else if(skill >= 18000 && skill < 19000) {
		$(div[0]).addClass("color-text-flow");
		$(div[0]).html(function(i, html) {
			var chars = $.trim(html).split("");
		  
			return '<span>' + chars.join('</span><span>') + '</span>';
		});
	}
	else if(skill >= 19000) {
		$(div[0]).addClass("color-text-flow");
		$(div[0]).html(function(i, html) {
			var chars = $.trim(html).split("");
		  
			return '<span>' + chars.join('</span><span>') + '</span>';
		});
	}
}

function colorTotal(div, skill) {
	if(skill < 10000) {
		$(div[0]).addClass("s0");
	}
	else if(skill >= 10000 && skill < 15000) {
		$(div[0]).addClass("s1");
	}
	else if(skill >= 15000 && skill < 20000) {
		$(div[0]).addClass("s2");
	}
	else if(skill >= 20000 && skill < 25000) {
		$(div[0]).addClass("s3");
	}
	else if(skill >= 25000 && skill < 30000) {
		$(div[0]).addClass("s4");
	}
	else if(skill >= 30000 && skill < 35000) {
		$(div[0]).addClass("s5");
	}
	else if(skill >= 35000 && skill < 40000) {
		$(div[0]).addClass("s6");
	}
	else if(skill >= 40000 && skill < 45000) {
		$(div[0]).addClass("s7");
	}
	else if(skill >= 45000 && skill < 50000) {
		$(div[0]).addClass("s8");
	}
	else if(skill >= 50000 && skill < 55000) {
		$(div[0]).addClass("s9");
	}
	else if(skill >= 55000 && skill < 60000) {
		$(div[0]).addClass("s10");
	}
	else if(skill >= 60000 && skill < 65000) {
		$(div[0]).addClass("s11");
	}
	else if(skill >= 65000 && skill < 70000) {
		$(div[0]).addClass("s12");
	}
	else if(skill >= 70000 && skill < 75000) {
		$(div[0]).addClass("s13");
	}
	else if(skill >= 75000 && skill < 80000) {
		$(div[0]).addClass("s14");
	}
	else if(skill >= 80000 && skill < 85000) {
		$(div[0]).addClass("s15");
	}
	else if(skill >= 85000 && skill < 90000) {
		$(div[0]).addClass("color-text-flow");
		$(div[0]).html(function(i, html) {
			var chars = $.trim(html).split("");
		  
			return '<span>' + chars.join('</span><span>') + '</span>';
		});
	}
	else if(skill >= 90000 && skill < 95000) {
		$(div[0]).addClass("color-text-flow");
		$(div[0]).html(function(i, html) {
			var chars = $.trim(html).split("");
		  
			return '<span>' + chars.join('</span><span>') + '</span>';
		});
	}
	else if(skill >= 95000) {
		$(div[0]).addClass("color-text-flow");
		$(div[0]).html(function(i, html) {
			var chars = $.trim(html).split("");
		  
			return '<span>' + chars.join('</span><span>') + '</span>';
		});
	}
}

// 스킬페이지 테이블 왼쪽 컬러 - style 태그 용
function skillTableColor(skill) {
	var color = "";
	if(skill < 20000000) color = "background-color: #FFFFFF";
	else if(skill < 30000000) color = "background-color: #FACC2E";
	else if(skill < 40000000) color = "background: linear-gradient(#FACC2E, #FFFFFF)";
	else if(skill < 50000000) color = "background-color: #FFFF00";
	else if(skill < 60000000) color = "background: linear-gradient(#FFFF00, #FFFFFF)";
	else if(skill < 70000000) color = "background-color: #33FF00";
	else if(skill < 80000000) color = "background: linear-gradient(#33FF00, #FFFFFF)";
	else if(skill < 90000000) color = "background-color: #3366FF";
	else if(skill < 100000000) color = "background: linear-gradient(#3366FF, #FFFFFF)";
	else if(skill < 110000000) color = "background-color: #FF00FF";
	else if(skill < 120000000) color = "background: linear-gradient(#FF00FF, #FFFFFF)";
	else if(skill < 130000000) color = "background-color: #FF0000";
	else if(skill < 140000000) color = "background: linear-gradient(#FF0000, #FFFFFF)";
	else if(skill < 150000000) color = "background: linear-gradient(#dd8844, #FFFFFF)";
	else if(skill < 160000000) color = "background: linear-gradient(#888888, #dddddd)";
	else if(skill < 170000000) color = "background: linear-gradient(#ffff99, #FFFFFF)";
	else if(skill < 180000000) color = "background: linear-gradient(#FF0000, #FF8C00, #FFFF00, #80FF00)";
	else if(skill < 190000000) color = "background: linear-gradient(#80FF00, #58ACFA, #0101DF)";
	else color = "background: linear-gradient(#5858FA, #FF0040)";
	return color;
}

// 스킬페이지 테이블 스샷용 컬러 - style 태그 용
function skillTableColorFlat(skill) {
	var color = "";
	if(skill < 20000000) color = "background-color: #FFFFFF";
	else if(skill < 30000000) color = "background-color: #FACC2E";
	else if(skill < 40000000) color = "background: linear-gradient(to right, #FACC2E, #FFFFFF)";
	else if(skill < 50000000) color = "background-color: #FFFF00";
	else if(skill < 60000000) color = "background: linear-gradient(to right, #FFFF00, #FFFFFF)";
	else if(skill < 70000000) color = "background-color: #33FF00";
	else if(skill < 80000000) color = "background: linear-gradient(to right, #33FF00, #FFFFFF)";
	else if(skill < 90000000) color = "background-color: #3366FF";
	else if(skill < 100000000) color = "background: linear-gradient(to right, #3366FF, #FFFFFF)";
	else if(skill < 110000000) color = "background-color: #FF00FF";
	else if(skill < 120000000) color = "background: linear-gradient(to right, #FF00FF, #FFFFFF)";
	else if(skill < 130000000) color = "background-color: #FF0000";
	else if(skill < 140000000) color = "background: linear-gradient(to right, #FF0000, #FFFFFF)";
	else if(skill < 150000000) color = "background: linear-gradient(to right, #dd8844, #FFFFFF)";
	else if(skill < 160000000) color = "background: linear-gradient(to right, #888888, #dddddd)";
	else if(skill < 170000000) color = "background: linear-gradient(to right, #ffff99, #FFFFFF)";
	else if(skill < 180000000) color = "background: linear-gradient(to right, #FF0000, #FF8C00, #FFFF00, #80FF00)";
	else if(skill < 190000000) color = "background: linear-gradient(to right, #80FF00, #58ACFA, #0101DF)";
	else color = "background: linear-gradient(to right, #5858FA, #FF0040)";
	return color;
}