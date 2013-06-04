import java.util.ArrayList;
import java.awt.event.*;

public class Game implements KeyListener, MouseListener {

	ArrayList<Actor> actors;
	ArrayList<Thing> things;
	ArrayList<Boolean> actorDeathFlags;
	ArrayList<Boolean> thingDeathFlags;
	ArrayList<Actor> actorsToAdd;
	ArrayList<Thing> thingsToAdd;

	Player player;

	boolean[] keysPressed;
	boolean shiftPressed;
	boolean mouseDown;

	boolean over;

	int kills = 0;

	long ticks;

	public Game() {
		init();
	}

	public void init() {
		actors = new ArrayList<Actor>();
		things = new ArrayList<Thing>();
		actorsToAdd = new ArrayList<Actor>();
		thingsToAdd = new ArrayList<Thing>();
		actorDeathFlags = new ArrayList<Boolean>();
		thingDeathFlags = new ArrayList<Boolean>();
		
		player = new Player(0,0);
		addActor(player);

		for (int i=0; i<1000; i++)
			addActor(new BasicEnemy(Math.random()*1000, Math.random()*1000));

		keysPressed = new boolean[4];
		over = false;
		mouseDown = false;

		ticks = 0;

	}

	public void tick() {
		if (!over) {
				for (Actor a : actors)
					a.update();

				for (Actor a : actorsToAdd)
					actors.add(a);
				actorsToAdd = new ArrayList<Actor>();

				for (Thing t : thingsToAdd)
					things.add(t);
				thingsToAdd = new ArrayList<Thing>();

				for (int i=0; i<actors.size(); i++)
					if (actorDeathFlags.get(i) == Boolean.TRUE) {
						actors.remove(i);
						actorDeathFlags.remove(i);
						i--;
					}

				for (int i=0; i<things.size(); i++)
					if (thingDeathFlags.get(i) == Boolean.TRUE) {
						things.remove(i);
						thingDeathFlags.remove(i);
						i--;
					}

				//System.out.println(Math.sqrt(player.vx*player.vx + player.vy*player.vy));

				if (player.health <= 0)
					end();

				if (actors.size() < 100) {
					BasicEnemy.accel *= 1.2;
					init();
				}

				ticks++;
		}
	}

	public void end() {
		over = true;
	}

	public void addActor(Actor a) {
		actorsToAdd.add(a);
		actorDeathFlags.add(false);
	}

	public void addThing(Thing t) {
		thingsToAdd.add(t);
		thingDeathFlags.add(false);
	}

	public void mousePressed(MouseEvent e) {
		mouseDown = true;
	}

	public void mouseReleased(MouseEvent e) {
		mouseDown = false;
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
	
	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void keyTyped(KeyEvent e) {}
}
