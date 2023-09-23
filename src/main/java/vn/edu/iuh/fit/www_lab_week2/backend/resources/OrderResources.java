package vn.edu.iuh.fit.www_lab_week2.backend.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.www_lab_week2.backend.models.Order;
import vn.edu.iuh.fit.www_lab_week2.backend.services.OrderServices;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@Path("/orders")
public class OrderResources {
    private final OrderServices orderServices;
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public OrderResources() {
        orderServices = new OrderServices();
    }

    @GET
    @Produces("application/json")
    @Path("/list")
    public Response getAll(){
        List<Order> list = orderServices.getAll();
        return Response.ok(list).build();
    }

    @GET
    @Produces("application/json")
    @Path("/{id}")
    public Response getByOrderId(@PathParam("id") long id){
        Optional<Order> op = orderServices.findById(id);
        if (op.isPresent()){
            return Response.ok(op.get()).build();
        }
        return Response.ok(Response.Status.BAD_REQUEST).build();
    }


    @GET
    @Produces("application/json")
    public Response getOrdersByTimePeriod(
           @QueryParam("from") String from,
           @QueryParam("to")String to) throws Exception{
        String format = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        java.util.Date untilFrom =  simpleDateFormat.parse(from);
        java.util.Date untilTo =  simpleDateFormat.parse(to);
        Date fromDate =new Date( untilFrom.getTime());
        Date toDate =new Date( untilTo.getTime());
        List<Order> list = orderServices.getOrdersByTimePeriod(fromDate, toDate);
        if(!list.isEmpty()){
            return Response.ok(list).build();
        }
        return Response.ok(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Produces("application/json")
    @Path("/date")
    public Response getOrdersByDate(@QueryParam("date") String date) throws  Exception{
        String format = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        java.util.Date untilDate = simpleDateFormat.parse(date);
        Date date1 = new Date(untilDate.getTime());
        List<Order> orderList = orderServices.getOrdersByDate(date1);
        if(!orderList.isEmpty()){
            return Response.ok(orderList).build();
        }
        return Response.ok(Response.Status.NOT_FOUND).build();
    }


    @GET
    @Path("/employee/{empId}")
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

        List<Order> list = orderServices.getOrdersByPeriod(id,from,to);
        if(!list.isEmpty()){
            return Response.ok(list).build();
        }else{
            return  Response.ok(Response.Status.NOT_FOUND).build();
        }
    }
}
