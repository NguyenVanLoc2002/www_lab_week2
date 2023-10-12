<%@ page import="vn.edu.iuh.fit.www_lab_week2.frontend.models.EmployeeModel" %>
<%@ page import="vn.edu.iuh.fit.www_lab_week2.backend.models.Employee" %>
<%@ page import="java.util.Optional" %>
<%@ page import="vn.edu.iuh.fit.www_lab_week2.backend.enums.EmployeeStatus" %><%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 12/10/2023
  Time: 3:41 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CẬP NHẬT NHÂN VIÊN</title>
</head>
<body>
<%
    long id = Long.parseLong(request.getParameter("id"));
    EmployeeModel employeeModel = new EmployeeModel();
    Optional<Employee> employee = employeeModel.findById(id);
    if (employee.isPresent()){
        Employee employeeToEdit = employee.get();

%>
<form action="controllers?action=updateEmp" method="post" accept-charset="UTF-8">
    <input type="hidden" name="id" value="<%=employeeToEdit.getId()%>">
    Name: <input name="name" value="<%=employeeToEdit.getName()%>"></br>
    Day of birth:<input type="date" name="dob" value="<%=employeeToEdit.getDob()%>"></br>
    Email: <input name="email" value="<%=employeeToEdit.getEmail()%>"></br>
    Phone: <input type="number" name="phone" value="<%=employeeToEdit.getPhone()%>"></br>
    Address: <input name="address" value="<%=employeeToEdit.getAddress()%>"></br>
    Status:</br>
    <input type="radio" name="status" value="ACTIVE" <%= employeeToEdit.getEmployeeStatus() == EmployeeStatus.ACTIVE ? "checked" : "" %>>ACTIVE<br>
    <input type="radio" name="status" value="NO_ACTIVE"  <%= employeeToEdit.getEmployeeStatus() == EmployeeStatus.NO_ACTIVE ? "checked" : "" %>  >NO_ACTIVE<br>
    <input type="radio" name="status" value="TERMINATED" <%= employeeToEdit.getEmployeeStatus() == EmployeeStatus.TERMINATED ? "checked" : "" %>  >TERMINATED<br>
    <input type="submit" value="Lưu">
    <input type="reset" value="Reset">
</form>
<%
    }else{
%>

<%
    }
%>
</body>
</html>
