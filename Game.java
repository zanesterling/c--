import java.util.ArrayList;
import java.awt.event.*;

public class Game implements KeyListener {

	ArrayList<Actor> actors;
	ArrayList<Boolean> actorDeathFlags;
	ArrayList<Thing> things;
	Player player;

	boolean[] keysPressed;
	boolean shiftPressed;

	boolean over;

	double c; // This is the speed of light.

	public Game() {
		c = 300000000;

		actors = new ArrayList<Actor>();
		actorDeathFlags = new ArrayList<Boolean>();
		things = new ArrayList<Thing>();
		player = new Player(0,0);
		add(player);

		for (int i=0; i<10; i++)
			add(new BasicEnemy(200, 50*i - 225));

		keysPressed = new boolean[4];
		over = false;
	}

	public void tick() {
		for (Actor a : actors)
			a.update();

		for (int i=0; i<actors.size(); i++)
			if (actorDeathFlags.get(i) == Boolean.TRUE) {
				actors.remove(i);
				actorDeathFlags.remove(i);
			}

		System.out.println(Math.sqrt(player.vx*player.vx + player.vy*player.vy));

		if (player.health <= 0)
			end();
	}

	public void end() {
		over = true;
	}

	public void add(Actor a) {
		actors.add(a);
		actorDeathFlags.add(false);
	}

	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
			case KeyEvent.VK_W: keysPressed[0] = true; break;
			case KeyEvent.VK_A: keysPressed[1] = true; break;
			case KeyEvent.VK_S: keysPressed[2] = true; break;
			case KeyEvent.VK_D: keysPressed[3] = true; break;
			case KeyEvent.VK_SHIFT: shiftPressed = true; break;
			case KeyEvent.VK_Q: Main.mainComponent.stop();
		}
	}

	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()) {
			case KeyEvent.VK_W: keysPressed[0] = false; break;
			case KeyEvent.VK_A: keysPressed[1] = false; break;
			case KeyEvent.VK_S: keysPressed[2] = false; break;
			case KeyEvent.VK_D: keysPressed[3] = false; break;
			case KeyEvent.VK_SHIFT: shiftPressed = false; break;
		}
	}

	public void keyTyped(KeyEvent e) {}
}
