import books.BookSearch;
import gui.*;

public class Controller {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
	
		BookSearch search = new BookSearch("Project2.db");
		String text = search.authorsToString("", "",
               "Rowling", "",
                "", "", null);
		System.out.println(text);
		
	}
}