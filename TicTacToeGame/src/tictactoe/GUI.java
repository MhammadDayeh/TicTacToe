package tictactoe;

import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;

class GUI implements ActionListener {
	private Font font;
	private JFrame mainFrame;
	private JButton playButton, exitButton;
	private JPanel logo;
	private JLabel logoLabel;
	private ImageIcon logoPic;

	GUI() {
		font = new Font("Lucida Grande", Font.PLAIN, 16);

		logoPic = new ImageIcon("./Images/Logo.png");

		mainFrame = new JFrame("TicTacToe Game");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setLayout(new FlowLayout());
		mainFrame.getContentPane().setBackground(Color.BLACK);
		mainFrame.setSize(490, 480);
		mainFrame.setResizable(false);

		logo = new JPanel();
		logo.setPreferredSize(new Dimension(490, 330));
		logo.setLayout(new FlowLayout());
		logo.setBackground(Color.BLACK);

		logoLabel = new JLabel(logoPic, 0);
		logo.add(logoLabel);	

		playButton = new JButton("PLAY");
		playButton.setForeground(Color.GREEN);
		playButton.setPreferredSize(new Dimension(450, 50));
		playButton.addActionListener(this);
		playButton.setFont(font);

		exitButton = new JButton("EXIT");
		exitButton.setForeground(Color.RED);
		exitButton.setPreferredSize(new Dimension(450, 50));
		exitButton.addActionListener(this);
		exitButton.setFont(font);
		
		mainFrame.add(logo);
		mainFrame.add(playButton);
		mainFrame.add(exitButton);

		mainFrame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "PLAY") {
			SwingUtilities.invokeLater(new Runnable(){
				public void run() {
					new Game();
				}
			});
		} else if (e.getActionCommand() == "EXIT") {
			System.exit(0);
		}
	}
}
