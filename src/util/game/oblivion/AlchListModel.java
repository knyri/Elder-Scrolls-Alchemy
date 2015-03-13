/**
 *
 */
package util.game.oblivion;

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
			ingredients.add(new Ingredient("Alkanet Flower",AlchemyConstants.RESTORE_INTELLIGENCE, AlchemyConstants.RESIST_POISON, AlchemyConstants.LIGHT, AlchemyConstants.DAMAGE_FATIGUE));
			ingredients.add(new Ingredient("Aloe Vera Leaves",AlchemyConstants.RESTORE_FATIGUE, AlchemyConstants.RESTORE_HEALTH, AlchemyConstants.DAMAGE_MAGICKA, AlchemyConstants.INVISIBILITY));
			ingredients.add(new Ingredient("Ambrosia",AlchemyConstants.RESTORE_HEALTH, AlchemyConstants.NONE, AlchemyConstants.NONE, AlchemyConstants.NONE));
			ingredients.add(new Ingredient("Apple",AlchemyConstants.RESTORE_FATIGUE, AlchemyConstants.DAMAGE_LUCK, AlchemyConstants.FORTIFY_WILLPOWER, AlchemyConstants.DAMAGE_HEALTH));
			ingredients.add(new Ingredient("Arrowroot",AlchemyConstants.RESTORE_AGILITY, AlchemyConstants.DAMAGE_LUCK, AlchemyConstants.FORTIFY_STRENGTH, AlchemyConstants.BURDEN));
			ingredients.add(new Ingredient("Ashes of Hindaril",AlchemyConstants.SILENCE, AlchemyConstants.RESIST_DISEASE, AlchemyConstants.FROST_DAMAGE, AlchemyConstants.INVISIBILITY));
			ingredients.add(new Ingredient("Beef",AlchemyConstants.RESTORE_FATIGUE, AlchemyConstants.SHIELD, AlchemyConstants.FORTIFY_AGILITY, AlchemyConstants.DISPEL));
			ingredients.add(new Ingredient("Bergamot Seeds",AlchemyConstants.RESIST_DISEASE, AlchemyConstants.DISPEL, AlchemyConstants.DAMAGE_MAGICKA, AlchemyConstants.SILENCE));
			ingredients.add(new Ingredient("Blackberry",AlchemyConstants.RESTORE_FATIGUE, AlchemyConstants.RESIST_SHOCK, AlchemyConstants.FORTIFY_ENDURANCE, AlchemyConstants.RESTORE_MAGICKA));
			ingredients.add(new Ingredient("Bloodgrass",AlchemyConstants.CHAMELEON, AlchemyConstants.RESIST_PARALYSIS, AlchemyConstants.BURDEN, AlchemyConstants.FORTIFY_HEALTH));
			ingredients.add(new Ingredient("Boar Meat",AlchemyConstants.RESTORE_HEALTH, AlchemyConstants.DAMAGE_SPEED, AlchemyConstants.FORTIFY_HEALTH, AlchemyConstants.BURDEN));
			ingredients.add(new Ingredient("Bog Beacon Asco Cap",AlchemyConstants.RESTORE_MAGICKA, AlchemyConstants.SHIELD, AlchemyConstants.DAMAGE_PERSONALITY, AlchemyConstants.DAMAGE_ENDURANCE));
			ingredients.add(new Ingredient("Bonemeal",AlchemyConstants.DAMAGE_FATIGUE, AlchemyConstants.RESIST_FIRE, AlchemyConstants.FORTIFY_LUCK, AlchemyConstants.NIGHT_EYE));
			ingredients.add(new Ingredient("Bread Loaf",AlchemyConstants.RESTORE_FATIGUE, AlchemyConstants.DETECT_LIFE, AlchemyConstants.DAMAGE_AGILITY, AlchemyConstants.DAMAGE_STRENGTH));
			ingredients.add(new Ingredient("Cairn Bolete Cap",AlchemyConstants.RESTORE_HEALTH, AlchemyConstants.DAMAGE_INTELLIGENCE, AlchemyConstants.RESIST_PARALYSIS, AlchemyConstants.SHOCK_DAMAGE));
			ingredients.add(new Ingredient("Carrot",AlchemyConstants.RESTORE_FATIGUE, AlchemyConstants.NIGHT_EYE, AlchemyConstants.FORTIFY_INTELLIGENCE, AlchemyConstants.DAMAGE_ENDURANCE));
			ingredients.add(new Ingredient("Carrot of Seeing",AlchemyConstants.RESTORE_FATIGUE, AlchemyConstants.NIGHT_EYE, AlchemyConstants.FORTIFY_INTELLIGENCE, AlchemyConstants.DAMAGE_ENDURANCE));
			ingredients.add(new Ingredient("Cheese Wedge",AlchemyConstants.RESTORE_FATIGUE, AlchemyConstants.RESIST_FIRE, AlchemyConstants.FIRE_SHIELD, AlchemyConstants.DAMAGE_AGILITY));
			ingredients.add(new Ingredient("Cheese Wheel",AlchemyConstants.RESTORE_FATIGUE, AlchemyConstants.RESIST_PARALYSIS, AlchemyConstants.DAMAGE_LUCK, AlchemyConstants.FORTIFY_WILLPOWER));
			ingredients.add(new Ingredient("Cinnabar Polypore Cap Red",AlchemyConstants.RESTORE_AGILITY, AlchemyConstants.SHIELD, AlchemyConstants.DAMAGE_PERSONALITY, AlchemyConstants.DAMAGE_ENDURANCE));
			ingredients.add(new Ingredient("Cinnabar Polypore Cap Yellow",AlchemyConstants.RESTORE_ENDURANCE, AlchemyConstants.FORTIFY_ENDURANCE, AlchemyConstants.DAMAGE_PERSONALITY, AlchemyConstants.REFLECT_SPELL));
			ingredients.add(new Ingredient("Clannfear Claws",AlchemyConstants.CURE_DISEASE, AlchemyConstants.RESIST_DISEASE, AlchemyConstants.PARALYZE, AlchemyConstants.DAMAGE_HEALTH));
			ingredients.add(new Ingredient("Clouded Funnel Cap",AlchemyConstants.RESTORE_INTELLIGENCE, AlchemyConstants.FORTIFY_INTELLIGENCE, AlchemyConstants.DAMAGE_ENDURANCE, AlchemyConstants.DAMAGE_MAGICKA));
			ingredients.add(new Ingredient("Columbine Root Pulp",AlchemyConstants.RESTORE_PERSONALITY, AlchemyConstants.RESIST_FROST, AlchemyConstants.FORTIFY_MAGICKA, AlchemyConstants.CHAMELEON));
			ingredients.add(new Ingredient("Corn",AlchemyConstants.RESTORE_FATIGUE, AlchemyConstants.RESTORE_INTELLIGENCE, AlchemyConstants.DAMAGE_AGILITY, AlchemyConstants.SHOCK_SHIELD));
			ingredients.add(new Ingredient("Crabmeat",AlchemyConstants.RESTORE_ENDURANCE, AlchemyConstants.RESIST_SHOCK, AlchemyConstants.DAMAGE_FATIGUE, AlchemyConstants.FIRE_SHIELD));
			ingredients.add(new Ingredient("Daedra Heart",AlchemyConstants.RESTORE_HEALTH, AlchemyConstants.SHOCK_SHIELD, AlchemyConstants.DAMAGE_MAGICKA, AlchemyConstants.SILENCE));
			ingredients.add(new Ingredient("Daedra Silk",AlchemyConstants.BURDEN, AlchemyConstants.NIGHT_EYE, AlchemyConstants.CHAMELEON, AlchemyConstants.DAMAGE_ENDURANCE));
			ingredients.add(new Ingredient("Daedra Venin",AlchemyConstants.PARALYZE, AlchemyConstants.RESTORE_FATIGUE, AlchemyConstants.DAMAGE_HEALTH, AlchemyConstants.REFLECT_DAMAGE));
			ingredients.add(new Ingredient("Daedroth Teeth",AlchemyConstants.NIGHT_EYE, AlchemyConstants.FROST_SHIELD, AlchemyConstants.BURDEN, AlchemyConstants.LIGHT));
			ingredients.add(new Ingredient("Dragon's Tongue",AlchemyConstants.RESIST_FIRE, AlchemyConstants.DAMAGE_HEALTH, AlchemyConstants.RESTORE_HEALTH, AlchemyConstants.FIRE_SHIELD));
			ingredients.add(new Ingredient("Dreugh Wax",AlchemyConstants.DAMAGE_FATIGUE, AlchemyConstants.RESIST_POISON, AlchemyConstants.WATER_BREATHING, AlchemyConstants.DAMAGE_HEALTH));
			ingredients.add(new Ingredient("Dryad's Saddle Polypore Cap",AlchemyConstants.RESTORE_LUCK, AlchemyConstants.RESIST_FROST, AlchemyConstants.DAMAGE_SPEED, AlchemyConstants.FROST_DAMAGE));
			ingredients.add(new Ingredient("Ectoplasm",AlchemyConstants.SHOCK_DAMAGE, AlchemyConstants.DISPEL, AlchemyConstants.FORTIFY_MAGICKA, AlchemyConstants.DAMAGE_HEALTH));
			ingredients.add(new Ingredient("Elf Cup Cap",AlchemyConstants.DAMAGE_WILLPOWER, AlchemyConstants.CURE_DISEASE, AlchemyConstants.FORTIFY_STRENGTH, AlchemyConstants.DAMAGE_INTELLIGENCE));
			ingredients.add(new Ingredient("Emetic Russula Cap",AlchemyConstants.RESTORE_AGILITY, AlchemyConstants.SHIELD, AlchemyConstants.DAMAGE_PERSONALITY, AlchemyConstants.DAMAGE_ENDURANCE));
			ingredients.add(new Ingredient("Fennel Seeds",AlchemyConstants.RESTORE_FATIGUE, AlchemyConstants.DAMAGE_INTELLIGENCE, AlchemyConstants.DAMAGE_MAGICKA, AlchemyConstants.PARALYZE));
			ingredients.add(new Ingredient("Fire Salts",AlchemyConstants.FIRE_DAMAGE, AlchemyConstants.RESIST_FROST, AlchemyConstants.RESTORE_MAGICKA, AlchemyConstants.FIRE_SHIELD));
			ingredients.add(new Ingredient("Flax Seeds",AlchemyConstants.RESTORE_MAGICKA, AlchemyConstants.FEATHER, AlchemyConstants.SHIELD, AlchemyConstants.DAMAGE_HEALTH));
			ingredients.add(new Ingredient("Flour",AlchemyConstants.RESTORE_FATIGUE, AlchemyConstants.DAMAGE_PERSONALITY, AlchemyConstants.FORTIFY_FATIGUE, AlchemyConstants.REFLECT_DAMAGE));
			ingredients.add(new Ingredient("Fly Amanita Cap",AlchemyConstants.RESTORE_AGILITY, AlchemyConstants.BURDEN, AlchemyConstants.RESTORE_HEALTH, AlchemyConstants.SHOCK_DAMAGE));
			ingredients.add(new Ingredient("Foxglove Nectar",AlchemyConstants.RESIST_POISON, AlchemyConstants.RESIST_PARALYSIS, AlchemyConstants.RESTORE_LUCK, AlchemyConstants.RESIST_DISEASE));
			ingredients.add(new Ingredient("Frost Salts",AlchemyConstants.FROST_DAMAGE, AlchemyConstants.RESIST_FIRE, AlchemyConstants.SILENCE, AlchemyConstants.FROST_SHIELD));
			ingredients.add(new Ingredient("Garlic",AlchemyConstants.RESIST_DISEASE, AlchemyConstants.DAMAGE_AGILITY, AlchemyConstants.FROST_SHIELD, AlchemyConstants.FORTIFY_STRENGTH));
			ingredients.add(new Ingredient("Ginko Leaf",AlchemyConstants.RESTORE_SPEED, AlchemyConstants.FORTIFY_MAGICKA, AlchemyConstants.DAMAGE_LUCK, AlchemyConstants.SHOCK_DAMAGE));
			ingredients.add(new Ingredient("Ginseng",AlchemyConstants.DAMAGE_LUCK, AlchemyConstants.CURE_POISON, AlchemyConstants.BURDEN, AlchemyConstants.FORTIFY_MAGICKA));
			ingredients.add(new Ingredient("Glow Dust",AlchemyConstants.RESTORE_SPEED, AlchemyConstants.LIGHT, AlchemyConstants.REFLECT_SPELL, AlchemyConstants.DAMAGE_HEALTH));
			ingredients.add(new Ingredient("Grapes",AlchemyConstants.RESTORE_FATIGUE, AlchemyConstants.WATER_WALKING, AlchemyConstants.DISPEL, AlchemyConstants.DAMAGE_HEALTH));
			ingredients.add(new Ingredient("Green Stain Cup Cap",AlchemyConstants.RESTORE_FATIGUE, AlchemyConstants.DAMAGE_SPEED, AlchemyConstants.REFLECT_DAMAGE, AlchemyConstants.DAMAGE_HEALTH));
			ingredients.add(new Ingredient("Green Stain Shelp Cap",AlchemyConstants.RESTORE_LUCK, AlchemyConstants.FORTIFY_LUCK, AlchemyConstants.DAMAGE_FATIGUE, AlchemyConstants.RESTORE_HEALTH));
			ingredients.add(new Ingredient("Ham",AlchemyConstants.RESTORE_FATIGUE, AlchemyConstants.RESTORE_HEALTH, AlchemyConstants.DAMAGE_MAGICKA, AlchemyConstants.DAMAGE_LUCK));
			ingredients.add(new Ingredient("Harrada",AlchemyConstants.DAMAGE_HEALTH, AlchemyConstants.DAMAGE_MAGICKA, AlchemyConstants.SILENCE, AlchemyConstants.PARALYZE));
			ingredients.add(new Ingredient("Human Heart",AlchemyConstants.RESTORE_HEALTH, AlchemyConstants.SHOCK_SHIELD, AlchemyConstants.DAMAGE_MAGICKA, AlchemyConstants.SILENCE));
			ingredients.add(new Ingredient("Human Skin",AlchemyConstants.DAMAGE_MAGICKA, AlchemyConstants.RESIST_SHOCK, AlchemyConstants.REFLECT_DAMAGE, AlchemyConstants.DAMAGE_HEALTH));
			ingredients.add(new Ingredient("Imp Fluid",AlchemyConstants.DAMAGE_HEALTH, AlchemyConstants.NONE, AlchemyConstants.NONE, AlchemyConstants.NONE));
			ingredients.add(new Ingredient("Imp Gall",AlchemyConstants.FORTIFY_PERSONALITY, AlchemyConstants.CURE_PARALYSIS, AlchemyConstants.DAMAGE_HEALTH, AlchemyConstants.FIRE_DAMAGE));
			ingredients.add(new Ingredient("Ironwood Nut",AlchemyConstants.RESTORE_INTELLIGENCE, AlchemyConstants.RESIST_FIRE, AlchemyConstants.DAMAGE_FATIGUE, AlchemyConstants.FORTIFY_HEALTH));
			ingredients.add(new Ingredient("Jumbo Potato",AlchemyConstants.RESTORE_FATIGUE, AlchemyConstants.SHIELD, AlchemyConstants.BURDEN, AlchemyConstants.FROST_SHIELD));
			ingredients.add(new Ingredient("Lady's Mantle Leaves",AlchemyConstants.RESTORE_HEALTH, AlchemyConstants.DAMAGE_ENDURANCE, AlchemyConstants.NIGHT_EYE, AlchemyConstants.FEATHER));
			ingredients.add(new Ingredient("Lady's Smock Leaves",AlchemyConstants.RESTORE_INTELLIGENCE, AlchemyConstants.RESIST_FIRE, AlchemyConstants.DAMAGE_FATIGUE, AlchemyConstants.FORTIFY_HEALTH));
			ingredients.add(new Ingredient("Lavender Sprig",AlchemyConstants.RESTORE_PERSONALITY, AlchemyConstants.FORTIFY_WILLPOWER, AlchemyConstants.RESTORE_HEALTH, AlchemyConstants.DAMAGE_LUCK));
			ingredients.add(new Ingredient("Leek",AlchemyConstants.RESTORE_FATIGUE, AlchemyConstants.FORTIFY_AGILITY, AlchemyConstants.DAMAGE_PERSONALITY, AlchemyConstants.DAMAGE_STRENGTH));
			ingredients.add(new Ingredient("Lettuce",AlchemyConstants.RESTORE_FATIGUE, AlchemyConstants.RESTORE_LUCK, AlchemyConstants.FIRE_SHIELD, AlchemyConstants.DAMAGE_PERSONALITY));
			ingredients.add(new Ingredient("Lichor",AlchemyConstants.RESTORE_MAGICKA, AlchemyConstants.NONE, AlchemyConstants.NONE, AlchemyConstants.NONE));
			ingredients.add(new Ingredient("Mandrake Root",AlchemyConstants.CURE_DISEASE, AlchemyConstants.RESIST_POISON, AlchemyConstants.DAMAGE_AGILITY, AlchemyConstants.FORTIFY_WILLPOWER));
			ingredients.add(new Ingredient("Milk Thistle Seeds",AlchemyConstants.LIGHT, AlchemyConstants.FROST_DAMAGE, AlchemyConstants.CURE_PARALYSIS, AlchemyConstants.PARALYZE));
			ingredients.add(new Ingredient("Minotaur Horn",AlchemyConstants.RESTORE_WILLPOWER, AlchemyConstants.BURDEN, AlchemyConstants.FORTIFY_ENDURANCE, AlchemyConstants.RESIST_PARALYSIS));
			ingredients.add(new Ingredient("Monkshood Root Pulp",AlchemyConstants.RESTORE_STRENGTH, AlchemyConstants.DAMAGE_INTELLIGENCE, AlchemyConstants.FORTIFY_ENDURANCE, AlchemyConstants.BURDEN));
			ingredients.add(new Ingredient("Morning Glory Root Pulp",AlchemyConstants.BURDEN, AlchemyConstants.DAMAGE_WILLPOWER, AlchemyConstants.FROST_SHIELD, AlchemyConstants.DAMAGE_MAGICKA));
			ingredients.add(new Ingredient("Mort Flesh",AlchemyConstants.DAMAGE_FATIGUE, AlchemyConstants.DAMAGE_LUCK, AlchemyConstants.FORTIFY_HEALTH, AlchemyConstants.SILENCE));
			ingredients.add(new Ingredient("Motherwort Sprig",AlchemyConstants.RESIST_POISON, AlchemyConstants.DAMAGE_FATIGUE, AlchemyConstants.SILENCE, AlchemyConstants.INVISIBILITY));
			ingredients.add(new Ingredient("Mugwort Seeds",AlchemyConstants.RESTORE_HEALTH, AlchemyConstants.NONE, AlchemyConstants.NONE, AlchemyConstants.NONE));
			ingredients.add(new Ingredient("Mutton",AlchemyConstants.FORTIFY_HEALTH, AlchemyConstants.DAMAGE_FATIGUE, AlchemyConstants.DISPEL, AlchemyConstants.DAMAGE_MAGICKA));
			ingredients.add(new Ingredient("Nightshade",AlchemyConstants.DAMAGE_HEALTH, AlchemyConstants.BURDEN, AlchemyConstants.DAMAGE_LUCK, AlchemyConstants.FORTIFY_MAGICKA));
			ingredients.add(new Ingredient("Nirnroot",AlchemyConstants.DRAIN_HEALTH, AlchemyConstants.DRAIN_FATIGUE, AlchemyConstants.DRAIN_AGILITY, AlchemyConstants.DRAIN_SPEED));
			ingredients.add(new Ingredient("Ogre's Teeth",AlchemyConstants.DAMAGE_INTELLIGENCE, AlchemyConstants.RESIST_PARALYSIS, AlchemyConstants.SHOCK_DAMAGE, AlchemyConstants.FORTIFY_SPEED));
			ingredients.add(new Ingredient("Onion",AlchemyConstants.RESTORE_FATIGUE, AlchemyConstants.WATER_BREATHING, AlchemyConstants.DETECT_LIFE, AlchemyConstants.DAMAGE_HEALTH));
			ingredients.add(new Ingredient("Orange",AlchemyConstants.RESTORE_FATIGUE, AlchemyConstants.DETECT_LIFE, AlchemyConstants.BURDEN, AlchemyConstants.SHIELD));
			ingredients.add(new Ingredient("Painted Troll Fat",AlchemyConstants.FORTIFY_MAGICKA, AlchemyConstants.RESTORE_HEALTH, AlchemyConstants.FORTIFY_HEALTH, AlchemyConstants.RESTORE_MAGICKA));
			ingredients.add(new Ingredient("Pear",AlchemyConstants.RESTORE_FATIGUE, AlchemyConstants.DAMAGE_SPEED, AlchemyConstants.FORTIFY_HEALTH, AlchemyConstants.DAMAGE_HEALTH));
			ingredients.add(new Ingredient("Peony Seeds",AlchemyConstants.RESTORE_STRENGTH, AlchemyConstants.DAMAGE_HEALTH, AlchemyConstants.DAMAGE_SPEED, AlchemyConstants.RESTORE_FATIGUE));
			ingredients.add(new Ingredient("Pinarus' Prize Minotaur Horn",AlchemyConstants.RESTORE_WILLPOWER, AlchemyConstants.BURDEN, AlchemyConstants.FORTIFY_ENDURANCE, AlchemyConstants.RESIST_PARALYSIS));
			ingredients.add(new Ingredient("Potato",AlchemyConstants.RESTORE_FATIGUE, AlchemyConstants.SHIELD, AlchemyConstants.BURDEN, AlchemyConstants.FROST_SHIELD));
			ingredients.add(new Ingredient("Primrose Leaves",AlchemyConstants.RESTORE_WILLPOWER, AlchemyConstants.RESTORE_PERSONALITY, AlchemyConstants.FORTIFY_LUCK, AlchemyConstants.DAMAGE_STRENGTH));
			ingredients.add(new Ingredient("Pumpkin",AlchemyConstants.RESTORE_FATIGUE, AlchemyConstants.DAMAGE_AGILITY, AlchemyConstants.DAMAGE_PERSONALITY, AlchemyConstants.DETECT_LIFE));
			ingredients.add(new Ingredient("Radish",AlchemyConstants.RESTORE_FATIGUE, AlchemyConstants.DAMAGE_ENDURANCE, AlchemyConstants.CHAMELEON, AlchemyConstants.BURDEN));
			ingredients.add(new Ingredient("Rat Meat",AlchemyConstants.DAMAGE_FATIGUE, AlchemyConstants.DETECT_LIFE, AlchemyConstants.DAMAGE_MAGICKA, AlchemyConstants.SILENCE));
			ingredients.add(new Ingredient("Redwort Flower",AlchemyConstants.RESIST_FROST, AlchemyConstants.CURE_POISON, AlchemyConstants.DAMAGE_HEALTH, AlchemyConstants.INVISIBILITY));
			ingredients.add(new Ingredient("Refined Frost Salts",AlchemyConstants.FROST_DAMAGE, AlchemyConstants.FROST_SHIELD, AlchemyConstants.RESIST_FIRE, AlchemyConstants.SILENCE));
			ingredients.add(new Ingredient("Rice",AlchemyConstants.RESTORE_FATIGUE, AlchemyConstants.SILENCE, AlchemyConstants.SHOCK_SHIELD, AlchemyConstants.DAMAGE_AGILITY));
			ingredients.add(new Ingredient("Root Pulp",AlchemyConstants.CURE_DISEASE, AlchemyConstants.DAMAGE_WILLPOWER, AlchemyConstants.FORTIFY_STRENGTH, AlchemyConstants.DAMAGE_INTELLIGENCE));
			ingredients.add(new Ingredient("Rumare Slaughterfish Scales",AlchemyConstants.DAMAGE_WILLPOWER, AlchemyConstants.WATER_BREATHING, AlchemyConstants.DAMAGE_HEALTH, AlchemyConstants.WATER_WALKING));
			ingredients.add(new Ingredient("S'jirra's Famous Potato Bread",AlchemyConstants.DETECT_LIFE, AlchemyConstants.RESTORE_HEALTH, AlchemyConstants.DAMAGE_AGILITY, AlchemyConstants.DAMAGE_STRENGTH));
			ingredients.add(new Ingredient("Sacred Lotus Seeds",AlchemyConstants.RESIST_FROST, AlchemyConstants.DAMAGE_HEALTH, AlchemyConstants.FEATHER, AlchemyConstants.DISPEL));
			ingredients.add(new Ingredient("Scales",AlchemyConstants.DAMAGE_WILLPOWER, AlchemyConstants.WATER_BREATHING, AlchemyConstants.DAMAGE_HEALTH, AlchemyConstants.WATER_WALKING));
			ingredients.add(new Ingredient("Scamp Skin",AlchemyConstants.DAMAGE_MAGICKA, AlchemyConstants.RESIST_SHOCK, AlchemyConstants.REFLECT_DAMAGE, AlchemyConstants.DAMAGE_HEALTH));
			ingredients.add(new Ingredient("Sheperd's Pie",AlchemyConstants.CURE_DISEASE, AlchemyConstants.SHIELD, AlchemyConstants.FORTIFY_AGILITY, AlchemyConstants.DISPEL));
			ingredients.add(new Ingredient("Somnalius Frond",AlchemyConstants.RESTORE_SPEED, AlchemyConstants.DAMAGE_ENDURANCE, AlchemyConstants.FORTIFY_FATIGUE, AlchemyConstants.FEATHER));
			ingredients.add(new Ingredient("Spiddal Stick",AlchemyConstants.DAMAGE_HEALTH, AlchemyConstants.DAMAGE_MAGICKA, AlchemyConstants.FIRE_DAMAGE, AlchemyConstants.RESTORE_FATIGUE));
			ingredients.add(new Ingredient("St. Jahn's Wort Nectar",AlchemyConstants.RESIST_SHOCK, AlchemyConstants.DAMAGE_HEALTH, AlchemyConstants.CURE_POISON, AlchemyConstants.CHAMELEON));
			ingredients.add(new Ingredient("Steel Blue Entoloma Cap",AlchemyConstants.RESTORE_MAGICKA, AlchemyConstants.FIRE_DAMAGE, AlchemyConstants.RESIST_FROST, AlchemyConstants.BURDEN));
			ingredients.add(new Ingredient("Stinkhorn Cap",AlchemyConstants.DAMAGE_HEALTH, AlchemyConstants.RESTORE_MAGICKA, AlchemyConstants.WATER_WALKING, AlchemyConstants.INVISIBILITY));
			ingredients.add(new Ingredient("Strawberry",AlchemyConstants.RESTORE_FATIGUE, AlchemyConstants.CURE_POISON, AlchemyConstants.DAMAGE_HEALTH, AlchemyConstants.REFLECT_DAMAGE));
			ingredients.add(new Ingredient("Summer Bolete Cap",AlchemyConstants.RESTORE_AGILITY, AlchemyConstants.SHIELD, AlchemyConstants.DAMAGE_PERSONALITY, AlchemyConstants.DAMAGE_ENDURANCE));
			ingredients.add(new Ingredient("Sweetcake",AlchemyConstants.RESTORE_FATIGUE, AlchemyConstants.FEATHER, AlchemyConstants.RESTORE_HEALTH, AlchemyConstants.BURDEN));
			ingredients.add(new Ingredient("Sweetroll",AlchemyConstants.RESTORE_FATIGUE, AlchemyConstants.RESIST_DISEASE, AlchemyConstants.DAMAGE_PERSONALITY, AlchemyConstants.FORTIFY_HEALTH));
			ingredients.add(new Ingredient("Taproot",AlchemyConstants.RESTORE_LUCK, AlchemyConstants.DAMAGE_ENDURANCE, AlchemyConstants.RESIST_POISON, AlchemyConstants.SHOCK_SHIELD));
			ingredients.add(new Ingredient("Tiger Lily Nectar",AlchemyConstants.RESTORE_ENDURANCE, AlchemyConstants.DAMAGE_STRENGTH, AlchemyConstants.WATER_WALKING, AlchemyConstants.DAMAGE_WILLPOWER));
			ingredients.add(new Ingredient("Tinder Polypore Cap",AlchemyConstants.RESTORE_WILLPOWER, AlchemyConstants.RESIST_DISEASE, AlchemyConstants.INVISIBILITY, AlchemyConstants.DAMAGE_MAGICKA));
			ingredients.add(new Ingredient("Tobacco",AlchemyConstants.RESTORE_FATIGUE, AlchemyConstants.RESIST_PARALYSIS, AlchemyConstants.DAMAGE_MAGICKA, AlchemyConstants.DISPEL));
			ingredients.add(new Ingredient("Tomato",AlchemyConstants.RESTORE_FATIGUE, AlchemyConstants.DETECT_LIFE, AlchemyConstants.BURDEN, AlchemyConstants.SHIELD));
			ingredients.add(new Ingredient("Troll Fat",AlchemyConstants.DAMAGE_AGILITY, AlchemyConstants.FORTIFY_PERSONALITY, AlchemyConstants.DAMAGE_WILLPOWER, AlchemyConstants.DAMAGE_HEALTH));
			ingredients.add(new Ingredient("Unicorn Horn",AlchemyConstants.FORTIFY_HEALTH, AlchemyConstants.NONE, AlchemyConstants.NONE, AlchemyConstants.NONE));
			ingredients.add(new Ingredient("Vampire Dust",AlchemyConstants.SILENCE, AlchemyConstants.RESIST_DISEASE, AlchemyConstants.FROST_DAMAGE, AlchemyConstants.INVISIBILITY));
			ingredients.add(new Ingredient("Venison",AlchemyConstants.RESTORE_HEALTH, AlchemyConstants.FEATHER, AlchemyConstants.DAMAGE_HEALTH, AlchemyConstants.CHAMELEON));
			ingredients.add(new Ingredient("Viper's Bugloss Leaves",AlchemyConstants.RESIST_PARALYSIS, AlchemyConstants.NIGHT_EYE, AlchemyConstants.BURDEN, AlchemyConstants.CURE_PARALYSIS));
			ingredients.add(new Ingredient("Void Salts",AlchemyConstants.RESTORE_MAGICKA, AlchemyConstants.DAMAGE_HEALTH, AlchemyConstants.FORTIFY_MAGICKA, AlchemyConstants.DISPEL));
			ingredients.add(new Ingredient("Water Hyacinth Nectar",AlchemyConstants.DAMAGE_LUCK, AlchemyConstants.DAMAGE_FATIGUE, AlchemyConstants.RESTORE_MAGICKA, AlchemyConstants.FORTIFY_MAGICKA));
			ingredients.add(new Ingredient("Watermelon",AlchemyConstants.RESTORE_FATIGUE, AlchemyConstants.LIGHT, AlchemyConstants.BURDEN, AlchemyConstants.DAMAGE_HEALTH));
			ingredients.add(new Ingredient("Wheat Grain",AlchemyConstants.RESTORE_FATIGUE, AlchemyConstants.DAMAGE_MAGICKA, AlchemyConstants.FORTIFY_HEALTH, AlchemyConstants.DAMAGE_PERSONALITY));
			ingredients.add(new Ingredient("White Seed Pod",AlchemyConstants.RESTORE_STRENGTH, AlchemyConstants.WATER_BREATHING, AlchemyConstants.SILENCE, AlchemyConstants.LIGHT));
			ingredients.add(new Ingredient("Wisp Stalk Caps",AlchemyConstants.DAMAGE_HEALTH, AlchemyConstants.DAMAGE_WILLPOWER, AlchemyConstants.DAMAGE_INTELLIGENCE, AlchemyConstants.FORTIFY_SPEED));
			ingredients.add(new Ingredient("Wormwood Leaves",AlchemyConstants.FORTIFY_FATIGUE, AlchemyConstants.INVISIBILITY, AlchemyConstants.DAMAGE_HEALTH, AlchemyConstants.DAMAGE_MAGICKA));
		}
	}
}
