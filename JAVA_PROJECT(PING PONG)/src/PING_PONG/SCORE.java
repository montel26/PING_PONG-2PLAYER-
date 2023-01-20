package PING_PONG;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class SCORE extends Rectangle{
	
	static int GAME_WIDTH;
	static int GAME_HEIGHT;
	
	//holds scores of players
	int player1;
	int player2;
	
	SCORE(int GAME_WIDTH, int GAME_HEIGHT){
		SCORE.GAME_HEIGHT = GAME_HEIGHT;
		SCORE.GAME_WIDTH = GAME_WIDTH;
	}
	
	public void  draw(Graphics g) {
		g.setColor(Color.white);
		g.setFont(new Font("Consolas", Font.PLAIN, 60));
		
		//draw line
		//g.drawLine(GAME_WIDTH/2, 0, GAME_WIDTH/2, GAME_HEIGHT);
		
		
		//draw string
		g.drawString(String.valueOf(player1), (GAME_WIDTH/2)-85, 50);
		g.drawString(String.valueOf(player2), (GAME_WIDTH/2)+20, 50);
	}

}
