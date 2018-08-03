<#import "import.ftl" as import/>
<#macro standard title="" keywords="" description="" jsMap={} cssMap={}>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>${title}</title>
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <@import.link filesMap={'bootstrap/css':'bootstrap.min','dist/css':'AdminLTE.min','dist/css/skins':'_all-skins.min','adminlte':'font-awesome.min,ionicons.min'}/>
    <@import.link cssMap/>
    <@import.script filesMap={"plugins/jQuery":"jQuery-2.1.4.min"}/>
    <style>
        .content{
            min-height:20px;;
        }
    </style>

</head>
<body class="hold-transition login-page">

    <#nested/>


    <@import.script filesMap={"bootstrap/js":"bootstrap.min","plugins/fastclick":"fastclick.min"}/>
    <@import.script filesMap={"dist/js":"app.min","plugins/slimScroll":"jquery.slimscroll.min","adminlte":"docs"}/>
    <@import.script jsMap/>
</body>




</html>
</#macro>

