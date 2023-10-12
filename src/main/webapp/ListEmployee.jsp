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
<script src="js/Employee.js"></script>
<table>
    <tr>
        <th>ID</th>
        <th>NAME</th>
        <th>DOB</th>
        <th>PHONE</th>
        <th>ADDRESS</th>
        <th>EMAIL</th>
        <th>STATUS</th>
        <th><a href="insertEmployee.jsp">INSERT</a></th>
    </tr>
    <%
        for (Employee employee : employeeList) {
    %>
    <tr>
        <td><%=employee.getId()%>
        </td>
        <td><%=employee.getName()%>
        </td>
        <td><%=employee.getDob()%>
        </td>
        <td><%=employee.getPhone()%>
        </td>
        <td><%=employee.getAddress()%>
        </td>
        <td><%=employee.getEmail()%>
        </td>
        <td><%=employee.getEmployeeStatus()%>
        </td>
        <td><a href="updateEmployee.jsp?id=<%=employee.getId()%>">UPDATE</a> <br>
            <a href="javascript:void(0);" onclick="deleteEmployee(<%=employee.getId()%>)">DELETE</a></td>
    </tr>
    <%}%>
</table>
</body>
</html>
