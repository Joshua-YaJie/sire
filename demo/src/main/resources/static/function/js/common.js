Date.prototype.format=function(fmt) {         
     var o = {         
     "M+" : this.getMonth()+1, //月份         
     "d+" : this.getDate(), //日         
     "h+" : this.getHours()%12 == 0 ? 12 : this.getHours()%12, //小时         
     "H+" : this.getHours(), //小时         
     "m+" : this.getMinutes(), //分         
     "s+" : this.getSeconds(), //秒         
     "q+" : Math.floor((this.getMonth()+3)/3), //季度         
     "S" : this.getMilliseconds() //毫秒         
     };         
     var week = {         
     "0" : "\u65e5",         
     "1" : "\u4e00",         
     "2" : "\u4e8c",         
     "3" : "\u4e09",         
     "4" : "\u56db",         
     "5" : "\u4e94",         
     "6" : "\u516d"        
     };         
     if(/(y+)/.test(fmt)){         
         fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));         
     }         
     if(/(E+)/.test(fmt)){         
         fmt=fmt.replace(RegExp.$1, ((RegExp.$1.length>1) ? (RegExp.$1.length>2 ? "\u661f\u671f" : "\u5468") : "")+week[this.getDay()+""]);         
     }         
     for(var k in o){         
         if(new RegExp("("+ k +")").test(fmt)){         
             fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));         
         }         
     }         
     return fmt;         
}
Date.parseTime=function(longTime){
	if(!longTime) return;
	var d=	new Date();
	d.setTime(longTime);
	return d.format('yyyy-MM-dd HH:mm:ss');
} 
Date.parseDate=function(longTime){
	if(!longTime) return;
	var d=	new Date();
	d.setTime(longTime);
	return d.format('yyyy-MM-dd');
}
Number.prototype.toPercent = function(){
	return (Math.round(this * 10000)/100).toFixed(2) + '%';
	}
Number.prototype.formatMoney = function (places, symbol, thousand, decimal) {
    places = !isNaN(places = Math.abs(places)) ? places : 2;
    symbol = symbol !== undefined ? symbol : "$";
    thousand = thousand || ",";
    decimal = decimal || ".";
    var number = this,
        negative = number < 0 ? "-" : "",
        i = parseInt(number = Math.abs(+number || 0).toFixed(places), 10) + "",
        j = (j = i.length) > 3 ? j % 3 : 0;
    return symbol + negative + (j ? i.substr(0, j) + thousand : "") + i.substr(j).replace(/(\d{3})(?=\d)/g, "$1" + thousand) + (places ? decimal + Math.abs(number - i).toFixed(places).slice(2) : "");
};
function formatMoney(number, places, symbol, thousand, decimal) {
    number = number || 0;
    places = !isNaN(places = Math.abs(places)) ? places : 2;
    symbol = symbol !== undefined ? symbol : "$";
    thousand = thousand || ",";
    decimal = decimal || ".";
    var negative = number < 0 ? "-" : "",
        i = parseInt(number = Math.abs(+number || 0).toFixed(places), 10) + "",
        j = (j = i.length) > 3 ? j % 3 : 0;
    return symbol + negative + (j ? i.substr(0, j) + thousand : "") + i.substr(j).replace(/(\d{3})(?=\d)/g, "$1" + thousand) + (places ? decimal + Math.abs(number - i).toFixed(places).slice(2) : "");
}
/**
 * 判断是不是正数
 * @param number
 * @returns {Boolean}
 */
function isInteger(number){
	 var re = /^[1-9]+[0-9]*]*$/  ;   //判断字符串是否为数字 /^[0-9]+.?[0-9]*$/     //判断正整数 /^[1-9]+[0-9]*]*$/  
	 if (!re.test(number)){
	        return false;
	 }
	 return true;
}
function isNull(arg1)
{
 return !arg1 && arg1!==0 && typeof arg1!=="boolean"?true:false;
}
