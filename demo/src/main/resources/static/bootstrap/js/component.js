function  bootstrapTable(config){
	$("#"+config.id).bootstrapTable({
		height:config.height||500,
			url:config.url,
        striped: config.striped||true,
        pagination: config.pagination||true,
        onlyInfoPagination:config.onlyInfoPagination||false,
        cache:config.cache||false,
        singleSelect: config.singleSelect||false,
        pageNumber:config.pageNumber||1,
        pageSize: config.pageSize||10,
        pageList: config.pageList||[10, 20, 50, 100,200],
        search: config.search||false, //不显示 搜索框
        showColumns: config.showColumns||false, //不显示下拉框（选择显示的列）
        sidePagination: config.sidePagination||"server", //服务端请求
        queryParams: queryParams,
        columns:config.columns,
		onLoadSuccess:function(data){
			if( typeof config.onLoadSuccess === 'function' ){
				config.onLoadSuccess(data);
			}
        },
        onLoadError: function (status, res) {
        	var data = res.responseText;
            if (data == "timeout") {
            	 if( window.top != window.self ){
                     window.top.location = "/index.html";
                 }
            }
        	if( typeof config.onLoadError === 'function' ){
 				config.onLoadError(status, res);
 			}else{
 				if(document.getElementById("loadingModal")){
 					$('#loadingModal').modal('hide');
 				}
 				strapError("接口发生错误，info:"+data);
 			}
            
        },
        onRefreshOptions:function(options) {
        	if( typeof config.onRefreshOptions === 'function' ){
				config.onRefreshOptions(options);
			}
        }
	});
} 

function  bootstrapTableNoHeight(config){
	$("#"+config.id).bootstrapTable({
	    url:config.url,
        striped: config.striped||true,
        pagination: config.pagination||true,
        onlyInfoPagination:config.onlyInfoPagination||false,
        cache:config.cache||false,
        singleSelect: config.singleSelect||false,
        pageNumber:config.pageNumber||1,
        pageSize: config.pageSize||10,
        pageList: config.pageList||[10, 20, 50, 100,200],
        search: config.search||false, //不显示 搜索框
        showColumns: config.showColumns||false, //不显示下拉框（选择显示的列）
        sidePagination: config.sidePagination||"server", //服务端请求
        queryParams: queryParams,
        columns:config.columns,
		onLoadSuccess:function(data){
			if( typeof config.onLoadSuccess === 'function' ){
				config.onLoadSuccess(data);
			}
        },
        onLoadError: function (status, res) {
        	var data = res.responseText;
            if (data == "timeout") {
            	 if( window.top != window.self ){
                     window.top.location = "/index.html";
                 }
            }
        	if( typeof config.onLoadError === 'function' ){
 				config.onLoadError(status, res);
 			}else{
 				if(document.getElementById("loadingModal")){
 					$('#loadingModal').modal('hide');
 				}
 				strapError("接口发生错误，info:"+data);
 			}
            
        },
        onRefreshOptions:function(options) {
        	if( typeof config.onRefreshOptions === 'function' ){
				config.onRefreshOptions(options);
			}
        }
	});
} 
