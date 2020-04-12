import java.util.Random;

public abstract class AttainableItems {
	
	private static final int[] potionStats = {0,0,0,20};
	private static final Items potion = new Items("Potion", 10,true,potionStats ,1,0);
	private static final int[] superPotionStats = {0,0,0,60};
	private static final Items superPotion = new Items("Super potion",10,true, superPotionStats,1,0);
	private static final int[] swordStats = {5,0,-1,0};
	private static final Items sword = new Items("Sword",0,true, swordStats,3,0);
	private static final int[] shieldStats = {0,5,-2,0};
	private static final Items shield = new Items("Shield",0,true, shieldStats,2,0);
	private static final int[] attackBoostStats = {3,0,0,0};
	private static final Items attackBoost = new Items("Attack booster",10,true, attackBoostStats,1,0);
	private static final int[] speedStats = {0,0,5,0};
	private static final Items speed = new Items("Speed",10,true, speedStats,1,0);
	private static final int[] jamStats = {5,0,4,0};
	private static final Items jam = new Items("Jam",10,true, jamStats,4,30);
	private static final int[] peanutButterStats = {5,4,0,0};
	private static final Items peanutButter = new Items("Peanut Butter",10,true, peanutButterStats,4,30);
	private static final int[] magicSpatulaStats = {5,0,2,-5};
	private static final Items magicSpatula = new Items("Magic Spatula",0,false, magicSpatulaStats,3,0);
	private static final int[] yeezyStats = {0,0,6,0};
	private static final Items yeezys = new Items("Magic Spatula",0,false, yeezyStats,1,0);
	private static final int[] wizardHatStats = {8,0,0,-20};
	private static final Items wizardHat = new Items("Bartholomew's Spiky Wizard Hat",0,false, wizardHatStats,6,0);
	private static final int[] khakiShortsStats = {0,-2,8,0};
	private static final Items khakiShorts = new Items("Gilgamesh the Mighty's Khaki Shorts",0,false, khakiShortsStats,4,0);
	private static final int[] bathRobeStats = {0,8,0,-15};
	private static final Items bathRobe = new Items("Gwydion's Bath Robe",0,false, bathRobeStats,5,0);
	private static final int[] potLidStats = {0,2,0,0};
	private static final Items potLid = new Items("Measely Pot Lid",0,false, potLidStats,2,0);
	private static final int[] twigStats = {10,0,4,0};
	private static final Items twig =  new Items("just a twig",0,false, twigStats,3,0);
	
	private static final Items[] ATTAINABLEITEMS = {
			potion,potion,potion,potion,
			superPotion, attackBoost,attackBoost,attackBoost,
			speed,speed,speed,jam,
			jam,peanutButter,peanutButter,sword,
			shield,magicSpatula,yeezys,wizardHat,
			khakiShorts,bathRobe,potLid,twig
	};
	
	public final static Items getItem(){
		Random r = new Random();
		Items item = new Items(ATTAINABLEITEMS[r.nextInt(ATTAINABLEITEMS.length)]);
		return item;
	}
}
