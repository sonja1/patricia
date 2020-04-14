import java.util.Random;

/**
 * Class to nicely organize and manage all possible moves in the game.
 */

public abstract class LearnableMoves {
	private static final int[] tackleStats = {0,0,0,0};
	private static final Move tackle = new Move("Tackle",5,true,tackleStats,0,-40,0.8);
	private static final int[] punchStats = {0,0,-2,0};
	private static final Move punch = new Move("Punch", 12, true, punchStats , 3, -50, 0.9);
	private static final int[] kickStats = {0,-2,0,0};
	private static final Move kick = new Move("Kick", 15, true, kickStats, 5, -60, 0.8);
	private static final int[] slapStats = {0,-1,0,0};
	private static final Move slap = new Move("Slap", 10, true, slapStats, 1, -40, 1.0);
	private static final int[] danceStats = {0,-5,-3,0};
	private static final Move dance = new Move("Dance", 5, true, danceStats, 5, 0, 1.0);
	private static final int[] treatYoSelfStats = {2,2,2,10};
	private static final Move treatYoSelf = new Move("Treat yoself", 10, false, treatYoSelfStats, 5, 0, 1.0);//heals
	private static final int[] fireBallStats = {0,-5,0,0};
	private static final Move fireball = new Move("Fireball", 30, true, fireBallStats, 2, -70, 1.0);
	private static final int[] snowballStats = {0,0,-3,0};
	private static final Move snowball = new Move("Snowball", 30, true, snowballStats, 2, -70, 0.95);
	private static final int[] thunderStats = {0,0,0,0};
	private static final Move thunder = new Move("Thunder", 30, true, thunderStats, 0, -80, 0.95);
	private static final int[] healStats = {5,5,5,10};
	private static final Move heal = new Move("Heal", 20, false, healStats, 3, 30, 1.0);//heals
	private static final int[] meteorJamStats = {-2,-2,2,0};
	private static final Move meteorJam = new Move("Meteor Jam", 40, true, meteorJamStats, 1, -110, 0.9);
	private static final int[] arsonStats = {0,-4,0,0};
	private static final Move arson = new Move("Arson", 35, true, arsonStats, 3, -100, 1.0);
	private static final int[] algebra2Stats = {-2,-3,0,0};
	private static final Move algebra2 = new Move("Algebra II", 20, true, algebra2Stats, 2, -120, 0.7);
	private static final int[] tacticalBrickStats = {-2,0,0,0};
	private static final Move tacticalBrick = new Move("Tactical Brick Throw", 10, true, tacticalBrickStats, 5, -10, 1.0);
	private static final int[] spitStats = {-4,-5,0,-10};
	private static final Move spit = new Move("Spit", 20, true, spitStats, 3, 0, 1.0);
	private static final int[] thiccSkinStats = {0,5,-2,20};
	private static final Move thiccSkin = new Move("Thicc Skin", 20, false, thiccSkinStats, 4, 0, 1.0);
	private static final int[] ouchStats = {5,0,8,0};
	private static final Move ouch = new Move("Ouch", 10, false, ouchStats, 5, -10, 1.0);
	private static final Move[][] LEARNABLEMOVES = {
		{punch, kick, slap, dance},
		{treatYoSelf, fireball, snowball, thunder},
		{heal, meteorJam, arson, algebra2},
		{tacticalBrick, spit, thiccSkin, ouch}
	};
	
	/**
	 * Method to get a move based on a tier. Based on the 2d array LEARNABLEMOVES, the moves are divided
	 * among 4 "tiers" where tier 1 are the weakest moves and tier 4 are the strongest moves.
	 * @param int tier, the tier of the move, so the method randomly access moves from the specified tier.
	 */ 
	public final static Move getMove(int tier){
		if(tier >= 0 && tier<LEARNABLEMOVES.length){
			Random r = new Random();
			Move move = new Move(LEARNABLEMOVES[tier][r.nextInt(4)]);
			return move;
		}
		if(tier == -1) {
			return tackle;
		}
		return null;
	}
	
}
