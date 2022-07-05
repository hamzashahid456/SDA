

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


public class CarParking {

	public JFrame frmLogInSystem;
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
					CarParking window = new CarParking();
					window.frmLogInSystem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CarParking() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogInSystem = new JFrame();
		frmLogInSystem.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Hp\\Downloads\\Sus Birds.png"));
		frmLogInSystem.getContentPane().setBackground(Color.WHITE);
		frmLogInSystem.setTitle("Admin Login System");
		frmLogInSystem.setBounds(100, 100, 808, 498);
		frmLogInSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogInSystem.getContentPane().setLayout(null);
		
		JButton btnLogin = new JButton("Sign in");
		btnLogin.setEnabled(false);
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
								MainMenu obj = new MainMenu();
								obj.frmMainMenu.setVisible(true);
								frmLogInSystem.setVisible(false);

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
		
		JButton btnNewButton = new JButton("Switch to Operator Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OperatorLogin obj=new OperatorLogin();
				frmLogInSystem.setVisible(false);
				obj.frmAdminLoginSystem.setVisible(true);
			}
			
		});
		btnNewButton.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnNewButton.setBounds(590, 68, 192, 23);
		frmLogInSystem.getContentPane().add(btnNewButton);
		
		txtPassword = new JPasswordField();
		txtPassword.setHorizontalAlignment(SwingConstants.CENTER);
		txtPassword.setBounds(273, 279, 234, 31);
		frmLogInSystem.getContentPane().add(txtPassword);
		
		JLabel lblNewLabel_3_1 = new JLabel("Password :");
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setFont(new Font("Georgia", Font.PLAIN, 20));
		lblNewLabel_3_1.setBounds(335, 251, 122, 14);
		frmLogInSystem.getContentPane().add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3 = new JLabel("Username :");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Georgia", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(335, 184, 122, 14);
		frmLogInSystem.getContentPane().add(lblNewLabel_3);
		btnLogin.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnLogin.setBounds(314, 338, 157, 42);
		frmLogInSystem.getContentPane().add(btnLogin);
		
		txtUserName = new JTextField();
		txtUserName.setToolTipText("");
		txtUserName.setFont(new Font("Georgia", Font.PLAIN, 11));
		txtUserName.setHorizontalAlignment(SwingConstants.CENTER);
		txtUserName.setBounds(273, 209, 234, 31);
		frmLogInSystem.getContentPane().add(txtUserName);
		txtUserName.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Car Parking Portal");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Lucida Bright", Font.BOLD, 40));
		lblNewLabel.setBounds(203, 38, 492, 90);
		frmLogInSystem.getContentPane().add(lblNewLabel);
		
		
		JLabel lblNewLabel_1 = new JLabel("ADMIN LOGIN");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Leelawadee", Font.BOLD, 30));
		lblNewLabel_1.setBounds(285, 112, 234, 98);
		frmLogInSystem.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setToolTipText("Username\r\n");
		lblNewLabel_2.setBackground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Hp\\Downloads\\imageedit_1_3667449362.jpg"));
		lblNewLabel_2.setBounds(0, 0, 792, 459);
		frmLogInSystem.getContentPane().add(lblNewLabel_2);
	
	}
}
