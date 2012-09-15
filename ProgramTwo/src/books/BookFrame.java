package books;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
				
			}
			else if (e.getSource() == addAuthor) {
				
			}
			else if (e.getSource() == searchByAuthor) {
				
			}
			else if (e.getSource() == searchByTitle) {
				
			}
			else if (e.getSource() == removeBook) {
				
			}
			else if (e.getSource() == searchByKeyword) {
				
			}
			else if (e.getSource() == modifyBook) {
				
			}
			else if (e.getSource() == modifyAuthor) {
				
			}
			else if (e.getSource() == clearForm) {
				
			}
		}
		
	}

}
