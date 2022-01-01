package Views;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalDate;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;

import DAO.BookQuery;
import model.Book;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LibrarianGD extends JFrame {
	BookQuery BQ = new BookQuery();
	
	private JPanel contentPane;
	private JTextField tfID;
	private JTextField tfName;
	private JTextField tfAuthor;
	private JComboBox cbType;
	private JDateChooser DateCExport;
	private JSpinner spInventory;
	private JTextField tfPrice;
	
	private JLabel lbType;
	private JLabel lbInventory;
	private JLabel lbPrice;
	
	
	private JTable TableMaBook;
	private JButton btnAdd;
	private JLabel Test;
	private JButton btnRestForm;
	private JButton btnEdit;
	private JButton btnDelete;
	private JButton btnDescription;
	private JTextField tfnameFind;
	private JButton btnFind;
	private JLabel lbNameBook;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LibrarianGD frame = new LibrarianGD();
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
	public LibrarianGD() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 476);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfID = new JTextField();
		tfID.setBounds(258, 66, 200, 20);
		contentPane.add(tfID);
		tfID.setColumns(10);
		
		JLabel lbID = new JLabel("ID :");
		lbID.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lbID.setBounds(166, 68, 82, 14);
		contentPane.add(lbID);
		
		JLabel lbName = new JLabel("Name Book :");
		lbName.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lbName.setBounds(166, 99, 82, 14);
		contentPane.add(lbName);
		
		tfName = new JTextField();
		tfName.setColumns(10);
		tfName.setBounds(258, 99, 200, 20);
		contentPane.add(tfName);
		
		JLabel lbAuthor = new JLabel("Author :");
		lbAuthor.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lbAuthor.setBounds(166, 130, 82, 14);
		contentPane.add(lbAuthor);
		
		tfAuthor = new JTextField();
		tfAuthor.setColumns(10);
		tfAuthor.setBounds(258, 130, 200, 20);
		contentPane.add(tfAuthor);
		
		JLabel CalDateExport = new JLabel("Date Export :");
		CalDateExport.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		CalDateExport.setBounds(486, 68, 90, 14);
		contentPane.add(CalDateExport);
		
		lbType = new JLabel("Type :");
		lbType.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lbType.setBounds(166, 163, 82, 14);
		contentPane.add(lbType);
		
		lbInventory = new JLabel("Inventory :");
		lbInventory.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lbInventory.setBounds(486, 99, 90, 14);
		contentPane.add(lbInventory);
		
		lbPrice = new JLabel("Price :");
		lbPrice.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lbPrice.setBounds(486, 130, 90, 14);
		contentPane.add(lbPrice);
		
		cbType = new JComboBox();
		cbType.setModel(new DefaultComboBoxModel(new String[] {"--- Select Type Book ---", "TextBook", "Novel", "Comic", "Poem", "Dictionary", "Cookery book", "Textbook"}));
		cbType.setBounds(258, 161, 200, 20);
		contentPane.add(cbType);
		
		DateCExport = new JDateChooser();
		DateCExport.setDateFormatString("yyyy-MM-dd");
		DateCExport.setBounds(573, 66, 201, 20);
		contentPane.add(DateCExport);
		
		spInventory = new JSpinner();
		spInventory.setBounds(573, 97, 201, 20);
		contentPane.add(spInventory);
		
		tfPrice = new JTextField();
		tfPrice.setBounds(573, 128, 201, 20);
		contentPane.add(tfPrice);
		tfPrice.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(166, 188, 608, 179);
		contentPane.add(scrollPane);
		
		TableMaBook = new JTable();
		TableMaBook.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int id = TableMaBook.rowAtPoint(e.getPoint());
				Book BK = BQ.getBookbyID(TableMaBook.getValueAt(id, 0).toString());
				setModel(BK);
			}
		});
		scrollPane.setViewportView(TableMaBook);
		TableMaBook.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"ID", "Name", "Author", "Type", "Day Export", "Inventory", "Price"
			}
		));
		TableMaBook.getColumnModel().getColumn(0).setPreferredWidth(51);
		TableMaBook.getColumnModel().getColumn(1).setPreferredWidth(173);
		TableMaBook.getColumnModel().getColumn(2).setPreferredWidth(100);
		TableMaBook.getColumnModel().getColumn(3).setPreferredWidth(73);
		TableMaBook.getColumnModel().getColumn(4).setPreferredWidth(96);
		TableMaBook.getColumnModel().getColumn(5).setPreferredWidth(69);
		TableMaBook.getColumnModel().getColumn(6).setPreferredWidth(99);
		TableMaBook.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		btnAdd = new JButton("Add Book");
		btnAdd.setBounds(296, 378, 111, 23);
		contentPane.add(btnAdd);
		
		Test = new JLabel("");
		Test.setBounds(44, 214, 46, 14);
		contentPane.add(Test);
		
		btnRestForm = new JButton("New Form");
		btnRestForm.setBounds(166, 378, 111, 23);
		contentPane.add(btnRestForm);
		
		btnEdit = new JButton("Edit Book");
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnEdit.setBounds(418, 378, 111, 23);
		contentPane.add(btnEdit);
		
		btnDelete = new JButton("Delete Book");
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnDelete.setBounds(541, 378, 111, 23);
		contentPane.add(btnDelete);
		
		btnDescription = new JButton("Description");
		btnDescription.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnDescription.setBounds(663, 378, 111, 23);
		contentPane.add(btnDescription);
		
		tfnameFind = new JTextField();
		tfnameFind.setColumns(10);
		tfnameFind.setBounds(258, 412, 394, 20);
		contentPane.add(tfnameFind);
		
		btnFind = new JButton("Find");
		btnFind.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnFind.setBounds(663, 411, 111, 23);
		contentPane.add(btnFind);
		
		lbNameBook = new JLabel("Name Book :");
		lbNameBook.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lbNameBook.setBounds(166, 415, 82, 14);
		contentPane.add(lbNameBook);
		
		lblNewLabel = new JLabel("Book Management");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setBounds(317, 13, 242, 42);
		contentPane.add(lblNewLabel);
	}
	//
	/*public String MousegetValueID(MouseEvent e){
		int id = TableMaBook.rowAtPoint(e.getPoint());
		return TableMaBook.getValueAt(id, 0).toString();
	}*/
	//
	public String getTfnameFind() {
		return tfnameFind.getText();
	}
	
	public String getTfID() {
		return tfID.getText();
	}
	//
	public Date Convert(LocalDate time){
		return Date.valueOf(time); 
	}
	

	public Date getUdate(java.util.Date  time){
		java.util.Date keyword = DateCExport.getDate();
	    java.sql.Date sqldate = new java.sql.Date(keyword.getTime());
	    return sqldate;
	}
		
	public void filldataTablelikeName(String Name) {
		DefaultTableModel Model = (DefaultTableModel) TableMaBook.getModel();
		Model.setRowCount(0);
		for (Book BK : BQ.getBooklikeName(Name)){
			Object DataRow[] = new Object[7];
			DataRow[0] = BK.getID();
			DataRow[1] = BK.getName_Book();
			DataRow[2] = BK.getAuthor	();
			DataRow[3] = BK.getType();
			DataRow[4] = BK.getDayexport();
			DataRow[5] = BK.getInventory();
			DataRow[6] = BK.getPrice();
			Model.addRow(DataRow);
		}
	}
	
	public void fillDataTable() {
		DefaultTableModel Model = (DefaultTableModel) TableMaBook.getModel();
		Model.setRowCount(0);
		for (Book BK : BQ.getallBook()){
			Object DataRow[] = new Object[7];
			DataRow[0] = BK.getID();
			DataRow[1] = BK.getName_Book();
			DataRow[2] = BK.getAuthor	();
			DataRow[3] = BK.getType();
			DataRow[4] = BK.getDayexport();
			DataRow[5] = BK.getInventory();
			DataRow[6] = BK.getPrice();
			Model.addRow(DataRow);
		}
	}
	
	public void setModel(Book BK){
		tfID.setText(BK.getID());
		tfName.setText(BK.getName_Book());
		tfAuthor.setText(BK.getAuthor());
		cbType.setSelectedItem(BK.getType());
		DateCExport.setDate(BK.getDayexport());
		spInventory.setValue(BK.getInventory());
		tfPrice.setText(String.valueOf(BK.getPrice()));
	}
	
	public Book getModel(){
		Book BK = new Book();
		BK.setID(tfID.getText());
		BK.setName_Book(tfName.getText());
		BK.setAuthor(tfAuthor.getText());
		//cbType.getS
		BK.setType(cbType.getSelectedItem().toString());
		BK.setDayexport(getUdate(DateCExport.getDate()));
		BK.setInventory(Integer.parseInt(spInventory.getValue().toString()));
		BK.setPrice(Double.parseDouble(tfPrice.getText()));
		if (cbType.getSelectedItem().toString().equals("--- Select Type Book ---")){
			ShowMesage("Error !. Select Type Name");
			return null;
		}
		return BK;
	}
	
	public void resetForm(){
		tfID.setText("");
		tfName.setText("");
		tfAuthor.setText("");
		cbType.setSelectedIndex(0);
		DateCExport.setDate(Convert(java.time.LocalDate.now()));
		spInventory.setToolTipText("");
		tfPrice.setText("");
		
	}
	public Boolean ValidateForm(){
		if (tfID.getText().isEmpty() || tfName.getText().isEmpty())
			return false;
		return true;
	}
	
	//
	
	public void ShowMesage(String message){
		JOptionPane.showConfirmDialog(this, message);
	}
	
	
	//
	public void ADD_Book (ActionListener Listener){
		btnAdd.addActionListener(Listener);
	}
	public void SearchBookName(ActionListener Listener){
		btnFind.addActionListener(Listener);
	}
	public void EditBook(ActionListener Listener){
		btnEdit.addActionListener(Listener);
	}
	public void DeleteBook(ActionListener Listenner){
		btnDelete.addActionListener(Listenner);
	}
	public void ResetForm(ActionListener Listener){
		btnRestForm.addActionListener(Listener);
	}
	public void Description(ActionListener Listener){
		btnDescription.addActionListener(Listener);	
	}
}
