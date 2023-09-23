package vn.edu.iuh.fit.www_lab_week2.services;

import vn.edu.iuh.fit.www_lab_week2.enums.EmployeeStatus;
import vn.edu.iuh.fit.www_lab_week2.models.Employee;
import vn.edu.iuh.fit.www_lab_week2.models.Order;
import vn.edu.iuh.fit.www_lab_week2.reponsitories.EmployeeRepository;
import vn.edu.iuh.fit.www_lab_week2.reponsitories.OrderReponsitory;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeServices {
    private EmployeeRepository employeeRepository;
    private OrderReponsitory orderReponsitory;

    public EmployeeServices() {
        employeeRepository = new EmployeeRepository();
        orderReponsitory = new OrderReponsitory();
    }

    public void insertEmp(Employee employee) {
        employeeRepository.insertEmp(employee);
    }

    public void updateEmp(Employee employee) {
        employeeRepository.updateEmp(employee);
    }

    public boolean deleteEmp(long id) {
        Optional<Employee> op = employeeRepository.findById(id);
        if (op.isPresent()) {
            Employee employee = op.get();
            employee.setEmployeeStatus(EmployeeStatus.TERMINATED);
            return true;
        }
        return false;
    }

    public Optional<Employee> findById(long id) {
        return employeeRepository.findById(id);
    }

    public List<Employee> getAll() {
        return employeeRepository.getAllEmp();
    }

}
