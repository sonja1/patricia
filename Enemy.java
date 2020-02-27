public class Enemy extends Character {
  private char[][] appearance; 
  private Item droppable;
  private int tier;
  
  //Constructor
  
  public Enemy (int aTier, String aName, int anHp, int anAtk, int aDef, int aSpeed) {
	  super(aName,anHp,anAtk,aDef,aSpeed);
	  tier = aTier;  
  }
  
  
  //Getters
  
  public int getTier() {
	  return tier;
  }
  
  //Setters
  
  public void setTier(int aTier) {
	  if (aTier > 0) {
		  tier = aTier;
	  }
  }
  
}
