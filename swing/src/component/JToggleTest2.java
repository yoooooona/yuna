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

import javax.swing.AbstractButton;
import javax.swing.JButton;

public class JToggleTest2 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lbl;
	private JToggleButton tglbtn;
	private JButton btn;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JToggleTest2 frame = new JToggleTest2();
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
	public JToggleTest2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		lbl = new JLabel("New label");

		tglbtn = new JToggleButton("Toggle \uBC84\uD2BC ");
		contentPane.add(tglbtn, BorderLayout.NORTH);

		contentPane.add(lbl, BorderLayout.CENTER);

		btn = new JButton("\uC77C\uBC18 \uBC84\uD2BC ");
		contentPane.add(btn, BorderLayout.SOUTH);

		tglbtn.addActionListener(this);
		btn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// toggle 버튼 클릭이 될 때마다
		//toggle Button on, Toggle Button off
		//JToggleButton tglbtn=(JToggleButton) e.getSource();
	/*	if(e.getSource()==btn) { //JButton
			
		}else { //JToggleButton
			JToggleButton tglbtn=(JToggleButton) e.getSource();
			if(tglbtn.isSelected()) {
				tglbtn.setText("Button on");
			}else {
				tglbtn.setText("Button off");
			}
		}*/
		
		//두번째 방법 : 부모로 받기
		AbstractButton btn1=(AbstractButton) e.getSource();  //castException을 막을 수 있음
		if(btn1==btn) {
			lbl.setText("Basic Button click");
		}else {
			if(btn1.isSelected()) {
				lbl.setText("ToggleButton on");
			}else {
				lbl.setText("ToggleButton off");
			}
		}
		
	}

}
