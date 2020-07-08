package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class Menu extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 888, 488);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 139, 139));
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("ADD STUDENT");
		btnNewButton.setForeground(new Color(0, 139, 139));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(42, 52, 136, 46);
		contentPane.add(btnNewButton);
		
		JButton btnStudentInfo = new JButton("STUDENT INFO");
		btnStudentInfo.setForeground(new Color(0, 139, 139));
		btnStudentInfo.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnStudentInfo.setBounds(207, 52, 136, 46);
		contentPane.add(btnStudentInfo);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBox.setForeground(new Color(0, 139, 139));
		comboBox.addItem("Branch");
		comboBox.addItem("Dhanmondi");
		comboBox.addItem("Farmgate ");
		comboBox.addItem("Motijheel");
		comboBox.setSelectedItem("Branch");
		comboBox.setBounds(361, 52, 136, 46);
		contentPane.add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(513, 53, 129, 46);
		contentPane.add(textField);
		textField.setColumns(10);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"stid", "nane", "college", "phone_no", "branch name"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, String.class, String.class, Integer.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.setBounds(84, 176, 579, 213);
		contentPane.add(table);
	}
}
