package database;

import java.util.TreeMap;

import datatypes.Department;

public class DepartmentsTable
{
	private static DepartmentsTable uniqueInstance;
	private TreeMap<String, Department> departments;
	private DepartmentsTable()
	{
		departments = new TreeMap<>();
	}
	public static DepartmentsTable getInstance()
	{
		if(uniqueInstance == null)
		{
			synchronized(DepartmentsTable.class)
			{
				if(uniqueInstance == null)
					uniqueInstance = new DepartmentsTable();
			}
		}
		return uniqueInstance;
	}
	public TreeMap<String, Department> getData()
	{
		return departments;
	}
}