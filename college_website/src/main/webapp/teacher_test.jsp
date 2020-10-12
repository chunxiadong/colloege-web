<%--
  Created by IntelliJ IDEA.
  User: Azrael
  Date: 2020/10/12
  Time: 13:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Teacher_test</title>
</head>
<body>
<h2>
    Hello World!
</h2>
<a href="${pageContext.request.contextPath}/college/teacher/getAllTeacher">开始测试</a>
<h2>
    TeacherMessage_insert_test
</h2>
<hr/>
<form action="${pageContext.request.contextPath}/college/teacher/insertTeacher" enctype="multipart/form-data" method="post">
    <input type="text" name="teacherName"/>教师姓名
    <input type="text" name="teacherTitle"/>教师职位
    <input type="text" name="teacherHonor"/>教师荣誉
    <input type="text" name="teacherTeam"/>教师团队
    <input type="text" name="teacherTeamTitle">团队职位
    <input type="submit" value="go">
</form>


<h2>
    TeacherMessage_get_test
</h2>
<hr/>
<form action="${pageContext.request.contextPath}/college/teacher/getTeacher" enctype="multipart/form-data" method="post">
    <input type="text" name="teacherId"/>教师编号
    <input type="text" name="teacherName"/>教师姓名
    <input type="text" name="teacherTitle"/>教师职位
    <input type="submit" value="go">
</form>

<h2>
    TeacherMessage_delete_test
</h2>
<hr/>
<form action="${pageContext.request.contextPath}/college/teacher/deleteTeacher" enctype="multipart/form-data" method="post">
    <input type="text" name="teacherId"/>教师编号
    <input type="text" name="teacherName"/>教师姓名
    <input type="text" name="teacherTitle"/>教师职位
    <input type="submit" value="go">
</form>
<h2>
    TeacherMessage_update_test
</h2>
<hr/>
<form action="${pageContext.request.contextPath}/college/teacher/updateTeacher" enctype="multipart/form-data" method="post">
    <input type="text" name="teacherId"/>想要更改的教师编号
    <br/>
    <input type="text" name="teacherName"/>教师姓名
    <input type="text" name="teacherTitle"/>教师职位
    <input type="text" name="teacherHonor"/>教师荣誉
    <input type="text" name="teacherTeam"/>教师团队
    <input type="text" name="teacherTeamTitle"/>团队职位
    <input type="submit" value="go">
</form>

</body>
</html>