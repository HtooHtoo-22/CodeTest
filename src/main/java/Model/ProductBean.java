package Model;

import java.util.Base64;

import lombok.Data;

@Data
public class ProductBean {
	private int id;
	private String product_name;
	private String brand;
	private Double price;
	private byte[] photo;
	public String get() {
		if(photo!=null) {
			return Base64.getEncoder().encodeToString(photo);
		}else {
			return null;
		}
	}
	
}
