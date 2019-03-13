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
var txtAbout0 = {
    update_au: {
        "jp":"自動更新",
        "ko":"자동 갱신",
        "en":"Auto update"
    },
    update_man: {
        "jp":"手動更新",
        "ko":"수동 갱신",
        "en":"Manual update"
    },
    filter_rival: {
        "jp":"フィルター・ライバル",
        "ko":"필터, 라이벌",
        "en":"Filter, rival"
    },
    desc: {
        "jp":"GITADORA Infoの使い方を説明します",
        "ko":"GITADORA Info의 사용법을 설명합니다",
        "en":"Introduce how to use GITADORA Info"
    },
    copy: {
        "jp":"下のボタンをを押すと「j」以外の" +
            "avascript:$.getScript('https://gitadora.info/$/update');" +
            "をコピーします。jだけ入力して他のはペーストしてください",
        "ko":"아래 버튼를 누르면 j를 제외한" +
                "avascript:$.getScript('https://gitadora.info/$/update');" +
                "를 복사합니다. j만 입력 후 나머지는 붙여넣기 하시면 됩니다.",
        "en":"Touch the button below to copy script. It copies script except j, which means "+
                "「avascript:$.getScript('https://gitadora.info/$/update');」"+
                "is copied. Just input 'j' and paste on the address bar."
    },
    device: {
        pc: {
            "jp":"パソコンで",
            "ko":"PC로",
            "en":"with PC"
        },
        mo: {
            "jp":"スマホで",
            "ko":"스마트폰으로",
            "en":"with smartphone"
        }
    },
    pc: {
        title: {
            "jp":"パソコンでデータ更新",
            "ko":"PC로 업데이트 하기",
            "en":"Update with PC"
        },
        step1: {
            title: {
                "jp":"1. 新規登録",
                "ko":"1. 회원 가입",
                "en":"1. Sign up"
            },
            desc: {
                "jp":"上のログインボタンを押してGoogleアカウントでログインすると登録に入ります",
                "ko":"상단에서 로그인 버튼을 눌러 구글 아이디로 로그인하면 회원등록 과정으로 진행됩니다",
                "en":"Click Sign in/up button to login with Google account to start sign up process"
            }
        },
        step2: {
            title: {
                "jp":"2. アップデーター実行スクリプト",
                "ko":"2. 업데이터 실행 스크립트",
                "en":"2. Updater execution script"
            },
            desc: {
                "jp":"下記のスクリプトをコピーしてから「３．アップデート方法」に進みます",
                "ko":"아래의 스크립트를 복사한 후 「3. 업데이트 방법」으로 진행합니다",
                "en":"Copy the script and proceed to 「3. Update process」"
            },
            addr1desc: {
                "jp":"スクリプト",
                "ko":"스크립트",
                "en":"Script"
            },
            cardt1: {
                "jp":"1) 現在起動中のバージョン",
                "ko":"1) 현재 가동중인 버전",
                "en":"1) Current version"
            },
            cardt2: {
                "jp":"2) 旧作 (MATIXX, Tri-Boost Re:Evolve)",
                "ko":"2) 구버전 (MATIXX, Tri-Boost Re:Evolve)",
                "en":"2) Old version (MATIXX, Tri-Boost Re:Evolve)"
            },
            addr1:"<b>javascript:$.getScript('https://gitadora.info/$/update');</b>",
            addr2:"<b>javascript:$.getScript('https://gitadora.info/$/updateOld');</b>",
            copy1: {
                "jp":"下のボタンをを押すと「j」以外の" +
                    "avascript:$.getScript('https://gitadora.info/$/update');" +
                    "をコピーします。jだけ入力して他のはペーストしてください",
                "ko":"아래 버튼를 누르면 j를 제외한" +
                        "avascript:$.getScript('https://gitadora.info/$/update');" +
                        "를 복사합니다. j만 입력 후 나머지는 붙여넣기 하시면 됩니다.",
                "en":"Touch the button below to copy script. It copies script except j, which means "+
                        "「avascript:$.getScript('https://gitadora.info/$/update');」"+
                        "is copied. Just input 'j' and paste on the address bar."
            },
            copy2: {
                "jp":"下のボタンをを押すと「j」以外の" +
                    "avascript:$.getScript('https://gitadora.info/$/updateOld');" +
                    "をコピーします。jだけ入力して他のはペーストしてください",
                "ko":"아래 버튼를 누르면 j를 제외한" +
                        "avascript:$.getScript('https://gitadora.info/$/updateOld');" +
                        "를 복사합니다. j만 입력 후 나머지는 붙여넣기 하시면 됩니다.",
                "en":"Touch the button below to copy script. It copies script except j, which means "+
                        "「avascript:$.getScript('https://gitadora.info/$/updateOld');」"+
                        "is copied. Just input 'j' and paste on the address bar."
            }
        },
        step3: {
            title: {
                "jp":"3. 更新方法",
                "ko":"3. 업데이트 방법",
                "en":"3. Update process"
            },
            s1: {
                "jp":"1) ブラウザーを起動します。<a href='https://chrome.google.com/'>Google Chrome</a>をおすすめします。<br/>"+
                    "<b style='color:red;'>Internet Explorerは使えません</b>",
                "ko":"1) 브라우저를 엽니다. <a href='https://chrome.google.com/'>Google Chrome</a>을 권장합니다.<br/>"+
                    "<b style='color:red;'>Internet Explorer는 지원하지 않습니다</b>",
                "en":"1) Open browser. We recommend you to use <a href='https://chrome.google.com/'>Google Chrome</a><br/>"+
                    "<b style='color:red;'>We does not support Internet Explorer</b>"
            },
            s2: {
                "jp":"2) <a class='innerhref' href='https://p.eagate.573.jp/'>eAmusement</a>から「ログイン」してください",
                "ko":"2) <a class='innerhref' href='https://p.eagate.573.jp/'>eAmusement</a>에 로그인 해주세요.",
                "en":"2) Please sign in at <a class='innerhref' href='https://p.eagate.573.jp/'>eAmusement</a>"
            },
            s3: {
                "jp":"3) もし複数のカードを使用している方は上の「e-AMUSEMENT」メニューで...",
                "ko":"3) 만약 카드를 여러장 쓰고 있다면 위에서 e-AMUSEMENT 메뉴를 누르고...",
                "en":"3) If you use muleiple cards, first, select e-Amusement menu..."
            },
            s4: {
                "jp":"4) 「参照e-AMUSEMENT PASSの切り替え」から",
                "ko":"4) '사용 중인 카드 변경' 메뉴로 들어가서",
                "en":"4) Go to 'Card exchange' menu"
            },
            s5: {
                "jp":"5) ご使用になるカードを選びます",
                "ko":"5) 데이터를 가지고 오고자 하는 카드를 선택합니다.",
                "en":"5) and select the card which you want to use"
            },
            s6: {
                "jp":"6) <a class='innerhref' href='https://p.eagate.573.jp/game/gfdm/gitadora_exchain/p/index.html'>GITADORAの公式サイト</a>に移動します。",
                "ko":"6) <a class='innerhref' href='https://p.eagate.573.jp/game/gfdm/gitadora_exchain/p/index.html'>GITADORA 홈페이지</a>로 이동합니다.",
                "en":"6) Go to <a class='innerhref' href='https://p.eagate.573.jp/game/gfdm/gitadora_exchain/p/index.html'>GITADORA web site</a>"
            },
            s7: {
                "jp":"7) 上でコピーしてたスクリプトをアドレス空間にペーストして実行します",
                "ko":"7) 위에서 복사했던 스크립트를 붙여넣고 실행합니다",
                "en":"7) Paste the script you copied and execute."
            },
            s8: {
                "jp":"8) 各ボタンをクリックしてデータを更新します",
                "ko":"8) 이제 각 항목을 클릭하여 데이터를 업데이트 하면 됩니다",
                "en":"8) Let's do the update"
            }
        }
    },
    mobile: {
        title: {
            "jp":"スマホで更新",
            "ko":"스마트폰으로 업데이트 하기",
            "en":"Update from smartphone"
        },
        step1: {
            title: {
                "jp":"1. 新規登録",
                "ko":"1. 회원 가입",
                "en":"1. Sign up"
            },
            desc: {
                "jp":"右上のメニューボタンから「ログイン」をタッチするとGoogleアカウントでGITADORA Infoの登録に入ります",
                "ko":"페이지 상단 오른쪽 버튼을 누르고 로그인 선택하여 구글 아이디로 로그인하면 회원등록 과정으로 진행됩니다",
                "en":"Click upper right menu button and select Login to sign in with Google account which leads to sign up sequence"
            }
        },
        step3: {
            title: {
                "jp":"3. 更新方法",
                "ko":"3. 업데이트 방법",
                "en":"3. Update process"
            },
            s1: {
                "jp":"1) ブラウザーを起動します。<a class='innerhref' href='https://chrome.google.com/'>Google Chrome</a>をおすすめします",
                "ko":"1) 브라우저를 엽니다. <a class='innerhref' href='https://chrome.google.com/'>Google Chrome</a>을 권장합니다",
                "en":"1) Open browser. We recommend you to use <a class='innerhref' href='https://chrome.google.com/'>Google Chrome</a>"
            },
            s2: {
                "jp":"2) <a class='innerhref' href='https://p.eagate.573.jp/'>eAmusement</a>から「ログイン」してください",
                "ko":"2) <a class='innerhref' href='https://p.eagate.573.jp/'>eAmusement</a>에 로그인 해주세요.",
                "en":"2) Please sign in at <a class='innerhref' href='https://p.eagate.573.jp/'>eAmusement</a>"
            },
            s3: {
                "jp":"3) もし複数のカードを使用している方は右上のメニューの「e-AMUSEMENT PASS」から...",
                "ko":"3) 만약 카드를 여러장 쓰고 있다면 오른쪽 상단의 메뉴에서 e-AMUSEMENT PASS를 누르고...",
                "en":"3) If you use muleiple cards, first, select e-Amusement menu..."
            },
            s4: {
                "jp":"4) 「参照e-AMUSEMENT PASSの切り替え」から",
                "ko":"4) '사용 중인 카드 변경' 메뉴로 들어가서",
                "en":"4) Go to 'Card exchange' menu"
            },
            s5: {
                "jp":"5) ご使用になるカードを選びます",
                "ko":"5) 데이터를 가지고 오고자 하는 카드를 선택합니다.",
                "en":"5) and select the card which you want to use"
            },
            s6: {
                "jp":"6) <a class='innerhref' href='https://p.eagate.573.jp/game/gfdm/gitadora_matixx/p/index.html'>GITADORAのホムページ</a>に移動します。",
                "ko":"6) <a class='innerhref' href='https://p.eagate.573.jp/game/gfdm/gitadora_matixx/p/index.html'>GITADORA 홈페이지</a>로 이동합니다.",
                "en":"6) Go to <a class='innerhref' href='https://p.eagate.573.jp/game/gfdm/gitadora_matixx/p/index.html'>GITADORA site</a>"
            },
            s7: {
                "jp":"7) コピーしてたスクリプトをアドレス空間にペーストして実行します",
                "ko":"7) 위에서 복사했던 스크립트를 붙여넣고 실행합니다",
                "en":"7) Paste the script you copied and execute."
            },
            s8: {
                "jp":"8) 各ボタンをクリックしてデータをアップデートします",
                "ko":"8) 이제 각 항목을 클릭하여 데이터를 업데이트 하면 됩니다",
                "en":"8) Let's do the update"
            }
        }
    }  
};