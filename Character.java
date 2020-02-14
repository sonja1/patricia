public class Character {
  private int level = 1;
  private int hp = 10;
  private int mp = 10;
  private int attack = 5;
  private int defense = 5;
  private int speed = 5;
  private final int maxLevel = 10;
  private int expPoints;
  // private ArrayList<Moves> moves = new ArrayList<Moves>();
  
  public void increase(String stat, int addition) {
	  if (stat.equals("hp")) {
		  if (addition <= expPoints) {
			  hp += addition;
			  expPoints -= addition;
		  }
	  }
  }
  
  public void levelUp() {
	  if (level < maxLevel) {
		  level++;
		  expPoints = level/2;
		  increase
		  
	  }
	  
  }
  
  
  
  
 
}
