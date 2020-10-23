<%--
  Created by IntelliJ IDEA.
  User: 春夏冬
  Date: 2020/10/22
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script>
        function changeImage() {
            $('#verifyCodeImage').attr('src', '${pageContext.request.contextPath }/user/getVerifyCode);
        }
    </script>
</head>
<body>
<div class="form-group">
    <div class="input-icon">
        <i class="fa fa-picture-o"></i>
        <input class="form-control" style="width:180px;" type="text" id="verifyCode" name="verifyCode" placeholder="验证码" maxlength="4">
        <img style="position: absolute;right: 0;top: 0;"  src="${pageContext.request.contextPath }/college/admin/getVerifyCode" width="110" height="34" id="verifyCodeImage" onclick="javascript:changeImage();">
    </div>
</div>
</body>
</html>
