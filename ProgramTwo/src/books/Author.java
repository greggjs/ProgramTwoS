package books;

import java.sql.*;

public class Author implements Comparable<Author>	{

	public static final String
		FIRST_NAME = "fName",
		MID_NAME = "mName",
		LAST_NAME = "lName",
		BIRTH_MONTH = "bMonth",
		BIRTH_DAY = "bDay",
		BIRTH_YEAR = "bYear",
		AUTHOR_ID = "authorID";

	private String fName, mName, lName;
	private int bMonth, bDay, bYear;
	private int authorID;

	public Author(String fName, String mName, String lName, int bDay, int bMonth, int bYear, int authorID)	{
		this.fName = fName;
		this.mName = mName;
		this.lName = lName;
		this.bDay = bDay;
		this.bMonth = bMonth;
		this.bYear = bYear;
		this.authorID = authorID;
	}
	
	/**
	 * Creates an object of type Author from ResultSet
	 * @param rs A ResultSet containing an Author entry in a database
	 * @throws SQLException May result from the ResultSet not containing an entry for Author
	 */
	public Author(ResultSet rs) throws SQLException	{
		fName = rs.getString(FIRST_NAME);
		mName = rs.getString(MID_NAME);
		lName = rs.getString(LAST_NAME);
		bDay = rs.getInt(BIRTH_DAY);
		bMonth = rs.getInt(BIRTH_MONTH);
		bYear = rs.getInt(BIRTH_YEAR);
		authorID = rs.getInt(AUTHOR_ID);
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
		return "Name: " + getName() + " -- DOB (M-D-Y): " + getBirthDate() + " -- ID: " + authorID;
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
