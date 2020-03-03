import java.util.ArrayList;

public class Character {

	private String name;
	private int atk; // index 0
	private int def; // index 1
	private int speed; // index 2
	private int currentHp; // index 3
	private int maxHp; 
	private Move[] moves;
	private ArrayList<Items> items = new ArrayList<Items>();
	private final int EQUIPSLOTS = 6;
	private Items[] equipped = new Items[EQUIPSLOTS];
	private ArrayList<int[]> tempStatChanges = new ArrayList<int[]>();


	//Constructors

	public Character(String aName, int anHp, int anAtk, int aDef, int aSpeed) {
		name = aName;
		if (anHp > 0) {
			maxHp = anHp;
			currentHp = anHp;
		}
		if (anAtk > 0) {
			atk = anAtk;
		}
		if (aDef > 0) {
			def = aDef;
		}
		if (aSpeed > 0) {
			speed = aSpeed;
		}
	}

	//Copy constructor

	public Character (Character aCharacter) {
		this.name = aCharacter.name;
		this.atk = aCharacter.atk;
		this.def = aCharacter.def;
		this.speed = aCharacter.speed;
		this.currentHp =aCharacter.currentHp;
		this.maxHp = aCharacter.maxHp;
		this.moves = aCharacter.moves;
		this.items = aCharacter.items;
	}

	// Getters

	public String getName() {
		return name;
	}
	public int getCurrentHp() {
		return currentHp;
	}

	public int getMaxHp() {
		return maxHp;
	}

	public int getAtk() {
		return atk;
	}

	public int getDef() {
		return def;
	}

	public int getSpeed() {
		return speed;
	}

	public Move[] getMoves() {
		return moves;
	}

	//Setters

	public void setName(String aName) {
		name = aName;
	}
	public void setCurrentHp(int aCurrentHp) {
		currentHp = aCurrentHp;
	}

	public void setMaxHp(int aMaxHp) {
		maxHp = aMaxHp;
	}

	public void setAtk(int anAtk) {
		atk = anAtk;
	}

	public void setDef(int aDef) {
		def = aDef;
	}

	public void setSpeed(int aSpeed) {
		speed = aSpeed;
	}


	//Methods

	public void useMove(Move aMove, Character user) {
		if(aMove.getPower()>=0){
			currentHp = currentHp - (aMove.getPower()*user.getAtk())/(def);
		}
		else{
			currentHp = currentHp - (aMove.getPower()*user.getAtk());
		}
		if (currentHp < 0) {
			currentHp = 0;
		}
		int[] moveStatChanges = aMove.getStatChanges();
		atk += moveStatChanges[0];
		def += moveStatChanges[1];
		speed += moveStatChanges[2];
		maxHp += moveStatChanges[3]; 
	}

	//Use item not in inventory
	public void useItem(Items anItem) {
			int[] statChange = anItem.getStatChange();
			atk += statChange[0];
			def += statChange[1];
			speed += statChange[2];
			maxHp += statChange[3];
			if (anItem.getPower() >= this.getMaxHp()-this.getCurrentHp()) {
				currentHp = this.getMaxHp();
			}
			else {
				currentHp += anItem.getPower();
			}
			//if(anItem.isConsumable()){	
			//}
	}
	
	public void useItem(int i){
		if(i < items.size()){
			this.useItem(items.get(i));
			if(items.get(i).isConsumable()){
				items.remove(i);
			}
			else{
				unequip(items.get(i).getEquipmentType());
				equipped[items.get(i).getEquipmentType()] = items.get(i);
				items.remove(i);
			}
		}
	}
	public void unequip(int i){
		if(i<EQUIPSLOTS && equipped[i]!=null){
			int[] statChange = anItem.getStatChange();
			atk-= statChange[0];
			def-= statChange[1];
			speed-= statChange[2];
			maxHp -= statChange[3];
			items.add(equipped[i]);
			equipped[i] = null;
		}
	}
}
