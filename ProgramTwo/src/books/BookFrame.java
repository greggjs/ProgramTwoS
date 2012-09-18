/**
 * filename: BookFrame.java
 * description: 
 * 
 * @author Jake Gregg
 * @version 1.0
 */

package books;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.sql.*;

public class BookFrame extends JFrame {

	JPanel searchPanel; // panels for holding search and button options
	JPanel buttonPanel;
	JButton clearForm;
	JButton addBook;
	JButton addAuthor;
	JButton searchByAuthor;
	JButton searchByTitle;
	JButton removeBook;
	JButton searchByKeyword;
	JButton modifyBook;
	JButton modifyAuthor;

	JLabel bookLabel1;
	JLabel bookLabel2;
	JLabel bookLabel3;
	JLabel bookLabel4;
	JLabel bookLabel5;
	JLabel bookLabel6;
	JLabel authorLabel1;
	JLabel authorLabel2;
	JLabel authorLabel3;
	JLabel authorLabel4;
	JLabel authorLabel5;
	JLabel authorLabel6;
	JLabel authorLabel7;
	JLabel authorLabel8;
	
	JPanel bookPanel;
	JPanel authorPanel;
	
	JTextField bookTitle; // text fields for book search
	JTextField bookPubDay;
	JTextField bookPubMonth;
	JTextField bookPubYear;
	JTextField bookID;
	JTextField authorFirstName; // text fields for author search
	JTextField authorMiddleName;
	JTextField authorLastName;
	JTextField authorBDay;
	JTextField authorBMonth;
	JTextField authorBYear;
	JTextField authorID;
	
	Font bold1, bold2;

	BookSearch search; // object to search through the database

	// objects to store book and author search results
	ArrayList<Book> books = new ArrayList<Book>();
	ArrayList<Author> authors = new ArrayList<Author>();

	/**
	 * 
	 * @throws Exception
	 */
	public BookFrame(String databaseLoc) throws Exception {

		super("Book & Author Search");
		/////////////////////////////////////////////////
		// construct a new frame, set general settings //
		/////////////////////////////////////////////////
		initializeFrame();
		connectToDatabase(databaseLoc);
		createPanels();
		createLabels();
		formatAuthorAndTitles();
		createTextFields();
		addLabelsAndTextFieldsBook();
		addLabelsAndTextFieldsAuthor();
		addPanelsToSearch();
		addButtons();
		addPanels();
		connectButtons();
		
	}
	
	public void start()	{
		setVisible(true);
	}
	
