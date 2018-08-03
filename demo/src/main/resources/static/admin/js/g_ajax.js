//全局的ajax访问，处理ajax清求时sesion超时
$.ajaxSetup({
    contentType : "application/x-www-form-urlencoded;charset=utf-8",
    complete : function(XMLHttpRequest, textStatus) {
        var noPorn = XMLHttpRequest.getResponseHeader("noPorn"); // 通过XMLHttpRequest取得响应头，noPorn，
        var noLogin = XMLHttpRequest.getResponseHeader("noLogin"); // 通过XMLHttpRequest取得响应头，noPorn，
        if (noPorn == "noPorn") {
            // 如果超时就处理 ，指定要跳转的页面
            window.location.replace("/privilege/noPorn");
        }

        if (noLogin == "noLogin") {
            // 如果超时就处理 ，指定要跳转的页面
            var loginUrl = XMLHttpRequest.getResponseHeader("loginUrl");
            window.location.replace(loginUrl);
        }

    }
});