package PING_PONG;

import java.awt.*;
import javax.swing.*;

public class GAMEFRAME extends JFrame{
	//creates panel objECT in frame so when you call frame in main it also calls the panel
	GAME_PANEL panel;
	
	GAMEFRAME(){
		panel = new GAME_PANEL();
		this.add(panel);
		this.setTitle("Pong Game");
		this.setResizable(false);//do not allow anyone to resize it 
		this.setBackground(Color.BLACK);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //SO IF PRESS THE X THS CLOSSES THE APPLICATION
		this.pack();//this basically use the game frame class and have it fit on our game panel. like a glove.
		//so we do not have to set the size of our game fame this does it for us.
		
		this.setVisible(true);
		this.setLocationRelativeTo(null);//set window to appear in the middle
		
	}

}

