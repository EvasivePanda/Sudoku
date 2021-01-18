
public class SudokuSolver {

	Board starty;
	SudokuChecker sc;

	SudokuSolver() {
		sc = new SudokuChecker();
	}

	public boolean solve(Board b) {
		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++) {
				if (!b.isStartingVal(row, col) && b.getValAtLocation(row, col) == Nums.empty) {
					for (int k = 1; k < 10; k++) {
						b.placeValue(k, row, col);
						if (sc.isValidSudoku(b) && solve(b)) {
							return true;
						}
						b.removeValue(row, col);
					}
					return false;
				}
			}
		}
		return true;
	}
}
