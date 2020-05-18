package model;

import datatypes.*;
import database.*;
import java.util.ArrayList;
import java.util.TreeMap;
import java.time.LocalDate;

public class SchoolModel
{
	public SchoolModel() {}
	public University getUniversity()
	{
		return UniversityInformationTable.getInstance().getData(); 
	}
	public String getUniversityName()
	{
		return UniversityInformationTable.getInstance().getData().name();
	}
	public TreeMap<String, Building> getBuildings()
	{
		return BuildingsTable.getInstance().getData();
	}
	public TreeMap<String, College> getColleges()
	{
		return CollegesTable.getInstance().getData();
	}
	public TreeMap<String, Department> getDepartments()
	{
		return DepartmentsTable.getInstance().getData();
	}
	public TreeMap<String, Major> getMajors()
	{
		return MajorsTable.getInstance().getData();
	}
	public TreeMap<Integer, Course> getCourses()
	{
		return CoursesTable.getInstance().getData();
	}
	public TreeMap<Integer, Session> getSessions()
	{
		return SessionsTable.getInstance().getData();
	}
	public String getCurrentSemester()
	{
		String semester = "";
		LocalDate date = LocalDate.now();
		int month = date.getMonthValue();
		if(month >= 1 && month <= 6)
			semester += "Spring";
		if(month >= 7 && month <= 12)
			semester += "Fall";
		return semester;
	}
	public int getCurrentYear()
	{
		return LocalDate.now().getYear();
	}
	public String getCurrentTerm()
	{
		return getCurrentSemester() + ' ' + Integer.toString(getCurrentYear());
	}
	public TreeMap<String, ArrayList<Session>> getSessionScheduleByTerm()
	{
		TreeMap<String, ArrayList<Session>> sessionScheduleByTerm = new TreeMap<>();
		ArrayList<String> terms = new ArrayList<>();					// all terms
		for(int i = 0; i < SessionsTable.getInstance().getData().size(); i++)	// find all terms
		{
			Session session = SessionsTable.getInstance().getData().get(i);
			String term = session.semester() + ' ' + Integer.toString(session.year());
			if(!terms.contains(term))
				terms.add(term);
		}
		for(String term : terms)						// get sessions by terms
		{
			ArrayList<Session> sessionsByTerm = new ArrayList<>();
			for(int i = 0; i < SessionsTable.getInstance().getData().size(); i++)	// check if a session is in a term
			{
				Session session = SessionsTable.getInstance().getData().get(i);
				String sTerm = session.semester() + ' ' + Integer.toString(session.year());
				if(term.equals(sTerm))
					sessionsByTerm.add(session);
			}
			sessionScheduleByTerm.put(term, sessionsByTerm);
		}
		return sessionScheduleByTerm;
	}
	public TreeMap<String, Object[][]> getSessionScheduleByTermConverted()
	{
		TreeMap<String, ArrayList<Session>> sessionScheduleByTerm = getSessionScheduleByTerm();
		TreeMap<String, Object[][]> sessionScheduleByTermConverted = new TreeMap<>();
		for(String term : sessionScheduleByTerm.keySet())
		{
			ArrayList<Session> sessions = sessionScheduleByTerm.get(term);
			Object[][] tableData = new Object[sessions.size()][6];
			for(int i = 0; i < sessions.size(); i++)
			{
				tableData[i][0] = sessions.get(i).courseID(); // courseID
				tableData[i][1] = CoursesTable.getInstance().getData().get(sessions.get(i).courseID()).name();
				tableData[i][2] = sessions.get(i).buildingName() + " " + Integer.toString(sessions.get(i).roomID());
				tableData[i][3] = sessions.get(i).day() + " " + sessions.get(i).startTime().toString() + "-" + sessions.get(i).endTime().toString();
				Employee instructor = EmployeesTable.getInstance().getData().get(sessions.get(i).instructorID());
				tableData[i][4] = instructor.firstname() + " " + instructor.middlename() + " " + instructor.lastname();
				ArrayList<Integer> prereqs = CoursesTable.getInstance().getData().get(sessions.get(i).courseID()).prereqs();
				ArrayList<String> prereqsName = new ArrayList<>();
				for(int j : prereqs)
					prereqsName.add(CoursesTable.getInstance().getData().get(sessions.get(j).courseID()).name());
				tableData[i][5] = prereqsName.toString();
			}
			sessionScheduleByTermConverted.put(term, tableData);
		}
		return sessionScheduleByTermConverted;
	}
}
