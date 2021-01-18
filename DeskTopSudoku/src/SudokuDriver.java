import java.util.Scanner;

public class SudokuDriver {

	/** This is the scanner used to get the user inputs for the boards size. */
	private Scanner userInput = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SudokuDriver sd = new SudokuDriver();
		sd.testy();
		// sd.makeGame();
		// frameClass fc = new frameClass();
		// fc fgdssdm n
		// fc.makeBoxForGame(null);
	}

	public void makeGame() {
		/**
		 * JFrame frame = new JFrame("FrameDemo");
		 * frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //3. Create components
		 * and put them in the frame. //...create emptyLabel... frame.setSize(800,600);
		 * 
		 * //4. Size the frame. //frame.pack();
		 * 
		 * //5. Show it. frame.setVisible(true); frame.setTitle("Sudoku Game"); //
		 * JFrame.setDefaultLookAndFeelDecorated(true); //JFrame fdrame = new JFrame("A
		 * window");
		 */

	}

	public void testy() {

		SudokuChecker sc = new SudokuChecker();
		Board b = new Board();
		Board c;
		SudokuMaker sm = new SudokuMaker(b);
		// c = sm.boardMakesy();
		c = makeValidDoku(b);
		// c = makeHardestSudoku(b);
		// frameClass fc = new frameClass();
		// fc.makeBoxForGame(c.getStringBoard());
		// fc.test();
		// c.finalizeBoard();
		SudokuSolver ss = new SudokuSolver();
		// b = sm.boardMakesy();
		c.printBoard();
		if (ss.solve(c)) {
			System.out.println(" Things possible");
			c.printBoard();
		} else {
			System.out.println("Sorry not possible");
		}
		// window.print(c.getStringBoard());
		// c.printBoard();
		// c.printBoard();
		// System.out.println(" ?"+ss.solveSud(c,0,0,1));

		// Board b = new Board();
		// b.printBoard();
		// sc.isValidSudoku(b);
		// c.placeValue(8, 0, 0);
		// b.removeValue(0, 0);
	}

	public Board makeHardestSudoku(Board b) {
		b.placeValue(8, 0, 0);
		b.placeValue(3, 1, 2);
		b.placeValue(6, 1, 3);
		b.placeValue(7, 2, 1);
		b.placeValue(2, 2, 6);
		b.placeValue(9, 2, 4);
		b.placeValue(5, 3, 1);
		b.placeValue(7, 3, 5);
		b.placeValue(4, 4, 4);
		b.placeValue(5, 4, 5);
		b.placeValue(7, 4, 6);
		b.placeValue(1, 5, 3);
		b.placeValue(3, 5, 7);
		b.placeValue(1, 6, 2);
		b.placeValue(6, 6, 7);
		b.placeValue(8, 6, 8);
		b.placeValue(8, 7, 2);
		b.placeValue(5, 7, 3);
		b.placeValue(1, 7, 7);
		b.placeValue(9, 8, 1);
		b.placeValue(4, 8, 6);
		return b;
	}

	public Board makeValidDoku(Board b) {
		b.placeValue(5, 0, 0); // Should be a 5 here
		b.placeValue(3, 0, 1);
		b.placeValue(7, 0, 4);
		b.placeValue(6, 1, 0);
		b.placeValue(1, 1, 3);
		b.placeValue(9, 1, 4);
		b.placeValue(5, 1, 5);
		b.placeValue(9, 2, 1);
		b.placeValue(8, 2, 2);
		b.placeValue(6, 2, 7);
		b.placeValue(8, 3, 0);
		b.placeValue(6, 3, 4);
		b.placeValue(3, 3, 8);
		b.placeValue(4, 4, 0);
		b.placeValue(8, 4, 3);
		b.placeValue(3, 4, 5);
		b.placeValue(1, 4, 8);
		b.placeValue(7, 5, 0);
		b.placeValue(2, 5, 4);
		b.placeValue(6, 5, 8);
		b.placeValue(6, 6, 1);
		b.placeValue(2, 6, 6);
		b.placeValue(8, 6, 7);
		b.placeValue(4, 7, 3);
		b.placeValue(1, 7, 4);
		b.placeValue(9, 7, 5);
		b.placeValue(5, 7, 8);
		b.placeValue(8, 8, 4);
		b.placeValue(7, 8, 7);
		b.placeValue(9, 8, 8);
		return b;
	}

}
