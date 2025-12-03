package BookStore2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BookStore {
	
	//1)멤버변수
	private ArrayList<Book> books;
	private ArrayList<Customer> customers;
	
	//DB관련 멤버변수들
	Connection con; // 멤버변수
	Statement stmt;
	ResultSet rs;
	
	//2)생성자
	public BookStore() {
		books = new ArrayList<Book>();
		customers = new ArrayList<Customer>();
	}	
	
	//3)메소드 - getter
	public ArrayList<Book> getBooks(){
		return books;
	}
	public ArrayList<Customer> getCustomers(){
		return customers;
	}
	
	//3)메소드 - 일반기능: db연결
	public void setConnection() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userid = "madang"; // c##추가
		String pwd = "madang"; // c##추가

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로드 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			System.out.println("데이터베이스 연결 준비 .....");
			con = DriverManager.getConnection(url, userid, pwd);
			System.out.println("데이터베이스 연결 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//3)메소드 db
	public void getBooksDB() { // 생성자
		String query = "SELECT bookid, bookname, publisher, price FROM book";
		try {
			stmt = con.createStatement(); // 2
			rs = stmt.executeQuery(query); // 3
			System.out.println("BOOK ID \tBOOK NAME \t\tPUBLISHER \t\t\tPRICE");
			
			while (rs.next()) {
				
				Book book = new Book(rs.getInt("bookid"),	
									 rs.getString("bookname"), 
									 rs.getString("publisher"),
									 rs.getInt("price"));
				
				books.add(book);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void getCustomersDB() { // 생성자
		String query = "SELECT CUSTID, NAME, ADDRESS, PHONE FROM CUSTOMER";
		try {
			stmt = con.createStatement(); // 2
			rs = stmt.executeQuery(query); // 3
			System.out.println("고객ID \t 고객명 \t\t주소 \t\t\t 전화번호");
			
			while (rs.next()) {
				
				Customer cust = new Customer(rs.getInt("custid"),	
											 rs.getString("name"), 
											 rs.getString("address"),
											 rs.getString("phone"));
				
				customers.add(cust);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}















