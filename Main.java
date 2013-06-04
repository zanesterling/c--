import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Canvas;

import java.lang.Runnable;

import javax.swing.JFrame;

public class Main extends Canvas implements Runnable {

	static final int WIDTH = 1250;
	static final int HEIGHT = 900;
	static final int FRAME_RATE = 30; //fps
	static final int TICK_TIME = 1000 / FRAME_RATE;

	static JFrame frame;
	Thread thread;
	boolean running;

	BufferedImage img;
	int[] pixels;

	static Screen screen;
	static Game game;

static Main mainComponent;
	static long fps;

	public Main() {
		Dimension size = new Dimension(WIDTH, HEIGHT);
		setPreferredSize(size);
		setMaximumSize(size);
		setMinimumSize(size);

		game = new Game();
		screen = new Screen(WIDTH, HEIGHT);
		img = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		pixels = ((DataBufferInt)img.getRaster().getDataBuffer()).getData();
	}

	public void start() {
		//don't start if you're running
		if (running) return;
		running = true;

		thread = new Thread(this);
		thread.run();
	}

	public void run() {
		System.out.println("Starting successfully. Good luck!");
		long lastTickTime = 0;
		while (running) {
			tick();
			render();

			//regulate framerate
			long time = System.currentTimeMillis();
			long tickTime = time - lastTickTime;
			if (tickTime < TICK_TIME) {
				try {
					Thread.sleep(TICK_TIME - tickTime);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else 
				System.out.println("WAH");

			fps = 1000 / (System.currentTimeMillis() - lastTickTime);

			lastTickTime = System.currentTimeMillis();
			System.out.println(tickTime);
		}
	}

	public void tick() {
		game.tick();
	}

	public void render() {
		screen.render(game);

		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		g.drawImage(screen.img, 0,0, WIDTH, HEIGHT, this);

		bs.show();
	}

	public void stop() {
		//don't stop if you're stopped
		if (!running) return;
		running = false;

		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Loading scores...");
		Scanner sc = new Scanner(new File("scores.txt"));
		String[] names = new String[10];
		int[] scores = new int[10];
		int score = game.kills;

		int i=0;
		while (scores[i] < score)
			i++;

		if (i > 0) {
			Scanner stdin = new Scanner(System.in);
			System.out.println("Enter your name.");
			String name = next();
			FileWriter fw = new FileWriter("scores.txt", false);

		}

		System.out.println("Safe exit. Goodbye!");
		System.exit(0);
	}

	public static void main(String[] args) {
		mainComponent = new Main();
		mainComponent.addKeyListener(game);
		mainComponent.addMouseListener(game);
		
		frame = new JFrame("Pert!");
		frame.add(mainComponent);
		frame.addKeyListener(game);
		frame.addMouseListener(game);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.pack();
		frame.setVisible(true);

		mainComponent.start();
	}
}
