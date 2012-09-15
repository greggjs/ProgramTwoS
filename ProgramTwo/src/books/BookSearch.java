package books;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class BookSearch {
	
	static Connection conn;
	static Statement stat;
	static ResultSet rs;

	// Used by JDBC to connect to the assigned database.
	public static void connect() throws Exception {
		Class.forName("org.sqlite.JDBC");
		conn = DriverManager.getConnection("jdbc:sqlite:Project2.db");
		stat = conn.createStatement();
	}
	
	public static ArrayList<Author> searchForAuthor(String[] arg0) throws Exception	{
		connect();
		rs = stat.executeQuery("SELECT * FROM AUTHOR");
		
		ArrayList<Author> ans = new ArrayList<Author>();
		while(rs.next())	{
			ans.add(new Author(rs));		
		}
		
		
		return ans;
	}

}
