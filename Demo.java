import java.util.Scanner;

public class Demo {
  public static void main(String[] args) {
	  //Setting dummy character, enemy, move, and 
	  Player dummyPlayer = new Player("dummy player",10,11,12,13,0,1);
	  
	  //Getting the maximum HP
	  
	  System.out.println(dummyPlayer.getMaxHp());
	  
	  //Getting the initial level and xp
	  
	  System.out.println("Level: "+dummyPlayer.getLevel());
	  System.out.println("xp: "+ dummyPlayer.getXp());
	  
	  //Levelling up the player and seeing the changes to xp and level
	  
	  dummyPlayer.levelUp(4);
	  System.out.println("Level: "+dummyPlayer.getLevel());
	  System.out.println("xp: "+ dummyPlayer.getXp());
	  
	  
	  //Move dummyMove = new Move("dummy move",20,1.0, [0,0,0,0], dummy);
	  
	  
  }
}
