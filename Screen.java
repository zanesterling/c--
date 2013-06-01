import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Color;

public class Screen extends Bitmap {

	BufferedImage img;
	Graphics g;

	public Screen(int width, int height) {
		super(width, height);
		
		img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		g = img.getGraphics();
	}

	public void render(Game game) {
		//repaint background
		g.setColor(Color.BLACK);
		g.fillRect(0,0,800,600);

		//draw things
		g.setColor(Color.BLUE);
		for (Thing t : game.things)
			drawThing(t);

		//draw actors
		g.setColor(Color.WHITE);
		for (Actor a : game.actors)
			drawActor(a);

		//draw player
		g.setColor(Color.RED);
		drawActor(game.player);
	}

	public void drawThing(Thing t) {
		g.fillRect((int)t.x, (int)t.y, 2*(int)t.radius, 2*(int)t.radius);
	}

	public void drawActor(Actor a) {
		g.fillRect((int)a.x, (int)a.y, 2*(int)a.radius, 2*(int)a.radius);

	}
}
