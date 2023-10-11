<%@ page import="vn.edu.iuh.fit.www_lab_week2.backend.models.ProductPrice" %>
<%@ page import="vn.edu.iuh.fit.www_lab_week2.backend.services.ProductPriceServices" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.time.ZoneId" %><%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 30/09/2023
  Time: 12:43 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%--<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/4.4.0/chart.min.js"></script>--%>
<head>
    <title>Biểu đồ giá theo thời gian</title>
</head>
<body>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.7.0/chart.min.js"></script>
<canvas id="priceChart" width="400" height="200"></canvas>
<script src="js/scShowChartPrice.js"></script>

</body>
</html>
