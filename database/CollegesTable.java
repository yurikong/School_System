package database;

import java.util.TreeMap;

import datatypes.College;

public class CollegesTable
{
	private static CollegesTable uniqueInstance;
	private TreeMap<String, College> colleges;
	private CollegesTable()
	{
		colleges = new TreeMap<>();
	}
	public static CollegesTable getInstance()
	{
		if(uniqueInstance == null)
		{
			synchronized(CollegesTable.class)
			{
				if(uniqueInstance == null)
					uniqueInstance = new CollegesTable();
			}
		}
		return uniqueInstance;
	}
	public TreeMap<String, College> getData()
	{
		return colleges;
	}
}