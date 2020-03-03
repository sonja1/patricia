import java.util.Random;
import java.util.Scanner;

public class Battle {
  
	//Constructors but tbh im not sure what else we need for this :/
	public Battle(Player aPlayer, Enemy anEnemy)) {
		Move[] usablePlayerMoves = aPlayer.getMoves();
		Move[] enemyMoves = anEnemy.getMoves();
		Scanner keyboard = new Scanner(System.in);
		Random r = new Random();
		if (aPlayer.getSpeed() > anEnemy.getSpeed()) {
			while (aPlayer.getCurrentHp() > 0 && anEnemy.CurrentHp() > 0) {
				System.out.println("Select a move");
				for (Move aMove : usablePlayerMoves) {
					if ((keyboard.next()).equals(aMove.getName())) {
						anEnemy.useMove(aMove);
					}
				}
				if (anEnemy.getCurrentHp() > 0) {
					Move enemyMove = r.next();
					aPlayer.useMove(enemyMove); 		
			    }
		    }
	    }
		
	}
}
