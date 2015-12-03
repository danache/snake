package test;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import test.Snake;
import test.Food;

public class GamePanel extends Panel implements Runnable, KeyListener, FocusListener{
	private Snake snake;
	private Food foods[];
	private int foodNum;
	private Image im ;
	private int direction;
	static final int SOUTH = 0;
	static final int NORTH = 1;
	static final int EAST = 2;
	static final int WEST = 3;
	private static final int FPS = 50;
	public int width;
	public int height;
	private boolean pauseFlag;
	private boolean gameFlag;
	private boolean 
	focusFlag;
	public GamePanel(){
		snake = new Snake(this);
		foods = new Food[100];
		foodNum = 0;
		foods[foodNum++] = new Food(this, snake);
		direction = -1;
		pauseFlag = true;
		gameFlag = true;
		focusFlag = true;
		addFocusListener(this);
		addKeyListener(this);
	}
	
	public void gameUpdate(){
		snake.update();
		for (int i = 0;i < foodNum; i++){
			foods[i].update();
		}

	}
	
	public void gameRender(){
		im = createImage(getWidth(), getHeight());
		Graphics dbGraphics = im.getGraphics();
		snake.draw(dbGraphics);
	
		for (int i = 0;i < foodNum; i++){
			foods[i].draw(dbGraphics);
		}
		
		
		
	}
	
	public void gamePaint(){
		Graphics graphics = this.getGraphics();
		graphics.drawImage(im, 0, 0, null);
	}
	
	public int getDirection(){
		return direction;
	};
	
	public void keyTyped(KeyEvent e){};
	
	public void keyReleased(KeyEvent e){};
	
	public void gameStarted(){
		 width = this.getWidth();
		height = this.getHeight();
		gameFlag = true;
		Thread gameTheread = new Thread(this);
		gameTheread.start();
	}
	
	public void run(){
		if (gameFlag){
		long t1, t2, dt, sleepTime;
		long period = 1000 / FPS;
		t1 = System.nanoTime();
		while (true) {
			if (pauseFlag && focusFlag){
				gameUpdate();
			}
			gameRender();
			gamePaint();
			t2 = System.nanoTime();
			dt = (t2 - t1) / 1000000L;
			sleepTime = period - dt;
			if (sleepTime <= 0) {
				sleepTime = 2;
			}
			try{
				Thread.sleep(sleepTime);
			}catch (InterruptedException e){}
			t1 = System.nanoTime();
		}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyCode = e.getKeyCode();
		
		switch (keyCode) {
		
		case KeyEvent.VK_DOWN:
			if (direction != NORTH){
				direction = SOUTH;
			}
			break;
			
		case KeyEvent.VK_UP:
			if (direction != SOUTH){
					direction = NORTH;
				}
			break;
			
		case KeyEvent.VK_RIGHT:
			if (direction != WEST){
					direction = EAST;
				}break;
			
		case KeyEvent.VK_LEFT:
			if (direction != EAST){
				direction = WEST;
				}
			break;
		case KeyEvent.VK_P:
			pauseFlag = !pauseFlag;
			break;
		case KeyEvent.VK_1:
			end();
			break;
		case KeyEvent.VK_ADD:
			snake.incSpeed();
			break;
		case KeyEvent.VK_SUBTRACT:
			snake.decSpeed();
			break;
		case KeyEvent.VK_A:
			addFood();
			break;
		default:
			break;
		}
		
	}

	public void end(){
		
		snake = new Snake(this);
		foods = new Food[100];
		foodNum = 0;
		foods[foodNum++] = new Food(this, snake);
		direction = -1;
		pauseFlag = true;
		gameFlag = false;
		focusFlag = true;
	}
	
	public void addFood(){
		foods[foodNum++] = new Food(this, snake);
	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		focusFlag = true;
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		focusFlag = false;
	}
}


