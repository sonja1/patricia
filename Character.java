import java.util.ArrayList;

public class Character {

  private String name;
  private int atk; // index 0
  private int def; // index 1
  private int speed; // index 2
  private int currentHp; // index 3
  private int maxHp; 
  private Move[] moves;
  private ArrayList<Item> items = new ArrayList<Item>();
  private Item[] equipped;


  //Constructors

  public Character(String aName, int anHp, int anAtk, int aDef, int aSpeed) {
	  name = aName;
	  if (anHp > 0) {
		  maxHp = anHp;
		  currentHp = anHp;
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
      this.name = aCharacter.name;
	  this.atk = aCharacter.atk;
	  this.def = aCharacter.def;
	  this.speed = aCharacter.speed;
	  this.currentHp =aCharacter.currentHp;
	  this.maxHp = aCharacter.maxHp;
	  this.moves = aCharacter.moves;
	  this.items = aCharacter.items;
  }

  // Getters

  public String getName() {
	  return name;
  }
  public int getCurrentHp() {
	  return currentHp;
  }

  public int getMaxHp() {
	  return maxHp;
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

  //do we need setters for this lol


  //Methods

  public void useMove(Move aMove, Character anAttacker) {
	  currentHp = currentHp - (aMove.getPower()*anAttacker.getAtk())/(def);
	  // this is super rough but im assuming this method being used on the character is the character getting attacked???
	  // we can come up with a better formula later tho
	  // i think there should be a multiplier before the second term that is either 0 or 1 based on whether the attack hits or not
	  // let me know what y'all think tho lol
	  atk += aMove.statChanges[0];
	  def += aMove.statChanges[1];
	  speed += aMove.statChanges[2];
	  currentHp += aMove.statChanges[3]; //lmao pls tell me this is how u access an index
  }

  public void useItem(Items anItem) {
	  if (anItem.getConsumable() == true) {
		  atk += anItem.statChange[0];
		  def += anItem.statChange[1];
		  speed += anItem.statChange[2];
		  currentHp += anItem.statChange[3];
		  items.remove(anItem);
	  }
  }









}
