package datatypes;

import java.util.ArrayList;

public class Employee
{
	private int id;
	private String firstname;
	private String middlename;
	private String lastname;
	private String title;
	private float salary;
	private ArrayList<Integer> sessionsTeaching;
	public Employee(int id, String firstname, String middlename, String lastname, String title, float salary, ArrayList<Integer> sessionsTeaching)
	{
		this.id = id;
		this.firstname = firstname;
		this.middlename = middlename;
		this.lastname = lastname;
		this.title = title;
		this.salary = salary;
		this.sessionsTeaching = sessionsTeaching;
	}
	public void setID(int id) { this.id = id; }
	public void setFirstname(String firstname) { this.firstname = firstname; }
	public void setMiddlename(String middlename) { this.middlename = middlename; }
	public void setLastname(String lastname) { this.lastname = lastname; }
	public void setTitle(String title) { this.title = title; }
	public void setSalary(float salary) { this.salary = salary; }
	public void setSessionsTeaching(ArrayList<Integer> sessionsTeaching) { this.sessionsTeaching = sessionsTeaching; }
	public int id() { return id; }
	public String firstname() { return firstname; }
	public String middlename() { return middlename; }
	public String lastname() { return lastname; }
	public String title() { return title; }
	public float salary() { return salary; }
	public ArrayList<Integer> sessionsTeaching() { return sessionsTeaching; }
}
