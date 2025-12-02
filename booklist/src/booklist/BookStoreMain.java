package booklist;

import java.util.ArrayList;

public class BookStoreMain 
{
	public static void main(String args[]) 
	{
		BookStore bs1 = new BookStore();
		
		bs1.setConnection();
		bs1.getBookList();
		
//		System.out.println("2.배열 출력 - 2번(다른클래스에서 출력)");
//		bs1.printBookList();
		
		//4.객체배열
		System.out.println("4.객체배열 출력 - 2번(다른클래스에서 출력)");
		
		for(int i=0; i< bs1.getBookArr().length; i++) {
			bs1.getBookArr()[i].printBook();
		}
		
		//5.객체배열 템플릿(ArrayList)
		System.out.println("5.객체배열(템플릿 출력 - 2번(다른클래스에서 출력)");
		for(int i=0; i<bs1.getBookArrayList().size(); i++)
		{
			bs1.getBookArr()[i].printBook();
		}		
		
		
		bs1.setConnection();
		bs1.getCustomerList();
	}
}
