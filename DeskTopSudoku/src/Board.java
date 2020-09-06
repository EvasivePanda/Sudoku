//import java.util.HashMap;



public class Board {

	/** This is the 2-d array that holds the cells that make up the board itself.*/
	private Cell[][] board; 
	/**This is the copy of the board so creation of sudokus can be made*/
	private Board boardCopy;
	//private HashMap  lastChangeableLoc = new HashMap <Integer, Cell>();
	
	public Board(){
		this.board = new Cell[9][9];
		for(int row = 0; row < 9; row++){
			for(int col = 0; col < 9; col++){
				board[row][col] = new Cell();
			}
		}
	}
	
	public Board Copy(){
		boardCopy = new Board();
		for(int row = 0; row < 9; row++){
			for(int col = 0; col < 9; col++){
				boardCopy.placeValue(this.board[row][col].value.getInt(), row, col);
			}
		}
		boardCopy.finalizeBoard();
		return this.boardCopy;
	}
	
	public Nums getValAtLocation(int row, int col){
		return board[row][col].value;
	}
	
	public Nums getEnum(int val){
		if(val == 1){
			return Nums.one;
		}if(val == 2){
			return Nums.two;
		}
		if(val == 3){
			return Nums.three;
		}
		if(val == 4){
			return Nums.four;
		}
		if(val == 5){
			return Nums.five;
		}
		if(val == 6){
			return Nums.six;
		}
		if(val == 7){
			return Nums.seven;
		}
		if(val == 8){
			return Nums.eight;
		}
		if(val == 9){
			return Nums.nine;
		}
		return Nums.empty;
	}
	
	

	/**
	 * This method places a passed boardable element onto the board in the coordinates passed into it. It throws an exception 
	 * if the location is invalid for the board or if the element is null.
	 * @param elem : The element that will be placed onto the board.
	 * @param row : Integer value of the desired row the element will be placed in
	 * @param col : Integer value of the desired colum the element will be placed in
	 */
	public void placeValue(int value,int row, int col){
		if(row >= 9 || col >= 9 || row < 0 || col <0){
			throw new IllegalArgumentException("Cannot place value out of bounds");
		}
		if(value >9 || value<0){
			throw new IllegalArgumentException("Value is not in range of Sudoku values (Integers from 1-9 (0 for empty)");
		}
		board[row][col].addElement(getEnum(value));
	}
	
	public void removeValue(int row, int col){
		if(row >= 9 || col >= 9 || row < 0 || col <0){
			throw new IllegalArgumentException("Cannot place value out of bounds");
		}
		board[row][col].removeElement();		
	}
	
	
	public void finalizeBoard(){
		for(int i = 0; i < 9; i++){
			for(int j = 0; j<9; j++){
				if(!board[i][j].value.equals(Nums.empty)){
					
				board[i][j].setAsStartingVal();
				}
			}
		}
	}
	
	
	/**
	public void setLastChangeableVal(){
		boolean foundCV = false;
		for(int i = 8; i > -1; i--){
			for(int j = 8; j>-1;  j--){
				if(!board[i][j].isStartingValue() && !foundCV){
				this.lastChangeableLoc.put(1,board[i][j]);
				foundCV = true;
				}
			}
		}

	}**/
	
/**
	public boolean isFilledOut(){
		for(int i = 0; i <9 ; i++){
			for(int j = 0; j<9;  j++){
				if(board[i][j].element.equals(Nums.empty)){
				return false;
				}
			}
		}
		return true;

	}
	*/
	public String getStringBoard(){
		String printer="";
		for(int i = 0; i < 9; i++){
			printer = printer +"\n";
			for(int j = 0; j<9; j++){
				printer = printer+board[i][j].toString();
			}
		}
		return printer;
}
	/**
	 * This method prints out the current state of the board. It creates a string of all of the cells toStrings and 
	 * presents that to the user.
	 */
	public void printBoard(){
		String printer="";
		for(int i = 0; i < 9; i++){
			printer = printer +"\n";
			for(int j = 0; j<9; j++){
				printer = printer+board[i][j].toString();
			}
		}
		System.out.println(printer);
	}
	
	public boolean isStartingVal(int row, int col){
		return board[row][col].isStartingValue();
	}
	
	/**
	 * This nested class is what makes up the overall board. Many cells are used to create one cohesive board. The cells can have two 
	 * states (visible and invisible). The cells can also have multiple elements inside of them. The combination of these two things change 
	 * what the cell looks like on the board, how its printed.
	 * @author Timothy Moll
	 *
	 */
	private class Cell {
		/**This boolean tells if a cell is a starting value*/
		private boolean isStartingValue;
		/**This array list holds the multiple elements that may be placed into a particular cell*/ 
		Nums value;
		
		/**
		 * This constructor sets the instance variables that store the location coordinates of this cell.
		 * @param row : Integer value for the row of this cell
		 * @param col : Inbteger value for the column of this cell
		 */
		public Cell (){
			//this.row = row;
			//this.col = col;
			this.value = Nums.empty;
			isStartingValue = false;
		}
		
		/**
		 * This method adds a particular element into this cell.
		 * @param elem : Passed boardable element that is being put into the cell
		 */
		public boolean addElement(Nums elem){
			if(!isStartingValue){
				value = elem;
				return true;
			}
			return false;
		}
		
		public void setAsStartingVal(){
			this.isStartingValue = true;
		}
		
		public boolean isStartingValue(){
			return this.isStartingValue;
		}
		
		
		/**
		 * This method removes an element from a cell if it is located in the cell
		 * @param elem : Element that is being removed from the cell
		 * @return : IF the cell had that element and it was removed
		 */
		public boolean removeElement(){
			if(!this.isStartingValue){
				value = Nums.empty;
				return true;
			}
			return false;
		}
		
		/**
		 * This method creates a string based on the three things that a cell can print. It either prints the cells 'invisible' state (#).
		 * A cells empty visible state ( ). Or a cells filled visible state (The toString of the element filling the cell).
		 */
		public String toString(){   
			return this.value.getVal()+"";
		}
		
	}
}
