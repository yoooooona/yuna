package component;

import javax.swing.JPanel;
import javax.swing.JTree;
//단독으로 사용하지는 못한다
public class PanelTest1 extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelTest1() {
		
		JTree tree = new JTree();
		add(tree);

	}

}
