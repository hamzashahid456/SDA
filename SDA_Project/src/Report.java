import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import net.proteanit.sql.DbUtils;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;

public class Report {

	JFrame frmReport;
	private static JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Report window = new Report();
					window.frmReport.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Report() {
		initialize();
		GetInfo();
		GetInfo2();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmReport = new JFrame();
		frmReport.setTitle("Report");
		frmReport.setBounds(100, 100, 699, 691);
		frmReport.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmReport.getContentPane().setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(38, 445, 611, 182);
		frmReport.getContentPane().add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		JLabel lblNewLabel_2 = new JLabel("Member Report:");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Georgia", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(38, 373, 189, 40);
		frmReport.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Customer Report:");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Georgia", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(40, 89, 181, 40);
		frmReport.getContentPane().add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 140, 611, 214);
		frmReport.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu obj = new MainMenu();
				frmReport.setVisible(false);
				obj.frmMainMenu.setVisible(true);
			}
		});
		btnNewButton.setBounds(38, 27, 113, 40);
		frmReport.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Hp\\Desktop\\Smp.jpg"));
		lblNewLabel.setBounds(0, 0, 683, 652);
		frmReport.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("New label");
		label.setBounds(349, 27, 139, 31);
		frmReport.getContentPane().add(label);
	}
	void GetInfo() {
		try {
			
			Connection con=DBconnection.MySqlConnection();
			
			String query="select customerID,vehicleNumber,vehicleType,floor,price,date from customer "
					+ "where date = current_date and status = b'1'";
			
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
	
	void GetInfo2() {
		try {
			
			Connection con=DBconnection.MySqlConnection();
			
			String query="select customerID,vehicleNumber,vehicleType,floor,price,date from customer "
					+ "where date = current_date and status = b'1'";
			
			PreparedStatement stmt = con.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			table_1.setModel(DbUtils.resultSetToTableModel(rs));	

			stmt.close();
			con.close();	
		}
		catch(Exception ex) {
		JOptionPane.showMessageDialog(null,"Error In "+ex.toString());
		}
	}
}
