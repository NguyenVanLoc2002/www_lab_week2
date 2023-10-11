function addToCart(productId, productName, productPrice) {
    var cart = JSON.parse(localStorage.getItem("cart")) || [];
    var quantity = parseInt(document.getElementById("quantity-" + productId).value);
    if (quantity > 0) {
        var item = {
            id: productId,
            name: productName,
            price: productPrice,
            quantity: quantity
        };
        cart.push(item);
        // updateCart();
        // Lưu lại giỏ hàng vào Local Storage
        localStorage.setItem("cart", JSON.stringify(cart));
    }
}


function goToPayment() {
    window.location.href = "payMent.jsp";
}

// function convertToISO8601(timeString) {
//     const isoString = moment(timeString, 'dd-MM-yyyy, h:mm:ss A').format();
//     return isoString;
// }


function goToShowChart(arrPrice, arrTime) {
    localStorage.removeItem("chartPriceData");
    localStorage.setItem("chartPriceData",JSON.stringify( {prices: arrPrice, times: arrTime}));
    window.location.href = "showChartPrice.jsp";
}

