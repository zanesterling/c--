import java.util.ArrayList;
import java.awt.event.*;

public class Game implements KeyListener {

	ArrayList<Actor> actors;
	ArrayList<Thing> things;
	Player player;

	boolean[] keysPressed;

	public static double c; // This is the speed of light.

	public Game() {
		actors = new ArrayList<Actor>();
		things = new ArrayList<Thing>();
		player = new Player(0,0);
		actors.add(player);

		keysPressed = new boolean[4];
	}

	public void tick() {
		for (Actor a : actors)
			a.update();
	}

	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
			case KeyEvent.VK_W: keysPressed[0] = true;
			case KeyEvent.VK_A: keysPressed[1] = true;
			case KeyEvent.VK_S: keysPressed[2] = true;
			case KeyEvent.VK_D: keysPressed[3] = true;
		}
	}

	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()) {
			case KeyEvent.VK_W: keysPressed[0] = false;
			case KeyEvent.VK_A: keysPressed[1] = false;
			case KeyEvent.VK_S: keysPressed[2] = false;
			case KeyEvent.VK_D: keysPressed[3] = false;
		}
	}

	public void keyTyped(KeyEvent e) {}
}
