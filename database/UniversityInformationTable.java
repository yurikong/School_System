package database;

import datatypes.University;
import java.util.ArrayList;

public class UniversityInformationTable
{
	private static UniversityInformationTable uniqueInstance;
	private University univ;
	// implement current semester and year with java.util.Date
	private UniversityInformationTable()
	{
		univ = new University();
	}
	public static UniversityInformationTable getInstance()
	{
		if(uniqueInstance == null)
		{
			synchronized(UniversityInformationTable.class)
			{
				if(uniqueInstance == null)
					uniqueInstance = new UniversityInformationTable();
			}
		}
		return uniqueInstance;
	}
	public University getData()
	{
		return univ;
	}
	public final ArrayList<Character> getLetterGrades()
	{
		ArrayList<Character> letterGrades = new ArrayList<>();
		letterGrades.add('A');
		letterGrades.add('B');
		letterGrades.add('C');
		letterGrades.add('D');
		letterGrades.add('F');
		return letterGrades;
	}
}