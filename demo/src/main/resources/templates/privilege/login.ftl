<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>MC-MANAGE | Log in</title>
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <link rel="stylesheet" href="../../adminlte/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="../../adminlte/font-awesome.min.css"/>
    <link rel="stylesheet" type="text/css" href="../../adminlte/ionicons.min.css"/>
    <link rel="stylesheet" href="../../adminlte/dist/css/AdminLTE.min.css">
    <link rel="stylesheet" href="../../admin/css/jquery-confirm.min.css">
    <link rel="stylesheet" href="../../adminlte/plugins/iCheck/square/blue.css">
    <![endif]-->
</head>
<body class="hold-transition login-page">
<div class="login-box">
    <div class="login-logo">
        <a href="#"><b>监控中心管理系统</b></a>
    </div>
    <div class="login-box-body">
        <p class="login-box-msg">Welcome To Mc-Manage</p>
        <form>
            <div class="form-group has-feedback">
                <input type="text" class="form-control" placeholder="账 号" id="username">
                <span class="fa fa-user form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input type="password" class="form-control" placeholder="密 码" id="password">
                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
            </div>
            <div class="row">
                <div class="col-xs-8">
                </div>
                <div class="col-xs-4">
                    <button type="button" id="submit" class="btn btn-primary btn-block btn-flat">登 录</button>
                </div>
            </div>
        </form>
    </div>
</div>
<script src="../../adminlte/plugins/jQuery/jquery-2.2.3.min.js"></script>
<script src="../../adminlte/bootstrap/js/bootstrap.min.js"></script>
<script src="../../adminlte/plugins/iCheck/icheck.min.js"></script>
<script src="../../admin/js/showTips.js"></script>
<script src="../../admin/js/jquery-confirm.min.js"></script>

<script>
  $(function () {
        $('input').iCheck({
          checkboxClass: 'icheckbox_square-blue',
          radioClass: 'iradio_square-blue',
          increaseArea: '20%' // optional
        });
        $("#submit").click(function(){
            var params={};
            var username = $.trim($("#username").val());
            if(username==""){
                $.showTips({message:"请输入用户名", autoclose: "20000000"});
                return false;
            }

            var password = $.trim($("#password").val());
            if(password==""){
                $.showTips({message:"请输入密码", autoclose: "2000"});
                return false;
            }
            params.username=username;
            params.password=password;
            $.ajax({
                type: 'POST',
                url: "login.do",
                data: JSON.stringify(params),
                dataType: 'json',
                contentType: "application/json",
                success: function (res) {
                    if (res.success) {
                        window.location.href=res.refer;
                    } else {
                        $.showTips({message:"用户名或者密码不正确", autoclose: "2000"});
                    }
                },
                error: function (res) {
                    $.showTips({message: "系统异常，登录失败", autoclose: "2000"});
                }
            });
        });
    });
</script>
</body>
</html>
