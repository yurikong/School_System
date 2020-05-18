package datatypes;

import java.util.ArrayList;
import java.time.LocalTime;

public class Session
{
	private final int id;
	private int courseID;
	private int instructorID;
	private LocalTime startTime;
	private LocalTime endTime;
	private String semester;
	private int year;
	private String day;				// MW or TTh
	private String buildingName;
	private int roomID; // change this to roomID
	private int roomNumber;
	private int enrollmentLimit;
	private ArrayList<Integer> roster; // id of students enrolled
	public Session(final int id, int cid, int instructorID, LocalTime startTime, LocalTime endTime, String semester, int year, String day, String buildingName, int roomID, int roomNumber, int enrollmentLimit, ArrayList<Integer> roster)
	{
		this.id = id;
		this.courseID = cid;
		this.instructorID = instructorID;
		this.startTime = startTime;
		this.endTime = endTime;
		this.semester = semester;
		this.year = year;
		this.day = day;
		this.buildingName = buildingName;
		this.roomID = roomID;
		this.roomNumber = roomNumber;
		this.enrollmentLimit = enrollmentLimit;
		this.roster = roster;
	}
	public void setCourseID(int courseID) { this.courseID = courseID; }
	public void setInstructorID(int instructorID) { this.instructorID = instructorID; }
	public void setStartTime(LocalTime startTime) { this.startTime = startTime; }
	public void setEndTime(LocalTime endTime) { this.endTime = endTime; }
	public void setSemester(String semester) { this.semester = semester; }
	public void setYear(int year) { this.year = year; }
	public void setDay(String day) { this.day = day; }
	public void setBuildingName(String buildingName) { this.buildingName = buildingName; }
	public void setRoomID(int roomID) { this.roomID = roomID; }
	public void setRoomNumber(int roomNumber) { this.roomNumber = roomNumber; }
	public void setEnrollmentLimit(int enrollmentLimit) { this.enrollmentLimit = enrollmentLimit; }
	public void setRoster(ArrayList<Integer> roster) { this.roster = roster; }
	public final int id() { return id; }
	public int courseID() { return courseID; }
	public int instructorID() { return instructorID; }
	public LocalTime startTime() { return startTime; }
	public LocalTime endTime() { return endTime; }
	public String semester() { return semester; }
	public int year() { return year; }
	public String day() { return day; }
	public String buildingName() { return buildingName; }
	public int roomID() { return roomID; }
	public int roomNumber() { return roomNumber; }
	public int enrollmentLimit() { return enrollmentLimit; }
	public ArrayList<Integer> roster() { return roster; }
}
