import java.util.ArrayList;

public class Character {
	private final int EQUIPSLOTS = 6;
	private final int NUMMOVES = 4;

	private String name;
	private int atk; // index 0
	private int def; // index 1
	private int spd; // index 2
	private int currentHp; // index 3
	private int maxHp; 
	private Move[] moves = new Move[NUMMOVES];
	private int knownMoves = 0;
	private ArrayList<Items> inventory = new ArrayList<Items>();
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
			spd = aSpeed;
		}
	}

	//Copy constructor

	public Character (Character aCharacter) {
		this.name = aCharacter.name;
		this.atk = aCharacter.atk;
		this.def = aCharacter.def;
		this.spd = aCharacter.spd;
		this.currentHp =aCharacter.currentHp;
		this.maxHp = aCharacter.maxHp;
		this.moves = aCharacter.moves;
		this.inventory = aCharacter.inventory;
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
		return spd;
	}

	public Move[] getMoves() {
		return moves;
	}

	public int getKnownMoves(){
		return knownMoves;
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
		spd = aSpeed;
	}

	public void addItem(Items anItem){
		inventory.add(anItem);
	}
	public void addMove(Move aMove){
		if(knownMoves<moves.length){
			moves[knownMoves] = aMove;
			knownMoves++;
		}
	}
	public void replaceMove(int i, Move aMove){
		if(i<NUMMOVES){
			moves[i] = aMove;
		}
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
		int[] statChange = aMove.getStatChanges();
		atk += statChange[0];
		def += statChange[1];
		spd += statChange[2];
		maxHp += statChange[3]; 
		this.addTempChange(aMove.getEffectTurns(), statChange);
	}

	//Use item not in inventory
	public void useItem(Items anItem) {
		int[] statChange = anItem.getStatChange();
		atk += statChange[0];
		def += statChange[1];
		spd += statChange[2];
		maxHp += statChange[3];
		if (anItem.getPower() >= this.getMaxHp()-this.getCurrentHp()) {
			currentHp = this.getMaxHp();
		}
		else {
			currentHp += anItem.getPower();
		}
		if(anItem.isConsumable()){	
			this.addTempChange(anItem.getEffectDuration(), statChange);
		}
	}

	public void useItem(int i){
		if(i < inventory.size()){
			this.useItem(inventory.get(i));
			if(inventory.get(i).isConsumable()){
				inventory.remove(i);
			}
			else{
				unequip(inventory.get(i).getEquipmentType());
				equipped[inventory.get(i).getEquipmentType()] = inventory.get(i);
				inventory.remove(i);
			}
		}
	}
	public void unequip(int i){
		if(i<EQUIPSLOTS && equipped[i]!=null){
			int[] statChange = equipped[i].getStatChange();
			atk-= statChange[0];
			def-= statChange[1];
			spd-= statChange[2];
			maxHp -= statChange[3];
			inventory.add(equipped[i]);
			equipped[i] = null;
		}
	}

	public void addTempChange(int duration, int[] statChange){
		if(duration > 0){
			int[] tempStatChange = new int[5];
			for(int i = 0; i<statChange.length; i++){
				tempStatChange[i] = statChange[i];
			}
			tempStatChange[tempStatChange.length-1] = duration;
			tempStatChanges.add(tempStatChange);
		}
	}
	public void statsNextTurn(){
		for(int i = 0; i<tempStatChanges.size(); i++){
			int[] statChange = tempStatChanges.get(i);
			statChange[statChange.length-1] -= 1;
			if(statChange[statChange.length-1] <= 0){
				atk-= statChange[0];
				def-= statChange[1];
				spd-= statChange[2];
				maxHp -= statChange[3];
				if(currentHp>maxHp){
					currentHp = maxHp;
				}
				tempStatChanges.remove(i);
			}
		}
	}

	public String toString(){
		String stringMoves = "[";
		for(int i = 0; i<moves.length; i++){
			if(moves[i] != null){
				stringMoves += moves[i].getName();
			}
			else{
				stringMoves+= "Not Learnt";
			}
			if(i != moves.length -1){
				stringMoves += ", ";
			}
		}
		stringMoves+= "]";
		String stringEquipped = "[";
		for(int i = 0; i<equipped.length; i++){
			if(equipped[i] != null){
				stringEquipped += equipped[i].getName();
			}
			else{
				stringEquipped+= "Nothing";
			}
			if(i != equipped.length -1){
				stringEquipped += ", ";
			}
		}
		stringEquipped+= "]";

		String stringInventory = "[";
		for(int i = 0; i<inventory.size(); i++){
			stringInventory += inventory.get(i).getName();
			if(i != inventory.size() -1){
				stringInventory += ", ";
			}
		}
		stringInventory += "]";

		return ("Name: " + name + 
				"\nSTATS\nHP:" + currentHp + "/" + maxHp + "\natk:" + atk +" def:" + def + " spd:" + spd + 
				"\nMOVES\n" + stringMoves +
				"\nEQUIPPED\n" + stringEquipped +
				"\nINVENTORY\n" + stringInventory);
	}
}