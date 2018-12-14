package component;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;
import javax.swing.JEditorPane;
import javax.swing.border.TitledBorder;

import de.javasoft.plaf.synthetica.SyntheticaBlackEyeLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaStandardLookAndFeel;

import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class PizzaTest extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JButton order, cancel;
	private JLabel lbl;
	private JRadioButton rdbtncombo,rdbtnpotato,rdbtnbul;
	private JRadioButton rdbtnpimang, rdbtnche, rdbtnpe, rdbtnba;
	private JRadioButton rdbtnsmall, rdbtnmedium, rdbtnlarge;
	
	//피자 가격정하기
	int combo=18000;
	int potato=15900;
	int bul=19000;
	
	//토핑 가격정하기
	int pimang=300;
	int che=2000;
	int pe=1000;
	int ba=3000;
	
	//크기 가겨정하기
	int small=0;
	int medium=1500;
	int large=3000;
	
	//가격 묶어주기
	int kind=0; // 피자 종류
	int toping=0; // 추가 토핑
	int sizes=0; // 피자 크기
	
	String[] str = new String[4];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
					//UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					//Jtattoo
					//UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
					UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
					//UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
					//UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
					//UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
					//UIManager.setLookAndFeel("de.javasoft.plaf.synthetica.SyntheticaBlackEyeLookAndFeel");
					//UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
					//UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
					//UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
					//UIManager.setLookAndFeel("com.jtattoo.plaf.luna.LunaLookAndFeel");
					//UIManager.setLookAndFeel(new SyntheticaStandardLookAndFeel());
					//UIManager.setLookAndFeel(new SyntheticaBlackEyeLookAndFeel());
					PizzaTest frame = new PizzaTest();
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
	public PizzaTest() {
		setTitle("\uD53C\uC790\uC8FC\uBB38");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("\uC790\uBC14 \uD53C\uC790\uC5D0 \uC624\uC2E0 \uAC83\uC744 \uD658\uC601\uD569\uB2C8\uB2E4");
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		order = new JButton("\uC8FC\uBB38");
		panel_1.add(order);
		order.addActionListener(this);
		
		cancel = new JButton("\uCDE8\uC18C");
		panel_1.add(cancel);
		
		
		lbl = new JLabel("");
		panel_1.add(lbl);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 255)), "\uC885\uB958", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(panel_2, BorderLayout.WEST);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		rdbtncombo = new JRadioButton("\uCF64\uBCF4");
		panel_2.add(rdbtncombo);
		
		rdbtnpotato = new JRadioButton("\uD3EC\uD14C\uC774\uD1A0");
		panel_2.add(rdbtnpotato);
		
		rdbtnbul = new JRadioButton("\uBD88\uACE0\uAE30");
		panel_2.add(rdbtnbul);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 255)), "\uCD94\uAC00\uD1A0\uD551", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new GridLayout(0, 1, 0, 0));
		
		rdbtnpimang = new JRadioButton("\uD53C\uB9DD");
		panel_4.add(rdbtnpimang);
		
		rdbtnche = new JRadioButton("\uCE58\uC988");
		panel_4.add(rdbtnche);
		
		rdbtnpe = new JRadioButton("\uD398\uD398\uB85C\uB2C8");
		panel_4.add(rdbtnpe);
		
		rdbtnba = new JRadioButton("\uBCA0\uC774\uCEE8");
		panel_4.add(rdbtnba);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 255)), "\uD06C\uAE30", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel_3, BorderLayout.EAST);
		panel_3.setLayout(new GridLayout(0, 1, 0, 0));
		
		rdbtnsmall = new JRadioButton("Small");
		panel_3.add(rdbtnsmall);
		
		rdbtnmedium = new JRadioButton("Medium");
		panel_3.add(rdbtnmedium);
		
		rdbtnlarge = new JRadioButton("Large");
		panel_3.add(rdbtnlarge);
		
		//버튼 group 세우기
		ButtonGroup grp1=new ButtonGroup();
		grp1.add(rdbtncombo);
		grp1.add(rdbtnpotato);
		grp1.add(rdbtnbul);
		
		ButtonGroup grp2=new ButtonGroup();
		grp2.add(rdbtnpimang);
		grp2.add(rdbtnche);
		grp2.add(rdbtnpe);
		grp2.add(rdbtnba);
		
		ButtonGroup grp3=new ButtonGroup();
		grp3.add(rdbtnsmall);
		grp3.add(rdbtnmedium);
		grp3.add(rdbtnlarge);
		
		//cancel버튼을 눌렀을 때 선택했던 JRadioBox지우기
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				grp1.clearSelection();
				grp2.clearSelection();
				grp3.clearSelection();
				lbl.setText("");
				
			}
		});
		
		
		rdbtncombo.addActionListener(this);
		rdbtnpotato.addActionListener(this);
		rdbtnbul.addActionListener(this);
		rdbtnpimang.addActionListener(this);
		rdbtnche.addActionListener(this);
		rdbtnpe.addActionListener(this);
		rdbtnba.addActionListener(this);
		rdbtnsmall.addActionListener(this);
		rdbtnmedium.addActionListener(this);
		rdbtnlarge.addActionListener(this);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		AbstractButton btnA = (AbstractButton)e.getSource();
		//체크박스에 체크를 다 한 후 주문을 눌렀을 때 라벨에 금액나오기
		if(btnA==order) {
			JButton btn= (JButton) btnA;
			//주문 내용확인하기
			JOptionPane.showMessageDialog(this,"피자종류 : "+str[0]+"\n"+"피자 토핑 : "+str[1]+"\n"+"피자크기 :" +str[2]+"\n" 
				+"주문 금액 : "+str[3]	,"주문서" , JOptionPane.OK_OPTION);
		}
		//취소버튼을 누르게 되면 라벨에 금액 지우기  
		else {
			if(btnA==rdbtncombo || btnA==rdbtnpotato|| btnA==rdbtnbul) {
				if(btnA==rdbtncombo)
					kind = combo;
				else if(btnA==rdbtnpotato)
					kind = potato;
				else if(btnA==rdbtnbul)
					kind = bul;
				
				str[0] = btnA.getText();
			}else if(btnA==rdbtnpimang || btnA==rdbtnche || btnA==rdbtnpe || btnA==rdbtnba){
				if(btnA==rdbtnpimang)
					toping = pimang;
				else if(btnA==rdbtnche)
					toping = che;
				else if(btnA==rdbtnpe)
					toping = pe;
				else if(btnA==rdbtnba)
					toping = ba;
				
				str[1] = btnA.getText();
			}else if(btnA==rdbtnsmall || btnA==rdbtnmedium || btnA==rdbtnlarge) {
				if(btnA==rdbtnsmall) 
					sizes=small;
			else if(btnA==rdbtnmedium)
				sizes=medium;
			else if(btnA==rdbtnlarge) 
				sizes=large;
				
				str[2] = btnA.getText();
			}
			lbl.setText((kind+toping+sizes)+"");
			str[3] =lbl.getText();
		}
		
		
		
		
	}

}
