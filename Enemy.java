public class Enemy extends Character {
  private char[][] appearance; 
  private Items droppable;
  private int tier;
  
  //Constructor
  
  public Enemy (int aTier, String aName, int anHp, int anAtk, int aDef, int aSpeed) {
	  super(aName,anHp,anAtk,aDef,aSpeed);
	  tier = aTier;  
  }
  
  
  //Getters
  
  public int getTier() {
	  return tier;
  }
  
  //Setters
  
  public void setTier(int aTier) {
	  if (aTier > 0) {
		  tier = aTier;
	  }
  }
  
  public void setStats(Player aPlayer, int aTier) {
	  int playerTotalStat = aPlayer.getAtk() + aPlayer.getDef() + aPlayer.getSpeed() + aPlayer.getMaxHp();
	  int enemyTotalStat = (1 + (aTier*playerTotalStat)/10);
	  this.setAtk(enemyTotalStat/4);
	  this.setDef(enemyTotalStat/4);
	  this.setSpeed(enemyTotalStat/4);
	  this.setMaxHp(enemyTotalStat/4);
	  this.setCurrentHp(enemyTotalStat/4)
  }
  
}
