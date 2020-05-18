package database;

import java.util.TreeMap;

import datatypes.Admin;

public class AdminsTable
{
	private static AdminsTable uniqueInstance;
	private TreeMap<Integer, Admin> admins;
	private AdminsTable()
	{
		admins = new TreeMap<>();
	}
	public static AdminsTable getInstance()
	{
		if(uniqueInstance == null)
		{
			synchronized(AdminsTable.class)
			{
				if(uniqueInstance == null)
					uniqueInstance = new AdminsTable();
			}
		}
		return uniqueInstance;
	}
	public TreeMap<Integer, Admin> getData()
	{
		return admins;
	}
}