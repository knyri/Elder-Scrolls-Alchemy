/**
 *
 */
package util.game.oblivion;

import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import simple.gui.factory.SJPanel;
import simple.gui.factory.SwingFactory;
import simple.gui.factory.TextFactory;

/**
 * <br>Created: Feb 25, 2009
 * @author Kenneth Pierce
 */
public class Alchemy extends JPanel implements ItemListener, ChangeListener {
	private static final long serialVersionUID = -8384317732137294496L;
	final JComboBox<String> effectList1 = new JComboBox<String>(AlchemyConstants.getEffectList());
	final JComboBox<String> effectList2 = new JComboBox<String>(AlchemyConstants.getEffectList());
	final JComboBox<String> effectList3 = new JComboBox<String>(AlchemyConstants.getEffectList());
	final JComboBox<String> effectList4 = new JComboBox<String>(AlchemyConstants.getEffectList());
	final AlchListModel listmodel= new AlchListModel();
	final JList<Ingredient> itemList = new JList<Ingredient>(listmodel);
	final JSlider level = new JSlider(JSlider.VERTICAL, 1, 4, 4);
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
	/* (non-Javadoc)
	 * Fired when one of the wanted effects is changed
	 * @see java.awt.event.ItemListener#itemStateChanged(java.awt.event.ItemEvent)
	 */
	@Override
	public void itemStateChanged(final ItemEvent ie) {
		if (ie.getStateChange() == ItemEvent.SELECTED) {
			listmodel.filterList(level.getValue(),effectList1.getSelectedIndex(),effectList2.getSelectedIndex(),effectList3.getSelectedIndex(),effectList4.getSelectedIndex());
		}
	}
	/* (non-Javadoc)
	 * Fired when the skill level is changed
	 * @see javax.swing.event.ChangeListener#stateChanged(javax.swing.event.ChangeEvent)
	 */
	@Override
	public void stateChanged(final ChangeEvent ce) {
		listmodel.filterList(level.getValue(),effectList1.getSelectedIndex(),effectList2.getSelectedIndex(),effectList3.getSelectedIndex(),effectList4.getSelectedIndex());
	}

}
