import java.util.Scanner;

public class aGame {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		Dungeon myDungeon = new Dungeon(); //instantiate and create dungeon object
		
		Room currentRoom = myDungeon.getRoom0(); //create currentroom object

		System.out.println(currentRoom); //show current room
		

		
		boolean loop = true; 
		while (loop) {	
		
		menu();
		
		String direction = input.nextLine(); //input for direction to go
		
		if (direction.equals ("n") && currentRoom.getNorth() != null) { //if input is n and isn't null
			currentRoom = currentRoom.getNorth();
			System.out.println(currentRoom);			
		}
		
		else if (direction.equals ("n") && currentRoom.getNorth() == null) { //if input is n but unable to go to that direction
			System.out.println("You can't go that way!");
		}
		
		else if (direction.equals ("e") && currentRoom.getEast() != null) {
			currentRoom = currentRoom.getEast();
			System.out.println(currentRoom);
		}
		
		else if (direction.equals ("e") && currentRoom.getEast() == null) {
			System.out.println("You can't go that way!");
		}
		
		else if (direction.equals ("w") && currentRoom.getWest() != null) {
			currentRoom = currentRoom.getWest();
			System.out.println(currentRoom);
		}
		
		else if (direction.equals ("w") && currentRoom.getWest() == null) {
			System.out.println("You can't go that way!");
		}
		
		else if (direction.equals ("s") && currentRoom.getSouth() != null) {
			currentRoom = currentRoom.getSouth();
			System.out.println(currentRoom);
		}
		
		else if (direction.equals ("s") && currentRoom.getSouth() == null) {
			System.out.println("You can't go that way!");
		}
		
		else if (direction.equals ("q")) {
			System.out.println("You leave the dungeon");
			loop = false;
		}
		
		}		
	}
	
	public static void menu() {
		System.out.println("Which way would you like to go?");
		System.out.println("n: north");
		System.out.println("s: south");
		System.out.println("w: west");
		System.out.println("e: east");
		System.out.println("q: quit game");
	}
}