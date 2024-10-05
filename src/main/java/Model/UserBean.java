package Model;

import lombok.Data;

@Data
public class UserBean {
	private int id;
	private String name;
	private String email;
	private String password;
	private String role;
}
