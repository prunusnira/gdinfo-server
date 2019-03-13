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
function filteranalyzer() {
	var func = new Object();
	
	function getLevel(lv) {
		var lvBin = (parseInt(lv) >>> 0).toString(2);
		var lvsize = lvBin.length;
		
		for(var i = 0; i < lvsize; i++) {
			if(lvBin[lvsize-i-1] == '1') {
				$($("input:checkbox[name='lv[]']")[i]).prop("checked",true);
			};
		}
	}
	
	function getRank(rank) {
		var rsize = rank.length;
		
		for(var i = 0; i < rsize; i++) {
			if(rank[rsize-i-1] == '1') {
				$($("input:checkbox[name='rank[]']")[8-i]).prop("checked",true);
			};
		}
	}
	
	function getVersion(ver) {
		var verArr = new Array();
		var size = ver.length / 2;
		for(var i = 0; i < size; i++) {
			verArr.push(ver.substring(i*2, i*2+2));
		}
		
		for(var i = 0; i < verArr.length; i++) {
			if(verArr[i] != '00') {
				$($("input:checkbox[name='ver[]']")[parseInt(verArr[i])-1]).prop("checked",true);
			}
			else {
				$($("input:checkbox[name='ver[]']")[27]).prop("checked",true);
			}
		}
	}
	
	function getHot(hot) {
		if(hot.includes('h')) {
			$($("input:checkbox[name='hot[]']")[0]).prop("checked",true);
		}
		if(hot.includes('o')) {
			$($("input:checkbox[name='hot[]']")[1]).prop("checked",true);
		}
	}
	
	function getOrder(order) {
		if(order == 'titleasc') {
			$("input:radio[name='order']:radio[value='titleasc']").attr("checked",true);
		}
		else if(order == 'titledesc') {
			$("input:radio[name='order']:radio[value='titledesc']").attr("checked",true);
		}
		else if(order == 'verasc') {
			$("input:radio[name='order']:radio[value='verasc']").attr("checked",true);
		}
		else if(order == 'verdesc') {
			$("input:radio[name='order']:radio[value='verdesc']").attr("checked",true);
		}
		else if(order == 'rateasc') {
			$("input:radio[name='order']:radio[value='rateasc']").attr("checked",true);
		}
		else if(order == 'ratedesc') {
			$("input:radio[name='order']:radio[value='ratedesc']").attr("checked",true);
		}
		else if(order == 'skillasc') {
			$("input:radio[name='order']:radio[value='skillasc']").attr("checked",true);
		}
		else if(order == 'skilldesc') {
			$("input:radio[name='order']:radio[value='skilldesc']").attr("checked",true);
		}
		else if(order == 'playtime') {
			$("input:radio[name='order']:radio[value='playtime']").attr("checked",true);
		}
		else if(order == 'gbscasc') {
			$("input:radio[name='order']:radio[value='gbscasc']").attr("checked",true);
		}
		else if(order == 'gbscdesc') {
			$("input:radio[name='order']:radio[value='gbscdesc']").attr("checked",true);
		}
		else if(order == 'gadvasc') {
			$("input:radio[name='order']:radio[value='gadvasc']").attr("checked",true);
		}
		else if(order == 'gadvdesc') {
			$("input:radio[name='order']:radio[value='gadvdesc']").attr("checked",true);
		}
		else if(order == 'gextasc') {
			$("input:radio[name='order']:radio[value='gextasc']").attr("checked",true);
		}
		else if(order == 'gextdesc') {
			$("input:radio[name='order']:radio[value='gextdesc']").attr("checked",true);
		}
		else if(order == 'gmasasc') {
			$("input:radio[name='order']:radio[value='gmasasc']").attr("checked",true);
		}
		else if(order == 'gmasdesc') {
			$("input:radio[name='order']:radio[value='gmasdesc']").attr("checked",true);
		}
		else if(order == 'bbscasc') {
			$("input:radio[name='order']:radio[value='bbscasc']").attr("checked",true);
		}
		else if(order == 'bbscdesc') {
			$("input:radio[name='order']:radio[value='bbscdesc']").attr("checked",true);
		}
		else if(order == 'badvasc') {
			$("input:radio[name='order']:radio[value='badvasc']").attr("checked",true);
		}
		else if(order == 'badvdesc') {
			$("input:radio[name='order']:radio[value='badvdesc']").attr("checked",true);
		}
		else if(order == 'bextasc') {
			$("input:radio[name='order']:radio[value='bextasc']").attr("checked",true);
		}
		else if(order == 'bextdesc') {
			$("input:radio[name='order']:radio[value='bextdesc']").attr("checked",true);
		}
		else if(order == 'bmasasc') {
			$("input:radio[name='order']:radio[value='bmasasc']").attr("checked",true);
		}
		else if(order == 'bmasdesc') {
			$("input:radio[name='order']:radio[value='bmasdesc']").attr("checked",true);
		}
		else if(order == 'dbscasc') {
			$("input:radio[name='order']:radio[value='dbscasc']").attr("checked",true);
		}
		else if(order == 'dbscdesc') {
			$("input:radio[name='order']:radio[value='dbscdesc']").attr("checked",true);
		}
		else if(order == 'dadvasc') {
			$("input:radio[name='order']:radio[value='dadvasc']").attr("checked",true);
		}
		else if(order == 'dadvdesc') {
			$("input:radio[name='order']:radio[value='dadvdesc']").attr("checked",true);
		}
		else if(order == 'dextasc') {
			$("input:radio[name='order']:radio[value='dextasc']").attr("checked",true);
		}
		else if(order == 'dextdesc') {
			$("input:radio[name='order']:radio[value='dextdesc']").attr("checked",true);
		}
		else if(order == 'dmasasc') {
			$("input:radio[name='order']:radio[value='dmasasc']").attr("checked",true);
		}
		else if(order == 'dmasdesc') {
			$("input:radio[name='order']:radio[value='dmasdesc']").attr("checked",true);
		}
		
		// 레벨 비교용
		else if(order == 'bscasc') {
			$("input:radio[name='order']:radio[value='bscasc']").attr("checked",true);
		}
		else if(order == 'bscdesc') {
			$("input:radio[name='order']:radio[value='bscdesc']").attr("checked",true);
		}
		else if(order == 'advasc') {
			$("input:radio[name='order']:radio[value='advasc']").attr("checked",true);
		}
		else if(order == 'advdesc') {
			$("input:radio[name='order']:radio[value='advdesc']").attr("checked",true);
		}
		else if(order == 'extasc') {
			$("input:radio[name='order']:radio[value='extasc']").attr("checked",true);
		}
		else if(order == 'extdesc') {
			$("input:radio[name='order']:radio[value='extdesc']").attr("checked",true);
		}
		else if(order == 'masasc') {
			$("input:radio[name='order']:radio[value='masasc']").attr("checked",true);
		}
		else if(order == 'masdesc') {
			$("input:radio[name='order']:radio[value='masdesc']").attr("checked",true);
		}
		
		else if(order == 'lvasc') {
			$("input:radio[name='order']:radio[value='lvasc']").attr("checked",true);
		}
		else if(order == 'lvdesc') {
			$("input:radio[name='order']:radio[value='lvdesc']").attr("checked",true);
		}
		
		// 이하 스킬 비교용
		
		else if(order == 'mrateasc') {
			$("input:radio[name='order']:radio[value='mrateasc']").attr("checked",true);
		}
		else if(order == 'mratedesc') {
			$("input:radio[name='order']:radio[value='mratedesc']").attr("checked",true);
		}
		else if(order == 'rrateasc') {
			$("input:radio[name='order']:radio[value='rrateasc']").attr("checked",true);
		}
		else if(order == 'rratedesc') {
			$("input:radio[name='order']:radio[value='rratedesc']").attr("checked",true);
		}
		else if(order == 'mskillasc') {
			$("input:radio[name='order']:radio[value='mskillasc']").attr("checked",true);
		}
		else if(order == 'mskilldesc') {
			$("input:radio[name='order']:radio[value='mskilldesc']").attr("checked",true);
		}
		else if(order == 'rskillasc') {
			$("input:radio[name='order']:radio[value='rskillasc']").attr("checked",true);
		}
		else if(order == 'rskilldesc') {
			$("input:radio[name='order']:radio[value='rskilldesc']").attr("checked",true);
		}
		else if(order == 'skilldiffasc') {
			$("input:radio[name='order']:radio[value='skilldiffasc']").attr("checked",true);
		}
		else if(order == 'skilldiffdesc') {
			$("input:radio[name='order']:radio[value='skilldiffdesc']").attr("checked",true);
		}
		else if(order == 'ratediffasc') {
			$("input:radio[name='order']:radio[value='ratediffasc']").attr("checked",true);
		}
		else if(order == 'ratediffdesc') {
			$("input:radio[name='order']:radio[value='ratediffdesc']").attr("checked",true);
		}
	}
	
	function getRival(rival) {
		var rsize = rival.length;
		
		for(var i = 0; i < rsize; i++) {
			if(rival[i] == '1') {
				$($("input:checkbox[name='rival[]']")[rsize-i-1]).prop("checked",true);
			};
		}
	}
	
	func.getLevel = getLevel;
	func.getRank = getRank;
	func.getVersion = getVersion;
	func.getHot = getHot;
	func.getOrder = getOrder;
	func.getRival = getRival;
	
	return func;
}