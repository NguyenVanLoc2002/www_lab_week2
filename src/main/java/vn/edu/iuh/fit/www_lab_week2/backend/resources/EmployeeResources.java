package vn.edu.iuh.fit.www_lab_week2.backend.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.www_lab_week2.backend.models.Employee;
import vn.edu.iuh.fit.www_lab_week2.backend.services.EmployeeServices;

import java.util.List;
import java.util.Optional;

@Path("/employees")
public class EmployeeResources {
    private final EmployeeServices employeeServices;
    private final Logger  logger= LoggerFactory.getLogger(this.getClass().getName());

    public EmployeeResources() {
        employeeServices = new EmployeeServices();
    }

    @GET
    @Produces("application/json")
    public Response getAlll() {
        List< Employee> employeeList = employeeServices.getAll();
        return Response.ok(employeeList).build();
    }

    @GET
    @Produces("application/json")
    @Path("/{id}")
    public Response getEmp(@PathParam("id") long eid) {
        Optional<Employee> empOpt = employeeServices.findById(eid);
        if (empOpt.isPresent()) {
            return Response.ok(empOpt.get()).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

}