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

import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class Home extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblPassword;
	private JTextField textField_1;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to CCMS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 26));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(65, 31, 347, 67);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(200, 132, 225, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("User Name");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 16));
		lblNewLabel_1.setBounds(55, 125, 113, 35);
		contentPane.add(lblNewLabel_1);
		
		lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Arial Black", Font.BOLD, 16));
		lblPassword.setBounds(55, 191, 113, 35);
		contentPane.add(lblPassword);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(200, 198, 225, 26);
		contentPane.add(textField_1);
		
		btnNewButton = new JButton("Login");
		btnNewButton.setForeground(new Color(0, 128, 128));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Arial Black", Font.BOLD, 17));
		btnNewButton.setBounds(176, 264, 99, 35);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				String username= textField.getText();
				String password= textField_1.getText();
				if(username.equals("a") && password.equals("a"))
				{
					
					Data frame = new Data();
					frame.setVisible(true);
	
				
				
					
				}
				else{
					JOptionPane.showMessageDialog(null, "your username or password wrong");
				 }
			}
			
		});
	}
}
