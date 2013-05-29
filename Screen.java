import java.awt.image.BufferedImage;
import java.awt.Graphics;

public class Screen extends Bitmap {

	BufferedImage img;
	Graphics g;

	public Screen(int width, int height) {
		super(width, height);
		
		img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		g = img.getGraphics();
	}

	public void render(Game game) {
		g.setColor(Color.WHITE);
		g.fillRect(0,0,800,600,null);
		g.setColor(Color.BLACK);
		for (Actor a : game.actors)
			g.drawImage((int)a.x, (int)a.y, a.width, a.height, null);
	}
}
