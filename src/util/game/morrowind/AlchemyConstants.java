/**
 * 
 */
package util.game.morrowind;

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
		"Blind",
		"Burden",
		"Chameleon",
		"Cure Blight Disease",
		"Cure Common Disease",
		"Cure Paralysis",
		"Cure Poison",
		"Damage Agility",
		"Damage Endurance",
		"Damage Fatigue",
		"Damage Health",
		"Damage Intelligence",
		"Damage Luck",
		"Damage Magicka",
		"Damage Personality",
		"Damage Speed",
		"Damage Strength",
		"Damage Willpower",
		"Detect Animal",
		"Detect Enchantment",
		"Detect Key",
		"Dispel",
		"Drain Agility",
		"Drain Alteration",
		"Drain Endurance",
		"Drain Fatigue",
		"Drain Health",
		"Drain Intellegence",
		"Drain Luck",
		"Drain Magicka",
		"Drain Personality",
		"Drain Speed",
		"Drain Strength",
		"Drain Willpower",
		"Feather",
		"Fire Damage",
		"Fire Shield",
		"Fortify Agility",
		"Fortify Attack",
		"Fortify Endurance",
		"Fortify Fatigue",
		"Fortify Health",
		"Fortify Intelligence",
		"Fortify Luck",
		"Fortify Magicka",
		"Fortify Max Magicka",
		"Fortify Personality",
		"Fortify Speed",
		"Fortify Strength",
		"Fortify Willpower",
		"Frost Damage",
		"Frost Shield",
		"Invisibility",
		"Levitate",
		"Light",
		"Night-Eye",
		"Paralyze",
		"Poison",
		"Recall",
		"Reflect",
		"Resist Blight Disease",
		"Resist Common Disease",
		"Resist Fire",
		"Resist Frost",
		"Resist Magicka",
		"Resist Paralysis",
		"Resist Poison",
		"Resist Shock",
		"Restore Agility",
		"Restore Endurance",
		"Restore Fatigue",
		"Restore Health",
		"Restore Intelligence",
		"Restore Luck",
		"Restore Magicka",
		"Restore Personality",
		"Restore Speed",
		"Restore Strength",
		"Restore Willpower",
		"Shield",
		"Shock Damage",
		"Shock Shield",
		"Silence",
		"Spell Absorption",
		"Swift Swim",
		"Telekinesis",
		"Vampirism",
		"Water Breathing",
		"Water Walking",
		"Weakness to Fire"
	};
	public static final int
	NONE = 0,
	BLIND=1,
	BURDEN=2,
	CHAMELEON=3,
	CURE_BLIGHT_DISEASE=4,
	CURE_COMMON_DISEASE=5,
	CURE_PARALYSIS=6,
	CURE_POISON=7,
	AGILITY_DAMAGE=8,
	ENDURANCE_DAMAGE=9,
	FATIGUE_DAMAGE=10,
	HEALTH_DAMAGE=11,
	INTELLIGENCE_DAMAGE=12,
	LUCK_DAMAGE=13,
	MAGICKA_DAMAGE=14,
	PERSONALITY_DAMAGE=15,
	SPEED_DAMAGE=16,
	STRENGTH_DAMAGE=17,
	WILLPOWER_DAMAGE=18,
	DETECT_ANIMAL=19,
	DETECT_ENCHANTMENT=20,
	DETECT_KEY=21,
	DISPEL=22,
	AGILITY_DRAIN=23,
	DRAIN_ALTERATION=24,
	ENDURANCE_DRAIN=25,
	FATIGUE_DRAIN=26,
	HEALTH_DRAIN=27,
	INTELLEGENCE_DRAIN=28,
	LUCK_DRAIN=29,
	MAGICKA_DRAIN=30,
	PERSONALITY_DRAIN=31,
	SPEED_DRAIN=32,
	STRENGTH_DRAIN=33,
	WILLPOWER_DRAIN=34,
	FEATHER=35,
	FIRE_DAMAGE=36,
	FIRE_SHIELD=37,
	AGILITY_FORTIFY=38,
	ATTACK_FORTIFY=39,
	ENDURANCE_FORTIFY=40,
	FATIGUE_FORTIFY=41,
	HEALTH_FORTIFY=42,
	INTELLIGENCE_FORTIFY=43,
	LUCK_FORTIFY=44,
	MAGICKA_FORTIFY=45,
	MAGICKA_FORTIFY_MAX=46,
	PERSONALITY_FORTIFY=47,
	SPEED_FORTIFY=48,
	STRENGTH_FORTIFY=49,
	WILLPOWER_FORTIFY=50,
	FROST_DAMAGE=51,
	FROST_SHIELD=52,
	INVISIBILITY=53,
	LEVITATE=54,
	LIGHT=55,
	NIGHT_EYE=56,
	PARALYZE=57,
	POISON=58,
	RECALL=59,
	REFLECT=60,
	RESIST_BLIGHT_DISEASE=61,
	RESIST_COMMON_DISEASE=62,
	RESIST_FIRE=63,
	RESIST_FROST=64,
	RESIST_MAGICKA=65,
	RESIST_PARALYSIS=66,
	RESIST_POISON=67,
	RESIST_SHOCK=68,
	AGILITY_RESTORE=69,
	ENDURANCE_RESTORE=70,
	FATIGUE_RESTORE=71,
	HEALTH_RESTORE=72,
	INTELLIGENCE_RESTORE=73,
	LUCK_RESTORE=74,
	MAGICKA_RESTORE=75,
	PERSONALITY_RESTORE=76,
	SPEED_RESTORE=77,
	STRENGTH_RESTORE=78,
	WILLPOWER_RESTORE=79,
	SHIELD=80,
	SHOCK_DAMAGE=81,
	SHOCK_SHIELD=82,
	SILENCE=83,
	SPELL_ABSORPTION=84,
	SWIFT_SWIM=85,
	TELEKINESIS=86,
	VAMPIRISM=87,
	WATER_BREATHING=88,
	WATER_WALKING=89,
	WEAK_FIRE=90,
	FIRST_EFFECT=1,
	LAST_EFFECT=EFFECTS.length-1;//90
	public static final String[] getEffectList() {
		return EFFECTS.clone();
	}
	public static final String getEffectString(final int effect) {
		if (effect<0 || effect>=EFFECTS.length) return "";
		return EFFECTS[effect];
	}
}
