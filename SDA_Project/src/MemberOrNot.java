import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class MemberOrNot {

	JFrame frmMemberOrNot;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberOrNot window = new MemberOrNot();
					window.frmMemberOrNot.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MemberOrNot() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMemberOrNot = new JFrame();
		frmMemberOrNot.setTitle("Member Or Not");
		frmMemberOrNot.setBounds(100, 100, 606, 371);
		frmMemberOrNot.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMemberOrNot.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Member");
		btnNewButton.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemberEntry obj = new MemberEntry();
				obj.frame.setVisible(true);
				frmMemberOrNot.setVisible(false);
			}
		});
		btnNewButton.setBounds(75, 132, 152, 61);
		frmMemberOrNot.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Not Member");
		btnNewButton_1.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EnterCustomer obj = new EnterCustomer();
				obj.frmEnterCustomer.setVisible(true);
				frmMemberOrNot.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(298, 132, 152, 61);
		frmMemberOrNot.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OperatorMainMenu obj = new OperatorMainMenu();
				obj.frmOperatorMainMenu.setVisible(true);
				frmMemberOrNot.setVisible(false);
			}
		});
		btnNewButton_2.setBounds(32, 22, 104, 35);
		frmMemberOrNot.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Hp\\Downloads\\imageedit_1_3667449362.jpg"));
		lblNewLabel.setBounds(0, 0, 590, 332);
		frmMemberOrNot.getContentPane().add(lblNewLabel);
	}
}
