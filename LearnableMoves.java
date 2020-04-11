import java.util.Random;

public abstract class LearnableMoves {
	private static final int[] punchStats = {0,0,-2,0};
	private static final Move punch = new Move("Punch", 70, true, punchStats , 3, -50, 0.9);
	private static final int[] kickStats = {0,-2,0,0};
	private static final Move kick = new Move("Kick", 80, true, kickStats, 5, -60, 0.8);
	private static final int[] slapStats = {0,-1,0,0};
	private static final Move slap = new Move("Slap", 50, true, slapStats, 1, -40, 1.0);
	private static final int[] danceStats = {0,-5,-3,0};
	private static final Move dance = new Move("Dance", 10, true, danceStats, 5, 0, 1.0);
	private static final int[] treatYoSelfStats = {2,2,2,10};
	private static final Move treatYoSelf = new Move("Treat yoself", 70, false, treatYoSelfStats, 5, 0, 1.0);//heals
	private static final int[] fireBallStats = {0,-5,0,0};
	private static final Move fireball = new Move("Fireball", 100, true, fireBallStats, 2, -70, 1.0);
	private static final int[] snowballStats = {0,0,-3,0};
	private static final Move snowball = new Move("Snowball", 100, true, snowballStats, 2, -70, 0.95);
	private static final int[] thunderStats = {0,0,0,0};
	private static final Move thunder = new Move("Thunder", 100, true, thunderStats, 0, -80, 0.95);
	private static final int[] healStats = {5,5,5,10};
	private static final Move heal = new Move("Heal", 10, false, healStats, 3, 30, 1.0);//heals
	private static final int[] meteorJamStats = {-2,-2,2,0};
	private static final Move meteorJam = new Move("Meteor Jam", 130, true, meteorJamStats, 1, -110, 0.9);
	private static final int[] arsonStats = {0,-4,0,0};
	private static final Move arson = new Move("Arson", 130, true, arsonStats, 3, -100, 1.0);
	private static final int[] algebra2Stats = {-2,-3,0,0};
	private static final Move algebra2 = new Move("Algebra II", 130, true, algebra2Stats, 2, -120, 0.7);
	private static final int[] tacticalBrickStats = {-5,0,0,0};
	private static final Move tacticalBrick = new Move("Tactical Brick Throw", 5, true, tacticalBrickStats, 5, -10, 1.0);
	private static final int[] spitStats = {-4,-5,0,-10};
	private static final Move spit = new Move("Spit", 130, true, spitStats, 3, 0, 1.0);
	private static final int[] thiccSkinStats = {0,5,-2,20};
	private static final Move thiccSkin = new Move("Thicc Skin", 130, false, thiccSkinStats, 4, 0, 1.0);
	private static final int[] ouchStats = {5,0,8,0};
	private static final Move ouch = new Move("Ouch", 20, false, ouchStats, 5, -10, 1.0);
	private static final Move[][] LEARNABLEMOVES = {
		{punch, kick, slap, dance},
		{treatYoSelf, fireball, snowball, thunder},
		{heal, meteorJam, arson, algebra2},
		{tacticalBrick, spit, thiccSkin, ouch}
	};
	public final static Move getMove(int tier){
		if(tier<LEARNABLEMOVES.length){
			Random r = new Random();
			Move move = new Move(LEARNABLEMOVES[tier][r.nextInt(4)]);
			return move;
		}
		return null;
	}
	
}
