<%--
  Created by IntelliJ IDEA.
  User: 春夏冬
  Date: 2020/9/3
  Time: 8:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Hello World!</h2>
<a href="${pageContext.request.contextPath}/college/message/getAllMessage">开始测试</a>

<hr/>
<form action="${pageContext.request.contextPath}/college/message/deleteMessage" enctype="multipart/form-data" method="post">
    <input type="text" name="messageId"/>编号
    <input type="text" name="messageTitle"/>标题
    <input type="text" name="messageType"/>类型
    <input type="text" name="author"/>作者
    <input type="text" name="formatDate"/>更新时间
    <input type="submit" value="go">
</form>
<img src="http://localhost:8080/college/message/onloadImg/4.jpg">
</body>
</html>
