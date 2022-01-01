package DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Book;


public class BookQuery {
	ConnectSQLDAO SQL_D = new ConnectSQLDAO();
	
	
	// thêm một cuốn sách
	public boolean Add_Book(Book BK){
		PreparedStatement sttm = null;
		try {
		
			String sSQL = "INSERT INTO BOOK (ID,Name_Book, Author, Type, Dayexport, Inventory, Price) VALUES (?,?,?,?,?,?,?)";
			sttm = SQL_D.getCon().prepareStatement(sSQL);
			sttm.setString(1, BK.getID());
			sttm.setString(2, BK.getName_Book());
			sttm.setString(3, BK.getAuthor());
			sttm.setString(4, BK.getType());
			sttm.setDate(5, BK.getDayexport() );
			sttm.setInt(6, BK.getInventory());
			sttm.setDouble(7, BK.getPrice());
			
			if (sttm.executeUpdate() > 0){
				System.out.println("add thanh cong");
				return true ;
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print("Error Insert" + e.toString());
		} finally {
			try {
				sttm.close();
				//SQL_D.getCon().close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
		}
		
		return false;
	}
	public boolean Update_Book (Book BK){
		PreparedStatement sttm  = null ;
		try {
			String sSQL = " UPDATE BOOK SET NAME_BOOK = ? ,  AUTHOR = ? , TYPE = ?, DAYEXPORT = ?, INVENTORY = ? , PRICE = ? WHERE ID = ?";
			sttm = SQL_D.getCon().prepareStatement(sSQL);
			sttm.setString(1, BK.getName_Book());
			sttm.setString(2, BK.getAuthor());
			sttm.setString(3, BK.getType());
			sttm.setDate(4, BK.getDayexport());
			sttm.setInt(5, BK.getInventory());
			sttm.setDouble(6, BK.getPrice());
			sttm.setString(7, BK.getID());
			
			if (sttm.executeUpdate() > 0){
				System.out.print("update thanh cong");
				return true ;
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print("Error Update" + e.toString());
		} finally {
			try {
				sttm.close();
				//SQL_D.getCon().close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return false ;
	}
	
	// Xóa  1 Cuốn Sách
	public boolean delete(String ID){
		//Câu lệnh SQL
		PreparedStatement sttm = null;
		String sSQL = "DELETE FROM BOOK WHERE ID = ? ";
		try {
					
			sttm = SQL_D.getCon().prepareStatement(sSQL);
			sttm.setString(1, ID);

			// Nếu thêm thành công
			if (sttm.executeUpdate() > 0){
				System.out.println("delete thanh cong");
				return true;
			}
			
		} catch (SQLException e) {
			// Nếu thêm thất bại
			System.out.println("Error delete BOOK "+ ID);
		} finally {
			try {
				// Dóng SQL
				//SQL_D.getCon().close();
				sttm.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return true;
	}
	
	public List<Book> getallBook (){
		List<Book> LBK = new ArrayList<Book>();
		Statement sttm = null ;
		ResultSet rs = null;
		
		try {
			String sSQL = "SELECT * FROM BOOK ";
			sttm = SQL_D.getCon().createStatement();
			rs = sttm.executeQuery(sSQL);
			while (rs.next()){
				Book BK = new Book();
				BK.setID(rs.getString(1));
				BK.setName_Book(rs.getString(2));
				BK.setAuthor(rs.getString(3));
				BK.setType(rs.getString(4));
				BK.setDayexport(rs.getDate(5));
				BK.setInventory(rs.getInt(6));
				BK.setPrice(rs.getDouble(7));

				LBK.add(BK);
			}
		} catch (Exception e) {
			System.out.println("Error update " + e.toString());
		} finally {
			try {
				rs.close();
				sttm.close();
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
		}
		return LBK;
	}
	
	// tìm tên sách
	
	public List<Book> getBooklikeName(String Name){
		List<Book> LBK = new ArrayList<Book>();
		PreparedStatement sttm = null ;
		ResultSet rs = null;
		
		try {
			String sSQL = "SELECT * FROM BOOK WHERE NAME_BOOK LIKE ? ";
			sttm = SQL_D.getCon().prepareStatement(sSQL);
			sttm.setString(1,"%" + Name + "%"); 
			rs = sttm.executeQuery();
			while (rs.next()){
				Book BK = new Book();
				BK.setID(rs.getString(1));
				BK.setName_Book(rs.getString(2));
				BK.setAuthor(rs.getString(3));
				BK.setType(rs.getString(4));
				BK.setDayexport(rs.getDate(5));
				BK.setInventory(rs.getInt(6));
				BK.setPrice(rs.getDouble(7));
				LBK.add(BK);
			}
		} catch (Exception e) {
			System.out.println("Error select " + e.toString());
		} finally {
			try {
				rs.close();
				sttm.close();
				//SQL_D.getCon().close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
		}
		return LBK;
	}
	
	public Book getBookbyID(String ID){
		PreparedStatement sttm = null ;
		ResultSet rs = null;
		
		try {
			String sSQL = "SELECT * FROM BOOK WHERE ID = ? ";
			sttm = SQL_D.getCon().prepareStatement(sSQL);
			sttm.setString(1, ID);
			rs = sttm.executeQuery();
			while (rs.next()){
				Book BK = new Book();
				BK.setID(rs.getString(1));
				BK.setName_Book(rs.getString(2));
				BK.setAuthor(rs.getString(3));
				BK.setType(rs.getString(4));
				BK.setDayexport(rs.getDate(5));
				BK.setInventory(rs.getInt(6));
				BK.setPrice(rs.getDouble(7));	
				return BK;
			}

		} catch (Exception e) {
			System.out.println("Error select " + e.toString());
		} finally {
			try {
				rs.close();
				sttm.close();
				//SQL_D.getCon().close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
		}
		return null;
	}
	public List<Book> OrderByBook(String Str, String choice){
		List<Book> LBK = new ArrayList<Book>();
		PreparedStatement sttm = null ;
		ResultSet rs = null;
		
		try {
			String sSQL = "SELECT * FROM BOOK ORDER BY " + Str + " " + choice + "";
			sttm = SQL_D.getCon().prepareStatement(sSQL);
//			sttm.setString(1, Str);
//			sttm.setString(2, choice);
			//sttm.setString(2, choice);
			
			rs = sttm.executeQuery();
			while (rs.next()){
				Book BK = new Book();
				BK.setID(rs.getString(1));
				BK.setName_Book(rs.getString(2));
				BK.setAuthor(rs.getString(3));
				BK.setType(rs.getString(4));
				BK.setDayexport(rs.getDate(5));
				BK.setInventory(rs.getInt(6));
				BK.setPrice(rs.getDouble(7));

				LBK.add(BK);
			}
		} catch (Exception e) {
			System.out.println("Error fill " + e.toString());
		} finally {
			try {
				rs.close();
				sttm.close();
				//SQL_D.getCon().close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
		}
		return LBK;
	}

	//
	public Date Convert(String time){
		return Date.valueOf(time); 
	}	
	
	public static void main(String[] args) {
		BookQuery bq = new BookQuery();
		
		Book BK = new Book("BT19","ngon cao","thu sang","tham",bq.Convert("2021-06-21"),7,600);
		//bq.Add_Book(BK);   
		//bq.Update_Book(BK);
		//bq.delete("BT04");
		
		//System.out.print(bq.OrderByBook("ID", "ASC"));
		
	}
}


