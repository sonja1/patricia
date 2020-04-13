
public class PlayerBattle extends Battle{
	private Enemy enemy;
	public PlayerBattle(Player aPlayer){
		super(aPlayer, new Enemy(aPlayer));
		enemy = (Enemy)character2;
	}
	
	public void nextTurn(){
		super.nextTurn();
		while(!this.isCharacter1Turn() && enemy.chooseMove(this.getWillPower())!=-1){
				this.useMove(enemy.chooseMove(this.getWillPower()));
		}
		if(!this.isCharacter1Turn()){
			super.nextTurn();
		}
	}
	
	protected void checkState(){
		super.checkState();
		if(this.getState() == 1){
			character1.addItem(enemy.getDroppable());
		}
	}
}
