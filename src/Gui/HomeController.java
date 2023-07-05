package Gui;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;

import Core.Console;
import Core.ConsoleManage;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class HomeController {
	@FXML
	private TableView<Console> table = new TableView<Console>();
	@FXML
	private Label actionMessage;
	@FXML
	private Label addStockCondition;
	@FXML
	private Label addDayCondition;
	@FXML
	private Button onClickAdd;
	@FXML
	private Button onClickDelete;
	@FXML
	private Button onClickUpdate;
	@FXML
	private Button onClickChange;
	@FXML
	private TextField consoleNameTF;
	@FXML
	private TextField consoleIdTF;
	@FXML
	private TextField consoleBrandTF;
	@FXML
	private TextField consolePriceTF;
	@FXML
	private TextField consoleInStockTF;
	@FXML
	private TextField consoleStatusTF;
	private int role;
	
	//Các constructer
	
	
	//Các phương thức get, set
	public void setRole(int role) {
		this.role = role;
	}
	
	public int getRole() {
		return role;
	}
	
	ConsoleManage csMN = new ConsoleManage();
	
	//Khởi tạo bảng
	@SuppressWarnings("unchecked")
	@FXML
	public void initialize() {
		Platform.runLater(() -> {
			TableColumn<Console, String> idColumn =
					(TableColumn<Console, String>) table.getVisibleLeafColumn(0);		
			idColumn.setCellValueFactory(new PropertyValueFactory<Console, String>("productId"));

			
			TableColumn<Console, String> nameColumn =
					(TableColumn<Console, String>) table.getVisibleLeafColumn(1);		
			nameColumn.setCellValueFactory(new PropertyValueFactory<Console, String>("name"));

			TableColumn<Console, String> brandColumn =
					(TableColumn<Console, String>) table.getVisibleLeafColumn(2);
			brandColumn.setCellValueFactory(new	PropertyValueFactory<Console, String>("brand"));

			TableColumn<Console, String> priceColumn =
					(TableColumn<Console, String>) table.getVisibleLeafColumn(3);
			priceColumn.setCellValueFactory(new PropertyValueFactory<Console, String>("price"));
			
			TableColumn<Console, String> statusColumn =
					(TableColumn<Console, String>) table.getVisibleLeafColumn(4);
			statusColumn.setCellValueFactory(new PropertyValueFactory<Console, String>("status"));
			
			TableColumn<Console, Integer> intStockColumn =
					(TableColumn<Console, Integer>) table.getVisibleLeafColumn(5);
			intStockColumn.setCellValueFactory(new PropertyValueFactory<Console, Integer>("inStock"));

			List<Console> consoleList = csMN.getConsoleList();
			ObservableList<Console> obsConsoleList = FXCollections.observableArrayList(consoleList);
			table.setItems(obsConsoleList);
			
			if (role == 1) { // Nếu là nhân viên -> disable nút delete và add
				onClickDelete.setDisable(true);
				onClickAdd.setDisable(true);
			}
		});
	}
	
	//Xử lí sự kiện add
	@SuppressWarnings("unchecked")
	public void onClickAdd() {
		int num = Integer.parseInt(consoleInStockTF.getText());
		Console cs = new Console(consoleIdTF.getText(),consoleNameTF.getText(),consoleBrandTF.getText(),consolePriceTF.getText(),consoleStatusTF.getText(),num);
		boolean addResult = csMN.addConsole(cs);
		if(addResult) {
			table.getItems().add(cs);
			System.out.println("Thêm thành công!");
			actionMessage.setText("Thêm thành công!");
			List<Console> consoleList = csMN.getConsoleList();
			ObservableList<Console> obsConsoleList = FXCollections.observableArrayList(consoleList);
			table.setItems(obsConsoleList);
			
		}
		else {
			System.out.println("Thêm không thành công!");
			actionMessage.setText("Thêm không thành công!");
			List<Console> consoleList = csMN.getConsoleList();
			ObservableList<Console> obsConsoleList = FXCollections.observableArrayList(consoleList);
			table.setItems(obsConsoleList);
		}
	}
	
	//Xử lý sự kiện update
	@SuppressWarnings("unchecked")
	public void onClickUpdate() {
		int selectedIndex = table.getSelectionModel().getSelectedIndex();
		Console selectedConsole = table.getItems().get(selectedIndex);
		selectedConsole.setProductId(consoleIdTF.getText());
		selectedConsole.setName(consoleNameTF.getText());
		selectedConsole.setBrand(consoleBrandTF.getText());
		selectedConsole.setPrice(consolePriceTF.getText());
		selectedConsole.setStatus(consoleStatusTF.getText());
		selectedConsole.setInStock(Integer.parseInt(consoleInStockTF.getText()));
		if (selectedIndex >= 0) {
			
			boolean updateResult = csMN.updateConsole(selectedConsole);
			if (updateResult) {
				table.getItems().set(selectedIndex, selectedConsole);
				System.out.println("Cập nhập thành công!");
				actionMessage.setText("Cập nhập thành công!");
			} else {
				System.out.println("Cập nhập thất bại!");
				actionMessage.setText("Cập nhập thất bại!");
			}
		}
	}
	
	//Xử lý sự kiện delete
	@SuppressWarnings("unchecked")
	public void onClickDelete() {
		int selectedIndex = table.getSelectionModel().getSelectedIndex();
		Console cs = table.getItems().get(selectedIndex);
		if(cs.getProductId() == "") {
			System.out.println("Sản phẩm không tồn tại!");
			actionMessage.setText("Sản phẩm không tồn tại!!");
		}else {
			if (selectedIndex >= 0) {
				boolean deleteResult = csMN.deleteConsole(cs.getProductId());
				if (deleteResult) {
					table.getItems().remove(selectedIndex);
					System.out.println("Xóa thành công!!");
					actionMessage.setText("Xóa thành công!");
				} else {
					System.out.println("Xóa không thành công!");
					actionMessage.setText("Xóa không thành công!");
				}
			}
		}
	}
	
	public void onClickRow() {
		Console cs = table.getSelectionModel().getSelectedItem();
		consoleIdTF.setText(cs.getProductId());
		consoleNameTF.setText(cs.getName());
		consoleBrandTF.setText(cs.getBrand());
		consolePriceTF.setText(cs.getPrice());
		consoleStatusTF.setText(cs.getStatus());
		consoleInStockTF.setText(cs.getPrice());
	}	
	
	
	public static void main(String[] args) {
		ConsoleManage csm = new ConsoleManage();
		List<Console> consoleList = csm.getConsoleList();
		for (Console console : consoleList) {
			System.out.println(console.getName());
		}
	}
}


























































