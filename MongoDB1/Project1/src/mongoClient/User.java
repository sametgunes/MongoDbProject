package mongoClient;

public class User {

	private String id;
	private String name;
	private String pwd;
	public User(){}
	/*public User(String name,String pwd) {
		
		this.name=name;
		this.pwd=pwd;
	}
	*/
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	
}