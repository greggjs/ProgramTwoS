package books;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BookFrame extends JFrame{

	JPanel searchPanel;
	JPanel buttonPanel;
	JButton search;
	JButton clearForm;
	JButton addBook;
	JButton addAuthor;
	JButton searchByAuthor;
	JButton searchByTitle;
	JButton removeBook;
	JButton searchByKeyword;
	JButton modifyBook;
	JButton modifyAuthor;
	JTextField bookTitle;
	JTextField bookPubDay;
	JTextField bookPubMonth;
	JTextField bookPubYear;
	JTextField bookID;
	JTextField authorFirstName;
	JTextField authorMiddleName;
	JTextField authorLastName;
	JTextField authorBDay;
	JTextField authorBMonth;
	JTextField authorBYear;
	JTextField authorID;
	static BookSearch bookSearch = new BookSearch();

	public BookFrame() {

		// construct a new frame, set general settings
		super("Book & Author Search");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setBounds(200, 200, 800, 500);

		// searchPanel holds the book and search options, which are
		// on the bookPanel and authorPanel respectively
		searchPanel = new JPanel(new GridLayout(1, 2));
		JPanel bookPanel = new JPanel();
		JPanel authorPanel = new JPanel(new GridLayout(6, 3));

		// Labels for labeling the textboxes
		JLabel bookLabel1 = new JLabel("Book Title");
		JLabel bookLabel2 = new JLabel("Book Publish Day");
		JLabel bookLabel3 = new JLabel("Book Publish Month");
		JLabel bookLabel4 = new JLabel("Book Publish Year");
		JLabel bookLabel5 = new JLabel("Book ID");
		JLabel authorLabel1 = new JLabel("Author First Name");
		JLabel authorLabel2 = new JLabel("Author Middle Name");
		JLabel authorLabel3 = new JLabel("Author Last Name");
		JLabel authorLabel4 = new JLabel("Author Birth Day");
		JLabel authorLabel5 = new JLabel("Author Birth Month");
		JLabel authorLabel6 = new JLabel("Author Birth Year");
		JLabel authorLabel7 = new JLabel("Author ID");

		// text fields for getting the information from the user
		bookTitle = new JTextField();
		bookPubDay = new JTextField();
		bookPubMonth = new JTextField();
		bookPubYear = new JTextField();
		bookID = new JTextField();
		authorFirstName = new JTextField();
		authorMiddleName = new JTextField();
		authorLastName = new JTextField();
		authorBDay = new JTextField();
		authorBMonth = new JTextField();
		authorBYear = new JTextField();
		authorID = new JTextField();

		// add the labels and textfields to the bookPanel
		bookPanel.add(bookLabel1); // title
		bookPanel.add(bookTitle);
		bookPanel.add(bookLabel2); // pub day, month, year
		bookPanel.add(bookLabel3);
		bookPanel.add(bookLabel4);
		bookPanel.add(bookPubDay);
		bookPanel.add(bookPubMonth);
		bookPanel.add(bookPubYear);
		bookPanel.add(bookLabel5); // book ID
		bookPanel.add(bookID);

		// add the labels annd textfields to the authorPanel
		authorPanel.add(authorLabel1); // first, middle, last name
		authorPanel.add(authorLabel2);
		authorPanel.add(authorLabel3);
		authorPanel.add(authorFirstName);
		authorPanel.add(authorMiddleName);
		authorPanel.add(authorLastName);
		authorPanel.add(authorLabel4); // birth day, month, year
		authorPanel.add(authorLabel5);
		authorPanel.add(authorLabel6);
		authorPanel.add(authorBDay);
		authorPanel.add(authorBMonth);
		authorPanel.add(authorBYear);
		authorPanel.add(authorLabel7); // author ID
		authorPanel.add(authorID);

		// add the two panels to the searchPanel
		searchPanel.add(bookPanel);
		searchPanel.add(authorPanel);

		// initialize all buttons
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

		// add buttons to panel
		buttonPanel.add(addBook);
		buttonPanel.add(addAuthor);
		buttonPanel.add(removeBook);
		buttonPanel.add(searchByAuthor);
		buttonPanel.add(searchByTitle);
		buttonPanel.add(searchByKeyword);
		buttonPanel.add(modifyBook);
		buttonPanel.add(modifyAuthor);
		buttonPanel.add(clearForm);

		// add the panel to the frame
		this.add(searchPanel, BorderLayout.CENTER);
		this.add(buttonPanel, BorderLayout.SOUTH);

		// connect all the buttons to the ActionListener
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

		// make the JFrame visible
		setVisible(true);
	}

	public class Click implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == addBook) {

				try {
					String title = bookTitle.getText(); //Getting string from textfield
					title = title.replace("'", ""); //removing apostrophe's cause they tear this shit up

					int pDay = Integer.parseInt(bookPubDay.getText());
					int pMonth = Integer.parseInt(bookPubMonth.getText());
					int pYear = Integer.parseInt(bookPubYear.getText());

					if (bookSearch.checkDate(pDay, pMonth, pYear)) {
						bookSearch.addBook(title, pDay, pMonth, pYear);	
					}
					else {
						System.out.println("Please enter a real past date");
					}

				} catch(NumberFormatException err) {
					System.out.println("Please  only input integers for day, month, and year."); //Wherever we should output this message, probably not console
				}
			}
			else if (e.getSource() == addAuthor) {

				try {
					String fName = authorFirstName.getText(); //Getting string from textfield
					fName = fName.replace("'", ""); //Remove all apostrophes 
					String mName = authorMiddleName.getText(); //Getting string from textfield
					mName = mName.replace("'", ""); //Remove all apostrophes
					String lName = authorLastName.getText(); //Getting string from textfield
					lName = lName.replace("'", ""); //Remove all apostrophes
					int bDay = Integer.parseInt(authorBDay.getText()); 
					int bMonth = Integer.parseInt(authorBMonth.getText()); 
					int bYear = Integer.parseInt(authorBYear.getText()); 

					if (bookSearch.checkDate(bDay, bMonth, bYear)) {
						bookSearch.addAuthor(fName, mName, lName, bDay, bMonth, bYear);
					}
					else {
						System.out.println("Please enter a real past date");
					}

				} catch (NumberFormatException err) {
					System.out.println("Please  only input integers for day, month, and year."); //Wherever we should output this message, probably not console
				}

			}
			else if (e.getSource() == searchByAuthor) {
				ArrayList<Author> authors = new ArrayList<Author>(); //Creating an ArrayList of Authors
				ArrayList<Book> authorsBooks = new ArrayList<Book>(); //Creating an ArrayList for each of the authors found of the books they wrote
				String fName = authorFirstName.getText(); //Getting string from textfield
				fName = fName.replace("'", ""); //Remove all apostrophes 
				String mName = authorMiddleName.getText(); //Getting string from textfield
				mName = mName.replace("'", ""); //Remove all apostrophes
				String lName = authorLastName.getText(); //Getting string from textfield
				lName = lName.replace("'", ""); //Remove all apostrophes
				authors = bookSearch.searchAuthor(fName, mName, lName);
				for(int i = 0; i < authors.size(); i++) { //Iterating through each author found to match name
					System.out.println(authors.get(i).toString());  //Printing the name and birthdate of each author found
					System.out.println("Wrote: ");
					authorsBooks = bookSearch.getAuthorsBooks(authors.get(i).authorID); //Getting the books from the Author, populating ArrayList
					for(int j = 0; j < authorsBooks.size(); j++) { //Iterating through ArrayList of author's books
						System.out.println("\t" + authorsBooks.get(j).toString()); //Displaying the books written by the author
					}
					authorsBooks.clear();
				}
			}
			else if (e.getSource() == searchByTitle) {
				ArrayList<Book> books = new ArrayList<Book>(); //Creating an ArrayList of Books
				ArrayList<Author> booksAuthors = new ArrayList<Author>(); //Creating an ArrayList for each of the books found of the authors that wrote them
				String title = bookTitle.getText(); //Getting string from textfield
				title = title.replace("'", ""); //Remove all apostrophes 
				books = bookSearch.searchBook(title); //Populating arraylist with books that match title given
				for(int i = 0; i < books.size(); i++) { //Iterating through each book found to match title
					System.out.println(books.get(i).toString());  //Printing the title and publish date of each author found
					System.out.println("Written by: ");
					booksAuthors = bookSearch.getBookAuthors(books.get(i).bookID); //Getting the authors from the book, populating ArrayList
					for(int j = 0; j < booksAuthors.size(); j++) { //Iterating through ArrayList of book's authors
						System.out.println("\t" + booksAuthors.get(j).toString()); //Displaying the authors that wrote the book
					}
					booksAuthors.clear();
				}
			}
			else if (e.getSource() == removeBook) {
				int bookInt = Integer.parseInt(bookID.getText());
				bookSearch.removeBook(bookInt);
			}
			else if (e.getSource() == searchByKeyword) {

			}
			else if (e.getSource() == modifyBook) {

			}
			else if (e.getSource() == modifyAuthor) {

			}
			else if (e.getSource() == clearForm) {
				bookTitle.setText("");
				bookPubDay.setText("");
				bookPubMonth.setText("");
				bookPubYear.setText("");
				bookID.setText("");
				authorFirstName.setText("");
				authorMiddleName.setText("");
				authorLastName.setText("");
				authorBDay.setText("");
				authorBMonth.setText("");
				authorBYear.setText("");
				authorID.setText("");
			}
		}

	}

	public static void main(String[] args) {
		try {
			bookSearch.connect();
			BookFrame myFrame = new BookFrame();
		} catch (Exception e) {
			System.out.println("Could not locate Project2.db database file.");
		}
	}
}