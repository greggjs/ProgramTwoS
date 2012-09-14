package books;

import java.sql.*;

public class Author implements Comparable<Author>	{

	private static final String
	SQL_FIRST_NAME = "fName",
	SQL_MID_NAME = "mName",
	SQL_LAST_NAME = "lName",
	SQL_BIRTH_MONTH = "bMonth",
	SQL_BIRTH_DAY = "bDay",
	SQL_BIRTH_YEAR = "bYear",
	SQL_AUTHOR_ID = "authorID";

	private String fName, mName, lName;
	private int bMonth, bDay, bYear;
	public int authorID;

	/**
	 * Creates an object of type Author
	 * @param rs A ResultSet containing an Author entry in a database
	 * @throws SQLException May result from the ResultSet not containing an entry for Author
	 */
	public Author(ResultSet rs) throws SQLException	{
		fName = rs.getString(SQL_FIRST_NAME);
		mName = rs.getString(SQL_MID_NAME);
		lName = rs.getString(SQL_LAST_NAME);
		bDay = rs.getInt(SQL_BIRTH_DAY);
		bMonth = rs.getInt(SQL_BIRTH_MONTH);
		bYear = rs.getInt(SQL_BIRTH_YEAR);
		authorID = rs.getInt(SQL_AUTHOR_ID);
	}

	/**
	 * Formated name for the author
	 * @return Name of format: Smith, John Doe
	 */
	public String getName()	{
		return lName + ", " + fName + " " + mName;
	}

	/**
	 * Formated birthday for author
	 * @return Birthday of format: 1-2-1990 (M-D-Y)
	 */
	public String getBirthDate()	{
		return bMonth + "-" + bDay + "-" + bYear;
	}

	/**
	 * Formats author information to be used for an SQL entry. does not include parentheses
	 * Includes NULL for autoincrementing primary key authorID
	 * @return String formated for SQL use
	 */
	public String toSQLString()	{
		return fName + "," + mName + "," + lName + ","
				+ bDay + "," + bMonth + "," + bYear + ", NULL";
	}

	/**
	 * Creates a string representation of Author
	 * @return Formated string
	 */
	public String toString()	{
		return "Name: " + getName() + " -- DOB (M-D-Y): " + getBirthDate();
	}

	/**
	 * Compares to another author's name alphabetically
	 * @return
	 */
	public int compareTo(Author arg0) {
		if (!lName.equalsIgnoreCase(arg0.lName)) return lName.compareToIgnoreCase(arg0.lName);
		if (!fName.equalsIgnoreCase(arg0.fName)) return fName.compareToIgnoreCase(arg0.fName);
		if (!mName.equalsIgnoreCase(arg0.fName)) return mName.compareToIgnoreCase(arg0.mName);
		return authorID - arg0.authorID;
	}

}