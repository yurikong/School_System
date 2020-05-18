package database;

import datatypes.User;
import java.util.TreeMap;

public class UsersTable
{
	private static UsersTable uniqueInstance;
	private TreeMap<Integer, User> users;
	private static int id;
	private UsersTable()
	{
		users = new TreeMap<>();
		id = 0;
	}
	public static UsersTable getInstance()
	{
		if(uniqueInstance == null)
		{
			synchronized(UsersTable.class)
			{
				if(uniqueInstance == null)
					uniqueInstance = new UsersTable();
			}
		}
		return uniqueInstance;
	}
	public int getID() { return id++; }
	public TreeMap<Integer, User> getData()
	{
		return users;
	}
}