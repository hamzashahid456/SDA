

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class ViewMember {
	JFrame frmViewMemebrship;
	private static JTable table;
	private JScrollPane scrollPane;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewMember window = new ViewMember();
					window.frmViewMemebrship.setVisible(true);
					
					
					
					
					
					
					
					
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ViewMember() {
		initialize();
		GetInfo();;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmViewMemebrship = new JFrame();
		frmViewMemebrship.getContentPane().setBackground(new Color(240, 240, 240));
		frmViewMemebrship.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Hp\\Downloads\\Sus Birds.png"));
		frmViewMemebrship.setTitle("View Memebrship");
		frmViewMemebrship.setBounds(100, 100, 757, 484);
		frmViewMemebrship.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmViewMemebrship.getContentPane().setLayout(null);
		
		btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OperatorMainMenu men = new OperatorMainMenu();
				frmViewMemebrship.setVisible(false);
				men.frmOperatorMainMenu.setVisible(true);
				
			}
		});
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(74, 104, 555, 238);
		frmViewMemebrship.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		btnNewButton_1.setBounds(23, 21, 118, 39);
		frmViewMemebrship.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Hp\\Desktop\\Smp.jpg"));
		lblNewLabel.setBackground(new Color(240, 240, 240));
		lblNewLabel.setBounds(0, 0, 748, 453);
		frmViewMemebrship.getContentPane().add(lblNewLabel);
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







