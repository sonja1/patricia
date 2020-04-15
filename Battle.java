public class Battle {
	protected Character character1;
	protected Character character2;
	private Character currentCharacter;
	private Character otherCharacter;
	private boolean character1Turn;// true if character1's turn false if character2's turn
	private int state=0; //0 if game is running, 1 if player1 won, -1 if player 2 won.
	private int willpower; //available actions of the current player

	public Battle(Character aCharacter1, Character aCharacter2) {
		this(aCharacter1, aCharacter2, true);
		this.nextTurn();
	}
	protected Battle(Character aCharacter1, Character aCharacter2, boolean differentiate) {
		character1 = aCharacter1;
		character2 = aCharacter2;
		if(character1.getSpd()>=character2.getSpd()){
			character1Turn = false;
		}
		else{
			character1Turn = true;
		}
	}
	public void nextTurn(){
		if(character1Turn){
			character1Turn = false;
			character2.statsNextTurn();
			currentCharacter = character2;
			otherCharacter = character1;
		}
		else{
			character1Turn = true;
			character1.statsNextTurn();
			currentCharacter = character1;
			otherCharacter = character2;
		}
		willpower = (currentCharacter.getSpd()*10 + (currentCharacter.getMaxHp()-currentCharacter.getCurrentHp()))/2;
	}
	protected void checkState(){
		if(character1.getCurrentHp()<=0){
			state = -1;
		}
		else if(character2.getCurrentHp()<=0){
			state = 1;
		}
		else if(willpower<=0){
			this.nextTurn();
		}
		System.out.println(state);
	}
	
	public void useMove(int moveIndex){
		if(currentCharacter.getKnownMoves() > moveIndex){
			Move move = currentCharacter.getMove(moveIndex);
			if(willpower-move.getWillpower()>=0){
				if(move.getEnemyTargetted()){
					otherCharacter.useMove(move, currentCharacter);
				}
				else{
					currentCharacter.useMove(move,currentCharacter);
				}
				willpower-= move.getWillpower();
			}		
		}
		this.checkState();
	}
	public void useItem(int itemIndex){
		if(currentCharacter.getItems().size()>itemIndex){
			int itemWillpower = currentCharacter.getItem(itemIndex).getWillpower();
			if(willpower-itemWillpower>=0){
				willpower -= itemWillpower;
				currentCharacter.useItem(itemIndex);
			}
		}
		this.checkState();
	}
	public void unequip(int equipIndex){
		currentCharacter.unequip(equipIndex);
	}
	
	public int getState(){
		return state;
	}
	public boolean isCharacter1Turn(){
		return character1Turn;
	}
	public int getWillPower(){
		return willpower;
	}
	
}
