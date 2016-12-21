/**
 * This class will help with converting each line of a book to a String[]
 * @author muyiyimiss
 *
 */
public class WordsByLine {
	
	/**
	 * This is the instance variable
	 */
	private String[] words;
	
	/**
	 * This is the constructor
	 * @param newWordArray
	 */
	public WordsByLine(String[] newWordArray){
		words = newWordArray;
	}
	
	/**
	 * This is the return method of its instance variable
	 * @return a String array
	 */
	public String[] getWordsByLine(){
		return words;
	}
	
	/**
	 * This method will take out the string in the array by specifying its index
	 * @param i, the index
	 * @return, the String at index i
	 */
	public String getAWord(int i){
		return words[i];
	}
	
	/**
	 * This method will get the length of the array
	 * @return
	 */
	public int getSize(){
		return words.length;
	}

}
