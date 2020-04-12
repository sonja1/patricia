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
  
  Items potion = new Items("Potion", 10,true, {0,0,0,20},1,0);
  droppableItems.add(0,potion);
  Items superPotion = new Items("Super potion",10,true, {0,0,0,60},1,0);
  droppableItems.add(5,potion);
  Items sword = new Items("Sword",10,true, {5,0,-2,0},3,0);
  droppableItems.add(4,potion);
  Items shield = new Items("Shield",10,true, {0,5,-2,0},3,0);
  droppableItems.add(3,potion);
  Items attackBoost = new Items("Attack booster",10,true, {3,0,0,0},1,0);
  droppableItems.add(2,potion);
  Items speed = new Items("Speed",10,true, {0,0,5,0},1,0);
  droppableItems.add(1,potion);
  Items key = new Items("Key", 0, false,  {0,0,0,0,}, 1, 0};
  droppableItems.add(6,potion);
  
  
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
	 LearnableMoves moves = new LearnableMoves();
	 if (aPlayer.getLevel() < 12) {
		 this.droppable = droppableItems(random.nextInt(6));
	 }
	 else {
		 this.droppable = droppableItems(random.nextInt(4)+3);
	 }
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
