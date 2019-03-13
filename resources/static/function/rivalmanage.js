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
function addAsRival(gtype, id) {
	$.ajax({
		url:"/d/rivaladd/"+id+"/"+gtype,
		type:"GET",
		success:function(data) {
			if(data == true) {
				alert("Rival is added successfully");
			}
			else {
				location.href="/rivalfail";
			}
		}
	});
	
}

function setRival(id) {
	var url = location.href;
	if(url.indexOf("?rival=") != -1) {
		url = url.split("?rival=")[0];
	}
	else if(url.indexOf("&rival=") != -1) {
		url = url.split("&rival=")[0];
	}
	
	if(url.indexOf("?") != -1) {
		url = url+"&rival="+id;
	}
	else {
		url = url+"?rival="+id;
	}
	location.href = url;
}