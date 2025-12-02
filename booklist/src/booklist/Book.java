package booklist;

public class Book
{
	//1.멤버변수
	private int bookid;
	private String bookname;
	private String publisher;
	private int price;
	
	//2.생성자
	public Book() {
		this.bookid = 0;
		this.bookname = "";
		this.publisher = "";
		this.price = 0;
	}
	
	public Book(int bookid, String bookname, String publisher, int price) 
	{
		this.bookid = bookid;
		this.bookname = bookname;
		this.publisher = publisher;
		this.price = price;
	}


	//3.세터/게터 메소드
	public int getBookid() {
		return bookid;
	}

	public String getBookname() {
		return bookname;
	}

	public String getPublisher() {
		return publisher;
	}

	public int getPrice() {
		return price;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	//3.메소드
	public void printBook() {
		System.out.print(bookid +"\t");
		System.out.print(bookname + "\t");
		System.out.print(publisher +"\t");
		System.out.println(price );
	}
	
}




