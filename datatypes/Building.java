package datatypes;

import java.util.ArrayList;

public class Building
{
	private String name;
	//private ArrayList<Room> rooms;
	private ArrayList<Integer> rooms;
	public Building(String name, ArrayList<Integer> rooms)
	{
		this.name = name;
		this.rooms = rooms;
	}
	public void setName(String name) { this.name = name; }
	public void setRooms(ArrayList<Integer> rooms) { this.rooms = rooms; }
	public String name() { return name; }
	public ArrayList<Integer> rooms() { return rooms; }
}
