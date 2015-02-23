/**
 *
 */
package util.game.oblivion;

import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.AbstractTableModel;

import simple.gui.factory.SJPanel;
import simple.gui.factory.SwingFactory;
import simple.gui.factory.TextFactory;

/**
 * <br>Created: Feb 25, 2009
 * @author Kenneth Pierce
 */
public class Alchemy extends JPanel implements ItemListener, ChangeListener {
	/**
	 *
	 */
	private static final long serialVersionUID = -8384317732137294496L;
	protected static final Vector<Ingredient> ingredients = new Vector<Ingredient>();
	protected final class TableDataModel extends AbstractTableModel {

		/**
		 *
		 */
		private static final long serialVersionUID = -6657699588733550084L;

		/* (non-Javadoc)
		 * @see javax.swing.table.TableModel#getColumnCount()
		 */
		@Override
		public int getColumnCount() {
			return 5;
		}

		/* (non-Javadoc)
		 * @see javax.swing.table.TableModel#getRowCount()
		 */
		@Override
		public int getRowCount() {
			return ingredients.size();
		}

		/* (non-Javadoc)
		 * @see javax.swing.table.TableModel#getValueAt(int, int)
		 */
		@Override
		public Object getValueAt(int row, int col) {
			switch (col) {
			case 0:
				return ingredients.get(row).getName();
			case 1:
				return ingredients.get(row).getEffect1();
			case 2:
				return ingredients.get(row).getEffect2();
			case 3:
				return ingredients.get(row).getEffect3();
			case 4:
				return ingredients.get(row).getEffect4();
			}
			return null;
		}

		/* (non-Javadoc)
		 * @see javax.swing.table.AbstractTableModel#getColumnName(int)
		 */
		@Override
		public String getColumnName(int column) {
			switch (column) {
			case 0:
				return "Name";
			case 1:
				return "Effect 1";
			case 2:
				return "Effect 2";
			case 3:
				return "Effect 3";
			case 4:
				return "Effect 4";
			}
			return super.getColumnName(column);
		}

		/* (non-Javadoc)
		 * @see javax.swing.table.AbstractTableModel#isCellEditable(int, int)
		 */
		@Override
		public boolean isCellEditable(int rowIndex, int columnIndex) {
			return false;
		}

	}
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
	final JComboBox<String> effectList1 = new JComboBox<String>(AlchemyConstants.getEffectList());
	final JComboBox<String> effectList2 = new JComboBox<String>(AlchemyConstants.getEffectList());
	final JComboBox<String> effectList3 = new JComboBox<String>(AlchemyConstants.getEffectList());
	final JComboBox<String> effectList4 = new JComboBox<String>(AlchemyConstants.getEffectList());
	final JList<Ingredient> itemList = new JList<Ingredient>();
	final JSlider level = new JSlider(JSlider.VERTICAL, 1, 4, 4);
	final Vector<Ingredient> items = new Vector<Ingredient>();
	public Alchemy() {
		super(new BorderLayout());
		itemList.setFont(TextFactory.MONOSPACE);
		JPanel top = SJPanel.makeBoxLayoutPanelX();
		effectList1.addItemListener(this);
		effectList2.addItemListener(this);
		effectList3.addItemListener(this);
		effectList4.addItemListener(this);
		level.addChangeListener(this);
		top.add(effectList1);
		top.add(effectList2);
		top.add(effectList3);
		top.add(effectList4);
		add(top, BorderLayout.NORTH);
		add(new JScrollPane(itemList));
		add(level, BorderLayout.EAST);
		level.setToolTipText("Skill Level");
		itemList.setListData(ingredients);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame frame = SwingFactory.makeDefaultJFrame("Oblivion Alchemy");
		JComponent con = new Alchemy();
		con.setOpaque(true);
		frame.setContentPane(con);
		frame.pack();
		//frame.setSize(200, 300);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	protected void updateList() {
		items.clear();
		if (effectList1.getSelectedIndex()==0) {
			items.addAll(ingredients);
		} else {
			for (Ingredient item : ingredients) {
				if (item.getEffect1() == effectList1.getSelectedIndex()) {
					items.add(item);
				} else if (level.getValue() > 1 &&item.getEffect2() == effectList1.getSelectedIndex()) {
					items.add(item);
				} else if (level.getValue() > 2 && item.getEffect3() == effectList1.getSelectedIndex()) {
					items.add(item);
				} else if (level.getValue() > 3 && item.getEffect4() == effectList1.getSelectedIndex()) {
					items.add(item);
				}
			}
		}
		if (effectList2.getSelectedIndex() > 0)
			filterList(effectList2.getSelectedIndex());
		if (effectList3.getSelectedIndex() > 0)
			filterList(effectList3.getSelectedIndex());
		if (effectList4.getSelectedIndex() > 0)
			filterList(effectList4.getSelectedIndex());
		itemList.setListData(items);
	}
	protected void filterList(int effect) {
		boolean keep = false;
		for (Ingredient item : ingredients) {
			if (item.getEffect1() == effect) {
				keep = true;
			} else if (level.getValue() > 1 &&item.getEffect2() == effect) {
				keep = true;
			} else if (level.getValue() > 2 && item.getEffect3() == effect) {
				keep = true;
			} else if (level.getValue() > 3 && item.getEffect4() == effect) {
				keep = true;
			}
			if (!keep) {
				items.remove(item);
			}
			keep = false;
		}
		itemList.setListData(items);
	}
	/* (non-Javadoc)
	 * @see java.awt.event.ItemListener#itemStateChanged(java.awt.event.ItemEvent)
	 */
	@Override
	public void itemStateChanged(ItemEvent ie) {
		if (ie.getStateChange() == ItemEvent.SELECTED) {
			updateList();
		}
	}
	/* (non-Javadoc)
	 * @see javax.swing.event.ChangeListener#stateChanged(javax.swing.event.ChangeEvent)
	 */
	@Override
	public void stateChanged(ChangeEvent ce) {
		updateList();
	}

}
