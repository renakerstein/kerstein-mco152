package kerstein.connectfour;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class ConnectFourJFrame extends JFrame {
	ConnectFourGame game = new ConnectFourGame();
	private final ImageIcon blankPiece = new ImageIcon("blank.png");
	private final ImageIcon arrow = new ImageIcon("arrow.png");
	private final ImageIcon player1Piece = new ImageIcon("RED.png");
	private final ImageIcon player2Piece = new ImageIcon("BLACK.png");
	private final int maxRows = 6;
	private final int maxColumns = 7;
	private JButton[] buttons;
	private JLabel[][] slots;
	private int again;
	private Boolean won = false;

	public static void main(String[] args) {
		new ConnectFourJFrame().setVisible(true);

	}

	public ConnectFourJFrame() {
		setTitle("CONNECT FOUR");
		setSize(800, 600);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// use grid layout
		GridLayout layout = new GridLayout(7, 6);
		Container container = getContentPane();
		container.setLayout(layout);
		game.intializeBoard();

		// instantiate array of JButtons
		buttons = new JButton[maxColumns];
		for (int i = 0; i < buttons.length; i++) {
			container.add(buttons[i] = new JButton());
			buttons[i].setIcon(arrow);
			int counter = i;
			buttons[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent event) {
					try {
						int row = game.dropPiece(counter);
						if (game.getCurrentPlayer() == 1) {
							slots[row][counter].setIcon(player1Piece);
						} else {
							slots[row][counter].setIcon(player2Piece);
						}
					} catch (FullColumnException ex) {
						JOptionPane.showConfirmDialog(container,
								"THIS COLUMN IS FULL \nTRY AGAIN",
								"Connect Four", JOptionPane.CLOSED_OPTION);
						game.switchPlayer(); // make sure the player who tried
						// to enter in a full column
						// has another chance to enter
						// and it should not skip
						// his/her turn

					}
					won = game.gameStatus(); // check current status of the game
					if (won == true) {
						again = JOptionPane.showConfirmDialog(
								container,
								game.getColor()
								+ " WINS!!! \nDo you want to play again?",
								"Connect four", JOptionPane.YES_NO_OPTION);
						if (again == JOptionPane.YES_OPTION) {
							for (int i = 0; i < slots.length; i++) {
								for (int column = 0; column < slots[i].length; column++) {
									slots[i][column].setIcon(blankPiece);
								}
							}
							game.intializeBoard(); // reset the logic grid
							game.setCurrentPlayer(1); // set player 1 to go
							// first again
							game.setColor("RED"); // set player 1 to be red
						} else {
							JOptionPane.showMessageDialog(container,
									"HAVE A GOOD DAY! \nTHANK YOU FOR PLAYING");
							System.exit(0);
						}
					} else if (won == false && game.isFull()) {
						again = JOptionPane
								.showConfirmDialog(
										container,
										"DRAW - THERE IS NO WINNER! \nDo you want to play again?",
										"Connect four",
										JOptionPane.YES_NO_OPTION);
						if (again == JOptionPane.YES_OPTION) {
							for (int i = 0; i < slots.length; i++) {
								for (int column = 0; column < slots[i].length; column++) {
									slots[i][column].setIcon(blankPiece);
								}
							}
							game.intializeBoard(); // reset the logic grid
							game.setCurrentPlayer(1); // set player 1 to go
							// first again
							game.setColor("RED"); // set player 1 to be red
						} else {
							JOptionPane.showMessageDialog(container,
									"HAVE A GOOD DAY! \nTHANK YOU FOR PLAYING");
							System.exit(0);
						}
					} else {
						game.switchPlayer();
					}
				}
			});
		}// close for loop

		// instantiate 2 dimensional array of JLables
		slots = new JLabel[maxRows][maxColumns];
		for (int row = 0; row < slots.length; row++) {
			for (int column = 0; column < slots[row].length; column++) {
				slots[row][column] = new JLabel();
				slots[row][column].setIcon(blankPiece);
				add(slots[row][column]);

			}

		}
	}
}
