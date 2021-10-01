<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>注册</h2>
    <form action="student/addStudent.do" method="post">
        姓名：<input type="text" name="name">
        年龄：<input type="text" name="age">
        <input type="submit" value="注册">
        <input type="reset" value="重置">
    </form>
    <br>
    <form action="student/findStudent.do" method="post">
        <input type="submit" value="查询所有">
    </form>
</body>
</html>
