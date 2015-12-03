package test;

import java.awt.Frame;

public class DrawFrame {
		GamePanel gamePanel;
	public DrawFrame(){
		Frame frame = new Frame("game");
		gamePanel = new GamePanel();
		frame.setLocation(300, 200);
		frame.setSize(320, 240);
		frame.add(gamePanel);
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		DrawFrame drawFrame = new DrawFrame();
		drawFrame.gamePanel.gameStarted();
	}
}
