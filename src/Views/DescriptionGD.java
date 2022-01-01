package Views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Book;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class DescriptionGD extends JFrame {

	private JPanel contentPane;
	private JLabel lb1;
	private JLabel lbAuthor;
	private JLabel lbType;
	private JLabel lbDayExport;
	private JLabel lbInventory ;
	private JLabel lbPrice;
	private JButton btnConfirm;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DescriptionGD frame = new DescriptionGD();
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
	public DescriptionGD() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 401, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lb1 = new JLabel("Information Book");
		lb1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lb1.setBounds(117, 11, 155, 33);
		contentPane.add(lb1);
		
		lbAuthor = new JLabel("");
		lbAuthor.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lbAuthor.setBounds(10, 55, 365, 23);
		contentPane.add(lbAuthor);
		
		lbType = new JLabel("");
		lbType.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lbType.setBounds(10, 89, 365, 23);
		contentPane.add(lbType);
		
		lbDayExport = new JLabel("");
		lbDayExport.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lbDayExport.setBounds(10, 123, 365, 23);
		contentPane.add(lbDayExport);
		
		lbInventory = new JLabel("");
		lbInventory.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lbInventory.setBounds(10, 157, 365, 23);
		contentPane.add(lbInventory);
		
		lbPrice = new JLabel("");
		lbPrice.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lbPrice.setBounds(10, 191, 365, 23);
		contentPane.add(lbPrice);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(10, 253, 365, 248);
		contentPane.add(textPane);
		
		JLabel lblDescription = new JLabel("Description :");
		lblDescription.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblDescription.setBounds(10, 219, 96, 23);
		contentPane.add(lblDescription);
		
		btnConfirm = new JButton("Confirm");
		btnConfirm.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnConfirm.setBounds(261, 512, 114, 39);
		contentPane.add(btnConfirm);
	}
	
	public void setModelDescription(Book BK){
		   lbAuthor.setText("Author          : " + BK.getAuthor());
		     lbType.setText("Type            : " + BK.getType());
		lbDayExport.setText("Day Export      : " + BK.getDayexport());
		lbInventory.setText("Inventory       : " + BK.getInventory());
		    lbPrice.setText("Price           : " + BK.getPrice());	
	}
	
	public void Confirm (ActionListener listener){
		btnConfirm.addActionListener(listener);
		
	}
	
}
