package datatypes;

import java.util.ArrayList;

public class Department
{
	private String name;
	private int chairID;
	private ArrayList<String> majors;
	public Department(String name, int chairID, ArrayList<String> majors)
	{
		this.name = name;
		this.chairID = chairID;
		this.majors = majors;
	}
	public void setName(String name) { this.name = name; }
	public void setChairID(int chairID) { this.chairID = chairID; }
	public void setMajors(ArrayList<String> majors) { this.majors = majors; }
	public String name() { return name; }
	public int chairID() { return chairID; }
	public ArrayList<String> majors() { return majors; }
}
