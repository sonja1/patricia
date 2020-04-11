/**
 * Represents a playable character in the game.
 * Has a level and xp (experience points).
 */

public class Player extends Character {
  private int xp = 0;
  private int level;
  private Move[][] possibleMoves = new Move[4][4];
  private Move LearnableMove = null;
  
   //Creating the possibleMoves array
  Move punch = new Move("Punch", 70, true, {0,0,-2,0}, 3, 50, 0.9);
  possibleMoves[0][0].add(punch);
  Move kick = new Move("Kick", 80, true, {0,-2,0,0}, 5, 60, 0.8);
  possibleMoves[0][1].add(kick);
  Move slap = new Move("Slap", 50, true, {0,-1,0,0}, 1, 40, 1.0);
  possibleMoves[0][2].add(slap);
  Move dance = new Move("Dance", 10, true, {0,-5,-3,0}, 5, 0, 1.0);
  possibleMoves[0][3].add(dance);
  Move treatYoSelf = new Move("Treat yoself", 70, false, {2,2,2,10}, 5, 0, 1.0);//heals
  possibleMoves[1][0].add(treatYoSelf);
  Move fireball = new Move("Fireball", 100, true, {0,-5,0,0}, 2, 70, 1.0);
  possibleMoves[1][1].add(fireball);
  Move snowball = new Move("Snowball", 100, true, {0,0,-3,0}, 2, 70, 0.95);
  possibleMoves[1][2].add(snowball);
  Move thunder = new Move("Thunder", 100, true, {0,0,0,0}, 0, 80, 0.95);
  possibleMoves[1][3].add(thunder);
  Move heal = new Move("Heal", 10, false, {5,5,5,30}, 5, 0, 1.0);//heals
  possibleMoves[2][0].add(heal);
  Move meteorJam = new Move("Meteor Jam", 130, true, {-2,-2,2,0}, 1, 110, 0.9);
  possibleMoves[2][1].add(meteorJam);
  Move arson = new Move("Arson", 130, true, {0,-4,0,0}, 3, 100, 1.0);
  possibleMoves[2][2].add(arson);
  Move algebra2 = new Move("Algebra II", 130, true, {-2,-3,0,0}, 2, 120, 0.7);
  possibleMoves[2][3].add(algebra2);
  Move heal = new Move("Tactical Brick Throw", 30, true, {-5,0,0,0}, 5, -10, 1.0);
  possibleMoves[3][0].add(heal);
  Move meteorJam = new Move("", 130, true, {-2,-2,2,0}, 1, 110, 0.9);
  possibleMoves[3][1].add(meteorJam);
  Move arson = new Move("", 130, true, {0,-4,0,0}, 3, 100, 1.0);
  possibleMoves[3][2].add(arson);
  Move algebra2 = new Move("", 130, true, {-2,-3,0,0}, 2, 120, 0.7);
  possibleMoves[3][3].add(algebra2);
  
  
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
	  this.level++;
	  this.xp += addXp;
	  if (this.getLevel() % 3 == 0) {
		  Move newMove = possibleMoves[this.level][i];
		  if (super.getKnownMoves() < (super.getMoves()).length) {
			  super.addMove(newMove);
		  } else {
			  super.replaceMove(newMove);
		  }
  }
  
  /**
   * Allows player to use their xp to increase their stats.
   */
  public void allotStats(int addAtk, int addDef, int addSpeed, int addHp) {
	  if (addAtk+addDef+addSpeed+addHp == xp)
		  super.setAtk(super.getAtk()+addAtk);
	      super.setDef(super.getDef()+addDef);
	      super.setSpd(super.getSpeed()+addSpeed);
	      super.setMaxHp(super.getMaxHp()+addHp);
	      super.setCurrentHp(super.getCurrentHp() + addHp);
	      xp = 0;
  }
  
  
  }
   
}
