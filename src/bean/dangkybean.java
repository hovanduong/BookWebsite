package bean;

public class dangkybean {
	private String hoten;
	private String diachi;
	private String sodt;
	private String email;
	private String username;
	private String password;
	public dangkybean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public dangkybean(String hoten, String diachi, String sodt, String email, String username, String password) {
		super();
		this.hoten = hoten;
		this.diachi = diachi;
		this.sodt = sodt;
		this.email = email;
		this.username = username;
		this.password = password;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public String getSodt() {
		return sodt;
	}
	public void setSodt(String sodt) {
		this.sodt = sodt;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
