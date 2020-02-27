import java.util.Scanner;

public class Demo {
  public static void main(String[] args) {
	  //Setting up scanner
	  Scanner keyboard = new Scanner(System.in);
	  
	  //Setting dummy player, enemy, move, item
	  Player dummyPlayer = new Player(0,1, "dummy player",10,11,12,13);
	  Enemy dummyEnemy = new Enemy(1,"dummy enemy", 10,12,10,12);
	  int[] moveStatChanges = {0,0,0,0};
	  Move dummyMove = new Move("dummy move",20,1.0, moveStatChanges,true);
	  
	  
	  //Getting the player's initial stats 
	  System.out.println("Initial attack: "+ dummyPlayer.getAtk());
	  System.out.println("Initial defense: "+ dummyPlayer.getDef());
	  System.out.println("Initial speed: "+ dummyPlayer.getSpeed());
	  System.out.println("Initial max HP: "+dummyPlayer.getMaxHp());
	  
	  
	  //Getting the initial level and xp
	  
	  System.out.println("Level: "+dummyPlayer.getLevel());
	  System.out.println("xp: "+ dummyPlayer.getXp());
	  
	  //Levelling up the player and seeing the changes to xp and level - user input for xp gain
	  System.out.print("The player is levelling up. How much xp should they gain? ");
	  int addXp = keyboard.nextInt();
	  dummyPlayer.levelUp(addXp);
	  System.out.println("Level: "+dummyPlayer.getLevel());
	  System.out.println("xp: "+ dummyPlayer.getXp());
	  
	  //Allotting xp to the player's stats and showing it
	  
	  int addAtk = 0;
	  int addDef = 0;
	  int addSpeed = 0;
	  int addHp = 0;
	  
	  while (addAtk+addDef+addSpeed+addHp != dummyPlayer.getXp()) {
		  System.out.print("How much to add to attack stat? ");
		  addAtk = keyboard.nextInt();
		  System.out.print("How much to add to defense stat? ");
		  addDef = keyboard.nextInt();
		  System.out.print("How much to add to speed stat? ");
		  addSpeed = keyboard.nextInt();
		  System.out.print("How much to add to max hp? ");
		  addHp = keyboard.nextInt();
	  }
	  
	  dummyPlayer.allotStats(addAtk,addDef,addSpeed,addHp);
	  System.out.println("Stats have been allotted as the player levelled up.");
	  
	  System.out.println("New attack: "+ dummyPlayer.getAtk());
	  System.out.println("New defense: "+ dummyPlayer.getDef());
	  System.out.println("New speed: "+ dummyPlayer.getSpeed());
	  System.out.println("New max HP: "+ dummyPlayer.getMaxHp());
	  System.out.println("New current HP: "+ dummyPlayer.getCurrentHp());
	  System.out.println("xp: "+ dummyPlayer.getXp());
	 
	  
	  //Player gets attacked by an enemy :(
	  System.out.println("Now we will have the enemy use the move on the player.");
	  int expectedDecreaseInHp = (dummyMove.getPower()*dummyEnemy.getAtk())/(dummyPlayer.getDef());
	  System.out.println("The current HP should decrease by "+ expectedDecreaseInHp);
	  dummyPlayer.useMove(dummyMove,dummyEnemy);
	  System.out.println("Current HP: "+ dummyPlayer.getCurrentHp());
  }
}
