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
1. EmployeeServices:
- Các phương thức như: insert, update, getAll, getById được gọi lại từ lớp EmployeeRepository thì có phương thức deleteEmp ta phải thực hiện khác là:
	+ Tìm nhân viên theo Id bằng  
	Optional<Employee> op = employeeRepository.findById(id);
	+ Sau đó nếu op này tồn tại thì lấy Employee ra để set lại trạng thái là 	TERMINATED rồi update lại nhân viên đó bằng phương thức update từ  	EmployeeRepository --> return true;
	+ Còn nếu không tồn tại thì trả về false
2. OrderServices
- Ngoài các phương thức đã có ở orderReponsitory thì có thêm:
  List<Order> getOrdersByDate(Date orderDate): Lấy danh sách order theo ngày
	+ Biến đổi orderDate sang LocalDateTime để có thể so sánh ngày 
	+ Lấy danh sách order 
	+ Duyệt danh sách nếu nó không rỗng thì lấy từng order ra so sánh ngày 	với ngày đã được chuyển đổi.

	+ Nếu nó thỏa điều kiện thì add vào danh sách mới rồi return về danh sách 	đó
	+ Nếu danh sách order rỗng thì return null
   List<Order> getOrdersByTimePeriod(Date from, Date to): Lấy danh sách order        	nằm trong khoảng ngày được nhập
	+ Biến đổi from và to sang LocalDateTime để có thể so sánh ngày
	+ Lấy danh sách order 
	+ Duyệt danh sách nếu nó không rỗng thì lấy từng order ra so sánh
	+ Nếu order nào không trước ngày from và không sau ngày to thì add vào 	danh sách mới
	+ Các trường hợp còn lại return null
  List<Order> getOrdersByPeriod(long empId, Date from, Date to): Lấy danh sach     	hóa đơn theo nhan viên trong khoảng ngày nào đó
	+ Lấy các hóa đơn theo id nhân viên
	+ Nếu có danh sách hóa thì tìm danh sách các hóa đơn theo khoảng ngày 	mong muốn bằng việc gọi lại hàm getOrdersByTimePeriod
	+ Nếu tìm thấy thì return về danh sách đó
	+ Nếu không return false
3. Các lớp service khác thì chỉ gọi lại các phương thức đã có trong lớp reponsitory của chính nó .......

IV. Lập REST API (tạo các lớp trong package resoure)
1. OrderResources
- Tạo 1 đường dẫn bằng việc dùng Anotation @Path("/orders") để có thể phân biệt giữa đối tượng này với đối tượng khác
- Khởi tạo lớp service tương ứng của nó cụ thể là orderServices
- Thực hiện các thao tác:
     Lấy hóa đơn theo id:Response getByOrderId(@PathParam("id") long id) 	(..../api/orders/{id})
	+ Dùng @GET để lấy dữ liêu, @Produces("application/json") để biến đổi 	thành dạng Json và @Path("/{id}") để chỉ định order muốn tìm 
	+ Dùng phương thức findById đã viết trong lớp service 
	+ Nếu tìm thấy thì trả về 1 order
	+ Nếu không tìm thầy thì Response sẽ hiên thị trạng thái BAD_REQUEST
     Lấy hóa đơn từ ngày này đến ngày kia: Response getOrdersByTimePeriod(
           @QueryParam("from") String from,
           @QueryParam("to")String to) (..../api/orders?from=...&&to=...)
	+ Chuyển đổi các chuỗi ngày thành util.Date rồi chuyển sang sql.Date 
	+ Tìm danh sách với phương thức getOrdersByTimePeriod(fromDate, toDate) 	với fromDate và toDate đã được chuyển đổi
	+ Nếu tìm thấy thì trả về danh sách dạng Json
	+ Nếu không thì trả về trạng thái NOT_FOUND


