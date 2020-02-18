public class Character {
  private int mp; // index 0
  private int atk; // index 1
  private int def; // index 2
  private int speed; // index 3
  private int currentHp; // index 4
  private int maxHp; // should we also have an index for this? if so, index 5
  private Move[] moves;
  
  //Constructors
  
  public Character(int anHp, int anMp, int anAtk, int aDef, int aSpeed) {
	  if (anHp > 0) {
		  maxHp = anHp;
		  currentHp = anHp;
	  }
	  if (anMp > 0) {
		  mp = anMp;
	  }
	  if (anAtk > 0) {
		  atk = anAtk;
	  }
	  if (aDef > 0) {
		  def = aDef;
	  }
	  if (aSpeed > 0) {
		  speed = aSpeed;
	  }
  }
  
  //Copy constructor
  
  public Character (Character aCharacter) {
	  this.mp = aCharacter.mp;
	  this.atk = aCharacter.atk;
	  this.def = aCharacter.def;
	  this.speed = aCharacter.speed;
	  this.currentHp =aCharacter.currentHp;
	  this.maxHp = aCharacter.maxHp;
	  this.moves = Character.moves;
  }
  
  // Getters 
  
  public int getHp() {
	  return hp;
  }
  
  public int getMaxHp() {
	  return maxHp;
  }
  
  public int getMp() {
	  return mp;
  }
  
  public int getAtk() {
	  return atk;
  }
  
  public int getDef() {
	  return def;
  }
  
  public int getSpeed() {
	  return speed;
  }
  
  public Move[] getMoves() {
	  return moves;
  }
  
  //Methods
  
  public void useMove(Move aMove, Character anAttacker) {
	  currentHp = currentHp - (aMove.getPower()*anAttacker.getAttack())/(def);
	  // this is super rough but im assuming this method being used on the character is the character getting attacked???
	  // we can come up with a better formula later tho
	  // i think there should be a multiplier before the second term that is either 0 or 1 based on whether the attack hits or not
	  // let me know what y'all think tho lol
  }
  
  public void useItem(Item anItem ) {
	  if (anItem.consumable() == true) {
		  mp += 0; // these 0s will be replaced by like idk. something to access the statChanges array
		  atk += 0; // idk how to do it rn but like. something like atk += anItem.statChanges[1] ??? idk how to write it yet
		  def += 0; // indices for each stat are listed in comments next to the instance variables
		  speed += 0;
		  currentHp += 0;
	  }
  }
  
  
  
  
  
  
 
}
