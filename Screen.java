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
		for (Actor a : game.actors)
			g.drawImage(a.img, (int)a.x, (int)a.y, null);
	}
}
