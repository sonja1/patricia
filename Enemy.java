public class Enemy extends Character {
  private String type;
  private char[][] appearance; 
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
  
  public String getType() {
	  return type;
  }
  
}
