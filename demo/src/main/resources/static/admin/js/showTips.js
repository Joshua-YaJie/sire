(function($){
    $.extend({
        //showTips
        showTips:function(options){

            //defaults
            var defaults = {
                message:"",autoclose:3000,flushPage:false,btn_type:"btn-primary",redirectUrl:""
            };

            //extend
            options = $.extend({},defaults,options);

            var autoClose = "confirm|"+options.autoclose
            $.alert({
                title: '提示框!',
                content: options.message,
                autoClose: autoClose,
                confirmButton:"确定",
                confirmButtonClass: options.btn_type,
                columnClass: 'col-md-4 col-md-offset-4',
                confirm: function(){
                    if(options.flushPage){
                        window.location.reload();
                    }
                    if(options.redirectUrl!=""){
                        window.location= options.redirectUrl;
                    }
                }
            });


        }
    });
})(jQuery);