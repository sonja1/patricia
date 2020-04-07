/**
 * Represents an enemy in the game.
 * Child of character class, also has a tier and a droppable item.
 */

public class Enemy extends Character {
  //private char[][] appearance; 
  private Items droppable;
  private int tier;
  
  //Constructor
   /**
    * Creates an enemy with given tier, name, and stats.
    */
<<<<<<< HEAD
  public Enemy (int aTier, String aName, int anHp, int anAtk, int aDef, int aSpeed, Items aDroppable) {
	  super(aName,anHp,anAtk,aDef,aSpeed);
=======
  public Enemy (int aTier, String aName, int anHp, int anAtk, int aDef, int aSpd) {
	  super(aName,anHp,anAtk,aDef,aSpd);
>>>>>>> branch 'master' of https://github.com/sonja1/patricia.git
	  if (aTier == 1 || aTier == 0 || aTier == -1) {
		  tier = aTier;
	  }  
	  this.addItem(aDroppable); 
  }
  
  
  //Getters
  /**
   * Gets the enemy's tier.
   * @return the enemy's tier.
   */
  public int getTier() {
	  return tier;
  }
  
  //Setters
  /**
   * Sets the tier of the enemy, must be an integer from -1 to 1.
   */
  public void setTier(int aTier) {
	  if (aTier == 1 || aTier == 0 || aTier == -1) {
		  tier = aTier;
	  }
  }
   /**
    * Setting the enemy's stats relative to the player and the tier.
    */
  public void setStats(Player aPlayer, int aTier) {
	  int playerTotalStat = aPlayer.getAtk() + aPlayer.getDef() + aPlayer.getSpeed() + aPlayer.getMaxHp();
	  int enemyTotalStat = (1 + aTier/10)*playerTotalStat;
	  this.setAtk(enemyTotalStat/4);
	  this.setDef(enemyTotalStat/4);
	  this.setSpd(enemyTotalStat/4);
	  this.setMaxHp(enemyTotalStat/4);
	  this.setCurrentHp(enemyTotalStat/4);
  }
  
}
