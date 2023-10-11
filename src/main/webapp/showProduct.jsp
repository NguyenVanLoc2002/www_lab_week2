<%@ page import="vn.edu.iuh.fit.www_lab_week2.backend.services.ProductServices" %>
<%@ page import="vn.edu.iuh.fit.www_lab_week2.backend.models.Product" %>
<%@ page import="vn.edu.iuh.fit.www_lab_week2.backend.models.ProductImage" %>
<%@ page import="vn.edu.iuh.fit.www_lab_week2.backend.services.ProductImageServices" %>
<%@ page import="vn.edu.iuh.fit.www_lab_week2.backend.enums.ProductStatus" %>
<%@ page import="vn.edu.iuh.fit.www_lab_week2.backend.enums.EmployeeStatus" %>
<%@ page import="vn.edu.iuh.fit.www_lab_week2.backend.services.ProductPriceServices" %>
<%@ page import="vn.edu.iuh.fit.www_lab_week2.backend.models.ProductPrice" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="com.google.gson.Gson" %>
<%@ page import="com.google.gson.GsonBuilder" %>
<%@ page import="java.time.ZoneId" %>
<%@ page import="java.util.*" %>
<%@ page import="java.lang.reflect.Array" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 29/09/2023
  Time: 3:32 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Hiển thị sản phẩm</title>
    <link rel="stylesheet" type="text/css" href="css/styleShowProduct.css">
</head>
<body>

<script src="js/scShowProduct.js"></script>


<button type="submit" class="giohang" onclick="goToPayment()" style="right: 10px">Giỏ hàng</button>
<div class="container">
    <%
        ProductServices productServices = new ProductServices();
        List<Product> productList = productServices.getAll();
        if (productList != null && !productList.isEmpty()) {
            for (Product product : productList) {
    %>
    <div class="product">
        <div class="product_images">
            <%
                ProductImageServices productImageServices = new ProductImageServices();
                List<ProductImage> productImageList = productImageServices.findProductImageByProductId(product.getId());
                for (ProductImage productImage : productImageList) {
            %>
            <img class="product_image" src="<%=productImage.getPath()%>" alt="<%=product.getName()%>">
            <%
                }
            %>
        </div>
        <div class="product-details">
            <p><strong>Tên sản phẩm: </strong> <%=product.getName()%>
            </p>

            <p><strong>Tên nhà sản xuất: </strong> <%=product.getManufacturer_name()%>
            </p>

            <p><strong>Tên đơn vị: </strong> <%=product.getUnit()%>
            </p>

            <p><strong>Mô tả: </strong> <%=product.getDescription()%>
            </p>

            <%
                ProductPriceServices productPriceServices = new ProductPriceServices();
                double price = productPriceServices.getPriceByProductId(product.getId());

            %>
            <p><strong>Giá: </strong> <%=price%>
            </p>

            <div id="cart">
                <input type="number" id="quantity-<%=product.getId()%>" value="1" min="1">
                <input type="button" value="Thêm giỏ hàng"
                       onclick="addToCart('<%=product.getId()%>', '<%=product.getName()%>', '<%=price%>')">
            </div>
            <br>
            <div class="chartprice">
                <%
                    List<ProductPrice> priceList = productPriceServices.getListPriceByProductId(product.getId());
                    List<Double> lstPrice = new ArrayList<>();
                    List<Date> lstTime = new ArrayList<>();
                    if(!priceList.isEmpty()){
                        for (ProductPrice prPrice: priceList) {
                            double pri = prPrice.getPrice();
                            lstPrice.add(pri);
                            LocalDateTime time = prPrice.getPrice_date_time();
                            Date date = Date.from(time.atZone(ZoneId.systemDefault()).toInstant());
                            lstTime.add(date);
                        }
                    }
                    String p = new Gson().toJson(lstPrice);
                    String t = new Gson().toJson(lstTime);
                %>
                <input type="button" value="Biểu đồ giá" onclick='goToShowChart(<%=p%>,<%=t%>)'>
            </div>

        </div>
    </div>
    <%
            }
        }
    %>
</div>
</body>
</html>
