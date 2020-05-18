package model;

import datatypes.Student;
import datatypes.Employee;
import datatypes.Session;
import database.StudentsTable;
import database.UniversityInformationTable;
import database.CoursesTable;
import database.EmployeesTable;
import database.SessionsTable;
import java.util.ArrayList;
import java.util.TreeMap;

public class StudentModel
{
	public StudentModel() {}
	public Student getStudentInformation(int id)
	{
		return StudentsTable.getInstance().getData().get(id);
	}
	public void enrollSession(int studentID, int sessionID)
	{
		StudentsTable.getInstance().getData().get(studentID).sessionsEnrolled().add(sessionID);
	}
	public void dropSession(int studentID, int sessionID)
	{
		int index = StudentsTable.getInstance().getData().get(studentID).sessionsEnrolled().indexOf(sessionID);
		StudentsTable.getInstance().getData().get(studentID).sessionsEnrolled().remove(index);
	}
	public TreeMap<String, ArrayList<Session>> getStudentScheduleByTerm(int id)
	{
		TreeMap<String, ArrayList<Session>> scheduleByTerm = new TreeMap<>();
		ArrayList<String> terms = new ArrayList<>();					// all terms
		for(int i = 0; i < SessionsTable.getInstance().getData().size(); i++)	// find all terms
		{
			Session session = SessionsTable.getInstance().getData().get(i);
			String term = session.semester() + ' ' + Integer.toString(session.year());
			if(!terms.contains(term))
				terms.add(term);
		}
		ArrayList<Integer> sessionIDs = StudentsTable.getInstance().getData().get(id).sessionsEnrolled();	// all sessions of a student
		for(String term : terms)						// get sessions by terms
		{
			ArrayList<Session> sessionsByTerm = new ArrayList<>();
			for(int sID : sessionIDs)	// check if a session is in a term
			{
				Session session = SessionsTable.getInstance().getData().get(sID);
				String sTerm = session.semester() + ' ' + Integer.toString(session.year());
				if(term.equals(sTerm))
					sessionsByTerm.add(session);
			}
			scheduleByTerm.put(term, sessionsByTerm);
		}
		return scheduleByTerm;
	}
	public TreeMap<String, Object[][]> getStudentScheduleByTermConverted(int id)
	{
		TreeMap<String, ArrayList<Session>> scheduleByTerm = getStudentScheduleByTerm(id);
		TreeMap<String, Object[][]> scheduleByTermConverted = new TreeMap<>();
		for(String term : scheduleByTerm.keySet())
		{
			ArrayList<Session> sessions = scheduleByTerm.get(term);
			Object[][] tableData = new Object[sessions.size()][5];
			for(int i = 0; i < sessions.size(); i++)
			{
				tableData[i][0] = sessions.get(i).courseID(); // courseID
				tableData[i][1] = CoursesTable.getInstance().getData().get(tableData[i][0]).name(); // course name
				tableData[i][2] = sessions.get(i).buildingName() + " " + Integer.toString(sessions.get(i).roomNumber()); // building + room number
				tableData[i][3] = sessions.get(i).day() + " " + sessions.get(i).startTime().toString() + "-" + sessions.get(i).endTime().toString(); // starttime - endtime
				Employee instructor = EmployeesTable.getInstance().getData().get(sessions.get(i).instructorID());
				tableData[i][4] = instructor.firstname() + " " + instructor.middlename() + " " + instructor.lastname(); // instructor full name 
			}
			scheduleByTermConverted.put(term, tableData);
		}
		return scheduleByTermConverted;
	}
}