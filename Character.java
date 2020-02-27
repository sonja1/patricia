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
	  int[] moveStatChanges = aMove.getStatChanges();
	  atk += moveStatChanges[0];
	  def += moveStatChanges[1];
	  speed += moveStatChanges[2];
	  currentHp += moveStatChanges[3]; /
  }

  public void useItem(Items anItem) {
	  if (anItem.getConsumable() == true) {
		  int[] statChange = anItem.getStatChange();
		  atk += statChange[0];
		  def += statChange[1];
		  speed += statChange[2];
		  currentHp += statChange[3];
		  items.remove(anItem);
	  }
  }









}