	private void initializeFrame()	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setBounds(200, 200, 800, 300);
		setResizable(false);
	}
	
		///////////////////////////////////////////
		// make an object to search our database //
		///////////////////////////////////////////
	private void connectToDatabase(String databaseLoc)	{
		try {
			search = new BookSearch(databaseLoc);
		} catch (Exception err) { // catches if it doesn't exist
			JOptionPane.showMessageDialog(null, "Cannot Connect " +
					" to database specified.", "Database Does Not"
							+ " Exist", JOptionPane.INFORMATION_MESSAGE);
			System.exit(-1); // closes as well
		}
	}
		//////////////////////////////////////////////////////////////
		// searchPanel holds the book and search options, which are //
		// on the bookPanel and authorPanel respectively            //
		//////////////////////////////////////////////////////////////
	private void createPanels()	{
		searchPanel = new JPanel(new GridLayout(1, 2));
		bookPanel = new JPanel();
		bookPanel.setLayout(null);
		authorPanel = new JPanel();
		authorPanel.setLayout(null);
	}
	
		///////////////////////////////////////
		// Labels for labeling the textboxes //
		///////////////////////////////////////
	private void createLabels()	{
		bookLabel1 = new JLabel("Title");
		bookLabel2 = new JLabel("Publish Day");
		bookLabel3 = new JLabel("Publish Month");
		bookLabel4 = new JLabel("Publish Year");
		bookLabel5 = new JLabel("Book ID");
		bookLabel6 = new JLabel("Book");
		authorLabel1 = new JLabel("First Name");
		authorLabel2 = new JLabel("Middle Name");
		authorLabel3 = new JLabel("Last Name");
		authorLabel4 = new JLabel("Birth Day");
		authorLabel5 = new JLabel("Birth Month");
		authorLabel6 = new JLabel("Birth Year");
		authorLabel7 = new JLabel("Author ID");
		authorLabel8 = new JLabel("Author");
	}
	
		///////////////////////////////////////////////////
		// fonts to make the author and book titles bold //
		///////////////////////////////////////////////////
	private void formatAuthorAndTitles()	{
		bold1 = new Font(bookLabel6.getFont().getName(),
				Font.BOLD, bookLabel6.getFont().getSize());
		bold2 = new Font(authorLabel8.getFont().getName(),
				Font.BOLD, authorLabel8.getFont().getSize());
	}
	
		///////////////////////////////////////////////////////////
		// text fields for getting the information from the user //
		///////////////////////////////////////////////////////////
	private void createTextFields()	{
		bookTitle = new JTextField(); // books 
		bookPubDay = new JTextField();
		bookPubMonth = new JTextField();
		bookPubYear = new JTextField();
		bookID = new JTextField();
		authorFirstName = new JTextField(); // authors
		authorMiddleName = new JTextField();
		authorLastName = new JTextField();
		authorBDay = new JTextField();
		authorBMonth = new JTextField();
		authorBYear = new JTextField();
		authorID = new JTextField();
	}
	
		////////////////////////////////////////////////////
		// add the labels and textfields to the bookPanel //
		////////////////////////////////////////////////////
	private void addLabelsAndTextFieldsBook()	{
		bookLabel6.setFont(bold1); // book header
		bookPanel.add(bookLabel6); 
		bookLabel6.setBounds(140, 10, 200, 25);

		bookPanel.add(bookLabel1); // title
		bookLabel1.setBounds(10, 35, 200, 25); 
		bookPanel.add(bookTitle);
		bookTitle.setBounds(8, 60, 300, 25);

		bookPanel.add(bookLabel2); // pub day, month, year
		bookLabel2.setBounds(10, 85, 200, 25);
		bookPanel.add(bookLabel3);
		bookLabel3.setBounds(100, 85, 200, 25);
		bookPanel.add(bookLabel4);
		bookLabel4.setBounds(210, 85, 200, 25);
		bookPanel.add(bookPubDay);
		bookPubDay.setBounds(8, 110, 75, 25);
		bookPanel.add(bookPubMonth);
		bookPubMonth.setBounds(108, 110, 75, 25);
		bookPanel.add(bookPubYear);
		bookPubYear.setBounds(208, 110, 75, 25);

		bookPanel.add(bookLabel5); // book ID
		bookLabel5.setBounds(10, 135, 200, 25);
		bookPanel.add(bookID);
		bookID.setBounds(8, 160, 200, 25);
	}
		///////////////////////////////////////////////////////
		// add the labels annd textfields to the authorPanel //
		///////////////////////////////////////////////////////
	private void addLabelsAndTextFieldsAuthor()	{
		authorLabel8.setFont(bold2); // author header
		authorPanel.add(authorLabel8);
		authorLabel8.setBounds(140, 10, 200, 25);

		authorPanel.add(authorLabel1); // first, middle, last name
		authorLabel1.setBounds(10, 35, 200, 25);
		authorPanel.add(authorLabel2);
		authorLabel2.setBounds(155, 35, 200, 25);
		authorPanel.add(authorLabel3);
		authorLabel3.setBounds(265, 35, 200, 25);
		authorPanel.add(authorFirstName); 
		authorFirstName.setBounds(8, 60, 125, 25);
		authorPanel.add(authorMiddleName);
		authorMiddleName.setBounds(150, 60, 75, 25);
		authorPanel.add(authorLastName);
		authorLastName.setBounds(260, 60, 125, 25);

		authorPanel.add(authorLabel4); // birth day, month, year
		authorLabel4.setBounds(10, 85, 200, 25);
		authorPanel.add(authorLabel5);
		authorLabel5.setBounds(110, 85, 200, 25);
		authorPanel.add(authorLabel6);
		authorLabel6.setBounds(210, 85, 200, 25);
		authorPanel.add(authorBDay);
		authorBDay.setBounds(8, 110, 75, 25);
		authorPanel.add(authorBMonth);
		authorBMonth.setBounds(108, 110, 75, 25);
		authorPanel.add(authorBYear);
		authorBYear.setBounds(208, 110, 75, 25);

		authorPanel.add(authorLabel7); // author ID
		authorLabel7.setBounds(10, 135, 200, 25);
		authorPanel.add(authorID);
		authorID.setBounds(8, 160, 200, 25);
	}
	
		///////////////////////////////////////////
		// add the two panels to the searchPanel //
		///////////////////////////////////////////
	private void addPanelsToSearch()	{
		searchPanel.add(bookPanel);
		searchPanel.add(authorPanel);
	}
	
		////////////////////////////
		// initialize all buttons //
		////////////////////////////
	private void addButtons()	{
		buttonPanel = new JPanel(new GridLayout(3, 3));
		clearForm = new JButton("Clear Form");
		addBook = new JButton("Add Book");
		addAuthor = new JButton("Add Author");
		searchByAuthor = new JButton("Search by Author");
		searchByTitle = new JButton("Search by Title");
		removeBook = new JButton("Remove Book");
		searchByKeyword = new JButton("Search by Keyword");
		modifyBook = new JButton("Modify Book...");
		modifyAuthor = new JButton("Modify Author...");
	
		//////////////////////////
		// add buttons to panel //
		//////////////////////////
		buttonPanel.add(addBook);
		buttonPanel.add(addAuthor);
		buttonPanel.add(removeBook);
		buttonPanel.add(searchByAuthor);
		buttonPanel.add(searchByTitle);
		buttonPanel.add(searchByKeyword);
		buttonPanel.add(modifyBook);
		buttonPanel.add(modifyAuthor);
		buttonPanel.add(clearForm);
	}
	
		////////////////////////////////
		// add the panel to the frame //
		////////////////////////////////
	private void addPanels()	{
		add(searchPanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
	}
		///////////////////////////////////////////////////
		// connect all the buttons to the ActionListener //
		///////////////////////////////////////////////////
	private void connectButtons()	{
		Click button = new Click();
		clearForm.addActionListener(button);
		addBook.addActionListener(button);
		addAuthor.addActionListener(button);
		searchByAuthor.addActionListener(button);
		searchByTitle.addActionListener(button);
		removeBook.addActionListener(button);
		searchByKeyword.addActionListener(button);
		modifyBook.addActionListener(button);
		modifyAuthor.addActionListener(button);

	}

	/**
	 * 
	 * @author Jake Gregg
	 *
	 */
	public class Click implements ActionListener {

		// This is what processes all events put through the buttons
		public void actionPerformed(ActionEvent e) {
			try {

				////////////////
				// add a book //
				////////////////

				if (e.getSource() == addBook) {
					// check and see if it's valid input
					if (!checkBook()) return;
					if (!checkAuthor()) return;

					// add the book to the database
					search.addBook(bookTitle.getText(),
							Integer.parseInt(bookPubDay.getText()),
							Integer.parseInt(bookPubMonth.getText()),
							Integer.parseInt(bookPubYear.getText()));

					// show a message box saying it was successful
					JOptionPane.showMessageDialog(null,
							"Book added successfully", "Success!",
							JOptionPane.INFORMATION_MESSAGE);

					// clear the form data
					clearForm();

				}

				///////////////////
				// add an author //
				///////////////////

				else if (e.getSource() == addAuthor) {

					// check and see if it's a valid input
					if(!checkAuthor()) return;

					// add the author to the database
					search.addAuthor(authorFirstName.getText(),
							authorMiddleName.getText(),
							authorLastName.getText(),
							Integer.parseInt(authorBDay.getText()),
							Integer.parseInt(authorBMonth.getText()),
							Integer.parseInt(authorBYear.getText()));

					// show a message saying it was successful
					JOptionPane.showMessageDialog(null,
							"Author added successfully", "Success!",
							JOptionPane.INFORMATION_MESSAGE);

					// clear the form data
					clearForm();

				}

				//////////////////////////
				// search for an author //
				//////////////////////////

				else if (e.getSource() == searchByAuthor) {

					// put the search results in the proper ArrayList
					authors = search.searchAuthor(authorFirstName.getText(),
							authorMiddleName.getText(),
							authorLastName.getText(), authorBDay.getText(),
							authorBMonth.getText(), authorBYear.getText(),
							authorID.getText());

					for (Author a : authors) System.out.println(a);
					// display the results to the user
					displayResults(null, authors);

					// clear the form data
					clearForm();

				}

				/////////////////////////////////////
				// search for a book by it's title //
				/////////////////////////////////////

				else if (e.getSource() == searchByTitle) {
					
					// put the results in the proper ArrayList
					books = search.searchBook(bookTitle.getText(),
							bookPubDay.getText(), bookPubMonth.getText(),
							bookPubYear.getText(), bookID.getText());

					for (Book b : books) System.out.println(b);
					// display the results to the user
					displayResults(books, null);

					// clear the form data
					clearForm();

				}

				/////////////////////////////////////
				// remove a book from the database //
				/////////////////////////////////////

				else if (e.getSource() == removeBook) {

					// catch if the bookID is not properly formatted
					if (bookID.getText().equals("") || 
							Integer.parseInt(bookID.getText()) < 0)
						JOptionPane.showMessageDialog(null,
								"Please input a valid Book ID", "No Book ID",
								JOptionPane.INFORMATION_MESSAGE);

					// remove the book
					search.removeBook(Integer.parseInt(bookID.getText()));

					// tell the user that the remove was successful
					JOptionPane.showMessageDialog(null,
							"Book deleted successfully", "Success!",
							JOptionPane.INFORMATION_MESSAGE);

					// clear the form data
					clearForm();

				}

				/////////////////////////
				// search by a keyword //
				/////////////////////////

				else if (e.getSource() == searchByKeyword) {
					
				}

				///////////////////
				// modify a book //
				///////////////////

				else if (e.getSource() == modifyBook) {

				}

				//////////////////////
				// modify an author //
				//////////////////////

				else if (e.getSource() == modifyAuthor) {

				}

				//////////////////////////////
				// clears all the form data //
				//////////////////////////////

				else if (e.getSource() == clearForm) {
					clearForm();
				}

				// catch all execptions if the format of the input was
				// incorrect
			} catch (NumberFormatException err) {

				JOptionPane.showMessageDialog(null, "Please "
						+ "enter a valid format", "Invalid Input Format",
						JOptionPane.INFORMATION_MESSAGE);
				clearForm();

				// catch all types of SQL exceptions that occur in
				// the method
			} catch (SQLException err) {

				JOptionPane.showMessageDialog(null, "SQL Error", "SQL Error",
						JOptionPane.INFORMATION_MESSAGE);
				clearForm();

			}

		}

		/**
		 * This method displays search results to the user after 
		 * a search has been called and executed successfully.
		 * 
		 * @param bookList the search result of books
		 * @param authorList the search result of authors
		 */
		private void displayResults(ArrayList<Book> bookList,
                ArrayList<Author> authorList) {

        String result = ""; // result stored as a single string

        // this handles displaying book results
        if (authorList == null) {
                // concatenates the book results into result
                // it creates a new line after each result
                for (int i = 0; i < bookList.size(); i++)
                        result = result.concat((bookList.get(i).
                                        toString()).concat("\n"));
                // displays the result to the user
                JOptionPane.showMessageDialog(null, result,
                                "Book Search Results",
                                JOptionPane.INFORMATION_MESSAGE);
        }

        // this handles displaying author results
        else {
                // concatenates the author results into result
                // it creates a new line after each result
                for (int i = 0; i < authorList.size(); i++)
                        result = result.concat(authorList.get(i)
                                        .toString()).concat("\n");
                // displays the result to the user
                JOptionPane.showMessageDialog(null, result,
                                "Book Search Results",
                                JOptionPane.INFORMATION_MESSAGE);
		/**
		 * This method checks the author data inputed and returns
		 * error messages to the user if the data is incorrect
		 */
		private boolean checkAuthor() {

			// checks if the text fields for the name are blank
			if (authorFirstName.getText().equals("")
					|| authorMiddleName.getText().equals("")
					|| authorLastName.getText().equals(""))	{
				JOptionPane.showMessageDialog(null,
						"Input a valid author name", "No Author Name",
						JOptionPane.INFORMATION_MESSAGE);
				return false;
			}

			// checks if the text field for the author birthday are blank
			else if (authorBDay.getText().equals("")
					|| authorBMonth.getText().equals("")
					|| authorBYear.getText().equals(""))	{
				JOptionPane.showMessageDialog(null,
						"Input a birthday", "No Birthday",
						JOptionPane.INFORMATION_MESSAGE);
				return false;
			}

			// checks if the birthday is a valid birthday
			int bDay, bMonth, bYear;
			try{
				bDay = (authorBDay.getText().equals("")) ? null : Integer.parseInt(authorBDay.getText());
				bMonth = (authorBMonth.getText().equals("")) ? null : Integer.parseInt(authorBMonth.getText());
				bYear = (authorBYear.getText().equals("")) ? null : Integer.parseInt(authorBYear.getText());
			} catch(Exception e)	{
				JOptionPane.showMessageDialog(null,
						"Input a correct birthday",
						"Incorrect Birthday",
						JOptionPane.INFORMATION_MESSAGE);
				return false;
			}
			
			if (!BookSearch.checkDate(bMonth, bDay, bYear))	{
				JOptionPane.showMessageDialog(null,
						"Input a correct birthday",
						"Incorrect Birthday",
						JOptionPane.INFORMATION_MESSAGE);
				return false;
			}
			return true;
		}

		/**
		 * This method checks the book data inputed and returns
		 * error messages to the user if the data is incorrect
		 */
		private boolean checkBook() {

			// if the book title field is empty
			if (bookTitle.getText().equals(""))	{
				JOptionPane.showMessageDialog(null,
						"Input a book title", "No Book Title",
						JOptionPane.INFORMATION_MESSAGE);
				return false;
			}

			// if the book publish date is empty
			else if (bookPubDay.getText().equals("")
					|| bookPubMonth.getText().equals("")
					|| bookPubYear.getText().equals(""))	{
				JOptionPane.showMessageDialog(null,
						"Input a publish date", "No Publish Day",
						JOptionPane.INFORMATION_MESSAGE);
				return false;
			}

			//checking that dates are ints
			try {
				int day = Integer.parseInt(bookPubDay.getText());
				int month = Integer.parseInt(bookPubMonth.getText());
				int year = Integer.parseInt(bookPubYear.getText());

				//checking that dates are real
				if (BookSearch.checkDate(day, month, year))	{
					JOptionPane.showMessageDialog(null,
							"Input a correct publish date",
							"Incorrect Publish Day",
							JOptionPane.INFORMATION_MESSAGE);
					return false;
				}
			} catch(NumberFormatException err) {
				JOptionPane.showMessageDialog(null,
						"Input an integer for dates",
						"Input Integers for Dates",
						JOptionPane.INFORMATION_MESSAGE);
				return false;
			}

			return true;

		}

		/**
		 * this method clears all data in the text fields 
		 */
		private void clearForm() { 

			// sets all text to empty
			authorFirstName.setText("");
			authorMiddleName.setText("");
			authorLastName.setText("");
			authorBDay.setText("");
			authorBMonth.setText("");
			authorBYear.setText("");
			authorID.setText("");
			bookTitle.setText("");
			bookPubDay.setText("");
			bookPubMonth.setText("");
			bookPubYear.setText("");
			bookID.setText("");
		}
	}
}