
public class GameCharacter {
	
	protected String name;
	protected int health;
	protected int attackPower;
	protected int magicPower;
	
	public GameCharacter(String name, int health, int attackPower, int magicPower) {
		this.name = name;
		this.health = health;
		this.attackPower = attackPower;
		this.magicPower = magicPower;
	}
	
	public void takeDamage(int takeDamage) { //whenever a character takes damage
		health -= takeDamage;		
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getAttackPower() {
		return this.attackPower;
	}
	
	public int getHealth() {
		return this.health;
	}
	
	@Override
	public String toString() {
		
		String val = "";
		
		val += "Name: " + name;
		val += " Health: " + health;
		val += " Attack Power: " + attackPower;
		val += " Magic Power: " + magicPower;
		return val;
	}

}