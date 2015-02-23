/**
 *
 */
package util.game.skyrim;

/**
 * <br>Created: Jan 11, 2012
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
		"Cure Disease",
		"Damage Health",
		"Damage Magicka",
		"Damage Magicka Regen",
		"Damage Stamina",
		"Damage Stamina Regen",
		"Fear",
		"Fortify Alteration",
		"Fortify Barter",
		"Fortify Block",
		"Fortify Carry Weight",
		"Fortify Conjuration",
		"Fortify Destruction",
		"Fortify Enchanting",
		"Fortify Health",
		"Fortify Heavy Armor",
		"Fortify Illusion",
		"Fortify Light Armor",
		"Fortify Lockpicking",
		"Fortify Magicka",
		"Fortify Marksman",
		"Fortify One-handed",
		"Fortify Pickpocket",
		"Fortify Restoration",
		"Fortify Smithing",
		"Fortify Sneak",
		"Fortify Stamina",
		"Fortify Two-handed",
		"Frenzy",
		"Invisibility",
		"Lingering Damage Health",
		"Lingering Damage Magicka",
		"Lingering Damage Stamina",
		"Paralysis",
		"Ravage Health",
		"Ravage Magicka",
		"Ravage Stamina",
		"Regenerate Health",
		"Regenerate Magicka",
		"Regenerate Stamina",
		"Resist Fire",
		"Resist Frost",
		"Resist Magic",
		"Resist Poison",
		"Resist Shock",
		"Restore Health",
		"Restore Magicka",
		"Restore Stamina",
		"Slow",
		"Waterbreathing",
		"Weakness to Fire",
		"Weakness to Frost",
		"Weakness to Magic",
		"Weakness to Poison",
		"Weakness to Shock",
		"Unknown"
	};
	public static final int
		NONE = 0,
				CURE_DISEASE=1,
				DAMAGE_HEALTH=2,
				DAMAGE_MAGICKA=3,
				DAMAGE_MAGICKA_REGEN=4,
				DAMAGE_STAMINA=5,
				DAMAGE_STAMINA_REGEN=6,
				FEAR=7,
				FORTIFY_ALTERATION=8,
				FORTIFY_BARTER=9,
				FORTIFY_BLOCK=10,
				FORTIFY_CARRY_WEIGHT=11,
				FORTIFY_CONJURATION=12,
				FORTIFY_DESTRUCTION=13,
				FORTIFY_ENCHANTING=14,
				FORTIFY_HEALTH=15,
				FORTIFY_HEAVY_ARMOR=16,
				FORTIFY_ILLUSION=17,
				FORTIFY_LIGHT_ARMOR=18,
				FORTIFY_LOCKPICKING=19,
				FORTIFY_MAGICKA=20,
				FORTIFY_MARKSMAN=21,
				FORTIFY_ONE_HANDED=22,
				FORTIFY_PICKPOCKET=23,
				FORTIFY_RESTORATION=24,
				FORTIFY_SMITHING=25,
				FORTIFY_SNEAK=26,
				FORTIFY_STAMINA=27,
				FORTIFY_TWO_HANDED=28,
				FRENZY=29,
				INVISIBILITY=30,
				LINGERING_DAMAGE_HEALTH=31,
				LINGERING_DAMAGE_MAGICKA=32,
				LINGERING_DAMAGE_STAMINA=33,
				PARALYSIS=34,
				RAVAGE_HEALTH=35,
				RAVAGE_MAGICKA=36,
				RAVAGE_STAMINA=37,
				REGENERATE_HEALTH=38,
				REGENERATE_MAGICKA=39,
				REGENERATE_STAMINA=40,
				RESIST_FIRE=41,
				RESIST_FROST=42,
				RESIST_MAGIC=43,
				RESIST_POISON=44,
				RESIST_SHOCK=45,
				RESTORE_HEALTH=46,
				RESTORE_MAGICKA=47,
				RESTORE_STAMINA=48,
				SLOW=49,
				WATERBREATHING=50,
				WEAKNESS_TO_FIRE=51,
				WEAKNESS_TO_FROST=52,
				WEAKNESS_TO_MAGIC=53,
				WEAKNESS_TO_POISON=54,
				WEAKNESS_TO_SHOCK=55,
				UNKNOWN=56,
		LAST_EFFECT=EFFECTS.length-1;
	public static final String[] getEffectList() {
		return EFFECTS.clone();
	}
	public static final String getEffectString(int effect) {
		if (effect<0 || effect>=EFFECTS.length) return "";
		return EFFECTS[effect];
	}
}
