import java.util.Random;

import javax.swing.JOptionPane;

public class GameBoard {

	public void moveDown() {
		for (int k = 0; k < gameBoard.length; k++) {
			for (int i = 0; i < gameBoard.length-1; i++) {
				for (int j = 0; j < gameBoard[i].length; j++) {
					if (gameBoard[i][j].value > 0 && gameBoard[i+1][j].value == 0) {
						TileObject temp = gameBoard[i][j];
						gameBoard[i][j] = gameBoard[i+1][j];
						gameBoard[i+1][j] = temp;
					}
					else if (gameBoard[i][j].value == gameBoard[i+1][j].value) {
						gameBoard[i+1][j].value += gameBoard[i][j].value;
						score += gameBoard[i+1][j].value + gameBoard[i][j].value;
						gameBoard[i][j].value = 0;
					}
				}
			}
		}
	}
	
	public void moveRight() {
		for (int k = 0; k < gameBoard.length; k++) {
			for (int i = 0; i < gameBoard.length; i++) {
				for (int j = 0; j < gameBoard[i].length-1; j++) {
					if (gameBoard[i][j].value > 0 && gameBoard[i][j+1].value == 0) {
						TileObject temp = gameBoard[i][j];
						gameBoard[i][j] = gameBoard[i][j+1];
						gameBoard[i][j+1] = temp;
					}
					else if (gameBoard[i][j].value == gameBoard[i][j+1].value) {
						gameBoard[i][j+1].value += gameBoard[i][j].value;
						score += gameBoard[i][j+1].value + gameBoard[i][j].value;
						gameBoard[i][j].value = 0;
					}
				}
			}
		}
	}
	
	public void moveLeft() {
		for (int k = 0; k < gameBoard.length; k++) {
			for (int i = 0; i < gameBoard.length; i++) {
				for (int j = gameBoard[i].length-1; j > 0; j--) {
					if (gameBoard[i][j].value > 0 && gameBoard[i][j-1].value == 0) {
						TileObject temp = gameBoard[i][j];
						gameBoard[i][j] = gameBoard[i][j-1];
						gameBoard[i][j-1] = temp;
					}
					else if (gameBoard[i][j].value == gameBoard[i][j-1].value) {
						gameBoard[i][j-1].value += gameBoard[i][j].value;
						score += gameBoard[i][j-1].value + gameBoard[i][j].value;
						gameBoard[i][j].value = 0;
					}
				}
			}
		}
	}
	
	public void moveUp() {
		for (int k = 0; k < gameBoard.length; k++) {
			for (int i = gameBoard.length-1; i > 0; i--) {
				for (int j = 0; j < gameBoard[i].length; j++) {
					if (gameBoard[i][j].value > 0 && gameBoard[i-1][j].value == 0) {
						TileObject temp = gameBoard[i][j];
						gameBoard[i][j] = gameBoard[i-1][j];
						gameBoard[i-1][j] = temp;
					}
					else if (gameBoard[i][j].value == gameBoard[i-1][j].value) {
						gameBoard[i-1][j].value += gameBoard[i][j].value;
						score += gameBoard[i-1][j].value + gameBoard[i][j].value;
						gameBoard[i][j].value = 0;
					}
				}
			}
		}
	}
	
	public boolean mergeLeft() {
		boolean mergeL = false;
		for (int k = 0; k < gameBoard.length; k++) {
			for (int i = 0; i < gameBoard.length; i++) {
				for (int j = gameBoard[i].length-1; j > 0; j--) {
					if (gameBoard[i][j].value == gameBoard[i][j-1].value) {
						mergeL = true;
					}
				}
			}
		}
		return mergeL;
	}
	
	public boolean mergeUp() {
		boolean mergeU = false;
		for (int k = 0; k < gameBoard.length; k++) {
			for (int i = gameBoard.length-1; i > 0; i--) {
				for (int j = 0; j < gameBoard[i].length; j++) {
					if (gameBoard[i][j].value == gameBoard[i-1][j].value) {
						mergeU = true;
					}
				}
			}
		}
		return mergeU;
	}
	
	public boolean mergeRight() {
		boolean mergeR = false;
		for (int k = 0; k < gameBoard.length; k++) {
			for (int i = 0; i < gameBoard.length; i++) {
				for (int j = 0; j < gameBoard[i].length-1; j++) {
					if (gameBoard[i][j].value == gameBoard[i][j+1].value) {
						mergeR = true;
					}
				}
			}
		}
		return mergeR;
	}
	
	public boolean mergeDown() {
		boolean mergeD = false;
		for (int k = 0; k < gameBoard.length; k++) {
			for (int i = 0; i < gameBoard.length-1; i++) {
				for (int j = 0; j < gameBoard[i].length; j++) {
					if (gameBoard[i][j].value == gameBoard[i+1][j].value) {
						mergeD = true;
					}
				}
			}
		}
		return mergeD;
	}
	
	TileObject[][] gameBoard = new TileObject[4][4];
	int score = 0; 
	
	GameBoard() {
		for (int i = 0; i < gameBoard.length; i++) {
			for (int j = 0; j < gameBoard[i].length; j++) {
				gameBoard[i][j] = new TileObject();
			}
		}
		
		Random ran = new Random();
		
		int row = ran.nextInt(gameBoard.length);
		int col = ran.nextInt(gameBoard[0].length);
		
		gameBoard[row][col].value = 2;
		
		boolean sameRow = true;
		boolean sameCol = true;
		int row2 = 0;
		int col2 = 0;
		while (sameRow && sameCol) {
			row2 = ran.nextInt(gameBoard.length);
			col2 = ran.nextInt(gameBoard[0].length);
			
			if (row != row2) {
				sameRow = false;
			}
			if (col != col2)
				sameCol = false;
		}
		
		gameBoard [row2][col2].value = 2;
		
		printBoard();
	}
	
	public void printBoard() {
		
		for (int i = 0; i < gameBoard.length; i++) {
			for (int j = 0; j < gameBoard[i].length; j++) {
				System.out.print(gameBoard[i][j].value + " ");
			}
			System.out.println();
		}
		
	}
	
	public void addNewTile() {
		Random ran = new Random();
		
		boolean isThere = true;
		int row = 0;
		int col = 0;
		
		while (isThere) {
			row = ran.nextInt(gameBoard.length);
			col = ran.nextInt(gameBoard[0].length);
			
			if (gameBoard[row][col].value == 0) {
				isThere = false;
			}
			
		}
		
		gameBoard [row][col].value = 2;
	}
	
	public boolean checkWin() {
		boolean won = false;
		for (int i = 0; i < gameBoard.length; i++) {
			for (int j = 0; j < gameBoard[i].length; j++) {
				if (gameBoard[i][j].value == 2048) {
					JOptionPane.showMessageDialog(null, "Congrats! You've won!");
					won = true;
				}
			}
		}
		return won;
	}
	
	public boolean checkLose() {
		boolean lose = false;
		boolean zeroTiles = false;
		for (int i = 0; i < gameBoard.length; i++) {
			for (int j = 0; j < gameBoard[i].length; j++) {
				if (gameBoard[i][j].value == 0) {
					zeroTiles = true;
				}
			}
		}
		boolean mergeL = mergeLeft();
		boolean mergeR = mergeRight();
		boolean mergeD = mergeDown();
		boolean mergeU = mergeUp();
		
		if (zeroTiles == false) {
			if (mergeL == false && mergeR == false && mergeD == false & mergeU == false) {
				lose = true;
				JOptionPane.showMessageDialog(null, "Sorry but you lost!");
			}
		}
		return lose;
	}
	
	public void countScore() {
		
	}
}
