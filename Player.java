public class Player extends Character {
  private int xp = 0;
  private int level;
  
  //Constructor
  
  public Player(String aName, int anHp, int anAtk, int aDef, int aSpeed, int anXp, int aLevel) {
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
		  atk = this.getAtk() + stats[0];
	      def = this.getDef() + stats[1];
	      speed = this.getSpeed() + stats[2];
	      maxHp = this.getMaxHp() + stats[3];
	      xp = 0;
  }
}
