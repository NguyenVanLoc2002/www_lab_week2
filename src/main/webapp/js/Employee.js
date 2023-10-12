function deleteEmployee(employeeId) {
    if(confirm("Bạn có chắc chắn muốn xóa nhân viên?")){
        var xhr = new XMLHttpRequest();
        xhr.open("DELETE", "controllers?action=deleteEmp&id="+employeeId, true);
        xhr.onreadystatechange=function (){
            if(xhr.readyState===4 && xhr.status===200){//// Xóa thành công, cập nhật trang hoặc thông báo
                location.reload();// Tải lại trang
            }
        };
        xhr.send();
    }
}

