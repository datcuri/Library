package Run;


import Controller.BookController;

import Views.LibrarianGD;

public class run {
	public static void main(String[] args) {
		LibrarianGD theViewsLi = new LibrarianGD();
		BookController theConntroller =  new BookController(theViewsLi);
		
		//theConntroller.showBookViews();
		
		theViewsLi.setVisible(true);
		
	}
}
