package books;

import java.sql.*;

public class Book implements Comparable<Book>	{

	public static final String
		TITLE = "title",
		PUBLISH_MONTH = "pMonth",
		PUBLISH_DAY = "pDay",
		PUBLISH_YEAR = "pYear",
		BOOK_ID = "bookID";

	private String title;
	private int pMonth, pDay, pYear;
	private int bookID;

	/**
	 * Creates an object of type Book
	 * @param rs A ResultSet containing a Book entry in a database
	 * @throws SQLException May result from the ResultSet not containing an entry for Book
	 */
	public Book(ResultSet rs) throws SQLException	{
		title = rs.getString(TITLE);
		pDay = rs.getInt(PUBLISH_DAY);
		pMonth = rs.getInt(PUBLISH_MONTH);
		pYear = rs.getInt(PUBLISH_YEAR);
		bookID = rs.getInt(BOOK_ID);
	}

	/**
	 * Formated publish date for book
	 * @return Publish date of book in format: 1-2-1990 (M-D-Y)
	 */
	public String getPublishDate()	{
		return pMonth + "-" + pDay + "-" + pYear;
	}

	/**
	 * Formats author information to be used for an SQL entry. does not include parentheses
	 * Includes NULL for automatically incrementing primary key bookID
	 * @return String formated for SQL use
	 */
	public String toSQLString()	{
		return title + "," + pDay + "," + pMonth + "," + pYear + ", NULL";
	}

	/**
	 * Creates a string representation of Author
	 * @return Formated string
	 */
	public String toString()	{
		return "Title: " + title + " -- Published: " + getPublishDate();
	}

	/**
	 * Compares to another book's title alphabetically
	 * @return
	 */
	public int compareTo(Book arg0) {
		if (!title.equalsIgnoreCase(arg0.title)) return title.compareToIgnoreCase(arg0.title);
		return bookID - arg0.bookID;
	}

}
