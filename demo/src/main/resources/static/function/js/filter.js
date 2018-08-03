$.ajaxSetup({
	complete: function (XMLHttpRequest, textStatus) {
        var data = XMLHttpRequest.responseText;
        if (data == "timeout") {
        	 if( window.top != window.self ){
                 window.top.location = "/index.html";
             }
        }
    }
});