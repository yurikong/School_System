package database;

import java.util.TreeMap;

import datatypes.Major;

public class MajorsTable
{
	private static MajorsTable uniqueInstance;
	private TreeMap<String, Major> majors;
	private MajorsTable()
	{
		majors = new TreeMap<>();
	}
	public static MajorsTable getInstance()
	{
		if(uniqueInstance == null)
		{
			synchronized(MajorsTable.class)
			{
				if(uniqueInstance == null)
					uniqueInstance = new MajorsTable();
			}
		}
		return uniqueInstance;
	}
	public TreeMap<String, Major> getData()
	{
		return majors;
	}
}