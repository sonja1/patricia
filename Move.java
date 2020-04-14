import java.util.Arrays;

/**
 * A class to manage the details and behaviours of moves that are used by characters in battles.
 */
public class Move {
	private final int NUMSTATS = 4;
	private String name;
	private int power;
	private double accuracy = 0;
	private int[] statChanges = new int[NUMSTATS];
	private boolean enemyTargetted;
	private int effectTurns;
	private int willpower;

	/**
	 * Move constructor. Creates move with the parameters specified below.
	 * @param name, willpower, enemytargetted, statChanges, effectTurns, power, accuracy are instance variables
	 * of each move.
	 */
	public Move (String name,int willpower, boolean enemyTargetted, int[] statChanges,
			int effectTurns, int power, double accuracy) {
		this.setName(name);
		this.setPower(power);
		this.setAccuracy(accuracy);
		this.setEnemyTargetted(enemyTargetted);
		this.setStatChanges(statChanges);
		this.setEffectTurns(effectTurns);
		this.setWillpower(willpower);
	}
	
	/**
	 * Copy constructor. Creates a move that is a copy of another.
	 * @param aCopy, the move which will have its information copied.
	 */
	public Move (Move copy) {
		this.setName(copy.name);
		this.setPower(copy.power);
		this.setAccuracy(copy.accuracy);
		this.setEnemyTargetted(copy.enemyTargetted);
		this.setStatChanges(copy.statChanges);
		this.setEffectTurns(copy.effectTurns);
		this.setWillpower(copy.willpower);
	}
	
	//getters and setters
	public String getName() {
		return name;
	}
	public void setName(String newName) {
		name = newName;
	}
	public int getWillpower() {
		return willpower;
	}
	public void setWillpower(int newWillpower) {
		willpower = newWillpower;
	}

	public int getPower() {
		return power; 
	}
	public void setPower(int newPower) {
		power = newPower;
	}

	public double getAccuracy() {
		return accuracy;
	}
	public void setAccuracy(double newAccuracy) {
		if(newAccuracy <= 1 && newAccuracy >= 0) {
			accuracy = newAccuracy;
		}
		else{
			accuracy=1.0;
		}
	}

	public boolean getEnemyTargetted() {
		return enemyTargetted;
	}
	public void setEnemyTargetted(boolean isEnemyTargetted) {
		enemyTargetted = isEnemyTargetted;
	}

	public int[] getStatChanges() {
		return Arrays.copyOfRange(statChanges,0,NUMSTATS);
	}
	public int getStatChange(int i) {
		return statChanges[i];	
	}
	public void setStatChanges(int[] newStatChanges) {
		System.arraycopy(newStatChanges, 0, statChanges, 0, NUMSTATS);
	}
	public void setStatChange(int i, int change) {
		if(i<NUMSTATS){
			statChanges[i] = change;
		}
	}

	public void setEffectTurns(int newEffectTurns){
		if(newEffectTurns >= 0){
			effectTurns = newEffectTurns;
		}
	}
	public int getEffectTurns(){
		return effectTurns;
	}

}
