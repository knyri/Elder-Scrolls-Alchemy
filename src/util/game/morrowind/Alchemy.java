/**
 *
 */
package util.game.morrowind;

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
		public Object getValueAt(final int row, final int col) {
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
		public String getColumnName(final int column) {
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
		public boolean isCellEditable(final int rowIndex, final int columnIndex) {
			return false;
		}

	}
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
		final JPanel top = SJPanel.makeBoxLayoutPanelX();
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
	public static void main(final String[] args) {
		final JFrame frame = SwingFactory.makeDefaultJFrame("Oblivion Alchemy");
		final JComponent con = new Alchemy();
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
			for (final Ingredient item : ingredients) {
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
		if (effectList2.getSelectedIndex() > 0){
			filterList(effectList2.getSelectedIndex());
		}
		if (effectList3.getSelectedIndex() > 0){
			filterList(effectList3.getSelectedIndex());
		}
		if (effectList4.getSelectedIndex() > 0){
			filterList(effectList4.getSelectedIndex());
		}
		itemList.setListData(items);
	}
	protected void filterList(final int effect) {
		boolean keep = false;
		for (final Ingredient item : ingredients) {
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
	public void itemStateChanged(final ItemEvent ie) {
		if (ie.getStateChange() == ItemEvent.SELECTED) {
			updateList();
		}
	}
	/* (non-Javadoc)
	 * @see javax.swing.event.ChangeListener#stateChanged(javax.swing.event.ChangeEvent)
	 */
	@Override
	public void stateChanged(final ChangeEvent ce) {
		updateList();
	}

}
