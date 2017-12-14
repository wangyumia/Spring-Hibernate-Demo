<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<%
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link href="<%=basePath %>bootstrap2.3.2/css/bootstrap.min.css" rel="stylesheet" />
    <title></title>
    <link href="<%=basePath %>styles/Common.css" rel="stylesheet" />
    <link href="<%=basePath %>styles/Index2.css" rel="stylesheet" />   
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
								<th style="color:black;height:50px;width:100px;">图书名字</th>
                                <th style="color:black;height:50px;width:100px;">图书类型</th>
                                <th style="color:black;height:50px;width:800px;">图书介绍</th>
                                <th style="color:black;height:50px;width:100px;">图书价格</th>
                                <th style="color:black;height:50px;width:200px;">操作</th> 
                            </tr> 
                        </thead>
                       <c:forEach var="book" items="${detailList}">
                        	<tbody id="tbody">
                        		<tr  class="change">
                        		<th><img src="<%=basePath %>/${book.bookimg1}" alt="无法显示该图片" width="100px" height="150px"/><br><br>${book.bookname}</th>
                        		<th>${book.book.bookType.typename}</th>
                        		<th class="intro">${book.introduce}</th>
                        		<th>${book.bookprice}</th>
                        		<th ><a href="<%=basePath %>book/getbook?bookid=${book.bookid }">修改</a>&emsp;|&emsp;<a href="<%=basePath %>book/deletebook?bookid=${book.bookid }">删除</a></th>  
								</tr>
                        	</tbody>
                       </c:forEach>
                    </table>
                    <div id="page" class="tr"></div>
                </div>
            </div>
            <div id="addModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                    <h3>添加图书</h3>
                </div>
                 <form class="form-horizontal" action="<%=basePath%>book/addbook"> 
                <div class="modal-body">
                   		 <div class="control-group">
                            <label class="control-label" for="Chinese">图书图片</label>
                            <div class="controls">
                                <input type="text" id="Chinese" placeholder="bookname" name="bookimg">
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="Chinese">图书名字</label>
                            <div class="controls">
                                <input type="text" id="Chinese" placeholder="bookname" name="bookname">
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="Chinese">图书类型</label>
                            <div class="controls">
                                <input type="text" id="Chinese" placeholder="booktype" name="booktype">
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="Math">图书介绍</label>
                            <div class="controls">
                                <input type="text" id="Math" placeholder="introduce" name="introduce">
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="English">图书价格</label>
                            <div class="controls">
                                <input type="text" id="English" placeholder="bookprice" name="bookprice">
                            </div>
                        </div>
                </div>
                <div class="modal-footer">
                    <button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
                    <button class="btn btn-primary" id="add" onclick="add();">保存</button>
                    <button class="btn btn-primary" id="edt" onclick="edt();">保存</button>
                </div>
               </form>
            </div>
          
        </div>
    </div>

    <script src="<%=basePath %>scripts/jquery-1.9.1.min.js"></script>
    <script src="<%=basePath %>bootstrap2.3.2/js/bootstrap.min.js"></script>
    <script src="<%=basePath %>layer-v2.3/layer/layer.js"></script>
    <script src="<%=basePath %>laypage-v1.3/laypage/laypage.js"></script>
    <script src="<%=basePath %>scripts/Index2.js"></script>
</body>
</html>
