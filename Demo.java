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
	  int[] item1StatChanges = {0,0,0,10};
	  int[] item2StatChanges = {0,0,0,20};
	  String[] itemList = new String[100];
	  Items dummyItem1 = new Items(true,itemList,item1StatChanges,"dummy item 1");
	  Items dummyItem2 =  new Items(true,itemList,item2StatChanges,"dummy item 2");
	  
	  //Getting the player's initial stats 
	  System.out.print("Would you like to view the dummy player's stats? yes or no: ");
	  if ((keyboard.next()).equals("yes")) {
		  System.out.println("Initial attack: "+ dummyPlayer.getAtk());
		  System.out.println("Initial defense: "+ dummyPlayer.getDef());
		  System.out.println("Initial speed: "+ dummyPlayer.getSpeed());
		  System.out.println("Initial max HP: "+dummyPlayer.getMaxHp());
	  }
	  
	  
	  //Getting the initial level and xp
	  System.out.print("Would you like to view the dummy player's current level and xp? yes or no: ");
	  if ((keyboard.next()).equals("yes")) {
		  System.out.println("Level: "+dummyPlayer.getLevel());
		  System.out.println("xp: "+ dummyPlayer.getXp());
	  }
	  
	  
	  //Levelling up the player and seeing the changes to xp and level - user input for xp gain
	  System.out.print("Would you like to level up the dummy player? yes or no: ");
	  if ((keyboard.next()).equals("yes")) {
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
			  System.out.println("Please allot all of your available xp to your stats.");
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
		  
		  System.out.print("Would you like to view the dummy player's new stats? yes or no: ");
		  if ((keyboard.next()).equals("yes")) {
			  System.out.println("New attack: "+ dummyPlayer.getAtk());
			  System.out.println("New defense: "+ dummyPlayer.getDef());
			  System.out.println("New speed: "+ dummyPlayer.getSpeed());
			  System.out.println("New max HP: "+ dummyPlayer.getMaxHp());
			  System.out.println("New current HP: "+ dummyPlayer.getCurrentHp());
			  System.out.println("xp: "+ dummyPlayer.getXp());
		  }
	  }
	  
	  
	  //Player gets attacked by an enemy :(
	  System.out.println("Now we will have a dummy enemy use the move on the player.");
	  int expectedDecreaseInHp = (dummyMove.getPower()*dummyEnemy.getAtk())/(dummyPlayer.getDef());
	  System.out.println("The current HP should decrease by "+ expectedDecreaseInHp + ", or until it reaches 0.");
	  dummyPlayer.useMove(dummyMove,dummyEnemy);
	  System.out.print("Would you like to view the dummy player's current HP after being attacked? yes or no: ");
	  if ((keyboard.next()).equals("yes")) {
		  System.out.println("Current HP: "+ dummyPlayer.getCurrentHp());
	  }
	  
	  // Give the user an opportunity to heal themselves
	  
	  System.out.print("The dummy character's HP has been reduced :( would you like to heal them? yes or no: ");
		  if ((keyboard.next()).equals("yes")) {
			  System.out.println("Item 1 will increase the HP by "+ item1StatChanges[3]);
			  System.out.println("Item 2 will increase the HP by "+ item2StatChanges[3]);
			  System.out.print("Which item would you like to use? 1 or 2: ");
			  if (keyboard.nextInt() == 1) {
				  dummyPlayer.useItem(dummyItem1);
				  dummyItem1.setConsumable(false);
			  }
			  else if (keyboard.nextInt() == 2) {
				  dummyPlayer.useItem(dummyItem2);
				  dummyItem2.setConsumable(false);
			  }
			  System.out.print("So nice of you to heal the dummy player. Would you like to take a look at their healed HP? yes or no: ");
			  if ((keyboard.next()).equals("yes")) {
				  System.out.println("Current HP: "+ dummyPlayer.getCurrentHp());
			  }
			  if (dummyPlayer.getCurrentHp() < dummyPlayer.getMaxHp()) {
				  System.out.println("Would you like to use another item to further heal the dummy player? yes or no: ");
				  if ((keyboard.next()).equals("yes")) {
					  if (dummyItem1.getConsumable() == false) {
						  System.out.println("You only have item 2 available, so it is used. This will add a maximum of "+ item2StatChanges[3] + " HP");
						  dummyPlayer.useItem(dummyItem2);
						  System.out.println("Current HP: "+ dummyPlayer.getCurrentHp());
					  } else {
						  System.out.println("You only have item 1 available, so it is used. This will add a maximum "+ item1StatChanges[3] + " HP");
						  dummyPlayer.useItem(dummyItem1);
						  System.out.println("Current HP: "+ dummyPlayer.getCurrentHp());
						  
					  }
					  
				  }
			  }
			  
			 

		  }
	 System.out.println("Demo complete."); 
  }
}
