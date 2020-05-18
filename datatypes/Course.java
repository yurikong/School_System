package datatypes;

import java.util.ArrayList;

public class Course
{
	private final int id;
	private String name;
	private int unit;
	private ArrayList<Integer> prereqs;
	private ArrayList<Integer> sessions;
	public Course(final int id, String name, int unit, ArrayList<Integer> prereqs, ArrayList<Integer> sessions)
	{
		this.id = id;
		this.name = name;
		this.unit = unit;
		this.prereqs = prereqs;
		this.sessions = sessions;
	}
	public void setName(String name) { this.name = name; }
	public void setUnit(int unit) { this.unit = unit; }
	public void setPrereqs(ArrayList<Integer> prereqs) { this.prereqs = prereqs; }
	public void setSessions(ArrayList<Integer> sessions) { this.sessions = sessions; }
	public final int id() { return id; }
	public String name() { return name; }
	public int unit() { return unit; }
	public ArrayList<Integer> prereqs() { return prereqs; }
	public ArrayList<Integer> sessions() { return sessions; }
}
