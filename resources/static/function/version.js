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
var GDVer = [
	{num:1, sv:"GF1", full:"GuitarFreaks 1st"},
	{num:2, sv:"GF2DM1", full:"GuitarFreaks 2nd & DrumMania 1st"},
	{num:3, sv:"GF3DM2", full:"GuitarFreaks 3rd & DrumMania 2nd"},
	{num:4, sv:"GF4DM3", full:"GuitarFreaks 4th & DrumMania 3rd"},
	{num:5, sv:"GF5DM4", full:"GuitarFreaks 5th & DrumMania 4th"},
	{num:6, sv:"GF6DM5", full:"GuitarFreaks 6th & DrumMania 5th"},
	{num:7, sv:"GF7DM6", full:"GuitarFreaks 7th & DrumMania 6th"},
	{num:8, sv:"GF8DM7", full:"GuitarFreaks 8th & DrumMania 7th"},
	{num:9, sv:"GF9DM8", full:"GuitarFreaks 9th & DrumMania 8th"},
	{num:10, sv:"GF10DM9", full:"GuitarFreaks 10th & DrumMania 9th"},
	{num:11, sv:"GF11DM10", full:"GuitarFreaks 11st & DrumMania 10th"},
	{num:12, sv:"ee'mall", full:"ee'mall & ee'mall 2nd"},
	{num:13, sv:"GFDM V", full:"GuitarFreaks & DrumMania V"},
	{num:14, sv:"GFDM V2", full:"GuitarFreaks & DrumMania V2"},
	{num:15, sv:"GFDM V3", full:"GuitarFreaks & DrumMania V3"},
	{num:16, sv:"GFDM V4", full:"GuitarFreaks & DrumMania V4"},
	{num:17, sv:"GFDM V5", full:"GuitarFreaks & DrumMania V5"},
	{num:18, sv:"GFDM V6", full:"GuitarFreaks & DrumMania V6"},
	{num:19, sv:"GFDM XG", full:"GuitarFreaks & DrumMania XG"},
	{num:20, sv:"GFDM XG2", full:"GuitarFreaks & DrumMania XG2"},
	{num:21, sv:"GFDM XG3", full:"GuitarFreaks & DrumMania XG3"},
	{num:22, sv:"GD", full:"GITADORA"},
	{num:23, sv:"GD OD", full:"GITADORA OverDrive"},
	{num:24, sv:"GD TB", full:"GITADORA Tri-Boost"},
	{num:25, sv:"GD TBRE", full:"GITADORA Tri-Boost Re:Evolve"},
	{num:26, sv:"GD MX", full:"GITADORA Matixx"},
	{num:27, sv:"GD EXC", full:"GITADORA EXCHAIN"}
];

function generateVerFilter(all) {
	var filter = "";
	for(var i = 0; i < GDVer.length; i++) {
		var verstr = GDVer[i].num;
		if(verstr < 10) {
			verstr = "0"+verstr;
		}
		filter +=
			"<div class='div-table-cell filter-obj'>"+
				"<label><input type='checkbox' name='ver[]' value='"+verstr+"'>"+GDVer[i].sv+"</label>"+
			"</div>";
	}
	
	if(all) {
		filter +=
			"<div class='div-table-cell filter-obj'>"+
				"<label><input type='checkbox' name='ver[]' value='00'>All Songs</label>"+
			"</div>";
	}
	return filter;
}

var currentVer = 27;