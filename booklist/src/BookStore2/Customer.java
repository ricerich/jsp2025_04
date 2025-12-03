package BookStore2;

public class Customer {
	
	//1)멤버변수
	private int custid;
	private String name;
	private String address;
	private String phone;
	
	
	//2)생성자
	public Customer() {

	}


	public Customer(int custid, String name, String address, String phone) {
		this.custid = custid;
		this.name = name;
		this.address = address;
		this.phone = phone;
	}

	//3)메소드 - Setter, Getter
	public int getCustid() {
		return custid;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getPhone() {
		return phone;
	}

	public void setCustid(int custid) {
		this.custid = custid;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	//3-)일반 메소드
	public void printCustomer() {
		System.out.print(custid +"\t");
		System.out.print(name + "\t");
		System.out.print(address +"\t");
		System.out.print(phone);
		System.out.println();
	}
}










