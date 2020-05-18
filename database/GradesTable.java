package database;

import java.util.TreeMap;

public class GradesTable
{
	private static GradesTable uniqueInstance;
	private TreeMap<int[], Character> grades; // <[studentID, courseID], grade>
	private GradesTable()
	{
		grades = new TreeMap<>();
	}
	public static GradesTable getInstance()
	{
		if(uniqueInstance == null)
		{
			synchronized(GradesTable.class)
			{
				if(uniqueInstance == null)
					uniqueInstance = new GradesTable();
			}
		}
		return uniqueInstance;
	}
	public TreeMap<int[], Character> getData()
	{
		return grades;
	}
}