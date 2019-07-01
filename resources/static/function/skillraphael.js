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
function getSkillGraph(wsize, div, skill) {
	var size = wsize;
	var rad = size/2;
	var r = Raphael(div, size, size);

	r.customAttributes.arc = function(centerX, centerY, startAngle, endAngle, arcEdge) {
		var radians = Math.PI / 180, largeArc = +(endAngle - startAngle > 180),
		// calculate the start and end points for both inner and outer edges of
		// the arc segment
		// the -90s are about starting the angle measurement from the top get
		// rid of these if this doesn't suit your needs
		outerX1 = centerX + arcEdge * Math.cos((startAngle - 90) * radians),
		outerY1 = centerY + arcEdge * Math.sin((startAngle - 90) * radians),
		outerX2 = centerX + arcEdge * Math.cos((endAngle - 90) * radians),
		outerY2 = centerY + arcEdge * Math.sin((endAngle - 90) * radians);

		// build the path array
		var path = [
		            [ "M", outerX1, outerY1 ], // move to the start point
		            [ "A", arcEdge, arcEdge, 0, largeArc, 1, outerX2, outerY2 ] // draw the outer edge of the arc
		];
		return {
			path : path
		};
	};
	
	var background = r.circle(rad, rad, rad*0.9).attr({
		fill : "#eeeeee",
		"stroke-width" : 0
	});

	// 스킬 수치 분석
	var color = parseInt(skill / 500);
	var drawval = skill % 500;
	var fillsize = parseInt(drawval / 100);
	var circlep = drawval % 100;
	
	var colorval;
	var colorval2;
	if(color < 2) {
		colorval="#ffffff";
		colorval2="#ffffff";
	}
	else if(color < 3) {
		colorval="#FACC2E";
		colorval2="#FACC2E";
	}
	else if(color < 4) {
		colorval="#FACC2E";
		colorval2="#FFFFFF";
	}
	else if(color < 5) {
		colorval="#FFFF00";
		colorval2="#FFFF00";
	}
	else if(color < 6) {
		colorval="#FFFF00";
		colorval2="#ffffff";
	}
	else if(color < 7) {
		colorval="#33FF00";
		colorval2="#33FF00";
	}
	else if(color < 8) {
		colorval="#33FF00";
		colorval2="#ffffff";
	}
	else if(color < 9) {
		colorval="#7598FF";
		colorval2="#7598FF";
	}
	else if(color < 10) {
		colorval="#7598FF";
		colorval2="#ffffff";
	}
	else if(color < 11) {
		colorval="#FF00FF";
		colorval2="#FF00FF";
	}
	else if(color < 12) {
		colorval="#FF00FF";
		colorval2="#ffffff";
	}
	else if(color < 13) {
		colorval="#FF0000";
		colorval2="#FF0000";
	}
	else if(color < 14) {
		colorval="#FF0000";
		colorval2="#ffffff";
	}
	else if(color < 15) {
		colorval="#dd8844";
		colorval2="#ffffff";
	}
	else if(color < 16) {
		colorval="#888888";
		colorval2="#dddddd";
	}
	else if(color < 17) {
		colorval="#ffff99";
		colorval2="#ffffff";
	}
	else if(color < 18) {
		colorval="#FF8C00";
		colorval2="#80FF00";
	}
	else if(color < 19) {
		colorval="#80FF00";
		colorval2="#0101DF";
	}
	else {
		colorval="#5858FA";
		colorval2="#FF0040";
	}
	
	// 길이범위: 100, 110, 120, 130, 140
	var fillrad;
	if(fillsize == 0) fillrad = rad*0.4;
	if(fillsize == 1) fillrad = rad*0.5;
	if(fillsize == 2) fillrad = rad*0.6;
	if(fillsize == 3) fillrad = rad*0.7;
	if(fillsize == 4) fillrad = rad*0.8;
	
	var filled = r.circle(rad, rad, fillrad).attr({
		fill:"270-"+colorval+"-"+colorval2,
		"stroke-width" : 0
	});
	
	var path = r.path().attr({
		stroke : colorval,
		"stroke-width" : rad*0.1,
		arc : [ rad, rad, 0, circlep*3.6, fillrad+rad*0.05 ]
	});
	
	var line1 = r.circle(rad, rad, rad*0.4).attr({
		stroke: "#dddddd",
		"stroke-width" : 1
	});
	
	var line2 = r.circle(rad, rad, rad*0.5).attr({
		stroke: "#dddddd",
		"stroke-width" : 1
	});
	
	var line3 = r.circle(rad, rad, rad*0.6).attr({
		stroke: "#dddddd",
		"stroke-width" : 1
	});
	
	var line4 = r.circle(rad, rad, rad*0.7).attr({
		stroke: "#dddddd",
		"stroke-width" : 1
	});
	
	var line5 = r.circle(rad, rad, rad*0.8).attr({
		stroke: "#dddddd",
		"stroke-width" : 1
	});
	
	var text = r.text(rad, rad, skill).attr({
		'font-size' : rad*0.4,
		'font-weight' : 'bold',
		'stroke':'white',
		'stroke-width':rad*0.01
	});
}

function getRecordGraph(wsize, div, date, skill, width, height) {
	var r = Raphael(div, width, height);
	var minval = 0;
	var maxval = 10000;
	
	var size = skill.length;
	var idxarr = new Array();
	
	// 상한선-하한선 정하기
	for(var i = 0; i < size; i++) {
		var sval = parseFloat(skill[i]);
		if(minval == 0 && maxval == 10000) {
			minval = sval - 100;
			maxval = sval + 100;
		}
		else if(minval > sval) {
			minval = sval - 100;
		}
		else if(maxval < sval) {
			maxval = sval + 100;
		}

		idxarr.push(i);
	}

	var option = {
		axis: '0 0 1 1',
		axisxstep: 1,
		axisystep: 4
	}

	var graph = r.linechart(
		0, 0, width, height,
		idxarr, skill, option
	);

	var showtext = r.text(0, 30, "");
	showtext.hide();

	graph.hover(
		function(e) {
			showtext.attr({
				"text":date[this.axis]+" / "+this.value,
				"fill":"#ffffff",
				"text-anchor":"start",
				"font":"15px 'Noto Sans KR'",
				"stroke":"#000000",
				"stroke-width":"0.5"
			});
			showtext.show();
			showtext.toFront();
		},
		function(e) {
			showtext.hide();
		}
	);

	/*graph.mouseover(
		function(e) {
			showtext.attr({
				"text":date[Math.round(e.x/(width/skill.length-1))]+" / "+skill[Math.round(e.x/(width/skill.length-1))],
				"fill":"#ffffff",
				"text-anchor":"start",
				"font":"15px 'Noto Sans KR'",
				"stroke":"#000000",
				"stroke-width":"0.5"
			});
			showtext.show();
			showtext.toFront();
		}
	);

	graph.mouseout(
		function(e) {
			showtext.hide();
		}
	);*/
}