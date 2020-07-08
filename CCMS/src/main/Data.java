package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JList;

public class Data extends JFrame {
	private String[] columns ={"St_ID","Student Name","College name","Phone num","Branch name"};
	private String[] rows=new String[5];
	PreparedStatement pst = null;
	ResultSet rs =null;
	 

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblName;
	private JTextField textField_2;
	private JLabel lblPhoneNumber;
	private JTextField textField_3;
	private JLabel lblCollege;
	private JLabel lblBranchName;
	private JButton btnNewButton;
	private JButton btnDelete;
	private JButton btnModify;
	private JLabel lblC;
	private JTable table;
	private JTextField textField_4;
	private JButton btnOldStudent;
	private JTextField textField_5;
	private JButton btnSearch;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Data frame = new Data();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Data() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 888, 507);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student id");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblNewLabel.setBounds(29, 113, 97, 23);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textField.setBounds(162, 113, 193, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textField_1.setColumns(10);
		textField_1.setBounds(162, 154, 193, 22);
		contentPane.add(textField_1);
		
		lblName = new JLabel("Name");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblName.setBounds(29, 154, 97, 23);
		contentPane.add(lblName);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textField_2.setColumns(10);
		textField_2.setBounds(162, 197, 193, 22);
		contentPane.add(textField_2);
		
		lblPhoneNumber = new JLabel("College Name");
		lblPhoneNumber.setForeground(Color.WHITE);
		lblPhoneNumber.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblPhoneNumber.setBounds(29, 197, 97, 23);
		contentPane.add(lblPhoneNumber);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textField_3.setColumns(10);
		textField_3.setBounds(162, 240, 193, 22);
		contentPane.add(textField_3);
		
		lblCollege = new JLabel("Phone No");
		lblCollege.setForeground(Color.WHITE);
		lblCollege.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblCollege.setBounds(29, 240, 123, 23);
		contentPane.add(lblCollege);
		
		lblBranchName = new JLabel("Branch Name");
		lblBranchName.setForeground(Color.WHITE);
		lblBranchName.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblBranchName.setBounds(29, 281, 123, 23);
		contentPane.add(lblBranchName);
		
		btnNewButton = new JButton("INSERT");
		btnNewButton.setForeground(new Color(255, 140, 0));
		btnNewButton.setFont(new Font("Arial Black", Font.BOLD, 13));
		btnNewButton.setBounds(29, 346, 97, 38);
		contentPane.add(btnNewButton);
		
		btnDelete = new JButton("DELETE");
		btnDelete.setForeground(new Color(255, 140, 0));
		btnDelete.setFont(new Font("Arial Black", Font.BOLD, 13));
		btnDelete.setBounds(144, 346, 97, 38);
		contentPane.add(btnDelete);
		
		btnModify = new JButton("MODIFY");
		btnModify.setForeground(new Color(255, 140, 0));
		btnModify.setFont(new Font("Arial Black", Font.BOLD, 13));
		btnModify.setBounds(259, 346, 97, 38);
		contentPane.add(btnModify);
		
		lblC = new JLabel("C C M S");
		lblC.setForeground(new Color(224, 255, 255));
		lblC.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 30));
		lblC.setBounds(29, 21, 134, 66);
		contentPane.add(lblC);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"st_id", "name", "college_name", "Phone_no", "branch name"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, String.class, String.class, Integer.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.setBounds(433, 119, 414, 288);
		contentPane.add(table);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textField_4.setColumns(10);
		textField_4.setBounds(162, 284, 193, 22);
		contentPane.add(textField_4);
		
		JButton btnAllStudent = new JButton("All Student");
		btnAllStudent.setForeground(new Color(255, 140, 0));
		btnAllStudent.setFont(new Font("Arial Black", Font.BOLD, 13));
		btnAllStudent.setBounds(431, 45, 123, 27);
		contentPane.add(btnAllStudent);
		
		btnOldStudent = new JButton("Old Student");
		btnOldStudent.setForeground(new Color(255, 140, 0));
		btnOldStudent.setFont(new Font("Arial Black", Font.BOLD, 13));
		btnOldStudent.setBounds(574, 45, 123, 27);
		contentPane.add(btnOldStudent);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textField_5.setColumns(10);
		textField_5.setBounds(574, 81, 123, 27);
		contentPane.add(textField_5);
		
		btnSearch = new JButton("Search");
		btnSearch.setForeground(new Color(255, 140, 0));
		btnSearch.setFont(new Font("Arial Black", Font.BOLD, 13));
		btnSearch.setBounds(433, 83, 123, 27);
		contentPane.add(btnSearch);
		
		
	
		
			
			
			
		
		
		btnNewButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				int num= table.getRowCount();
				try{
					Class.forName("com.mysql.jdbc.Driver");
					String sql = "INSERT INTO student_info"+"(st_id, name, college_name, phone_num, branch_name)"
				                  +"VALUES(?,?,?,?,?)";
					Connection con= DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/test","root","");
					 pst = con.prepareStatement(sql);
					 pst.setString(1, textField.getText());
					 pst.setString(2, textField_1.getText());
					 pst.setString(3,textField_2.getText());
					 pst.setString(4, textField_3.getText());
					 pst.setString(5, textField_4.getText());
					 pst.executeUpdate();
					 JOptionPane.showMessageDialog(null, "insert successfully");
					
				}catch(Exception exception)
				{
					JOptionPane.showMessageDialog(null, exception);
				}
				
				/*	rows[0]=fntf.getText();
					rows[1]=intf.getText();
					rows[2]=cntf.getText();
					rows[3]=phtf.getText();
					rows[4]=bntf.getText();
					model.addRow(rows);*/
					showTableData();
					String id= table.getValueAt(num, 0).toString();
					String name= table.getValueAt(num, 1).toString();
					String ftname= table.getValueAt(num, 2).toString();
					String phnum= table.getValueAt(num, 3).toString();
					String bname= table.getValueAt(num, 4).toString();
					
					textField.setText(id);
					textField_1.setText(name);
					textField_2.setText(ftname);
					textField_3.setText(phnum);
					textField_4.setText(bname);
					
				if(bname=="framgate")
				{
					try{
						Class.forName("com.mysql.jdbc.Driver");
						String sql = "INSERT INTO framgate"+"(st_id, name, college_name, phone_num, branch_name)"
					                  +"VALUES(?,?,?,?,?)";
						Connection con= DriverManager.getConnection(
								"jdbc:mysql://localhost:3306/test","root","");
						 pst = con.prepareStatement(sql);
						 pst.setString(1, textField.getText());
						 pst.setString(2, textField_1.getText());
						 pst.setString(3, textField_2.getText());
						 pst.setString(4, textField_3.getText());
						 pst.setString(5, textField_4.getText());
						 pst.executeUpdate();
						 JOptionPane.showMessageDialog(null, "insert successfully");
						 framgateData();
						
					}catch(Exception exception)
					{
						JOptionPane.showMessageDialog(null, exception);
					}
					
						
						
				}
				else if(bname=="dhanmondi")
				{
					try{
						Class.forName("com.mysql.jdbc.Driver");
						String sql = "INSERT INTO dhanmondi"+"(st_id, name, college_name, phone_num, branch_name)"
					                  +"VALUES(?,?,?,?,?)";
						Connection con= DriverManager.getConnection(
								"jdbc:mysql://localhost:3306/test","root","");
						 pst = con.prepareStatement(sql);
						 pst.setString(1,textField.getText());
						 pst.setString(2, textField_1.getText());
						 pst.setString(3,textField_2.getText());
						 pst.setString(4, textField_3.getText());
						 pst.setString(5, textField_4.getText());
						 pst.executeUpdate();
						 JOptionPane.showMessageDialog(null, "insert successfully");
						 dhanmondiData();
						
					}catch(Exception exception)
					{
						JOptionPane.showMessageDialog(null, exception);
					}
					
						
						
				}
				else if(bname=="motijeel"){
					
					try{
						Class.forName("com.mysql.jdbc.Driver");
						String sql = "INSERT INTO motijeel"+"(st_id, name, college_name, phone_num, branch_name)"
					                  +"VALUES(?,?,?,?,?)";
						Connection con= DriverManager.getConnection(
								"jdbc:mysql://localhost:3306/test","root","");
						 pst = con.prepareStatement(sql);
						 pst.setString(1, textField.getText());
						 pst.setString(2, textField_1.getText());
						 pst.setString(3, textField_2.getText());
						 pst.setString(4, textField_3.getText());
						 pst.setString(5,textField_4.getText());
						 pst.executeUpdate();
						 JOptionPane.showMessageDialog(null, "insert successfully");
						 motijeelData();
						
					}catch(Exception exception)
					{
						JOptionPane.showMessageDialog(null, exception);
					}
					
						
						
				}
				else
				{
					JOptionPane.showMessageDialog(null, "do not matching branch name");
				}
				
					
				}
			
		});
		btnOldStudent.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
					oldstudentData();
					
				}
			
		});
		btnAllStudent.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
					showTableData();
					
				}
			
		});
		btnDelete.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				int num= table.getSelectedRow();
				if(num>=0)
				{
					try{
						Class.forName("com.mysql.jdbc.Driver");
						String sql = "DELETE FROM student_info WHERE st_id=?"
					                  ;
						Connection con= DriverManager.getConnection(
								"jdbc:mysql://localhost:3306/test","root","");
						 pst = con.prepareStatement(sql);
					     pst.setString(1, textField.getText());
						 pst.executeUpdate();
						 JOptionPane.showMessageDialog(null, "delete successfully");
						
					}catch(Exception exception)
					{
						JOptionPane.showMessageDialog(null, exception);
					}
					String id= table.getValueAt(num, 0).toString();
					String name= table.getValueAt(num, 1).toString();
					String ftname= table.getValueAt(num, 2).toString();
					String phnum= table.getValueAt(num, 3).toString();
					String bname= table.getValueAt(num, 4).toString();
					
					textField.setText(id);
					textField_1.setText(name);
					textField_2.setText(ftname);
					textField_3.setText(phnum);
					textField_4.setText(bname);
					
					try{
						Class.forName("com.mysql.jdbc.Driver");
						String sql = "INSERT INTO oldstudent"+"(st_id, name, college_name, phone_num, branch_name)"
					                  +"VALUES(?,?,?,?,?)";
						Connection con= DriverManager.getConnection(
								"jdbc:mysql://localhost:3306/test","root","");
						 pst = con.prepareStatement(sql);
						 pst.setString(1, textField.getText());
						 pst.setString(2, textField_1.getText());
						 pst.setString(3, textField_2.getText());
						 pst.setString(4, textField_3.getText());
						 pst.setString(5, textField_4.getText());
						 pst.executeUpdate();
						 JOptionPane.showMessageDialog(null, "insert old student");
						
					}catch(Exception exception)
					{
						JOptionPane.showMessageDialog(null, exception);
					}
					
				}
				else
				{
					JOptionPane.showMessageDialog(null, "select row 1st");
				}
				
						
				oldstudentData();
					
				}
			
		});
		btnSearch.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					String sql = "SELECT * FROM student_info WHERE phone_num=?";
					Connection con = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/test","root","");
					pst = con.prepareStatement(sql);
					pst.setString(1,btnSearch.getText());
					rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					JOptionPane.showMessageDialog(null, "Search successfully");
					
				}catch(Exception exception){
					JOptionPane.showMessageDialog(null, exception);
					
				}
				finally {
					try{
						rs.close();
						pst.close();
					} catch(Exception exception2){
						
					}
				}
				
				showTableData();
			
				
				}
			
		});
		
		table.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e)
			{
				int num= table.getSelectedRow();
				
				String id= table.getValueAt(num, 0).toString();
				String name= table.getValueAt(num, 1).toString();
				String ftname= table.getValueAt(num, 2).toString();
				String phnum= table.getValueAt(num, 3).toString();
				String bname= table.getValueAt(num, 4).toString();
				
				textField.setText(id);
				textField_1.setText(name);
				textField_2.setText(ftname);
				textField_3.setText(phnum);
				textField_4.setText(bname);
				
			}
			
		});
		
		btnModify.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					Class.forName("com.mysql.jdbc.Driver");
					String sql = "UPDATE student_info SET  name=?, college_name=?, phone_num=?, branch_name=? WHERE st_id=?"
				                  ;
					Connection con= DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/test","root","");
					 pst = con.prepareStatement(sql);
					 pst.setString(5,textField.getText());
					 pst.setString(1, textField_1.getText());
					 pst.setString(2, textField_2.getText());
					 pst.setString(3, textField_3.getText());
					 pst.setString(4,textField_4.getText());
					 pst.executeUpdate();
					 JOptionPane.showMessageDialog(null, "Update successfully");
					
				}catch(Exception exception)
				{
					JOptionPane.showMessageDialog(null, exception);
				}
				
				int num= table.getSelectedRow();
					String id=textField.getText();
					String name=textField_1.getText();
					String cname=textField_2.getText();
					String phnum=textField_3.getText();
					String bname=textField_4.getText(); 
					
					table.setValueAt(id, num, 0);
					table.setValueAt(name, num, 1);
					table.setValueAt(cname, num, 2);
					table.setValueAt(phnum, num, 3);
					table.setValueAt(bname, num, 4);
					showTableData();
					
				}
			
			
		});
	}
	public void showTableData(){
		try{
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/test","root","");
			String sql = "SELECT * FROM student_info";
			
			pst = con.prepareStatement(sql);
			rs= pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
		}catch(Exception exception){
			JOptionPane.showMessageDialog(null, exception);
			
		}
	}
	public void oldstudentData(){
		try{
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/test","root","");
			String sql = "SELECT * FROM oldstudent";
			
			pst = con.prepareStatement(sql);
			rs= pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
		}catch(Exception exception){
			JOptionPane.showMessageDialog(null, exception);
			
		}
	}
	
	public void framgateData(){
		try{
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/test","root","");
			String sql = "SELECT * FROM framgate";
			
			pst = con.prepareStatement(sql);
			rs= pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
		}catch(Exception exception){
			JOptionPane.showMessageDialog(null, exception);
			
		}
	}
	
	public void dhanmondiData(){
		try{
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/test","root","");
			String sql = "SELECT * FROM dhanmondi";
			
			pst = con.prepareStatement(sql);
			rs= pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
		}catch(Exception exception){
			JOptionPane.showMessageDialog(null, exception);
			
		}
	}
	
	public void motijeelData(){
		try{
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/test","root","");
			String sql = "SELECT * FROM motijeel";
			
			pst = con.prepareStatement(sql);
			rs= pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
		}catch(Exception exception){
			JOptionPane.showMessageDialog(null, exception);
			
		}
	}
}
