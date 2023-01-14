
public class Monster extends GameCharacter {
	
	private int xP;
	
	public Monster(String name, int health, int attackPower, int magicPower, int xP) {
		super(name, health, attackPower, magicPower);
		this.xP = xP;
	}
	
	public void attack(Player thePlayer) {
		thePlayer.takeDamage(this.attackPower);
	}	
	
	public void takeTurn(Player thePlayer) {
		System.out.println("The monster attacks!");
		attack(thePlayer);
	
	}
	
	public int getxP() {
		return this.xP;
	}
	
	@Override
	public String toString() {
		
		String val = super.toString();
		
		val += " XP:" + xP;
		return val;
	}
}