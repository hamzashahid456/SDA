import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class borrow_return_book {

	private JFrame frmBorrowReturnBook;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					borrow_return_book window = new borrow_return_book();
					window.frmBorrowReturnBook.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public borrow_return_book() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBorrowReturnBook = new JFrame();
		frmBorrowReturnBook.setTitle("Borrow Return Book");
		frmBorrowReturnBook.setBounds(100, 100, 1149, 609);
		frmBorrowReturnBook.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBorrowReturnBook.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Book Name:");
		lblNewLabel.setFont(new Font("Jamrul", Font.BOLD, 20));
		lblNewLabel.setBounds(261, 127, 199, 56);
		frmBorrowReturnBook.getContentPane().add(lblNewLabel);
		
		JLabel lblBookAuthor = new JLabel("Book Author:");
		lblBookAuthor.setFont(new Font("Jamrul", Font.BOLD, 20));
		lblBookAuthor.setBounds(261, 252, 199, 56);
		frmBorrowReturnBook.getContentPane().add(lblBookAuthor);
		
		textField = new JTextField();
		textField.setBounds(471, 127, 209, 56);
		frmBorrowReturnBook.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(471, 252, 209, 56);
		frmBorrowReturnBook.getContentPane().add(textField_1);
		
		JButton btnNewButton = new JButton("Borrow");
		btnNewButton.setBounds(409, 365, 152, 56);
		frmBorrowReturnBook.getContentPane().add(btnNewButton);
		
		JButton btnReturn = new JButton("Return");
		btnReturn.setBounds(621, 365, 152, 56);
		frmBorrowReturnBook.getContentPane().add(btnReturn);
	}

}
