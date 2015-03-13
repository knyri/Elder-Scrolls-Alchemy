/**
 *
 */
package util.game.morrowind;

import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;

/**
 * @author Super
 *
 */
public class AlchListModel extends AbstractListModel<Ingredient>{
	private final List<Ingredient> items;
	private int oldEffect1=0, oldEffect2=0, oldEffect3=0, oldEffect4=0, oldSkillLevel=0;
	/**
	 *
	 */
	public AlchListModel(){
		items= new ArrayList<Ingredient>(ingredients.size());
		items.addAll(ingredients);
	}
		private static final long serialVersionUID=1L;

	@Override
	public Ingredient getElementAt(int arg0){
		return items.get(arg0);
	}

	@Override
	public int getSize(){
		return items.size();
	}
	public synchronized void filterList(final int skillLevel, final int effect1, final int effect2, final int effect3, final int effect4) {
		//return if nothing has changed
		if(effect1==oldEffect1 && effect2==oldEffect2 && effect3==oldEffect3 && effect4==oldEffect4 && skillLevel==oldSkillLevel)
			return;
		boolean forceFilter= false;
		if (oldEffect1 != 0 && effect1 != oldEffect1 ||
				oldEffect2 != 0 && effect2 != oldEffect2 ||
				oldEffect3 != 0 && effect3 != oldEffect3 ||
				oldEffect4 != 0 && effect4 != oldEffect4 ||
				oldSkillLevel != 0 && oldSkillLevel < skillLevel) {
			// start over if the old !=0 and old != new
			// if the old is 0 then we can just filter what is in the list currently
			items.clear();
			items.addAll(ingredients);
			forceFilter= true;
		}
		if(skillLevel != oldSkillLevel)
			forceFilter= true;

		if(effect1 != 0 && (forceFilter || effect1 != oldEffect1))
			removeFilter(skillLevel, effect1);
		if(effect2 != 0 && (forceFilter || effect2 != oldEffect2))
			removeFilter(skillLevel, effect2);
		if(effect3 != 0 && (forceFilter || effect3 != oldEffect3))
			removeFilter(skillLevel, effect3);
		if(effect4 != 0 && (forceFilter || effect4 != oldEffect4))
			removeFilter(skillLevel, effect4);

		oldEffect1 = effect1;
		oldEffect2 = effect2;
		oldEffect3 = effect3;
		oldEffect4 = effect4;
		oldSkillLevel = skillLevel;
		fireContentsChanged(this,0,items.size());
	}
	/**
	 * Removes items without the desired effect
	 * @param skillLevel
	 * @param effect
	 */
	protected void removeFilter(int skillLevel, int effect){
		Ingredient item;
		for (int i=0; i<items.size(); i++) {
			item=items.get(i);
			if (! ((item.getEffect1() == effect) || (skillLevel > 1 &&item.getEffect2() == effect) || (skillLevel > 2 && item.getEffect3() == effect) || (skillLevel > 3 && item.getEffect4() == effect)) ) {
				items.remove(i);
				i--;
			}
		}
	}

