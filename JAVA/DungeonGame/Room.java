
public class Room {
	
	private String descrip; //description
	private Room north;
	private Room east;
	private Room west;
	private Room south;
	
	public Room(String descrip) { //constructor
		
		this.descrip = descrip;
			
	}
	
	public void setNorth(Room north) { //setters for directions
		
		this.north = north;
	}
	
	public void setEast(Room east) {
		
		this.east = east;
	}
	
	public void setWest(Room west) {
		
		this.west = west;
	}
	
	public void setSouth(Room south) {
		
		this.south = south;
	}
	
	public void setExits(Room north, Room east, Room west, Room south) { //setting exits
		
		setNorth(north);
		setEast(east);
		setWest(west);
		setSouth(south);
	}
	
	public Room getNorth() { //getters for directions
		
		return this.north;
	}
	public Room getEast() {
		
		return this.east;
	}
	public Room getWest() {
		
		return this.west;
	}
	public Room getSouth() {
		
		return this.south;
	}
	public String getDescrip() {
		
		return this.descrip;
	}
	public String getExits() {
		
		String north = "";
		String east = "";
		String west = "";
		String south = "";
		
		if(this.getNorth() != null) { //if north isn't null
			
			north = "North";
		}
		if(this.getEast() != null) { //if east isn't null
			
			east = "East";
		}
		if(this.getWest() != null) { //if west isn't null
			
			west = "West";
		}
		if(this.getSouth() != null) { //if south isn't null
			
			south = "South";
		}
		return String.format("Exits are : %s %s %s %s", north, east, west, south); //%s is for for strings; go in order
		
	}
	public String toString() { //return for description and exits
		
		return this.getDescrip() + this.getExits();
	}
 
}
