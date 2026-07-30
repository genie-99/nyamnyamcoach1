package nyamnyam1.DTO;

public class Users {
	private int id;
	private String password;
	private String name;
	private boolean isLogin;
	
	public Users() {}
	

	public Users(int id, String password, String name, boolean isLogin) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.isLogin = isLogin;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isLogin() {
		return isLogin;
	}

	public void setLogin(boolean isLogin) {
		this.isLogin = isLogin;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", password=" + password + ", name=" + name + ", isLogin=" + isLogin + "]";
	}
	
	
	
	
}
