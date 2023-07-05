package Core;

public class AuthenticationServiceImpl implements AuthenticationService{
	public boolean login(StoreStaff user) {
		HRM hr = new HRM();
		if(hr.checkHRM2(user)) {
			return true;
		}
		return false;
	}
}




