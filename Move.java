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
	/**
	 * Returns the name of the move.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name of the move.
	 * @param newName,the string representing the move's new name.
	 */
	public void setName(String newName) {
		name = newName;
	}
	
	/**
	 * Returns the willpower of the move.
	 */
	public int getWillpower() {
		return willpower;
	}
	
	/**
	 * Setter for the willpower of a move.
	 * @param newWillpower, an integer representing the new willpower of a move.
	 */
	public void setWillpower(int newWillpower) {
		willpower = newWillpower;
	}
	
	/**
	 * Returns the power of a move.
	 */

	public int getPower() {
		return power; 
	}
	
	/**
	 * Setter for the power of a move.
	 * @param newPower, the integer value of the new power of the move.
	 */
	public void setPower(int newPower) {
		power = newPower;
	}
	
	/**
	 * Returns the accuracy of a move.
	 */
	public double getAccuracy() {
		return accuracy;
	}
	
	/**
	 * Setter for the accuracy of the move.
	 * @param newAccuracy, a double value between 0 and 1 representing how accurate a move is.
	 */
	public void setAccuracy(double newAccuracy) {
		if(newAccuracy <= 1 && newAccuracy >= 0) {
			accuracy = newAccuracy;
		}
		else{
			accuracy=1.0;
		}
	}
	
	/**
	 * Returns the boolean representing whether the enemy is targetted or not.
	 */

	public boolean getEnemyTargetted() {
		return enemyTargetted;
	}
	
	/**
	 * Setter for the boolean of whether the enemy is targetted or not.
	 * @param the boolean isEnemyTargetted, which will represent if the enemy is targetted or not.
	 */
	public void setEnemyTargetted(boolean isEnemyTargetted) {
		enemyTargetted = isEnemyTargetted;
	}
	
	/**
	 * Returns the stat change array of the move. Each index of the array corresponds to a particular stat.
	 */
	public int[] getStatChanges() {
		return Arrays.copyOfRange(statChanges,0,NUMSTATS);
	}
	
	/**
	 * Returns the stat change for a particular stat based on the index provided.
	 * @param the index of the stat in question/
	 */
	public int getStatChange(int i) {
		return statChanges[i];	
	}
	
	/**
	 * Setter for entire stat change array.
	 * @param a new statchange array, where each index corresponds to a change to a specific stat.
	 */
	public void setStatChanges(int[] newStatChanges) {
		System.arraycopy(newStatChanges, 0, statChanges, 0, NUMSTATS);
	}
	
	/**
	 * Setter for a particular stat change.
	 * @param i, the index of the stat, and change, the integer value of the stat change.
	 */
	public void setStatChange(int i, int change) {
		if(i<NUMSTATS){
			statChanges[i] = change;
		}
	}
	
	/**
	 * 
	 */

	public void setEffectTurns(int newEffectTurns){
		if(newEffectTurns >= 0){
			effectTurns = newEffectTurns;
		}
	}
	public int getEffectTurns(){
		return effectTurns;
	}

}
