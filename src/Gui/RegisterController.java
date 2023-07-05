package Gui;

import java.io.IOException;
import java.util.Random;

import Core.AuthenticationService;
import Core.AuthenticationServiceImpl;
import Core.HRM;
import Core.Manager;
import Core.Staff;
import Core.StoreStaff;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegisterController {
	@FXML
	private TextField nameTextfieldRegister;
	@FXML
	private TextField usernameTextfieldRegister;
	@FXML
	private PasswordField passwordTextfieldRegister;
	@FXML
	private PasswordField repeatPasswordFieldRegister;
	@FXML
	private Label repeatPasswordFieldMessage;
	@FXML
	private Label messageRegister;
	@FXML
	private Label goToHomeSceneQuestion;
	@FXML
	private Label unfilledName;
	@FXML
	private Label unfilledEmail;
	@FXML
	private Label unfilledPass;
	@FXML
	private Label unfilledRepeatPassword;
	@FXML
	private Button registerBtn;
	@FXML
	private Button goToHomeBtn;
	
	public void onClickRegisterButton(ActionEvent event) {
		if(validateForm()) {
			HRM hrl = new HRM();
			//Kiểm tra email có tồn tài chưa
			String userEmail = usernameTextfieldRegister.getText();
			Staff stf1 = new Staff(userEmail,"");
			//Nếu đã tồn tại
			if(hrl.checkHRM2(stf1)) {
				unfilledEmail.setText("Email đã tồn tại!");
			}
			//Nếu chưa tồn tại
			else {
				hrl.addStaff(new Staff(usernameTextfieldRegister.getText(),passwordTextfieldRegister.getText(),
						nameTextfieldRegister.getText(),"Nhân viên",randomizeStaffId()));
				messageRegister.setText("Đăng ký thành công!");
				registerBtn.setDisable(true);
				goToHomeBtn.setDisable(false);
				goToHomeSceneQuestion.setText("Bạn muốn đăng nhập?");
			}
		
		}
	}
	
	//Phương thức chuyển về màn hình đăng nhập
	public void onClickGoToHomeBtn(ActionEvent event) {
			
			//Ẩn trang đăng ký
			Scene scn = nameTextfieldRegister.getScene();
			scn.getWindow().hide();
			goToHomeScene(1);
			
	}
	
	//Phương thức tạo ngẫu nhiên 1 mã nhân viên
	static String randomizeStaffId() {
		String result = "";
        //Vòng lặp in ra 5 số ngẫu nhiên
        for (int i=0; i<5; i++) {
            Random rand = new Random();
            int ranNum = rand.nextInt(100)+1;
            String newString = "STF" + ranNum;
            Staff stf = new Staff(newString);
            HRM hrl = new HRM();
            if(hrl.checkHRM1(stf)==false) {
            	result = newString;
            }
        }
        return result;
    }
	
	//Kiểm tra tính hợp lệ của các textfield trong form
	public boolean validateForm() {
		boolean result = true;
		
		resetMessage();
		
		if("".contentEquals( nameTextfieldRegister.getText())) {
			unfilledName.setText("Chưa nhập họ tên!");
			result = false;
		}
		
		if("".contentEquals( usernameTextfieldRegister.getText())) {
			unfilledEmail.setText("Chưa nhập email!");
			result = false;
		}
		
		if("".contentEquals( passwordTextfieldRegister.getText())) {
			unfilledPass.setText("Chưa nhập mật khẩu!");
			result = false;
		}
		
		if("".contentEquals(repeatPasswordFieldRegister.getText())) {
			unfilledRepeatPassword.setText("Chưa nhập lại mật khẩu!");
			result = false;
		}
		
		
		return result;
	}
	//Reset các nhãn message ân trên form
	public void resetMessage() {
		unfilledName.setText("");
		unfilledEmail.setText("");
		unfilledPass.setText("");
		unfilledRepeatPassword.setText("");		
	}
	
	public void goToHomeScene(int role) {
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








