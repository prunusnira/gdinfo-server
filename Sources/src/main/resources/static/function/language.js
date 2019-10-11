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
	qna: {
		main: {
			"jp":"GITADORA Infoに関するよく見える質問の説明のためのページです",
			"ko":"GITADORA Info에 대해 자주 보이는 질문들에 대한 간단한 설명을 위한 페이지를 만들었습니다.",
			"en":"This is FAQ page for GITADORA Info"
		},
		title1: {
			"jp":"なぜGoogleアカウントを使ってログインするの？",
			"ko":"왜 굳이 Google 계정을 사용하여 로그인하는가",
			"en":"Why you need Google account?"
		},
		desc1: {
			p1: {
				"jp":"作ろとすれば自体的なログインシステムを作ることができますが、" +
						"私はセキュリティーの専門家ではないのでもしや" +
						"皆さんが他のサイトで使うパスワードをDBに保存して" +
						"ちゃんと管理できるのかが分かりません。",
				"ko":"만들고자 한다면 내부의 자체 로그인 시스템을 만들 수 있습니다만," +
						" 전 보안전문가가 아니기 때문에 혹시나 여러분이 다른 사이트에서" +
						" 자주 사용하는 비밀번호를 제가 만든 데이터베이스에 저장한다면..." +
						" 솔직히 말해 아무리 암호화를 잘 해서 저장한다고 해도 잘 관리할 수 있을지 저는 잘 모르겠네요.",
				"en":""
			},
			p2: {
				"jp":"で、最近色んなサイトからよく使う他社のAPIを使ったログインを導入しました。" +
					"実際に沢山のウェブサービスから「Twitterを使ってログイン」とか" +
					"「Googleを使ってログイン」などのサービスを使っています。",
				"ko":" 그래서 최근에 다양한 사이트에서 많이 사용되는 타사의 API를 사용한 로그인을 도입하였습니다." +
					" 실제로 다양한 사이트에서 Twitter를 사용한 로그인," +
					" Google을 사용한 로그인 등을 많이 사용하고 있지요.",
				"en":""
			},
			p3: {
				"jp":"GITADORA InfoではGoogle+ JavaScript API<br/>" +
						"参考リンク1. <a href='https://developers.google.com/+/web/api/javascript'>https://developers.google.com/+/web/api/javascript</a><br/>" +
						"参考リンク2. <a href='https://developers.google.com/identity/sign-in/web/reference'>https://developers.google.com/identity/sign-in/web/reference</a><br/>" +
						"を使ってログインします。" +
						"そして、この過程から持ってくるデータはユーザーのE-MAILアドレスです。" +
						"(「Googleアカウント@gmail.com」の形のこれです)",
				"ko":"GITADORA Info에서는 Google+ JavaScript API<br/>" +
						"참고링크 1. <a href='https://developers.google.com/+/web/api/javascript'>https://developers.google.com/+/web/api/javascript</a><br/>" +
						"참고링크 2. <a href='https://developers.google.com/identity/sign-in/web/reference'>https://developers.google.com/identity/sign-in/web/reference</a><br/>" +
						"를 사용하여 로그인을 수행하고 있습니다." +
						" 그리고 이 과정에서 실제로 가져오는 데이터는 로그인하는 유저의 이메일 주소입니다." +
						" (「Google계정@gmail.com」의 형태의 그것입니다.)",
				"en":""
			},
			p4: {
				"jp":"このアドレスから@gmail.comを除外してGoogleIDのみ使います。" +
						"さらに、このIDもSHA-256を使って変化させて保存します。" +
						"(この部分はloginページのソースコードを確認すればすぐに分かります。)" +
						"<br/><br/>実際にサーバーではこうなります。(DBデータのスクショットです)",
				"ko":"여기서도 실제로 사용하는것은 @gmail.com을 제외한 구글 아이디 뿐이며," +
						" 이 ID도 실제 서버 데이터베이스에 저장되는 것은 SHA-256을 사용하여 변환된 Token 값입니다." +
						" (이 부분은 login 페이지의 소스코드를 확인하시면 알 수 있습니다." +
						" 자바스크립트 라이브러리를 사용하여 아이디를 변형한 후 이를 개인 식별을 위한 토큰으로 저장합니다.)" +
						"<br/><br/>실제 서버 DB에 저장되는 형태는 아래의 그림과 같습니다. (실제 DB 데이터의 스크린샷입니다)",
				"en":""
			},
			p5: {
				"jp":"<br/>ここの４番目のものがGoogle IDを変換したTokenです" +
						" 他のはeAmusementGateからの表示されるデータを持ってきたものです",
				"ko":"<br/>여기서 4번째 칸의 것이 Google ID를 변환하여 저장된 Token입니다." +
						" 나머지는 eAmusementGate에 표시되는 데이터를 긁어온 가져온 게임 데이터입니다.",
				"en":""
			},
			p6: {
				"jp":"つまり、GITADORA Infoのサーバーにはゲームに関する情報以外の" +
						"Googleアカウントや他の個人情報は一切保存しません",
				"ko":"즉, GITADORA Info의 서버에는 게임과 관련된 정보를 제외하고는" +
						" Google 계정이나 다른 아무런 개인정보도 서버에 저장하지 않습니다.",
				"en":""
			},
			p7: {
				"jp":"Twitterも選択できたんですが、Googleを選んだ理由は" +
						"TwitterよりはGoogleを使ってる人が多く、" +
						"不便を最小限にするためです。",
				"ko":"Twitter도 선택할 수 있었겠지만 굳이 Google을 선택한 이유는" +
						" Twitter를 사용하는 사람보다는 Google을 사용하는 사람이 많고" +
						" 이에 따른 불편함을 최소한으로 줄이기 위함입니다.",
				"en":""
			}
		}
	},
	login: {
		title: {
			"jp":"ログイン",
			"ko":"로그인",
			"en":"Sign up"
		},
		google: {
			"jp":"GITADORA InfoはGoogleのアカウントを使ったログインができます",
			"ko":"GITADORA Info는 구글 계정을 사용한 로그인만을 지원합니다.",
			"en":"GITADORA Info only uses Google account login"
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