import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class storeBooks {

	private JFrame frmStoreBooks;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblNewLabel;
	private JLabel lblBookAuthor;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					storeBooks window = new storeBooks();
					window.frmStoreBooks.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public storeBooks() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmStoreBooks = new JFrame();
		frmStoreBooks.setTitle("Store Books");
		frmStoreBooks.setBounds(100, 100, 1063, 578);
		frmStoreBooks.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStoreBooks.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(471, 109, 222, 54);
		frmStoreBooks.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(471, 216, 222, 54);
		frmStoreBooks.getContentPane().add(textField_1);
		
		lblNewLabel = new JLabel("Book Name:");
		lblNewLabel.setFont(new Font("Jamrul", Font.BOLD, 20));
		lblNewLabel.setBounds(281, 105, 172, 60);
		frmStoreBooks.getContentPane().add(lblNewLabel);
		
		lblBookAuthor = new JLabel("Book Author:");
		lblBookAuthor.setFont(new Font("Jamrul", Font.BOLD, 20));
		lblBookAuthor.setBounds(282, 210, 184, 65);
		frmStoreBooks.getContentPane().add(lblBookAuthor);
		
		btnNewButton = new JButton("Store");
		btnNewButton.setBounds(510, 308, 140, 46);
		frmStoreBooks.getContentPane().add(btnNewButton);
	}

}
