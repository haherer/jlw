<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <p>springmvc测试</p>
<%--    <p><a href="user/some.do">some.do请求</a> </p>--%>

    <form action="user/some.do" method="post">
        姓名<input type="text" name="name">
        年龄<input type="text" name="age">
        次数<input type="text" name="c">
        <input type="submit" value="提交">
    </form>
</body>
</html>
