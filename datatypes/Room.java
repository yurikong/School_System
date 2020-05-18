package datatypes;

public class Room
{
	private final int id;
	private int roomNumber;
	private int occupancyLimit;
	private String buildingName;
	public Room(final int id, int roomNumber, int occupancyLimit, String buildingName)
	{
		this.id = id;
		this.roomNumber = roomNumber;
		this.occupancyLimit = occupancyLimit;
		this.buildingName = buildingName;
	}
	public void setRoomNumber(int roomNumber) { this.roomNumber = roomNumber; }
	public void setOccupancyLimit(int occupancyLimit) { this.occupancyLimit = occupancyLimit; }
	public void setBuildingName(String buildingName) { this.buildingName = buildingName; }
	public final int id() { return id; }
	public int roomNumber() { return roomNumber; }
	public int occupancyLimit() { return occupancyLimit; }
	public String buildingName() { return buildingName; }
}
