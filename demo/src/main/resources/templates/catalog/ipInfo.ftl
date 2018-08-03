<#import "../include/loading.ftl" as loading />
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8" />
    <title></title>
    <link rel="stylesheet" type="text/css" href="../../bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="../../bootstrap/table/css/bootstrap-table.min.css"/>
    <link rel="stylesheet" type="text/css" href="../../bootstrap/table/css/bootstrap-theme.min.css"/>
    <link rel="stylesheet" type="text/css" href="../../adminlte/dist/css/AdminLTE.min.css"/>
    <link rel="stylesheet" type="text/css" href="../../bootstrap/confirm/jquery-confirm.min.css"/>
    <link rel="stylesheet" type="text/css" href="../../function/css/loading.css"/>
    <style type="text/css">
        .myTab th {background: #efefef none repeat scroll 0 0;}
        .fixed-table-container tbody td .th-inner, .fixed-table-container thead th .th-inner {
            line-height: 15px;
        }
    </style>
</head>

<body>
<div class="" style="margin:5px 10px;">
    <div class="row" style="">
        <div class="col-md-6 col-xs-12" >
            <div id="toolbar" class="fixed-table-toolbar" style="margin-bottom: 5px;">
                <div class="form-inline" role="form">
                    <button id="add" class="btn btn-info btn-sm" onclick="openPTreeAdd('appEdit')">
                        <i class="fa fa-plus-circle"></i>增加
                    </button>
                    <button id="query" class="btn btn-info btn-sm">查询</button>
                    <div class="form-group">
                        <div id="queryParmas" class="input-group">
                            <input id="query_params" class="form-control" value="" size="16" type="text" value="" placeholder="IP">
                        </div>
                    </div>
                    <button id="import" class="btn btn-info btn-sm">Excel导入</button>
                    <button id="export" class="btn btn-info btn-sm">Excel导出</button>
                </div>
            </div>
        </div>
        <table class="myTab" id="dateTable">  </table>
    </div>
</div>

<div class="modal fade" id="appEdit" tabindex="-1" role="dialog"
     aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">编辑信息<i class="fa fa-pencil"></i></h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="treeForm">
                    <input type="hidden" id="id" name="id"  value="" />
                    <div class="form-group">
                        <label for="nodecode" class="col-sm-2 control-label">系统</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="os" name="os">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="nodecode" class="col-sm-2 control-label">IP</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="ip" name="ip">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="nodecode" class="col-sm-2 control-label">业务名称</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="businessName" name="businessName">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="nodecode" class="col-sm-2 control-label">备注</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="description" name="description">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="nodecode" class="col-sm-2 control-label">IP段业务分类</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="ipBusClassfy" name="ipBusClassfy">
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" name="close" class="btn btn-default"
                        data-dismiss="modal">取消</button>
                <button type="button" name="buttonsave" id="rolemenusave" onclick="saveAppInfo()"
                        class="btn btn-primary">确认</button>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="Upload" tabindex="-1" role="dialog"
     aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" >Excel文件上传<i class="fa fa-pencil"></i></h4>
            </div>
            <div class="modal-body">
                <form name="uploadform" method="POST" action="ipUpload" ENCTYPE="multipart/form-data">
                    <table border="1" width="450" cellpadding="4" cellspacing="2" bordercolor="#9BD7FF">
                        <tr><td width="100%" colspan="2">
                            Excel文件：<input name="fileName" size="40" type="file">
                        </td></tr>
                    </table>
                    <br/><br/>
                    <table>
                        <tr><td align="center"><input name="upload" type="submit" value="开始上传"/></td></tr>
                    </table>
                </form>
            </div>
        </div>
    </div>
</div>
<@loading.playloading/>
<script type="text/javascript" src="../../admin/js/jquery.min.js"></script>
<script type="text/javascript" src="../../bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="../../bootstrap/confirm/jquery-confirm.min.js"></script>
<script type="text/javascript" src="../../bootstrap/confirm/confirm.js"></script>
<script type="text/javascript" src="../../bootstrap/table/js/bootstrap-table.min.js"></script>
<script type="text/javascript" src="../../bootstrap/table/js/bootstrap-table-zh-CN.min.js"></script>
<script type="text/javascript" src="../../function/js/common.js"></script>
<script type="text/javascript" src="../../function/js/timeTools.js"></script>
<script type="text/javascript" src="../../bootstrap/js/component.js"></script>
<script type="text/javascript" src="../../function/js/publicFunction.js"></script>

<script>
    function queryParams(params) {
        return {
            pageSize: params.limit,
            pageIndex: (params.offset+params.limit)/params.limit,
            ip: $("#query_params").val()
        };
    }
    function openLabelEdit(r){
        $("#id").val(r.id);
        $("#ip").val(r.ip);
        $("#os").val(r.os);
        $("#businessName").val(r.businessName);
        $("#ipBusClassfy").val(r.ipBusClassfy);
        $("#description").val(r.description);
        $('#appEdit').modal('show');
    }
    function openPTreeAdd(id){
        $("#treeForm input").val("");
        $('#'+id).modal('show');
    }

    function saveAppInfo(){
        ajax({
            url:"editIpInfo.do",
            data:$("#treeForm").serialize(),
            type: 'post',
            success: function(data) {
                strapSuccess("操作成功!");
                queryLabel();
                $('#appEdit').modal('hide');
            }
        });
    }

    function delLabel(row){
        ajax({
            url:"delIpInfo.do",
            data:{
                id:row.id
            },
            type: 'post',
            success: function(data) {
                strapSuccess("操作成功!");
                queryLabel();
            }
        });
    }
    function queryLabel(){
        $("#dateTable").bootstrapTable('refresh',{
            url:"queryIpList.do"
        });
    }
    $('#query').click(function () {
        queryLabel();
    });
    $('#export').click(function () {
        window.location.href = "ipExport";
    });
    $('#import').click(function () {
        $('#Upload').modal('show');
    });
    function optFormatter(value, row, index){
        return "<button  onclick='' type='button' class='btn btn-info btn-xs labelUpd'>修改</button>  "
                +"<button  onclick='' type='button' class='btn btn-warning btn-xs labelDel'>删除</button>";
    }

    window.operateEvents = {
        'click .labelUpd': function (e, value, row, index) {
            openLabelEdit(row);
        },
        'click .labelDel': function (e, value, row, index) {
            delLabel(row);
        }
    };



    $(function () {
        $('#loadingModal').modal("show");
        bootstrapTable({
            id:"dateTable",
            url:"queryIpList.do",
            striped: true,
            pagination: true,
            cache:false,
            singleSelect: false,
            pageSize:50,
            pageList: [50,100],
            search: false, //不显示 搜索框
            showColumns: false, //不显示下拉框（选择显示的列）
            sidePagination: "server", //服务端请求
            queryParams: queryParams,
            columns:[
                {field: 'businessName', title: '业务名称', halign: 'center',align:'center'},
                {field: 'ip', title: 'IP',halign: 'center',align:'center'},
                {field: 'os', title: '系统',halign: 'center',align:'center'},
                {field: 'description', title: '备注',halign: 'center',align:'center'},
                {field: 'ipBusClassfy', title: 'IP段业务分类',halign: 'center',align:'center'},
                {field: 'id', title: '索引',halign: 'center',align:'center',visible:false},
                {title: '操作',halign: 'center',formatter:optFormatter,events:'operateEvents'}
            ],
            onLoadSuccess:function(data){
                $('#loadingModal').modal('hide');
                if(data.code<0){
                    strapError("接口发生错误，info:"+data.msg);
                }
            },
            onRefreshOptions :function(options){
                $('#loadingModal').modal("show");
                $("#lineLoanPassRate").hide();
            }
        });

    });
</script>
</body>


</html>