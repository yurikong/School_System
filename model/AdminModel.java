package model;

import datatypes.*;
import database.*;
import java.util.TreeMap;
import java.util.ArrayList;

public class AdminModel
{
	public AdminModel() {}
	public String getAllUsers()
	{
		return UsersTable.getInstance().getData().toString();
	}
	public int generateUserID()
	{
		return UsersTable.getInstance().getID();
	}
	public int generateCourseID()
	{
		return CoursesTable.getInstance().getID();
	}
	public int generateSessionID()
	{
		return SessionsTable.getInstance().getID();
	}
	public int generateRoomID()
	{
		return RoomsTable.getInstance().getID();
	}
	public String getUniversityName()
	{
		return UniversityInformationTable.getInstance().getData().name();
	}
	public void setUniversityName(String name)
	{
		UniversityInformationTable.getInstance().getData().setName(name);
	}
	public void addBuilding(Building building)
	{
		BuildingsTable.getInstance().getData().put(building.name(), building);
	}
	public void removeBuilding(String name)
	{
		BuildingsTable.getInstance().getData().remove(name);
	}
	public void setBuilding(String name, Building building)
	{
		BuildingsTable.getInstance().getData().replace(name, building);
	}
	public void addRoom(Room room)
	{
		RoomsTable.getInstance().getData().put(room.id(), room);
	}
	public void removeRoom(int id)
	{
		RoomsTable.getInstance().getData().remove(id);
	}
	public void setRoom(Room room)
	{
		RoomsTable.getInstance().getData().replace(room.id(), room);
	}
	public void addCollege(College college)
	{
		CollegesTable.getInstance().getData().put(college.name(), college);
	}
	public void removeCollege(String name)
	{
		CollegesTable.getInstance().getData().remove(name);
	}
	public void setCollege(String name, College college)
	{
		CollegesTable.getInstance().getData().replace(name, college);
	}
	public void addDepartment(Department dept)
	{
		DepartmentsTable.getInstance().getData().put(dept.name(), dept);
	}
	public void removeDepartment(String name)
	{
		DepartmentsTable.getInstance().getData().remove(name);
	}
	public void setDepartment(String name, Department dept)
	{
		DepartmentsTable.getInstance().getData().replace(name, dept);
	}
	public void addMajor(Major major)
	{
		MajorsTable.getInstance().getData().put(major.name(), major);
	}
	public void removeMajor(String name)
	{
		MajorsTable.getInstance().getData().remove(name);
	}
	public void setMajor(String name, Major major)
	{
		MajorsTable.getInstance().getData().replace(name, major);
	}
	public void addCourse(Course course)
	{
		CoursesTable.getInstance().getData().put(course.id(), course);
	}
	public void removeCourse(int id)
	{
		CoursesTable.getInstance().getData().remove(id);
	}
	public void setCourse(Course course)
	{
		CoursesTable.getInstance().getData().replace(course.id(), course);
	}
	public void addSession(Session session)
	{
		SessionsTable.getInstance().getData().put(session.id(), session);
	}
	public void removeSession(int id)
	{
		SessionsTable.getInstance().getData().remove(id);
	}
	public void setSession(Session session)
	{
		SessionsTable.getInstance().getData().replace(session.id(), session);
	}
	public void addUserAccount(User user)
	{
		UsersTable.getInstance().getData().put(user.id(), user);
	}
	public void removeUserAccount(int id)
	{
		UsersTable.getInstance().getData().remove(id);
	}
	public void setUserAccount(User user)
	{
		UsersTable.getInstance().getData().replace(user.id(), user);
	}
	public int addEmployeeAccount(Employee employee, String password)
	{
		int id = generateUserID();
		User user = new User(id, password, "Employee");
		employee.setID(id);
		UsersTable.getInstance().getData().put(id, user);
		EmployeesTable.getInstance().getData().put(id, employee);
		return id;
	}
	public void removeEmployeeAccount(int id)
	{
		EmployeesTable.getInstance().getData().remove(id);
	}
	public void setEmployeeAccount(Employee employee)
	{
		EmployeesTable.getInstance().getData().replace(employee.id(), employee);
	}
	public int addStudentAccount(Student student, String password)
	{
		int id = generateUserID();
		User user = new User(id, password, "Student");
		student.setID(id);
		UsersTable.getInstance().getData().put(id, user);
		StudentsTable.getInstance().getData().put(id, student);
		return id;
	}
	public void removeStudentAccount(int id)
	{
		StudentsTable.getInstance().getData().remove(id);
	}
	public void setStudentAccount(Student student)
	{
		StudentsTable.getInstance().getData().replace(student.id(), student);
	}
	public TreeMap<Integer, User> getUserAccounts()
	{
		return UsersTable.getInstance().getData();
	}
	public TreeMap<Integer, Employee> getEmployeeAccounts()
	{
		return EmployeesTable.getInstance().getData();
	}
	public TreeMap<Integer, Student> getStudentAccounts()
	{
		return StudentsTable.getInstance().getData();
	}
	public void resetStudentSemesterUnits()
	{
		TreeMap<Integer, Student> allStudents = StudentsTable.getInstance().getData();
		for(int i = 0; i < allStudents.size(); i++)
			allStudents.get(i).setCurrentUnit(0);
	}
	public void assignStudentGrade(final int studentID, final int courseID, final char grade)
	{
		int[] key = {studentID, courseID};
		GradesTable.getInstance().getData().put(key, grade);
	}
	/*public String addSessionCheck(Session session)
	{
		ArrayList<Session> termSessions = new ArrayList<>();
		TreeMap<Integer, Session> st = SessionsTable.getInstance().getData();
		for(int i = 0; i < st.size(); i++)		// all sessions in that term
		{
			Session s = st.get(i);
			String term = s.semester() + " " + Integer.toString(s.year());
			if(term.equals(session.semester() + " " + Integer.toString(session.year())))
					termSessions.add(s);
		}
		for(Session s : termSessions)	// check session info conflict against sessions in the same term
		{
			if(session.day().equals(s.day()))	// same day, check time, room, instructor conflict
			{
				if(session.startTime().isBefore(s.endTime()) || session.endTime().isAfter(s.startTime())) // time conflict
					return "Time conflict";
				else	// no time conflict, check room
				{
					
				}
			}
		}
	}*/
	public Object[][] getAllEmployeesConverted()
	{
		TreeMap<Integer, Employee> employees = EmployeesTable.getInstance().getData();
		Object[][] tableData = new Object[employees.size()][4];
		for(int i = 0; i < employees.size(); i++)
		{
			tableData[i][0] = employees.get(i).id();
			tableData[i][1] = employees.get(i).firstname();
			tableData[i][2] = employees.get(i).middlename();
			tableData[i][3] = employees.get(i).lastname();
		}
		return tableData;
	}
	public Object[][] getAllSessionsConverted()
	{
		TreeMap<Integer, Session> sessions = SessionsTable.getInstance().getData();
		Object[][] tableData = new Object[sessions.size()][6];
		for(int i = 0; i < sessions.size(); i++)
		{
			tableData[i][0] = sessions.get(i).id();
			tableData[i][1] = CoursesTable.getInstance().getData().get(sessions.get(i).courseID()).name();
			tableData[i][2] = sessions.get(i).day() + " " + sessions.get(i).startTime().toString() + "-" + sessions.get(i).endTime().toString();
			tableData[i][3] = sessions.get(i).buildingName() + " " + Integer.toString(sessions.get(i).roomNumber());
			int instructorID = sessions.get(i).instructorID();
			if(instructorID == -1)
				tableData[i][4] = "N/A";
			else
				tableData[i][4] = EmployeesTable.getInstance().getData().get(instructorID).firstname() + " " +
									EmployeesTable.getInstance().getData().get(instructorID).middlename() + " " +
									EmployeesTable.getInstance().getData().get(instructorID).lastname();
			tableData[i][5] = sessions.get(i).semester() + " " + Integer.toString(sessions.get(i).year());
		}
		return tableData;
	}
	public Object[][] getAllStudentsConverted()
	{
		TreeMap<Integer, Student> students = StudentsTable.getInstance().getData();
		Object[][] tableData = new Object[students.size()][5];
		for(int i = 0; i < students.size(); i++)
		{
			tableData[i][0] = students.get(i).id();
			tableData[i][1] = students.get(i).firstname();
			tableData[i][2] = students.get(i).middlename();
			tableData[i][3] = students.get(i).lastname();
			tableData[i][4] = students.get(i).tuitionStatus();
		}
		return tableData;
	}
	public Object[][] getEmployeeSessionsByID(int instructorID)
	{
		ArrayList<Integer> sessionsTeaching = EmployeesTable.getInstance().getData().get(instructorID).sessionsTeaching();
		Object[][] tableData = new Object[sessionsTeaching.size()][4];
		for(int i = 0; i < sessionsTeaching.size(); i++)
		{
			Session session = SessionsTable.getInstance().getData().get(sessionsTeaching.get(i));
			tableData[i][0] = sessionsTeaching.get(i);
			tableData[i][1] = CoursesTable.getInstance().getData().get(session.courseID()).name();
			tableData[i][2] = session.day() + " " + session.startTime().toString() + "-" + session.endTime().toString();
			tableData[i][3] = session.buildingName() + " " + session.roomNumber();
		}
		return tableData;
	}
	public ArrayList<String> getCollegeNames()
	{
		ArrayList<String> collegeNames = new ArrayList<>();
		for(String name : CollegesTable.getInstance().getData().keySet())
			collegeNames.add(name);
		return collegeNames;
	}
	public int getCollegeDeanID(String collegeName)
	{
		return CollegesTable.getInstance().getData().get(collegeName).deanID();
	}
	public void setCollegeDean(String collegeName, int employeeID)
	{
		CollegesTable.getInstance().getData().get(collegeName).setDeanID(employeeID);
	}
}