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
var titletxt = {
		"dkdknewbie" :        { "jp" : "DKDK入門者",                 "ko" : "DKDK입문자",             "en" : "DKDK Newbie" },
		"dkdknewbie_g" :      { "jp" : "DKDK入門者(金)",             "ko" : "DKDK입문자(금)",         "en" : "DKDK Newbie(G)" },
		"dkdkstarter" :       { "jp" : "DKDK初心者",                 "ko" : "DKDK초급자",             "en" : "DKDK Starter" },
		"dkdkstarter_g" :     { "jp" : "DKDK初心者(金)",             "ko" : "DKDK초급자(금)",         "en" : "DKDK Starter" },
		"dkdkamatuer" :       { "jp" : "DKDK中級者",                 "ko" : "DKDK중급자",             "en" : "DKDK Amateur" },
		"dkdkamatuer_g" :     { "jp" : "DKDK中級者(金)",             "ko" : "DKDK중급자(금)",         "en" : "DKDK Amateur(G)" },
		"dkdkadv" :           { "jp" : "DKDK上級者",                 "ko" : "DKDK상급자",             "en" : "DKDK Advanced" },
		"dkdkadv_g" :         { "jp" : "DKDK上級者(金)",             "ko" : "DKDK상급자(금)",         "en" : "DKDK Advanced(G)" },
		"dkdkpro" :           { "jp" : "DKDK達人",                  "ko" : "DKDK달인",                "en" : "DKDK Pro" },
		"dkdkpro_g" :         { "jp" : "DKDK達人(金)",              "ko" : "DKDK달인(금)",            "en" : "DKDK Pro(G)" },
		"dkdkmaster" :        { "jp" : "DKDKマスター",              "ko" : "DKDK마스터",             "en" : "DKDK Master" },
		"dkdkmaster_g" :      { "jp" : "DKDKマスター(金)",          "ko" : "DKDK마스터(금)",         "en" : "DKDK Master(G)" },
		"lpnewbie" :          { "jp" : "左足入門者",                 "ko" : "왼발입문자",             "en" : "L.Pedal Newbie" },
		"lpnewbie_g" :        { "jp" : "左足入門者(金)",             "ko" : "왼발입문자(금)",         "en" : "L.Pedal Newbie(G)" },
		"lpstarter" :         { "jp" : "左足初心者",                 "ko" : "왼발초급자",             "en" : "L.Pedal Starter" },
		"lpstarter_g" :       { "jp" : "左足初心者(金)",             "ko" : "왼발초급자(금)",         "en" : "L.Pedal Starter(G)" },
		"lpamatuer" :         { "jp" : "左足中級者",                 "ko" : "왼발중급자",             "en" : "L.Pedal Amateur" },
		"lpamatuer_g" :       { "jp" : "左足中級者(金)",             "ko" : "왼발중급자(금)",         "en" : "L.Pedal Amateur(G)" },
		"lpadv" :             { "jp" : "左足上級者",                 "ko" : "왼발상급자",             "en" : "L.Pedal Advanced" },
		"lpadv_g" :           { "jp" : "左足上級者(金)",             "ko" : "왼발상급자(금)",         "en" : "L.Pedal Advanced(G)" },
		"lppro" :             { "jp" : "左足の達人",                 "ko" : "왼발의달인",             "en" : "L.Pedal Pro" },
		"lppro_g" :           { "jp" : "左足の達人(金)",             "ko" : "왼발의달인(금)",         "en" : "L.Pedal Pro(G)" },
		"lpmaster" :          { "jp" : "左足のマスター",             "ko" : "왼발의마스터",           "en" : "L.Pedal Master" },
		"lpmaster_g" :        { "jp" : "左足のマスター(金)",         "ko" : "왼발의마스터(금)",       "en" : "L.Pedal Master(G)" },
		"notenewbie" :        { "jp" : "処理力入門者",               "ko" : "처리력입문자",           "en" : "Note Newbie" },
		"notenewbie_g" :      { "jp" : "処理力入門者(金)",           "ko" : "처리력입문자(금)",       "en" : "Note Newbie(G)" },
		"notestarter" :       { "jp" : "処理力初級者",               "ko" : "처리력초급자",           "en" : "Note Starter" },
		"notestarter_g" :     { "jp" : "処理力初級者(金)",           "ko" : "처리력초급자(금)",       "en" : "Note Starter(G)" },
		"noteamatuer" :       { "jp" : "処理力中級者",               "ko" : "처리력중급자",           "en" : "Note Amateur" },
		"noteamatuer_g" :     { "jp" : "処理力中級者(金)",           "ko" : "처리력중급자(금)",       "en" : "Note Amateur(G)" },
		"noteadv" :           { "jp" : "処理力上級者",               "ko" : "처리력상급자",           "en" : "Note Advanced" },
		"noteadv_g" :         { "jp" : "処理力上級者(金)",           "ko" : "처리력상급자(금)",       "en" : "Note Advanced(G)" },
		"notepro" :           { "jp" : "処理力の達人",               "ko" : "처리력의달인",           "en" : "Note Pro" },
		"notepro_g" :         { "jp" : "処理力の達人(金)",           "ko" : "처리력의달인(금)",       "en" : "Note Pro(G)" },
		"notemaster" :        { "jp" : "処理力マスター",             "ko" : "처리력마스터",           "en" : "Note Master" },
		"notemaster_g" :      { "jp" : "処理力マスター(金)",         "ko" : "처리력마스터(금)",       "en" : "Note Master(G)" },
		"dmfcnewbie" :        { "jp" : "ドラフルコン入門",           "ko" : "도라풀콤입문",           "en" : "DMFC Newbie" },
		"dmfcnewbie_g" :      { "jp" : "ドラフルコン入門(金)",       "ko" : "도라풀콤입문(금)",       "en" : "DMFC Newbie(G)" },
		"dmfcstarter" :       { "jp" : "ドラフルコン初級",           "ko" : "도라풀콤초급",           "en" : "DMFC Starter" },
		"dmfcstarter_g" :     { "jp" : "ドラフルコン初級(金)",       "ko" : "도라풀콤초급(금)",       "en" : "DMFC Starter(G)" },
		"dmfcamatuer" :       { "jp" : "ドラフルコン中級",           "ko" : "도라풀콤중급",           "en" : "DMFC Amateur" },
		"dmfcamatuer_g" :     { "jp" : "ドラフルコン中級(金)",       "ko" : "도라풀콤중급(금)",       "en" : "DMFC Amateur(G)" },
		"dmfcadv" :           { "jp" : "ドラフルコン上級",           "ko" : "도라풀콤상급",           "en" : "DMFC Advanced" },
		"dmfcadv_g" :         { "jp" : "ドラフルコン上級(金)",       "ko" : "도라풀콤상급(금)",       "en" : "DMFC Advanced(G)" },
		"dmfcpro" :           { "jp" : "ドラフルコン達人",           "ko" : "도라풀콤달인",           "en" : "DMFC Pro" },
		"dmfcpro_g" :         { "jp" : "ドラフルコン達人(金)",       "ko" : "도라풀콤달인(금)",       "en" : "DMFC Pro(G)" },
		"dmfcmaster" :        { "jp" : "ドラフルコンマスター",       "ko" : "도라풀콤마스터",         "en" : "DMFC Master" },
		"dmfcmaster_g" :      { "jp" : "ドラフルコンマスター(金)",   "ko" : "도라풀콤마스터(금)",     "en" : "DMFC Master(G)" },
		"chordnewbie" :       { "jp" : "コード入門者",               "ko" : "코드입문자",             "en" : "Chord Newbie" },
		"chordnewbie_g" :     { "jp" : "コード入門者(金)",           "ko" : "코드입문자(금)",         "en" : "Chord Newbie(G)" },
		"chordstarter" :      { "jp" : "コード初級者",               "ko" : "코드초급자",             "en" : "Chord Starter" },
		"chordstarter_g" :    { "jp" : "コード初級者(金)",           "ko" : "코드초급자(금)",         "en" : "Chord Starter(G)" },
		"chordamatuer" :      { "jp" : "コード中級者",               "ko" : "코드중급자",             "en" : "Chord Amateur" },
		"chordamatuer_g" :    { "jp" : "コード中級者(金)",           "ko" : "코드중급자(금)",         "en" : "Chord Amateur(G)" },
		"chordadv" :          { "jp" : "コード上級者",               "ko" : "코드상급자",             "en" : "Chord Advanced" },
		"chordadv_g" :        { "jp" : "コード上級者(金)",           "ko" : "코드상급자(금)",         "en" : "Chord Advanced(G)" },
		"chordpro" :          { "jp" : "コードの達人",               "ko" : "코드의달인",             "en" : "Chord Pro" },
		"chordpro_g" :        { "jp" : "コードの達人(金)",           "ko" : "코드의달인(금)",         "en" : "Chord Pro(G)" },
		"chordmaster" :       { "jp" : "コードマスター",             "ko" : "코드마스터",             "en" : "Chord Master" },
		"chordmaster_g" :     { "jp" : "コードマスター(金)",         "ko" : "코드마스터(금)",         "en" : "Chord Master(G)" },
		"alternewbie" :       { "jp" : "ピッキング入門者",           "ko" : "피킹입문자",             "en" : "Picking Newbie" },
		"alternewbie_g" :     { "jp" : "ピッキング入門者(金)",       "ko" : "피킹입문자(금)",         "en" : "Picking Newbie(G)" },
		"alterstarter" :      { "jp" : "ピッキング初級者",           "ko" : "피킹초급자",             "en" : "Picking Starter" },
		"alterstarter_g" :    { "jp" : "ピッキング初級者(金)",       "ko" : "피킹초급자(금)",         "en" : "Picking Starter(G)" },
		"alteramatuer" :      { "jp" : "ピッキング中級者",           "ko" : "피킹중급자",　           "en" : "Picking Amateur" },
		"alteramatuer_g" :    { "jp" : "ピッキング中級者(金)",       "ko" : "피킹중급자(금)",         "en" : "Picking Amateur(G)" },
		"alteradv" :          { "jp" : "ピッキング上級者",           "ko" : "피킹상급자",             "en" : "Picking Advanced" },
		"alteradv_g" :        { "jp" : "ピッキング上級者(金)",       "ko" : "피킹상급자(금)",         "en" : "Picking Advanced(G)" },
		"alterpro" :          { "jp" : "ピッキング達人",             "ko" : "피킹의달인",             "en" : "Picking Pro" },
		"alterpro_g" :        { "jp" : "ピッキング達人(金)",         "ko" : "피킹의달인(금)",         "en" : "Picking Pro(G)" },
		"altermaster" :       { "jp" : "ピッキングマスター",         "ko" : "피킹마스터",             "en" : "Picking Master" },
		"altermaster_g" :     { "jp" : "ピッキングマスター(金)",     "ko" : "피킹마스터(금)",         "en" : "Picking Master(G)" },
		"mixnewbie" :         { "jp" : "ギター入門者",               "ko" : "기타입문자",             "en" : "Guitar Newbie" },
		"mixnewbie_g" :       { "jp" : "ギター入門者(金)",           "ko" : "기타입문자(금)",         "en" : "Guitar Newbie(G)" },
		"mixstarter" :        { "jp" : "ギター初級者",               "ko" : "기타초급자",             "en" : "Guitar Starter" },
		"mixstarter_g" :      { "jp" : "ギター初級者(金)",           "ko" : "기타초급자(금)",         "en" : "Guitar Starter(G)" },
		"mixamatuer" :        { "jp" : "ギター中級者",               "ko" : "기타중급자",             "en" : "Guitar Amateur" },
		"mixamatuer_g" :      { "jp" : "ギター中級者(金)",           "ko" : "기타중급자(금)",         "en" : "Guitar Amateur(G)" },
		"mixadv" :            { "jp" : "ギター上級者",               "ko" : "기타상급자",             "en" : "Guitar Advanced" },
		"mixadv_g" :          { "jp" : "ギター上級者(金)",           "ko" : "기타상급자(금)",         "en" : "Guitar Advanced(G)" },
		"mixpro" :            { "jp" : "ギターの達人",               "ko" : "기타의달인",             "en" : "Guitar Pro" },
		"mixpro_g" :          { "jp" : "ギターの達人(金)",           "ko" : "기타의달인(금)",         "en" : "Guitar Pro(G)" },
		"mixmaster" :         { "jp" : "ギターマスター",             "ko" : "기타마스터",             "en" : "Guitar Master" },
		"mixmaster_g" :       { "jp" : "ギターマスター(金)",         "ko" : "기타마스터(금)",         "en" : "Guitar Master(G)" },
		"gffcnewbie" :        { "jp" : "ギターフルコン",             "ko" : "기타풀콤입문",           "en" : "GFFC Newbie" },
		"gffcnewbie_g" :      { "jp" : "ギターフルコン",             "ko" : "기타풀콤입문(금)",       "en" : "GFFC Newbie(G)" },
		"gffcstarter" :       { "jp" : "ギターフルコン",             "ko" : "기타풀콤초급",           "en" : "GFFC Starter" },
		"gffcstarter_g" :     { "jp" : "ギターフルコン",             "ko" : "기타풀콤초급(금)",       "en" : "GFFC Starter(G)" },
		"gffcamatuer" :       { "jp" : "ギターフルコン",             "ko" : "기타풀콤중급",           "en" : "GFFC Amateur" },
		"gffcamatuer_g" :     { "jp" : "ギターフルコン",             "ko" : "기타풀콤중급(금)",       "en" : "GFFC Amateur(G)" },
		"gffcadv" :           { "jp" : "ギターフルコン",             "ko" : "기타풀콤상급",           "en" : "GFFC Advanced" },
		"gffcadv_g" :         { "jp" : "ギターフルコン",             "ko" : "기타풀콤상급(금)",       "en" : "GFFC Advanced(G)" },
		"gffcpro" :           { "jp" : "ギターフルコン",             "ko" : "기타풀콤달인",           "en" : "GFFC Pro" },
		"gffcpro_g" :         { "jp" : "ギターフルコン",             "ko" : "기타풀콤달인(금)",       "en" : "GFFC Pro(G)" },
		"gffcmaster" :        { "jp" : "ギターフルコン",             "ko" : "기타풀콤마스터",         "en" : "GFFC Master" },
		"gffcmaster_g" :      { "jp" : "ギターフルコン",             "ko" : "기타풀콤마스터(금)",     "en" : "GFFC Master(G)" },
		"guitarking" :        { "jp" : "ギターの王",                 "ko" : "기타의 왕",              "en" : "King of GITA" },
		"guitaremperor" :     { "jp" : "ギターの覇王",               "ko" : "기타의 패왕",            "en" : "Emperor of GITA" },
		"guitargod" :         { "jp" : "ギターの神",                 "ko" : "기타의 신",              "en" : "God of GITA" },
		"drumking" :          { "jp" : "ドラムの王",                 "ko" : "드럼의 왕",              "en" : "King of DORA" },
		"drumemperor" :       { "jp" : "ドラムの覇王",               "ko" : "드럼의 패왕",            "en" : "Emperor of DORA" },
		"drumgod" :           { "jp" : "ドラムの神",                 "ko" : "드럼의 신",              "en" : "God of DORA" },
		"infodev" :           { "jp" : "GITADORA Info デベロッパー", "ko" : "기타도라인포 개발자",    "en" : "Dev of GITADORA Info" },
		"notitle" :           { "jp" : "NOTITLE", "ko" : "없음", "en" : "NOTITLE" }
    };

