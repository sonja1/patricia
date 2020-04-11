import java.util.ArrayList;

/**
 * Represents an enemy in the game.
 * Child of character class, also has a tier and a droppable item.
 */

public class Enemy extends Character {
  private Items droppable;
  private int tier;
  private ArrayList<Items> droppableItems = new ArrayList<Items>();
  
  Items potion = new Items("Potion", 10,true, {0,0,0,20},1,0);
  droppableItems.add(potion);
  Items superPotion = new Items("Super potion",10,true, {0,0,0,60},1,0);
  droppableItems.add(superPotion);
  Items sword = new Items("Sword",10,true, {5,0,-2,0},3,0);
  droppableItems.add(sword);
  Items shield = new Items("Shield",10,true, {0,5,-2,0},3,0);
  droppableItems.add(shield);
  Items attackBoost = new Items("Attack booster",10,true, {3,0,0,0},1,0);
  droppableItems.add(attackBoost);
  Items speed = new Items("Speed",10,true, {0,0,5,0},1,0);
  droppableItems.add(speed);
  
  //Constructors
   /**
    * Creates an enemy with given tier, name, and stats.
    */

 public Enemy (String aName, int anHp, int anAtk, int aDef, int aSpd, Items aDroppable,int aTier,) {
	  super(aName,anHp,anAtk,aDef,aSpd);
	  if (aTier == 1 || aTier == 0 || aTier == -1) {
		  this.tier = aTier;
	  }  
	  this.droppable = aDroppable; 
  }
  /**
   * Copy constructor, copies another enemy.
   */
 public Enemy (Enemy anEnemy) {
	 super(anEnemy);
	 this.tier = anEnemy.tier;
	 this.droppable = anEnemy.droppable;
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
  
  public void chooseMove(int aWillpower) {
	  ArrayList<int> list = new ArrayList<int>();
	  for (int i = 0; i < (super.getItems()).size() + 5; i++) {
		  list.add(i);
	  }
	  for (int i = 3; i > super.getKnownMoves(); i --) {
		  list.remove(i);
	  }
	  for (number: list) {
		  
	  }
  }
  
}
