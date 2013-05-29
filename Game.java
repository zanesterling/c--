import java.util.ArrayList;

public class Game implements KeyListener {

	ArrayList<Actor> actors;
	ArrayList<Thing> things;
	public static double c; // This is the speed of light.

	public Game() {
		actors = new ArrayList<Actor>();
	}

	public void start() {

	}

	public void tick() {
		for (Actor a : actors)
			a.update();
	}
}
