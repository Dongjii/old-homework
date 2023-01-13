import java.util.Scanner;

public class Player extends GameCharacter{
	
	private int mana;
	
	public Player(String name, int health, int attackPower, int mana, int magicPower) {
		super(name, health, attackPower, magicPower);
		this.mana = mana;

	}
	
	public void attack(Monster theMonster) {
		theMonster.takeDamage(this.attackPower);
	}
	
	public void castSpell(Monster theMonster) {
		theMonster.takeDamage(this.magicPower);
		mana = mana - 2;
	}
	
	public void chargeMana() {
		this.mana += 1;
	}
	
	public void takeTurn(Monster theMonster) {
		System.out.println("What do you want to do?");
		System.out.println("1) Jet Pistol Punch");
		System.out.println("2) Fireball jutsu");
		System.out.println("3) PowerUp");
		System.out.println("4) Run back!");
		
	}
	
	public int getMana(){
		return this.mana;
	}
	
	@Override
	public String toString() {
		
		String val = super.toString();
		
		val += " Mana: " + mana;
		return val;
	}
	
}