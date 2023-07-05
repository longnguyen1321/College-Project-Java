package Core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ConsoleManage {
	private String jdbcURL;
	private String jdbcUsername;
	private String jdbcPassword;
	
	private Connection conn;
	
	//Các constructer
	public ConsoleManage() {
		this.jdbcURL = "jdbc:ucanaccess://C:\\Users\\Admin\\Downloads\\Workspace\\655464_NguyenNgocLong\\lib\\consoledatabase.accdb";
	}
	
	public ConsoleManage(String jdbcURL, String jbdcUsername, String jdbcPassword) {
		this.jdbcURL = jdbcURL;
		this.jdbcUsername = jbdcUsername;
		this.jdbcPassword = jdbcPassword;
	}
	
	public List<Console> getConsoleList(){
		List<Console>  consoleList = new ArrayList<Console>();
		Statement statement = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.create(jdbcURL, jdbcUsername, jdbcPassword);
			statement = conn.createStatement();
			rs = statement.executeQuery("Select * from tblconsole");
			String consoleId;
			String consoleName;
			String consoleBrand;
			int consoleInStock;
			String consolePrice;
			String consoleStatus;
			// Duyệt qua danh sách các bản thi nhận được trong đối tượng ResultSet
	
			while (rs.next()) {
				consoleId = rs.getString(1);
				consoleName = rs.getString(2);
				consoleBrand = rs.getString(3);
				consoleInStock = rs.getInt(4);
				consolePrice = rs.getString(5);
				consoleStatus = rs.getString(6);
				// Thêm vào list
				consoleList.add(new Console(consoleId,consoleName,consoleBrand,consolePrice,consoleStatus,consoleInStock));

		}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(statement);
			DBConnection.closeConnect(conn);
		}
		return consoleList;
	}
	
	public boolean addConsole(Console cs) {
		// Tạo kết nối database với 3 tham số truyền vào
		conn = DBConnection.create(jdbcURL, jdbcUsername, jdbcPassword);
		// Tạo câu truy vấn kiểu prepare
		String sqlCommand = "INSERT INTO tblconsole VALUES(?, ?, ?, ?, ?, ?)";
		PreparedStatement pst = null;

		boolean result = false;
		try {
		// Tạo đối tượng truy vấn kiểu Prepare
		pst = conn.prepareStatement(sqlCommand);
		// Đưa dữ liệu vào các vị trí dấu hỏi (?)
		pst.setString(1, cs.getProductId());
		pst.setString(2, cs.getName());
		pst.setString(3, cs.getBrand());
		pst.setString(4, cs.getPrice());
		pst.setString(5, cs.getStatus());
		pst.setString(6, String.valueOf(cs.getInStock()));
		// Thực hiện chạy câu truy vấn
		int i = pst.executeUpdate();
		// Nếu thành công, 1 bản ghi được thêm vào
		if (i == 1) {
		result = true;
		}
		} catch (SQLException e) {
		e.printStackTrace();
		} finally { // Đóng kết nối trong khối finally (bắt buộc chạy)
		DBConnection.closePreparedStatement(pst);
		DBConnection.closeConnect(conn);
		}
		return result;
	}
	
	public boolean updateConsole(Console cs) {
		conn = DBConnection.create(jdbcURL, jdbcUsername, jdbcPassword);
		String sqlCommand = "UPDATE tblconsole SET name = ?, brand = ?, price = ?, status = ?, inStock = ?" + "WHERE id = ?";

		PreparedStatement pst = null;
		boolean result = false;
		try {
			pst = conn.prepareStatement(sqlCommand);
			pst.setString(1, cs.getProductId());
			pst.setString(2, cs.getName());
			pst.setString(3, cs.getBrand());
			pst.setString(4, cs.getPrice());
			pst.setString(5, cs.getStatus());
			pst.setInt(6, cs.getInStock());
			int i = pst.executeUpdate();
			if (i == 1) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.closePreparedStatement(pst);
			DBConnection.closeConnect(conn);
		}
			return result;
	}
	
	public boolean deleteConsole(String consoleId) {
		conn = DBConnection.create(jdbcURL, jdbcUsername, jdbcPassword);
		String sqlCommand = "DELETE FROM tblconsole WHERE id = ?";
		PreparedStatement pst = null;
		boolean result = false;
		try {
			pst = conn.prepareStatement(sqlCommand);
			pst.setString(1, consoleId);
			int i = pst.executeUpdate();
			if (i == 1) {
				result = true;
		}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.closePreparedStatement(pst);
			DBConnection.closeConnect(conn);
		}
		return result;
	}
	
	
	public static void main(String[] args) {
		Console test = new Console("XBX","XBOX-X","Xbox","499","LowInStock",10);
		Console update = new Console("XBX","Xbox-S","Xbox","399","LowInStock",15);
		ConsoleManage test2 = new ConsoleManage();
		
			test2.updateConsole(update);
	}
	
}








