import java.util.Arrays;

/**
 * Class for items, i.e characteristics and behaviours of in-game items.
 */

public class Items {
	private final int NUMSTATS = 4;
	private final int EQUIPSLOTS = 6;
	private int power;
	private boolean consumable;
	private String itemName;
	private int[] statChange = new int[NUMSTATS];
	private int effectTurns;
	private int equipmentType;
	private int willpower;
	
	/**
	 * Item constructor. Makes an item.
	 * @param itemName, willpower, consumable, statChange, effectTurnsOrType are the instance variables of
	 * each item. The constructor makes an item with the specifications of the parameters.
	 */
	public Items(String itemName,int willpower, boolean consumable, int[] statChange,  int effectTurnsOrType, int power) {
		setConsumable(consumable);
		setName(itemName);
		setStatChanges(statChange);
		this.setWillpower(willpower);
		if(consumable){
			setEffectTurns(effectTurnsOrType);
			setEquipmentType(-1);
			setPower(power);
		}
		else{
			setEffectTurns(-1);
			setEquipmentType(effectTurnsOrType);
			setPower(0);
		}
	}
	/**
	 * Copy constructor.
	 * @param Items aCopy, an item to copy the information of.
	 */
	public Items(Items aCopy) {
		consumable = aCopy.consumable;
		itemName = aCopy.itemName;
		statChange = aCopy.statChange;
		
	}
//setter
	/**
	 * Setter method for whether or not the item is consumable.
	 * @param ifConsumable, a boolean that determines whether or not the item can be consumed by a character.
	 */
	public void setConsumable(boolean ifConsumable) {
		consumable = ifConsumable;
	}
	
	/**
	 * Setter method for the name of an item.
	 * @param a string aName which will be the name of the item.
	 */
	public void setName(String aName) {
		itemName = aName;	
	}	
	
	/**
	 * Setter method for the amount of turns the item takes effect if used in battle.
	 * @param an integer change representing the amount of turns the changes due to the item will occur.
	 */
	public void setEffectTurns(int change){
		if(consumable){
			effectTurns = change;
		}
	}

	public void setEquipmentType(int change){
		if(!consumable){
			if(change<EQUIPSLOTS && change>=0){
				equipmentType = change;
			}
			else{
				equipmentType =0;
			}
		}
	}
	
	/**
	 * Setter method for the 
	 */
	public void setStatChange(int i, int change) {
		if (i<NUMSTATS) {
			statChange[i] = change;
		}
	}
	public void setStatChanges(int[] newStatChange) {
		System.arraycopy(newStatChange, 0, statChange, 0, NUMSTATS);
	}
	public void setPower(int change){
		power = change;
	}
	public void setWillpower(int change){
		willpower = change;
	}
	
//getter
	/**
	 * Returns boolean value representing whether or not the item in question is consumable.
	 */
	public boolean isConsumable() {
		return consumable;
	}
	
	/**
	 * Returns the name of the item.
	 */
	public String getName() {
		return itemName;
	}
	
	/**
	 * Returns the amount of turns the effect of the item lasts.
	 */
	public int getEffectDuration(){
		return effectTurns;
	}
	
	/**
	 * Returns the equipment type of the item.
	 */
	public int getEquipmentType(){
		return equipmentType;
	}
	
	/**
	 * Returns the stat changes induced by the item, based on an array in which the indices 0,1,2,3 correspond
	 * to attack, defense, speed, and HP stats respectively.
	 */
	public int[] getStatChange() {
		return Arrays.copyOfRange(statChange,0,NUMSTATS);
	}
	
	/**
	 * Returns the power of an item.
	 */
	public int getPower(){
		return power;
	}
	/**
	 * Returns the willpower of an item.
	 */
	public int getWillpower(){
		return willpower;
	}
}
