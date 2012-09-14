package books;

import java.sql.*;

public class Author implements Comparable<Author>	{

	private static final String 
		SQL_FIRST_NAME = "FName", 
		SQL_MID_NAME = "MName",
		SQL_LAST_NAME = "LName", 
		SQL_BIRTH_MONTH = "Bmonth", 
		SQL_BIRTH_DAY = "Bday",
		SQL_BIRTH_YEAR = "Byear", 
		SQL_AUTHOR_ID = "AuthorID";
	
	private String firstName, midName, lastName;
	private int bMonth, bDay, bYear;
	private int authorID;
	
	/**
	 * Creates an object of type Author
	 * @param rs A ResultSet containing an Author entry in a database
	 * @throws SQLException May result from the ResultSet not containing an entry for Author
	 */
	public Author(ResultSet rs) throws SQLException	{
		firstName = rs.getString(SQL_FIRST_NAME);
		midName = rs.getString(SQL_MID_NAME);
		lastName = rs.getString(SQL_LAST_NAME);
		bMonth = rs.getInt(SQL_BIRTH_MONTH);
		bDay = rs.getInt(SQL_BIRTH_DAY);
		bYear = rs.getInt(SQL_BIRTH_YEAR);
		authorID = rs.getInt(SQL_AUTHOR_ID);
	}
	
	/**
	 * Formated name for the author
	 * @return Name of format: Smith, John Doe
	 */
	public String getName()	{
		return lastName + ", " + firstName + " " + midName;
	}
	
	/**
	 * Formated birthday for author
	 * @return Birthday of format: 1-2-1990
	 */
	public String getBirthDate()	{
		return bMonth + "-" + bDay + "-" + bYear;
	}
	
	/**
	 * Formats author information to be used for an SQL entry. does not include parentheses
	 * @return String formated for SQL use
	 */
	public String toSQLString()	{
		return firstName + "," + midName + "," + lastName + "," 
				+ bDay + "," + bMonth + "," + bYear;
	}

	/**
	 * Creates a string representation of Author
	 * @return Formated string
	 */
	public String toString()	{
		return "Name: " + getName() + " -- DOB: " + getBirthDate();
	}

	/**
	 * Compares to another author's name alphabetically
	 * @return 
	 */
	public int compareTo(Author arg0) {
		if (!lastName.equalsIgnoreCase(arg0.lastName)) return lastName.compareToIgnoreCase(arg0.lastName);
		if (!firstName.equalsIgnoreCase(arg0.firstName)) return firstName.compareToIgnoreCase(arg0.firstName);
		if (!midName.equalsIgnoreCase(arg0.firstName)) return midName.compareToIgnoreCase(arg0.midName);
		return authorID - arg0.authorID;
	}

}
