
import java.io.File;
	import java.io.FileNotFoundException;
	import java.util.ArrayList;
	import java.util.Scanner;
	/**
	 * This class reads in a txt file that is specified.
	 * @author muyiyimiss
	 *
	 */

public class BookReader {
	

		/**
		 * These are instance variables
		 */
		private String filename;
		private ArrayList<String> lines;
		
		/**
		 * The constructor
		 * @param file the file to read
		 */
		public BookReader(String name){
			filename = name;
			lines = new ArrayList<String>();
			readFile();
		}
		
		/**
		 * This method will try to read a file
		 * It will catch FileNotFoundException
		 */
		public void readFile(){
			try{
				
				
				File input = new File(filename);
				
				
				Scanner in = new Scanner(input);
				
				
				while(in.hasNextLine()){
					
					
					String line = in.nextLine();
					
					
					lines.add(line);
				}
				
				
				in.close();
				
			
			}catch(FileNotFoundException fnfe){
				System.out.println("Sorry, file not found");
				
				System.out.println(fnfe.getMessage());
//				fnfe.printStrackTrace();		
			}
			
			catch(Exception e){
				e.printStackTrace();
			}
		}
		
		/**
		 * This is the return method of a class's instance variable called lines
		 * @return an ArrayList<String>
		 */
		public ArrayList<String> getLines(){
			return lines;
		}
		
	}


