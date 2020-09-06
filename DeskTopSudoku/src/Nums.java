/**
 * These are the ten valid options for things that can be placed inside the Sudoku board
 * @author Tim Moll
 *
 */
public enum Nums {
	one('1',1),
	two('2',2),
	three('3',3), 
	four('4',4), 
	five('5',5),
	six('6',6),
	seven('7',7), 
	eight('8',8),
	nine('9',9),
	empty('.',0);
	
	private char numVal;
	private int intVal;
	
	Nums(char val,int valu){
		this.numVal = val;
		this.intVal = valu;
	}
	
	public char getVal(){
		return numVal;
	}
	public int getInt(){
		return intVal;
	}
}
