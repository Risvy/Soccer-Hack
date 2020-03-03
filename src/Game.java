import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import javax.sound.sampled.*;
//import Audio.AudioPlayer;
public class Game extends Thread implements KeyListener {

	private Display display;
	public int width, height;
	public String title;
	
	Game game;

	int maxWidth = 100;
	int maxHeight = 100;
	int newwidth = 100;
	int newHeight = 100;
	
	int xx = 0;
	boolean isCurve = false;
	
	private boolean running = true;;
	private Thread thread;

	private BufferStrategy bs;
	private Graphics g;
	//private AudioPlayer bgmusic;
	

	//private Menu menu;
	private BufferedImage testImage, testImage2, testImage3;

	static int goalCount = 0;
	int dx = 1;

	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;

		isCurve = false;
	}

	public void setGame(Game g) {
		game = g;
	}
	
	//private enum STATE{
		//MENU,
		//GAME
	//};
	
	//private STATE state = STATE.MENU;
	 
	private void init() {
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(this);
		// display.getFrame().addKeyListener(keyManager);

		testImage = ImageLoader.loadImage("/textures/background2.png");
		testImage2 = ImageLoader.loadImage("/textures/ball2.png");
		testImage3 = ImageLoader.loadImage("/textures/man3.png");
		//menu = new Menu();
		
		
		/*
		 * bgmusic = new AudioPlayer ("/Music/level1-1.mp3"); bgmusic.play();
		 */
		 
		
	}

	int ballY = 500, man = 100;
	int ballX = 465;

	boolean isForward = true;
	int leftMost = 180;
	int rightMost = 800;

	int count = 5;
	private void tick() {
		//if (state == STATE.GAME) {

		if (isShoot && ballY >= 280) {
			ballY -= 1;
			
			ballX += xx;
			
			if(count == 0) {
				count = 5;
				newwidth--;
				newHeight--;
			}
			count--;
			
		}
		
		else if (!isSaved && ballY <= 280) {
			System.out.println(ballX);
			if (ballX >= 195 && ballX <= 840) {

				goalCount++;
				System.out.println("Goal: " + goalCount);
				ballX=465;
				ballY= 500;
				newwidth = maxWidth;
				newHeight = maxHeight;
				isCurve = false;
				xx = 0;
				if (goalCount % 2 == 0) {
					dx++;
				}

			}
			ballX = 465;
			ballY = 500; 
			isShoot = false;
			newwidth = maxWidth;
			newHeight = maxHeight;
			isCurve = false;
			xx = 0;
		}

		if (isForward) {
			man += dx;
		} else {
			man -= dx;
		}
		if (man >= rightMost && isForward) {
			isForward = false;
		}

		if (man <= leftMost && !isForward) {
			isForward = true;
		}

		if (ballX + newwidth - 25 >= man && ballX <= man + manWidth - 35 && ballY < 200 + 240 - 30) {
			System.out.println(ballX + " " + ballY + " " + man + " ");
			System.out.println("Saved");
			isSaved = true;
			running = false;
			GameOver gameOver = new GameOver();
			gameOver.setVisible(true);
			this.display.getFrame().dispose();
		}

	}
	//}

	int manWidth = 120;
	boolean isSaved = false;

	//if (state == STATE.GAME) {
	private void render() {
		
		bs = display.getCanvas().getBufferStrategy();
		if (bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		// Clear Screen
		g.clearRect(0, 0, width, height);

		g.drawImage(testImage, 20, 20, null);
		g.drawImage(testImage2, ballX, ballY, newwidth, newHeight, null);
		g.drawImage(testImage3, man, 200, manWidth, 240, null);

		// g.drawImage(testImage3, 20, 20, null);
		// g.drawImage(testImage2, 465, 550->300, 150,150,null);
		// change of y
		// g.drawImage(img, x, y, width, height, observer)

		
		//bgmusic = new AudioPlayer ("/Music/level1-1.mp3"); 
		//bgmusic.play();
		bs.show();
		g.dispose();
	}
		
		//else if (state == STATE.MENU) {
			//menu.render(g);
		//}
//}

	@Override
	public void run() {
		System.out.println("Calling");
		//bgmusic = new AudioPlayer ("/Music/level1-1.mp3");
		//bgmusic.play();
		init();

		while (running) {
			tick();
			render();
		}

//		stop();

	}

	boolean isShoot = false;

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {

//		System.out.println("Pressed");
		
		//if (state == STATE.GAME) {
		if (!isShoot && e.getKeyCode() == KeyEvent.VK_SPACE) {
			
		
			isShoot = true;
//			newwidth = maxWidth;
//			newHeight = maxHeight;
		}

		if (!isShoot && e.getKeyCode() == KeyEvent.VK_LEFT) {
			if (ballX >= leftMost + 15) {
				ballX -= 15;
			}

		}

		if (!isShoot && e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if (ballX <= 900) {
				ballX += 15;
			}
		}
		
		if(!isCurve && isShoot && e.getKeyCode() == KeyEvent.VK_A) {
			xx = -1;
			isCurve = true;
		}
		
		if(!isCurve && isShoot && e.getKeyCode() == KeyEvent.VK_D) {
			xx = 1;
			isCurve = true;
		}

		if (!running && e.getKeyCode() == KeyEvent.VK_B) {
//			ballX = 465;
//			ballY = 500;
//			man = 100;
//			goalCount = 0;
//			isForward = true;
//			isSaved = false;
//			dx = 1;
//			running = true;
//
//			System.out.println("Space");
			

		}
	}
	//}
	@Override
	public void keyReleased(KeyEvent e) {
		if(!isCurve && isShoot && e.getKeyCode() == KeyEvent.VK_A) {
			xx = 0;
		}
		
		if(!isCurve && isShoot && e.getKeyCode() == KeyEvent.VK_D) {
			xx = 0;
		}
	}

//	public synchronized void start() {
//		if (running)
//			return;
//		running = true;
//		thread = new Thread(this);
//		thread.start();
//	}
//
//	public synchronized void stop() {
//		if (!running)
//			return;
//		running = false;
//		try {
//			thread.join();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}

}