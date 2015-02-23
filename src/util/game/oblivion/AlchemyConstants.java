/**
 * 
 */
package util.game.oblivion;

/**
 * <br>Created: Feb 25, 2009
 * @author Kenneth Pierce
 */
public final class AlchemyConstants {
	/*
	 * EFFECTS[1]="Restore Intelligence"
EFFECTS[2]="Resist Poison"
EFFECTS[3]="Light"
EFFECTS[4]="Damage Fatigue"
EFFECTS[5]="Restore Fatigue"
EFFECTS[6]="Restore Health"
EFFECTS[7]="Damage Magicka"
EFFECTS[8]="Invisibility"
EFFECTS[9]="Damage Luck"
EFFECTS[10]="Fortify Willpower"
EFFECTS[11]="Damage Health"
EFFECTS[12]="Restore Agility"
EFFECTS[13]="Fortify Strength"
EFFECTS[14]="Burden"
EFFECTS[15]="Silence"
EFFECTS[16]="Resist Disease"
EFFECTS[17]="Frost Damage"
EFFECTS[18]="Shield"
EFFECTS[19]="Fortify Agility"
EFFECTS[20]="Dispel"
EFFECTS[21]="Resist Shock"
EFFECTS[22]="Fortify Endurance"
EFFECTS[23]="Restore Magicka"
EFFECTS[24]="Chameleon"
EFFECTS[25]="Resist Paralysis"
EFFECTS[26]="Fortify Health"
EFFECTS[27]="Damage Speed"
EFFECTS[28]="Damage Personality"
EFFECTS[29]="Damage Endurance"
EFFECTS[30]="Resist Fire"
EFFECTS[31]="Fortify Luck"
EFFECTS[32]="Night-Eye"
EFFECTS[33]="Detect Life"
EFFECTS[34]="Damage Agility"
EFFECTS[35]="Damage Strength"
EFFECTS[36]="Damage Intelligence"
EFFECTS[37]="Shock Damage"
EFFECTS[38]="Fortify Intelligence"
EFFECTS[39]="Fire Shield"
EFFECTS[40]="Restore Personality"
EFFECTS[41]="Restore Endurance"
EFFECTS[42]="Reflect Spell"
EFFECTS[43]="Cure Disease"
EFFECTS[44]="Paralyze"
EFFECTS[45]="Resist Frost"
EFFECTS[46]="Fortify Magicka"
EFFECTS[47]="Shock Shield"
EFFECTS[48]="Reflect Damage"
EFFECTS[49]="Frost Shield"
EFFECTS[50]="Water Breathing"
EFFECTS[51]="Restore Luck"
EFFECTS[52]="Damage Willpower"
EFFECTS[53]="Fire Damage"
EFFECTS[54]="Feather"
EFFECTS[55]="Fortify Fatigue"
EFFECTS[56]="Restore Speed"
EFFECTS[57]="Cure Poison"
EFFECTS[58]="Water Walking"
EFFECTS[59]="Fortify Personality"
EFFECTS[60]="Cure Paralysis"
EFFECTS[61]="Restore Willpower"
EFFECTS[62]="Restore Strength"
EFFECTS[63]="Drain Health"
EFFECTS[64]="Drain Fatigue"
EFFECTS[65]="Drain Agility"
EFFECTS[66]="Drain Speed"
EFFECTS[67]="Fortify Speed"
	 */
	private static final String[] EFFECTS = new String[] {
		"NONE",
		"Restore Intelligence",
		"Resist Poison",
		"Light",
		"Damage Fatigue",
		"Restore Fatigue",
		"Restore Health",
		"Damage Magicka",
		"Invisibility",
		"Damage Luck",
		"Fortify Willpower",
		"Damage Health",
		"Restore Agility",
		"Fortify Strength",
		"Burden",
		"Silence",
		"Resist Disease",
		"Frost Damage",
		"Shield",
		"Fortify Agility",
		"Dispel",
		"Resist Shock",
		"Fortify Endurance",
		"Restore Magicka",
		"Chameleon",
		"Resist Paralysis",
		"Fortify Health",
		"Damage Speed",
		"Damage Personality",
		"Damage Endurance",
		"Resist Fire",
		"Fortify Luck",
		"Night-Eye",
		"Detect Life",
		"Damage Agility",
		"Damage Strength",
		"Damage Intelligence",
		"Shock Damage",
		"Fortify Intelligence",
		"Fire Shield",
		"Restore Personality",
		"Restore Endurance",
		"Reflect Spell",
		"Cure Disease",
		"Paralyze",
		"Resist Frost",
		"Fortify Magicka",
		"Shock Shield",
		"Reflect Damage",
		"Frost Shield",
		"Water Breathing",
		"Restore Luck",
		"Damage Willpower",
		"Fire Damage",
		"Feather",
		"Fortify Fatigue",
		"Restore Speed",
		"Cure Poison",
		"Water Walking",
		"Fortify Personality",
		"Cure Paralysis",
		"Restore Willpower",
		"Restore Strength",
		"Drain Health",
		"Drain Fatigue",
		"Drain Agility",
		"Drain Speed",
		"Fortify Speed"
	};
	public static final int
		NONE = 0,
		BURDEN=14,
		CHAMELEON=24,
		CURE_DISEASE=43,
		CURE_PARALYSIS=60,
		CURE_POISON=57,
		DAMAGE_AGILITY=34,
		DAMAGE_ENDURANCE=29,
		DAMAGE_FATIGUE=4,
		DAMAGE_HEALTH=11,
		DAMAGE_INTELLIGENCE=36,
		DAMAGE_LUCK=9,
		DAMAGE_MAGICKA=7,
		DAMAGE_PERSONALITY=28,
		DAMAGE_SPEED=27,
		DAMAGE_STRENGTH=35,
		DAMAGE_WILLPOWER=52,
		DETECT_LIFE=33,
		DISPEL=20,
		DRAIN_AGILITY=65,
		DRAIN_FATIGUE=64,
		DRAIN_HEALTH=63,
		DRAIN_SPEED=66,
		FEATHER=54,
		FIRE_DAMAGE=53,
		FIRE_SHIELD=39,
		FORTIFY_AGILITY=19,
		FORTIFY_ENDURANCE=22,
		FORTIFY_FATIGUE=55,
		FORTIFY_HEALTH=26,
		FORTIFY_INTELLIGENCE=38,
		FORTIFY_LUCK=31,
		FORTIFY_MAGICKA=46,
		FORTIFY_PERSONALITY=59,
		FORTIFY_SPEED=67,
		FORTIFY_STRENGTH=13,
		FORTIFY_WILLPOWER=10,
		FROST_DAMAGE=17,
		FROST_SHIELD=49,
		INVISIBILITY=8,
		LIGHT=3,
		NIGHT_EYE=32,
		PARALYZE=44,
		REFLECT_DAMAGE=48,
		REFLECT_SPELL=42,
		RESIST_DISEASE=16,
		RESIST_FIRE=30,
		RESIST_FROST=45,
		RESIST_PARALYSIS=25,
		RESIST_POISON=2,
		RESIST_SHOCK=21,
		RESTORE_AGILITY=12,
		RESTORE_ENDURANCE=41,
		RESTORE_FATIGUE=5,
		RESTORE_HEALTH=6,
		RESTORE_INTELLIGENCE=1,
		RESTORE_LUCK=51,
		RESTORE_MAGICKA=23,
		RESTORE_PERSONALITY=40,
		RESTORE_SPEED=56,
		RESTORE_STRENGTH=62,
		RESTORE_WILLPOWER=61,
		SHIELD=18,
		SHOCK_DAMAGE=37,
		SHOCK_SHIELD=47,
		SILENCE=15,
		WATER_BREATHING=50,
		WATER_WALKING=58,
		FIRST_EFFECT=1,
		LAST_EFFECT=EFFECTS.length-1;
	public static final String[] getEffectList() {
		return EFFECTS.clone();
	}
	public static final String getEffectString(int effect) {
		if (effect<0 || effect>=EFFECTS.length) return "";
		return EFFECTS[effect];
	}
}
