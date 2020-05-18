package datatypes;

public class User
{
	private int id;
	private String password;
	private String status;
	public User(int id, String password, String status)
	{
		this.id = id;
		this.password = password;
		this.status = status;
	}
	public void setID(int id) { this.id = id; }
	public void setPassword(String password) { this.password = password; }
	public void setStatus(String status) { this.status = status; }
	public int id() { return id; }
	public String password() { return password; }
	public String status() { return status; }
}