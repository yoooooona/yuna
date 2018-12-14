package layout;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JTabbedPaneTest extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_7;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JTabbedPaneTest frame = new JTabbedPaneTest();
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
	public JTabbedPaneTest() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\dw\\Desktop\\overwatch.png"));
		setTitle("\uC624\uBC84\uC6CC\uCE58");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(255, 204, 255));
		panel.setBackground(new Color(255, 102, 153));
		tabbedPane.addTab("\uD68C\uC6D0\uB4F1\uB85D", null, panel, null);
		panel.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton = new JButton("\uB4F1\uB85D");
		btnNewButton.setBackground(Color.PINK);
		panel.add(btnNewButton, BorderLayout.SOUTH);
		
		JPanel panel_4 = new JPanel();
		panel_4.setForeground(new Color(255, 105, 180));
		panel_4.setBackground(new Color(255, 240, 245));
		panel.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("\uBA54\uB974\uC2DC");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_1);
		
		textField = new JTextField();
		panel_4.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\uC601\uC6C5\uC774\uC5EC");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		panel_4.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\uC77C\uC5B4\uB098\uC138\uC694");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel);
		
		textField_1 = new JTextField();
		panel_4.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 218, 185));
		tabbedPane.addTab("\uD68C\uC6D0\uC870\uD68C", null, panel_1, null);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 204, 255));
		panel_1.add(panel_5);
		
		JLabel lblNewLabel_3 = new JLabel("\uC544\uB098");
		panel_5.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		panel_5.add(textField_3);
		textField_3.setColumns(10);
		
		JButton button = new JButton("\uBF55");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_5.add(button);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("\uD68C\uC6D0\uC218\uC815", null, panel_2, null);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.PINK);
		panel_2.add(panel_6);
		panel_6.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel_5 = new JLabel("\uBA54\uC774");
		panel_6.add(lblNewLabel_5);
		
		textField_4 = new JTextField();
		panel_6.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\uB9AC\uD37C");
		panel_6.add(lblNewLabel_4);
		
		textField_5 = new JTextField();
		panel_6.add(textField_5);
		textField_5.setColumns(10);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(250, 250, 210));
		panel_2.add(panel_7);
		
		JButton btnNewButton_2 = new JButton("New button");
		panel_7.add(btnNewButton_2);
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 228, 225));
		tabbedPane.addTab("\uD68C\uC6D0\uC0AD\uC81C", null, panel_3, null);
		
		JLabel lblNewLabel_9 = new JLabel("\uD55C\uC870");
		panel_3.add(lblNewLabel_9);
		
		textField_7 = new JTextField();
		panel_3.add(textField_7);
		textField_7.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("\uB300\uAE30\uC911");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_3.add(btnNewButton_1);
	}

}
