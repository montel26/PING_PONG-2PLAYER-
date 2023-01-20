package PING_PONG;

import java.awt.*;
import java.awt.event.*;


public class PADDLES extends Rectangle{
	
	int id;//1 or 2 represents the players
	int yVelocity;
	int speed = 2;
	
	PADDLES(int x, int y, int PADDLE_WIDTH, int PADDLE_HEIGHT, int id){
		super(x,y,PADDLE_WIDTH, PADDLE_HEIGHT);
		this.id = id;
	}
	
	//KEY PRESSED
	public void keyPressed(KeyEvent e) {
		switch(id) {
		case 1:
			if(e.getKeyCode() == KeyEvent.VK_U) {
				setYDirection(-speed);
				move();
			}
			if(e.getKeyCode() == KeyEvent.VK_D) {
				setYDirection(speed);
				move();
			}
			break;
		case 2:
			if(e.getKeyCode() == KeyEvent.VK_UP) {
				setYDirection(-speed);
				move();	
			}
			if(e.getKeyCode() == KeyEvent.VK_DOWN) {
				setYDirection(speed);
				move();	
			}
			break;
	
		}
	}
	
	//KEY RELEASED
	public void keyReleased(KeyEvent e) {
		switch(id) {
		case 1:
			if(e.getKeyCode() == KeyEvent.VK_D) {
				setYDirection(0); //0 and not speed because you will just move forever if you use speed
				move();
				
			}
			if(e.getKeyCode() == KeyEvent.VK_U) {
				setYDirection(0);
				move();
				
			}
			break;
		case 2:
			if(e.getKeyCode() == KeyEvent.VK_DOWN) {
				setYDirection(0);
				move();
				
			}
			if(e.getKeyCode() == KeyEvent.VK_UP) {
				setYDirection(0);
				move();
				
			}
			break;
	
		}
		
	}
	
	public void setYDirection(int yDirection) {
		yVelocity = yDirection;
	}
	
	public void move() {
		y = y + yVelocity;
	}
	
	public void draw(Graphics g) {
		if(id == 1) {
			g.setColor(Color.blue);
		}
		if(id == 2) {
			g.setColor(Color.red);
		}
		g.fillRect(x, y, width, height);
	}

}
