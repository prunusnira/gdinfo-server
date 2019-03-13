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
var towerName = new Array();
towerName["towerDmDKDK"] = {
	"jp":"DKDKの塔",
	"ko":"DKDK의 탑",
	"en":"Tower of DKDK"
};

towerName["towerDmLeftPedal"] = {
		"jp":"左足の塔",
		"ko":"왼페달의 탑",
		"en":"Tower of LeftPedal"
};

towerName["towerDmNote"] = {
		"jp":"処理力の塔",
		"ko":"처리력의 탑",
		"en":"Tower of Note"
};

towerName["towerDmFc"] = {
		"jp":"フルコンの塔(DM)",
		"ko":"풀콤보의 탑(DM)",
		"en":"Tower of FullCombo(D)"
};

towerName["towerGfChord"] = {
		"jp":"運指の塔",
		"ko":"코드의 탑",
		"en":"Tower of Chord"
};

towerName["towerGfAlter"] = {
		"jp":"オルタの塔",
		"ko":"얼터네이트 피킹의 탑",
		"en":"Tower of Alter"
};

towerName["towerGfMixed"] = {
		"jp":"運指オルタの塔",
		"ko":"복합패턴의 탑",
		"en":"Tower of Mixed"
};

towerName["towerGfFc"] = {
		"jp":"フルコンの塔(GF)",
		"ko":"풀콤보의 탑(GF)",
		"en":"Tower of FullCombo(G)"
};

towerName["towerTest"] = {
		"jp":"",
		"ko":"",
		"en":""
}

towerName["towerSpModelDD"] = {
	"jp":"The Day Dream",
	"ko":"The Day Dream",
	"en":"The Day Dream"
}

var towerDesc = new Array();
towerDesc["towerDmDKDK"] = {
	"jp":"(BPM) 1階: 130未満, 2階: 130~150, 3階: 150以上, 4階: 140未満 (EX), 5階: 140~170 (EX), 6階: 170~190, 7階: 190以上<br/>"+
	"This tower is associated with Approved DTX <a class='innerhref' href='https://www.youtube.com/watch?v=zgQMe-jKxtE'>Link to Video</a>",
	"ko":"(BPM 기준) 1층: 130 미만, 2층: 130~150, 3층: 150 이상, 4층: 140 미만 (EX), 5층: 140~170 (EX), 6층: 170~190, 7층: 190 이상<br/>"+
	"This tower is associated with Approved DTX <a class='innerhref' href='https://www.youtube.com/watch?v=zgQMe-jKxtE'>Link to Video</a>",
	"en":"(BPM) 1F: Under 130, 2F: 130~150, 3F: Over 150, 4F: Under 140 (EX), 5F: 140~170 (EX) 6F: 170~190, 7F: Over 190<br/>"+
	"This tower is associated with Approved DTX <a class='innerhref' href='https://www.youtube.com/watch?v=zgQMe-jKxtE'>Link to Video</a>"
};

towerDesc["towerDmLeftPedal"] = {
	"jp":"同時踏み、４・８ビートの左足などを練習する塔でございます。<br/>"+
	"This tower is associated with Approved DTX <a class='innerhref' href='https://www.youtube.com/watch?v=y_wyqiovt_w'>Link to Video</a>",
	"ko":"뚜벅이, 왼발곡들, 동시밟기, 4/8비트 햇페달 등을 연습할 수 있는 탑입니다.<br/>"+
	"This tower is associated with Approved DTX <a class='innerhref' href='https://www.youtube.com/watch?v=y_wyqiovt_w'>Link to Video</a>",
	"en":"This tower is for the practicing left pedal. You can practice 4/8beat pedals or pressing both pedals at the same time.<br/>"+
	"This tower is associated with Approved DTX <a class='innerhref' href='https://www.youtube.com/watch?v=y_wyqiovt_w'>Link to Video</a>"
};

towerDesc["towerDmNote"] = {
	"jp":"連打、タム、体力パターンなど色んなパターンのノーツを練習できる塔です。<br/>" +
			"S: 連打, T: タム, P: 体力",
	"ko":"연타, 탐, 체력곡 등 다양한 패턴의 노트를 연습할 수 있는 탑입니다.<br/>" +
			"S: 연타, T: 탐, P: 체력",
	"en":"This tower is for practicing notes that has stroke, tom and patterns that needs physical.<br/>" +
			"S: Stroke, T: Tom, P: Physical"
};

towerDesc["towerDmFc"] = {
	"jp":"フルコンボを目指しましょう！",
	"ko":"풀콤보를 노려봅시다!",
	"en":"Let's full combo!"
};

towerDesc["towerGfChord"] = {
	"jp":"階段、逆階段、ジグザグなどのコード関連のパターンを集めた塔です。",
	"ko":"계단, 역계단, 지그재그 등등 다양한 코드 관련 패턴을 모아둔 탑입니다.",
	"en":"This tower includes chord related patterns such as stairs, reverse stairs, zigzag"
};

towerDesc["towerGfAlter"] = {
	"jp":"オルタネイト・ピッキングのパターンを集めました。2/2, 3/3, 4/4などの速く運指が移動するオルタもあります。",
	"ko":"속주 혹은 얼터네이트 피킹 관련 패턴들을 모아둔 탑입니다. 2/2, 3/3, 4/4의 빠른 코드이동 속주도 포함되어 있습니다.",
	"en":"This tower is for practicing alternative pickings including fast chord movement of 2/2, 3/3, 4/4"
};

towerDesc["towerGfMixed"] = {
	"jp":"運指とオルタの実力が同時に必要となるパターンの塔です。総合的な処理力を要求します。",
	"ko":"코드 변환과 속주가 함께 나오는 패턴들을 모아두었습니다. 종합적인 처리력을 요구합니다.",
	"en":"This tower is for practicing overall techniques including chord and alternative picking."
};

towerDesc["towerGfFc"] = {
	"jp":"フルコンボを目指しましょう！",
	"ko":"풀콤보를 노려봅시다!",
	"en":"Let's full combo!"
};

towerDesc["towerTest"] = {
		"jp":"",
		"ko":"",
		"en":""
}

towerDesc["towerSpModelDD"] = {
	"jp":"「ギタドラ」って言うと思い出すあの曲! 1,3,5層はギタ、2,4,6層はドラです",
	"ko":"기타도라하면 생각나는 그 곡! 1, 3, 5층은 기타, 2, 4, 6층은 도라입니다.",
	"en":"The music that reminds you for the name GITADORA! GF patterns for floor 1, 3, 5, and DM patterns for floor 2, 4, 6"
}