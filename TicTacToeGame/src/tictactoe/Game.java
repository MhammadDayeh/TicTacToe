// TODO: add restart option after finishing game (JOptionPane)

package tictactoe;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

class Game implements ActionListener {
	private static JFrame gameFrame;	
	private static JPanel gamePanel, statusPanel;
	private static ArrayList<Button> slots;
	private static ImageIcon X_Icon, O_Icon;
	private static JLabel winnerLabel;
	private static boolean gameEnded = false;

	Game() {
		X_Icon = new ImageIcon("./Images/X_Image.png");
		O_Icon = new ImageIcon("./Images/O_Image.png");

		slots = new ArrayList<Button>(9);

		gameFrame = new JFrame("TICTACTOE");
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setSize(460, 540);
		gameFrame.getContentPane().setBackground(Color.LIGHT_GRAY);
		gameFrame.setLayout(new FlowLayout());
		gameFrame.setResizable(false);

		gamePanel = new JPanel();
		gamePanel.setPreferredSize(new Dimension(450, 440));
		gamePanel.setBackground(Color.BLACK);
		gamePanel.setLayout(new GridLayout(3, 3));	
		
		statusPanel = new JPanel();
		statusPanel.setPreferredSize(new Dimension(450, 50));
		statusPanel.setBackground(Color.WHITE);
		statusPanel.setLayout(new FlowLayout());
		
		winnerLabel = new JLabel("Winner: ");
		winnerLabel.setFont(new Font("SF Mono", Font.PLAIN, 14));
		statusPanel.add(winnerLabel);

		for (int i = 1; i < 10; i++) {
			slots.add(new Button(Integer.toString(i)));
		}

		for (Button button : slots) {
			gamePanel.add(button);
			button.setPreferredSize(new Dimension(100, 100));
			button.addActionListener(this);
		}

		gameFrame.add(gamePanel);
		gameFrame.add(statusPanel);

		gameFrame.setVisible(true);
	}

	public static void disableAll() {
		for (int i = 0; i < slots.size(); i++) {
			slots.get(i).setEnabled(false);
		}
	}
	
	public static void declareWinnerX() {
		winnerLabel.setText("Winner: X");
		winnerLabel.setForeground(Color.GREEN);
		disableAll();
		xWon = true;
		gameEnded = true;
	}

	public static void checkX() {
		if (slots.get(0).getIsX() && slots.get(1).getIsX() && slots.get(2).getIsX()) {
			declareWinnerX();
			highlightWinnerLine(slots.get(0), slots.get(1), slots.get(2));
			return;
		} else if (slots.get(3).getIsX() && slots.get(4).getIsX() && slots.get(5).getIsX()) {
			declareWinnerX();
			highlightWinnerLine(slots.get(3), slots.get(4), slots.get(5));
			return;
		} else if (slots.get(6).getIsX() && slots.get(7).getIsX() && slots.get(8).getIsX()) {
			declareWinnerX();
			highlightWinnerLine(slots.get(6), slots.get(7), slots.get(8));
			return;
		} else if (slots.get(0).getIsX() && slots.get(3).getIsX() && slots.get(6).getIsX()) {
			declareWinnerX();
			highlightWinnerLine(slots.get(0), slots.get(3), slots.get(6));
			return;
		} else if (slots.get(1).getIsX() && slots.get(4).getIsX() && slots.get(7).getIsX()) {
			declareWinnerX();
			highlightWinnerLine(slots.get(1), slots.get(4), slots.get(7));
			return;
		} else if (slots.get(2).getIsX() && slots.get(5).getIsX() && slots.get(8).getIsX()) {
			declareWinnerX();
			highlightWinnerLine(slots.get(2), slots.get(5), slots.get(8));
			return;
		} else if (slots.get(0).getIsX() && slots.get(4).getIsX() && slots.get(8).getIsX()) {
			declareWinnerX();
			highlightWinnerLine(slots.get(0), slots.get(4), slots.get(8));
			return;
		} else if (slots.get(2).getIsX() && slots.get(4).getIsX() && slots.get(6).getIsX()) {
			declareWinnerX();
			highlightWinnerLine(slots.get(2), slots.get(4), slots.get(6));
			return;
		} else {
			return;
		}
	}

