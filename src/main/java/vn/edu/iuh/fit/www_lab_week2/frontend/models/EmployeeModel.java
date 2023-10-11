package vn.edu.iuh.fit.www_lab_week2.frontend.models;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.edu.iuh.fit.www_lab_week2.backend.enums.EmployeeStatus;
import vn.edu.iuh.fit.www_lab_week2.backend.models.Employee;
import vn.edu.iuh.fit.www_lab_week2.backend.services.EmployeeServices;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class EmployeeModel {
    private EmployeeServices employeeServices;

    public EmployeeModel() {
        employeeServices = new EmployeeServices();
    }



    public void updateEmp(Employee employee) {
        employeeServices.updateEmp(employee);
    }

    public boolean deleteEMp(long id) {
        return employeeServices.deleteEmp(id);
    }

    public List<Employee> getAllEmp() {
        return employeeServices.getAll();
    }

    public void insertEmp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String name = req.getParameter("name");
        LocalDate dob = LocalDate.parse(req.getParameter("dob"));
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String address= req.getParameter("address");
        EmployeeStatus status = EmployeeStatus.valueOf(req.getParameter("status"));
        Employee employee = new Employee(name, dob, email,phone,address,status);
        employeeServices.insertEmp(employee);
        resp.sendRedirect("ListEmployee.jsp");
    }
}
