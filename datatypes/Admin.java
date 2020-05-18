package datatypes;

public class Admin
{
	private int id;
	private String firstname;
	private String middlename;
	private String lastname;
	public Admin(int id, String firstname, String middlename, String lastname)
	{
		this.id = id;
		this.firstname = firstname;
		this.middlename = middlename;
		this.lastname = lastname;
	}
	public void setID(int id) { this.id = id; }
	public void setFirstname(String firstname) { this.firstname = firstname; }
	public void setMiddlename(String middlename) { this.middlename = middlename; }
	public void setLastname(String lastname) { this.lastname = lastname; }
	public int id() { return id; }
	public String firstname() { return firstname; }
	public String middlename() { return middlename; }
	public String lastname() { return lastname; }
}