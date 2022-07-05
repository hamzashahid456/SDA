

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class RegisterOperator {

	public JFrame frmRegistration;
	private JTextField firstName;
	private JTextField lastName;
	private JTextField userName;
	private JPasswordField password;
	private JTextField salary;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterOperator window = new RegisterOperator();
					window.frmRegistration.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RegisterOperator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRegistration = new JFrame();
		frmRegistration.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Hp\\Downloads\\Sus Birds.png"));
		frmRegistration.setTitle("Operator Registration ");
		frmRegistration.setBounds(100, 100, 787, 507);
		frmRegistration.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegistration.getContentPane().setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.setBackground(Color.YELLOW);
		btnNewButton_1.setFont(new Font("Georgia", Font.PLAIN, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(!userName.getText().equals("")&&!password.getText().equals("")&&!firstName.getText().equals("")&&!lastName.getText().equals("")&&!salary.getText().equals("") ) {
						Connection con=DBconnection.MySqlConnection();
						Statement stmt = con.createStatement();
						
						String query="insert into carparking.registration values("
								+ "'"+firstName.getText()+"','"+lastName.getText()+"','"+userName.getText()+"','"+password.getText().toString()+"','"+salary.getText()+"',b'1')" ;
						
						stmt.executeUpdate(query);
						stmt.close();
						con.close();
						JOptionPane.showMessageDialog(null,"User Registered");
						
						
						
					}
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null,"Error In "+ex.toString());
				}
			}
		});
		
		JButton btnNewButton_1_1 = new JButton("Back");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu obj= new MainMenu();
				obj.frmMainMenu.setVisible(true);
				frmRegistration.setVisible(false);
			}
		});
		
		salary = new JTextField();
		salary.setBounds(315, 336, 190, 26);
		frmRegistration.getContentPane().add(salary);
		salary.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Salary:");
		lblNewLabel_4.setFont(new Font("Georgia", Font.PLAIN, 20));
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(196, 322, 98, 48);
		frmRegistration.getContentPane().add(lblNewLabel_4);
		
		password = new JPasswordField();
		password.setBounds(315, 284, 190, 26);
		frmRegistration.getContentPane().add(password);
		btnNewButton_1_1.setFont(new Font("Georgia", Font.PLAIN, 15));
		btnNewButton_1_1.setBounds(20, 21, 98, 23);
		frmRegistration.getContentPane().add(btnNewButton_1_1);
		btnNewButton_1.setBounds(325, 383, 167, 46);
		frmRegistration.getContentPane().add(btnNewButton_1);
		
		userName = new JTextField();
		userName.setColumns(10);
		userName.setBounds(312, 235, 193, 26);
		frmRegistration.getContentPane().add(userName);
		
		lastName = new JTextField();
		lastName.setColumns(10);
		lastName.setBounds(309, 198, 193, 26);
		frmRegistration.getContentPane().add(lastName);
		
		firstName = new JTextField();
		firstName.setBounds(309, 161, 193, 26);
		frmRegistration.getContentPane().add(firstName);
		firstName.setColumns(10);
		
		JLabel lblNewLabel_3_4 = new JLabel("Password: ");
		lblNewLabel_3_4.setForeground(Color.WHITE);
		lblNewLabel_3_4.setFont(new Font("Georgia", Font.PLAIN, 20));
		lblNewLabel_3_4.setBounds(196, 285, 123, 18);
		frmRegistration.getContentPane().add(lblNewLabel_3_4);
		
		JLabel lblNewLabel_3_3 = new JLabel("Username: ");
		lblNewLabel_3_3.setForeground(Color.WHITE);
		lblNewLabel_3_3.setFont(new Font("Georgia", Font.PLAIN, 20));
		lblNewLabel_3_3.setBounds(196, 241, 123, 18);
		frmRegistration.getContentPane().add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Last Name: ");
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setFont(new Font("Georgia", Font.PLAIN, 20));
		lblNewLabel_3_1.setBounds(196, 205, 107, 18);
		frmRegistration.getContentPane().add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3 = new JLabel("First Name: ");
		lblNewLabel_3.setFont(new Font("Georgia", Font.PLAIN, 20));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(196, 162, 123, 18);
		frmRegistration.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("Operator Registeration");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Leelawadee", Font.BOLD, 30));
		lblNewLabel_2.setBounds(213, 86, 374, 77);
		frmRegistration.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Car Parking Portal");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Lucida Bright", Font.BOLD, 40));
		lblNewLabel_1.setBounds(185, 11, 494, 114);
		frmRegistration.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Hp\\Downloads\\imageedit_1_3667449362.jpg"));
		lblNewLabel.setBounds(0, 0, 818, 468);
		frmRegistration.getContentPane().add(lblNewLabel);
	}
}
