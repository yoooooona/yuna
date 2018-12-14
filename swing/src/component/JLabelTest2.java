package component;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;

public class JLabelTest2 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JLabelTest2 frame = new JLabelTest2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JLabelTest2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("");

		JToggleButton btnNewButton = new JToggleButton("\uC774\uBBF8\uC9C0 \uBCF4\uC774\uAE30");
		btnNewButton.addActionListener(new ActionListener() { //익명구현
			@Override
			public void actionPerformed(ActionEvent e) {
				AbstractButton tgl=(AbstractButton) e.getSource();
				if(tgl.isSelected()) {
				lblNewLabel.setIcon(new ImageIcon(JLabelTest2.class.getResource("/component/Dog.gif")));
				}else {
					lblNewLabel.setIcon(null);
				}

			}
		});
		contentPane.add(btnNewButton, BorderLayout.SOUTH);

		
		
		contentPane.add(lblNewLabel, BorderLayout.CENTER);
	}

}
