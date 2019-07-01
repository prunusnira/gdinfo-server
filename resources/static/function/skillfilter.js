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
$.ready(function() {
	$('#filter').hide();
});

function showfilter(type) {
	if(type==1) {
		$('#filter').show();
		$('#filterShowHide').html("<a href='#' onclick='showfilter(0)'>"+
							"<div>"+
								"<h3>Hide Option Table</h3>"+
								text.other.filter[lang]+
							"</div>"+
						"</a>");
	}
	else if(type==0) {
		$('#filter').hide();
		$('#filterShowHide').html("<a href='#' onclick='showfilter(1)'>"+
							"<div>"+
								"<h3>Show Option Table</h3>"+
								text.other.filter[lang]+
							"</div>"+
						"</a>");
	}
}

function filterReset() {
	$(':input', '#filterform').removeAttr('checked').removeAttr('selected');
}

// skill
function applyfilter(pagetype) {
	var lv = 0;
	var rank = 0;
	var ver = "";
	var hot = "";
	var order;
	$("input[name='lv[]']:checked").each(function() {
		lv += parseInt($(this).val());
	});
	
	$("input[name='rank[]']:checked").each(function() {
		rank += parseInt($(this).val());
	});
	
	$("input[name='ver[]']:checked").each(function() {
		ver += $(this).val();
	});
	
	$("input[name='hot[]']:checked").each(function() {
		hot += $(this).val();
	});
	
	order = $("input[name='order']:checked").val();
	
	if(order == undefined) {
		order = porder;
	}
	
	var url = '/'+pagetype;
	
	var extend = "";
	
	if(lv != 0) {
		if(extend == '') {
			extend = '?lv='+lv;
		}
		else {
			extend += '&lv='+lv;
		}
	}
	if(rank != 0) {
		if(extend == '') {
			extend = '?rank='+rank;
		}
		else {
			extend += '&rank='+rank;
		}
	}
	if(ver != "") {
		if(extend == '') {
			extend = '?ver='+ver;
		}
		else {
			extend += '&ver='+ver;
		}
	}
	if(hot != "") {
		if(extend == '') {
			extend = '?hot='+hot;
		}
		else {
			extend += '&hot='+hot;
		}
	}
	
	location.href = url+extend;
}

// rival
function applyfilterR(pagetype, gtype, porder, userid) {
	var lv = 0;
	var rank = 0;
	var ver = "";
	var hot = "";
	var order;
	var rival = 0;
	$("input[name='lv[]']:checked").each(function() {
		lv += parseInt($(this).val());
	});
	
	$("input[name='rank[]']:checked").each(function() {
		rank += parseInt($(this).val());
	});
	
	$("input[name='ver[]']:checked").each(function() {
		ver += $(this).val();
	});
	
	$("input[name='hot[]']:checked").each(function() {
		hot += $(this).val();
	});
	
	order = $("input[name='order']:checked").val();
	
	$("input[name='rival[]']:checked").each(function() {
		rival += parseInt($(this).val());
	});
	
	if(order == undefined) {
		order = porder;
	}
	
	var url = '/'+pagetype+'/'+userid+'/'+gtype+'/1?order='+order;
	
	if(lv != 0) {
		url += '&lv='+lv;
	}
	if(rank != 0) {
		url += '&rank='+rank;
	}
	if(ver != "") {
		url += '&ver='+ver;
	}
	if(hot != "") {
		url += '&hot='+hot;
	}
	if(rival != 0) {
		url += '&rival='+rival;
	}

	location.href = url;
}

// ptrank, lvcomp
function applyfilterP(pagetype) {
	var ver = "";
	var hot = "";
	var order;
	
	$("input[name='ver[]']:checked").each(function() {
		ver += $(this).val();
	});
	
	$("input[name='hot[]']:checked").each(function() {
		hot += $(this).val();
	});
	
	order = $("input[name='order']:checked").val();
	
	$("input[name='rival[]']:checked").each(function() {
		rival += parseInt($(this).val());
	});
	
	var url = '/'+pagetype+'/'+ver+'/'+order+'/1';
	
	var extend = "";
	
	if(hot != "") {
		if(extend == "") {
			extend += '?hot='+hot;
		}
		else {
			extend += '&hot='+hot;
		}
	}
	
	if(ver != "") {
		location.href = url+extend;
	}
	else {
		alert(txtPtrank.selectver[lang]);
	}
}

// notplayed
function applyfilterNP(pagetype) {
	var lv = 0;
	var ver = "";
	var hot = "";
	var order;
	$("input[name='lv[]']:checked").each(function() {
		lv += parseInt($(this).val());
	});
	
	$("input[name='ver[]']:checked").each(function() {
		ver += $(this).val();
	});
	
	$("input[name='hot[]']:checked").each(function() {
		hot += $(this).val();
	});
	
	order = $("input[name='order']:checked").val();
	
	if(order == undefined) {
		order = "lvdesc";
	}
	
	var url = '/'+pagetype+'?order='+order;
	
	if(lv != 0) {
		url += '&lv='+lv;
	}
	if(ver != "") {
		url += '&ver='+ver;
	}
	if(hot != "") {
		url += '&hot='+hot;
	}
	
	location.href = url;
}