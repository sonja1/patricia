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
  
  public void allotStats(int[4] stats) {
	  if (stats[0]+stats[1]+stats[2]+stats[3] == xp)
		  this.getAtk() += stats[0];
	      this.getDef() += stats[1];
	      this.getSpeed() += stats[2];
	      this.getMaxHp() += stats[3];
	      xp = 0;
  }
}
