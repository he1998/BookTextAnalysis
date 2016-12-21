
import java.util.ArrayList;
/**
 * This class will read the StopListWords and put them in an ArrayList<String>
 * @author muyiyimiss
 *
 */
public class StopListWords {
	
	/**
	 * This is the instance variable
	 */
	private BookReader readStopWords;
	private ArrayList<String> stopWordsLines;
	
	/**
	 * This is the constructor
	 */
	public StopListWords(){
		readStopWords = new BookReader("stop-list.txt");

		stopWordsLines = new ArrayList<String>();

		convertToWord();
	}
	
	/**
	 * This method will add each word into an ArrayList<String> 
	 */
	public void convertToWord(){
		for(int i = 0; i< readStopWords.getLines().size(); i++){
			String s = readStopWords.getLines().get(i).replaceAll("[^a-zA-Z0-9-]", "").replace("-", "").replace(":", "");
			stopWordsLines.add(s.toLowerCase());
		}

	}
	
	/**
	 * This method will get the stopWordLines at a specific index
	 * @param i, the index
	 * @return the words at i
	 */
	public String getWord(int i){
		return stopWordsLines.get(i);
	}
	
	/**
	 * This method will tell whether a word is a stop word or not
	 * @param the String that needs to be judged
	 * @return true if it is a stop word, false if it is not
	 */
	public boolean isStopWord(String s){
		boolean isStopWord = false;
		for(int i = 0; i<stopWordsLines.size(); i++){
			String sWord = stopWordsLines.get(i);
			if(s.equals(sWord)){
				isStopWord = true;
				break;
			}else{
				isStopWord = false;
			}
			
		}
		return isStopWord;
	}
	

}
