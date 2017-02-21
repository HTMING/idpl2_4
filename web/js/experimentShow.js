Date.prototype.Format = function (fmt) { //author: meizz 
    var o = {
        "M+": this.getMonth() + 1, //月份 
        "d+": this.getDate(), //日 
        "h+": this.getHours(), //小时 
        "m+": this.getMinutes(), //分 
        "s+": this.getSeconds(), //秒 
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
        "S": this.getMilliseconds() //毫秒 
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
};
function convert(time){
	var second;
	var minute;
	var hour;
	var result;
	if(time<60)
		result = time + " s ";
	else if(time>=60&&time<3600){
		minute = Math.floor(time/60);
		second = time%60;
		result = minute + " m " + second + " s "; 
	}
	else{
		hour = Math.floor(time/3600);
		minute = Math.floor((time-3600*hour)/60);
		second = time-3600*hour-minute*60;
		result = hour + " h " + minute + " m " + second + " s ";
	}
	return result;
}
function loadtime(){
	var tables=document.getElementsByTagName("table");
	var tables_number=tables.length;
	var table;
	var rows;	
	var startRunning;
	var completedTime;
	var date;
	for(var i=0;i<tables_number-3;i++)
	{
		rows=tables[i].rows;
		startRunning=rows[1].cells[0].innerHTML;
		completedTime=rows[1].cells[1].innerHTML;
		date		=rows[1].cells[3].innerHTML;
		if(startRunning!=""&&completedTime!="")
			rows[1].cells[2].innerHTML = convert(completedTime-startRunning);
		if(startRunning!="")
			rows[1].cells[0].innerHTML = new Date(startRunning*1000).Format("yyyy-MM-dd hh:mm:ss");
		if(completedTime!="")
			rows[1].cells[1].innerHTML = new Date(completedTime*1000).Format("yyyy-MM-dd hh:mm:ss");
		if(date!="")
			rows[1].cells[3].innerHTML = new Date(date*1000).Format("yyyy-MM-dd hh:mm:ss");	
	}
}
