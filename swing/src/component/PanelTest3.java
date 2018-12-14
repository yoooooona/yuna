package component;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class PanelTest3 extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelTest3() {
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\uAC15\uC544\uC9C0"}));
		add(comboBox);

	}

}
