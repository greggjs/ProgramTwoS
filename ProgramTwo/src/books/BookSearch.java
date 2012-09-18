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
	public static boolean checkDate(int dayOfMonth, int month, int year) {
		
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
		String query = "INSERT INTO AUTHOR VALUES ('" + fName +
				"', '" + mName + "', '" + lName + "', " + bDay + ", " + bMonth + ", " +
				bYear + ", NULL)";
		stat.execute(query);
	}

	/**
	 * Search for authors that meet a set of criteria. To not specify a field, use null
	 * @param firstName
	 * @param middleName
	 * @param lastName
	 * @param birthDay
	 * @param birthMonth
	 * @param birthYear
	 * @param authorID
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Author> searchAuthor(String firstName, String middleName, String lastName, String birthDay,
			String birthMonth, String birthYear, String authorID) throws SQLException {
		ArrayList<Author> authors = new ArrayList<Author>();
		String[] fields = {firstName, middleName, lastName, birthDay, birthMonth, birthYear, authorID};
		String query = "SELECT * FROM AUTHOR";
		for (int i = 0 ; i < fields.length ; i++)	{
			if (!(fields[i] == null || fields[i].trim().equals("")))	{
				query += " WHERE";
				break;
			}
		}

		boolean andNeeded = false;
		if (!(fields[0] == null || fields[0].trim().equals("")))	{
			query += (andNeeded) ? " AND fNamee='"+fields[0]+"'" : " fName='"+fields[0]+"'";
			andNeeded = true;
		}
		if (!(fields[1] == null || fields[1].trim().equals("")))	{
			query += (andNeeded) ? " AND mName='"+fields[1]+"'" : " mName='"+fields[1]+"'";
			andNeeded = true;
		}
		if (!(fields[2] == null || fields[2].trim().equals("")))	{
			query += (andNeeded) ? " AND lName='"+fields[2]+"'" : " lName='"+fields[2]+"'";
			andNeeded = true;
		}
		if (!(fields[3] == null || fields[3].trim().equals("")))	{
			query += (andNeeded) ? " AND bDay="+fields[3] : " bDay="+fields[3];
			andNeeded = true;
		}
		if (!(fields[4] == null || fields[4].trim().equals("")))	{
			query += (andNeeded) ? " AND bMonth="+fields[4] : " bMonth="+fields[4];
			andNeeded = true;
		}
		if (!(fields[5] == null || fields[5].trim().equals("")))	{
			query += (andNeeded) ? " AND bYear="+fields[5] : " bYear="+fields[5];
			andNeeded = true;
		}
		if (!(fields[6] == null || fields[6].trim().equals("")))	{
			query += (andNeeded) ? " AND authorID="+fields[6] : " authorID="+fields[6];
			andNeeded = true;
		}
		ResultSet rs = stat.executeQuery(query);
		while (rs.next()) authors.add(new Author(rs));

		return authors;
	}

	/**	 
	 * Searches for all books that meet a set of criteria. To leave a field empty, pass null
	 * @param title
	 * @param pDay
	 * @param pMonth
	 * @param pYear
	 * @param bookID
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Book> searchBook(String title, String pDay, String pMonth, String pYear, 
			String bookID) throws SQLException {
		
		String[] fields = {title, pDay, pMonth, pYear, bookID};
		ArrayList<Book> books = new ArrayList<Book>();
		String query = "SELECT * FROM BOOK";
		for (int i = 0 ; i < fields.length ; i++)	{
			if (!(fields[i] == null || fields[i].trim().equals("")))	{
				query += " WHERE";
				break;
			}
		}
		boolean andNeeded = false;
		if (!(fields[0] == null || fields[0].trim().equals("")))	{
			query += (andNeeded) ? " AND title='"+fields[0]+"'" : " title='"+fields[0]+"'";
			andNeeded = true;
		}
		if (!(fields[1] == null || fields[1].trim().equals("")))	{
			query += (andNeeded) ? " AND pDay="+fields[1] : " pDay="+fields[1];
			andNeeded = true;
		}
		if (!(fields[2] == null || fields[2].trim().equals("")))	{
			query += (andNeeded) ? " AND pMonth="+fields[2] : " pMonth="+fields[2];
			andNeeded = true;
		}
		if (!(fields[3] == null || fields[3].trim().equals("")))	{
			query += (andNeeded) ? " AND pYear="+fields[3] : " pYear="+fields[3];
			andNeeded = true;
		}
		if (!(fields[4] == null || fields[4].trim().equals("")))	{
			query += (andNeeded) ? " AND bookID="+fields[4] : " bookID="+fields[4];
			andNeeded = true;
		}
		ResultSet rs = stat.executeQuery(query);
		while (rs.next()) books.add(new Book(rs));
		return books;
	}

	/**
	 * Returns all of the authors for a book given the book's ID
	 * @param bookID
	 * @return
	 */
	public ArrayList<Author> getBookAuthors(int bookID) throws SQLException	{
		ArrayList<Author> authors = new ArrayList<Author>();
		ResultSet rs = stat.executeQuery("SELECT * FROM AUTHORED WHERE bookID="+bookID);
		ArrayList<Integer> authorIDs = new ArrayList<Integer>();
		while (rs.next()) authorIDs.add(rs.getInt("authorID"));
		for (Integer id : authorIDs)	{
			rs = stat.executeQuery("SELECT * FROM AUTHOR WHERE authorID="+id);
			while (rs.next()) authors.add(new Author(rs));
		}
		return authors;
	}

	/**
	 * Finds all of the books an author has written given the author's ID
	 * @param authorID
	 * @return
	 * @throws SQLException 
	 */
	public ArrayList<Book> getAuthorsBooks(int authorID) throws SQLException	{
		ArrayList<Book> books = new ArrayList<Book>();
		ResultSet rs = stat.executeQuery("SELECT * FROM AUTHORED WHERE authorID="+authorID);
		ArrayList<Integer> bookIDs = new ArrayList<Integer>();
		while (rs.next()) bookIDs.add(rs.getInt("bookID"));
		for (Integer id : bookIDs)	{
			rs = stat.executeQuery("SELECT * FROM BOOK WHERE bookID=" + id);
			while (rs.next()) books.add(new Book(rs));
		}

		return books;
	}

	/**
	 * Removes a book from the database, also removes all AUTHORED tuples containing the bookID
	 * @param bookID
	 * @throws SQLException
	 */
	public void removeBook(int bookID) throws SQLException {
		stat.execute("DELETE FROM AUTHORED WHERE bookID = '" + bookID + "'");
		stat.execute("DELETE FROM BOOK WHERE bookID = '" + bookID + "'");
		
	}
	
	/**
	 * Removes authors and all of the books written by the author
	 * @param authorID
	 * @throws SQLException
	 */
	public void removeAuthor(int authorID) throws SQLException	{
		ArrayList<Integer> booksToBeDeleted = new ArrayList<Integer>();
		
		ResultSet rs = stat.executeQuery("SELECT * FROM AUTHORED WHERE authorID = '" + authorID + "'");
		while (rs.next()) booksToBeDeleted.add(rs.getInt("bookID"));
		
		for (Integer bookID : booksToBeDeleted) removeBook(bookID);
		
		stat.execute("DELETE FROM AUTHOR WHERE authorID = '" + authorID + "'");
	}
	
	public String searchByKeyWord(String keyword) throws SQLException	{
		ArrayList<Book> books = new ArrayList<Book>();
		
		ResultSet rs = stat.executeQuery("SELECT * FROM BOOK WHERE title LIKE '%" + keyword + "%'");
		
		while (rs.next()) books.add(new Book(rs));
		
		String ans = "";
		for (Book b : books) ans += b.toString() + "\n";
		
		return ans;
	}
	
	public void modifyBook(String title, int pDay, int pMonth,
            int pYear, int bookID) throws SQLException {
		stat.execute("UPDATE BOOK SET title='" + title +
                    "' AND pDay='" + pDay + "' AND pMonth='" +
                    pMonth + "' AND pYear='" + pYear +
                    "' WHERE bookID='" + bookID + "'");
	}



	public void modifyAuthor(String fName, String mName, String lName,
            int bDay, int bMonth, int bYear, int authorID) throws SQLException {
		stat.execute("UPDATE AUTHOR SET fName='" + fName +
                    "' AND mName='" + mName + "' AND lName='" +
                    lName + "' AND bDay='" + bDay +
                    "' AND bMonth='" + bMonth + "' AND bYear='" +
                    bYear + "' WHERE bookID='" + authorID + "'");
	}
	
	 public String authorsToString(ArrayList<Author> authors) throws SQLException{
         String authorString ="";
         for(Author a : authors) authorString += a.toString() + "\n";
            
             return authorString;
	 }

	 public String booksToString(ArrayList<Book> books) throws SQLException{
             String bookString ="";
             for(Book b : books) bookString += b.toString() + "\n";
            
             return bookString;
	 }
}
