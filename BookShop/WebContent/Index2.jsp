<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link href="bootstrap2.3.2/css/bootstrap.min.css" rel="stylesheet" />
    <title></title>
    <link href="styles/Common.css" rel="stylesheet" />
    <link href="styles/Index2.css" rel="stylesheet" />
</head>
<body>
    <div class="container-fluid">
        <div class="row-fluid">
            <h4>数据列表</h4>
            <div class="add"><a class="btn btn-success" onclick="openadd();">新增</a></div>
            <div class="w">
                <div class="span12">
                    <table class="table table-condensed table-bordered table-hover tab">
                        <thead>
                            <tr>
                                <th>bookimg</th>
                                <th>bookname</th>
                                <th>introduce</th>
                                <th>bookprice</th>
                                <th>operation</th>
                            </tr>
                        </thead>
                        <tbody id="tbody"></tbody>
                    </table>
                    <div id="page" class="tr"></div>
                </div>
            </div>
            <div id="addModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                    <h3 id="myModalLabel">添加图书</h3>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal" action="">
                        <div class="control-group">
                            <label class="control-label" for="userName">bookimg</label>
                            <div class="controls">
                                <img src=""/>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="Chinese">bookname</label>
                            <div class="controls">
                                <input type="text" id="Chinese" placeholder="bookname">
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="Math">introduce</label>
                            <div class="controls">
                                <input type="text" id="Math" placeholder="introduce">
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="English">bookprice</label>
                            <div class="controls">
                                <input type="text" id="English" placeholder="bookprice">
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
                    <button class="btn btn-primary" id="add" onclick="add();">保存</button>
                    <button class="btn btn-primary" id="edt" onclick="edt();">保存</button>
                </div>
            </div>
        </div>
    </div>

    <script src="scripts/jquery-1.9.1.min.js"></script>
    <script src="bootstrap2.3.2/js/bootstrap.min.js"></script>
    <script src="layer-v2.3/layer/layer.js"></script>
    <script src="laypage-v1.3/laypage/laypage.js"></script>
    <script src="scripts/Index2.js"></script>
</body>
</html>
