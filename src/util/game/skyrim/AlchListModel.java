/**
 *
 */
package util.game.skyrim;

import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;

/**
 * @author Super
 *
 */
public class AlchListModel extends AbstractListModel<Ingredient>{
	private final List<Ingredient> items;
	private int oldEffect1=0, oldEffect2=0, oldEffect3=0, oldEffect4=0;
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
	public synchronized void filterList(final int effect1, final int effect2, final int effect3, final int effect4) {
		//return if nothing has changed
		if(effect1==oldEffect1 && effect2==oldEffect2 && effect3==oldEffect3 && effect4==oldEffect4)
			return;
		boolean forceFilter= false;
		if (oldEffect1 != 0 && effect1 != oldEffect1 ||
				oldEffect2 != 0 && effect2 != oldEffect2 ||
				oldEffect3 != 0 && effect3 != oldEffect3 ||
				oldEffect4 != 0 && effect4 != oldEffect4){
			// start over if the old !=0 and old != new
			// if the old is 0 then we can just filter what is in the list currently
			items.clear();
			items.addAll(ingredients);
			forceFilter= true;
		}

		if(effect1 != 0 && (forceFilter || effect1 != oldEffect1))
			removeFilter(effect1);
		if(effect2 != 0 && (forceFilter || effect2 != oldEffect2))
			removeFilter(effect2);
		if(effect3 != 0 && (forceFilter || effect3 != oldEffect3))
			removeFilter(effect3);
		if(effect4 != 0 && (forceFilter || effect4 != oldEffect4))
			removeFilter(effect4);

		oldEffect1 = effect1;
		oldEffect2 = effect2;
		oldEffect3 = effect3;
		oldEffect4 = effect4;
		fireContentsChanged(this,0,items.size());
	}
	/**
	 * Removes items without the desired effect
	 * @param skillLevel
	 * @param effect
	 */
	protected void removeFilter(int effect){
		Ingredient item;
		for (int i=0; i<items.size(); i++) {
			item=items.get(i);
			if (! (item.getEffect1() == effect || item.getEffect2() == effect || item.getEffect3() == effect || item.getEffect4() == effect) ) {
				items.remove(i);
				i--;
			}
		}
	}

