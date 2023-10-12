# www_lab_week2
//Nguyễn Văn Lộc
Phần cấu hình:
- Tạo 1 file persistence.xml thiết kế kết nối JDBC để thao tác với CSDL

PHẦN BACKEND:
I)Tạo các lớp models(entity) và thiết lập các mối quan hệ như đề yêu cầu:
Ví dụ: Tạo bảng Employee 
- Dùng Các Anotation như 
@Entity
@Table(name = "employee")
để tạo bảng 
- Khai báo các biến có trong lớp Employee và dùng các Anotation tương ứng:
	+ Đối với biến có dạng Enum cụ thể là EmployeeStatus thì nên dùng
	 @Enumerated(EnumType.ORDINAL) để Ánh xạ enum thành giá trị số nguyên (1, 0, -1) vào 	 CSDl
- Dùng Anotation để liên kết bảng với bảng Order thể hiện mối quan hệ 1 nhiều:
 	+ Bên lớp Employee:
  		@OneToMany(mappedBy = "employee") ---> với employee là biến được khai báo bên 			Order
    		private List<Order> orderList; 
 	+ Bên lớp Order:
    		@ManyToOne
   	 	@JoinColumn(name = "emp_id")
    	private Employee employee; 
===> Tạo các bảng khác cũng tương tự 
*** Tạo các lớp convert như EmployeeStatusConverter để có thể tự động chuyển đổi dữ liệu khi bất kì phương thức nào gọi EmployeeStatus chuyển đổi thành integer để lưu vào CSDL và ngược lại.

II)Tạo các lớp repositories
Ví dụ tạo EmployeeReponsitory
- Tạo kết nối đến CSDL bằng EntityManager thông qua file cấu hình persistence.xml đã được đặt tên
- Thực hiện phiên làm việc bằng cách khởi tạo EntityTransaction;
- Thực hiện các thao tác CRUD đơn giản như insert,update, getById, getAll,...

III)Tạo các lớp services thực hiện các thao tác phức tạp xử lý logic để tương tác trực tiếp với phần frontend


