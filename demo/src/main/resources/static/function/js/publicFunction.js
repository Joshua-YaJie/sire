/**
 * 头部导航，变换焦点
 * @param obj
 */
function doNavLiClick(obj){
	 $(obj).attr("class","active");
	 $($(obj).siblings()).removeClass("active");
}
/**
 * 选中id元素下得所有复选框,unDoId下的checkbox取消选择
 * @param id,unDoId
 */
function selectAllCheckBox(id,unDoId){
	if(unDoId!="")
		$("#"+unDoId+" input[type='checkbox']").prop("checked",false);
	$("#"+id+" input[type='checkbox']").prop("checked",true);
}
/**
 * @param obj 本身
 * @param id div的id
 */
function selectAll(obj,id){
	if(obj.checked){
		$("#"+id+" input[type='checkbox']").prop("checked",true);
	}else{
		$("#"+id+" input[type='checkbox']").prop("checked",false);
	}
}


/**
 * 获取选中复选框的id
 */
function getSelectCheckBoxIds(classId){
	var searchIDs = $("."+classId+":checked").map(function(){
		return $(this).val();
	});
	ids = searchIDs.get().join(",");
	if(ids==undefined||ids==''){
		return "";
	}
	return ids;
}
/**
*自定义操作
*/
function ajax(config){
	$('#loadingModal').modal("show");
    $.ajax({
    	  url:config.url,
	      data:config.data,
	      type: 'post',
	      async: false, 
	      success: function(data) { 
	    	  
           if(data.code >= 0){
              if( typeof config.success === 'function' ){
	  				config.success(data);
	  		  }
              $('#loadingModal').modal('hide');
           }else{
        	   $('#loadingModal').modal('hide');
        	   strapError("操作失败:"+data.msg);
              return false;
           }
          },
          error:function(data){
        	  $('#loadingModal').modal('hide');
        	  strapError("操作失败！");
              return false;
	        } 
	  });			      
   }