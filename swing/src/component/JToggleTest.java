package component;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToggleButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JToggleTest extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JToggleTest frame = new JToggleTest();
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
	public JToggleTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("New label");
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("Toggle \uBC84\uD2BC ");
		tglbtnNewToggleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//toggle 버튼 클릭시 label에 button on과 button off
				//라는 글자가 번갈아 나오도록 하기
				JToggleButton tgl=(JToggleButton) e.getSource();
				if(tgl.isSelected()) {
					lblNewLabel.setText("Button on");
				}else {
					lblNewLabel.setText("Button off");				
				}
				
				
			}
		});
		contentPane.add(tglbtnNewToggleButton, BorderLayout.NORTH);
		
		
		contentPane.add(lblNewLabel, BorderLayout.CENTER);
	}

}
