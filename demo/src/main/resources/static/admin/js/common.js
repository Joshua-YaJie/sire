/**
 * Created by zlc on 16/3/2.
 */
function showModal(){
    $('#showModel').modal('show');
}
function closeModal(){
    $('#showModel').modal('hide');
}
function serializeJson(modalId){
    var serializeObj={};
    var array=$("#"+modalId+" form").serializeArray();
    var str=$("#"+modalId+" form").serialize();
    $(array).each(function(){
        if(serializeObj[this.name]){
            if($.isArray(serializeObj[this.name])){
                serializeObj[this.name].push(this.value);
            }else{
                serializeObj[this.name]=[serializeObj[this.name],this.value];
            }
        }else{
            serializeObj[this.name]=this.value;
        }
    });
    return serializeObj;
}
function setModalValues(modalId,data){

    var objs, index;
    objs = $("#"+modalId+" form").serializeArray();
    for (index = 0; index < objs.length; ++index)
    {
        if(typeof($("#"+modalId +" #edit-"+objs[index].name).attr("class")) != "undefined"&&
            $("#"+modalId +" #edit-"+objs[index].name).attr("class").indexOf("chosen-select")>0){
            $("#"+modalId +" #edit-"+objs[index].name).val(data[objs[index].name]);
            $("#"+modalId +" #edit-"+objs[index].name).trigger("chosen:updated");
        }else
            $("#"+modalId +" #edit-"+objs[index].name).val(data[objs[index].name]) ;
    }
}
function checkModalValues(modalId,warnId){
    var objs, index;
    objs = $("#"+modalId+" form").serializeArray();
    $("#"+warnId).hide();
    for (index = 0; index < objs.length; ++index)
    {
        if(typeof($("#"+modalId +" #edit-"+objs[index].name).attr("must")) != "undefined"&&
            $("#"+modalId +" #edit-"+objs[index].name).attr("must")=="true"){
            if($("#"+modalId +" #edit-"+objs[index].name).val()==""){
                var field=$("#"+modalId +" #label-"+objs[index].name).text();
                $("#"+warnId +" span").text(field+"必须填写");
                $("#"+warnId).show();
                return false;
            }
        }

    }
    return true;
}

function clearModalValues(modalId){
    var objs, index;
    objs = $("#"+modalId+" form").serializeArray();
    for (index = 0; index < objs.length; ++index)
    {
        if(typeof($("#"+modalId +" #edit-"+objs[index].name).attr("class")) != "undefined"&&
            $("#"+modalId +" #edit-"+objs[index].name).attr("class").indexOf("chosen-select")>0){
            $("#"+modalId +" #edit-"+objs[index].name).val("");
            $("#"+modalId +" #edit-"+objs[index].name).trigger("chosen:updated");
        }else
            $("#"+modalId +" #edit-"+objs[index].name).val("") ;
    }

}
function ajaxJson(config){
    $('#loadingModal').modal("show");
    $.ajax({
        type: 'post',
        data: config.data,
        url:config.url,
        dataType: 'json',
        contentType: "application/json",
        success: function (data) {
            $('#loadingModal').modal('hide');
            if(data.code==0){
                if( typeof config.success === 'function' ){
                    config.success(data);
                }else{
                    $.showTips({message: "操作成功", autoclose:"2000",flushPage:true});
                }
            }else{

                if( typeof config.fail === 'function' ){
                    config.fail(data);
                }else{
                    strapError("操作失败,error:"+data.msg);
                }
                return false;
            }
        },
        error: function (data) {
            $('#loadingModal').modal('hide');
            if( typeof config.error === 'function' ){
                config.error(data);
            }else{
                strapError("操作失败！");
            }
            return false;
        }
    });
}
function ajax(config){
    $('#loadingModal').modal("show");
    $.ajax({
        url:config.url,
        data:config.data,
        type: 'post',
        async: false,
        success: function(data) {
            $('#loadingModal').modal('hide');
            if(data.code==0){
                if( typeof config.success === 'function' ){
                    config.success(data);
                }else{
                    $.showTips({message: "操作成功", autoclose:"2000",flushPage:true});
                }
            }else{
                if( typeof config.fail === 'function' ){
                    config.fail(data);
                }else{
                    strapError("操作失败,error:"+data.msg);
                }
                return false;
            }
        },
        error:function(data){
            $('#loadingModal').modal('hide');
            if( typeof config.error === 'function' ){
                config.error(data);
            }else{
                strapError("操作失败！");
            }
            return false;
        }
    });
}