

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainMenu {
	JFrame frmMainMenu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu window = new MainMenu();
					window.frmMainMenu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMainMenu = new JFrame();
		frmMainMenu.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Hp\\Downloads\\Sus Birds.png"));
		frmMainMenu.setTitle("Admin Main Menu");
		frmMainMenu.setBounds(100, 100, 837, 492);
		frmMainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMainMenu.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("View Members");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminViewMembers obj=new AdminViewMembers();
				frmMainMenu.setVisible(false);
				obj.frmAdminView.setVisible(true);
				
			}
		});
		
		JButton btnViewReport = new JButton("View Report");
		btnViewReport.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnViewReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Report obj = new Report();
				frmMainMenu.setVisible(false);
				obj.frmReport.setVisible(true);
			}
		});
		
		JButton btnNewButton_1 = new JButton("Log out");
		btnNewButton_1.setBackground(Color.YELLOW);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CarParking obj=new CarParking();
				obj.frmLogInSystem.setVisible(true);
				frmMainMenu.setVisible(false);
			}
		});
		
		JButton btnDeleteCustomer = new JButton("View Customers");
		btnDeleteCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminViewCustomers men = new AdminViewCustomers();
				frmMainMenu.setVisible(false);
				men.frmAdminView.setVisible(true);
			}
		});
		btnDeleteCustomer.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnDeleteCustomer.setBackground(Color.WHITE);
		btnDeleteCustomer.setBounds(387, 254, 172, 42);
		frmMainMenu.getContentPane().add(btnDeleteCustomer);
		
		JButton btnNewButton_2 = new JButton("Register New Operator");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterOperator obj=new RegisterOperator();
				obj.frmRegistration.setVisible(true);
				frmMainMenu.setVisible(false);
			}
		});
		btnNewButton_2.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setBounds(166, 191, 180, 42);
		frmMainMenu.getContentPane().add(btnNewButton_2);
		btnNewButton_1.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnNewButton_1.setBounds(355, 401, 89, 23);
		frmMainMenu.getContentPane().add(btnNewButton_1);
		
		JButton btnDeleteUser = new JButton("Delete/Edit Operator");
		btnDeleteUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteOperator men = new DeleteOperator();
				frmMainMenu.setVisible(false);
				men.frmDeleteOperator.setVisible(true);
			}
		});
		btnDeleteUser.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnDeleteUser.setBackground(Color.WHITE);
		btnDeleteUser.setBounds(166, 254, 180, 42);
		frmMainMenu.getContentPane().add(btnDeleteUser);
		btnViewReport.setBackground(Color.WHITE);
		btnViewReport.setBounds(292, 324, 163, 42);
		frmMainMenu.getContentPane().add(btnViewReport);
		btnNewButton.setBounds(387, 191, 172, 42);
		frmMainMenu.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("WELCOME ADMIN");
		lblNewLabel_2.setFont(new Font("Leelawadee", Font.BOLD, 30));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(272, 91, 256, 81);
		frmMainMenu.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Car Parking Portal");
		lblNewLabel_1.setFont(new Font("Lucida Bright", Font.BOLD, 40));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(204, 11, 407, 106);
		frmMainMenu.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Hp\\Downloads\\imageedit_6_2710433596.jpg"));
		lblNewLabel.setBounds(0, 0, 821, 453);
		frmMainMenu.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("New label");
		label.setBounds(355, 405, 46, 14);
		frmMainMenu.getContentPane().add(label);
	}
}
