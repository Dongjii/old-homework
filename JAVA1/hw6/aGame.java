import java.util.Scanner;
import java.util.Random;

public class aGame {
	
	static Player dong; //declare object
	static Monster goblin; //declare object
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		Dungeon myDungeon = new Dungeon(); //instantiate and create dungeon object
		
		Room currentRoom = myDungeon.getRoom0(); //create currentroom object
		
		System.out.println("Find the basketball Court!"); //how to win

		System.out.println(currentRoom); //show current room
		
		dong = new Player("Dongwoo ", 30, 10, 0, 30); //create player object


		
		boolean loop = true; 
		while (loop) {	
		
		menu();
		
		String direction = input.nextLine(); //input for direction to go
		
		if ((direction.equals ("n") || direction.equals ("N")) && currentRoom.getNorth() != null) { //if input is n and isn't null
			currentRoom = currentRoom.getNorth();
			System.out.println(currentRoom);
			
			monsterOne(); 
				
		}
		
		else if ((direction.equals ("n") || direction.equals ("N")) && currentRoom.getNorth() == null) { //if input is n but unable to go to that direction
			System.out.println("You can't go that way!");
		}
		
		else if ((direction.equals ("e") || direction.equals ("E")) && currentRoom.getEast() != null) {
			currentRoom = currentRoom.getEast();
			System.out.println(currentRoom);
			
			monsterOne();
		}
		
		else if ((direction.equals ("e") || direction.equals ("E")) && currentRoom.getEast() == null) {
			System.out.println("You can't go that way!");
		}
		
		else if ((direction.equals ("w") || direction.equals ("W")) && currentRoom.getWest() != null) {
			currentRoom = currentRoom.getWest();
			System.out.println(currentRoom);
			
			monsterOne();
		}
		
		else if ((direction.equals ("w") || direction.equals ("W")) && currentRoom.getWest() == null) {
			System.out.println("You can't go that way!");
		}
		
		else if ((direction.equals ("s") || direction.equals ("S")) && currentRoom.getSouth() != null) {
			currentRoom = currentRoom.getSouth();
			System.out.println(currentRoom);
			
			monsterOne();
		}
		
		else if ((direction.equals ("s") || direction.equals ("S")) && currentRoom.getSouth() == null) {
			System.out.println("You can't go that way!");
		}
		
		else if (direction.equals ("q") || direction.equals ("Q")) {
			System.out.println("You leave the dungeon");
			loop = false;
			
		}
		else {
			System.out.println("Invalid Option");
		}
			if (currentRoom == myDungeon.basketballCourt) { //once player gets to basketballcourt they win
				loop = false;
				System.out.println("You found the basketball court! You win!");
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
	
	public static void monsterOne() {
		Random rng = new Random();
		int rng1 = rng.nextInt(3); //33% chance to find a monster

		//RandomItem item = new RandomItem();
		
		if (rng1 == 0) {

			duel();
		}
		else {
			RandomItem();
		}
			
		
	}
	
	public static void duel() {
		Scanner input = new Scanner(System.in);

		Monster goblin = new Monster("Goblin ", 30 , 5 , 0, 20); //create monster object
		
		
		System.out.println("You encounter a monster!");
		boolean loopf = true; 
		while (loopf) {
			
			System.out.println(dong);
			System.out.println(goblin);
			
			dong.takeTurn(goblin);

			int fight = input.nextInt();
			
			if (dong.health > 0 && goblin.health > 0) { //option 1: punch
				if (fight == 1) {
					dong.attack(goblin);
					System.out.println("You damage the goblin for " + dong.attackPower + " damage.");
					
					if (goblin.health > 0) { //if the goblin is still alive, it attacks
						goblin.takeTurn(dong);
					}
				}
				
				else if (fight == 2) { //option 2: fireball
					
					if (dong.getMana() >= 2) {
						dong.castSpell(goblin);
						System.out.println("You burn the goblin for " + dong.magicPower + " damage.");
						
						if (goblin.health > 0) {
							goblin.takeTurn(dong);
						}
					}
					else {
						System.out.println("You should power up first!");
					}
				}
				
				else if (fight == 3) { //option 3: powerup
					dong.chargeMana();
					System.out.println("You power your mana up!");
					goblin.takeTurn(dong);
				}
				
				else if (fight == 4) { //option 4: run
					System.out.println("Retreat!");
					
					loopf = false;
					
				}
				else {
					System.out.println("Choose a correct option, please");
				}
			}
			if (dong.health <= 0) {
				loopf = false;
				System.out.println("You died!");
			}
			
			else if (goblin.health <= 0) {
				loopf = false;
				System.out.println("You defeated the goblin!");
				
				
				System.out.println("You gain " + goblin.getxP() + " experience");
			}

		}
	}
	
	public static void RandomItem() {
		Random rng2 = new Random();
		int rng3 = rng2.nextInt(2); //two items to find
		
		
		if (rng3 == 0) {
			System.out.println("You found a sword!");
			System.out.println("It increases your attack power by 2!");
			
			dong.attackPower = dong.attackPower + 2;
			System.out.println(dong);
			
		}
		else if (rng3 == 1) {
			System.out.println("You found a potion!");
			System.out.println("It increases your health by 5!");
			
			dong.health = dong.health + 5;
			System.out.println(dong);
		}
	}

}