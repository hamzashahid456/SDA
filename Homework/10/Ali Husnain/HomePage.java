package logInGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;

public class HomePage {

	 JFrame frmHomepage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage window = new HomePage();
					window.frmHomepage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HomePage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHomepage = new JFrame();
		frmHomepage.setTitle("HomePage");
		frmHomepage.getContentPane().setBackground(Color.WHITE);
		frmHomepage.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Hp\\Downloads\\FAST_Peshawar_campus.jpg"));
		lblNewLabel.setBounds(0, 172, 647, 250);
		frmHomepage.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Hp\\Downloads\\NU-logo.png"));
		lblNewLabel_1.setBounds(30, 11, 572, 116);
		frmHomepage.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("WELCOME TO FAST");
		lblNewLabel_2.setFont(new Font("Georgia", Font.PLAIN, 30));
		lblNewLabel_2.setBounds(155, 126, 338, 31);
		frmHomepage.getContentPane().add(lblNewLabel_2);
		frmHomepage.setBounds(100, 100, 663, 461);
		frmHomepage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
