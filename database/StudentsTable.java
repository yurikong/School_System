package database;

import java.util.TreeMap;

import datatypes.Student;

public class StudentsTable
{
	private static StudentsTable uniqueInstance;
	private TreeMap<Integer, Student> students;
	private StudentsTable()
	{
		students = new TreeMap<>();
	}
	public static StudentsTable getInstance()
	{
		if(uniqueInstance == null)
		{
			synchronized(StudentsTable.class)
			{
				if(uniqueInstance == null)
					uniqueInstance = new StudentsTable();
			}
		}
		return uniqueInstance;
	}
	public TreeMap<Integer, Student> getData()
	{
		return students;
	}
}