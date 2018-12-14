package component;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class RadioTeset1 extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RadioTeset1 frame = new RadioTeset1();
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
	public RadioTeset1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\uC560\uC644\uB3D9\uBB3C \uC120\uD0DD");
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JRadioButton rdocat = new JRadioButton("\uACE0\uC591\uC774");
		panel.add(rdocat);
		
		JRadioButton rdodog = new JRadioButton("\uAC15\uC544\uC9C0");
		panel.add(rdodog);
		
		JRadioButton rdoham = new JRadioButton("\uD584\uC2A4\uD130");
		panel.add(rdoham);
		
		JRadioButton rdorab = new JRadioButton("\uD1A0\uB07C");
		panel.add(rdorab);
		
		JRadioButton rdogo = new JRadioButton("\uACE0\uC2B4\uB3C4\uCE58");
		panel.add(rdogo);
		
		//¹öÆ° group
		ButtonGroup grp=new ButtonGroup();
		grp.add(rdorab);
		grp.add(rdogo);
		grp.add(rdoham);
		grp.add(rdodog);
		grp.add(rdocat);
		
		textField =  new JTextField();
		contentPane.add(textField, BorderLayout.SOUTH);
		textField.setColumns(10);
		
		rdocat.addActionListener(this);
		rdodog.addActionListener(this);
		rdogo.addActionListener(this);
		rdoham.addActionListener(this);
		rdorab.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		textField.setText(e.getActionCommand());
		
	}

}
