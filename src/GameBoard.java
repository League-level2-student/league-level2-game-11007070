import java.util.Random;

public class GameBoard {

	public void moveDown() {
		
	}
	
	public void moveRight() {
		
	}
	
	public void moveLeft() {
		
	}
	
	public void moveUp() {
		
	}
	
	TileObject[][] gameBoard = new TileObject[4][4];
	
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
}
