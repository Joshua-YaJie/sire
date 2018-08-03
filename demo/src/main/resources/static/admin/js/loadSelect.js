/*
 *@Description: loadSelect.js
 *@Version:	    v1.0
 *@Author:      zhanghaijun
 *@Update:      zhanghaijun(2015-05-12 10:30)
 */
loadSelect = function(selectArray, keep, def) {
    var loadOptions = function(selectObj, indexNo, keep, def) {
        //obj
        var i = indexNo,obj = $("select[name='" + selectObj[i].name + "']");
        //changeSelect
        var changeSelect = function() {
            if (selectObj[i].url ) {
                if (obj.val() === "") {

                    for (var j = i +1; j < selectObj.length; j++) {
                        if (keep ) {
                            $("select[name='" + selectObj[j].name + "'] option").each(function() {
                                if (this.value != "")this.parentNode.removeChild(this);
                            });
                        } else {
                            $("select[name='" + selectObj[j].name + "']").remove();
                        }
                    }

                }
                else {
                    var nextIndex = i + 1;
                    var objNext = $("select[name='" + selectObj[nextIndex].name + "']");
                    if (objNext.size() == 0) {
                        obj.after("<select name='" + selectObj[nextIndex].name + "' class='" + selectObj[nextIndex].className + "'></select>");
                    }
                    loadOptions(selectArray, nextIndex, keep, def);
                }

            }
        };

        //addOptions
        var addOptions = function(data, o, def) {
            var _tmpObj = o.hide(),
                disStyle = {};
            _tmpObj.children("option").each(function() {
                this.parentNode.removeChild(this);
            });

            if (def === true ) {
                var defop = document.createElement('option'),
                    sl = _tmpObj[0];
                defop.text = "请选择";
                defop.value = "0";
                try {
                    sl.add(defop, null); // standards compliant
                } catch(ex) {
                    if(sl!=undefined){
                        sl.add(defop); // IE only
                    }
                }
            }

            $.each(data, function(index, callback, def) {
                var _this = this,op = document.createElement('option'),sl = _tmpObj[0];
                op.text = _this.label;
                op.value = _this.value;
                try {
                    sl.add(op, null); // standards compliant
                } catch(ex) {
                    if(sl!=undefined){
                        sl.add(op); // IE only
                    }
                }

                if (index === 0 && defop === false) {
                    op.selected = true;
                }
                if (_this.selected == "selected" ) {
                    changeSelect();
                }

            });

            if (data.length>0||(def!=undefined&&!def.show)) {
                disStyle.display = 'inline';
            }
            _tmpObj.css(disStyle);
        };


        //loadDefaultValue
        var loadDefaultValue = function(i) {

            if (selectObj[i].defaultValue) {
                var flag = false;
                obj.children("option").each(function(){
                        var optionvalue = $(this).val()
                        if(optionvalue==selectObj[i].defaultValue){
                            flag=true;
                        }
                }
                );
                if(flag){
                    obj.val(selectObj[i].defaultValue);
                }else{
                    obj.val(0);
                }
            }
            changeSelect();
        };
        //initSelect
        if (i == 0 ) {
            $.get(selectObj[i].initUrl, function(data) {
                addOptions(data, obj, def);
                loadDefaultValue(i);
            });
        } else {
            var preIndex = i - 1;
            var selectVal = $("select[name=" + selectObj[preIndex].name + "]").val() - 0;
            if (selectVal == 0) {
                addOptions([], obj, def);
                loadDefaultValue(i);
            } else {
                var urlget=selectObj[preIndex].url;
                if(urlget.indexOf("?") > 0){
                    urlget+="&value=";
                }else{
                    urlget+="?value=";
                }
                $.get(urlget + selectVal, function(data) {
                    addOptions(data, obj, def);
                    loadDefaultValue(i);
                });
            }
        }
        obj.bind("change", changeSelect);
    };

    loadOptions(selectArray, 0, keep, def);
};