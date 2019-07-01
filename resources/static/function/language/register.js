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
var txtRegister = {
    title: {
        "jp":"スキル登録",
        "ko":"스킬 등록",
        "en":"Skill register"
    },
    desc: {
        "jp":"ユーザーから直接スキルを登録します<br/>" +
                "バージョンで曲を探すのが難しい場合は検索でお願いします",
        "ko":"사용자가 직접 데이터를 등록합니다<br/>" +
                "버전 선택으로 곡을 찾기 어려운 경우 상단의 검색창에서 제목으로 검색하세요",
        "en":"User can add data manually<br/>" +
                "Select music from version or via search to add skill data"
    },
    regdesc: {
        "jp":"手書き更新では「プレイ回数」や「クリア回数」、「スキルメーター」は更新されません<br/>" +
                "また、「プレイ回数」は１になり、「マイベスト」の計算に影響を与えます<br/>" +
                "このデータを正常にするためには「自動更新」で更新してください",
        "ko":"수동 등록시에는 플레이/클리어 횟수, 스킬미터 정보는 갱신되지 않습니다.<br/>" +
                "또한 플레이 횟수가 강제로 1로 변경되어 마이베스트 계산에 영향을 미칩니다.<br/>" +
                "해당 데이터를 정상적으로 갱신하기 위해서는 업데이터를 사용하여 자동갱신 해주세요",
        "en":"Manual update does not change play/clear count and skill meter<br/>" +
                "Also, play count changes to 1 which influences my best calculation<br/>" +
                "These data will be restored if you use automatic updater"
    }
};