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

public class OperatorViewCustomers {

	JFrame frmOperatorView;
	private static JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OperatorViewCustomers window = new OperatorViewCustomers();
					window.frmOperatorView.setVisible(true);
					
					
					
					
					
					
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public OperatorViewCustomers() {
		initialize();
		GetInfo();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmOperatorView = new JFrame();
		frmOperatorView.setTitle("Operator View");
		frmOperatorView.setBounds(100, 100, 676, 430);
		frmOperatorView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmOperatorView.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(99, 99, 452, 247);
		frmOperatorView.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OperatorMainMenu obj = new OperatorMainMenu();
				frmOperatorView.setVisible(false);
				obj.frmOperatorMainMenu.setVisible(true);
			}
		});
		btnNewButton.setBounds(26, 29, 119, 37);
		frmOperatorView.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Hp\\Desktop\\Smp.jpg"));
		lblNewLabel.setBounds(0, 0, 660, 391);
		frmOperatorView.getContentPane().add(lblNewLabel);
	}
	
	void GetInfo() {
		try {
			
			Connection con=DBconnection.MySqlConnection();
			
			
			String query="select customerID,vehicleNumber,vehicleType,price,date from customer where status=b'1'";
			
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
