<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 28/09/2023
  Time: 4:46 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Insert Employee</title>
</head>
<body>
<form action="controllers?action=insert_Emp" method="post" accept-charset="UTF-8">
    Name: <input name="name"></br>
    Day of birth:<input type="date" name="dob"></br>
    Email: <input name="email"></br>
    Phone: <input type="number" name="phone"></br>
    Address: <input name="address"></br>
    Status:</br>
    <input type="radio" name="status" value="ACTIVE">ACTIVE<br>
    <input type="radio" name="status" value="NO_ACTIVE">NO_ACTIVE<br>
    <input type="radio" name="status" value="TERMINATED">TERMINATED<br>
    <input type="submit" value="Submit">
    <input type="reset" value="Reset">
</form>
</body>
</html>
