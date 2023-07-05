package Core;


public class Manager extends StoreStaff{
	private String mgrId;
	
	//Các constructer
	public Manager() {
		
	}
	
	public Manager(String email, String matKhau) {
		this.setEmail(email);
		this.setMatKhau(matKhau);
	}
	
	public Manager(String email, String matKhau, String hoTen, String chucVu, String mgrId) {
		this.setEmail(email);
		this.setMatKhau(matKhau);
		this.setChucVu(chucVu);
		this.setHoTen(hoTen);
		this.mgrId = mgrId;
	}
	
	//Các phương thức get,set
	public String getMgrId() {
		return mgrId;
	}
	
	public void setMgrId(String mgrId) {
		this.mgrId = mgrId;
	}
	
	public Manager(String email) {
		this.setEmail(email);
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Manager) {
			Manager mgr = (Manager)obj;
			if(getMgrId().equals(mgr.getMgrId())) {
				return true;
			}
		}
		return false;
	}
	
	public boolean equalsCheck(Object obj) {
		if(obj instanceof Manager) {
			Manager mgr = (Manager)obj;
			if((getEmail().equals(mgr.getEmail())) && (getMatKhau().equals(mgr.getMatKhau()))) {
				return true;
			}
		}
		return false;
	}
	
	public boolean equalsEmail(Object obj) {
		if(obj instanceof Manager) {
			Manager mgr = (Manager)obj;
			if(getEmail().equals(mgr.getEmail())) {
				return true;
			}
		}
		return false;
	}
	
	
	
}
