/**
 * Represents a playable character in the game.
 * Has a level and xp (experience points).
 */

public class Player extends Character {
	private int xp = 0;
	private int level;
	private Move learnableMove = null;

	//Creating the possibleMoves array



	//Constructor

	public Player(int anXp, int aLevel, String aName, int anHp, int anAtk, int aDef, int aSpd) {
		super(aName, anHp, anAtk, aDef, aSpd);
		if (anXp >= 0) {
			this.xp = anXp;
		}
		if (aLevel > 0) {
			this.level = aLevel;
		}
	}
	//Getters
	/**
	 * Gets the player's level.
	 * @return the player's level.
	 */
	public int getLevel() {
		return this.level;
	}

	/**
	 * Gets the player's xp points.
	 * @return the player's xp points.
	 */
	public int getXp() {
		return this.xp;
	}

	//Methods
	/**
	 * Levels up the player.
	 * Player recieves xp when levelling up.
	 * At certain levels, player has opportunity to learn a new move.
	 */
	public void levelUp(int addXp) {
		if(level<=12){
			this.level++;
			this.xp += addXp;
			if (this.getLevel() % 3 == 0){
				Move newMove = LearnableMoves.getMove(this.getLevel()/3 -1);
				if(this.getKnownMoves() < 4){
					this.addMove(newMove);
				}
				else{
					learnableMove = newMove;
				}
			} 
		} 
	}

	public void learnMove(int i){
		if(learnableMove != null){
			this.replaceMove(i, learnableMove);
			learnableMove = null;
		}
	}

	/**
	 * Allows player to use their xp to increase their stats.
	 */
	public void allotStats(int addAtk, int addDef, int addSpeed, int addHp) {
		if (addAtk+addDef+addSpeed+addHp == xp){
			super.setAtk(super.getAtk()+addAtk);
			super.setDef(super.getDef()+addDef);
			super.setSpd(super.getSpd()+addSpeed);
			super.setMaxHp(super.getMaxHp()+addHp);
			super.setCurrentHp(super.getCurrentHp() + addHp);
			xp = 0;
		} 
	}

}
