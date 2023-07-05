package Core;

public class Staff extends StoreStaff {
	private String staffId;	
	
	//Các constructor
	public Staff() {
		
	}
	
	public Staff(String staffId) {
		this.staffId = staffId;
	}
	
	public Staff(String email, String matKhau) {
		this.setEmail(email);
		this.setMatKhau(matKhau);
	}
	
	public Staff(String email, String matKhau, String hoTen, String chucVu, String staffId ) {
		this.setEmail(email);
		this.setMatKhau(matKhau);
		this.setChucVu(chucVu);
		this.setHoTen(hoTen);
		this.staffId = staffId;
	}
	
	//Các phương thức get,set
	public void setStaffId(String stfId) {
		this.staffId = stfId;
	}
	
	public String getStaffId() {
		return staffId;
	}

	//Hàm kiểm tra 2 nhân viên có bị trùng không
	public boolean equals(Object obj) {
		if(obj instanceof Staff) {
			Staff stf = (Staff)obj;
			if(getStaffId().equals(stf.getStaffId())) {
				return true;
			}
		}
		return false;
	}
	

	//getEmail().equals(stf.getEmail()) == true && getMatKhau().equals(stf.getMatKhau()) == true
	public boolean equalsEmail(Object obj) {
		if(obj instanceof Staff) {
			Staff stf = (Staff)obj;
			if(getEmail().equals(stf.getEmail())) {
				return true;
			}
		}
		return false;
	}
	
	public boolean equalsCheck(Object obj) {
		if(obj instanceof Staff) {
			Staff stf = (Staff)obj;
			if((getEmail().equals(stf.getEmail()) == true) && (getMatKhau().equals(stf.getMatKhau()))) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		/*Staff test = new Staff("nnl@gmail");
		Staff test1 = new Staff("nnl@gmail");
		if(test1.equalsCheck(test)) {
			System.out.println("LoginTestSuccces");
		}
		else {
			System.out.println("Not succcess");
		}
		if(test1.equalsEmail(test)) {
			System.out.println("EmailTestSuccces");
		}
		else {
			System.out.println("Email not succcess");
		}*/
		Staff stf1 = new Staff("NNL@","123");
		System.out.println(stf1.getEmail() + stf1.getMatKhau());
	}
}
