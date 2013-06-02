import java.awt.image.BufferedImage;
import java.util.ArrayList;
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
		g.fillRect(0, 0, width, height);

		//draw things
		g.setColor(Color.BLUE);
		for (Thing t : game.things)
			if (t.points != null)
				vectorDraw(t);
			else
				circleDraw(t);

		//draw actors
		g.setColor(Color.WHITE);
		for (Actor a : game.actors)
			if (a != game.player)
				if (a.points != null)
					vectorDraw(a);
				else
					circleDraw(a);

		//draw player
		g.setColor(Color.RED);
		if (game.player.points != null)
			vectorDraw(game.player);
		else
			circleDraw(game.player);
	}

	public void vectorDraw(Thing t) {}

	public void vectorDraw(Actor a) {
		for (int i=0; i<a.points.size()-1; i++) {
			//join points and things
			int x1 = a.points.get(i)[0] - a.radius + (int)(a.x - Main.game.player.x) + width / 2;
			int y1 = a.points.get(i)[1] - a.radius + (int)(a.y - Main.game.player.y) + height / 2;
			int x2 = a.points.get(i+1)[0] - a.radius + (int)(a.x - Main.game.player.x) + width / 2;
			int y2 = a.points.get(i+1)[1] - a.radius + (int)(a.y - Main.game.player.y) + height / 2;

			g.drawLine(x1, y1, x2, y2);
		}

		//join first point to last point (close the figure)
		int x1 = a.points.get(a.points.size()-1)[0] - a.radius + (int)(a.x - Main.game.player.x) + width / 2;
		int y1 = a.points.get(a.points.size()-1)[1] - a.radius + (int)(a.y - Main.game.player.y) + height / 2;
		int x2 = a.points.get(0)[0] - a.radius + (int)(a.x - Main.game.player.x) + width / 2;
		int y2 = a.points.get(0)[1] - a.radius + (int)(a.y - Main.game.player.y) + height / 2;

		g.drawLine(x1, y1, x2, y2);
	}

	public void circleDraw(Thing t) {
		int x = (int)(t.x + width / 2 - Main.game.player.x);
		int y = (int)(t.y + height / 2 - Main.game.player.y);
		g.fillOval(x-(int)t.radius, y-(int)t.radius, 2*(int)t.radius, 2*(int)t.radius);
	}

	public void circleDraw(Actor a) {
		int x = (int)(a.x + width / 2 - Main.game.player.x);
		int y = (int)(a.y + height / 2 - Main.game.player.y);
		g.fillOval(x-(int)a.radius, y-(int)a.radius, 2*(int)a.radius, 2*(int)a.radius);
	}
}
