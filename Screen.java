import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

public class Screen extends Bitmap {

	BufferedImage img;
	Graphics g;

	int size;
	long lastMsgTick;
	String message;

	public Screen(int width, int height) {
		super(width, height);
		
		img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		g = img.getGraphics();

		size = 40;
		lastMsgTick = -200;
		message = "";
	}

	public void render(Game game) {

		//repaint background
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, width, height);

        if (game.over) {
			g.setColor(Color.RED);
			g.setFont(new Font(Font.DIALOG, Font.BOLD, 50));
			g.drawString("GAME OVER", 450, 400);
        } 

        else {
            //draw things
            for (Thing t : game.things) {
				g.setColor(t.color);
                if (t.points != null)
                    vectorDraw(t);
                else
                    circleDraw(t);
			}

            //draw actors
            for (Actor a : game.actors) {
				g.setColor(a.color);
				if (a.points != null)
					vectorDraw(a);
				else
					circleDraw(a);
			}

            //draw gui
            for (int i=0; (i+1)*size<=width && i < game.player.health; i++) {
                g.setColor(Color.WHITE);
                g.drawOval(i*(size+10), height-size, size, size);
                g.setColor(Color.RED);
                g.drawRect(i*(size+10) + size/2 - 5, height-size+5, 10, size-10);
                g.drawRect(i*(size+10)+ 5, height-size + size/2 - 5, size-10, 10);
            }

        

       		if(Main.game.ticks - lastMsgTick < 100){
				g.setColor(Color.RED);
				g.setFont(new Font(Font.DIALOG, Font.BOLD, 50));
				g.drawString(message, 450, 400);
       		}
       	}

		g.setColor(Color.WHITE);
		g.setFont(new Font(Font.DIALOG, Font.BOLD, 15));
		g.drawString("C: " + (int) Main.game.c, 0, 20);
		g.drawString("FPS: " + Main.fps, 0, 40);
		g.drawString("HEALTH: " + Main.game.player.health, 1158, 20);
		g.drawString("AMMO: " + Main.game.player.weapon.ammo, 1158, 40);
		g.drawString("CASUALTIES: " + Main.game.kills, 1100, 820);

	}

	public void vectorDraw(Thing t) {}

	public void vectorDraw(Actor a) {
		ArrayList<double[]> points = new ArrayList<double[]>();
		for (int[] point : a.points)
			points.add(new double[]{point[0], point[1]});
		//for (int[] point : a.points)
		//	points.add(Lorentz.contract(point[0], point[1], a.vx, a.vy));

		for (int i=0; i<a.points.size()-1; i++) {
			//join points and things
			int x1 = (int)points.get(i)[0] + (int)(a.x - Main.game.player.x) + width / 2;
			int y1 = (int)points.get(i)[1] + (int)(a.y - Main.game.player.y) + height / 2;
			int x2 = (int)points.get(i+1)[0] + (int)(a.x - Main.game.player.x) + width / 2;
			int y2 = (int)points.get(i+1)[1] + (int)(a.y - Main.game.player.y) + height / 2;

			g.drawLine(x1, y1, x2, y2);
		}

		//join first point to last point (close the figure)
		int x1 = (int)points.get(a.points.size()-1)[0] + (int)(a.x - Main.game.player.x) + width / 2;
		int y1 = (int)points.get(a.points.size()-1)[1] + (int)(a.y - Main.game.player.y) + height / 2;
		int x2 = (int)points.get(0)[0] + (int)(a.x - Main.game.player.x) + width / 2;
		int y2 = (int)points.get(0)[1] + (int)(a.y - Main.game.player.y) + height / 2;

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
