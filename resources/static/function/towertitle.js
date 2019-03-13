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
function getFloorTitle(tower, floor, rate, allfloors) {
	// 타이틀 목록 가져오기
	var titleshort = "";
	
	// 1. 탑 이름에 따른 접두어 결정
	switch(tower) {
	case "towerDmDKDK": titleshort = "dkdk"; break;
	case "towerDmLeftPedal": titleshort = "lp"; break;
	case "towerDmNote": titleshort = "note"; break;
	case "towerDmFc": titleshort = "dmfc"; break;
	case "towerGfChord": titleshort = "chord"; break;
	case "towerGfAlter": titleshort = "alter"; break;
	case "towerGfMixed": titleshort = "mix"; break;
	case "towerGfFc": titleshort = "gffc"; break;
	default: titleshort = ""; break;
	}
	
	var titlelist = new Array();
	
	// 2. 탑 사이즈와 현재 층을 고려해 타이틀 이름을 리스트에 추가
	switch(allfloors) {
	case 4:
		switch(floor) {
		case 0: titlelist.push(titleshort+'amatuer'); if(rate == 100) { titlelist.push(titleshort+'amatuer_g'); } break;
		case 1: titlelist.push(titleshort+'adv'); if(rate == 100) { titlelist.push(titleshort+'adv_g'); } break;
		case 2: titlelist.push(titleshort+'pro'); if(rate == 100) { titlelist.push(titleshort+'pro_g'); } break;
		case 3: titlelist.push(titleshort+'master'); if(rate == 100) { titlelist.push(titleshort+'master_g'); } break;
		}
		break;
	case 5:
		switch(floor) {
		case 0: titlelist.push(titleshort+'starter'); if(rate == 100) { titlelist.push(titleshort+'starter_g'); } break;
		case 1: titlelist.push(titleshort+'amatuer'); if(rate == 100) { titlelist.push(titleshort+'amatuer_g'); } break;
		case 2: titlelist.push(titleshort+'adv'); if(rate == 100) { titlelist.push(titleshort+'adv_g'); } break;
		case 3: titlelist.push(titleshort+'pro'); if(rate == 100) { titlelist.push(titleshort+'pro_g'); } break;
		case 4: titlelist.push(titleshort+'master'); if(rate == 100) { titlelist.push(titleshort+'master_g'); } break;
		}
		break;
	case 6:
		switch(floor) {
		case 0: titlelist.push(titleshort+'newbie'); if(rate == 100) { titlelist.push(titleshort+'newbie_g'); } break;
		case 1: titlelist.push(titleshort+'starter'); if(rate == 100) { titlelist.push(titleshort+'starter_g'); } break;
		case 2: titlelist.push(titleshort+'amatuer'); if(rate == 100) { titlelist.push(titleshort+'amatuer_g'); } break;
		case 3: titlelist.push(titleshort+'adv'); if(rate == 100) { titlelist.push(titleshort+'adv_g'); } break;
		case 4: titlelist.push(titleshort+'pro'); if(rate == 100) { titlelist.push(titleshort+'pro_g'); } break;
		case 5: titlelist.push(titleshort+'master'); if(rate == 100) { titlelist.push(titleshort+'master_g'); } break;
		}
		break;
	case 7:
		switch(floor) {
		case 0: titlelist.push(titleshort+'newbie'); if(rate == 100) { titlelist.push(titleshort+'newbie_g'); } break;
		case 1: titlelist.push(titleshort+'starter'); if(rate == 100) { titlelist.push(titleshort+'starter_g'); } break;
		case 2:
		case 3: titlelist.push(titleshort+'amatuer'); if(rate == 100) { titlelist.push(titleshort+'amatuer_g'); } break;
		case 4: titlelist.push(titleshort+'adv'); if(rate == 100) { titlelist.push(titleshort+'adv_g'); } break;
		case 5: titlelist.push(titleshort+'pro'); if(rate == 100) { titlelist.push(titleshort+'pro_g'); } break;
		case 6: titlelist.push(titleshort+'master'); if(rate == 100) { titlelist.push(titleshort+'master_g'); } break;
		}
		break;
	case 8:
		switch(floor) {
		case 0: titlelist.push(titleshort+'newbie'); if(rate == 100) { titlelist.push(titleshort+'newbie_g'); } break;
		case 1: titlelist.push(titleshort+'starter'); if(rate == 100) { titlelist.push(titleshort+'starter_g'); } break;
		case 2:
		case 3: titlelist.push(titleshort+'amatuer'); if(rate == 100) { titlelist.push(titleshort+'amatuer_g'); } break;
		case 4:
		case 5: titlelist.push(titleshort+'adv'); if(rate == 100) { titlelist.push(titleshort+'adv_g'); } break;
		case 6: titlelist.push(titleshort+'pro'); if(rate == 100) { titlelist.push(titleshort+'pro_g'); } break;
		case 7: titlelist.push(titleshort+'master'); if(rate == 100) { titlelist.push(titleshort+'master_g'); } break;
		}
		break;
	}

	return titlelist;
}

