package PING_PONG;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class GAME_PANEL extends  JPanel implements Runnable{
	//static used in case we make multiple instances of game panel  they all share the same GAMEWIDTH constant
	//final keyword stops use from tampering with the value
	static final int GAME_WIDTH = 1000;
	static final int GAME_HEIGHT = 500;
	static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH, GAME_HEIGHT);
	
	//ball diameter
	static final int BALL_DIAMETER = 20;
	
	//paddle dimensions
	static final int PADDLE_WIDTH = 25;
	static final int PADDLE_HEIGHT = 100;
	
	//DECLARE A FEW INSTANCES
	Thread  gameThread;//using thread because we using the runnable interface
	Image image;
	Graphics graphics;
	Random random;
	PADDLES paddle1;
	PADDLES paddle2;
	SCORE score;
	BALL ball;
	
	
	GAME_PANEL(){
		newPaddles();
		newBall();
		score = new SCORE(GAME_WIDTH, GAME_HEIGHT);
		this.setFocusable(true);
		this.addKeyListener(new AL());
		this.setPreferredSize(SCREEN_SIZE);
		
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	//new ball method
	public void newBall() {
		random = new Random();
		ball  = new BALL((GAME_WIDTH/2) - (BALL_DIAMETER/2), (GAME_HEIGHT/2)- (BALL_DIAMETER/2), BALL_DIAMETER, BALL_DIAMETER);
		
	}
	
	//new paddles method
	public void newPaddles() {
		paddle1 = new PADDLES(0, (GAME_HEIGHT/2) - (PADDLE_HEIGHT/2), PADDLE_WIDTH, PADDLE_HEIGHT, 1);
		paddle2 = new PADDLES(GAME_WIDTH - PADDLE_WIDTH, (GAME_HEIGHT/2) - (PADDLE_HEIGHT/2), PADDLE_WIDTH, PADDLE_HEIGHT, 2);
	}
	
	//paint method
	public void paint(Graphics g) {
		image = createImage(getWidth(), getHeight());
		graphics = image.getGraphics();
		draw(graphics);
		g.drawImage(image, 0, 0, this);
		
	}
	
	//draw method
	public void draw(Graphics g) {
		paddle1.draw(g);
		paddle2.draw(g);
		ball.draw(g);
		score.draw(g);
	}
	
	//move method
	public void move() {
		paddle1.move();
		paddle2.move();//increase speed and make moving more fluid
		ball.move();
	}
	
	//collision checker for ball , PADDLES, AND boarders
	//also stops paddle from moving off screen
	public void checkCollision() {
		//bounce ball off the edges
		if(ball.y <= 0) {
			ball.setYDirection(-ball.yVelocity); //the minus sign makes the ball go the opposite way once the collision is made
		}
		if(ball.y >= GAME_HEIGHT-BALL_DIAMETER) {
			ball.setYDirection(-ball.yVelocity);
		}
				
		//bounce ball off paddle
		if(ball.intersects(paddle1)) {
		   ball.xVelocity = Math.abs(ball.xVelocity); //convert negative number to positive
		   ball.xVelocity++;//for more difficulty
		   if(ball.yVelocity > 0) {
			  ball.yVelocity++;
		   }else {
			  ball.yVelocity --;
		   }
		ball.setXDirection(ball.xVelocity);
		ball.setYDirection(ball.yVelocity);
		}
				
		if(ball.intersects(paddle2)) {
			ball.xVelocity = Math.abs(ball.xVelocity); //convert negative number to positive
			ball.xVelocity++;//for more difficulty
			if(ball.yVelocity > 0) {
				ball.yVelocity++;
			}else {
				ball.yVelocity --;
			}
			ball.setXDirection(-ball.xVelocity);
			ball.setYDirection(ball.yVelocity);
				}			
		if(paddle1.y <= 0) {
			paddle1.y = 0;
		}
		if(paddle1.y >= (GAME_HEIGHT - PADDLE_HEIGHT)) {
			paddle1.y = GAME_HEIGHT - PADDLE_HEIGHT;
		}
		
		if(paddle2.y <= 0) {
			paddle2.y = 0;
		}
		if(paddle2.y >= (GAME_HEIGHT - PADDLE_HEIGHT)) {
			paddle2.y = GAME_HEIGHT - PADDLE_HEIGHT;
		}
		
		//give a player 1 point
		//creates new paddles
		//creates new ball
		if(ball.x <= 0) {
			score.player2++;
			newPaddles();
			newBall();
			 
		}
		if(ball.x >= GAME_WIDTH-BALL_DIAMETER) {
			score.player1++;
			newPaddles();
			newBall();
			
		}
		
	}
	
	//run method
	public void run() {
		//game loop
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;//nano seconds
		double delta = 0;
		while(true) {
			long now = System.nanoTime();
			delta += (now - lastTime)/ns;
			lastTime = now;
			if(delta >= 1) {
				move();
				checkCollision();
				repaint();
				delta--;
			
			}
		}
	}
	
	//CLASS action listener to your events
	public class AL extends KeyAdapter{ //INNER CLASS
		//contains 2 methods
		public void keyPressed(KeyEvent e) {
			paddle1.keyPressed(e);
			paddle2.keyPressed(e);
			
		}
		
		public void keyReleased(KeyEvent e) {
			paddle1.keyReleased(e);
			paddle2.keyReleased(e);
		}
	}

}
