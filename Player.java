public class Player extends Character {
  private int xp = 0;
  private int level;
  
  //Constructor
  
  public Player(int anXp, int aLevel, String aName, int anHp, int anAtk, int aDef, int aSpeed) {
	  super(aName, anHp, anAtk, aDef, aSpeed);
	  if (anXp >= 0) {
		  xp = anXp;
	  }
	  if (aLevel > 0) {
		  level = aLevel;
	  }
  }
  //Getters
  
  public int getLevel() {
	  return level;
  }
  
  public int getXp() {
	  return xp;
  }
  //Methods
  
  public void levelUp(int addXp) {
	  level++;
	  xp += addXp;
  }
  
  public void allotStats(int addAtk, int addDef, int addSpeed, int addHp) {
	  if (addAtk+addDef+addSpeed+addHp == xp)
		  super.setAtk(super.getAtk()+addAtk);
	      super.setDef(super.getDef()+addDef);
	      super.setSpeed(super.getSpeed()+addSpeed);
	      super.setMaxHp(super.getMaxHp()+addHp);
	      super.setCurrentHp(super.getCurrentHp() + addHp);
	      xp = 0;
  }
}
