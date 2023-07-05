package Core;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StoreStaff {
	private String hoTen;
	private Date ngaySinh;
	private String chucVu;
	private String email;
	private String matKhau;
	
	
	//Các constructor
	public StoreStaff() {
		
	}
	
	public StoreStaff(String email, String matKhau) {
		this.email = email;
		this.matKhau = matKhau;
	}
	
	
	
	public StoreStaff(String email) {
		this.email = email;
	}
	
	//Các phương thức get,set
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	
	public String getMatKhau() {
		return matKhau;
	}

	public String getChucVu() {
		return chucVu;
	}

	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	
	public boolean equalsEmail(Object obj) {
		return super.equals(obj);
	}



	public boolean equalsLogin(StoreStaff storeStaff) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean equalsCheck(StoreStaff storeStaff) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
