/**
 *
 */
package util.game.skyrim;

import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import simple.gui.factory.SJPanel;
import simple.gui.factory.SwingFactory;
import simple.gui.factory.TextFactory;


/**
 * <br>Created: Jan 11, 2012
 * @author Kenneth Pierce
 */
/**
 * @author Super
 *
 */
public class Alchemy extends JPanel {
	/**
	 *
	 */
	private static final long serialVersionUID = -8384317732137294496L;

	final JComboBox<String> effectList1 = new JComboBox<String>(AlchemyConstants.getEffectList());
	final JComboBox<String> effectList2 = new JComboBox<String>(AlchemyConstants.getEffectList());
	final JComboBox<String> effectList3 = new JComboBox<String>(AlchemyConstants.getEffectList());
	final JComboBox<String> effectList4 = new JComboBox<String>(AlchemyConstants.getEffectList());
	final AlchListModel
		mainList= new AlchListModel(),
		combineableList= new AlchListModel();
	final JList<Ingredient>
		mainListDisplay = new JList<Ingredient>(mainList),
		combineableListDisplay= new JList<Ingredient>(combineableList);
	public Alchemy() {
		super(new BorderLayout());
		mainListDisplay.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		combineableListDisplay.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		mainListDisplay.setFont(TextFactory.getMonoFont());
		combineableListDisplay.setFont(TextFactory.getMonoFont());
		mainListDisplay.addListSelectionListener(new ListSelectionListener(){
			Ingredient lastItem= null;
			@Override
			public void valueChanged(ListSelectionEvent e){
				/*
				 * This event works strangely.
				 * The indexes are useless in single selection mode
				 */
				Ingredient item= mainListDisplay.getSelectedValue();
				// because it fires on mouse down and mouse up
				if(item != lastItem){
//					combineableList.filterList(null);
					lastItem= item;
					combineableList.filterList(item);
				}
			}
		});

		JPanel top = SJPanel.makeBoxLayoutPanelX();
		effectList1.addItemListener(effectsListener);
		effectList2.addItemListener(effectsListener);
		effectList3.addItemListener(effectsListener);
		effectList4.addItemListener(effectsListener);
		top.add(effectList1);
		top.add(effectList2);
		top.add(effectList3);
		top.add(effectList4);
		add(top, BorderLayout.NORTH);
		add( new JSplitPane(JSplitPane.VERTICAL_SPLIT,
				new JScrollPane(mainListDisplay),
				new JScrollPane(combineableListDisplay)
			)
		);
	}
	private final ItemListener effectsListener= new ItemListener(){
		@Override
		public void itemStateChanged(ItemEvent ie){
			if (ie.getStateChange() == ItemEvent.SELECTED) {
				mainList.filterList(effectList1.getSelectedIndex(),effectList2.getSelectedIndex(),effectList3.getSelectedIndex(),effectList4.getSelectedIndex());
			}
		}
	};
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame frame = SwingFactory.makeDefaultJFrame("Skyrim Alchemy");
		JComponent con = new Alchemy();
		con.setOpaque(true);
		frame.setContentPane(con);
		frame.pack();
		//frame.setSize(200, 300);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
