package logInGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import com.mysql.cj.xdevapi.Statement;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class LogIn_Page {

	JFrame frmLoginPage;
	private JTextField txtUserName;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogIn_Page window = new LogIn_Page();
					window.frmLoginPage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LogIn_Page() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLoginPage = new JFrame();
		frmLoginPage.getContentPane().setBackground(Color.WHITE);
		frmLoginPage.setTitle("Login Page");
		frmLoginPage.setBounds(100, 100, 658, 470);
		frmLoginPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLoginPage.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Password:");
		lblNewLabel.setFont(new Font("Georgia", Font.PLAIN, 16));
		lblNewLabel.setBounds(339, 191, 110, 14);
		frmLoginPage.getContentPane().add(lblNewLabel);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Georgia", Font.PLAIN, 16));
		lblUsername.setBounds(339, 137, 110, 21);
		frmLoginPage.getContentPane().add(lblUsername);
		
		txtUserName = new JTextField();
		txtUserName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtUserName.setBounds(425, 128, 176, 39);
		frmLoginPage.getContentPane().add(txtUserName);
		txtUserName.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtPassword.setBounds(425, 179, 176, 39);
		frmLoginPage.getContentPane().add(txtPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Georgia", Font.PLAIN, 20));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(txtUserName.getText().equals("")&&!txtPassword.getText().equals("")) {
						Connection con=DBConnection.MySqlConnection();
						String username="";
						String password="";
						if(!con.equals(null)) {
							java.sql.Statement stmt=con.createStatement();
							String query= "select UserName, Password from javatest.login"
                                    + " where UserName= '"       + txtUserName.getText().trim() + "'"
                                    + "AND Password = '"        + txtPassword.getText().toString() + "'";
							ResultSet rs=stmt.executeQuery(query);
							while(rs.next()) {
								 username = rs.getString(1);
								 password = rs.getString(2);
							}
							stmt.close();
							con.close();
						    if(txtUserName.getText().equals(username)&&txtPassword.getText().equals(password)){
						    	HomePage obj=new HomePage();
						    	obj.frmHomepage.setVisible(true);
						    	frmLoginPage.setVisible(false);
						    	
						    	JOptionPane.showMessageDialog(null,"Log in Succed");
						    }
							else {
								JOptionPane.showMessageDialog(null,"Invalid ");
								
							}
						}
						}
			
					else {
						JOptionPane.showMessageDialog(null,"Enter Username/Password");
					}
				}
				catch(Exception ex){
					JOptionPane.showMessageDialog(null,"Database Connection Failed:"+ex.toString());
				}
			}
		});
		btnLogin.setBounds(412, 258, 143, 39);
		frmLoginPage.getContentPane().add(btnLogin);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Hp\\Downloads\\NU-logo.png"));
		lblNewLabel_1.setBounds(89, 11, 539, 115);
		frmLoginPage.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Hp\\Downloads\\login.png"));
		lblNewLabel_2.setBounds(31, 137, 271, 242);
		frmLoginPage.getContentPane().add(lblNewLabel_2);
	}
}
