package Gui;

import Core.HRM;
import Core.Manager;
import Core.Staff;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestLogin extends Application{
	@Override
	public void start(Stage primaryStage) {
		try {
			//Load file file giao dien ra thanh phan co vai tro layout
			Parent root = 
					FXMLLoader.load(getClass().getResource("LoginScene.fxml"));
			
			//Thêm layout vào scene
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Demo javafx with FXML");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	

	
	public static void main(String[] args) {
		Application.launch(args);
	}
}
