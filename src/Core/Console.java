package Core;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Console {
	private String productId;
	private String name;
	private String brand;
	private int inStock;
	private String price;
	private String status;
	
	//Các constructer
	public Console() {
		
	}
	
	//Các phương thức get, set
	public String getName() {
		return name;
	}
	
	public String getBrand() {
		return brand;
	}
	
	public String getPrice() {
		return price;
	}
	
	public String getStatus() {
		return status;
	}
	
	public int getInStock() {
		return inStock;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public void setPrice(String price) {
		this.price = price;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public void setInStock(int inStock) {
		this.inStock = inStock;
	}
	
	public void setProductId(String productId) {
		this.productId = productId;
	}
	
	public String getProductId() {
		return productId;
	}
	
	public Console(String productId, String name, String brand, String price, String status,int inStock) {
		this.productId = productId;
		this.name = name;
		this.brand = brand;
		this.inStock = inStock;
		this.price = price;
		this.status = status;
	}
	
	public Console(String name, String brand, int inStock) {
		this.name = name;
		this.brand = brand;
		this.inStock = inStock;
	}
	
	public Console(String name, String brand,String price, String status,int inStock) {
		this.productId = name;
		this.brand = brand;
		this.inStock = inStock;
		this.price = price;
		this.status = status;
	}
	
	
	
}