var titlesp = {
	// war evasion mas-d
	660: {
		type: 0,
		12: {
			value: "warevasion_masd",
			"jp":"神の足", "ko":"신의 다리", "en":"God Leg"
		}
	},
	// 밤부소드걸
	691: {
		type: 2,
		12: {
			value: "bamboosword_masd",
			"jp":"スピードラナー", "ko":"스피드러너", "en":"Speed Runner"
		},
		value: "bamboosword",
		"jp":"バンブーソードガール",
		"ko":"대나무 검 소녀",
		"en":"Bamboo Sword Girl"
	},
	// 퍼펙트월드
	1117: {
		type: 1,
		value: "perfectworld",
		"jp":"素晴らしき素敵な世界",
		"ko":"정말 멋진 세계야",
		"en":"What a beautiful world"
	},
	// 존네
	260: {
		type: 1,
		value: "sonne",
		"jp":"BLAZING!!!",
		"ko":"BURNING!!!",
		"en":"BLAZING!!!"
	},
	// 100초
	31: {
		type: 1,
		value: "100sec",
		"jp":"一番緊張する100秒",
		"ko":"가장 긴장되는 100초",
		"en":"The most intense 100 sec"
	},
	// 탐피
	112: {
		type: 0,
		5: {
			value: "timepiece_bscb",
			"jp":"ピッキングの始まり", "ko":"피킹의 시작", "en":"Start of picking"
		},
		8: {
			value: "timepiece_masb",
			"jp":"ピッキングの終わり", "ko":"피킹의 끝", "en":"End of picking"
		}
	},
	// 락 투 인피니티
	234: {
		type: 1,
		value: "rocktoinfinity",
		"jp":"Rock to Infinity",
		"ko":"Rock to Infinity",
		"en":"Rock to Infinity"
	},
	// 네코네코
	739: {
		type: 1,
		value: "nekoneko",
		"jp":"モフモフ",
		"ko":"모후모후",
		"en":"Shaggy Kitty"
	},
	// 모후모후
	1033: {
		type: 1,
		value: "mohumohu",
		"jp":"ねこねこ",
		"ko":"네코네코",
		"en":"neko*neko"
	},
	// 모나리자
	327: {
		type: 0,
		11: {
			value: "monariza_extd",
			"jp":"私も足マスター？", "ko":"나도 발 마스터?", "en":"Am I kick master?"
		}
	},
	// 워크 위드 유
	263: {
		type: 0,
		11: {
			value: "walkwithyou_extd",
			"jp":"拍子感回復", "ko":"박치탈출", "en":"Get used to beat"
		}
	},
	// 군청과 유성
	444: {
		type: 0,
		11: {
			value: "yuusei_extd",
			"jp":"左足が痛いよ", "ko":"왼발 아파", "en":"No more for my left leg"
		}
	},
	// 젯월드
	10: {
		type: 1,
		value: "jetworld",
		"jp":"おっさん",
		"ko":"아조시...",
		"en":"Oldies Goodies"
	},
	// 스카이스크래퍼
	749: {
		type: 1,
		value: "skyscraper",
		"jp":"高いところは危ない",
		"ko":"높은 곳은 위험해",
		"en":"Too danterous"
	},
	// 노모어소로우
	1099: {
		type: 1,
		value: "nomoresorrow",
		"jp":"Dont worry be happy",
		"ko":"Dont worry be happy",
		"en":"Dont worry be happy"
	},
	// IMI
	291: {
		type: 0,
		3: {
			value: "imi_extg",
			"jp":"細長いモチはお好きですか？",
			"ko":"가래떡 좋아하세요?",
			"en":"Do you like rice cake?"
		}
	},
	// 포리프
	250: {
		type: 1,
		value: "fourleaf",
		"jp":"よつばのクローバー",
		"ko":"네잎클로버",
		"en":"Four leafs Clover"
	},
	// 킵유어드림
	296: {
		type: 1,
		value: "keepurdream",
		"jp":"Make your dream come true",
		"ko":"Make your dream come true",
		"en":"Make your dream come true"
	},
	// 페어리테일즈
	142: {
		type: 1,
		value: "fairytales",
		"jp":"Fairy Lv.1",
		"ko":"Fairy Lv.1",
		"en":"Fairy Lv.1"
	},
	// 린트블룸
	624: {
		type: 1,
		value: "lindwurm",
		"jp":"Maudかわいい",
		"ko":"Maud 귀여워",
		"en":"Maud is cute"
	},
	// dd5
	109: {
		type: 1,
		value: "modeldd5",
		"jp":"見てるぞ",
		"ko":"지켜보고있다",
		"en":"I am watching you"
	},
	// 무중력다이브
	785: {
		type: 1,
		value: "nogravitydive",
		"jp":"イブだぜっ！",
		"ko":"이브다젯!",
		"en":"Ibudaze!"
	},
	// 미스티레이크
	1088: {
		type: 1,
		value: "mistylake",
		"jp":"おっさん、風呂でカッコつけってんじゃないよ",
		"ko":"아저씨 목욕탕에서 폼잡는거 아니에요",
		"en":"Hey, stop posing in public bath"
	},
	// 잇떼
	1263: {
		type: 1,
		value: "itte",
		"jp":"もっとやれ",
		"ko":"ㄷㅓ",
		"en":"Do more"
	},
	// 도키메키 발렌타인
	807: {
		type: 1,
		value: "valentine",
		"jp":"りおちゃんのチョコ",
		"ko":"리오쟝의 초콜릿",
		"en":"Chocolate, made by Rio"
	},
	// DD1
	23: {
		type: 1,
		value: "modeldd1",
		"jp":"は!?",
		"ko":"하!?",
		"en":"Ha!?"
	},
	// dd2
	55: {
		type: 1,
		value: "modeldd2",
		"jp":"DD2",
		"ko":"DD2",
		"en":"DD2"
	},
	// dd3
	72: {
		type: 1,
		value: "modeldd3",
		"jp":"DD3",
		"ko":"DD3",
		"en":"DD3"
	},
	// dd4
	92: {
		type: 1,
		value: "modeldd4",
		"jp":"DD4",
		"ko":"DD4",
		"en":"DD4"
	},
	// dd6
	122: {
		type: 1,
		value: "modeldd6",
		"jp":"DD6",
		"ko":"DD6",
		"en":"DD6"
	},
	// dd7
	166: {
		type: 1,
		value: "modeldd7",
		"jp":"DD7",
		"ko":"DD7",
		"en":"DD7"
	},
	// dd8
	205: {
		type: 1,
		value: "modeldd8",
		"jp":"DD8",
		"ko":"DD8",
		"en":"DD8"
	},
	// dd9
	300: {
		type: 1,
		value: "modeldd9",
		"jp":"CUBE",
		"ko":"CUBE",
		"en":"CUBE"
	},
	// dd10
	414: {
		type: 1,
		value: "modeldd10",
		"jp":"DD10",
		"ko":"DD10",
		"en":"DD10"
	},
	// ddult
	644: {
		type: 1,
		value: "modelddu",
		"jp":"Ultimate Power",
		"ko":"Ultimate Power",
		"en":"Ultimate Power"
	},
	// dd11
	753: {
		type: 1,
		value: "modeldd11",
		"jp":"Over the Decades",
		"ko":"Over the Decades",
		"en":"Over the Decades"
	},
	// ft2
	184: {
		type: 1,
		value: "modelft2",
		"jp":"Fairy Lv.2",
		"ko":"Fairy Lv.2",
		"en":"Fairy Lv.2"
	},
	// ft3
	507: {
		type: 1,
		value: "modelft3",
		"jp":"Fairy Lv.3",
		"ko":"Fairy Lv.3",
		"en":"Fairy Lv.3"
	},
	// ft4
	1208: {
		type: 1,
		value: "modelft4",
		"jp":"Fairy Lv.4",
		"ko":"Fairy Lv.4",
		"en":"Fairy Lv.4"
	},
	// ft2 miracle
	185: {
		type: 1,
		value: "modelft2m",
		"jp":"Fairy Lv.MAX",
		"ko":"Fairy Lv.MAX",
		"en":"Fairy Lv.MAX"
	},
	// i'm gonna get you
	25: {
		type: 1,
		value: "gonnagetyou",
		"jp":"私のものになれ",
		"ko":"쟁취하고 말것이다",
		"en":"Gonna Get You"
	},
	// toxic vibration
	658: {
		type: 1,
		value: "toxicvibration",
		"jp":"毒とヴァイブレーションってどんな関係が...",
		"ko":"독이랑 진동이랑 무슨 관계가...",
		"en":"What is related between TOXIC and VIBRATION?"
	},
	// yukyuu no pegasus
	804: {
		type: 1,
		value: "pegasus",
		"jp":"悠久のリフレシア",
		"ko":"유구의 리플레시아",
		"en":"The Reflesia of Eternity"
	},
	// souhaku
	116: {
		type: 1,
		value: "souhaku",
		"jp":"蒼白",
		"ko":"창백",
		"en":"Pure White"
	},
	// haunted maid lunch
	608: {
		type: 1,
		value: "hauntedmaid",
		"jp":"闇に落ちる",
		"ko":"흑화",
		"en":"Become Corrupted"
	},
	// going my way
	240: {
		type: 1,
		value: "goingmyway",
		"jp":"ゴーイング・マイ・ウェイ",
		"ko":"고잉 마이 웨이",
		"en":"Going My Way"
	},
	// x-treme grade
	311: {
		type: 1,
		value: "xtremegrade",
		"jp":"You Hope to X-Grade on Here!",
		"ko":"You Hope to X-Grade on Here!",
		"en":"You Hope to X-Grade on Here!"
	},
	// no reason of fear
	757: {
		type: 1,
		value: "noreason",
		"jp":"鷲",
		"ko":"독수리",
		"en":"Eagle"
	},
	// the fourth interval
	1089: {
		type: 1,
		value: "fourthinterval",
		"jp":"象",
		"ko":"코끼리",
		"en":"Elephant"
	},
	// russian caravan rhapsody
	745: {
		type: 1,
		value: "russiancaravan",
		"jp":"ロック・メイリン",
		"ko":"락 메이링",
		"en":"Rock Mei Ling"
	},
	// eight
	465: {
		type: 1,
		value: "eight",
		"jp":"ベー",
		"ko":"메롱",
		"en":"Teasing"
	},
	// my way my life
	1036: {
		type: 1,
		value: "mywaymylife",
		"jp":"人生...",
		"ko":"인생...",
		"en":"Life..."
	},
	// jyuudan
	1166: {
		type: 1,
		value: "jyuudan",
		"jp":"ミリタリーいやです",
		"ko":"밀리터리 시러요",
		"en":"I don't like military"
	},
	// 3am detective
	788: {
		type: 1,
		value: "3amdetective",
		"jp":"夜明けに寝る良い子",
		"ko":"새벽에 자는 착한 어린이",
		"en":"Good kids sleep at dawn"
	},
	// alternative tactics
	722: {
		type: 1,
		value: "alternativetactics",
		"jp":"今日も楽しい大和さん",
		"ko":"오늘도 신난 야마토씨",
		"en":"Yamato-san having good day"
	},
	// catharsis no tsuki
	561: {
		type: 1,
		value: "catharsistsuki",
		"jp":"月下のお嫁さん",
		"ko":"월하의 신부",
		"en":"Bride under the moon"
	},
	// miracle sweet sweets magic
	1163: {
		type: 1,
		value: "miraclesweet",
		"jp":"甘いもの大好き",
		"ko":"단거 좋아요",
		"en":"I like sweets!"
	},
	// pokapoka retrode
	784: {
		type: 1,
		value: "pokapoka",
		"jp":"ぽかぽか",
		"ko":"따끈따끈",
		"en":"It's warm"
	},
	// knight of rondo
	1164: {
		type: 1,
		value: "knightofrondo",
		"jp":"ドヤッ！",
		"ko":"도얏!",
		"en":"Hah!"
	},
	// ding dong bell
	1119: {
		type: 1,
		value: "dingdongbell",
		"jp":"太陽万歳！",
		"ko":"태양만세!",
		"en":"Praise the Sun"
	},
	// onkochisin
	667: {
		type: 0,
		11: {
			value: "onkochisin_extd",
			"jp":"どこでも堂々と歩こう",
			"ko":"어디서나 당당하게 걷기",
			"en":"Walk proudly"
		}
	},
	// fuwafuwa
	786: {
		type: 1,
		value: "fuwafuwa",
		"jp":"ふわふわ",
		"ko":"둥실둥실",
		"en":"Soften"
	},
	// fire2
	1244: {
		type: 1,
		value: "fire2",
		"jp":"野生動物を守りましょう",
		"ko":"야생동물을 보호합시다",
		"en":"Let's protect animals"
	},
	// ichimoudajin
	218: {
		type: 1,
		value: "ichimoudajin",
		"jp":"Rock x Rock",
		"ko":"Rock x Rock",
		"en":"Rock x Rock"
	},
	// sikkoku no special princess sundae
	741: {
		type: 1,
		value: "specialprincesssundae",
		"jp":"日曜日にはサンデーアイスクリーム",
		"ko":"일요일엔 선데 아이스크림",
		"en":"Sundae ice cream for Sunday"
	},
	// flutter genshou no tenmatsu to tanitsu sikousei no kanjyouron
	743: {
		type: 1,
		value: "fluttergenshou",
		"jp":"理系はダメ",
		"ko":"이과 그만",
		"en":"No more science"
	},
	// phantom veronica
	795: {
		type: 1,
		value: "phantomveronica",
		"jp":"Jail Breaker",
		"ko":"Jail Breaker",
		"en":"Jail Breaker"
	},
	// summer holiday
	437: {
		type: 1,
		value: "summerholiday",
		"jp":"夏休み",
		"ko":"여름방학",
		"en":"Summer holiday"
	},
	// nijiiro yuuenchi
	771: {
		type: 1,
		value: "nijiiroyuuenchi",
		"jp":"ランド行きたい",
		"ko":"에버랜드 가고싶다",
		"en":"I want to go to amusement park"
	},
	// over there
	167: {
		type: 1,
		value: "overthere",
		"jp":"超えてみろ",
		"ko":"넘어보아라",
		"en":"Go beyond"
	},
	// death bringer
	632: {
		type: 1,
		value: "deathbringer",
		"jp":"アンダーテイカー",
		"ko":"언더테이커",
		"en":"Undertaker"
	},
	// kemono no ousya meumeu
	1172: {
		type: 1,
		value: "kemonomeumeu",
		"jp":"め↘う↗！",
		"ko":"메↘우↗!",
		"en":"ME↘U↗！"
	},
	// sweet feelin'
	1204: {
		type: 1,
		value: "sweetfeelin",
		"jp":"甘いコーヒーのように",
		"ko":"달달한 커피와 같이",
		"en":"Like sweet coffee"
	},
	// takaramono
	379: {
		type: 1,
		value: "takaramono",
		"jp":"つ！でぃ！えくす！",
		"ko":"투!디!엑스!",
		"en":"II!D!X!"
	}
}