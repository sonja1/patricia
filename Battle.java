public class Battle {
	private boolean character1sTurn;
	private Character character1;
	private Character character2;
	
	public Battle(Character aCharacter1, Character aCharacter2) {
		this.character1 = character1;
		this.character2 = character2;
		this.character1sTurn = true;
		if (aCharacter1.getSpeed() < aCharacter2.getSpeed()) {
			this.character1sTurn = false;
		}
	}
	
 
}
