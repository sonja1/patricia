public class Player extends Character {
  private int xp = 0;
  private int level;
  
  //Constructor
  
  public Player(String aName, int anHp, int anAtk, int aDef, int aSpeed, int anXp, int aLevel) {
	  super(String aName, int anHp, int anAtk, int aDef, int aSpeed);
	  xp = anXp;
	  level = aLevel;
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
		  this.atk += stats[0];
	      this.def += stats[1];
	      this.speed += stats[2];
	      this.maxHp += stats[3];
	      this.xp = 0;
  }
}
