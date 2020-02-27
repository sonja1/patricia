import java.util.Arrays;

public class Items {
	private final int stat = 4;
	private final int capacity = 100;
	private int num;
	private boolean consumable;
	private String itemName;
	private String[] itemList = new String[100];
	private int[] statChange = new int[stat];
	
	
	public Items(boolean consumable, String[] itemList, int[] statChange, String itemName) {
		setConsumable(consumable);
		setItemName(itemName);
		setItemList(itemList,itemName);
		setStatChange(statChange, num, num);
		
		
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
	
//I want to make it loop through the item list and select items so this is just a draft
	public void setItemList(String[] aList, String item) {
			System.arraycopy(aList, 0, aList, 0, capacity);
	}
	
	public void setStatChange(int [] newStat, int i, int change) {
		if (Arrays.asList(newStat).contains(i)) {
			newStat[i] = change;
		}
		System.arraycopy(newStat, 0, statChange, 0, stat);

	}
//getter
	public boolean getConsumable() {
		return consumable;
	}
	
	public String getItemName() {
		return itemName;
	
	}
		
		
	public String[] getItemList() {
		return itemList;
	
	}
	
	public int[] getStatChange() {
		return statChange;
	}
}