	protected static final ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
	static {
		if (ingredients.size() == 0) {
			//ingredients.add(new Ingredient("",AlchemyConstants, AlchemyConstants, AlchemyConstants, AlchemyConstants));
			ingredients.add(new Ingredient("Abecean Longfin",AlchemyConstants.WEAKNESS_TO_FROST, AlchemyConstants.FORTIFY_SNEAK, AlchemyConstants.WEAKNESS_TO_POISON, AlchemyConstants.FORTIFY_RESTORATION));
			ingredients.add(new Ingredient("Ancestor Moth Wing:DG",AlchemyConstants.DAMAGE_STAMINA, AlchemyConstants.FORTIFY_CONJURATION, AlchemyConstants.DAMAGE_MAGICKA_REGEN, AlchemyConstants.FORTIFY_ENCHANTING));
			ingredients.add(new Ingredient("Ashen Grass Pod:?",AlchemyConstants.RESIST_FIRE, AlchemyConstants.WEAKNESS_TO_SHOCK, AlchemyConstants.UNKNOWN, AlchemyConstants.FORTIFY_SNEAK));
			ingredients.add(new Ingredient("Bear Claws",AlchemyConstants.RESTORE_STAMINA, AlchemyConstants.FORTIFY_HEALTH, AlchemyConstants.FORTIFY_ONE_HANDED, AlchemyConstants.DAMAGE_MAGICKA_REGEN));
			ingredients.add(new Ingredient("Bee",AlchemyConstants.RESTORE_STAMINA, AlchemyConstants.RAVAGE_STAMINA, AlchemyConstants.REGENERATE_STAMINA, AlchemyConstants.WEAKNESS_TO_SHOCK));
			ingredients.add(new Ingredient("Beehive Husk",AlchemyConstants.RESIST_POISON, AlchemyConstants.FORTIFY_LIGHT_ARMOR, AlchemyConstants.FORTIFY_SNEAK, AlchemyConstants.FORTIFY_DESTRUCTION));
			ingredients.add(new Ingredient("Bleeding Crown",AlchemyConstants.WEAKNESS_TO_FIRE, AlchemyConstants.FORTIFY_BLOCK, AlchemyConstants.WEAKNESS_TO_POISON, AlchemyConstants.RESIST_MAGIC));
			ingredients.add(new Ingredient("Blisterwort",AlchemyConstants.DAMAGE_STAMINA, AlchemyConstants.FRENZY, AlchemyConstants.RESTORE_HEALTH, AlchemyConstants.FORTIFY_SMITHING));
			ingredients.add(new Ingredient("Blue Butterfly Wing",AlchemyConstants.DAMAGE_STAMINA, AlchemyConstants.FORTIFY_CONJURATION, AlchemyConstants.DAMAGE_MAGICKA_REGEN, AlchemyConstants.FORTIFY_ENCHANTING));
			ingredients.add(new Ingredient("Blue Dartwing",AlchemyConstants.RESIST_SHOCK, AlchemyConstants.FORTIFY_PICKPOCKET, AlchemyConstants.RESTORE_HEALTH, AlchemyConstants.FEAR));
			ingredients.add(new Ingredient("Blue Mountain Flower",AlchemyConstants.RESTORE_HEALTH, AlchemyConstants.FORTIFY_CONJURATION, AlchemyConstants.FORTIFY_HEALTH, AlchemyConstants.DAMAGE_MAGICKA_REGEN));
			ingredients.add(new Ingredient("Bone Meal",AlchemyConstants.DAMAGE_STAMINA, AlchemyConstants.RESIST_FIRE, AlchemyConstants.FORTIFY_CONJURATION, AlchemyConstants.RAVAGE_STAMINA));
			ingredients.add(new Ingredient("Briar Heart",AlchemyConstants.RESTORE_MAGICKA, AlchemyConstants.FORTIFY_BLOCK, AlchemyConstants.PARALYSIS, AlchemyConstants.FORTIFY_MAGICKA));
			ingredients.add(new Ingredient("Burnt Spriggan Wood:?",AlchemyConstants.WEAKNESS_TO_FIRE, AlchemyConstants.UNKNOWN, AlchemyConstants.UNKNOWN, AlchemyConstants.UNKNOWN));
			ingredients.add(new Ingredient("Butterfly Wing",AlchemyConstants.RESTORE_HEALTH, AlchemyConstants.FORTIFY_BARTER, AlchemyConstants.LINGERING_DAMAGE_STAMINA, AlchemyConstants.DAMAGE_MAGICKA));
			ingredients.add(new Ingredient("Canis Root",AlchemyConstants.DAMAGE_STAMINA, AlchemyConstants.FORTIFY_ONE_HANDED, AlchemyConstants.FORTIFY_MARKSMAN, AlchemyConstants.PARALYSIS));
			ingredients.add(new Ingredient("Charred Skeever Hide",AlchemyConstants.RESTORE_STAMINA, AlchemyConstants.CURE_DISEASE, AlchemyConstants.RESIST_POISON, AlchemyConstants.RESTORE_HEALTH));
			ingredients.add(new Ingredient("Chaurus Eggs",AlchemyConstants.WEAKNESS_TO_POISON, AlchemyConstants.FORTIFY_STAMINA, AlchemyConstants.DAMAGE_MAGICKA, AlchemyConstants.INVISIBILITY));
			ingredients.add(new Ingredient("Chaurus Hunter Antennae:DG",AlchemyConstants.DAMAGE_STAMINA, AlchemyConstants.FORTIFY_CONJURATION, AlchemyConstants.DAMAGE_MAGICKA_REGEN, AlchemyConstants.FORTIFY_ENCHANTING));
			ingredients.add(new Ingredient("Chicken's Egg",AlchemyConstants.RESIST_MAGIC, AlchemyConstants.DAMAGE_MAGICKA_REGEN, AlchemyConstants.WATERBREATHING, AlchemyConstants.LINGERING_DAMAGE_STAMINA));
			ingredients.add(new Ingredient("Creep Cluster",AlchemyConstants.RESTORE_MAGICKA, AlchemyConstants.DAMAGE_STAMINA_REGEN, AlchemyConstants.FORTIFY_CARRY_WEIGHT, AlchemyConstants.WEAKNESS_TO_MAGIC));
			ingredients.add(new Ingredient("Crimson Nirnroot",AlchemyConstants.DAMAGE_HEALTH, AlchemyConstants.DAMAGE_STAMINA, AlchemyConstants.INVISIBILITY, AlchemyConstants.RESIST_MAGIC));
			ingredients.add(new Ingredient("Cyrodilic Spadetail",AlchemyConstants.DAMAGE_STAMINA, AlchemyConstants.FORTIFY_RESTORATION, AlchemyConstants.FEAR, AlchemyConstants.RAVAGE_HEALTH));
			ingredients.add(new Ingredient("Daedra Heart",AlchemyConstants.RESTORE_HEALTH, AlchemyConstants.DAMAGE_STAMINA_REGEN, AlchemyConstants.DAMAGE_MAGICKA, AlchemyConstants.FEAR));
			ingredients.add(new Ingredient("Deathbell",AlchemyConstants.DAMAGE_HEALTH, AlchemyConstants.RAVAGE_STAMINA, AlchemyConstants.SLOW, AlchemyConstants.WEAKNESS_TO_POISON));
			ingredients.add(new Ingredient("Dragon's Tongue",AlchemyConstants.RESIST_FIRE, AlchemyConstants.FORTIFY_BARTER, AlchemyConstants.FORTIFY_ILLUSION, AlchemyConstants.FORTIFY_TWO_HANDED));
			ingredients.add(new Ingredient("Dwarven Oil",AlchemyConstants.WEAKNESS_TO_MAGIC, AlchemyConstants.FORTIFY_ILLUSION, AlchemyConstants.REGENERATE_MAGICKA, AlchemyConstants.RESTORE_MAGICKA));
			ingredients.add(new Ingredient("Ectoplasm",AlchemyConstants.RESTORE_MAGICKA, AlchemyConstants.FORTIFY_DESTRUCTION, AlchemyConstants.FORTIFY_MAGICKA, AlchemyConstants.DAMAGE_HEALTH));
			ingredients.add(new Ingredient("Elves Ear",AlchemyConstants.RESTORE_MAGICKA, AlchemyConstants.FORTIFY_MARKSMAN, AlchemyConstants.WEAKNESS_TO_FROST, AlchemyConstants.RESIST_FIRE));
			ingredients.add(new Ingredient("Eye of Sabre Cat",AlchemyConstants.RESTORE_STAMINA, AlchemyConstants.RAVAGE_HEALTH, AlchemyConstants.DAMAGE_MAGICKA, AlchemyConstants.RESTORE_HEALTH));
			ingredients.add(new Ingredient("Falmer Ear",AlchemyConstants.DAMAGE_HEALTH, AlchemyConstants.FRENZY, AlchemyConstants.RESIST_POISON, AlchemyConstants.FORTIFY_LOCKPICKING));
			ingredients.add(new Ingredient("Fire Salts",AlchemyConstants.WEAKNESS_TO_FROST, AlchemyConstants.RESIST_FIRE, AlchemyConstants.RESTORE_MAGICKA, AlchemyConstants.REGENERATE_MAGICKA));
			ingredients.add(new Ingredient("Fly Amanita",AlchemyConstants.RESIST_FIRE, AlchemyConstants.FORTIFY_TWO_HANDED, AlchemyConstants.FRENZY, AlchemyConstants.REGENERATE_STAMINA));
			ingredients.add(new Ingredient("Frost Mirriam",AlchemyConstants.RESIST_FROST, AlchemyConstants.FORTIFY_SNEAK, AlchemyConstants.RAVAGE_MAGICKA, AlchemyConstants.DAMAGE_STAMINA));
			ingredients.add(new Ingredient("Frost Salts",AlchemyConstants.WEAKNESS_TO_FIRE, AlchemyConstants.RESIST_FROST, AlchemyConstants.RESTORE_MAGICKA, AlchemyConstants.FORTIFY_CONJURATION));
			ingredients.add(new Ingredient("Garlic",AlchemyConstants.RESIST_POISON, AlchemyConstants.FORTIFY_STAMINA, AlchemyConstants.REGENERATE_MAGICKA, AlchemyConstants.REGENERATE_HEALTH));
			ingredients.add(new Ingredient("Giant Lichen",AlchemyConstants.WEAKNESS_TO_SHOCK, AlchemyConstants.RAVAGE_HEALTH, AlchemyConstants.WEAKNESS_TO_POISON, AlchemyConstants.RESTORE_MAGICKA));
			ingredients.add(new Ingredient("Gleamblossom:DG",AlchemyConstants.RESIST_MAGIC, AlchemyConstants.FEAR, AlchemyConstants.REGENERATE_HEALTH, AlchemyConstants.PARALYSIS));
			ingredients.add(new Ingredient("Giant's Toe",AlchemyConstants.DAMAGE_STAMINA, AlchemyConstants.FORTIFY_HEALTH, AlchemyConstants.FORTIFY_CARRY_WEIGHT, AlchemyConstants.DAMAGE_STAMINA_REGEN));
			ingredients.add(new Ingredient("Glow Dust",AlchemyConstants.DAMAGE_MAGICKA, AlchemyConstants.DAMAGE_MAGICKA_REGEN, AlchemyConstants.FORTIFY_DESTRUCTION, AlchemyConstants.RESIST_SHOCK));
			ingredients.add(new Ingredient("Glowing Mushroom",AlchemyConstants.RESIST_SHOCK, AlchemyConstants.FORTIFY_DESTRUCTION, AlchemyConstants.FORTIFY_SMITHING, AlchemyConstants.FORTIFY_HEALTH));
			ingredients.add(new Ingredient("Grass Pod",AlchemyConstants.RESIST_POISON, AlchemyConstants.RAVAGE_MAGICKA, AlchemyConstants.FORTIFY_ALTERATION, AlchemyConstants.RESTORE_MAGICKA));
			ingredients.add(new Ingredient("Hagraven Claw",AlchemyConstants.RESIST_MAGIC, AlchemyConstants.LINGERING_DAMAGE_MAGICKA, AlchemyConstants.FORTIFY_ENCHANTING, AlchemyConstants.FORTIFY_BARTER));
			ingredients.add(new Ingredient("Hagraven Feathers",	AlchemyConstants.DAMAGE_MAGICKA, AlchemyConstants.FORTIFY_CONJURATION, AlchemyConstants.FRENZY, AlchemyConstants.WEAKNESS_TO_FROST));
			ingredients.add(new Ingredient("Hanging Moss",		AlchemyConstants.DAMAGE_MAGICKA, AlchemyConstants.FORTIFY_HEALTH, AlchemyConstants.DAMAGE_MAGICKA_REGEN, AlchemyConstants.FORTIFY_ONE_HANDED));
			ingredients.add(new Ingredient("Hawk Beak",			AlchemyConstants.RESTORE_STAMINA, AlchemyConstants.RESIST_FROST, AlchemyConstants.FORTIFY_CARRY_WEIGHT, AlchemyConstants.RESIST_SHOCK));
			ingredients.add(new Ingredient("Hawk Feathers",		AlchemyConstants.CURE_DISEASE, AlchemyConstants.FORTIFY_LIGHT_ARMOR, AlchemyConstants.FORTIFY_ONE_HANDED, AlchemyConstants.FORTIFY_SNEAK));
			ingredients.add(new Ingredient("Hawk's Egg:HF",AlchemyConstants.RESIST_MAGIC, AlchemyConstants.DAMAGE_MAGICKA_REGEN, AlchemyConstants.WATERBREATHING, AlchemyConstants.LINGERING_DAMAGE_STAMINA));
			ingredients.add(new Ingredient("Histcarp",			AlchemyConstants.RESTORE_STAMINA, AlchemyConstants.FORTIFY_MAGICKA, AlchemyConstants.DAMAGE_STAMINA_REGEN, AlchemyConstants.WATERBREATHING));
			ingredients.add(new Ingredient("Honeycomb",			AlchemyConstants.RESTORE_STAMINA, AlchemyConstants.FORTIFY_BLOCK, AlchemyConstants.FORTIFY_LIGHT_ARMOR, AlchemyConstants.RAVAGE_STAMINA));
			ingredients.add(new Ingredient("Human Flesh",		AlchemyConstants.DAMAGE_HEALTH, AlchemyConstants.PARALYSIS, AlchemyConstants.RESTORE_MAGICKA, AlchemyConstants.FORTIFY_SNEAK));
			ingredients.add(new Ingredient("Human Heart",		AlchemyConstants.DAMAGE_HEALTH, AlchemyConstants.DAMAGE_MAGICKA, AlchemyConstants.DAMAGE_MAGICKA_REGEN, AlchemyConstants.FRENZY));
			ingredients.add(new Ingredient("Ice Wraith Teeth",	AlchemyConstants.WEAKNESS_TO_FROST, AlchemyConstants.FORTIFY_HEAVY_ARMOR, AlchemyConstants.INVISIBILITY, AlchemyConstants.WEAKNESS_TO_FIRE));
			ingredients.add(new Ingredient("Imp Stool",			AlchemyConstants.DAMAGE_HEALTH, AlchemyConstants.DAMAGE_MAGICKA, AlchemyConstants.DAMAGE_MAGICKA_REGEN, AlchemyConstants.FRENZY));
			ingredients.add(new Ingredient("Jazbay Grapes",		AlchemyConstants.WEAKNESS_TO_MAGIC, AlchemyConstants.FORTIFY_MAGICKA, AlchemyConstants.REGENERATE_MAGICKA, AlchemyConstants.RAVAGE_HEALTH));
			ingredients.add(new Ingredient("Juniper Berries",	AlchemyConstants.WEAKNESS_TO_FIRE, AlchemyConstants.FORTIFY_MARKSMAN, AlchemyConstants.REGENERATE_HEALTH, AlchemyConstants.DAMAGE_STAMINA_REGEN));
			ingredients.add(new Ingredient("Large Antlers",	AlchemyConstants.RESTORE_STAMINA, AlchemyConstants.FORTIFY_STAMINA, AlchemyConstants.SLOW, AlchemyConstants.DAMAGE_STAMINA_REGEN));
			ingredients.add(new Ingredient("Lavender",	AlchemyConstants.RESIST_MAGIC, AlchemyConstants.FORTIFY_STAMINA, AlchemyConstants.RAVAGE_MAGICKA, AlchemyConstants.FORTIFY_CONJURATION));
			ingredients.add(new Ingredient("Luna Moth Wing",	AlchemyConstants.DAMAGE_MAGICKA, AlchemyConstants.FORTIFY_LIGHT_ARMOR, AlchemyConstants.REGENERATE_HEALTH, AlchemyConstants.INVISIBILITY));
			ingredients.add(new Ingredient("Moon Sugar",	AlchemyConstants.WEAKNESS_TO_FIRE, AlchemyConstants.RESIST_FROST, AlchemyConstants.RESTORE_MAGICKA, AlchemyConstants.REGENERATE_MAGICKA));
			ingredients.add(new Ingredient("Mora Tapinella",	AlchemyConstants.RESTORE_MAGICKA, AlchemyConstants.LINGERING_DAMAGE_HEALTH, AlchemyConstants.REGENERATE_STAMINA, AlchemyConstants.FORTIFY_ILLUSION));
			ingredients.add(new Ingredient("Mudcrab Chitin",	AlchemyConstants.RESTORE_STAMINA, AlchemyConstants.CURE_DISEASE, AlchemyConstants.RESIST_POISON, AlchemyConstants.RESIST_FIRE));
			ingredients.add(new Ingredient("Namira's Rot",	AlchemyConstants.DAMAGE_MAGICKA, AlchemyConstants.FORTIFY_LOCKPICKING, AlchemyConstants.FEAR, AlchemyConstants.REGENERATE_HEALTH));
			ingredients.add(new Ingredient("Nightshade",	AlchemyConstants.DAMAGE_HEALTH, AlchemyConstants.DAMAGE_MAGICKA_REGEN, AlchemyConstants.LINGERING_DAMAGE_STAMINA, AlchemyConstants.FORTIFY_DESTRUCTION));
			ingredients.add(new Ingredient("Nirnroot",	AlchemyConstants.DAMAGE_HEALTH, AlchemyConstants.DAMAGE_STAMINA, AlchemyConstants.INVISIBILITY, AlchemyConstants.RESIST_MAGIC));
			ingredients.add(new Ingredient("Nordic Barnacle",	AlchemyConstants.DAMAGE_MAGICKA, AlchemyConstants.WATERBREATHING, AlchemyConstants.REGENERATE_HEALTH, AlchemyConstants.FORTIFY_PICKPOCKET));
			ingredients.add(new Ingredient("Orange Dartwing",	AlchemyConstants.RESTORE_STAMINA, AlchemyConstants.RAVAGE_MAGICKA, AlchemyConstants.FORTIFY_PICKPOCKET, AlchemyConstants.LINGERING_DAMAGE_HEALTH));
			ingredients.add(new Ingredient("Pearl",	AlchemyConstants.RESTORE_STAMINA, AlchemyConstants.FORTIFY_BLOCK, AlchemyConstants.RESTORE_MAGICKA, AlchemyConstants.RESIST_SHOCK));
			ingredients.add(new Ingredient("Pine Thrush Egg",	AlchemyConstants.RESTORE_STAMINA, AlchemyConstants.FORTIFY_LOCKPICKING, AlchemyConstants.WEAKNESS_TO_POISON, AlchemyConstants.RESIST_SHOCK));
			ingredients.add(new Ingredient("Poison Bloom:DG",AlchemyConstants.DAMAGE_HEALTH, AlchemyConstants.SLOW, AlchemyConstants.FORTIFY_CARRY_WEIGHT, AlchemyConstants.FEAR));
			ingredients.add(new Ingredient("Powdered Mammoth Tusk",	AlchemyConstants.RESTORE_STAMINA, AlchemyConstants.FORTIFY_SNEAK, AlchemyConstants.WEAKNESS_TO_FIRE, AlchemyConstants.FEAR));
			ingredients.add(new Ingredient("Purple Mountain Flower",	AlchemyConstants.RESTORE_STAMINA, AlchemyConstants.FORTIFY_SNEAK, AlchemyConstants.LINGERING_DAMAGE_MAGICKA, AlchemyConstants.RESIST_FROST));
			ingredients.add(new Ingredient("Red Mountain Flower",	AlchemyConstants.RESTORE_MAGICKA, AlchemyConstants.RAVAGE_MAGICKA, AlchemyConstants.FORTIFY_MAGICKA, AlchemyConstants.DAMAGE_HEALTH));
			ingredients.add(new Ingredient("River Betty",	AlchemyConstants.DAMAGE_HEALTH, AlchemyConstants.FORTIFY_ALTERATION, AlchemyConstants.SLOW, AlchemyConstants.FORTIFY_CARRY_WEIGHT));
			ingredients.add(new Ingredient("Rock Warbler Egg",	AlchemyConstants.RESTORE_HEALTH, AlchemyConstants.FORTIFY_ONE_HANDED, AlchemyConstants.DAMAGE_STAMINA, AlchemyConstants.WEAKNESS_TO_MAGIC));
			ingredients.add(new Ingredient("Sabre Cat Tooth",	AlchemyConstants.RESTORE_STAMINA, AlchemyConstants.FORTIFY_HEAVY_ARMOR, AlchemyConstants.FORTIFY_SMITHING, AlchemyConstants.WEAKNESS_TO_POISON));
			ingredients.add(new Ingredient("Salmon Roe:HF",AlchemyConstants.RESTORE_STAMINA, AlchemyConstants.WATERBREATHING, AlchemyConstants.FORTIFY_MAGICKA, AlchemyConstants.RESTORE_MAGICKA));
			ingredients.add(new Ingredient("Salt Pile",	AlchemyConstants.WEAKNESS_TO_MAGIC, AlchemyConstants.FORTIFY_RESTORATION, AlchemyConstants.SLOW, AlchemyConstants.REGENERATE_MAGICKA));
			ingredients.add(new Ingredient("Scaly Pholiota",	AlchemyConstants.WEAKNESS_TO_MAGIC, AlchemyConstants.FORTIFY_ILLUSION, AlchemyConstants.REGENERATE_STAMINA, AlchemyConstants.FORTIFY_CARRY_WEIGHT));
			ingredients.add(new Ingredient("Silverside Perch",	AlchemyConstants.RESTORE_STAMINA, AlchemyConstants.DAMAGE_STAMINA_REGEN, AlchemyConstants.RAVAGE_HEALTH, AlchemyConstants.RESIST_FROST));
			ingredients.add(new Ingredient("Skeever Tail",	AlchemyConstants.DAMAGE_STAMINA_REGEN, AlchemyConstants.RAVAGE_HEALTH, AlchemyConstants.DAMAGE_HEALTH, AlchemyConstants.FORTIFY_LIGHT_ARMOR));
			ingredients.add(new Ingredient("Slaughterfish Egg",	AlchemyConstants.RESIST_POISON, AlchemyConstants.FORTIFY_PICKPOCKET, AlchemyConstants.LINGERING_DAMAGE_HEALTH, AlchemyConstants.FORTIFY_STAMINA));
			ingredients.add(new Ingredient("Slaughterfish Scales",	AlchemyConstants.RESIST_FROST, AlchemyConstants.LINGERING_DAMAGE_HEALTH, AlchemyConstants.FORTIFY_HEAVY_ARMOR, AlchemyConstants.FORTIFY_BLOCK));
			ingredients.add(new Ingredient("Small Antlers",	AlchemyConstants.WEAKNESS_TO_POISON, AlchemyConstants.FORTIFY_RESTORATION, AlchemyConstants.LINGERING_DAMAGE_STAMINA, AlchemyConstants.DAMAGE_HEALTH));
			ingredients.add(new Ingredient("Small Pearl",	AlchemyConstants.RESTORE_STAMINA, AlchemyConstants.FORTIFY_ONE_HANDED, AlchemyConstants.FORTIFY_RESTORATION, AlchemyConstants.RESIST_FROST));
			ingredients.add(new Ingredient("Snowberries",	AlchemyConstants.RESIST_FIRE, AlchemyConstants.FORTIFY_ENCHANTING, AlchemyConstants.RESIST_FROST, AlchemyConstants.RESIST_SHOCK));
			ingredients.add(new Ingredient("Spawn Ash:?",AlchemyConstants.RAVAGE_STAMINA, AlchemyConstants.RESIST_FIRE, AlchemyConstants.FORTIFY_ENCHANTING, AlchemyConstants.RAVAGE_MAGICKA));
			ingredients.add(new Ingredient("Spider Egg",	AlchemyConstants.DAMAGE_STAMINA, AlchemyConstants.DAMAGE_MAGICKA_REGEN, AlchemyConstants.FORTIFY_LOCKPICKING, AlchemyConstants.FORTIFY_MARKSMAN));
			ingredients.add(new Ingredient("Spriggan Sap",	AlchemyConstants.DAMAGE_MAGICKA_REGEN, AlchemyConstants.FORTIFY_ENCHANTING, AlchemyConstants.FORTIFY_SMITHING, AlchemyConstants.FORTIFY_ALTERATION));
			ingredients.add(new Ingredient("Swamp Fungal Pod",	AlchemyConstants.RESIST_SHOCK, AlchemyConstants.LINGERING_DAMAGE_MAGICKA, AlchemyConstants.PARALYSIS, AlchemyConstants.RESTORE_HEALTH));
			ingredients.add(new Ingredient("Taproot",	AlchemyConstants.WEAKNESS_TO_MAGIC, AlchemyConstants.FORTIFY_ILLUSION, AlchemyConstants.REGENERATE_MAGICKA, AlchemyConstants.RESTORE_MAGICKA));
			ingredients.add(new Ingredient("Thistle Branch",	AlchemyConstants.RESIST_FROST, AlchemyConstants.RAVAGE_STAMINA, AlchemyConstants.RESIST_POISON, AlchemyConstants.FORTIFY_HEAVY_ARMOR));
			ingredients.add(new Ingredient("Torchbug Thorax",	AlchemyConstants.RESTORE_STAMINA, AlchemyConstants.LINGERING_DAMAGE_MAGICKA, AlchemyConstants.WEAKNESS_TO_MAGIC, AlchemyConstants.FORTIFY_STAMINA));
			ingredients.add(new Ingredient("Trama Root:?",AlchemyConstants.WEAKNESS_TO_SHOCK, AlchemyConstants.FORTIFY_CARRY_WEIGHT, AlchemyConstants.UNKNOWN, AlchemyConstants.SLOW));
			ingredients.add(new Ingredient("Troll Fat",	AlchemyConstants.RESIST_POISON, AlchemyConstants.FORTIFY_TWO_HANDED, AlchemyConstants.FRENZY, AlchemyConstants.DAMAGE_HEALTH));
			ingredients.add(new Ingredient("Tundra Cotton",	AlchemyConstants.RESIST_MAGIC, AlchemyConstants.FORTIFY_MAGICKA, AlchemyConstants.FORTIFY_BLOCK, AlchemyConstants.FORTIFY_BARTER));
			ingredients.add(new Ingredient("Vampire Dust",	AlchemyConstants.INVISIBILITY, AlchemyConstants.RESTORE_MAGICKA, AlchemyConstants.REGENERATE_HEALTH, AlchemyConstants.CURE_DISEASE));
			ingredients.add(new Ingredient("Void Salts",	AlchemyConstants.WEAKNESS_TO_SHOCK, AlchemyConstants.RESIST_MAGIC, AlchemyConstants.DAMAGE_HEALTH, AlchemyConstants.FORTIFY_MAGICKA));
			ingredients.add(new Ingredient("Wheat",	AlchemyConstants.RESTORE_HEALTH, AlchemyConstants.FORTIFY_HEALTH, AlchemyConstants.DAMAGE_STAMINA_REGEN, AlchemyConstants.LINGERING_DAMAGE_MAGICKA));
			ingredients.add(new Ingredient("White Cap",	AlchemyConstants.WEAKNESS_TO_FROST, AlchemyConstants.FORTIFY_HEAVY_ARMOR, AlchemyConstants.RESTORE_MAGICKA, AlchemyConstants.RAVAGE_MAGICKA));
			ingredients.add(new Ingredient("Wisp Wrappings",	AlchemyConstants.RESTORE_STAMINA, AlchemyConstants.FORTIFY_DESTRUCTION, AlchemyConstants.FORTIFY_CARRY_WEIGHT, AlchemyConstants.RESIST_MAGIC));
			ingredients.add(new Ingredient("Yellow Mountian Flower:DG",AlchemyConstants.RESIST_POISON, AlchemyConstants.FORTIFY_RESTORATION, AlchemyConstants.FORTIFY_HEALTH, AlchemyConstants.DAMAGE_STAMINA_REGEN));
		}
	}
}
