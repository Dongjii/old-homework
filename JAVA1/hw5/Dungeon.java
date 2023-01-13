
public class Dungeon {
	
	private Room basketballCourt;
	private Room bedroom2;
	private Room livingRoom;
	private Room bedroom1;
	private Room kitchen;
	private Room diningRoom;
	private Room gameroom;
	
	public Dungeon() {
		
		//new rooms
		
		basketballCourt = new Room("Basketball Court:Ball is life. ");
		
		bedroom2 = new Room("Bedroom 2:Another place to nap. ");
		
		livingRoom = new Room("Livingroom: Alive in a room. ");
		
		bedroom1 = new Room("Bedroom 1:Naptime. ");
		
		kitchen = new Room("Kitchen:Foooooooood. ");
		
		diningRoom = new Room("Diningroom:Lunch time? Dinner time? ");
		
		gameroom = new Room("Gameroom:Let's play games! ");
		
		//room exits
		
		basketballCourt.setExits(null, null, null, livingRoom); //if there are no exits at -north,east,west,south- then null
		
		bedroom2.setExits(null, null, livingRoom, kitchen);
		
		livingRoom.setExits(basketballCourt, bedroom2, bedroom1, diningRoom);
		
		bedroom1.setExits(null, livingRoom, null, gameroom);
		
		kitchen.setExits(bedroom2, null, diningRoom, null);
		
		diningRoom.setExits(livingRoom, kitchen, gameroom, null);
		
		gameroom.setExits(bedroom1, diningRoom, null, null);

		
	}
	
	
	
	public Room getRoom0() {
		
		return gameroom; //currentroom
	}
}