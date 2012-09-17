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
	
	BookSearch search;
	ArrayList<Book> books = new ArrayList<Book>();
	ArrayList<Author> authors = new ArrayList<Author>();
	
	public BookFrame() throws Exception {
		
		// construct a new frame, set general settings
		super("Book & Author Search");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setBounds(200, 200, 800, 300);
		setResizable(false);
		
		// make an object to search our database
		try {
			search = new BookSearch("Project2.db");
		} catch (SQLException err) {
			JOptionPane.showMessageDialog(null, "Cannot Connect " +
					" to database specified.", "Database Does Not"
					+ " Exist", JOptionPane.INFORMATION_MESSAGE);
		}
		// searchPanel holds the book and search options, which are
		// on the bookPanel and authorPanel respectively
		searchPanel = new JPanel(new GridLayout(1, 2));
//		searchPanel.setLayout(null);
		JPanel bookPanel = new JPanel();
		bookPanel.setLayout(null);
		JPanel authorPanel = new JPanel();
		authorPanel.setLayout(null);
		
		// Labels for labeling the textboxes
		JLabel bookLabel1 = new JLabel("Title");
		JLabel bookLabel2 = new JLabel("Publish Day");
		JLabel bookLabel3 = new JLabel("Publish Month");
		JLabel bookLabel4 = new JLabel("Publish Year");
		JLabel bookLabel5 = new JLabel("Book ID");
		JLabel bookLabel6 = new JLabel("Book");
		JLabel authorLabel1 = new JLabel("First Name");
		JLabel authorLabel2 = new JLabel("Middle Name");
		JLabel authorLabel3 = new JLabel("Last Name");
		JLabel authorLabel4 = new JLabel("Birth Day");
		JLabel authorLabel5 = new JLabel("Birth Month");
		JLabel authorLabel6 = new JLabel("Birth Year");
		JLabel authorLabel7 = new JLabel("Author ID");
		JLabel authorLabel8 = new JLabel("Author");
		
		Font bold1 = new Font(bookLabel6.getFont().getName(),
				Font.BOLD, bookLabel6.getFont().getSize());
		Font bold2 = new Font(authorLabel8.getFont().getName(),
				Font.BOLD, authorLabel8.getFont().getSize());
		
		// text fields for getting the information from the user
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
		
		// add the labels and textfields to the bookPanel
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
		
		
		// add the labels annd textfields to the authorPanel
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
	
	/**
	 * 
	 * @author Jake Gregg
	 *
	 */
	public class Click implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			
			// add a book
			if (e.getSource() == addBook) {
				try {

					checkBook();
					
					search.addBook(bookTitle.getText(),
							Integer.parseInt(bookPubDay.getText()),
							Integer.parseInt(bookPubMonth.getText()),
							Integer.parseInt(bookPubYear.getText()));
					
					JOptionPane.showMessageDialog(null,
							"Book added successfully", "Success!",
							JOptionPane.INFORMATION_MESSAGE);
					
					clearForm();
					
				} catch (NumberFormatException err) {
					JOptionPane.showMessageDialog(null, "Please " +
							"enter a valid format", 
							"Invalid Input Format", 
							JOptionPane.INFORMATION_MESSAGE);
					clearForm();
				}  catch (SQLException err) {
					JOptionPane.showMessageDialog(null,
							"SQL Error", 
							"SQL Error", 
							JOptionPane.INFORMATION_MESSAGE);
					clearForm();
				}
			}
			
			// add an author
			else if (e.getSource() == addAuthor) {
				try {
					checkAuthor();

					search.addAuthor(authorFirstName.getText(),
							authorMiddleName.getText(),
							authorLastName.getText(),
							Integer.parseInt(authorBDay.getText()),
							Integer.parseInt(authorBMonth.getText()),
							Integer.parseInt(authorBYear.getText()));

					JOptionPane.showMessageDialog(null,
							"Author added successfully", "Success!",
							JOptionPane.INFORMATION_MESSAGE);
					
					clearForm();
					
				} catch (NumberFormatException err) {
					JOptionPane.showMessageDialog(null, "Please " +
							"enter a valid format", 
							"Invalid Input Format", 
							JOptionPane.INFORMATION_MESSAGE);
					clearForm();
				} catch (SQLException err) {
					JOptionPane.showMessageDialog(null,
							"SQL Error", 
							"SQL Error", 
							JOptionPane.INFORMATION_MESSAGE);
					clearForm();
				}
			}
			
			// search for an author
			else if (e.getSource() == searchByAuthor) {
				try {

					checkAuthor();

					authors = search.searchAuthor(authorFirstName.getText(),
							authorMiddleName.getText(),
							authorLastName.getText(), authorBDay.getText(),
							authorBMonth.getText(), authorBYear.getText(),
							authorID.getText());

					displayResults(null, authors);

					clearForm();
					
				} catch (NumberFormatException err) {
					JOptionPane.showMessageDialog(null, "Please " +
							"enter a valid format", 
							"Invalid Input Format", 
							JOptionPane.INFORMATION_MESSAGE);
					clearForm();
				} catch (SQLException err) {
					JOptionPane.showMessageDialog(null,
							"SQL Error", 
							"SQL Error", 
							JOptionPane.INFORMATION_MESSAGE);
					clearForm();
				}
			}
			
			// search for a book by it's title
			else if (e.getSource() == searchByTitle) {
				try {
					
					checkBook();
					
					books = search.searchBook(bookTitle.getText(),
							bookPubDay.getText(),
							bookPubMonth.getText(),
							bookPubYear.getText(), 
							bookID.getText());
					
					displayResults(books, null);
					
					clearForm();
					
					
				} catch (NumberFormatException err) {
					JOptionPane.showMessageDialog(null, "Please " +
							"enter a valid format", 
							"Invalid Input Format", 
							JOptionPane.INFORMATION_MESSAGE);
					clearForm();
				} catch (SQLException err) {
					JOptionPane.showMessageDialog(null,
							"SQL Error", 
							"SQL Error", 
							JOptionPane.INFORMATION_MESSAGE);
					clearForm();
				}
				
			}
			
			// remove a book from the database
			else if (e.getSource() == removeBook) {
				
			}
			
			// search by a keyword
			else if (e.getSource() == searchByKeyword) {
				
			}
			
			// modify a book
			else if (e.getSource() == modifyBook) {
				
			}
			
			// modify an author
			else if (e.getSource() == modifyAuthor) {
				
			}
			
			// clears all the form data
			else if (e.getSource() == clearForm) {
				clearForm();
			}
		}
		
		private void displayResults(ArrayList<Book> bookList,
				ArrayList<Author> authorList) {
			String result = "";
			if (authorList == null) {
				for (int i = 0; i < bookList.size(); i++)
					result.concat(bookList.get(i).toString()).concat("\n");
				JOptionPane.showMessageDialog(null, result, 
						"Book Search Results", 
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				for (int i = 0; i < authorList.size(); i++)
					result.concat(authorList.get(i).toString()).concat("\n");
				JOptionPane.showMessageDialog(null, result, 
						"Book Search Results", 
						JOptionPane.INFORMATION_MESSAGE);
			}
			
		}
		
		private void checkAuthor() {
			if (authorFirstName.getText().equals("")
					|| authorMiddleName.getText().equals("")
					|| authorLastName.getText().equals(""))
				JOptionPane.showMessageDialog(null,
						"Input a valid author name", "No Author Name",
						JOptionPane.INFORMATION_MESSAGE);
			else if (authorBDay.getText().equals("")
					|| authorBMonth.getText().equals("")
					|| authorBYear.getText().equals(""))
				JOptionPane.showMessageDialog(null,
						"Input a birthday", "No Birthday",
						JOptionPane.INFORMATION_MESSAGE);
			else if (Integer.parseInt(authorBDay.getText()) < 0
					|| Integer.parseInt(authorBDay.getText()) > 32
					|| Integer.parseInt(authorBMonth.getText()) < 0
					|| Integer.parseInt(authorBMonth.getText()) > 12
					|| Integer.parseInt(authorBYear.getText()) < 0
					|| Integer.parseInt(authorBYear.getText()) > 2012)
				JOptionPane.showMessageDialog(null,
						"Input a correct birthday",
						"Incorrect Birthday",
						JOptionPane.INFORMATION_MESSAGE);
			else if (authorID.getText().equals(""))
				JOptionPane.showMessageDialog(null,
						"Please input a Author ID", "No Author ID",
						JOptionPane.INFORMATION_MESSAGE);
		}
		
		private void checkBook() {
			if (bookTitle.getText().equals(""))
				JOptionPane.showMessageDialog(null,
						"Input a book title", "No Book Title",
						JOptionPane.INFORMATION_MESSAGE);
			else if (bookPubDay.getText().equals("")
					|| bookPubMonth.getText().equals("")
					|| bookPubYear.getText().equals(""))
				JOptionPane.showMessageDialog(null,
						"Input a publish date", "No Publish Day",
						JOptionPane.INFORMATION_MESSAGE);
			else if (Integer.parseInt(bookPubDay.getText()) < 0
					|| Integer.parseInt(bookPubDay.getText()) > 32
					|| Integer.parseInt(bookPubMonth.getText()) < 0
					|| Integer.parseInt(bookPubMonth.getText()) > 12
					|| Integer.parseInt(bookPubYear.getText()) < 0
					|| Integer.parseInt(bookPubYear.getText()) > 2012)
				JOptionPane.showMessageDialog(null,
						"Input a correct publish date",
						"Incorrect Publish Day",
						JOptionPane.INFORMATION_MESSAGE);
			else if (bookID.getText().equals(""))
				JOptionPane.showMessageDialog(null,
						"Please input a Book ID", "No Book ID",
						JOptionPane.INFORMATION_MESSAGE);
		}
		
		private void clearForm() {
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
