public class Player extends Character {
  private int xp = 0;
  private int level;
  
  //Methods
  
  public void levelUp(int addXp) {
	  level++;
	  xp += addXp;
  }
  
  public void allotStats(int[] stats) {
	  if (stats[0]+stats[1]+stats[2]+stats[3] == xp)
		  atk += stats[0];
	      def += stats[1];
	      speed += stats[2];
	      maxHp += stats[3];
	      xp = 0;
  }
}
