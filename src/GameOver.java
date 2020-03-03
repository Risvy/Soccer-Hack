import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GameOver extends JFrame{

	
	public GameOver() {
		this.setSize(1380, 700);
		this.setTitle("SPORTS HACK");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	GridBagLayout grid = new GridBagLayout();
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		setLayout(grid);
		
		setTitle("SPORTS HACK");
		
		GridBagLayout layout = new GridBagLayout();
		
		this.setLayout(layout);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.ipady = 30;
		gbc.gridx = 0;
		gbc.gridy = 0;
		JLabel gameOverLabel = new JLabel("GAME OVER!!!");
		gameOverLabel.setFont(new Font("Helvetica", Font.BOLD, 70));
		this.add(gameOverLabel, gbc);
		
		
		
		//----------------

		//-------------------
		
		
//		gbc.gridx = 1;
//		gbc.gridy = 0;
//		this.add(new Button("Button two"), gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		
		gbc.ipady = 20;
		gbc.gridx = 0;
		gbc.gridy = 1;
		//JLabel in = new JLabel(Game.goalCount);
		JLabel scoreLabel = new JLabel("SCORE: " + Game.goalCount);
		scoreLabel.setFont(new Font("Helvetica",Font.BOLD,50));
		this.add(scoreLabel, gbc);
		
//		gbc.gridx = 1;
		
//		gbc.gridy = 1;
//		this.add(new Button("Button Four"), gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.ipady = 10;
		gbc.gridwidth = 2;
		
		JButton startAgain = new JButton("STATRT AGAIN");
		startAgain.setForeground(Color.white);
		startAgain.setBackground(Color.black);
		this.add(startAgain, gbc);
		startAgain.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Game game = new Game("SPORTS HACK", 1100, 800);
				game.setGame(game);
			    Game.goalCount = 0;
				game.start();
				dispose();
			}
		});
		
		//--------------
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.ipady = 10;
		gbc.gridwidth = 2;
		
		
		JButton startAgain2 = new JButton("EXIT");
		startAgain2.setForeground(Color.white);
		startAgain2.setBackground(Color.black);
		this.add(startAgain2, gbc);
		startAgain2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Exited");
				System.exit(0);
			}
		});
		
		
		//--------
		
		
		
		
		
		
		//this.add(startAgain, gbc);
		
		this.getContentPane().setBackground(Color.green);
//		this.setVisible(true);
		
	}
	public static void main(String[] args) {
		new GameOver();
	}

}
