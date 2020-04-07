import java.util.Scanner;

public class BattleTest {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		Character dummy1 = new Character("dummy1", 50, 10,10,10);
		Character dummy2 = new Character("dummy2", 90, 16,10,10);
		int[] moveStatChange = {0,-2,0,-10};
		int[] itemStatChange = {0,4,0,0};
		int[] equipStatChange = {2,0,0,0};
		Move testMove = new Move("Fireball",40, true, moveStatChange, 3, 2,   1.0);
		Items item = new Items("potion",30, true, itemStatChange, 2, 10);
		Items equippable = new Items("sword",0, false, equipStatChange,  1, -1);
		dummy1.addMove(testMove);
		dummy1.addItem(item);
		dummy1.addItem(item);
		dummy1.addItem(item);
		dummy1.addItem(equippable);
		dummy2.addMove(testMove);
		dummy2.addItem(item);
		dummy2.addItem(item);
		dummy2.addItem(item);
		dummy2.addItem(equippable);
		Battle battle = new Battle(dummy1,dummy2);
		System.out.println(dummy1);
		System.out.println();
		System.out.println(dummy2);
		System.out.println(battle.getWillPower());
		int input = kb.nextInt();
		while(battle.getState()==0){
			if(input == 0){
				battle.useMove(0);
			}
			else if(input == 1){
				battle.useItem(0);
			}
			if(input == 2){
				battle.useItem(1);
			}
			if(input == 3){
				battle.useItem(2);
			}
			if(input == 4){
				battle.useItem(3);
			}
			if(input == 5){
				battle.nextTurn();
			}
			System.out.println(battle.getState());
			if(battle.isCharacter1Turn()){
				System.out.println("CURRENT TURN");
			}
			System.out.println(dummy1);
			System.out.println();
			if(!battle.isCharacter1Turn()){
				System.out.println("CURRENT TURN");
			}
			System.out.println(dummy2);
			System.out.println(battle.getWillPower());
			input = kb.nextInt();
		}
		if(battle.getState() ==1){
			System.out.println("dummy1 Wins");
		}
		else if(battle.getState() ==-1){
			System.out.println("dummy2 Wins");
		}
		kb.close();
	}

}
