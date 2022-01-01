package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import DAO.BookQuery;
import Views.DescriptionGD;
import Views.LibrarianGD;
import model.Book;

public class DiscriptionController {
	private DescriptionGD TheViewDes;
	private BookQuery TheDao;
	private LibrarianGD TheViewLi;
	
	public DiscriptionController(DescriptionGD theViewDes) {
		TheViewDes = theViewDes;
		
		TheDao = new BookQuery();
		TheViewLi = new LibrarianGD();
		Book BK = TheDao.getBookbyID(TheViewLi.getTfID());
		
		theViewDes.setModelDescription(BK);
		theViewDes.Confirm(new Confirm());
	}
	
	private class Confirm implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			TheViewDes.setModelDescription(TheDao.getBookbyID(TheViewLi.getTfID()));
		}
	}

}
