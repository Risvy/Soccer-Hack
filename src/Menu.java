import java.awt.Font;
import java.awt.Graphics;
import java.awt.*;

public class Menu {

	public void render (Graphics g) {
		Font fnt = new Font ("arial",Font.BOLD,50);
		g.setFont(fnt);
		g.setColor(Color.BLACK);
		g.drawString("Soccer game", 100, 100);
	}
}
