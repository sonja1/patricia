import java.util.Arrays;

public class Items {
	private final int NUMSTATS = 4;
	private final int EQUIPSLOTS = 6;
	private int power;
	private boolean consumable;
	private String itemName;
	private int[] statChange = new int[NUMSTATS];
	private int effectTurns;
	private int equipmentType;
	
	public Items(boolean consumable, int[] statChange, String itemName, int effectTurnsOrType, int power) {
		setConsumable(consumable);
		setName(itemName);
		setStatChanges(statChange);
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
	
	public Items(Items aCopy) {
		consumable = aCopy.consumable;
		itemName = aCopy.itemName;
		statChange = aCopy.statChange;
		
	}
//setter
	public void setConsumable(boolean ifConsumable) {
		consumable = ifConsumable;
	}
	public void setName(String aName) {
		itemName = aName;	
	}	
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
//getter
	public boolean isConsumable() {
		return consumable;
	}
	public String getName() {
		return itemName;
	}
	public int getEffectDuration(){
		return effectTurns;
	}
	public int getEquipmentType(){
		return equipmentType;
	}
	public int[] getStatChange() {
		return Arrays.copyOfRange(statChange,0,NUMSTATS);
	}
	public int getPower(){
		return power;
	}
}
