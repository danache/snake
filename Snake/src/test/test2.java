/*package test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;

public class test2 {
	MyPanel mPanel;
	public test2(){
		mPanel = new MyPanel();
		Frame frame = new Frame("game");
		frame.setLocation(300, 200);
		frame.setSize(800, 600);
		frame.add(mPanel);
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		test2 sTest2 = new test2();
		sTest2.mPanel.gameStart();
	}
}

class MyPanel extends Panel implements Runnable,KeyListener {
	
	private int x;
	private int y;
	private int diameter;
	private int dx;
	private int dy;
	private int direction;
	static final int SOUTH = 0;
	static final int NORTH = 1;
	static final int EAST = 2;
	static final int WEST = 3;
	Image image;
	private static final int FPS = 50;
	
	public MyPanel(){
		x = 100;
		y = 50;
		diameter = 100;
		dx = 10;
		dy = 10;
		direction = -1;
		addKeyListener(this);
	}
	public void gameStart(){
		Thread gameThread = new Thread(this);
		gameThread.start();
	}
	public void paint(Graphics graphics) {
		graphics.setColor(Color.BLUE);
		graphics.fillOval(x, y, diameter, diameter);

	}
	public void  gameUpdate() {
		
		switch (direction) {

		case GamePanel.SOUTH:
			y += dy;
			break;

		case GamePanel.NORTH:
			y -= dy;
			break;

		case GamePanel.EAST:
			x += dx;
			break;

		case GamePanel.WEST:
			x -= dx;
			break;

		default:
			break;
			}
	}
	
	public void keyPressed(KeyEvent e) {
		System.out.print("sss");
		// TODO Auto-generated method stub
		int keyCode = e.getKeyCode();
		
		switch (keyCode) {
		
		case KeyEvent.VK_DOWN:
			direction = SOUTH;
			System.out.println("1");
			break;
			
		case KeyEvent.VK_UP:
			direction = NORTH;
			System.out.println("1");
			break;
			
		case KeyEvent.VK_RIGHT:
			direction = EAST;	
			System.out.println("1");
			break;
			
		case KeyEvent.VK_LEFT:
			direction = WEST;
			System.out.println("1");
			break;

		default:
			break;
		}
		
	}
	public void keyTyped(KeyEvent e){};
	
	public void keyReleased(KeyEvent e){};
	public void gameRender(){
		image = createImage(getWidth(), getHeight());
		Graphics dbg = image.getGraphics();
		dbg.setColor(Color.blue);
		dbg.fillOval(x, y, diameter, diameter);
		
	}
	public void gamePaint(){
		Graphics graphics = this.getGraphics();
		graphics.drawImage(image, 0, 0, null);
		graphics.dispose();
	}
	public void run() {
		long t1, t2, dt, sleepTime;
		long period = 1000 / FPS;
		t1 = System.nanoTime();
		while (true) {
			gameUpdate();
			gameRender();
			gamePaint();
			t2 = System.nanoTime();
			dt = (t2 - t2) / 1000000L;
			sleepTime = period - dt;
			if (sleepTime <= 0) {
				sleepTime = 2;
			}
			try{
				Thread.sleep(sleepTime);
			}
			catch (InterruptedException ex){}
			t1 = System.nanoTime();
		}
	}
}
*/