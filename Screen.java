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
			if (a != game.player)
				drawActor(a);

		//draw player
		g.setColor(Color.RED);
		drawActor(game.player);
	}

	public void drawThing(Thing t) {
		int x = (int)t.x + width / 2;
		int y = (int)t.y + height / 2;
		g.fillOval(x, y, 2*(int)t.radius, 2*(int)t.radius);
	}

	public void drawActor(Actor a) {
		int x = (int)a.x + width / 2;
		int y = (int)a.y + height / 2;
		g.fillOval(x, y, 2*(int)a.radius, 2*(int)a.radius);
	}
}
