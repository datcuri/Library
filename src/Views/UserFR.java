package Views;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class UserFR extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTable table;
	private JTextField tfName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserFR frame = new UserFR();
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
	public UserFR() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 890, 501);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(188, 161, 676, 229);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"ID", "Name Book ", "Author ", "Type", "Day Export", "Inventory", "Price"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		table.getColumnModel().getColumn(2).setPreferredWidth(130);
		table.getColumnModel().getColumn(3).setPreferredWidth(130);
		table.getColumnModel().getColumn(4).setPreferredWidth(120);
		table.getColumnModel().getColumn(5).setPreferredWidth(70);
		table.getColumnModel().getColumn(6).setPreferredWidth(120);
		
		JLabel lbName_Book = new JLabel("Tìm Kiếm :");
		lbName_Book.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lbName_Book.setBounds(188, 67, 106, 35);
		contentPane.add(lbName_Book);
		
		tfName = new JTextField();
		tfName.setBounds(294, 69, 454, 33);
		contentPane.add(tfName);
		tfName.setColumns(10);
		
		JButton btnFind = new JButton("FIND");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnFind.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnFind.setBounds(758, 70, 106, 35);
		contentPane.add(btnFind);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"ID", "NAME_BOOK", "AUTHOR", "TYPE", "DAYEXPORT", "INVENTORY", "PRICE"}));
		comboBox.setBounds(444, 115, 176, 35);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"ASC", "DESC"}));
		comboBox_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		comboBox_1.setBounds(630, 115, 118, 33);
		contentPane.add(comboBox_1);
		
		JButton btnSort = new JButton("SORT");
		btnSort.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSort.setBounds(758, 115, 106, 33);
		contentPane.add(btnSort);
		
		JButton btnThngTinChi = new JButton("Thông tin chi tiết");
		btnThngTinChi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThngTinChi.setBounds(699, 404, 165, 35);
		contentPane.add(btnThngTinChi);
	}
}
