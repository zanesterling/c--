import java.util.ArrayList;
import java.awt.event.*;

public class Game implements KeyListener {

	ArrayList<Actor> actors;
	ArrayList<Thing> things;
	Player player;

	double c; // This is the speed of light.

	public Game() {
		c = 300000000;

		actors = new ArrayList<Actor>();
		things = new ArrayList<Thing>();
		player = new Player(0,0);
		actors.add(player);

		actors.add(new TestActor(100,100));
	}

	public void start() {

	}

	public void tick() {
		for (Actor a : actors)
			a.update();
	}

	public void keyPressed(KeyEvent e) {
		
	}

	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}
}
