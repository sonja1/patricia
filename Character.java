import java.util.ArrayList;

/**
 * Represents a character in the RPG game.
 * A character has their own stats, battle abilities, and can use/store items
 */

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
	
	/**
	 * Creates a new character with the given name and stats, which must be positive values.
	 * @param aName: a name for the character; anHp, anAtk, aDef, aSpeed: an hp stat, an attack stat, a defense stat, and a speed stat for the character, respectively.
	 * All of these must be positive integers.
	 */
	public Character(String aName, int anHp, int anAtk, int aDef, int aSpeed) {
		name = aName;
		if (anHp > 1) {
			maxHp = anHp;
			currentHp = anHp;
		}
		else {
			maxHp = 1;
			currentHp = 1;
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
	
	/**
	 * Creates a new character that replicates the information of an existing character.
	 * @param aCharacter, a character whos information to copy
	 */
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
	
	/**
	 * Gets the name of the character.
	 * @return this character's name.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Gets the current HP of the character.
	 * @return this character's current HP.
	 */
	public int getCurrentHp() {
		return currentHp;
	}
	
	/**
	 * Gets the maximum HP of the character.
	 * @return this character's maximum HP.
	 */
	public int getMaxHp() {
		return maxHp;
	}
	
	/**
	 * Gets the attack stat of the character.
	 * @return this character's attack stat.
	 */

	public int getAtk() {
		return atk;
	}
	
	/**
	 * Gets the defense stat of the character.
	 * @return this character's defense stat.
	 */

	public int getDef() {
		return def;
	}

    /**
     * Gets the speed of the character.
     * @return this character's speed.
     */
	public int getSpd() {
		return spd;
	}
	
	/**
	 * Gets the moves of the character.
	 * @return this character's array of moves.
	 */
	public Move[] getMoves() {
		return moves;
	}
	
	/**
	 * Gets the item inventory of the character.
	 * @return this character's array of items.
	 */
	public ArrayList<Items> getItems(){
		return inventory;
	}
	
	/**
	 * Gets a particular item from the character's inventory.
	 * @param itemIndex, the index of the item in the array.
	 * @return one of the items in the inventory.
	 */
	public Items getItem(int itemIndex){
		if(inventory.size()>itemIndex){
			return inventory.get(itemIndex);
		}
		else{
			return null;
		}
	}
	
	/**
	 * Get a particular move the character knows.
	 * @param moveIndex, the index of the move in the move array
	 * @return one of the moves in the character's move array.
	 */
	public Move getMove(int moveIndex){
		if(knownMoves>moveIndex){
			return moves[moveIndex];
		}
		else{
			return null;
		}
	}
	
	/**
	 * Gets the number of moves the character knows.
	 * @return this number.
	 */
	public int getKnownMoves(){
		return knownMoves;
	}

	//Setters
	
	
	/**
	 * Setting the name for the character.
	 * @param aName, a name for the character.
	 */
	public void setName(String aName) {
		name = aName;
	}
	
	/**
	 * Setting the current HP of the character
	 * @param a positive integer aCurrentHp representing the the character's current health.
	 */
	public void setCurrentHp(int aCurrentHp) {
		if (aCurrentHp > 0 ) {
			currentHp = aCurrentHp;
		}
	}
	
	/**
	 * Setting the maximum HP of the character, making sure its not less than the current HP.
	 * @param aMaxHp, an integer that must be greater than 1.
	 */
	public void setMaxHp(int aMaxHp) {
		if(aMaxHp>1){
			maxHp = aMaxHp;
		}
		else{
			maxHp = 1;
		}
		if(currentHp>maxHp){
			currentHp=maxHp;
		}
	}
	
	/**
	 * Setting the attack stat of the character.
	 * @param anAtk, a positive integer that will represent the character's attack.
	 */
	public void setAtk(int anAtk) {
		if(anAtk>1){
			atk = anAtk;
		}
		else{
			atk = 1;
		}
	}
	
	/**
	 * Setting the defense of the character.
	 * @param aDef, a positive integer that will represent the character's defense.
	 */
	public void setDef(int aDef) {
		if(aDef>1){
			def = aDef;
		}
		else{
			def=1;
		}
	}
	
	/**
	 * Setting the speed of the character.
	 * @param aSpd, a positive integer that will represent the character's speed.
	 */
	public void setSpd(int aSpd) {
		if(aSpd>1){
			spd = aSpd;
		}
		else{
			spd = 1;
		}
		
	}
	
	/**
	 * Adding an item to the character's inventory.
	 * @param anItem, the item that will be added to the inventory.
	 */

	public void addItem(Items anItem){
		inventory.add(anItem);
	}
	
	/**
	 * Adding a move to the character's move array, i.e learning a move.
	 * @param the move to be learned.
	 */
	public void addMove(Move aMove){
		if(knownMoves<moves.length){
			moves[knownMoves] = aMove;
			knownMoves++;
		}
	}
	
	/**
	 * Replacing a move in the move array if character wants to learn new one but has full array.
	 * @param i, the index of the move to be replaced, and aMove, the new move.
	 */
	public void replaceMove(int i, Move aMove){
		if(i<NUMMOVES){
			moves[i] = aMove;
		}
	}

	//Methods

	public void useMove(Move aMove, Character user) {
		int[] statChange = aMove.getStatChanges();
		setAtk(atk+statChange[0]);
		setDef(def+statChange[1]);
		setSpd(spd+statChange[2]);
		setMaxHp(maxHp+statChange[3]); 
		if(aMove.getPower()>=0){
			currentHp = currentHp - (aMove.getPower()*user.getAtk())/(def);
		}
		else{
			currentHp = currentHp - (aMove.getPower()*user.getAtk());
		}
		if (currentHp < 0) {
			currentHp = 0;
		}
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