package vn.edu.iuh.fit.www_lab_week2.frontend.models;

import vn.edu.iuh.fit.www_lab_week2.backend.models.Employee;
import vn.edu.iuh.fit.www_lab_week2.backend.services.EmployeeServices;

import java.util.List;

public class EmployeeModels {
    private EmployeeServices employeeServices;

    public EmployeeModels() {
        employeeServices = new EmployeeServices();
    }

    public void insertEmp(Employee employee){
        employeeServices.insertEmp(employee);
    }

    public void updateEmp(Employee employee){
         employeeServices.updateEmp(employee);
    }

    public boolean deleteEMp(long id){
        return employeeServices.deleteEmp(id);
    }

    public List<Employee> getAllEmp(){
        return employeeServices.getAll();
    }
}
