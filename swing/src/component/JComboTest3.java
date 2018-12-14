package component;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.jtattoo.plaf.acryl.AcrylBorders.ComboBoxBorder;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class JComboTest3 extends JFrame implements ItemListener{

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JComboBox comboBox;
	Icon icon;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JComboTest3 frame = new JComboTest3();
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
	public JComboTest3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		DefaultComboBoxModel<String> model=new DefaultComboBoxModel<>();
		model.addElement("Bird");
		model.addElement("Cat");
		model.addElement("Dog");
		model.addElement("Pig");
		model.addElement("Rabbit");
		
		comboBox = new JComboBox();
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Bird", "Cat", "Dog", "Pig", "Rabbit"}));
		contentPane.add(comboBox, BorderLayout.NORTH);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(JComboTest3.class.getResource("/component/Pig.gif")));
		contentPane.add(lblNewLabel, BorderLayout.CENTER);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		String selAnimal=(String) comboBox.getSelectedItem();
		updateIcon(selAnimal);
		
	}
	public void updateIcon(String selAnimal) {
		icon=new ImageIcon(JComboTest3.class.getResource("/component/"+selAnimal+".gif"));
		lblNewLabel.setIcon(icon);
	}


}
