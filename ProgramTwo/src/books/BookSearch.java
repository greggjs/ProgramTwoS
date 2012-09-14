package books;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BookSearch {

	static Connection conn;
	static Statement stat;
	static ResultSet rs;

	// Static entry-point
	public static void main(String args[]) {

	}

	// Used by JDBC to connect to the assigned database.
	public void connect() throws Exception {
		Class.forName("org.sqlite.JDBC");
		conn = DriverManager.getConnection("jdbc:sqlite:Assignment3.db");
		stat = conn.createStatement();
	}

}
