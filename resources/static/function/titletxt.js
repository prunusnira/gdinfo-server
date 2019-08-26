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
		"dkdklv1" :        { "jp" : "DKDK Lv1",                 "ko" : "DKDK Lv1",             "en" : "DKDK Lv1" },
		"dkdklv1g" :      { "jp" : "DKDK Lv1(金)",             "ko" : "DKDK Lv1(금)",         "en" : "DKDK Lv1(G)" },
		"dkdklv2" :       { "jp" : "DKDK Lv2",                 "ko" : "DKDK Lv2",             "en" : "DKDK Lv2" },
		"dkdklv2g" :     { "jp" : "DKDK Lv2(金)",             "ko" : "DKDK Lv2(금)",         "en" : "DKDK Lv2(G)" },
		"dkdklv3" :       { "jp" : "DKDK Lv3",                 "ko" : "DKDK Lv3",             "en" : "DKDK Lv3" },
		"dkdklv3g" :     { "jp" : "DKDK Lv3(金)",             "ko" : "DKDK Lv3(금)",         "en" : "DKDK Lv3(G)" },
		"dkdklv4" :           { "jp" : "DKDK Lv4",                 "ko" : "DKDK Lv4",             "en" : "DKDK Lv4" },
		"dkdklv4g" :         { "jp" : "DKDK Lv3(金)",             "ko" : "DKDK Lv4(금)",         "en" : "DKDK Lv4(G)" },
		"dkdklv5" :           { "jp" : "DKDK Lv4",                  "ko" : "DKDK Lv5",                "en" : "DKDK Lv5" },
		"dkdklv5g" :         { "jp" : "DKDK Lv4(金)",              "ko" : "DKDK Lv5(금)",            "en" : "DKDK Lv5(G)" },
		"dkdklvm" :        { "jp" : "DKDK Master",              "ko" : "DKDK Master",             "en" : "DKDK Master" },
		"dkdklvmg" :      { "jp" : "DKDK Master(金)",          "ko" : "DKDK Master(금)",         "en" : "DKDK Master(G)" },
		"lplv1" :          { "jp" : "左足 Lv1",                 "ko" : "왼발 Lv1",             "en" : "L.Pedal Lv1" },
		"lplv1g" :        { "jp" : "左足 Lv1(金)",             "ko" : "왼발 Lv1(금)",         "en" : "L.Pedal Lv1(G)" },
		"lplv2" :         { "jp" : "左足 Lv2",                 "ko" : "왼발 Lv2",             "en" : "L.Pedal Lv2" },
		"lplv2g" :       { "jp" : "左足 Lv2(金)",             "ko" : "왼발 Lv2(금)",         "en" : "L.Pedal Lv2(G)" },
		"lplv3" :         { "jp" : "左足 Lv3",                 "ko" : "왼발 Lv3",             "en" : "L.Pedal Lv3" },
		"lplv3g" :       { "jp" : "左足 Lv3(金)",             "ko" : "왼발 Lv3(금)",         "en" : "L.Pedal Lv3(G)" },
		"lplv4" :             { "jp" : "左足 Lv4",                 "ko" : "왼발 Lv4",             "en" : "L.Pedal Lv4" },
		"lplv4g" :           { "jp" : "左足 Lv4(金)",             "ko" : "왼발 Lv4(금)",         "en" : "L.Pedal Lv4(G)" },
		"lplv5" :             { "jp" : "左足 Lv5",                 "ko" : "왼발 Lv5",             "en" : "L.Pedal Lv5" },
		"lplv5g" :           { "jp" : "左足 Lv5(金)",             "ko" : "왼발 Lv5(금)",         "en" : "L.Pedal Lv5(G)" },
		"lplvm" :          { "jp" : "左足 Master",             "ko" : "왼발 Master",           "en" : "L.Pedal Master" },
		"lplvmg" :        { "jp" : "左足 Master(金)",         "ko" : "왼발 Master(금)",       "en" : "L.Pedal Master(G)" },
		"notelv1" :        { "jp" : "処理力 Lv1",               "ko" : "처리력 Lv1",           "en" : "Note Lv1" },
		"notelv1g" :      { "jp" : "処理力 Lv1(金)",           "ko" : "처리력 Lv1(금)",       "en" : "Note Lv1(G)" },
		"notelv2" :       { "jp" : "処理力 Lv2",               "ko" : "처리력 Lv2",           "en" : "Note Lv2" },
		"notelv2g" :     { "jp" : "処理力 Lv2(金)",           "ko" : "처리력 Lv2(금)",       "en" : "Note Lv2(G)" },
		"notelv3" :       { "jp" : "処理力 Lv3",               "ko" : "처리력 Lv3",           "en" : "Note Lv3" },
		"notelv3g" :     { "jp" : "処理力 Lv3(金)",           "ko" : "처리력 Lv3(금)",       "en" : "Note Lv3(G)" },
		"notelv4" :           { "jp" : "処理力 Lv4",               "ko" : "처리력 Lv4",           "en" : "Note Lv4" },
		"notelv4g" :         { "jp" : "処理力 Lv4(金)",           "ko" : "처리력 Lv4(금)",       "en" : "Note Lv4(G)" },
		"notelv5" :           { "jp" : "処理力 Lv5",               "ko" : "처리력 Lv5",           "en" : "Note Lv5" },
		"notelv5g" :         { "jp" : "処理力 Lv5(金)",           "ko" : "처리력 Lv5(금)",       "en" : "Note Lv5(G)" },
		"notelvm" :        { "jp" : "処理力 Master",             "ko" : "처리력 Master",           "en" : "Note Master" },
		"notelvmg" :      { "jp" : "処理力 Master(金)",         "ko" : "처리력 Master(금)",       "en" : "Note Master(G)" },
		"dmfclv1" :        { "jp" : "ドラフルコン Lv1",           "ko" : "도라풀콤 Lv1",           "en" : "DMFC Lv1" },
		"dmfclv1g" :      { "jp" : "ドラフルコン Lv1(金)",       "ko" : "도라풀콤 Lv1(금)",       "en" : "DMFC Lv1(G)" },
		"dmfclv2" :       { "jp" : "ドラフルコン Lv2",           "ko" : "도라풀콤 Lv2",           "en" : "DMFC Lv2" },
		"dmfclv2g" :     { "jp" : "ドラフルコン Lv2(金)",       "ko" : "도라풀콤 Lv2(금)",       "en" : "DMFC Lv2(G)" },
		"dmfclv3" :       { "jp" : "ドラフルコン Lv3",           "ko" : "도라풀콤 Lv3",           "en" : "DMFC Lv3" },
		"dmfclv3g" :     { "jp" : "ドラフルコン Lv3(金)",       "ko" : "도라풀콤 Lv3(금)",       "en" : "DMFC Lv3(G)" },
		"dmfclv4" :           { "jp" : "ドラフルコン Lv4",           "ko" : "도라풀콤 Lv4",           "en" : "DMFC Lv4" },
		"dmfclv4g" :         { "jp" : "ドラフルコン Lv4(金)",       "ko" : "도라풀콤 Lv4(금)",       "en" : "DMFC Lv4(G)" },
		"dmfclv5" :           { "jp" : "ドラフルコン Lv5",           "ko" : "도라풀콤 Lv5",           "en" : "DMFC Lv5" },
		"dmfclv5g" :         { "jp" : "ドラフルコン Lv5(金)",       "ko" : "도라풀콤 Lv5(금)",       "en" : "DMFC Lv5(G)" },
		"dmfclvm" :        { "jp" : "ドラフルコン Master",       "ko" : "도라풀콤 Master",         "en" : "DMFC Master" },
		"dmfclvmg" :      { "jp" : "ドラフルコン Master(金)",   "ko" : "도라풀콤 Master(금)",     "en" : "DMFC Master(G)" },
		"chordlv1" :       { "jp" : "コード Lv1",               "ko" : "코드 Lv1",             "en" : "Chord Lv1" },
		"chordlv1g" :     { "jp" : "コード Lv1(金)",           "ko" : "코드 Lv1(금)",         "en" : "Chord Lv1(G)" },
		"chordlv2" :      { "jp" : "コード Lv2",               "ko" : "코드 Lv2",             "en" : "Chord Lv2" },
		"chordlv2g" :    { "jp" : "コード Lv2(金)",           "ko" : "코드 Lv2(금)",         "en" : "Chord Lv2(G)" },
		"chordlv3" :      { "jp" : "コード Lv3",               "ko" : "코드 Lv3",             "en" : "Chord Lv3" },
		"chordlv3g" :    { "jp" : "コード Lv3(金)",           "ko" : "코드 Lv3(금)",         "en" : "Chord Lv3(G)" },
		"chordlv4" :          { "jp" : "コード Lv4",               "ko" : "코드 Lv4",             "en" : "Chord Lv4" },
		"chordlv4g" :        { "jp" : "コード Lv4(金)",           "ko" : "코드 Lv4(금)",         "en" : "Chord Lv4(G)" },
		"chordlv5" :          { "jp" : "コード Lv5",               "ko" : "코드 Lv5",             "en" : "Chord Lv5" },
		"chordlv5g" :        { "jp" : "コード Lv5(金)",           "ko" : "코드 Lv5(금)",         "en" : "Chord Lv5(G)" },
		"chordlvm" :       { "jp" : "コード Master",             "ko" : "코드 Master",             "en" : "Chord Master" },
		"chordlvmg" :     { "jp" : "コード Master(金)",         "ko" : "코드 Master(금)",         "en" : "Chord Master(G)" },
		"alterlv1" :       { "jp" : "ピッキング Lv1",           "ko" : "피킹 Lv1",             "en" : "Picking Lv1" },
		"alterlv1g" :     { "jp" : "ピッキング Lv1(金)",       "ko" : "피킹 Lv1(금)",         "en" : "Picking Lv1(G)" },
		"alterlv2" :      { "jp" : "ピッキング Lv2",           "ko" : "피킹 Lv2",             "en" : "Picking Lv2" },
		"alterlv2g" :    { "jp" : "ピッキング Lv2(金)",       "ko" : "피킹 Lv2(금)",         "en" : "Picking Lv2(G)" },
		"alterlv3" :      { "jp" : "ピッキング Lv3",           "ko" : "피킹 Lv3",　           "en" : "Picking Lv3" },
		"alterlv3g" :    { "jp" : "ピッキング Lv3(金)",       "ko" : "피킹 Lv3(금)",         "en" : "Picking Lv3(G)" },
		"alterlv4" :          { "jp" : "ピッキング Lv4",           "ko" : "피킹 Lv4",             "en" : "Picking Lv4" },
		"alterlv4g" :        { "jp" : "ピッキング Lv4(金)",       "ko" : "피킹 Lv4(금)",         "en" : "Picking Lv4(G)" },
		"alterlv5" :          { "jp" : "ピッキング Lv5",             "ko" : "피킹 Lv5",             "en" : "Picking Lv5" },
		"alterlv5g" :        { "jp" : "ピッキング Lv5(金)",         "ko" : "피킹 Lv5(금)",         "en" : "Picking Lv5(G)" },
		"alterlvm" :       { "jp" : "ピッキング Master",         "ko" : "피킹 Master",             "en" : "Picking Master" },
		"alterlvmg" :     { "jp" : "ピッキング Master(金)",     "ko" : "피킹 Master(금)",         "en" : "Picking Master(G)" },
		"mixlv1" :         { "jp" : "ギター Lv1",               "ko" : "기타 Lv1",             "en" : "Guitar Lv1" },
		"mixlv1g" :       { "jp" : "ギター Lv1(金)",           "ko" : "기타 Lv1(금)",         "en" : "Guitar Lv1(G)" },
		"mixlv2" :        { "jp" : "ギター Lv2",               "ko" : "기타 Lv2",             "en" : "Guitar Lv2" },
		"mixlv2g" :      { "jp" : "ギター Lv2(金)",           "ko" : "기타 Lv2(금)",         "en" : "Guitar Lv2(G)" },
		"mixlv3" :        { "jp" : "ギター Lv3",               "ko" : "기타 Lv3",             "en" : "Guitar Lv3" },
		"mixlv3g" :      { "jp" : "ギター Lv3(金)",           "ko" : "기타 Lv3(금)",         "en" : "Guitar Lv3(G)" },
		"mixlv4" :            { "jp" : "ギター Lv4",               "ko" : "기타 Lv4",             "en" : "Guitar Lv4" },
		"mixlv4g" :          { "jp" : "ギター Lv4(金)",           "ko" : "기타 Lv4(금)",         "en" : "Guitar Lv4(G)" },
		"mixlv5" :            { "jp" : "ギター Lv5",               "ko" : "기타 Lv5",             "en" : "Guitar Lv5" },
		"mixlv5g" :          { "jp" : "ギター Lv5(金)",           "ko" : "기타 Lv5(금)",         "en" : "Guitar Lv5(G)" },
		"mixlvm" :         { "jp" : "ギター Master",             "ko" : "기타 Master",             "en" : "Guitar Master" },
		"mixlvmg" :       { "jp" : "ギター Master(金)",         "ko" : "기타 Master(금)",         "en" : "Guitar Master(G)" },
		"gffclv1" :        { "jp" : "ギターフルコン Lv1",             "ko" : "기타풀콤 Lv1",           "en" : "GFFC Lv1" },
		"gffclv1g" :      { "jp" : "ギターフルコン Lv1(金)",             "ko" : "기타풀콤 Lv1(금)",       "en" : "GFFC Lv1(G)" },
		"gffclv2" :       { "jp" : "ギターフルコン Lv2",             "ko" : "기타풀콤 Lv2",           "en" : "GFFC Lv2" },
		"gffclv2g" :     { "jp" : "ギターフルコン Lv2(金)",             "ko" : "기타풀콤 Lv2(금)",       "en" : "GFFC Lv2(G)" },
		"gffclv3" :       { "jp" : "ギターフルコン Lv3",             "ko" : "기타풀콤 Lv3",           "en" : "GFFC Lv3" },
		"gffclv3g" :     { "jp" : "ギターフルコン Lv3(金)",             "ko" : "기타풀콤 Lv3(금)",       "en" : "GFFC Lv3(G)" },
		"gffclv4" :           { "jp" : "ギターフルコン Lv4",             "ko" : "기타풀콤 Lv4",           "en" : "GFFC Lv4" },
		"gffclv4g" :         { "jp" : "ギターフルコン Lv4(金)",             "ko" : "기타풀콤 Lv4(금)",       "en" : "GFFC Lv4(G)" },
		"gffclv5" :           { "jp" : "ギターフルコン Lv5",             "ko" : "기타풀콤 Lv5",           "en" : "GFFC Lv5" },
		"gffclv5g" :         { "jp" : "ギターフルコン Lv5(金)",             "ko" : "기타풀콤 Lv5(금)",       "en" : "GFFC Lv5(G)" },
		"gffclvm" :        { "jp" : "ギターフルコン Master",             "ko" : "기타풀콤 Master",         "en" : "GFFC Master" },
		"gffclvmg" :      { "jp" : "ギターフルコン Master(金)",             "ko" : "기타풀콤 Master(금)",     "en" : "GFFC Master(G)" },
		"guitarking" :        { "jp" : "ギターの王",                 "ko" : "기타의 왕",              "en" : "King of GITA" },
		"guitaremperor" :     { "jp" : "ギターの覇王",               "ko" : "기타의 패왕",            "en" : "Emperor of GITA" },
		"guitargod" :         { "jp" : "ギターの神",                 "ko" : "기타의 신",              "en" : "God of GITA" },
		"drumking" :          { "jp" : "ドラムの王",                 "ko" : "드럼의 왕",              "en" : "King of DORA" },
		"drumemperor" :       { "jp" : "ドラムの覇王",               "ko" : "드럼의 패왕",            "en" : "Emperor of DORA" },
		"drumgod" :           { "jp" : "ドラムの神",                 "ko" : "드럼의 신",              "en" : "God of DORA" },
		"infodev" :           { "jp" : "GITADORA Info デベロッパー", "ko" : "기타도라인포 개발자",    "en" : "Dev of GITADORA Info" },
		"notitle" :           { "jp" : "NOTITLE", "ko" : "없음", "en" : "NOTITLE" },
		"testlv1" : {"jp":"TEST", "ko":"TEST", "en":"TEST"},
		"testlv1g" : {"jp":"TEST", "ko":"TEST", "en":"TEST"}
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