import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener{
	@Override
	public void paintComponent(Graphics g){
		if(currentState == MENU){
		    drawMenuState(g);
		}
		else if(currentState == GAME){
		    drawGameState(g);
		}
		else if(currentState == END){
		    drawEndState(g);
		}
	}
	
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	int currentState = MENU;
	Timer frameDraw;
	Font titleFont = new Font("Arial", Font.PLAIN, 48);
	Font startFont = new Font("Arial", Font.PLAIN, 25);
	Font scoreFont = new Font("Arial", Font.PLAIN, 25);
	Font endFont = new Font("Arial", Font.PLAIN, 48);
	GameBoard gameBoard;
	
	
	GamePanel() {
	    frameDraw = new Timer(1000/60,this);
	    frameDraw.start();
	}
	
	void drawMenuState(Graphics g) {
		g.setColor(Color.lightGray);
		g.fillRect(0, 0, Game2048.WIDTH, Game2048.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.GRAY);
		g.drawString("2048", 190, 90);
		
		g.setFont(startFont);
		g.setColor(Color.GRAY);
		g.drawString("Press ENTER to start", 120, 280);
		
	}
	
	void drawGameState(Graphics g) {
		g.setColor(Color.lightGray);
		g.fillRect(0, 0, Game2048.WIDTH, Game2048.HEIGHT);
		
		g.setFont(scoreFont);
		g.setColor(Color.GRAY);
		g.drawString("Score: " + gameBoard.score, 320, 30);
		
		gameBoard.draw(g);
	}
	
	void drawEndState(Graphics g) {
		g.setColor(Color.lightGray);
		g.fillRect(0, 0, Game2048.WIDTH, Game2048.HEIGHT);
		
		g.setFont(endFont);
		g.setColor(Color.GRAY);
		g.drawString("End of Game", 190, 90);
	}
	
	void updateMenuState() {  
		
	}
	void updateGameState() {  
		
	}
	void updateEndState()  {  
		
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode()==KeyEvent.VK_ENTER) {
			if (currentState == END) {
				currentState = MENU;
			}
			else if (currentState == MENU) {
				currentState = GAME;
				gameBoard = new GameBoard();
				
			}
			else {
				currentState++;
			}
		}
		
		if (e.getKeyCode()==KeyEvent.VK_SPACE) {
			
		}
		
		if (e.getKeyCode()==KeyEvent.VK_UP) {
			System.out.println("UP");
			gameBoard.moveUp();
			gameBoard.addNewTile();
			gameBoard.printBoard();
			boolean won = gameBoard.checkWin();
			boolean lose = gameBoard.checkLose();
			if (won == true || lose == true) {
				frameDraw.stop();
				currentState = END;
			}
		}	
		
		if (e.getKeyCode()==KeyEvent.VK_DOWN) {
			System.out.println("DOWN");
			gameBoard.moveDown();
			gameBoard.addNewTile();
			gameBoard.printBoard();
			boolean won = gameBoard.checkWin();
			boolean lose = gameBoard.checkLose();
			if (won == true || lose == true) {
				frameDraw.stop();
				currentState = END;
			}
		}
	
		if (e.getKeyCode()==KeyEvent.VK_LEFT) {
			System.out.println("LEFT");
			gameBoard.moveLeft();
			gameBoard.addNewTile();
			gameBoard.printBoard();
			boolean won = gameBoard.checkWin();
			boolean lose = gameBoard.checkLose();
			if (won == true || lose == true) {
				frameDraw.stop();
				currentState = END;
			}
		}
		
		if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
			System.out.println("RIGHT");
			gameBoard.moveRight();
			gameBoard.addNewTile();
			gameBoard.printBoard();
			boolean won = gameBoard.checkWin();
			boolean lose = gameBoard.checkLose();
			if (won == true || lose == true) {
				frameDraw.stop();
				currentState = END;
			}
		}
		
	}
	

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(currentState == MENU){
		    updateMenuState();
		}else if(currentState == GAME){
		    updateGameState();
		}else if(currentState == END){
		    updateEndState();
		}
		//System.out.println("action");
		repaint();
		
	}
	
}
