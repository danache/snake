package test;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.font.NumericShaper.Range;
import java.util.Random;

public class Food {
	private GamePanel gamePanel;
	private Snake snake;
	public Point location;
	public Point size;
	private Random random;
	
	public Food(GamePanel gp, Snake sk){
		gamePanel = gp;
		snake = sk;
		random = new Random();
		location = new Point(Math.abs(random.nextInt() % (gamePanel.width + 1 ) ),Math.abs(random.nextInt() % (gamePanel.height + 1 )));
		size = new Point(sk.diameter, sk.diameter);
	
	}
	public void update(){
		int deltx = (snake.x - location.x)* (snake.x - location.x);
		int delty = (snake.y - location.y)* (snake.y - location.y);
		int size = snake.diameter * snake.diameter;
		
		if ((deltx + delty) < size) {
			location = new Point(Math.abs(random.nextInt() % gamePanel.width),Math.abs(random.nextInt() % gamePanel.height));
			if (snake.length < snake.MAXLENTH) {
				snake.length++;
				
			}
			
		}
	};
	
	public void draw(Graphics graphics){
		graphics.setColor(Color.black);
		graphics.fillRect(location.x, location.y, size.x, size.y);
	};
	

}