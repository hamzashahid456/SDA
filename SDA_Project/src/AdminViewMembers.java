

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class AdminViewMembers {

	JFrame frmAdminView;
	private static JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminViewMembers window = new AdminViewMembers();
					window.frmAdminView.setVisible(true);
					
					
					
					
					
					
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminViewMembers() {
		initialize();
		GetInfo();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAdminView = new JFrame();
		frmAdminView.setTitle("Admin View");
		frmAdminView.setBounds(100, 100, 676, 440);
		frmAdminView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAdminView.getContentPane().setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu men = new MainMenu();
				frmAdminView.setVisible(false);
				men.frmMainMenu.setVisible(true);
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(39, 118, 565, 261);
		frmAdminView.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		btnNewButton_1.setBounds(39, 23, 100, 30);
		frmAdminView.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Hp\\Desktop\\Smp.jpg"));
		lblNewLabel.setBounds(0, 0, 660, 401);
		frmAdminView.getContentPane().add(lblNewLabel);
	}
	
	void GetInfo() {
		try {
			
			Connection con=DBconnection.MySqlConnection();
		
			String query="select * from membership";
			
			PreparedStatement stmt = con.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));		
			
			stmt.close();
			con.close();
			
			
			
		}
		catch(Exception ex) {
		JOptionPane.showMessageDialog(null,"Error In "+ex.toString());
		}
	}
}
