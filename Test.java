public class Test {

    public static void main(String[] args) {
    	  Character dummy = new Character("dummy", 100, 10,10,10);
          Character dummyEnemy = new Character("dummy enemy", 100, 10, 10, 10);
          int[] statChange = {-2,-2,-2,0};
          int[] statChangeSword = {2,0,-1,0};
          int[] statChangePotion = {0,0,0,0};
          Move testMove = new Move("Fireball", 2, 1.0, statChange,false, 3);
          Items item = new Items(true, statChangePotion, "potion", 2, 10);
          Items equippable = new Items(false, statChangeSword, "sword", 1, -1);

          System.out.println(dummy.toString());

          //adding an item to inventory
          dummy.addItem(item);
          System.out.println("Adding an item to the inventory:");
          System.out.println(dummy.toString());

          //learning a Move
          dummy.addMove(testMove);
          System.out.println("Adding a move:");
          System.out.println(dummy.toString());

          //using the move on the dummyEnemy
          System.out.println("Enemy initial information:");
          System.out.println(dummyEnemy.toString());
          dummyEnemy.useMove(testMove, dummy);
          System.out.println("Enemy information after being attacked:");
          System.out.println(dummyEnemy.toString());
          System.out.println("Dummy player information after attacking:");
          System.out.println(dummy.toString());

          //equipping an item
          dummy.addItem(equippable);
          System.out.println("Dummy player adding a new item to inventory:");
          System.out.println(dummy.toString());
          dummy.useItem(1);
          System.out.println("Dummy player equipping the equippable item:");
          System.out.println(dummy.toString());
          dummy.unequip(1);
          System.out.println("Dummy player unequipping the equippable item:");
          System.out.println(dummy.toString());

          //enemy gets a potion and heals himself
          dummyEnemy.addItem(item);
          System.out.println("Enemy's information after gaining an item:");
          System.out.println(dummyEnemy.toString());
          dummyEnemy.useItem(0);
          System.out.println("Enemy's information after using its item:");
          System.out.println(dummyEnemy.toString());
        
        
        
        
    }
}
