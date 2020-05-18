package database;

import java.util.TreeMap;

import datatypes.Employee;

public class EmployeesTable
{
	private static EmployeesTable uniqueInstance;
	private TreeMap<Integer, Employee> employees;
	private EmployeesTable()
	{
		employees = new TreeMap<>();
	}
	public static EmployeesTable getInstance()
	{
		if(uniqueInstance == null)
		{
			synchronized(EmployeesTable.class)
			{
				if(uniqueInstance == null)
					uniqueInstance = new EmployeesTable();
			}
		}
		return uniqueInstance;
	}
	public TreeMap<Integer, Employee> getData()
	{
		return employees;
	}
}