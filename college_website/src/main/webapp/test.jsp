<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<input type="button" id="btn" value="获取数据"/>
<table width="80%" align="center">
    <tr>
        <td>测试</td>
        <td>测试</td>
        <td>测试</td>
        <td>测试</td>
        <td>测试</td>
        <td>测试</td>
        <td>测试</td>
        <td>测试</td>
        <td>测试</td>
    </tr>
    <tbody id="content">
    </tbody>
</table>

<script src="https://s3.pstatp.com/cdn/expire-1-M/jquery/3.3.1/jquery.min.js"></script>
<script>

    $(function () {
        $("#btn").click(function () {
            $.post("${pageContext.request.contextPath}/college/message/getAllMessage",function (data) {
                console.log(data)
                var html="";
                for (var i = 0; i <data.length ; i++) {
                    html+= "<tr>" +
                        "<td>" +data[i].messageTitle+ "</td>" +
                        "<td>" +data[i].messageType+ "</td>" +
                        "<td>" +data[i].author + "</td>" +
                        "<td>" +data[i].createDate + "</td>" +
                        "<td>" +data[i].formatDate + "</td>" +
                        "<td>" +data[i].messageId + "</td>" +
                        "<td>" +data[i].messageContent + "</td>" +
                        "<td>" +data[i].messageAddress + "</td>" +
                        "<td>" +data[i].status + "</td>" +
                        "</tr>"
                }

                $("#content").html(html);
            });
        })
    })
</script>

</body>
</html>