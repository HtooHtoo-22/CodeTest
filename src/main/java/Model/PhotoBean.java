package Model;

import java.util.Base64;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class PhotoBean {
	private int id;
	private String name;
	private MultipartFile file;
	private byte[] photoByte;
	
	public String get64() {
		if(photoByte!=null) {
			return Base64.getEncoder().encodeToString(photoByte);
		}else {
			return null;
		}
	}
}
