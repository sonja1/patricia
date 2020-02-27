public class Enemy extends Character {
  private String type;
  private char[][] appearance; // we'll deal with this later when we do the graphic user interface???
  private Item droppable;
  private int tier;
  
  //Constructor
  
  public Enemy (int aTier) {
	  
  }
  
  //Copy constructor
  
  //Getters
  
  public int getTier() {
	  return tier;
  }
  
}
