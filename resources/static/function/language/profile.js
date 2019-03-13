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
var txtProfile = {
    title: {
        "jp":"ユーザー情報",
        "ko":"유저 정보",
        "en":"About this user"
    },
    addr: {
        "jp":"現在のユーザーさんのプロフィールアドレス (クリックしてコピー): ",
        "ko":"이 사용자의 프로필 주소 (클릭 시 복사): ",
        "en":"Address of this profile page (Click to copy): "
    },
    userinfo: {
        title: {
            "jp":"ユーザー情報",
            "ko":"유저 정보",
            "en":"User Info"
        }
    },
    table1: {
        title: {
            "jp":"称号",
            "ko":"칭호",
            "en":"Title"
        },
        name: {
            "jp":"名",
            "ko":"이름",
            "en":"Name"
        },
        comment: {
            "jp":"コメント",
            "ko":"코멘트",
            "en":"Comment"
        }
    },
    detail: {
        "jp":"詳細情報",
        "ko":"상세 정보",
        "en":"Details"
    },
    button: {
        chkpskill: {
            "jp":"スキル表",
            "ko":"스킬 보기",
            "en":"Skill table"
        },
        setopencount: {
            "jp":"カウント公開",
            "ko":"카운트 공개",
            "en":"Open play count"
        },
        changecomment: {
            "jp":"コメント更新",
            "ko":"코멘트 변경",
            "en":"Change comment"
        },
        clearRankTable: {
            "jp":"クリア表",
            "ko":"클리어 표",
            "en":"Clear table"
        },
        mybest: {
            "jp":"マイベスト",
            "ko":"마이베스트",
            "en":"My best"
        },
        compare: {
            "jp":"スキル比較",
            "ko":"스킬비교",
            "en":"Skill comparision"
        },
        reset: {
            "jp":"スキルデータをリセット",
            "ko":"스킬데이터 리셋",
            "en":"Skill data reset"
        },
        rivaladd: {
            "jp":"ライバル登録",
            "ko":"라이벌 등록",
            "en":"Add as rival"
        },
        towerupdate: {
            "jp":"塔のクリア更新",
            "ko":"탑 클리어 상태 갱신",
            "en":"Update tower status"
        },
        towerstatus: {
            "jp":"塔のクリア現況",
            "ko":"탑 클리어 현황",
            "en":"Show tower status"
        }
    },
    detailed: {
        s: {
            "jp":"スキル",
            "ko":"스킬",
            "en":"Skill"
        },
        clv: {
            "jp":"クリア",
            "ko":"클리어",
            "en":"Clear"
        },
        flv: {
            "jp":"フルコン",
            "ko":"풀콤보",
            "en":"FC"
        },
        elv: {
            "jp":"エクセレント",
            "ko":"엑설런트",
            "en":"EXC"
        },
        count: {
            "jp":"プレー数",
            "ko":"플레이 수",
            "en":"Play count"
        },
        notopen: {
            "jp":"非公開",
            "ko":"비공개",
            "en":"Closed"
        },
        countdesc: {
            "jp":"プレー数について" +
                "* プレー数は今までプレーしたステージの数です(Stage Failedも含む)<br/>"+
                "* 公開設定により他人に見せることができます(基本非公開)<br/>" +
                "* 正確な計算のためには全曲のスキルデータが必要です<br/>" +
                "スキルデータをアップデートするとプレー数も一緒にアップデートします",
            "ko":"플레이 수에 대하여<br/>" +
                "* 플레이 수는 지금까지 플레이 한 총 스테이지 수 입니다(Stage Failed 포함).<br/>"+
                "* 공개 설정에 따라 다른 사람에게 보입니다(기본 비공개).<br/>" +
                "* 정확한 플레이 수의 계산을 위해서는 전곡 데이터가 필요합니다.",
            "en":"About play count<br/>" +
                "* Play count is sum of all number stages (Including stage failure)<br/>"+
                "* Others can or cannot see your data via your settings<br/>"+
                "* You need all pattern data to check exact play count"
        }
    },
    opencount: {
        current: {
            "jp":"現在のプレーカウント設定 ",
            "ko":"현재의 플레이카운트 설정 ",
            "en":"Open status - play count"
        },
        yes: {
            "jp":"公開",
            "ko":"공개",
            "en":"Opened"
        },
        no: {
            "jp":"非公開",
            "ko":"비공개",
            "en":"Closed"
        }
    },
    changecomment: {
        desc: {
            "jp":"コメントを入力してください（最大25字）",
            "ko":"변경할 코멘트를 입력하세요 (최대 25자)",
            "en":"Input your commend (Maximun 25)"
        }
    },
    towerupdate: {
        alert: {
            "jp":"この過程は最大２～３分掛かります（一般的に１０秒以内）。実行してからは完了のメッセージが出るまでこのページから離れないでください。",
            "ko":"이 과정은 최대 2~3분 소요되며 (일반적으로 10초 이내) 이 페이지를 벗어나면 실행이 취소될 수 있습니다. 완료 메시지가 뜰 때까지 이 페이지에 머물러주세요.",
            "en":"It takes maximum 2~3 minutes (normally within 10 sec) and DO NOT leave this page while executing it"
        },
        done: {
            "jp":"塔のデータを更新しました。",
            "ko":"탑 데이터 갱신이 완료되었습니다",
            "en":"Tower data updated"
        }
    }
};