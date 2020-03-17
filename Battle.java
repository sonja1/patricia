public class Battle {
	private Character character1;
	private Character character2;
	private int state;
	int speed1;
	int speed2;
	
	public Battle(Character aCharacter1, Character aCharacter2) {
		this.character1 = character1;
		this.character2 = character2;
		this.speed1 = character1.getSpeed();
		this.speed2 = character2.getSpeed();
		this.state = 1;
		if (speed1 < speed2) {
			this.state = -1;
		}
	}
	
	public void initiateBattle() {
		int one = 1;
	}
	
	public int BattleState() {
		return 0;
	}
	
	public void characterUseItem(int anItem) {
		int one = 1;
	}
	
	public void characterUseMove(int aMove) {
		int one = 1;
	}
}
