public class Test {

    public static void main(String[] args) {
        Character dummy = new Character("dummy", 100, 10,10,10);
        int[] statChange = {2,2,2,2};
        Move testMove = new Move("Fireball", 2, 1.0, statChange , false, 3);
        Items item = new Items(true, statChange, "potion", 2, 10);
        Items equippable = new Items(false, statChange, "sword", 1, -1);
    }
}
