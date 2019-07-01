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
var txtTerms = {
    title: {
        "jp":"利用規約",
        "ko":"이용약관",
        "en":"Terms and conditions"
    },
    s1t: {
        "jp":"1. サービス利用",
        "ko":"1. 서비스 이용",
        "en":"1. Using service"
    },
    s1c: {
        "jp":"本サービスのご利用は利用規約の同意としてみなします<br/>" +
                "本規約のすべての項目は韓国語の約款を基本にします",
        "ko":"본 서비스를 이용하는 것은 아래 약관을 동의하는 것으로 간주합니다.",
        "en":"Using this service is considered as agreement on this document<br/>" +
                "Please note that this document is based on Korean version"
    },
    s2t: {
        "jp":"2. 禁止事項",
        "ko":"2. 금지 사항",
        "en":"2. Prohibition"
    },
    s2c: {
        "jp":"下記の行為は記録抹消やIP遮断などの利用制限が受けることができます<br/>" +
                "1) サーバーに負担をかける行為<br/>" +
                "2) アップロードするjsonを操作して記録を変える行為<br/>" +
                "3) 本サービスの利用して金銭的利益を得る行為",
        "ko":"다음의 경우 기록 삭제, IP차단 등을 통해 서비스 이용에 제한을 받을 수 있습니다<br/>" +
                "1) 서버에 부하를 가하는 행위<br/>" +
                "2) 업로드하는 json을 변조하여 기록을 조작하는 행위<br/>" +
                "3) 본 사이트를 사용하여 금전적 이득을 취하는 행위",
        "en":"You can have restriction (Record delete, IP block) on using service from:<br/>" +
                "1) Overload on server<br/>" +
                "2) Illegally modifying json which is uploaded to server which makes record fudged<br/>" +
                "3) Taking economical advantage through this site"
    },
    s3t: {
        "jp":"3. 責任の限界",
        "ko":"3. 책임의 한계",
        "en":"3. Restriction on responsibility"
    },
    s3c: {
        "jp":"1) サービス提供者はサービスの維持が難しいと判断される時にサービスを中止できます<br/>" +
                "2) サービス提供者はサービス利用中eAmusementサービスからの警告や制限に責任を持っていません",
        "ko":"1) 서비스 제공자는 제공이 어렵거나 필요하다고 판단되는 경우 일시 혹은 영구적으로 서비스를 중지할 수 있습니다.<br/>" +
                "2) 서비스 제공 중 eAmusement 서비스로부터의 제재나 밴에 대해 서비스 제공자는 책임지지 않습니다.",
        "en":"1) Service provider can stop service temporary or permanently due to any reasons that makes hard to keep service<br/>" +
                "2) Service provider does not have any responsibility on service restriction or BAN from eAmusement service by using this service"
    },
    s4t: {
        "jp":"4. 収集情報",
        "ko":"4. 수집 정보",
        "en":"4. Data collected"
    },
    s4c: {
        "jp":"サービス提供のため下記のデータを利用者から取得します<br/>" +
                "1) Googleアカウントに登録されたe-mailアドレス<br/>" +
                "2) eAmusementに登録されたGITADORAのプレイデータ",
        "ko":"서비스 제공을 위해 사용자로부터 다음의 내용을 수집합니다.<br/>" +
                "1) Google 계정에 등록한 이메일 주소<br/>" +
                "2) eAmusement에 등록된 GITADORA 플레이 데이터",
        "en":"These data are collected to provide proper service<br/>" +
                "1) Google e-mail address<br/>" +
                "2) GITADORA play data registered on eAmusement"
    },
    s5t: {
        "jp":"5. 施行",
        "ko":"5. 시행",
        "en":"5. Effect"
    },
    s5c: {
        "jp":"この利用規約は2016年4月1日から有効です<br/>" +
                "改定履歴：2017年11月20日 - 英語の訳追加, eAmusementの名称変更<br/>" +
                "この文書は韓国語版を訳したものです。",
        "ko":"본 이용약관은 2016년 4월 1일부터 시행됩니다.<br/>" +
                "개정이력: 2017년 11월 20일 - 영문번역 추가, eAmusement 명칭변경",
        "en":"This document take effect from Apr. 1, 2016<br/>" +
                "Changes: Nov. 20, 2016 - English translation added, eAmusement name change<br/>" +
                "This document is translated version from Korean"
    }
};