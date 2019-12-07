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

// Cookie control from stackoverflow
// https://stackoverflow.com/questions/28654595/how-do-you-create-a-cookie-in-javascript-without-jquery
function createCookie(name,value,days) {
    if (days) {
        var date = new Date();
        date.setTime(date.getTime()+(days*24*60*60*1000));
        var expires = "; expires="+date.toGMTString();
    }
    else var expires = "";
    document.cookie = name+"="+value+expires+"; path=/";
}

function readCookie(name) {
    var nameEQ = name + "=";
    var ca = document.cookie.split(';');
    for(var i=0;i < ca.length;i++) {
        var c = ca[i];
        while (c.charAt(0)==' ') c = c.substring(1,c.length);
        if (c.indexOf(nameEQ) == 0) return c.substring(nameEQ.length,c.length);
    }
    return null;
}

function eraseCookie(name) {
    createCookie(name,"",-1);
}

var lang = navigator.language || navigator.systemLanguage;
if(readCookie("lang") == 'ko' || readCookie("lang") == 'jp' || readCookie("lang") == 'en') {
	lang = readCookie("lang");
}
else {
	if(lang=='ko' || lang=='ko-kr' || lang=='ko-KR') {
		lang = 'ko';
	}
	else if(lang=='ja' || lang=='ja-jp' || lang=='ja-JP') {
		lang = 'jp';
	}
	else {
		lang = 'en';
	}

	eraseCookie("lang");
	createCookie("lang", lang, false);
}

var text = {
	other: {
		canvas: {
			"jp":"現在のOSもしやブラウザでは利用できません",
			"ko":"지원되지 않는 OS 혹은 브라우저입니다.",
			"en":"This browser is not supported"
		},
		ios: {
			"jp":"",
			"ko":"",
			"en":""
		},
		korea: {
			"jp":"韓国",
			"ko":"한국",
			"en":"Korea"
		},
		japan: {
			"jp":"日本",
			"ko":"일본",
			"en":"Japan"
		},
		etc: {
			"jp":"その外",
			"ko":"그 외",
			"en":"Others"
		},
		filter: {
			"jp":"フィルターを利用することで様々なオプションのセットが可能です",
			"ko":"필터를 사용하면 버전 등의 다양한 옵션으로 검색이 가능합니다",
			"en":"You can search with several options including version, level, etc"
		},
		days: {
			"jp":"日前",
			"ko":"일전",
			"en":" days ago"
		},
		hrs: {
			"jp":"時間",
			"ko":"시간",
			"en":"hr"
		},
		mins: {
			"jp":"分前",
			"ko":"분전",
			"en":" min before"
		}
	},
	login: {
		title: {
			"jp":"ログイン",
			"ko":"로그인",
			"en":"Sign up"
		},
		google: {
			"jp":"SINはGoogleのアカウントを使ったログインができます",
			"ko":"SIN은 구글 계정을 사용한 로그인만을 지원합니다.",
			"en":"SIN only uses Google account login"
		}
	},
	music: {
		count: {
			"jp":"クリア回数",
			"ko":"클리어 횟수",
			"en":"Clear"
		},
		rank: {
			"jp":"ランク",
			"ko":"랭크",
			"en":"Rank"
		},
		rate: {
			"jp":"達成率",
			"ko":"달성률",
			"en":"Rate"
		},
		score: {
			"jp":"スコア",
			"ko":"점수",
			"en":"Score"
		},
		combo: {
			"jp":"コンボ",
			"ko":"콤보",
			"en":"Combo"
		},
		skill: {
			"jp":"スキル",
			"ko":"스킬",
			"en":"Skill"
		}
	},
	common: {
		btnlogin: {
			"jp":"ログイン",
			"ko":"로그인",
			"en":"Login"
		},
		empty: {
			"jp":"表示する項目がありません",
			"ko":"표시할 항목이 없습니다",
			"en":"There are no data to show"
		}
	},
	prohibit: {
		title: {
			"jp":"接続制限のご案内",
			"ko":"접속 제한 안내",
			"en":"Prohibition"
		},
		temp: {
			"jp":"このアカウントは次の時間まで停止されています",
			"ko":"이 계정은 다음 시간까지 일시적으로 정지되었습니다.",
			"en":"Your account is blocked until"
		},
		forever: {
			"jp":"永久的に停止されたアカウントです",
			"ko":"영구 정지된 계정입니다.",
			"en":"You are permanetly blocked"
		}
	},
	error: {
		e404: {
			"jp":"接続の問題を確認しました(404)<br/>" +
					"この問題が続ける場合、開発者に連絡お願いします<br/><br/>" +
					"Twitter @gitadorainfo",
			"ko":"잘못된 접근을 수행하였습니다 (404)<br/>" +
					"문제가 자꾸 발생한다면 개발자에게 문의를 주세요<br/><br/>" +
					"Twitter @gitadorainfo",
			"en":"Wrong connection found (404)<br/>" +
					"If this message keep showing, please contact developer<br/><br/>" +
					"Twitter @gitadorainfo"
		},
		e500: {
			"jp":"このページが表示されるのは２つの理由があります。<br/><br/>"+
					"1. 先にログインをお願いします。<br/>"+
					"もしログインしてからもこのページが見える場合、開発者に連絡お願いします<br/><br/>"+
					"2. アカウント主さんだけ接続できるページの可能性があります。<br/>"+
					"この場合は本人しかページの列欄が可能となります。<br/><br/>"+
					"お問い合わせ：Twitter @gitadorainfo",
			"ko":"이 페이지가 나오는 원인은 2가지가 있습니다.<br/><br/>"+
					"1. 로그인을 먼저 수행해주세요<br/>" +
					"만약 로그인 후에도 이 페이지가 계속 나타난다면 개발자에게 문의를 주세요<br/><br/>" +
					"2. 관련 계정 주인만 접근할 수 있는 페이지 일 수 있습니다<br/>" +
					"이 경우에는 해당 기능과 관련된 계정주 본인만 접근할 수 있습니다<br/><br/>"+
					"문의처: Twitter @gitadorainfo",
			"en":"There are 2 reasons for you to see this page<br/><br/>"+
					"1. Please sign in first.<br/>" +
					"If you get this message even if you are signed in, please contact developer<br/><br/>" +
					"2. This page would be only accessible by account owner<br/><br/>"+
					"Contact: Twitter @gitadorainfo"
		}
	},
	noie: {
		"jp":"Internet ExplorerではGITADORA Infoに接続できません。<br/>" +
				"<a class='innerhref' href='http://chrome.google.com'>Google Chrome</a>などの他のブラウザを使ってください。",
		"ko":"GITADORA Info는 Internet Explorer를 지원하지 않습니다.<br/>" +
				"<a class='innerhref' href='http://chrome.google.com'>구글 크롬</a>을 사용해주세요",
		"en":"GITADORA Info DOES NOT support Internet Explorer any more.<br />"+
				"Please use <a class='innerhref' href='http://chrome.google.com'>Google Chrome</a> instead."
	}
}