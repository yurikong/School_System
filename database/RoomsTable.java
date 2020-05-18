package database;

import java.util.TreeMap;

import datatypes.Room;

public class RoomsTable
{
	private static RoomsTable uniqueInstance;
	private TreeMap<Integer, Room> rooms;
	private static int id;
	private RoomsTable()
	{
		rooms = new TreeMap<>();
		id = 0;
	}
	public static RoomsTable getInstance()
	{
		if(uniqueInstance == null)
		{
			synchronized(RoomsTable.class)
			{
				if(uniqueInstance == null)
					uniqueInstance = new RoomsTable();
			}
		}
		return uniqueInstance;
	}
	public int getID() { return id++; }
	public TreeMap<Integer, Room> getData()
	{
		return rooms;
	}
}