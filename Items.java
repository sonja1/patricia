import java.util.Arrays;

public class Items {
	private final int NUMSTATS = 4;
	private boolean consumable;
	private String itemName;
	private int[] statChange = new int[NUMSTATS];
	private int effectTurns;
	private int equipmentType;
	
	public Items(boolean consumable, int[] statChange, String itemName, int effectTurnsOrType) {
		setConsumable(consumable);
		setItemName(itemName);
		setStatChange(statChange, num, num);
		if(consumable){
			effectTurns = effectTurnsOrType;
			equipmentType = -1;
		}
		else{
			effectTurns = -1;
			equipmentType = effectTurnsOrType;
		}
	}
	
	public Items(Items aCopy) {
		consumable = aCopy.consumable;
		itemName = aCopy.itemName;
		itemList = aCopy.itemList;
		statChange = aCopy.statChange;
		
	}
//setter
	public void setConsumable(boolean ifConsumable) {
		consumable = ifConsumable;
	}
	public void setItemName(String aName) {
		itemName = aName;	
	}	
	public void setEffectTurns(int change){
		if(consumable){
			effectTurns = change;
		}
	}
	public void setEquipmentType(int change){
		if(!consumable){
			equipmentType = change;
		}
	}
	public void setStatChange(int i, int change) {
		if (i<NUMSTATS) {
			newStat[i] = change;
		}
	}
	public void setStatChanges(int[] newStatChange) {
		System.arraycopy(newStatChange, 0, statChange, 0, NUMSTATS);
	}
//getter
	public boolean getConsumable() {
		return consumable;
	}
	public String getItemName() {
		return itemName;
	}
	public int getEffectDuration(){
		return effectDuration;
	}
	public int getEquipmentType(){
		return equipmentType;
	}
	public int[] getStatChange() {
		return Arrays.copyOfRange(statChange,0,NUMSTATS);;
	}
}
