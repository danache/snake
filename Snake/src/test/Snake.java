package test;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import test.*;;

public class Snake {
	GamePanel gamePanel;
	private Point[] body;
	public static final int MAXLENTH = 50;
	private int head;
	private int tail;
	public int length;
	private int speed;
	public int x;
	public int y;
	public int diameter;
	
	public void incSpeed() {
		speed++;
	}	
	
	public void decSpeed(){
		if (speed != 0) {
			speed--;
		}
	}
	public Snake(GamePanel gp) {
		gamePanel = gp;
		body = new Point[MAXLENTH];
		head = -1;
		tail = -1;
		length = 1;
		speed = 3;
		x = 50;
		y = 50;
		diameter = 10;
	}

	public void update() {
		int direction = gamePanel.getDirection();
		switch (direction) {

			case GamePanel.SOUTH:
				y += speed;
				break;

			case GamePanel.NORTH:
				y -= speed;
				break;

			case GamePanel.EAST:
				x += speed;
				break;

			case GamePanel.WEST:
				x -= speed;
				break;

			default:
				break;
		}
		head = (head + 1) % body.length;
		tail = (head + body.length - length + 1) % body.length;
		body[head] = new Point(x, y);
	};

	public void draw(Graphics graphics) {
		graphics.setColor(Color.BLUE);
		if (length > 1){
			int i = tail;
			while (i != head) {
				if (body[i].x == body[head].x && body[i].y == body[head].y) {
					gamePanel.end();
				}
				if (!beyondEdge(body[i].x, body[i].y)) {
					gamePanel.end();
				}
				graphics.fillOval(body[i].x, body[i].y, diameter, diameter);
				i = (i + 1) % body.length;
			}
		}
		graphics.setColor(Color.red);
		if(head != -1){
			if (!beyondEdge(body[head].x, body[head].y)) {
				gamePanel.end();
			}
		graphics.fillOval(body[head].x,body[head].y , diameter, diameter);
		}
	};
	public boolean beyondEdge(int x, int y){
		return 0 < x && x < gamePanel.width && 0 < y && y < gamePanel.height;
	};
}