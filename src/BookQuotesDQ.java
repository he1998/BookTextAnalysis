import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * This class will analyze the txt file by quotes.
 * It will used to deal with text that use double quotation marks
 * It is responsible for the following questions:
 * Top-10 longest quotes:
 * Top-10 shortest quotes:
 * @author muyiyimiss
 *
 */
public class BookQuotesDQ {


	/**
	 * These are instance variables
	 */
	private BookReader book;
	private ArrayList<String> quotes;

	/**
	 * This is the constructor
	 */
	public BookQuotesDQ(String bookName){
		book = new BookReader(bookName);

		quotes = new ArrayList<String>();

		extractQuote();
	}



	/**
	 * This method will extract quotes and add it into aliceQuotes
	 */
	public void extractQuote(){

		Pattern p = Pattern.compile("(\\s\"\\w[^\"]*\\p{Punct}\")");

		String wholeString = book.getLines().toString();
		Matcher m = p.matcher(wholeString);

		while(m.find()){
			quotes.add(m.group());
		}	
	}

	/**
	 * This method will print the top10 longest quotes
	 */
	public void getTop10LongestQuotes(){

		ArrayList<Integer> lengthArray = new ArrayList<Integer>();
		
		HashMap<String, Integer> quoteLength = new HashMap<String, Integer>();

		for(int i = 0; i<quotes.size(); i++){

			String quote = quotes.get(i).trim();

			int length = quote.length();

			if(!quoteLength.containsKey(quote)){
				quoteLength.putIfAbsent(quote, length);
				lengthArray.add(length);
			}
		}

		int[] lengthArray2 = new int[lengthArray.size()];

		for(int i = 0; i<lengthArray2.length; i++){
			lengthArray2 [i] = lengthArray.get(i);
		}

		for(int i = 0; i<lengthArray2.length; i++){
			for(int j = i; j<lengthArray2.length; j++ )
				if(lengthArray2[i]<lengthArray2[j]){
					int temp = lengthArray2[i];
					lengthArray2[i] = lengthArray2[j];
					lengthArray2[j] = temp;
				}
		}

		ArrayList<String> top10quotes  = new ArrayList<String>();

		for(int r = 0; r<10; r++){
			int a = lengthArray2[r];
			for(String quote: quoteLength.keySet()){
				if( quoteLength.get(quote) == a){
					if(!top10quotes.contains(quote)){
					top10quotes.add(quote);
					}
				}
			}
		}


		for(int i=0; i<10; i++){

			System.out.println(  lengthArray2[i]+ ": " + top10quotes.get(i));

		}

	}

	/**
	 * This method will print the top10 shortest quotes
	 */
	public void getTop10ShortestQuotes(){

		//Put quotes' length into an array called lengthArray and sort the array.
		//Put quotes & length into a hashmap called quoteLength
		ArrayList<Integer> lengthArray = new ArrayList<Integer>();
	
		HashMap<String, Integer> quoteLength = new HashMap<String, Integer>();

		for(int i = 0; i<quotes.size(); i++){

			String quote = quotes.get(i).trim().replaceAll("\\W", "");

			int length = quote.length();

			if(!quoteLength.containsKey(quote)){
				//lengthArray[i] = length;
				quoteLength.putIfAbsent(quote, length);
				lengthArray.add(length);
			}
		}

		int[] lengthArray2 = new int[lengthArray.size()];

		for(int i = 0; i<lengthArray2.length; i++){
			lengthArray2 [i] = lengthArray.get(i);
		}

		for(int i = 0; i<lengthArray2.length; i++){
			for(int j = i; j<lengthArray2.length; j++ )
				if(lengthArray2[i]>lengthArray2[j]){
					int temp = lengthArray2[i];
					lengthArray2[i] = lengthArray2[j];
					lengthArray2[j] = temp;
				}
		}

		ArrayList<String> top10quotes  = new ArrayList<String>();

		for(int r = 0; r<10; r++){
			int a = lengthArray2[r];
			for(String quote: quoteLength.keySet()){
				if( quoteLength.get(quote) == a){
					if(!top10quotes.contains(quote)){
					top10quotes.add(quote);
					}
				}
			}
		}


		for(int i=0; i<10; i++){

			System.out.println(  lengthArray2[i]+ ": " + top10quotes.get(i));

		}


	}

}
