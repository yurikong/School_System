package database;

import java.util.TreeMap;

import datatypes.Building;

public class BuildingsTable
{
	private static BuildingsTable uniqueInstance;
	private TreeMap<String, Building> buildings;
	private BuildingsTable()
	{
		buildings = new TreeMap<>();
	}
	public static BuildingsTable getInstance()
	{
		if(uniqueInstance == null)
		{
			synchronized(BuildingsTable.class)
			{
				if(uniqueInstance == null)
					uniqueInstance = new BuildingsTable();
			}
		}
		return uniqueInstance;
	}
	public TreeMap<String, Building> getData()
	{
		return buildings;
	}
}