<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Hello World!</h2>
<a href="${pageContext.request.contextPath}/college/message/getAllMessage">开始测试</a>

<hr/>
<form action="${pageContext.request.contextPath}/college/message/insertMessageWithImg" enctype="multipart/form-data" method="post">
<input type="file" name="file"/>附件
<input type="text" name="messageTitle"/>标题
<input type="text" name="messageType"/>类型
<input type="text" name="author"/>作者
<input type="text" name="messageContent"/>内容
<input type="submit" value="upload">
</form>
<hr/>
<%--<img src="http://localhost:8080/college/message/onloadImg/4.jpg">--%>
<form action="${pageContext.request.contextPath}/college/teacher/insertTeacher" enctype="multipart/form-data" method="post">
    <input type="text" name="teacherName"/>教师名
    <input type="text" name="teacherTitle"/>职务
    <input type="text" name="teacherHonor"/>荣誉
    <input type="text" name="teacherTeam"/>队伍
    <input type="text" name="teacherTeamTitle"/>团队支撑
    <input type="submit" value="upload">
</form>
<form action="${pageContext.request.contextPath}/college/teacher/getTeacher" enctype="multipart/form-data" method="post">
    <input type="text" name="teacherName"/>教师名
    <input type="text" name="teacherTitle"/>职务
    <input type="text" name="TeacherId"/>ID
    <input type="submit" value="upload">
</form>
<hr/>
<form action="${pageContext.request.contextPath}/college/message/getMessage" enctype="multipart/form-data" method="post">
    <input type="text" name="messageTitle"/>标题
    <input type="text" name="messageType"/>类型
    <input type="text" name="author"/>作者
    <input type="text" name="formatDate"/>time
    <input type="text" name="messageId"/>ID
    <input type="submit" value="upload">
</form>
</body>
</html>