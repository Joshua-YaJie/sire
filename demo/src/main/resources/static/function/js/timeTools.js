/**
 * 获取指定天数后的日期
 * @param number
 * @returns {String}
 */
function getNextDay(number){  
    var now = new Date(); 
    now.setDate(now.getDate() +number);  
    tempStr = changeTime(now);  
    return tempStr;
    
}

/**
 * 距现在多少月之后的天数
 * @param number
 * @returns {String}yyyy-mm
 */
function getNextMonth(number){

	var now = new Date();//当前时间
	var lastMonth = new Date(now.getFullYear(),now.getMonth()-number,now.getDate());//上个月
	return changeTimeToMonth(lastMonth)
}
/**
 * 距离指定时间多少月后的天数
 * @param beginDate
 * @param monthNum
 * @returns {String}yyyy-mm
 */
function  getMonth(beginDate,monthNum){
	var arr1 = beginDate.split("-");
	var date = new Date(arr1[0],parseInt(arr1[1])-1,10);
	var lastMonth = new Date(date.getFullYear(),date.getMonth()+(monthNum),date.getDate());
	return changeTimeToMonth(lastMonth)
}
/**
 * 两个时间比较
 * @param newBeginDate
 * @param lastDate
 * @returns {Boolean}
 */
function compareDate(newBeginDate,lastDate){
	var arr1 = newBeginDate.split("-");
	var date1 = new Date(arr1[0],parseInt(arr1[1])-1,10);
	var time1 = date1.getTime();
	var arr2 = lastDate.split("-");
	var date2 = new Date(arr2[0],parseInt(arr2[1])-1,10);
	var time2 = date2.getTime();
	if(time1>time2){
		return true;
	}else{
		return false;
	}
}

function changeTimeToMonth(str){
	var fullDate = "";
	var tmpMonth = "";
	var tmpDay = "";
	var tmpYear = "";
	tmpMonth = str.getMonth() + 1;
	if(tmpMonth < 10){
		tmpMonth = "0" + tmpMonth;
	}
	tmpDay = str.getDate();
	if(tmpDay < 10){
		tmpDay = "0" + tmpDay;
	}
	tmpYear = str.getFullYear();
	return(tmpYear+"-"+tmpMonth);
}



/**
 * 将时间转换为yy-mm-dd的格式
 * @param str
 * @returns {String}
 */
function changeTime(str){  
    var fullDate = "";  
    var tmpMonth = "";  
    var tmpDay = "";  
    var tmpYear = "";  
    tmpMonth = str.getMonth() + 1;  
    if(tmpMonth < 10){  
        tmpMonth = "0" + tmpMonth;  
    }  
    tmpDay = str.getDate();  
    if(tmpDay < 10){  
        tmpDay = "0" + tmpDay;  
    }  
    tmpYear = str.getFullYear();  
    return(tmpYear+"-"+tmpMonth+"-"+tmpDay);  
} 
/**
 * 指定时间前个月的日期
 * @param date
 * @returns {String}yyyymmdd
 */
function getMothBefore(date){
	var da=date.split("-");
	var year=parseInt(da[0]);
	var month=parseInt(da[1]);
	var monthStr="";
	month=month-1;
	if(month==0){
		monthStr="12";
		year=year-1;
	}else if(month<10){
		monthStr="0"+month;
	}else{
		monthStr=""+month;
	}
	return year+""+monthStr+""+da[2];
}
/**
 * 计算两个日期的时间差
 * @param sDate1
 * @param sDate2
 * @returns
 */
function  DateDiff(sDate1,  sDate2){    
   var  aDate,  oDate1,  oDate2,  iDays  
   aDate  =  sDate1.split("-")  
   oDate1  =  new  Date(Date.parse(sDate1.replace(/-/g, "/")))    //转换为12-18-2006格式  
   aDate  =  sDate2.split("-")  
   oDate2  =  new  Date(Date.parse(sDate2.replace(/-/g, "/")))  
   iDays  =  parseInt(Math.floor(oDate1.getTime()  -  oDate2.getTime())  /  1000  /  60  /  60  /24)    //把相差的毫秒数转换为天数  
   return  iDays  
}
/**
 * 验证正确的日期格式
 */
function RQcheck(RQ) {
    var date = RQ;
    var result = date.match(/^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/);

    if (result == null)
        return false;
    var d = new Date(result[1], result[3] - 1, result[4]);
    return (d.getFullYear() == result[1] && (d.getMonth() + 1) == result[3] && d.getDate() == result[4]);

}