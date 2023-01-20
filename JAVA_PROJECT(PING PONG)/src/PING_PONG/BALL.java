package PING_PONG;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class BALL extends Rectangle{
	
	//instances
	Random random;
	int xVelocity;
	int yVelocity;
	int initialSpeed = 2;
	
	
	BALL(int x, int y, int width, int height){
		super(x, y, width, height);//ball
		random = new Random();
		int randomXDirection = random.nextInt(2);
		if(randomXDirection == 0) {
			randomXDirection --;
		}
		setXDirection(randomXDirection * initialSpeed);
		
		
		int randomYDirection = random.nextInt(2);
		if(randomYDirection == 0) {
			randomYDirection --;
		}
		setYDirection(randomYDirection * initialSpeed);
		
		
	}
	//ball moves along both x any axis
	
    public void setXDirection(int randomXDirection) {
		xVelocity = randomXDirection;
		
	}
    public void setYDirection(int randomYDirection) {
    	yVelocity = randomYDirection;
	
    }
    
    public void move() {
    	x = x + xVelocity;
    	y = y + yVelocity;
    }
    
    public void draw(Graphics g) {
    	g.setColor(Color.white);
    	g.fillOval(x, y, height, width);
    	
    }


}
