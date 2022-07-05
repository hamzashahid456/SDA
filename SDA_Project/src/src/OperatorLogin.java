

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.SwingConstants;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;


public class OperatorLogin {

	public JFrame frmAdminLoginSystem;
	private JTextField textField;
	private JTextField txtUserName;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OperatorLogin window = new OperatorLogin();
					window.frmAdminLoginSystem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public OperatorLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAdminLoginSystem = new JFrame();
		frmAdminLoginSystem.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Hp\\Downloads\\Sus Birds.png"));
		frmAdminLoginSystem.getContentPane().setBackground(Color.WHITE);
		frmAdminLoginSystem.setTitle("Operator Login System");
		frmAdminLoginSystem.setBounds(100, 100, 808, 498);
		frmAdminLoginSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAdminLoginSystem.getContentPane().setLayout(null);
		
		JButton btnLogin = new JButton("Sign in");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (!txtUserName.getText().equals("") && !txtPassword.getText().equals("")) {
						Connection con = DBconnection.MySqlConnection();
						String username = "";
						String password = "";
						if (!con.equals(null)) {
							java.sql.Statement stmt = con.createStatement();
							String query = "select UserName, Password from carparking.login" + " where UserName = '"
									+ txtUserName.getText().trim() + "'" + "AND Password = '"
									+ txtPassword.getText().toString() + "'";

							ResultSet rs = stmt.executeQuery(query);
							while (rs.next()) {
								username = rs.getString(1);
								password = rs.getString(2);
							}
							stmt.close();
							con.close();

							if (txtUserName.getText().equals(username) && txtPassword.getText().equals(password)) {
								OperatorMainMenu obj = new OperatorMainMenu();
								obj.frmOperatorMainMenu.setVisible(true);
								frmAdminLoginSystem.setVisible(false);

								JOptionPane.showMessageDialog(null, "Log in Succed");
							} else {
								JOptionPane.showMessageDialog(null, "Invalid ");

							}
						}
					}

					else {
						JOptionPane.showMessageDialog(null, "Enter Username/Password");
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Database Connection Failed:" + ex.toString());
				}
			}
		});
		
		JButton btnNewButton = new JButton("Switch to Admin Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CarParking obj=new CarParking();
				frmAdminLoginSystem.setVisible(false);
				obj.frmLogInSystem.setVisible(true);
			}
			
		});
		btnNewButton.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnNewButton.setBounds(603, 71, 179, 23);
		frmAdminLoginSystem.getContentPane().add(btnNewButton);
		
		txtPassword = new JPasswordField();
		txtPassword.setHorizontalAlignment(SwingConstants.CENTER);
		txtPassword.setBounds(273, 279, 234, 31);
		frmAdminLoginSystem.getContentPane().add(txtPassword);
		
		JLabel lblNewLabel_3_1 = new JLabel("Password :");
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setFont(new Font("Georgia", Font.PLAIN, 20));
		lblNewLabel_3_1.setBounds(335, 251, 122, 14);
		frmAdminLoginSystem.getContentPane().add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3 = new JLabel("Username :");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Georgia", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(335, 184, 122, 14);
		frmAdminLoginSystem.getContentPane().add(lblNewLabel_3);
		btnLogin.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnLogin.setBounds(314, 338, 157, 42);
		frmAdminLoginSystem.getContentPane().add(btnLogin);
		
		txtUserName = new JTextField();
		txtUserName.setToolTipText("");
		txtUserName.setFont(new Font("Georgia", Font.PLAIN, 11));
		txtUserName.setHorizontalAlignment(SwingConstants.CENTER);
		txtUserName.setBounds(273, 209, 234, 31);
		frmAdminLoginSystem.getContentPane().add(txtUserName);
		txtUserName.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Car Parking Portal");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Lucida Bright", Font.BOLD, 40));
		lblNewLabel.setBounds(203, 38, 492, 90);
		frmAdminLoginSystem.getContentPane().add(lblNewLabel);
		
		
		JLabel lblNewLabel_1 = new JLabel("OPERATOR LOGIN");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Leelawadee", Font.BOLD, 30));
		lblNewLabel_1.setBounds(238, 104, 287, 98);
		frmAdminLoginSystem.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setToolTipText("Username\r\n");
		lblNewLabel_2.setBackground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Hp\\Downloads\\imageedit_1_3667449362.jpg"));
		lblNewLabel_2.setBounds(0, 0, 792, 459);
		frmAdminLoginSystem.getContentPane().add(lblNewLabel_2);
	
	}
}
