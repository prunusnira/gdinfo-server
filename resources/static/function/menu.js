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
// HEADER SCRIPTS
function openNav() {
    document.getElementById("sideMenu").style.width = "350px";
    $(".navhomeicon").show();
    $(".navlefttxt").show();
    $("#navopen").attr("src", "/img/header/prev_w.png");
    $("#sideopen").attr("onclick", "closeNav()");
}

function closeNav() {
    document.getElementById("sideMenu").style.width = "80px";
    $(".navhomeicon").hide();
    $(".navlefttxt").hide();
    $("#navopen").attr("src", "/img/header/next.png");
    $("#sideopen").attr("onclick", "openNav()");
}

function openDropdown(name) {
    openNav();
    
    var stat = $("#header-dropdown-"+name);

    if(stat.css("display") == 'block')
        stat.hide();
    else if(stat.css("display") == 'none') {
        stat.show();
    }
}

function openDropdown2(name) {
    var menu = $("#sideMenu2");
    var top = $("#navtop");
    var all = $("#navsub");
    var stat = $("#navsub-"+name);

    if(all.height() != 0) {
        closeAllSub();
        stat.hide();
        all.height(0);
        menu.height(top[0].scrollHeight);
    }
    else if(all.height() == 0) {
        closeAllSub();
        stat.show();
        all.height(all[0].scrollHeight);
        menu.height(menu[0].scrollHeight);
    }
}

function closeAllSub() {
    $("#navsub-color").hide();
    $("#navsub-login").hide();
    $("#navsub-howto").hide();
    $("#navsub-profile").hide();
    $("#navsub-skill").hide();
    $("#navsub-pattern").hide();
    $("#navsub-tower").hide();
    $("#navsub-piu").hide();
}

// 초기 기동시 메뉴 가림
closeNav();
closeAllSub();
$("#sideMenu2").height($("#sideMenu2")[0].scrollHeight);