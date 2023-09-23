<%@ page import="vn.edu.iuh.fit.www_lab_week2.backend.services.EmployeeServices" %>
<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.www_lab_week2.backend.models.Employee" %><%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 9/23/2023
  Time: 10:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Employee</title>
</head>
<body>
<%
    EmployeeServices employeeServices = new EmployeeServices();
    List<Employee> employeeList = employeeServices.getAll();
%>
<table>
    <tr>
        <th>ID</th>
        <th>NAME</th>
        <th>PHONE</th>
        <th>ADDRESS</th>
        <th>EMAIL</th>
        <th>DOB</th>
        <th>STATUS</th>
    </tr>
    <%
        for (Employee employee : employeeList) {
    %>
    <tr>
        <td><%employee.getId()%></td>
    </tr>
    <%}%>
</table>
</body>
</html>
