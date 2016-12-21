/**
 * This class will help with converting each line of a book to a char[]
 * @author muyiyimiss
 *
 */
public class CharsByLine {
	
	/**
	 * This is the instance variable
	 */
	private char[] c;
	
	/**
	 * This is the constructor
	 * @param newCharArray
	 */
	public CharsByLine(char[] newCharArray){
		c = newCharArray;
	}
	
	/**
	 * This is the get method of the instance variable
	 * @return a char[], which contains every line by characters.
	 */
	public char[] getCharsByLine(){
		return c;
	}
	
	/**
	 * This method will take out the character in the array by specifying its index
	 * @param i, the index
	 * @return the character at index i
	 */
	public char getAChar(int i){
		return c[i];
	}
	
	/**
	 * This method will get the length of the array
	 * @return
	 */
	public int getSize(){
		return c.length;
	}
	
}
