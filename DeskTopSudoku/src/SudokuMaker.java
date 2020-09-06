import java.util.Random;


public class SudokuMaker {
	private Board dokuBoard;
	SudokuChecker sc;
	SudokuSolver ss;
	Random rn = new Random();
	
	SudokuMaker(Board b){
		this.dokuBoard = b;
		 sc = new SudokuChecker();
		 ss = new SudokuSolver();
	}
	
	
	public Board boardMakesy(){
		boolean gotNum = false;
		int tries;
		int numC;
		for (int i =0; i< 9; i++){
			for (int j = 0; j< 9; j++){
				gotNum = false;
				tries=0;
				if(rn.nextInt(10) < 4){
				while(!gotNum && tries<10){
					numC = rn.nextInt(9)+1;
					dokuBoard.placeValue(numC, i, j);
					tries++;
					if(!ss.solve(dokuBoard.Copy())){
						dokuBoard.removeValue(i, j);
					}else{
						gotNum=true;
					}
				}}else{
					dokuBoard.removeValue(i, j);
					gotNum=true;
				}
			}
		}
	
	//	this.dokuBoard.printBoard();
		dokuBoard.finalizeBoard();
		return this.dokuBoard;
	}
}
