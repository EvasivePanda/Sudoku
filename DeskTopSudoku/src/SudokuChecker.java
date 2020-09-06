import java.util.HashMap;


public class SudokuChecker {

	private Board board;
	
	SudokuChecker(){
		//this.board = b;
	}
	
	
	
	public boolean isValidSudoku(Board board){
		this.board = board;
		
		for (int i=0; i<9;i++){
			if(!rowCheck(i)){
				//System.out.println("On horizontal  line "+ i+"!");
				return false;
			}
		}
		
		for(int i=0; i<9;i++){
			if(!colCheck(i)){
				//System.out.println("On vertical line "+ i+"!");
				return false;
			}
		}
		
		
		for(int i=0; i<9;i++){
			if(i<3){						//probably can make this prettier
				if(!gridCheck(i%3, 0)){
					//System.out.println("@ "+ i%3+" "+ 0+"!");
					return false;
				}
			}
			if(i >=3 && i < 6){
				if(!gridCheck(i%3, 3)){
					//System.out.println("@ "+ i%3+" "+ 3+"!");
					return false;
				}			
			}
			if(i>=6){
				if(!gridCheck(i%3, 6)){
					//System.out.println("@ "+ i%3+" "+ 6+"!");
					return false;
				}			
			}
		}
		
		return true;
	} 
	
	public boolean gridCheck(int row, int col){
		Nums eval;
		int roww = row*3;
		HashMap<Nums, Integer> map = new HashMap<>();
		for(int i = 0; i<3; i++){
			for(int j = 0; j<3; j++){
			eval = board.getValAtLocation(roww+i,col+j);
			//System.out.println("checking n =" +eval);

			if(eval !=Nums.empty){
				if(map.get(eval)==null){
					map.put(eval, 1);
				}else{
					//System.out.println("The value " + eval.getVal()+" is repeated in the 3x3");
					return false;
				}
			}
			}
		}
		return true;
	}
	
	
	public boolean colCheck(int colCheck){
		HashMap<Nums, Integer> map = new HashMap<>();
		Nums eval;
		for(int i=0; i<9;i++){
			//eval = Array.getChar(board[i], colCheck);
			eval = board.getValAtLocation(i, colCheck);
			if(eval !=Nums.empty){
				if(map.get(eval)==null){
					map.put(eval, 1);
				}else{
					//System.out.println("The value " + eval+" is repeated in the column");
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean rowCheck(int rowCheck){
		HashMap<Nums, Integer> map = new HashMap<>();
		map.clear();
		Nums eval;
		for(int i=0; i<9;i++){
			//eval = Array.getChar(board[i], colCheck);
			eval = board.getValAtLocation(rowCheck, i);
			if(eval !=Nums.empty){
				if(map.get(eval)==null){
					map.put(eval, 1);
				}else{
					//System.out.println("The value " + eval+" is repeated in the column");
					return false;
				}
			}
		}
		return true;
	}
}
