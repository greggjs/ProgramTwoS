package books;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;

public class BookSearch {

	Connection conn;
	Statement stat;
	ResultSet rs;

	/**
	 * Creates a BookSearch object that is connected to an SQL database containing Book, Author, 
	 * and Authored tables
	 * @param databaseLocation Location of database to be used
	 * @throws ClassNotFoundException Cannot use JDBC
	 * @throws SQLException Error connecting to database
	 */
	public BookSearch(String databaseLocation) throws ClassNotFoundException, SQLException	{
			connect(databaseLocation);
	}
	
	/**
	 * Connects BookSearch object to an SQL database
	 * @param databaseLocation Location of database to which BookSearch object should connect
	 * @throws ClassNotFoundException Cannot use JDBC
	 * @throws SQLException Error connecting to database
	 */
	public void connect(String databaseLocation) throws ClassNotFoundException, SQLException {
		Class.forName("org.sqlite.JDBC");
		conn =
				DriverManager.getConnection("jdbc:sqlite:" + databaseLocation);
		stat = conn.createStatement();
		stat.execute("PRAGMA foreign_keys = ON;");
	}

	/**
	 * Ensures that the input date is valid
	 * @param dayOfMonth
	 * @param month
	 * @param year
	 * @return true if date is valid, false if invalid
	 */
	public boolean checkDate(int dayOfMonth, int month, int year) {
		
		// Calendar starts date and month at 0
		int calMonth = month-1;
		
		Calendar inputCal = Calendar.getInstance();
		inputCal.set(year, calMonth, 1);	
		Calendar cal = Calendar.getInstance();

		// Can't have a future date
		if ( !(year <= cal.get(Calendar.YEAR)) )
			return false;
		
		// Month must be valid
		if ( !(calMonth >= inputCal.getActualMinimum(Calendar.MONTH) 
				&& calMonth <= inputCal.getActualMaximum(Calendar.MONTH)) )
			return false;
		
		// Day must be valid
		if ( !(dayOfMonth >= inputCal.getActualMinimum(Calendar.DAY_OF_MONTH) 
				&& dayOfMonth <= inputCal.getActualMaximum(Calendar.DAY_OF_MONTH)) )
			return false;
		
		return true;

	}

	/**
	 * Adds a book to the database to which the BookSearch object is connected
	 * @param title Title of book
	 * @param pDayOfMonth Publish date
	 * @param pMonth Publish month
	 * @param pYear Publish year
	 * @throws SQLException Database has too many Books. Auto-increment has reached 
	 * the highest possible integer.
	 */
	public void addBook(String title, int pDayOfMonth, int pMonth, int pYear) throws SQLException {
		stat.execute("INSERT INTO BOOK VALUES ('" + title +	"', " + pDayOfMonth + ", " 
				+ pMonth + ", " + pYear + ", NULL);");
	}

	/**
	 * Adds an Author to the database with the following parameters as values for its attributes
	 * @param fName Author's first name
	 * @param mName Author's middle name
	 * @param lName Author's last name
	 * @param bDay Author's birth day of month
	 * @param bMonth Author's birth month
	 * @param bYear Author's birth year
	 * @throws SQLException Database has too many Authors. Autoincrement has reached the highest 
	 * possible integer.
	 */
	public void addAuthor(String fName, String mName, String lName, int bDay, int bMonth, int bYear) throws SQLException{
		stat.execute("INSERT INTO AUTHOR VALUES ('" + fName +
				"', '" + mName + "', '" + lName + "', " + bDay + ", " + bMonth + ", " +
				bYear + ", NULL);");
	}

	/*
	 * Searches for all authors with a given first, middle, and last name and returns them all as an ArrayList of Authors
	 * for easy outputting of messages
	 */
	public ArrayList<Author> searchAuthor(String[] fields) throws SQLException {
		ArrayList<Author> authors = new ArrayList<Author>();

		return authors;
	}

	//Searches for all books with a given title and returns them all as an ArrayList of Books
	//for easy outputting of messages
	public ArrayList<Book> searchBook(String[] fields) throws SQLException {
		ArrayList<Book> books = new ArrayList<Book>();

		return books;
	}

	//Returns all of the authors for a book given the book's ID
	public ArrayList<Author> getBookAuthors(int bookID){
		ArrayList<Author> authors = new ArrayList<Author>();

		return authors;
	}

	//Returns all of the books an author wrote given the author's ID
	public ArrayList<Book> getAuthorsBooks(int authorID){
		ArrayList<Book> books = new ArrayList<Book>();

		return books;
	}

	//Removes a book from the database, also removes all AUTHORED tuples containing the bookID
	public void removeBook(int bookID) {
		try {
		rs = stat.executeQuery("DELETE FROM BOOK WHERE (bookID = '" + bookID + "');");
		} catch (Exception err){

		}
	}


}