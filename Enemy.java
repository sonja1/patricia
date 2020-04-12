import java.util.ArrayList;
import java.util.Random;

/**
 * Represents an enemy in the game.
 * Child of character class, also has a tier and a droppable item.
 */

public class Enemy extends Character {
  private Items droppable;
  private int tier;
  private ArrayList<Items> droppableItems = new ArrayList<Items>();
  
  
  //Constructors
   /**
    * Creates an enemy with given tier, name, and stats.
    */

 public Enemy (Player aPlayer) {
	 super.setName("Enemy");
	 Random random = new Random();
	 int aTier = random.nextInt(3)-1;
	 this.tier = aTier;
	 this.setAtk((1+aTier/10)*aPlayer.getAtk());
	 this.setDef((1+aTier/10)*aPlayer.getDef());
	 this.setSpd((1+aTier/10)*aPlayer.getSpd());
	 this.setMaxHp((1+aTier/10)*aPlayer.getMaxHp());
	 this.setCurrentHp((1+aTier/10)*aPlayer.getMaxHp());
	 AttainableItems items = new AttainableItems()
	 this.droppable = items.getItem();
	 LearnableMoves moves = new LearnableMoves();
	 if (aPlayer.getLevel() < 4) {
		 while (this.getKnownMoves() < 2) {
			 this.addMove(moves.getMove(1)) 
		 }
		 else if (aPlayer.getLevel() < 7) {
			 while (this.getKnownMoves() < 3) {
				 this.addMove(moves.getMove(2));
			 }
		 }
		 else if (aPlayer.getLevel() < 10) {
			 while (this.getKnownMoves() < 4) {
				 this.addMove(moves.getMove(3));
			 }
		 } else {
			 while (this.getKnownmoves() < 4) {
				 this.addMove(moves.getMove(4));  
			 }
		 }
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
