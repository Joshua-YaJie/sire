function strapWarning(content){
	$.alert({
	    icon: 'glyphicon glyphicon-warning-sign',
	    title: '警告!',
	    animation: 'top',
	    content: content,
        confirmButtonClass: 'btn-warning'
	});
}
function strapWarningConfirm(config){
	$.alert({
	    icon: 'glyphicon glyphicon-warning-sign',
	    title: '警告!',
	    animation: 'top',
	    content: config.content,
        confirmButtonClass: 'btn-warning',
        confirm:function(){
        	config.confirm();
        }
	});
}
function strapSuccess(content){
	$.alert({
	    icon: 'glyphicon glyphicon-ok',
	    title: '成功!',
	    animation: 'top',
	    content: content,
        confirmButtonClass: 'btn-success'
	});
}
function strapSuccessConfirm(config){
	$.alert({
	    icon: 'glyphicon glyphicon-ok',
	    title: '成功!',
	    animation: 'top',
	    content: config.content,
        confirmButtonClass: 'btn-success',
        confirm:function(){
        	config.confirm();
        }
	});
}
function strapAlert(content){
	$.alert({
	    icon: 'glyphicon glyphicon-info-sign',
	    title: '提示!',
	    animation: 'top',
	    content: content,
        confirmButtonClass: 'btn-info'
	});
}
function strapAlertConfirm(config){
	$.alert({
	    icon: 'glyphicon glyphicon-info-sign',
	    title: '提示!',
	    animation: 'top',
	    content: config.content,
        confirmButtonClass: 'btn-info',
        confirm:function(){
        	config.confirm();
        }
	});
}
function strapError(content){
	$.alert({
	    icon: 'glyphicon glyphicon-remove',
	    title: '错误!',
	    animation: 'top',
	    content: content,
        confirmButtonClass: 'btn-danger'
	});
}
function strapAlertConfirm(config){
	$.alert({
	    icon: 'glyphicon glyphicon-remove',
	    title: '错误!',
	    animation: 'top',
	    content: config.content,
        confirmButtonClass: 'btn-danger',
        confirm:function(){
        	config.confirm();
        }
	});
}
function strapConfirm(config){
	$.confirm({
        icon:'glyphicon glyphicon-question-sign',
        title: '确认?',
        content: config.content,
        animation: 'top',
        confirmButtonClass: 'btn-info',
		cancelButtonClass: 'btn-danger',
	    confirm:function(){
        	config.confirm();
        }
    });
}
function strapConfirmHasCancel(config){
	$.confirm({
        icon:'glyphicon glyphicon-question-sign',
        title: '确认?',
        content: config.content,
        animation: 'top',
        confirmButtonClass: 'btn-info',
		cancelButtonClass: 'btn-danger',
	    confirm:function(){
        	config.confirm();
        },
	    cancel:config.cancel() 
    });
}