	public static void declareWinnerO() {
		winnerLabel.setText("Winner: O");
		winnerLabel.setForeground(Color.GREEN);
		disableAll();
		oWon = true;
		gameEnded = true;
	}

	public static void checkO() {
		if (slots.get(0).getIsO() && slots.get(1).getIsO() && slots.get(2).getIsO()) {
			declareWinnerO();
			highlightWinnerLine(slots.get(0), slots.get(1), slots.get(2));
			return;
		} else if (slots.get(3).getIsO() && slots.get(4).getIsO() && slots.get(5).getIsO()) {
			declareWinnerO();
			highlightWinnerLine(slots.get(3), slots.get(4), slots.get(5));
			return;
		} else if (slots.get(6).getIsO() && slots.get(7).getIsO() && slots.get(8).getIsO()) {
			declareWinnerO();
			highlightWinnerLine(slots.get(6), slots.get(7), slots.get(8));
			return;
		} else if (slots.get(0).getIsO() && slots.get(3).getIsO() && slots.get(6).getIsO()) {
			declareWinnerO();
			highlightWinnerLine(slots.get(0), slots.get(3), slots.get(6));
			return;
		} else if (slots.get(1).getIsO() && slots.get(4).getIsO() && slots.get(7).getIsO()) {
			declareWinnerO();
			highlightWinnerLine(slots.get(1), slots.get(4), slots.get(7));
			return;
		} else if (slots.get(2).getIsO() && slots.get(5).getIsO() && slots.get(8).getIsO()) {
			declareWinnerO();
			highlightWinnerLine(slots.get(2), slots.get(5), slots.get(8));
			return;
		} else if (slots.get(0).getIsO() && slots.get(4).getIsO() && slots.get(8).getIsO()) {
			declareWinnerO();
			highlightWinnerLine(slots.get(0), slots.get(4), slots.get(8));
			return;
		} else if (slots.get(2).getIsO() && slots.get(4).getIsO() && slots.get(6).getIsO()) {
			declareWinnerO();
			highlightWinnerLine(slots.get(2), slots.get(4), slots.get(6));
			return;
		} else {
			return;
		}
	}
	
	public static void highlightWinnerLine(Button b1, Button b2, Button b3) {
    	b1.setBorder(new LineBorder(Color.GREEN, 3, true));
		b2.setBorder(new LineBorder(Color.GREEN, 3, true));	
    	b3.setBorder(new LineBorder(Color.GREEN, 3, true));
	}

	public static void OTurn() {
		checkX();
		checkO();

		while (!gameEnded) {	
			int randomNumber = (int)(Math.random() * ((8 - 0) + 1)) + 0;
			if (!(slots.get(randomNumber).isTaken())) {
				slots.get(randomNumber).setIcon(O_Icon);
				slots.get(randomNumber).setDisabledIcon(O_Icon);
				slots.get(randomNumber).setEnabled(false);
				slots.get(randomNumber).setIsO(true);
				break;
			} else {
				continue;
			}
		}

		checkX();
		checkO();
	}

	public static void draw() {
		winnerLabel.setText("Winner: DRAW");
		winnerLabel.setForeground(Color.GREEN);
		disableAll();	
		gameEnded = true;
	}
	
	private static boolean xWon = false, oWon = false;

	public static void determineWinner() {
		checkO();
		checkX();
		if (xWon) {
			declareWinnerX();
		} else if (oWon) {
			declareWinnerO();
		} else {
			draw();
		}
	}

	Button b;
	@Override
	public void actionPerformed(ActionEvent e) {
		int t = 0;
		for (int i = 1; i < 10; i++) {
			b = (Button) e.getSource();
			if (b.getMark().equals(Integer.toString(i))) {
				b.setIcon(X_Icon);
				b.setDisabledIcon(X_Icon);
				b.setEnabled(false);
				b.setIsX(true);
				break;
			}
		}
		
		for (Button button : slots) {
			if (button.isTaken()) t++;
		}

		if (t != 9) OTurn(); else determineWinner(); 
	}
}
