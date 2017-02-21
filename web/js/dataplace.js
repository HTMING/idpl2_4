/*Different way has different methods*/
function method_change(){
	var currSelectValue=document.getElementsByName("way")[0].value;
	var methodSelect=document.getElementsByName("method")[0];
	if(currSelectValue=="GET")
	{
		methodSelect.options.length = 0;
        var varItem1 = new Option("FTP", "FTP"); 
        methodSelect.options.add(varItem1);
        var varItem2 = new Option("HTTP", "HTTP");
        methodSelect.options.add(varItem2);
	}
	else
	{
		methodSelect.options.length = 0;
        var varItem1 = new Option("FTP", "FTP"); 
        methodSelect.options.add(varItem1);
       /* var varItem2 = new Option("SCP", "SCP");
        methodSelect.options.add(varItem2);*/
	}
}
/*prevent Data Sender and Receiver are same*/
function receiver_change(){
	var currSelectValue=document.getElementsByName("dataSource")[0].value;
	var receiverSelect=document.getElementsByName("dataDestination")[0];
	//
	receiverSelect.options.length = 0;
    var varItem1 = new Option("BUAA", "BUAA"); 
    receiverSelect.options.add(varItem1);
    var varItem2 = new Option("CNIC", "CNIC");
    receiverSelect.options.add(varItem2);
    var varItem3 = new Option("UCSD", "UCSD"); 
    receiverSelect.options.add(varItem3);
    var varItem4 = new Option("WISC", "WISC");
    receiverSelect.options.add(varItem4);
	for (var i = 0; i < receiverSelect.options.length; i++) { 
	     if (receiverSelect.options[i].value == currSelectValue) { 
	    	 receiverSelect.options.remove(i); 
//	    	 alert(currSelectValue);
	         break; 
	        } 
	     } 
//	alert(currSelectValue);
	receiverSelect.options[0].selected = true; 
//	alert(receiverSelect.value);
}
function getCurrentTime(){
	var timeStart_date=document.getElementById("timeStart_date").value;
	var timeStart_time=document.getElementById("timeStart_time").value;
	var timeEnd_date=document.getElementById("timeEnd_date").value;
	var timeEnd_time=document.getElementById("timeEnd_time").value;
	var timeStartUnixtime=document.getElementById("timeStartUnixtime");
	var timeEndUnixtime=document.getElementById("timeEndUnixtime");
	var createUnixtime=document.getElementById("createUnixtime");
	if(timeStart_date!=""&&timeStart_time!="")
	{
		timeStartUnixtime.value=Date.parse(timeStart_date+" "+timeStart_time)/1000;	
	}
	else
		timeStartUnixtime.value=null;
	if(timeEnd_date!=""&&timeEnd_time!="")
	{
		timeEndUnixtime.value=Date.parse(timeEnd_date+" "+timeEnd_time)/1000;	
	}
	else
		timeEndUnixtime.value=null;
	createUnixtime.value = Date.parse(new Date())/1000; 
}
/* format hour */
/*
function input_h(warnning,time){
	var curValue=document.getElementById(time).value;
	if(curValue=="00"||curValue=="01"||curValue=="02"||curValue=="03"||curValue=="04"||curValue=="05"||curValue=="06"
		||curValue=="07"||curValue=="08"||curValue=="09"||curValue=="10"||curValue=="11"||curValue=="12"||curValue=="13"
			||curValue=="14"||curValue=="15"||curValue=="16"||curValue=="17"||curValue=="18"||curValue=="19"||curValue=="20"
				||curValue=="21"||curValue=="22"||curValue=="23"||curValue=="")
		{
			document.getElementById(warnning).innerHTML="true";
		}
	else
		{
			document.getElementById(warnning).innerHTML="error";
		}
}
/* format minute */
/*
function input_m(warnning,time){
	var curValue=document.getElementById(time).value;
	if(curValue=="00"||curValue=="01"||curValue=="02"||curValue=="03"||curValue=="04"||curValue=="05"||curValue=="06"
		||curValue=="07"||curValue=="08"||curValue=="09"||curValue=="10"||curValue=="11"||curValue=="12"||curValue=="13"
			||curValue=="14"||curValue=="15"||curValue=="16"||curValue=="17"||curValue=="18"||curValue=="19"||curValue=="20"
				||curValue=="21"||curValue=="22"||curValue=="23"||curValue=="24"||curValue=="25"||curValue=="26"||curValue=="27"
					||curValue=="28"||curValue=="29"||curValue=="30"||curValue=="31"||curValue=="32"||curValue=="33"||curValue=="34"
						||curValue=="35"||curValue=="36"||curValue=="37"||curValue=="38"||curValue=="39"||curValue=="40"||curValue=="41"
							||curValue=="42"||curValue=="43"||curValue=="44"||curValue=="45"||curValue=="46"||curValue=="47"||curValue=="48"
								||curValue=="49"||curValue=="50"||curValue=="51"||curValue=="52"||curValue=="53"||curValue=="54"||curValue=="55"
									||curValue=="56"||curValue=="57"||curValue=="58"||curValue=="59"||curValue=="")
		{
			document.getElementById(warnning).innerHTML="true";
		}
	else
		{
			document.getElementById(warnning).innerHTML="error";
		}
}
function myreset(){
	document.getElementById("warnning1").innerHTML="(hh:mm)";
	document.getElementById("warnning2").innerHTML="(hh:mm)";
}
function mycheck(){
	var testNameValue=document.getElementById("testName").value;
	var dateValue1=document.getElementById("timeStart_d").value;
	var hourValue1=document.getElementById("timeStart_h").value;
	var minValue1=document.getElementById("timeStart_m").value;
	var dateValue2=document.getElementById("timeEnd_d").value;
	var hourValue2=document.getElementById("timeEnd_h").value;
	var minValue2=document.getElementById("timeEnd_m").value;
	var repeatValue=document.getElementById("frequency").value;
	var dataValue=document.getElementById("DataSizeNum").value;
	if(testNameValue=="")
	{
		alert("Experiment cannot be blank!");
		return false;
	}
	if(dataValue=="")
	{
		alert("Data Size cannot be blank!");
		return false;
	}
	if(dateValue1==""&&hourValue1==""&&minValue1=="")
		;
	else if(dateValue1!=""&&hourValue1!=""&&minValue1!="")
	{
		if(hourValue1!="00"&&hourValue1!="01"&&hourValue1!="02"&&hourValue1!="03"&&hourValue1!="04"&&hourValue1!="05"&&hourValue1!="06"
			&&hourValue1!="07"&&hourValue1!="08"&&hourValue1!="09"&&hourValue1!="10"&&hourValue1!="11"&&hourValue1!="12"&&hourValue1!="13"
				&&hourValue1!="14"&&hourValue1!="15"&&hourValue1!="16"&&hourValue1!="17"&&hourValue1!="18"&&hourValue1!="19"&&hourValue1!="20"
					&&hourValue1!="21"&&hourValue1!="22"&&hourValue1!="23")
		{
			alert("ERROR: Start Time format(yyyy-mm-dd hh:mm)!");
			return false;
		}
		if(minValue1!="00"&&minValue1!="01"&&minValue1!="02"&&minValue1!="03"&&minValue1!="04"&&minValue1!="05"&&minValue1!="06"
			&&minValue1!="07"&&minValue1!="08"&&minValue1!="09"&&minValue1!="10"&&minValue1!="11"&&minValue1!="12"&&minValue1!="13"
				&&minValue1!="14"&&minValue1!="15"&&minValue1!="16"&&minValue1!="17"&&minValue1!="18"&&minValue1!="19"&&minValue1!="20"
					&&minValue1!="21"&&minValue1!="22"&&minValue1!="23"&&minValue1!="24"&&minValue1!="25"&&minValue1!="26"&&minValue1!="27"
						&&minValue1!="28"&&minValue1!="29"&&minValue1!="30"&&minValue1!="31"&&minValue1!="32"&&minValue1!="33"&&minValue1!="34"
							&&minValue1!="35"&&minValue1!="36"&&minValue1!="37"&&minValue1!="38"&&minValue1!="39"&&minValue1!="40"&&minValue1!="41"
								&&minValue1!="42"&&minValue1!="43"&&minValue1!="44"&&minValue1!="45"&&minValue1!="46"&&minValue1!="47"&&minValue1!="48"
									&&minValue1!="49"&&minValue1!="50"&&minValue1!="51"&&minValue1!="52"&&minValue1!="53"&&minValue1!="54"&&minValue1!="55"
										&&minValue1!="56"&&minValue1!="57"&&minValue1!="58"&&minValue1!="59")
		{
			alert("ERROR: Start Time format(yyyy-mm-dd hh:mm)!");
			return false;			
		}
	}
	else
	{
		alert("ERROR: Start Time should be all blank or all filled!");
		return false;
	}
	if(dateValue2==""&&hourValue2==""&&minValue2=="")
		;
	else if(dateValue2!=""&&hourValue2!=""&&minValue2!="")
	{
		if(hourValue2!="00"&&hourValue2!="01"&&hourValue2!="02"&&hourValue2!="03"&&hourValue2!="04"&&hourValue2!="05"&&hourValue2!="06"
			&&hourValue2!="07"&&hourValue2!="08"&&hourValue2!="09"&&hourValue2!="10"&&hourValue2!="11"&&hourValue2!="12"&&hourValue2!="13"
				&&hourValue2!="14"&&hourValue2!="15"&&hourValue2!="16"&&hourValue2!="17"&&hourValue2!="18"&&hourValue2!="19"&&hourValue2!="20"
					&&hourValue2!="21"&&hourValue2!="22"&&hourValue2!="23")
		{
			alert("ERROR: End Time format!(yyyy-mm-dd hh:mm)!");
			return false;
		}
		if(minValue2!="00"&&minValue2!="01"&&minValue2!="02"&&minValue2!="03"&&minValue2!="04"&&minValue2!="05"&&minValue2!="06"
			&&minValue2!="07"&&minValue2!="08"&&minValue2!="09"&&minValue2!="10"&&minValue2!="11"&&minValue2!="12"&&minValue2!="13"
				&&minValue2!="14"&&minValue2!="15"&&minValue2!="16"&&minValue2!="17"&&minValue2!="18"&&minValue2!="19"&&minValue2!="20"
					&&minValue2!="21"&&minValue2!="22"&&minValue2!="23"&&minValue2!="24"&&minValue2!="25"&&minValue2!="26"&&minValue2!="27"
						&&minValue2!="28"&&minValue2!="29"&&minValue2!="30"&&minValue2!="31"&&minValue2!="32"&&minValue2!="33"&&minValue2!="34"
							&&minValue2!="35"&&minValue2!="36"&&minValue2!="37"&&minValue2!="38"&&minValue2!="39"&&minValue2!="40"&&minValue2!="41"
								&&minValue2!="42"&&minValue2!="43"&&minValue2!="44"&&minValue2!="45"&&minValue2!="46"&&minValue2!="47"&&minValue2!="48"
									&&minValue2!="49"&&minValue2!="50"&&minValue2!="51"&&minValue2!="52"&&minValue2!="53"&&minValue2!="54"&&minValue2!="55"
										&&minValue2!="56"&&minValue2!="57"&&minValue2!="58"&&minValue2!="59")
		{
			alert("ERROR: End Time format(yyyy-mm-dd hh:mm)!");
			return false;
		}			
	}
	else
	{
		alert("ERROR: End Time should be all blank or all filled!");
		return false;
	}
	if(repeatValue!="")
	{
		var patrn=/^\d*$/;
		if (!patrn.test(repeatValue)) {   
		    alert("ERROR: Repeat!"); 
			return false;
		}
	}
}
function auto_shift(){
	
}*/
/*function GetRequest(keyword) {
	   var url = location.search;
	   var theRequest = new Object();
	   if (url.indexOf("?") != -1) {
	      var str = url.substr(1);
	      strs = str.split("&");
	      for(var i = 0; i < strs.length; i ++) {
	         theRequest[strs[i].split("=")[0]]=unescape(strs[i].split("=")[1]);
	      }
	   }
	   return theRequest[keyword];
	}
	function redirect(){
		var q=GetRequest("q");
		if(q==null)
			window.location.href="./result.jsp";
		else
			window.location.href="./result.jsp?q="+q;
	}
	function myRefresh(){
		var p=GetRequest("p");
		var url = location.search;
		if(p!=null)
			setTimeout("redirect()",1000);
		if(url=="test")
			setTimeout("redirect()",1000);
	}*/