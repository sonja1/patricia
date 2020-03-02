import java.util.Arrays;

public class Move {
	private final int NUMSTATS = 4;
	private String name;
	private int power;
	private double accuracy = 0;
	private int[] statChanges = new int[NUMSTATS];
	private boolean enemyTargetted;
	private int effectTurns;
	
	public Move (String name, int power, double accuracy, 
			int[] statChanges, boolean enemyTargetted, int effectTurns) {
		this.setName(name);
		this.setPower(power);
		this.setAccuracy(accuracy);
		this.setEnemyTargetted(enemyTargetted);
		this.setStatChanges(statChanges);
		this.setEffectTurns(effectTurns);
	}
	//getters and setters
	public String getName() {
		return name;
	}
	public void setName(String newName) {
		name = newName;
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
	public void setStatChange(int change, int i) {
		statChanges[i] = change;
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
