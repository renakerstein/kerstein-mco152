package kerstein.connectfour;

import javax.swing.JLabel;

public class ConnectFourGame extends JLabel {
	private int[][] grid; // logic grid
	private final int maxRows = 6;
	private final int maxColumns = 7;
	private int currentPlayer;
	private String color;

	public ConnectFourGame() {
		this.currentPlayer = 1; // by default player1/ RED will go first
		this.color = "RED";
		this.grid = new int[maxRows][maxColumns];

	}

	public void setCurrentPlayer(int currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void intializeBoard() {
		// initialize logic grid
		for (int row = 0; row < maxRows; row++) {
			for (int column = 0; column < maxColumns; column++) {
				grid[row][column] = 0;
			}
		}
	}

	public String getColor() {
		return color;
	}

	public void switchPlayer() {
		if (this.currentPlayer == 1) {
			this.currentPlayer = 2;
			this.color = "BLACK";
		} else {
			this.currentPlayer = 1;
			this.color = "RED";
		}
	}

	public int dropPiece(int column) throws FullColumnException {
		boolean dropped = false;
		for (int row = maxRows - 1; row > -1; row--) {
			if (grid[row][column] == 0) { // the spot in the grid is empty
				grid[row][column] = currentPlayer;
				dropped = true;
				return row;
			}
		}
		if (dropped == false) {
			throw new FullColumnException();
		}
		return column;
	}

	public int getCurrentPlayer() {
		return currentPlayer;
	}

	public boolean isFull() {
		for (int row = 0; row < grid.length; row++) {
			for (int column = 0; column < grid[row].length; column++) {
				if (grid[row][column] == 0) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean gameStatus() {
		boolean consecutiveNumbers = false;
		for (int row = 0; row < 6; row++) {
			for (int column = 0; column < 4; column++) {
				int counterColumn = column; // to prevent the column from
				// incrementing in the if
				// statement and then again in
				// the for loop
				if (grid[row][counterColumn] == currentPlayer
						&& grid[row][++counterColumn] == currentPlayer
						&& grid[row][++counterColumn] == currentPlayer
						&& grid[row][++counterColumn] == currentPlayer) {
					consecutiveNumbers = true;
					return consecutiveNumbers;

				}
			}
		}
		// check down
		for (int row = 0; row < 3; row++) {
			for (int column = 0; column < 7; column++) {
				int counterRow = row; // to prevent the row from
				// incrementing in the if statement
				// and then again in the for loop
				if (grid[counterRow][column] == currentPlayer
						&& grid[++counterRow][column] == currentPlayer
						&& grid[++counterRow][column] == currentPlayer
						&& grid[++counterRow][column] == currentPlayer) {
					consecutiveNumbers = true;
					return consecutiveNumbers;

				}

			}
		}
		// check diagonally one way- negative slope
		for (int row = 0; row < 3; row++) {
			for (int column = 0; column < 4; column++) {
				int counterRow = row; // to prevent the row from incrementing in
				// the
				// if statement
				// and then again in the for loop
				int counterColumn = column;
				// to prevent the column from incrementing in the if statement
				// and
				// then again in the for loop
				if (grid[counterRow][counterColumn] == currentPlayer
						&& grid[++counterRow][++counterColumn] == currentPlayer
						&& grid[++counterRow][++counterColumn] == currentPlayer
						&& grid[++counterRow][++counterColumn] == currentPlayer) {
					consecutiveNumbers = true;
					return consecutiveNumbers;
				}
			}
		}

		// check diagonally the other way-positive slope
		for (int row = 3; row < 6; row++) {
			for (int column = 0; column < 4; column++) {
				int counterRow = row;
				// to prevent the row from incrementing in the if statement and
				// then again in the for loop
				int counterColumn = column; // to prevent the column
				// incrementing in the if statement
				// and then again in the for loop
				if (grid[counterRow][counterColumn] == currentPlayer
						&& grid[--counterRow][++counterColumn] == currentPlayer
						&& grid[--counterRow][++counterColumn] == currentPlayer
						&& grid[--counterRow][++counterColumn] == currentPlayer) {
					consecutiveNumbers = true;
					return consecutiveNumbers;
				}
				// if consecutiveNumbers is not found to be true in any of the
				// if statements it will remain
				// false as it was assigned in the beginning of the method
				// and
				// continue in the loop

			}
		}
		return consecutiveNumbers;
	}

}
