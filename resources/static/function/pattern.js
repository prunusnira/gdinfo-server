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
var GDPat = [
	{num:1, pat:"BAS-G"},
	{num:2, pat:"ADV-G"},
	{num:3, pat:"EXT-G"},
	{num:4, pat:"MAS-G"},
	{num:5, pat:"BAS-B"},
	{num:6, pat:"ADV-B"},
	{num:7, pat:"EXT-B"},
	{num:8, pat:"MAS-B"},
	{num:9, pat:"BAS-D"},
	{num:10, pat:"ADV-D"},
	{num:11, pat:"EXT-D"},
	{num:12, pat:"MAS-D"},
];

function getPatternImg600(ptcode) {
	var src = "";
	switch(ptcode) {
		case 1:
			src = "/img/diff/basg_600.png";
			break;
		case 2:
			src = "/img/diff/advg_600.png";
			break;
		case 3:
			src = "/img/diff/extg_600.png";
			break;
		case 4:
			src = "/img/diff/masg_600.png";
			break;
		case 5:
			src = "/img/diff/basb_600.png";
			break;
		case 6:
			src = "/img/diff/advb_600.png";
			break;
		case 7:
			src = "/img/diff/extb_600.png";
			break;
		case 8:
			src = "/img/diff/masb_600.png";
			break;
		case 9:
			src = "/img/diff/basd_600.png";
			break;
		case 10:
			src = "/img/diff/advd_600.png";
			break;
		case 11:
			src = "/img/diff/extd_600.png";
			break;
		case 12:
			src = "/img/diff/masd_600.png";
			break;
	}

	return src;
}

function getPatternImg300(ptcode) {
	var src = "";
	switch(ptcode) {
		case 1:
			src = "/img/diff/basg_300.png";
			break;
		case 2:
			src = "/img/diff/advg_300.png";
			break;
		case 3:
			src = "/img/diff/extg_300.png";
			break;
		case 4:
			src = "/img/diff/masg_300.png";
			break;
		case 5:
			src = "/img/diff/basb_300.png";
			break;
		case 6:
			src = "/img/diff/advb_300.png";
			break;
		case 7:
			src = "/img/diff/extb_300.png";
			break;
		case 8:
			src = "/img/diff/masb_300.png";
			break;
		case 9:
			src = "/img/diff/basd_300.png";
			break;
		case 10:
			src = "/img/diff/advd_300.png";
			break;
		case 11:
			src = "/img/diff/extd_300.png";
			break;
		case 12:
			src = "/img/diff/masd_300.png";
			break;
	}

	return src;
}