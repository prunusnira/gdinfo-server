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
function searchDropdown() {
    var stat = $("#search-dropdown");

    if(stat.css("display") == 'block')
        stat.hide();
    else if(stat.css("display") == 'none') {
        stat.show();
    }
}