	protected static final ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
	static {
		if (ingredients.size() == 0) {
			//ingredients.add(new Ingredient("",AlchemyConstants, AlchemyConstants, AlchemyConstants, AlchemyConstants));
			ingredients.add(new Ingredient("Alit Hide",AlchemyConstants.INTELLEGENCE_DRAIN, AlchemyConstants.RESIST_POISON, AlchemyConstants.TELEKINESIS, AlchemyConstants.DETECT_ANIMAL));
			ingredients.add(new Ingredient("Ampoule Pod",AlchemyConstants.WATER_WALKING, AlchemyConstants.PARALYZE, AlchemyConstants.DETECT_ANIMAL, AlchemyConstants.WILLPOWER_DRAIN));
			ingredients.add(new Ingredient("Ash Salts",AlchemyConstants.AGILITY_DRAIN, AlchemyConstants.RESIST_MAGICKA, AlchemyConstants.CURE_BLIGHT_DISEASE, AlchemyConstants.RESIST_MAGICKA));
			ingredients.add(new Ingredient("Ash Yam",AlchemyConstants.INTELLIGENCE_FORTIFY, AlchemyConstants.STRENGTH_FORTIFY, AlchemyConstants.RESIST_COMMON_DISEASE, AlchemyConstants.DETECT_KEY));
			ingredients.add(new Ingredient("Bittergreen Petals",AlchemyConstants.INTELLIGENCE_RESTORE, AlchemyConstants.INVISIBILITY, AlchemyConstants.ENDURANCE_DRAIN, AlchemyConstants.MAGICKA_DRAIN));
			ingredients.add(new Ingredient("Black Anther",AlchemyConstants.AGILITY_DRAIN, AlchemyConstants.RESIST_FIRE, AlchemyConstants.ENDURANCE_DRAIN, AlchemyConstants.LIGHT));
			ingredients.add(new Ingredient("Black Lichen",AlchemyConstants.STRENGTH_DRAIN, AlchemyConstants.RESIST_FROST, AlchemyConstants.SPEED_DRAIN, AlchemyConstants.CURE_POISON));
			ingredients.add(new Ingredient("Bloat",AlchemyConstants.MAGICKA_DRAIN, AlchemyConstants.INTELLIGENCE_FORTIFY, AlchemyConstants.WILLPOWER_FORTIFY, AlchemyConstants.DETECT_ANIMAL));
			ingredients.add(new Ingredient("Bonemeal",AlchemyConstants.AGILITY_RESTORE, AlchemyConstants.TELEKINESIS, AlchemyConstants.FATIGUE_DRAIN, AlchemyConstants.PERSONALITY_DRAIN));
			ingredients.add(new Ingredient("Bread",AlchemyConstants.FATIGUE_RESTORE, AlchemyConstants.NONE, AlchemyConstants.NONE, AlchemyConstants.NONE));
			ingredients.add(new Ingredient("Bungler's Bane",AlchemyConstants.SPEED_DRAIN, AlchemyConstants.ENDURANCE_DRAIN, AlchemyConstants.DISPEL, AlchemyConstants.STRENGTH_DRAIN));
			ingredients.add(new Ingredient("Chokeweed",AlchemyConstants.LUCK_DRAIN, AlchemyConstants.FATIGUE_RESTORE, AlchemyConstants.CURE_COMMON_DISEASE, AlchemyConstants.WILLPOWER_DRAIN));
			ingredients.add(new Ingredient("Coda Flower",AlchemyConstants.PERSONALITY_DRAIN, AlchemyConstants.LEVITATE, AlchemyConstants.INTELLEGENCE_DRAIN, AlchemyConstants.HEALTH_DRAIN));
			ingredients.add(new Ingredient("Comberry",AlchemyConstants.FATIGUE_DRAIN, AlchemyConstants.MAGICKA_RESTORE, AlchemyConstants.FIRE_SHIELD, AlchemyConstants.REFLECT));
			ingredients.add(new Ingredient("Corkbulb Root",AlchemyConstants.CURE_PARALYSIS, AlchemyConstants.HEALTH_RESTORE, AlchemyConstants.SHOCK_SHIELD, AlchemyConstants.LUCK_FORTIFY));
			ingredients.add(new Ingredient("Corpus Weepings",AlchemyConstants.FATIGUE_DRAIN, AlchemyConstants.LUCK_FORTIFY, AlchemyConstants.WILLPOWER_DRAIN, AlchemyConstants.HEALTH_RESTORE));
			ingredients.add(new Ingredient("Crab Meat",AlchemyConstants.FATIGUE_RESTORE, AlchemyConstants.RESIST_SHOCK, AlchemyConstants.SHOCK_SHIELD, AlchemyConstants.LUCK_RESTORE));
			ingredients.add(new Ingredient("Daedra Skin",AlchemyConstants.STRENGTH_FORTIFY, AlchemyConstants.CURE_COMMON_DISEASE, AlchemyConstants.PARALYZE, AlchemyConstants.SWIFT_SWIM));
			ingredients.add(new Ingredient("Daedra's Heart",AlchemyConstants.MAGICKA_RESTORE, AlchemyConstants.ENDURANCE_FORTIFY, AlchemyConstants.AGILITY_DRAIN, AlchemyConstants.NIGHT_EYE));
			ingredients.add(new Ingredient("Diamond",AlchemyConstants.AGILITY_DRAIN, AlchemyConstants.INVISIBILITY, AlchemyConstants.REFLECT, AlchemyConstants.DETECT_KEY));
			ingredients.add(new Ingredient("Dreugh Wax",AlchemyConstants.STRENGTH_FORTIFY, AlchemyConstants.STRENGTH_RESTORE, AlchemyConstants.LUCK_DRAIN, AlchemyConstants.WILLPOWER_DRAIN));
			ingredients.add(new Ingredient("Ectoplasm",AlchemyConstants.AGILITY_FORTIFY, AlchemyConstants.DETECT_ANIMAL, AlchemyConstants.STRENGTH_DRAIN, AlchemyConstants.HEALTH_DRAIN));
			ingredients.add(new Ingredient("Emerald",AlchemyConstants.MAGICKA_FORTIFY, AlchemyConstants.HEALTH_RESTORE, AlchemyConstants.AGILITY_DRAIN, AlchemyConstants.ENDURANCE_DRAIN));
			ingredients.add(new Ingredient("Fire Petal",AlchemyConstants.RESIST_FIRE, AlchemyConstants.HEALTH_DRAIN, AlchemyConstants.SPELL_ABSORPTION, AlchemyConstants.PARALYZE));
			ingredients.add(new Ingredient("Fire Salts",AlchemyConstants.HEALTH_DRAIN, AlchemyConstants.AGILITY_FORTIFY, AlchemyConstants.RESIST_FROST, AlchemyConstants.FIRE_SHIELD));
			ingredients.add(new Ingredient("Frost Salts",AlchemyConstants.SPEED_DRAIN, AlchemyConstants.MAGICKA_RESTORE, AlchemyConstants.FROST_SHIELD, AlchemyConstants.RESIST_FIRE));
			ingredients.add(new Ingredient("Ghoul Heart",AlchemyConstants.PARALYZE, AlchemyConstants.CURE_POISON, AlchemyConstants.ATTACK_FORTIFY, AlchemyConstants.NONE));
			ingredients.add(new Ingredient("Gold Kanet",AlchemyConstants.HEALTH_DRAIN, AlchemyConstants.BURDEN, AlchemyConstants.LUCK_DRAIN, AlchemyConstants.STRENGTH_RESTORE));
			ingredients.add(new Ingredient("Gravedust",AlchemyConstants.INTELLEGENCE_DRAIN, AlchemyConstants.CURE_COMMON_DISEASE, AlchemyConstants.MAGICKA_DRAIN, AlchemyConstants.ENDURANCE_RESTORE));
			ingredients.add(new Ingredient("Green Lichen",AlchemyConstants.PERSONALITY_FORTIFY, AlchemyConstants.CURE_COMMON_DISEASE, AlchemyConstants.STRENGTH_DRAIN, AlchemyConstants.HEALTH_DRAIN));
			ingredients.add(new Ingredient("Guar Hide",AlchemyConstants.FATIGUE_DRAIN, AlchemyConstants.ENDURANCE_FORTIFY, AlchemyConstants.PERSONALITY_RESTORE, AlchemyConstants.LUCK_FORTIFY));
			ingredients.add(new Ingredient("Hackle-Lo Leaf",AlchemyConstants.FATIGUE_RESTORE, AlchemyConstants.PARALYZE, AlchemyConstants.WATER_BREATHING, AlchemyConstants.LUCK_RESTORE));
			ingredients.add(new Ingredient("Heather",AlchemyConstants.PERSONALITY_RESTORE, AlchemyConstants.FEATHER, AlchemyConstants.SPEED_DRAIN, AlchemyConstants.PERSONALITY_DRAIN));
			ingredients.add(new Ingredient("Hound Meat",AlchemyConstants.FATIGUE_RESTORE, AlchemyConstants.FATIGUE_FORTIFY, AlchemyConstants.REFLECT, AlchemyConstants.DETECT_ENCHANTMENT));
			ingredients.add(new Ingredient("Hypha Facia",AlchemyConstants.LUCK_DRAIN, AlchemyConstants.AGILITY_DRAIN, AlchemyConstants.FATIGUE_DRAIN, AlchemyConstants.DETECT_ENCHANTMENT));
			ingredients.add(new Ingredient("Kagouti Hide",AlchemyConstants.FATIGUE_DRAIN, AlchemyConstants.SPEED_FORTIFY, AlchemyConstants.RESIST_COMMON_DISEASE, AlchemyConstants.NIGHT_EYE));
			ingredients.add(new Ingredient("Kresh Fiber",AlchemyConstants.LUCK_RESTORE, AlchemyConstants.PERSONALITY_FORTIFY, AlchemyConstants.MAGICKA_DRAIN, AlchemyConstants.SPEED_DRAIN));
			ingredients.add(new Ingredient("Kwama Cuttle",AlchemyConstants.RESIST_POISON, AlchemyConstants.FATIGUE_DRAIN, AlchemyConstants.WATER_WALKING, AlchemyConstants.WATER_BREATHING));
			ingredients.add(new Ingredient("Large Kwama Egg",AlchemyConstants.FATIGUE_RESTORE, AlchemyConstants.PARALYZE, AlchemyConstants.FROST_SHIELD, AlchemyConstants.HEALTH_FORTIFY));
			ingredients.add(new Ingredient("Luminous Russula",AlchemyConstants.WATER_BREATHING, AlchemyConstants.FATIGUE_DRAIN, AlchemyConstants.POISON, AlchemyConstants.NONE));
			ingredients.add(new Ingredient("Marshmerrow",AlchemyConstants.HEALTH_RESTORE, AlchemyConstants.DETECT_ENCHANTMENT, AlchemyConstants.WILLPOWER_DRAIN, AlchemyConstants.FATIGUE_DRAIN));
			ingredients.add(new Ingredient("Moon Sugar",AlchemyConstants.SPEED_FORTIFY, AlchemyConstants.DISPEL, AlchemyConstants.ENDURANCE_DRAIN, AlchemyConstants.LUCK_DRAIN));
			ingredients.add(new Ingredient("Muck",AlchemyConstants.INTELLEGENCE_DRAIN, AlchemyConstants.DETECT_KEY, AlchemyConstants.PERSONALITY_DRAIN, AlchemyConstants.CURE_COMMON_DISEASE));
			ingredients.add(new Ingredient("Netch Leather",AlchemyConstants.ENDURANCE_FORTIFY, AlchemyConstants.INTELLIGENCE_FORTIFY, AlchemyConstants.PERSONALITY_DRAIN, AlchemyConstants.CURE_PARALYSIS));
			ingredients.add(new Ingredient("Pearl",AlchemyConstants.AGILITY_DRAIN, AlchemyConstants.DISPEL, AlchemyConstants.WATER_BREATHING, AlchemyConstants.RESIST_COMMON_DISEASE));
			ingredients.add(new Ingredient("Racer Plumes",AlchemyConstants.WILLPOWER_DRAIN, AlchemyConstants.LEVITATE, AlchemyConstants.NONE, AlchemyConstants.NONE));
			ingredients.add(new Ingredient("Rat Meat",AlchemyConstants.MAGICKA_DRAIN, AlchemyConstants.PARALYZE, AlchemyConstants.CURE_POISON, AlchemyConstants.RESIST_POISON));
			ingredients.add(new Ingredient("Raw Ebony",AlchemyConstants.AGILITY_DRAIN, AlchemyConstants.CURE_POISON, AlchemyConstants.FROST_SHIELD, AlchemyConstants.SPEED_RESTORE));
			ingredients.add(new Ingredient("Raw Glass",AlchemyConstants.INTELLEGENCE_DRAIN, AlchemyConstants.STRENGTH_DRAIN, AlchemyConstants.SPEED_DRAIN, AlchemyConstants.FIRE_SHIELD));
			ingredients.add(new Ingredient("Red Lichen",AlchemyConstants.SPEED_DRAIN, AlchemyConstants.LIGHT, AlchemyConstants.CURE_COMMON_DISEASE, AlchemyConstants.MAGICKA_DRAIN));
			ingredients.add(new Ingredient("Resin",AlchemyConstants.HEALTH_RESTORE, AlchemyConstants.SPEED_RESTORE, AlchemyConstants.BURDEN, AlchemyConstants.RESIST_COMMON_DISEASE));
			ingredients.add(new Ingredient("Roobrush",AlchemyConstants.WILLPOWER_DRAIN, AlchemyConstants.AGILITY_FORTIFY, AlchemyConstants.HEALTH_DRAIN, AlchemyConstants.CURE_POISON));
			ingredients.add(new Ingredient("Ruby",AlchemyConstants.HEALTH_DRAIN, AlchemyConstants.FEATHER, AlchemyConstants.INTELLIGENCE_RESTORE, AlchemyConstants.AGILITY_DRAIN));
			ingredients.add(new Ingredient("Saltrice",AlchemyConstants.FATIGUE_RESTORE, AlchemyConstants.MAGICKA_FORTIFY, AlchemyConstants.STRENGTH_DRAIN, AlchemyConstants.HEALTH_RESTORE));
			ingredients.add(new Ingredient("Scales",AlchemyConstants.PERSONALITY_DRAIN, AlchemyConstants.WATER_WALKING, AlchemyConstants.ENDURANCE_RESTORE, AlchemyConstants.SWIFT_SWIM));
			ingredients.add(new Ingredient("Scamp Skin",AlchemyConstants.MAGICKA_DRAIN, AlchemyConstants.CURE_PARALYSIS, AlchemyConstants.PERSONALITY_RESTORE, AlchemyConstants.STRENGTH_RESTORE));
			ingredients.add(new Ingredient("Scathecraw",AlchemyConstants.STRENGTH_DRAIN, AlchemyConstants.CURE_POISON, AlchemyConstants.HEALTH_DRAIN, AlchemyConstants.WILLPOWER_RESTORE));
			ingredients.add(new Ingredient("Scrap Metal",AlchemyConstants.HEALTH_DRAIN, AlchemyConstants.SHOCK_SHIELD, AlchemyConstants.RESIST_SHOCK, AlchemyConstants.INTELLIGENCE_RESTORE));
			ingredients.add(new Ingredient("Scrib Jelly",AlchemyConstants.WILLPOWER_FORTIFY, AlchemyConstants.CURE_POISON, AlchemyConstants.CURE_BLIGHT_DISEASE, AlchemyConstants.WILLPOWER_RESTORE));
			ingredients.add(new Ingredient("Scrib Jerky",AlchemyConstants.FATIGUE_RESTORE, AlchemyConstants.FATIGUE_FORTIFY, AlchemyConstants.BURDEN, AlchemyConstants.SWIFT_SWIM));
			ingredients.add(new Ingredient("Scuttle",AlchemyConstants.FATIGUE_RESTORE, AlchemyConstants.FATIGUE_FORTIFY, AlchemyConstants.FEATHER, AlchemyConstants.TELEKINESIS));
			ingredients.add(new Ingredient("Shalk Resin",AlchemyConstants.FATIGUE_DRAIN, AlchemyConstants.HEALTH_FORTIFY, AlchemyConstants.PERSONALITY_DRAIN, AlchemyConstants.SPEED_FORTIFY));
			ingredients.add(new Ingredient("Sload Soap",AlchemyConstants.PERSONALITY_DRAIN, AlchemyConstants.AGILITY_FORTIFY, AlchemyConstants.FIRE_SHIELD, AlchemyConstants.AGILITY_RESTORE));
			ingredients.add(new Ingredient("Small Kwama Egg",AlchemyConstants.FATIGUE_RESTORE, AlchemyConstants.NONE, AlchemyConstants.NONE, AlchemyConstants.NONE));
			ingredients.add(new Ingredient("Spore Pod",AlchemyConstants.STRENGTH_DRAIN, AlchemyConstants.FATIGUE_DRAIN, AlchemyConstants.DETECT_KEY, AlchemyConstants.PARALYZE));
			ingredients.add(new Ingredient("Stoneflower Petals",AlchemyConstants.STRENGTH_RESTORE, AlchemyConstants.MAGICKA_FORTIFY, AlchemyConstants.LUCK_DRAIN, AlchemyConstants.PERSONALITY_FORTIFY));
			ingredients.add(new Ingredient("Trama Root",AlchemyConstants.WILLPOWER_RESTORE, AlchemyConstants.LEVITATE, AlchemyConstants.MAGICKA_DRAIN, AlchemyConstants.SPEED_DRAIN));
			ingredients.add(new Ingredient("Vampire Dust",AlchemyConstants.HEALTH_FORTIFY, AlchemyConstants.STRENGTH_FORTIFY, AlchemyConstants.SPELL_ABSORPTION, AlchemyConstants.VAMPIRISM));
			ingredients.add(new Ingredient("Violet Coprinus",AlchemyConstants.WATER_WALKING, AlchemyConstants.FATIGUE_DRAIN, AlchemyConstants.POISON, AlchemyConstants.NONE));
			ingredients.add(new Ingredient("Void Salts",AlchemyConstants.MAGICKA_RESTORE, AlchemyConstants.SPELL_ABSORPTION, AlchemyConstants.PARALYZE, AlchemyConstants.ENDURANCE_DRAIN));
			ingredients.add(new Ingredient("Wickwheat",AlchemyConstants.HEALTH_RESTORE, AlchemyConstants.WILLPOWER_FORTIFY, AlchemyConstants.PARALYZE, AlchemyConstants.INTELLIGENCE_DAMAGE));
			ingredients.add(new Ingredient("Willow Anther",AlchemyConstants.PERSONALITY_DRAIN, AlchemyConstants.FROST_SHIELD, AlchemyConstants.CURE_COMMON_DISEASE, AlchemyConstants.CURE_PARALYSIS));
			//---TRIBUNAL
			ingredients.add(new Ingredient("(T)Adamantium Ore",AlchemyConstants.BURDEN, AlchemyConstants.MAGICKA_RESTORE, AlchemyConstants.POISON, AlchemyConstants.REFLECT));
			ingredients.add(new Ingredient("(T)Durzog Meat",AlchemyConstants.AGILITY_FORTIFY, AlchemyConstants.STRENGTH_FORTIFY, AlchemyConstants.BLIND, AlchemyConstants.MAGICKA_DAMAGE));
			ingredients.add(new Ingredient("(T)Golden Sedge Flowers",AlchemyConstants.MAGICKA_DRAIN, AlchemyConstants.STRENGTH_FORTIFY, AlchemyConstants.ATTACK_FORTIFY, AlchemyConstants.SWIFT_SWIM));
			ingredients.add(new Ingredient("(T)Horn Lily Bulb",AlchemyConstants.RESIST_PARALYSIS, AlchemyConstants.HEALTH_DRAIN, AlchemyConstants.STRENGTH_RESTORE, AlchemyConstants.ENDURANCE_RESTORE));
			ingredients.add(new Ingredient("(T)Lloramor Spines",AlchemyConstants.SPELL_ABSORPTION, AlchemyConstants.INVISIBILITY, AlchemyConstants.POISON, AlchemyConstants.DETECT_ENCHANTMENT));
			ingredients.add(new Ingredient("(T)Meadow Rye",AlchemyConstants.SPEED_FORTIFY, AlchemyConstants.HEALTH_DAMAGE, AlchemyConstants.SPEED_RESTORE, AlchemyConstants.SPEED_DRAIN));
			ingredients.add(new Ingredient("(T)Nirthfly Stalks",AlchemyConstants.HEALTH_DAMAGE, AlchemyConstants.SPEED_FORTIFY, AlchemyConstants.SPEED_RESTORE, AlchemyConstants.SPEED_DRAIN));
			ingredients.add(new Ingredient("(T)Noble Sedge Flowers",AlchemyConstants.HEALTH_DAMAGE, AlchemyConstants.AGILITY_RESTORE, AlchemyConstants.POISON, AlchemyConstants.AGILITY_FORTIFY));
			ingredients.add(new Ingredient("(T)Scrib Cabbage",AlchemyConstants.INTELLEGENCE_DRAIN, AlchemyConstants.HEALTH_DAMAGE, AlchemyConstants.AGILITY_RESTORE, AlchemyConstants.AGILITY_FORTIFY));
			ingredients.add(new Ingredient("(T)Sweetpulp",AlchemyConstants.PARALYZE, AlchemyConstants.LEVITATE, AlchemyConstants.RESIST_PARALYSIS, AlchemyConstants.HEALTH_RESTORE));
			ingredients.add(new Ingredient("(T)Timsa-Come-By flowers",AlchemyConstants.DISPEL, AlchemyConstants.RESIST_PARALYSIS, AlchemyConstants.MAGICKA_DRAIN, AlchemyConstants.ENDURANCE_RESTORE));
			//BLOODMOON
			ingredients.add(new Ingredient("(B)Bear Pelt",AlchemyConstants.FATIGUE_DRAIN, AlchemyConstants.STRENGTH_FORTIFY, AlchemyConstants.RESIST_COMMON_DISEASE, AlchemyConstants.NIGHT_EYE));
			ingredients.add(new Ingredient("(B)Bristleback Leather",AlchemyConstants.BLIND, AlchemyConstants.FROST_DAMAGE, AlchemyConstants.RESIST_FROST, AlchemyConstants.RECALL));
			ingredients.add(new Ingredient("(B)Grahl Eyeball",AlchemyConstants.RESIST_FROST, AlchemyConstants.NIGHT_EYE, AlchemyConstants.MAGICKA_DRAIN, AlchemyConstants.STRENGTH_FORTIFY));
			ingredients.add(new Ingredient("(B)Gravetar",AlchemyConstants.RESIST_FROST, AlchemyConstants.HEALTH_DRAIN, AlchemyConstants.FATIGUE_FORTIFY, AlchemyConstants.LUCK_DRAIN));
			ingredients.add(new Ingredient("(B)Holly Berries",AlchemyConstants.RESIST_FROST, AlchemyConstants.FROST_SHIELD, AlchemyConstants.FROST_DAMAGE, AlchemyConstants.WEAK_FIRE));
			ingredients.add(new Ingredient("(B)Raw Stalhrim",AlchemyConstants.RESIST_FROST, AlchemyConstants.FROST_DAMAGE, AlchemyConstants.PARALYZE, AlchemyConstants.HEALTH_RESTORE));
			ingredients.add(new Ingredient("(B)Horker Tusk",AlchemyConstants.DRAIN_ALTERATION, AlchemyConstants.INTELLIGENCE_FORTIFY, AlchemyConstants.MAGICKA_FORTIFY_MAX, AlchemyConstants.DETECT_ANIMAL));
			ingredients.add(new Ingredient("(B)Ripened Belladonna Berries",AlchemyConstants.RESIST_MAGICKA, AlchemyConstants.MAGICKA_RESTORE, AlchemyConstants.MAGICKA_FORTIFY, AlchemyConstants.MAGICKA_DRAIN));
			ingredients.add(new Ingredient("(B)Snow Bear Pelt",AlchemyConstants.FATIGUE_DRAIN, AlchemyConstants.SPEED_FORTIFY, AlchemyConstants.RESIST_COMMON_DISEASE, AlchemyConstants.NIGHT_EYE));
			ingredients.add(new Ingredient("(B)Snow Wolf Pelt",AlchemyConstants.FATIGUE_DRAIN, AlchemyConstants.SPEED_FORTIFY, AlchemyConstants.RESIST_COMMON_DISEASE, AlchemyConstants.NIGHT_EYE));
			ingredients.add(new Ingredient("(B)Unripened Belladonna Berries",AlchemyConstants.RESIST_MAGICKA, AlchemyConstants.MAGICKA_RESTORE, AlchemyConstants.MAGICKA_FORTIFY, AlchemyConstants.MAGICKA_DRAIN));
			ingredients.add(new Ingredient("(B)Wolf Pelt",AlchemyConstants.FATIGUE_DRAIN, AlchemyConstants.SPEED_FORTIFY, AlchemyConstants.RESIST_COMMON_DISEASE, AlchemyConstants.NIGHT_EYE));
			ingredients.add(new Ingredient("(B)Wolfsbane Petals",AlchemyConstants.INTELLIGENCE_RESTORE, AlchemyConstants.INVISIBILITY, AlchemyConstants.ENDURANCE_DRAIN, AlchemyConstants.MAGICKA_DRAIN));
			//ingredients.add(new Ingredient("",AlchemyConstants, AlchemyConstants, AlchemyConstants, AlchemyConstants));
		}
	}
}
