// Sử dụng JavaScript để hiển thị thông tin sản phẩm và tính toán tổng tiền từ Local Storage
var cart = JSON.parse(localStorage.getItem("cart")) || [];

// Hiển thị thông tin sản phẩm và tính toán tổng tiền
var cartDiv = document.getElementById("cart");
var total = 0;

for (var i = 0; i < cart.length; i++) {
    var item = cart[i];
    cartDiv.innerHTML += "<p>" + item.name + " - $" + item.price + " x " + item.quantity + "</p>";
    total += parseFloat(item.price) * item.quantity;
}

cartDiv.innerHTML += "<p><strong>Tổng tiền: $" + total + "</strong></p>";

function deleteCart(){
    localStorage.removeItem('cart');
}

