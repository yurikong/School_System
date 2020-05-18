package datatypes;

import java.util.ArrayList;

public class Major
{
	private String name;
	private ArrayList<Integer> courses;
	public Major(String name, ArrayList<Integer> courses)
	{
		this.name = name;
		this.courses = courses;
	}
	public void setName(String name) { this.name = name; }
	public void setCourses(ArrayList<Integer> courses) { this.courses = courses; }
	public String name() { return name; }
	public ArrayList<Integer> courses() { return courses; }
}
