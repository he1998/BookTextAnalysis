import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class will analyze a book by characters.
 * It is responsible for the question of "Top-10 most frequent letters along with the frequency"
 * @author muyiyimiss
 *
 */
public class BookChars {

	/**
	 * These are instance variables
	 */
	private BookReader book;
	private ArrayList<CharsByLine> lineByChars;
	
	/**
	 * this is the constructor
	 * @param bookName, the name of the txt file that will be scanned and analyzed
	 */
	public BookChars(String bookName){
		
		book = new BookReader(bookName);
		lineByChars = new  ArrayList<CharsByLine>();
		convertToChar();
	}


	/**
	 * This method will convert every line in the txt file into an arraylist of CharsByLine, and store them in to lineByChars
	 */
	private void convertToChar(){
		for(int i = 0; i< book.getLines().size(); i++){
			CharsByLine line = new CharsByLine(book.getLines().get(i).toCharArray());
			lineByChars.add(line);
		}
	}

	/**
	 * This method will put all letters and their frequencies into a hashmap
	 * @return a hashmap called charFrequency
	 */
	private HashMap<Character, Integer> letterFrequencyHashMap() {
		
		HashMap<Character, Integer> charFrequency = new HashMap<Character, Integer>();

		for (int i = 0; i<lineByChars.size(); i++){
			for (int j = 0; j<lineByChars.get(i).getSize(); j++){
				char letter = lineByChars.get(i).getAChar(j);
				if (Character.isLetter(letter)) {
					char c = Character.toLowerCase(letter);
					if (charFrequency.containsKey(c)) {
						int count = charFrequency.get(c) +1;
						charFrequency.put(c, count);
					} else {
						charFrequency.put(c, 1);
					}
				}
			}
		}
		return charFrequency;
	}


	/**
	 * This method will print the top Ten letters with their frequencies
	 */
	public void topTenLetter(){

		HashMap<Character, Integer> charFrequency = letterFrequencyHashMap();

		ArrayList<Integer> counts = new ArrayList<Integer>();

		//Add all the frequencies to an arrayList
		counts.addAll(charFrequency.values());

		//Sort the frequencies in a descending order:
		int[] letters = new int[charFrequency.size()];

		for(int i = 0; i<letters.length; i++){
			letters[i] = counts.get(i);
		}

		for(int i = 0; i<letters.length; i++){
			for(int j = i; j<letters.length; j++ )
				if(letters[i]<letters[j]){
					int temp = letters[i];
					letters[i] = letters[j];
					letters[j] = temp;
				}
		}

		ArrayList<Character> top10words  = new ArrayList<Character>();


		for(int r = 0; r<10; r++){
			int a = letters[r];
			for(char word: charFrequency.keySet()){
				if( charFrequency.get(word) == a){
					top10words.add(word);
				}
			}
		}


		for(int i=0; i<10; i++){

			System.out.println( letters[i]+ ": " + top10words.get(i));

		}

	}



}

