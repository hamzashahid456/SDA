import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;

public class dispayCheckedBooks {

	private JFrame frmViewCheckedBooks;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dispayCheckedBooks window = new dispayCheckedBooks();
					window.frmViewCheckedBooks.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public dispayCheckedBooks() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmViewCheckedBooks = new JFrame();
		frmViewCheckedBooks.setTitle("View Checked Books");
		frmViewCheckedBooks.setBounds(100, 100, 1108, 585);
		frmViewCheckedBooks.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmViewCheckedBooks.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Jamrul", Font.BOLD, 20));
		lblNewLabel.setBounds(179, 127, 135, 77);
		frmViewCheckedBooks.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(358, 133, 210, 66);
		frmViewCheckedBooks.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Show Books");
		btnNewButton.setBounds(383, 260, 162, 51);
		frmViewCheckedBooks.getContentPane().add(btnNewButton);
		
		table = new JTable();
		table.setBounds(683, 93, 384, 336);
		frmViewCheckedBooks.getContentPane().add(table);
	}

}
