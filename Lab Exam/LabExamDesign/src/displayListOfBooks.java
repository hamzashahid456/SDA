import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class displayListOfBooks {

	private JFrame frmDisplayBooks;
	private JTextField textField_1;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					displayListOfBooks window = new displayListOfBooks();
					window.frmDisplayBooks.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public displayListOfBooks() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDisplayBooks = new JFrame();
		frmDisplayBooks.setTitle("display books");
		frmDisplayBooks.setBounds(100, 100, 1110, 570);
		frmDisplayBooks.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDisplayBooks.getContentPane().setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(239, 170, 324, 59);
		frmDisplayBooks.getContentPane().add(textField_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(239, 68, 324, 59);
		frmDisplayBooks.getContentPane().add(textField);
		
		JButton btnNewButton = new JButton("Author");
		btnNewButton.setBounds(616, 75, 163, 44);
		frmDisplayBooks.getContentPane().add(btnNewButton);
		
		JButton btnTopic = new JButton("Topic");
		btnTopic.setBounds(616, 177, 163, 44);
		frmDisplayBooks.getContentPane().add(btnTopic);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Books Names", "New column"
			}
		));
		table.setBounds(280, 276, 324, 214);
		frmDisplayBooks.getContentPane().add(table);
	}
}
