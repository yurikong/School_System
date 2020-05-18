package datatypes;

import java.util.ArrayList;

public class College
{
	private String name;
	private int deanID;
	private ArrayList<String> departments;
	public College(String name, int deanID, ArrayList<String> departments)
	{
		this.name = name;
		this.deanID = deanID;
		this.departments = departments;
	}
	public void setName(String name) { this.name = name; }
	public void setDeanID(int deanID) { this.deanID = deanID; }
	public void setDepartments(ArrayList<String> departments) { this.departments = departments; }
	public String name() { return name; }
	public int deanID() { return deanID; }
	public ArrayList<String> departments() { return departments; }
	public String toString()
	{
		String str = name + " " + deanID + " ";
		for(String dept : departments)
			str += dept + " ";
		return str;
	}
}