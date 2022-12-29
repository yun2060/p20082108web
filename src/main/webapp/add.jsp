<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加学生信息</title>
</head>
<body>
    <form action="AddServlet" method="post">
        学号：<input type="text" id="txt20082108" name="txt20082108"><br>
        姓名：<input type="text" id="txthusuyun" name="txthusuyun"><br>
        院系：<input type="text" id="txtschool" name="txtschool"><br>
        专业：<input type="text" id="txtmajor" name="txtmajor"><br>
        感染时间：<input type="date" id="startdate" name="startdate"><br>
        治愈时间：<input type="date" id="enddate" name="enddate"><br>
        症状描述：<textarea cols="20" rows="5" id="txtSymptom" name="txtSymptom"></textarea>
        <input type="submit" value="btnSubmit"><br>
    </form>
</body>
</html>
