import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FirstPage extends JFrame{

	//private AudioPlayer audio;
	
	//JPanel jp = new JPanel();
	//JLabel jl = new JLabel();
	
	

	public FirstPage() {
	
		this.setSize(1380, 700);
		this.setTitle("SPORTS HACK");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		//jl.setIcon(new ImageIcon("/textures/firstpage.jpg"));
	    
		/*
		 * jp.add(jl); add(jp);
		 * 
		 * validate();
		 */
	    
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
		JLabel gameOverLabel = new JLabel("WELCOME TO SPORTS HACK");
		gameOverLabel.setFont(new Font("Helvetica", Font.BOLD, 40));
		this.add(gameOverLabel, gbc);
		
		
//		gbc.gridx = 1;
//		gbc.gridy = 0;
//		this.add(new Button("Button two"), gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		
		gbc.ipady = 20;
		gbc.gridx = 0;
		gbc.gridy = 1;
		JLabel scoreLabel = new JLabel();
		this.add(scoreLabel, gbc);
//		gbc.gridx = 1;
//		gbc.gridy = 1;
//		this.add(new Button("Button Four"), gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.ipady = 10;
		gbc.gridwidth = 2;
		JButton playButton = new JButton("PLAY NOW");
		playButton.setForeground(Color.white);
		playButton.setBackground(Color.black);
		
//		playButton.setSize(100, 100);
		playButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//audio = new Audioplayer ("/Music/level1-1.mp3");
				//audio.play();
				Game game = new Game("SPORTS HACK", 1100, 800);
				game.setGame(game);
			    Game.goalCount = 0;
				game.start();
				dispose();
			}
		});
		this.add(playButton, gbc);
		
		this.getContentPane().setBackground(Color.green);
		this.setVisible(true);
		
	}
	public static void main(String[] args) {
		new FirstPage();
	}

}
