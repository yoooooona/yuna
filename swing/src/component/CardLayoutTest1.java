package component;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import java.awt.Color;

public class CardLayoutTest1 extends JFrame {

	private JPanel contentPane;
	private JPanel redCard, blueCard, orangeCard;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CardLayoutTest1 frame = new CardLayoutTest1();
					frame.setVisible(true);
					// Card 들이 2초 간격으로 변경되도록 만들기
					Thread t = new Thread() {
						@Override
						public void run() {
							for (int i = 0; i < 411; i++) {
								try {
									Thread.sleep(50);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								SwingUtilities.invokeLater(new Runnable() {
									@Override
									public void run() {
										CardLayout cardlayout=(CardLayout)frame.getContentPane().getLayout();
										cardlayout.next(frame.getContentPane());
										
									}
								});
							}
						}

					};
					t.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CardLayoutTest1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));

		contentPane.add("RedCard", getCard());
		contentPane.add("BlueCard", getCard());
		contentPane.add("OrangeCard", getCard());

	}

	private JPanel getCard() {
		// 패널 생성 후 리턴
		if (redCard == null) {
			redCard = new JPanel();
			redCard.setBackground(Color.PINK);
			return redCard;
		} else if (blueCard == null) {
			blueCard = new JPanel();
			blueCard.setBackground(Color.GREEN);
			return blueCard;
		} else if (orangeCard == null) {
			orangeCard = new JPanel();
			orangeCard.setBackground(Color.CYAN);
			return orangeCard;
		}
		return blueCard;

	}

}
