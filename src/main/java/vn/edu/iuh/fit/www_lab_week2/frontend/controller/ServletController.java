package vn.edu.iuh.fit.www_lab_week2.frontend.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.Path;
import vn.edu.iuh.fit.www_lab_week2.frontend.models.EmployeeModel;

import java.io.IOException;

@WebServlet(urlPatterns = {"/controllers"})
public class ServletController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action.equals("employee_List")) {
            resp.sendRedirect("ListEmployee.jsp");
        }else if(action.equals("show_Product")){
            resp.sendRedirect("showProduct.jsp");
        }else if(action.equals("show_chart")){
            resp.sendRedirect("showChartPrice.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action.equals("insert_Emp")) {
            EmployeeModel employeeModel = new EmployeeModel();
            employeeModel.insertEmp(req,resp);
        }
    }
}
