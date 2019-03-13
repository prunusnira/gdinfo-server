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
$('head').append('<script src="/function/language/header.js"><\/script>');
$('head').append('<script src="/function/language/footer.js"><\/script>');
$('head').append('<script src="/js/jquery.cookie.js"><\/script>');

// HEADER SCRIPTS
function openNav() {
    document.getElementById("sideMenu").style.width = "50%";
}

function closeNav() {
    document.getElementById("sideMenu").style.width = "0";
}

function openDropdown(name) {
    var stat = $("#header-dropdown-"+name);

    if(stat.css("display") == 'block')
        stat.hide();
    else if(stat.css("display") == 'none') {
        stat.show();
    }
}

var searchtype = "name";

function changeSearchType(type) {
    searchtype = type;
    
    switch(type) {
    case "name":
        $("#searchToggle").text("Player");
        break;
    case "gskill":
        $("#searchToggle").text("G-Skill");
        break;
    case "dskill":
        $("#searchToggle").text("D-Skill");
        break;
    case "music":
        $("#searchToggle").text("Music");
        break;
    }

    $("#header-dropdown-search").hide();
}

function search() {
    var inpval = $("input[name='val']").val();
    
    location.href="/search/"+searchtype+"/"+inpval+"/1";
}

function themeChange(type) {
    if(type == 3) alert("Under construction");
    else {
        if(window.location.pathname.startsWith("/login")) {
            alert(txtHeader.ngafterlogin[lang]);
        }
        else {
            $.cookie("theme", type);
            window.location.reload();
        }
    }
}
/* 나중에 사용할 것 */
function langChange(type) {
    $.cookie("lang", type);
    window.location.reload();
}

// Internet Explorer 체크
if (navigator.appName == 'Microsoft Internet Explorer' ||  !!(navigator.userAgent.match(/Trident/) || navigator.userAgent.match(/rv 11/)) || (typeof $.browser !== "undefined" && $.browser.msie == 1))
{
    location.href="http://gitadora.info/noie";
}
else {
    $(document).keyup(function(e) {
        if ($("#searchinp:focus") && (e.keyCode === 13)) {
            search();
        }
    });
}

// CSS 적용
var themeVal = $.cookie("theme");
if(themeVal == 0) {
    var overall = document.createElement('link');
    overall.href = "/css/custom/overall-w.css";
    overall.type = "text/css";
    overall.rel = "stylesheet";
    $("head").append(overall.outerHTML);
}
else if (themeVal == 1) {
    var overall = document.createElement('link');
    overall.href = "/css/custom/overall-b.css";
    overall.type = "text/css";
    overall.rel = "stylesheet";
    $("head").append(overall.outerHTML);
}
else if (themeVal == 2) {
    var overall = document.createElement('link');
    overall.href = "/css/custom/overall-o.css";
    overall.type = "text/css";
    overall.rel = "stylesheet";
    $("head").append(overall.outerHTML);
}
else {
    var overall = document.createElement('link');
    overall.href = "/css/custom/overall-w.css";
    overall.type = "text/css";
    overall.rel = "stylesheet";
    $("head").append(overall.outerHTML);
}

// Google Analytics
$('head').append('<script async src="https://www.googletagmanager.com/gtag/js?id=UA-129717967-1"><\/script>');

window.dataLayer = window.dataLayer || [];
function gtag(){dataLayer.push(arguments);}
gtag('js', new Date());
gtag('config', 'UA-129717967-1');