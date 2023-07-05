package Core;

import java.util.ArrayList;
import java.util.List;

public class HRM {
	private List<StoreStaff> hrl = new ArrayList<StoreStaff>();
	
	public HRM() {
		Staff stf1 = new Staff("nnl751@gmail.com","2022vnua","Nguyễn Ngọc Long","Nhân viên","A268");
		Staff stf2 = new Staff("nhd123@gmail.com","0905vnua","Nguyễn Huyền Diệp","Nhân viên","B754");
		Staff stf3 = new Staff("nqa0202@sv.vnua.edu.vn","22432002Quang","Nguyễn Quang Anh","Nhân viên","A963");
		Manager mgr1 = new Manager("tthquynh2021@gmail.com","quynhQuynh1","Trần Thị Hương Quỳnh","Quản lý","MGR.Q");
		Manager mgr2 = new Manager("ptvanh777@gmail.com","11A13", "Phạm Thị Vân Anh","Quản lý trưởng","MGRM.A");
		this.addStaff(stf1);
		this.addStaff(stf2);
		this.addStaff(stf3);
		this.addStaff(mgr1);
		this.addStaff(mgr2);
	}
	
	
	
	//Phương thức kiểm tra login
	public boolean checkHRM(StoreStaff stf) {
		for (StoreStaff storeStaff : hrl) {
			if(stf.equalsCheck(storeStaff)) {
				return true;
			}
		}
		return false;
	}
	
	//Phương thức kiểm tra có trùng mã nhân viên
	public boolean checkHRM1(StoreStaff stf) {
		for (StoreStaff storeStaff : hrl) {
			if(stf.equals(storeStaff)) {
				return true;
			}
		}
		return false;
	}
	
	//Phương thức kiểm tra có trùng email
	public boolean checkHRM2(StoreStaff stf) {
		for (StoreStaff storeStaff : hrl) {
			if(stf.equalsEmail(storeStaff)) {
				return true;
			}
		}
		return false;
	}
	
	public void equalsEmail() {
		
	}
	
	public void equalsCheck() {
		
	}
	
	public void addStaff(StoreStaff stf) {
		hrl.add(stf);
	}
	
	public List<StoreStaff> getHRList(){
		return hrl;
	}
}
