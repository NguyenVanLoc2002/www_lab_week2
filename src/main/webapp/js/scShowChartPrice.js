function showChart(arrPrice, arrTime) {
    var prices = arrPrice;
    var timeLabels = arrTime;

// Lấy tham chiếu đến phần tử canvas
    var ctx = document.getElementById("priceChart").getContext("2d");

// Tạo biểu đồ sử dụng Chart.js
    var myChart = new Chart(ctx, {
        type: "line",
        data: {
            labels: timeLabels,
            datasets: [
                {
                    label: "Giá",
                    data: prices,
                    fill: false,
                    borderColor: "blue",
                    borderWidth: 2
                }
            ]
        },
        options: {
            responsive: true,
            maintainAspectRatio: false,
            scales: {
                x: {
                    title: {
                        display: true,
                        text: "Thời gian"
                    }
                },
                y: {
                    title: {
                        display: true,
                        text: "Giá"
                    }
                }
            }
        }
    });
}

// showChart([100.0,100.0,110.0,210.0], ["Sep 22, 2023, 10:00:00 AM","Sep 22, 2023, 2:00:00 PM","Sep 23, 2023, 11:00:00 AM","Sep 24, 2023, 4:00:00 PM"]);

var chartData = JSON.parse(localStorage.getItem("chartPriceData"));

if (chartData) {
    // Dữ liệu đã lưu trong localStorage
    var prices = chartData.prices;
    var times = chartData.times;
    // Sử dụng dữ liệu để hiển thị biểu đồ
    showChart(prices, times);
    console.log(prices);
    console.log(times);
} else {
    console.error("không có dữ liệu")
}



