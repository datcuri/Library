package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import DAO.BookQuery;
import Views.DescriptionGD;
import Views.LibrarianGD;
import model.Book;


public class BookController {

	private LibrarianGD theView;
	private BookQuery theDao;

	
	public BookController(LibrarianGD View) {
		this.theView = View;
		
		theDao = new BookQuery();	
		theView.fillDataTable();
		
		theView.ADD_Book(new AddBook());
		theView.SearchBookName(new SearchBookName());
		theView.EditBook(new EditBook());
		theView.DeleteBook(new DeleteBook());
		theView.ResetForm(new ResetForm());
		theView.Description(new Description());
	}
	private class AddBook implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			Book Book = theView.getModel();
			boolean a =  theDao.Add_Book(Book);
			try {
				if (theView.ValidateForm()){
					if (a){
						theView.ShowMesage("Thanh cong");
						theView.fillDataTable();
					} 
				} else {
					theView.ShowMesage("Enter The ID or Name");
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}

		}
	}
	
	private class SearchBookName implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			theView.filldataTablelikeName(theView.getTfnameFind());
		}
	}
	
	private class EditBook implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Book Book = theView.getModel();
			boolean a =  theDao.Update_Book(Book);
			try {
			if (theView.ValidateForm()){
				if (a){
					theView.ShowMesage("Thanh cong");
					theView.fillDataTable();
				} 
			} else {
				theView.ShowMesage("Enter The ID or Name");
			}
			} catch (Exception e2) {
				// TODO: handle exception
			}

		}
	}
	
	private class DeleteBook implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			boolean a = theDao.delete(theView.getTfID());
			
			try {
				if (a){
					theView.ShowMesage("Xoa Thanh cong");
					theView.fillDataTable();
				} else {
					theView.ShowMesage("Xoa That bai");
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
		}
	}
	
	private class ResetForm implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			theView.resetForm();
		}
	}
	private class Description implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			DescriptionGD Des =  new DescriptionGD();
			DiscriptionController TheControler = new DiscriptionController(Des);
			
			Des.setVisible(true);
		}
	}
	
}
