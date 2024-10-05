package Model;

import java.util.Base64;

import lombok.Data;

@Data
public class CartBean {
	private int cart_id;
	private int product_id;
	private String product_name;
	private String brand;
	private Double price;
	private int quantity;
	private int user_id;
	private byte[]photoByte;
	public String get64(){
		if(photoByte!=null) {
			return Base64.getEncoder().encodeToString(photoByte);
		}else {
			return null;
		}
	}
}
