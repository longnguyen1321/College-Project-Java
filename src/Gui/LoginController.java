package Gui;

import java.util.Scanner;

import Core.AuthenticationService;
import Core.AuthenticationServiceImpl;
import Core.HRM;
import Core.Manager;
import Core.Staff;
import Core.StoreStaff;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class LoginController {
	@FXML
	private Label messageLogin;
	@FXML
	private Label unfilledUser;
	@FXML
	private Label unfilledPass;
	@FXML
	private ToggleGroup group;
	@FXML
	private RadioButton mgrRadio;
	@FXML
	private RadioButton staffRadio;
	@FXML
	private TextField userTextfieldLogin;
	@FXML
	private TextField passwordTextfieldLogin;
	
	// Tạo đối tượng dịch vụ xác thực
	private AuthenticationService authService = new AuthenticationServiceImpl();
	
	//Xử lí sự kiện đăng nhập
	public void onClickLoginButton(ActionEvent event) {
		//Nếu đã nhập đầy đủ thông tin
		
		if(/*validateFormLogin()*/true) {
			StoreStaff staff;
			//Tài khoản là nhân viên
			if(group.getSelectedToggle().equals(staffRadio)) {
				staff = new Staff(userTextfieldLogin.getText(),passwordTextfieldLogin.getText());
			}
			else {
				staff = new Manager(userTextfieldLogin.getText(),passwordTextfieldLogin.getText());
			}
			
			//Nếu login thành công
			if (authService.login(staff)) {
				// Lấy về lựa chọn hiện tại và quy ước quyền quản lý (role = 0), nhân1 viên (role = 1)
				int role = group.getSelectedToggle().equals(staffRadio) ? 0 : 1;

				// Ẩn trang đăng nhập
				Scene scn = userTextfieldLogin.getScene();
				scn.getWindow().hide();

				// truyền role vào trang chủ
				showHomeGUI(role);
			} else { // Nếu đăng nhập ko thành công, gán lỗi vào trường ẩn
				messageLogin.setText("Nhập sai thông tin tài khoản hoặc mật khẩu!");
				}
		}
	}	
	
	//Xử lí sự kiện bấm nút đăng ký tài khoản nhân viên
	public void onClickRegisterLoginButton(ActionEvent event) {

		try {
			// Tạo FXMLLoader tương ứng HomeScene.fxml
			FXMLLoader fxmlLoader = new
			FXMLLoader(getClass().getResource("Register.fxml"));
			// Lấy về đối tượng root layout
			Parent root = (Parent)fxmlLoader.load();
	
			// Tạo Stage, Scene từ root
			Stage homeStage = new Stage();
			homeStage.setTitle("RegisterScene");
			homeStage.setScene(new Scene(root));
			homeStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//Kiểm tra các form
	public boolean validateFormLogin() {
		boolean result = true;
		
		resetMessage();
		
		/*if("".equals(userTextfieldLogin.getText())) {
			unfilledUser.setText("Chưa nhập tài khoản!");
			result = false;
		}
		
		if("".equals(passwordTextfieldLogin.getText())) {
			unfilledPass.setText("Chưa nhập mật khẩu!");
			result = false;
		}*/
		
		return result;
	}
	
	//Reset các message
	public void resetMessage() {
		userTextfieldLogin.setText("");
		 passwordTextfieldLogin.setText("");
		 messageLogin.setText("");
		}
	
	
	public void showHomeGUI(int role) {
		try {
			// Tạo FXMLLoader tương ứng HomeScene.fxml
			FXMLLoader fxmlLoader = new
			FXMLLoader(getClass().getResource("HomeScene.fxml"));
			// Lấy về đối tượng root layout
			Parent root = (Parent)fxmlLoader.load();
			// Lấy về đối tượng HomeController từ fxmlLoader
			HomeController controller = fxmlLoader.getController();
			// Truyền dữ liệu vào đối tượng controller
			// Lớp HomeController cần khai báo thêm 2 thuộc tính role,username và phương thức get, set tương ứng
			controller.setRole(role);
			// Tạo Stage, Scene từ root
			Stage homeStage = new Stage();
			homeStage.setTitle("Home");
			homeStage.setScene(new Scene(root));
			homeStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
