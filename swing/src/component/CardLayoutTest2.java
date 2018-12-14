package component;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.Color;

public class CardLayoutTest2 extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JButton mainbtn1, mainbtn2, mainbtn3;
	
	//카드형태로 사용할 패널 배열 선언
	private JPanel panel[];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CardLayoutTest2 frame = new CardLayoutTest2();
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
	public CardLayoutTest2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel top = new JPanel();
		contentPane.add(top, BorderLayout.NORTH);
		
		mainbtn1 = new JButton("\uCCAB\uBC88\uC9F8");
		top.add(mainbtn1);
		
		mainbtn2 = new JButton("\uB450\uBC88\uC9F8");
		top.add(mainbtn2);
		
		mainbtn3 = new JButton("\uC138\uBC88\uC9F8");
		top.add(mainbtn3);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new CardLayout(0, 0));
		
		getCard(3); //패널 3개 생성
		//CardLayout 위에 만들어진 패널 붙이기
		int i=1;
		for(JPanel p:panel) {
			panel_1.add(String.valueOf(i),p);
			i++;
		}
		
		//"1"을 가진 패널 꾸미기
		JButton btn1=new JButton("첫번째");
		JRadioButton radio=new JRadioButton("손오공");
		panel[0].setBackground(Color.DARK_GRAY);
		panel[0].add(btn1);
		panel[0].add(radio);
		
		//"2"를 가진 패널 꾸미기
		JButton btn2=new JButton("두번째");
		JRadioButton radio2=new JRadioButton("저팔계");
		panel[1].setBackground(Color.PINK);
		panel[1].add(btn2);
		panel[1].add(radio2);
		
		//"3"을 가진 패널 꾸미기
		JButton btn3=new JButton("세번째");
		JRadioButton radio3=new JRadioButton("사오정");
		panel[2].setBackground(Color.CYAN);
		panel[2].add(btn3);
		panel[2].add(radio3);
		
		mainbtn1.addActionListener(this);
		mainbtn2.addActionListener(this);
		mainbtn3.addActionListener(this);
		
	}
	private JPanel[] getCard(int cnt) {
		panel=new JPanel[cnt];
		
		for(int i=0;i<panel.length;i++) {
			if(panel[i]==null) {
				panel[i]=new JPanel();
			}
		}
		return panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn=(JButton)e.getSource();
		
		JPanel p=(JPanel) getContentPane().getComponent(1);
		CardLayout card=(CardLayout) p.getLayout();
		
		if(btn==mainbtn1) {
			card.show(p,"1");
		}else if(btn==mainbtn2) {
			card.show(p,"2");
		}else {
			card.show(p,"3");
		}
		
	}
}
