package vn.edu.iuh.fit.www_lab_week2.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.www_lab_week2.models.Employee;
import vn.edu.iuh.fit.www_lab_week2.models.Order;
import vn.edu.iuh.fit.www_lab_week2.services.EmployeeServices;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
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

    @GET
    @Path("/orders/{empId}")
    @Produces("application/json")
    public Response getOrdersByPeriod(@PathParam("empId") long id,
                                      @QueryParam("from") String fromDate,
                                      @QueryParam("to") String toDate) throws  Exception{
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);

        // Chuyển đổi chuỗi thành đối tượng java.util.Date
        java.util.Date fromDateUtil = dateFormat.parse(fromDate);
        java.util.Date toDateUtil = dateFormat.parse(toDate);
        // Chuyển đổi chuỗi thành đối tượng Date
        Date from = new Date(fromDateUtil.getTime());
        Date to = new Date(toDateUtil.getTime());

        List<Order> list = employeeServices.getOrdersByPeriod(id,from,to);
        if(!list.isEmpty()){
            return Response.ok(list).build();
        }else{
            return  Response.ok(Response.Status.NOT_FOUND).build();
        }
    }
}