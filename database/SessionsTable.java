package database;

import java.util.TreeMap;

import datatypes.Session;

public class SessionsTable
{
	private static SessionsTable uniqueInstance;
	private TreeMap<Integer, Session> sessions;
	private static int id;
	private SessionsTable()
	{
		sessions = new TreeMap<>();
		id = 0;
	}
	public static SessionsTable getInstance()
	{
		if(uniqueInstance == null)
		{
			synchronized(SessionsTable.class)
			{
				if(uniqueInstance == null)
					uniqueInstance = new SessionsTable();
			}
		}
		return uniqueInstance;
	}
	public int getID() { return id++; }
	public TreeMap<Integer, Session> getData()
	{
		return sessions;
	}
}