import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.Color;

public class SelectMember {

	JFrame frmSelectMember;
	JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectMember window = new SelectMember();
					window.frmSelectMember.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SelectMember() {
		initialize();
		GetRole();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSelectMember = new JFrame();
		frmSelectMember.setTitle("Select Member");
		frmSelectMember.setBounds(100, 100, 652, 360);
		frmSelectMember.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSelectMember.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OperatorMainMenu obj = new OperatorMainMenu();
				obj.frmOperatorMainMenu.setVisible(true);
				frmSelectMember.setVisible(false);
			}
		});
		
		JButton btnNewButton_1 = new JButton("Update");
		btnNewButton_1.setBackground(Color.GREEN);
		btnNewButton_1.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String vehiclenum=comboBox.getSelectedItem().toString();
				
				EditMembers obj = new EditMembers(vehiclenum);
				obj.frmEditMembers.setVisible(true);
				frmSelectMember.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(289, 180, 120, 41);
		frmSelectMember.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Select CNIC:");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Georgia", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(76, 101, 218, 41);
		frmSelectMember.getContentPane().add(lblNewLabel_1);
		
		comboBox = new JComboBox();
		comboBox.setBounds(246, 99, 191, 51);
		frmSelectMember.getContentPane().add(comboBox);
		btnNewButton.setBounds(36, 22, 120, 41);
		frmSelectMember.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Hp\\Desktop\\Smp.jpg"));
		lblNewLabel.setBounds(0, 0, 636, 321);
		frmSelectMember.getContentPane().add(lblNewLabel);
	}
	
	void GetRole() {
		try {
			Connection con=DBconnection.MySqlConnection();
			String query="SELECT cnic FROM membership";
			Statement stmt=con.createStatement();
			String vehiclenum;
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next()) {
				vehiclenum=rs.getString(1);
				
				comboBox.addItem(vehiclenum);
			}
			stmt.close();
			con.close();
			
			
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null,"Error.\n"+ex.getLocalizedMessage());
		}
	}
}
