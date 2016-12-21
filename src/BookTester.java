import java.util.Scanner;
/**
 * This is the tester class
 * @author muyiyimiss
 *
 */
public class BookTester {

	public static void main(String[] args) {
		
		System.out.println("=================================================");
		System.out.println("Here is a list of books: (Enter the book's index(1-9) to see it's textual analysis; enter 0 to quit)");

		System.out.println("1. [Alice In Wonderland]");
		System.out.println("2. [Christmas Carol]");
		System.out.println("3. [Huck Finn]");
		System.out.println("4. [Les Mis]");
		System.out.println("5. [Metamorphosis]");
		System.out.println("6. [My Man Jeeves]");
		System.out.println("7. [Pride Prejudice]");
		System.out.println("8. [Tale of Two Cities]");
		System.out.println("9. [Tom Sawyer]");
		System.out.println("0. Quit");
		
		Scanner in = new Scanner(System.in);	
		
		int bookIndex = in.nextInt();

		for(;;) {
			
			String bookName = null;
			
			//Alice in Wonderland uses single quotation marks, BookQuotesSQ
			if(bookIndex == 1){
			
			bookName = "alice-in-wonderland.txt";
			
			System.out.println();
			System.out.println("-------------------------------------------------");
			System.out.println(bookName + ": Top-10 most frequent letters along with the frequency:");
			System.out.println();
			
			BookChars c = new BookChars(bookName);
			c.topTenLetter();
			
			System.out.println();
			System.out.println("-------------------------------------------------");
			System.out.println(bookName + ": Top-10 most frequent words:");
			System.out.println();
			
			BookWords w = new BookWords(bookName);
			w.topTenWord();
			
			System.out.println();
			System.out.println("-------------------------------------------------");
			System.out.println(bookName + ": Top-10 most frequent words without stop words:");
			System.out.println();
			
			w.topTenWordWithoutStopList();
			
			System.out.println();
			System.out.println("-------------------------------------------------");
			System.out.println(bookName + ": (Wild Card)The book's total number of words: ");
			System.out.println();
			
			System.out.println(w.countWords());
			
			System.out.println();
			System.out.println("-------------------------------------------------");
			System.out.println(bookName + ": Top-10 longest quotes:");
			System.out.println();
			
			BookQuotesSQ q = new BookQuotesSQ(bookName);
			q.getTop10LongestQuotes();
			
			System.out.println();
			System.out.println("-------------------------------------------------");
			System.out.println(bookName + ": Top-10 shortest quotes:");
			System.out.println();
			
			q.getTop10ShortestQuotes();
			
			System.out.println();
			
			//The rest of the books use double quotation marks, BookQuotesDQ
			}else{
			if(bookIndex == 2){
				bookName = "christmas-carol.txt";
			}
			if(bookIndex == 3){
				bookName = "huck-finn.txt";
			}
			if(bookIndex == 4){
				bookName = "les-mis.txt";
			}
			if(bookIndex == 5){
				bookName = "metamorphosis.txt";
			}
			if(bookIndex == 6){
				bookName = "my-man-jeeves.txt";
			}
			if(bookIndex == 7){
				bookName = "pride-prejudice.txt";
			}
			if(bookIndex == 8){
				bookName = "tale-of-two-cities.txt";
			}
			if(bookIndex == 9){
				bookName = "tom-sawyer.txt";
			}
			if(bookIndex == 0){
				break;
			}

			System.out.println();
			System.out.println("-------------------------------------------------");
			System.out.println(bookName + ": Top-10 most frequent letters along with the frequency:");
			System.out.println();
			
			BookChars c = new BookChars(bookName);
			c.topTenLetter();
			
			System.out.println();
			System.out.println("-------------------------------------------------");
			System.out.println(bookName + ": Top-10 most frequent words:");
			System.out.println();
			
			BookWords w = new BookWords(bookName);
			w.topTenWord();
			
			System.out.println();
			System.out.println("-------------------------------------------------");
			System.out.println(bookName + ": Top-10 most frequent words without stop words:");
			System.out.println();
			
			w.topTenWordWithoutStopList();
			
			System.out.println();
			System.out.println("-------------------------------------------------");
			System.out.println(bookName + ": The book's total number of words: ");
			System.out.println();
			
			System.out.println(w.countWords());
			
			System.out.println();
			System.out.println("-------------------------------------------------");
			System.out.println(bookName + ": Top-10 longest quotes:");
			System.out.println();
			
			BookQuotesDQ q = new BookQuotesDQ(bookName);
			q.getTop10LongestQuotes();
			
			System.out.println();
			System.out.println("-------------------------------------------------");
			System.out.println(bookName + ": Top-10 shortest quotes:");
			System.out.println();
			
			q.getTop10ShortestQuotes();
			
			System.out.println();
			}
			
			System.out.println("Enter the book's index or 0 to quit");
			
			bookIndex = in.nextInt();

		}
		
	}
}


