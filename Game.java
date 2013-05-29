import java.util.ArrayList;

public class Game implements KeyListener {

	ArrayList<Actor> actors;
	ArrayList<Thing> things;
	Player player;

	public static double c; // This is the speed of light.

	public Game() {
		actors = new ArrayList<Actor>();
		player = new Player(0,0,
	}

	public void start() {

	}

	public void tick() {
		for (Actor a : actors)
			a.update();
	}

	public void keyPressed() {
		
	}

	public void keyReleased() {}
	public void keyTyped() {}
}
