import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
/**
 * This class will analyze the txt file by words
 * It is responsible for the following questions:
 * Top-10 most frequent words:
 * Top-10 most frequent words without stop words:
 * (WildCard)The book's total number of words:
 * @author muyiyimiss
 *
 */
public class BookWords {

	/**
	 * These are instance variables
	 */
	private BookReader book;
	private ArrayList<WordsByLine> lineByWords;
	private StopListWords sw;

	
	/**
	 * This is the constructor
	 * @param bookName, the name of the txt file that will be scanned and analyzed
	 */
	public BookWords(String bookName){
		book = new BookReader(bookName);
		lineByWords = new ArrayList<WordsByLine>();
		sw = new StopListWords();
		convertToWord();
	}

	
	/**
	 * This method will convert the txt into an ArrayList of Words
	 */
	public void convertToWord(){
		for(int i = 0; i< book.getLines().size(); i++){
			String[] s = book.getLines().get(i).split(" ");

			for(int j = 0; j<s.length; j++){

				s[j]=s[j].replaceAll("[^a-zA-Z0-9-]", "").replace("-", "").replace(":", "");

			}

			WordsByLine aline = new WordsByLine(s);
			lineByWords.add(aline);
		}

	}

	/**
	 * This method will print out total number of words of the entire book
	 * @return, total number of words of the entire book
	 */
	public int countWords(){
		int count = 0;
		
		for(int i = 0; i<lineByWords.size(); i++){
			count = count + lineByWords.get(i).getSize();
		}
		
		return count;
	}
	
	
	/**
	 * This method will put all words and their frequencies into a hashmap
	 * @return a hashmap called wordsFrequency
	 */
	public HashMap<String, Integer> wordsFrequencyHashMap() {
		HashMap<String, Integer> wordsFrequencyHashmap = new HashMap<String, Integer>();

		for(int i = 0; i<lineByWords.size(); i++){
			for(int j = 0; j<lineByWords.get(i).getSize(); j++){	

				String word = lineByWords.get(i).getAWord(j).toLowerCase();

				if(!word.equalsIgnoreCase("")){

					if(wordsFrequencyHashmap.containsKey(word)){

						int count = wordsFrequencyHashmap.get(word)+1;

						wordsFrequencyHashmap.put(word, count);

					}else{
						wordsFrequencyHashmap.put(word, 1);
					}
				}


			}
		}
		return wordsFrequencyHashmap;
	}

	
	/**
	 * This method will print out top 10 words and their frequencies
	 */
	public void topTenWord(){

		HashMap<String, Integer> wordsFrequencies = wordsFrequencyHashMap();

		ArrayList<Integer> words = new ArrayList<Integer>();

		//Add all the frequencies to an arrayList
		words.addAll(wordsFrequencies.values());

		//Sort the frequencies in a descending order:
		int[] wordsArray = new int[wordsFrequencies.size()];

		for(int i = 0; i<wordsArray.length; i++){
			wordsArray[i] = words.get(i);
		}

		for(int i = 0; i<wordsArray.length; i++){
			for(int j = i; j<wordsArray.length; j++ )
				if(wordsArray[i]<wordsArray[j]){
					int temp = wordsArray[i];
					wordsArray[i] = wordsArray[j];
					wordsArray[j] = temp;
				}
		}

		ArrayList<String> top10counts  = new ArrayList<String>();
		
		
		for(int r = 0; r<10; r++){
			int a = wordsArray[r];
			for(String word: wordsFrequencies.keySet()){
				if( wordsFrequencies.get(word) == a){
					if(!top10counts.contains(word)){
					top10counts.add(word);
					}
				}
			}
		}
		
		
		for(int i=0; i<10; i++){
					
					System.out.println( wordsArray[i]+ ": " + top10counts.get(i));
					
				}


	}


	/**
	 * This method will put all words that are not stop words and their frequencies into a hashmap
	 * @return a hashmap called wordsFrequencyWithoutSWordsHashMap
	 */
	public HashMap<String, Integer> wordsFrequencyWithoutSWordsHashMap() {
		
		HashMap<String, Integer> wordFrequencies = new HashMap<String, Integer>();

		for(int i = 0; i<lineByWords.size(); i++){
			for(int j = 0; j<lineByWords.get(i).getSize(); j++){

				String word = lineByWords.get(i).getAWord(j).toLowerCase();

				if(!sw.isStopWord(word) && !word.equalsIgnoreCase("")){

					if(wordFrequencies.containsKey(word)){

						int count = wordFrequencies.get(word)+1;

						wordFrequencies.put(word, count);

					}else{
						wordFrequencies.put(word, 1);
					}
				}
			}
		}
		return wordFrequencies;
	}

	
	
	/**
	 * This method will print out top 10 words that are not stop words and their frequencies
	 */
	public void topTenWordWithoutStopList(){

		ArrayList<Integer> words = new ArrayList<Integer>();

		HashMap<String, Integer> wordFrequencies = wordsFrequencyWithoutSWordsHashMap();

		words.addAll(wordFrequencies.values());

		int[] wordsArray = new int[wordFrequencies.size()];

		for(int i = 0; i<wordsArray.length; i++){
			wordsArray[i] = words.get(i);
		}

		for(int i = 0; i<wordsArray.length; i++){
			for(int j = i; j<wordsArray.length; j++ )
				if(wordsArray[i]<wordsArray[j]){
					int temp = wordsArray[i];
					wordsArray[i] = wordsArray[j];
					wordsArray[j] = temp;
				}
		}

	
		ArrayList<String> top10counts  = new ArrayList<String>();
		
		
		for(int r = 0; r<10; r++){
			int a = wordsArray[r];
			for(String word: wordFrequencies.keySet()){
				if( wordFrequencies.get(word) == a){
					if(!top10counts.contains(word)){
					top10counts.add(word);
					}
					
				}
			}
		}
		
		
		for(int i=0; i<10; i++){
		
					System.out.println( wordsArray[i]+ ": " + top10counts.get(i));
					
				}

}

	}




