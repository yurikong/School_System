package database;

import java.util.TreeMap;

import datatypes.Course;

public class CoursesTable
{
	private static CoursesTable uniqueInstance;
	private TreeMap<Integer, Course> courses;
	private static int id;
	private CoursesTable()
	{
		courses = new TreeMap<>();
		id = 0;
	}
	public static CoursesTable getInstance()
	{
		if(uniqueInstance == null)
		{
			synchronized(CoursesTable.class)
			{
				if(uniqueInstance == null)
					uniqueInstance = new CoursesTable();
			}
		}
		return uniqueInstance;
	}
	public int getID() { return id++; }
	public TreeMap<Integer, Course> getData()
	{
		return courses;
	}
}