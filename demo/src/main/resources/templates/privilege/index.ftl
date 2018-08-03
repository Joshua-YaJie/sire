<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>史陶比尔管理中心</title>
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.6 -->
    <link rel="stylesheet" type="text/css" href="../../adminlte/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="../../adminlte/dist/css/AdminLTE.min.css">
    <link rel="stylesheet" type="text/css" href="../../adminlte/dist/css/skins/_all-skins.min.css">
    <link rel="stylesheet" type="text/css" href="../../adminlte/plugins/iCheck/flat/blue.css">
    <link rel="stylesheet" type="text/css" href="../../adminlte/plugins/morris/morris.css">
    <link rel="stylesheet" type="text/css" href="../../adminlte/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
    <link rel="stylesheet" type="text/css" href="../../adminlte/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
    <link rel="stylesheet" type="text/css" href="../../adminlte/font-awesome.min.css"/>
    <link rel="stylesheet" type="text/css" href="../../adminlte/ionicons.min.css"/>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <header class="main-header">
        <a href="#" class="logo">
            <span class="logo-mini"><b>STBE</b></span>
            <span class="logo-lg"><b>史陶比尔管理中心</b></span>
        </a>
        <nav class="navbar navbar-static-top">
            <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
                <span class="sr-only">Toggle navigation</span>
            </a>
            <div class="navbar-custom-menu">
                <ul class="nav navbar-nav"> 
      <#--              <li class="dropdown user user-menu">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <img src="../adminlte/dist/img/credit/51.jpg" class="user-image" alt="User Image">
                            <span class="hidden-xs">Administrator</span>
                        </a>
                    </li>-->
                    <li>
                        <a href="#" data-toggle="control-sidebar"><i class="fa fa-gears"></i></a>
                    </li>
                </ul>
            </div>
        </nav>
    </header>
    <!--左侧导航栏-->
    <aside class="main-sidebar">
        <section class="sidebar">
            <div class="user-panel">
                <div class="pull-left image">
                    <img src="../adminlte/dist/img/credit/IMG20180802_102510.png" class="img-circle" alt="User Image">
                </div>
                <div class="pull-left info">
                    <p>玄儿</p>
                    <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
                </div>
            </div>
            <ul class="sidebar-menu">
                <li class="header">史陶比尔导航栏</li>
<#--                <#list catalogList as item>-->
                      <li class="active treeview">
                            <a href="#">
                                <i class="fa fa-files-o"></i>
                                <span>史陶比尔</span>
                            </a>
  <#--                           <#list item.nodes as dItem>-->
                                <ul class="treeview-menu">
                                    <li><a href="/catalog/ipManage" target="myFrameName"><i class="fa fa-circle-o"></i> 大区权限</a></li>
                                    <li><a href="/catalog/ipManage" target="myFrameName"><i class="fa fa-circle-o"></i> 大区客户</a></li>
                                    <li><a href="/catalog/ipManage" target="myFrameName"><i class="fa fa-circle-o"></i> 区域客户</a></li>
                                </ul>
<#--                             </#list>-->
                       </li>
            <#--                 </#list>-->
            </ul>
        </section>
    </aside>
    <div class="content-wrapper">
       <iframe id="iframepage" name="myFrameName" src="/catalog/welcome" width="100%" frameborder="0" onLoad="iFrameHeight()"></iframe>
    </div>
    <footer class="main-footer">
        <div class="pull-right hidden-xs">
            <b>Version</b> 1.0.0
        </div>
        <strong>Copyright &copy; 2014-2020 <a href="https://www.u51.com/">史陶比尔</a>.</strong> All rights
        reserved.
    </footer>
    <!-- Control Sidebar -->
    <aside class="control-sidebar control-sidebar-dark">
        <ul class="nav nav-tabs nav-justified control-sidebar-tabs">
        </ul>
        <div class="tab-content">
            <div class="tab-pane" id="control-sidebar-home-tab">
            </div>
        </div>
    </aside>
    <div class="control-sidebar-bg"></div>
</div>

<script src="../../adminlte/plugins/jQuery/jquery-2.2.3.min.js"></script>
<script src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
<script>
  $.widget.bridge('uibutton', $.ui.button);
</script>

<script type="text/javascript" src="../../adminlte/bootstrap/js/bootstrap.min.js"></script>

<script type="text/javascript" src="../../adminlte/plugins/morris/morris.min.js"></script>

<script type="text/javascript" src="../../adminlte/plugins/sparkline/jquery.sparkline.min.js"></script>

<script type="text/javascript" src="../../adminlte/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script type="text/javascript" src="../../adminlte/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>

<script type="text/javascript" src="../../adminlte/plugins/knob/jquery.knob.js"></script>

<script type="text/javascript" src="../../adminlte/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>

<script type="text/javascript" src="../../adminlte/plugins/slimScroll/jquery.slimscroll.min.js"></script>

<script type="text/javascript" src="../../adminlte/plugins/fastclick/fastclick.js"></script>

<script type="text/javascript" src="../../adminlte/dist/js/app.min.js"></script>

<script type="text/javascript" src="../../adminlte/dist/js/demo.js"></script>


<script type="text/javascript" language="javascript">
    function iFrameHeight() {
	var ifm= document.getElementById("iframepage");
	var subWeb = document.frames ? document.frames["iframepage"].document : ifm.contentDocument;
	if(ifm != null && subWeb != null) {
	ifm.height =document.documentElement.clientHeight ;
	}
}
</script>
</body>
</html>