function floorTitlePopup(tower, floor, rate, allfloors, div) {
	var titlelist = getFloorTitle(tower, floor, rate, allfloors);
	
	// 팝업 셀렉트
	var titleselect = document.getElementById("titleselect");
	titleselect.innerHTML = '';
	var option = new Array(titlelist.length);
	for(var i = 0; i < titlelist.length; i++) {
		option[i] = document.createElement("option");
		option[i].setAttribute("value", titlelist[i]);
		
		var t = document.createTextNode(titletxt[titlelist[i]][lang]);
		option[i].appendChild(t);
		
		titleselect.appendChild(option[i]);
	}
	
	div.show();
}

function getMusicTitle(mid, ptcode) {
	var rtn = {};
	rtn.type = titlesp[mid].type;
	
	if(rtn.type == 0) {
		rtn.title = titlesp[mid][ptcode].value;
	}
	else if(rtn.type == 1) {
		rtn.title = titlesp[mid].value;
	}
	else if(rtn.type == 2) {
		if(titlesp[mid][ptcode] != null) {
			rtn.title = titlesp[mid][ptcode].value;
		}
		else {
			rtn.title = titlesp[mid].value;
		}
	}

	return rtn;
}

function musicTitlePopup(mid, ptcode, div) {
	var mtitle = getMusicTitle(mid, ptcode);
	
	// 팝업 셀렉트
	var titleselect = document.getElementById("titleselect");
	titleselect.innerHTML = '';
	var option = new Array();
	option[0] = document.createElement("option");
	option[0].setAttribute("value", mtitle.title);
	
	var t;
	if(mtitle.type == 0) {
		t = document.createTextNode(titlesp[mid][ptcode][lang]);
	}
	else if(mtitle.type == 1) {
		t = document.createTextNode(titlesp[mid][lang]);
	}
	else if(mtitle.type == 2) {
		if(titlesp[mid][ptcode] != null) {
			t = document.createTextNode(titlesp[mid][ptcode][lang]);
		}
		else {
			t = document.createTextNode(titlesp[mid][lang]);
		}
	}
	option[0].appendChild(t);
	
	titleselect.appendChild(option[0]);
	
	div.show();
}

function popupRemove(div) {
	div.hide();
}

function setTitle(userid, currentTitleValue, jqdiv) {
	// 확정된 칭호를 프로필 DB에 등록
	$.ajax({
		url: "/d/towertitleapply/"+userid+"/"+currentTitleValue,
		success: function(data) {
			alert(txtTower.title.changed[lang]);
			popupRemove(jqdiv);
		}
	});
}

function getTowerTitle(userid, handler) {
	$.ajax({
		url: "/d/towertitle/"+userid,
		success: function(data) {
			handler(data);
		}
	});
}

function checkFloorTitleExist(towername) {
	var exist = true;
	if(towername.startsWith("towerSp")) {
		exist = false;
	}

	return exist;
}

function checkMusicTitleExist(mid, ptcode) {
	var isExist = false;
	if(titlesp[mid] != "undefined" && titlesp[mid] != null) {
		if(titlesp[mid].type == 0) {
			if(titlesp[mid][ptcode] != "undefined" && titlesp[mid][ptcode] != null) {
				isExist = true;
			}
		}
		else {
			isExist = true;
		}
	}
	
	return isExist;
}

function addTowerTitleImage(type, title) {
	var image = document.createElement("img");
	image.src = "/img/title/"+title+".png";
	
	if(type == "35") {
		image.className = "towertitle35";
	}
	else if(type == "50") {
		image.className = "towertitle50";
	}
	
	return image;
}