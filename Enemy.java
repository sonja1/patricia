import java.util.ArrayList;
import java.util.Random;

/**
 * Represents an enemy in the game.
 * Child of character class, also has a tier and a droppable item.
 */

public class Enemy extends Character {
  private Items droppable;
  private int tier;
  
  //Constructors
   /**
    * Creates an enemy with given tier, name, and stats.
    */

 public Enemy (int aTier, Player aPlayer) {
	 this.setAtk((1+aTier/10)*aPlayer.getAtk());
	 this.setDef((1+aTier/10)*aPlayer.getDef());
	 this.setSpd((1+aTier/10)*aPlayer.getSpd());
	 this.setMaxHp((1+aTier/10)*aPlayer.getMaxHp());
	 this.setCurrentHp((1+aTier/10)*aPlayer.getMaxHp());
	 
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
    * Enemy randomly chooses move based on willpower.
    * @param aWillpower, an integer. Enemy cannot use moves that require more willpower than the input.
    */
  public int chooseMove(int aWillpower) {
	  ArrayList<int> list = new ArrayList<int>();
	  for (int i = 0; i < super.getKnownMoves(); i++) {
		  list.add(i);
	  }
	  for (number : list) {
		  if ((super.getMove(number)).getWillpower() > aWillpower) {
			  list.remove(number);
		  }
	  }
	  if (list.size() == 0) {
		  return -1;
	  }
	  else {
		  Random random = new Random();
		  return list.get(random.nextInt(list.size())); // 
	  }
  }
  
}
