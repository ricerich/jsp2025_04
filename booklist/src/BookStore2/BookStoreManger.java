package BookStore2;

import java.util.ArrayList;

public class BookStoreManger {
	
	void run() 
	{
		BookStore bs1 = new BookStore();
		
		bs1.setConnection();
		bs1.getBooksDB();
		
		//5.객체배열 템플릿(ArrayList)
		ArrayList<Book> books = bs1.getBooks();
		
		for(int i=0; i<books.size(); i++)
		{
			Book book = books.get(i);
			book.printBook();
		}		
		
		bs1.setConnection();
		bs1.getCustomersDB();
		
		//5.객체배열 템플릿(ArrayList)
		ArrayList<Customer> customers = bs1.getCustomers();
		
		for(int i=0; i<customers.size(); i++)
		{
			Customer customer = customers.get(i);
			customer.printCustomer();
		}		
		

	}
}





