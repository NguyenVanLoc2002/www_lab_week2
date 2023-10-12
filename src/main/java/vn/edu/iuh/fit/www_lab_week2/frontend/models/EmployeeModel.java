package vn.edu.iuh.fit.www_lab_week2.frontend.models;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.commons.logging.Log;
import vn.edu.iuh.fit.www_lab_week2.backend.enums.EmployeeStatus;
import vn.edu.iuh.fit.www_lab_week2.backend.models.Employee;
import vn.edu.iuh.fit.www_lab_week2.backend.services.EmployeeServices;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class EmployeeModel {
    private EmployeeServices employeeServices;

    public EmployeeModel() {
        employeeServices = new EmployeeServices();
    }


    public boolean deleteEMp(long id) {
        return employeeServices.deleteEmp(id);
    }

    public List<Employee> getAllEmp() {
        return employeeServices.getAll();
    }

    public Optional<Employee> findById(long id) {
        return employeeServices.findById(id);
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


    public void updateEmp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        long id = Long.parseLong(req.getParameter("id"));
        Optional<Employee> employee = employeeServices.findById(id);
        if(employee.isPresent()) {

            String name = req.getParameter("name");
            LocalDate dob = LocalDate.parse(req.getParameter("dob"));
            String email = req.getParameter("email");
            String phone = req.getParameter("phone");
            String address = req.getParameter("address");
            EmployeeStatus status = EmployeeStatus.valueOf(req.getParameter("status"));
            Employee employeeToUpdate = employee.get();
            employeeToUpdate.setName(name);
            employeeToUpdate.setEmail(email);
            employeeToUpdate.setPhone(phone);
            employeeToUpdate.setAddress(address);
            employeeToUpdate.setEmployeeStatus(status);
            employeeServices.updateEmp(employeeToUpdate);
            resp.sendRedirect("ListEmployee.jsp");
        }
    }
}
