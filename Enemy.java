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
	  public Enemy (Player aPlayer) {
	        super(aPlayer);
	    		super.setName("Enemy");
	    		Random random = new Random();
	    		int aTier = random.nextInt(3)-1;
	    		this.tier = aTier;
	    		this.setAtk((int)((double)((1+ (double) aTier/10.0)*aPlayer.getAtk())));
	    		this.setDef((int)((double)((1+ (double) aTier/10.0)*aPlayer.getDef())));
	    		this.setSpd((int)((double)((1+ (double) aTier/10.0)*aPlayer.getSpd())));
	    		this.setMaxHp((int)((double)((1+ (double) aTier/10.0)*aPlayer.getMaxHp())));
	    		this.setCurrentHp((int)((double)((1+ (double) aTier/10.0)*aPlayer.getMaxHp())));
	    		this.droppable = AttainableItems.getItem();
	    		this.addMove(LearnableMoves.getMove(-1));
	    		for(int i = 0; i<aPlayer.getLevel()/3; i++) {
	    			if(this.getKnownMoves()<4) {
	    				this.addMove(LearnableMoves.getMove(i));
	    			}
	    			else {
	    				this.replaceMove(0, LearnableMoves.getMove(i));
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
		return this.tier;
	}
	
	public Items getDroppable() {
		return this.droppable;
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
		  ArrayList<Integer> list = new ArrayList<Integer>();
		  for (int i = 0; i < super.getKnownMoves(); i++) {
			  if (this.getMove(i).getWillpower() < aWillpower) {
	        list.add(i);
	      }
	    }
		  if (list.isEmpty()) {
			  return -1;
		  }
		  else { 
			  Random random = new Random();
			  return list.get(random.nextInt(list.size()));
	      
		  }
	  }

}
