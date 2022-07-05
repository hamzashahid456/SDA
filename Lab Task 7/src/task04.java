import java.util.Scanner;
import static java.lang.System.*;


class Address{			// we will use association relationship as Student own his address
	String city;
	String state;
	String country;
	int zip;
	
	void getInfo(String city, String state, String country){
		this.city = city;
		this.country = country;
		this.state = state;
	}
	
	void display() {
		System.out.println(this.city);
		System.out.println(this.state);
		System.out.println(this.country);
		System.out.println(this.zip);
		
	}
		
}
class Student {
	String name;
	int rollNo;
	String email;
	Address obj = new Address();
	
	void getInfo(String n, int r, String id, Address ob){
		this.name = n;
		this.rollNo = r;
		this.email = id;
		this.obj = ob;
	}
	
	void display() {
		System.out.println(this.name);
		System.out.println(this.rollNo);
		System.out.println(this.email);
		obj.display();
		
	}
}




class task04 {
	public static void main(String[] args) {
		
		Address ob = new Address();
		ob.getInfo("Peshawar", "Islamic but only by name", "Pakistan");
				
		Student s1 = new Student();
		s1.getInfo("Hamza Shahid", 0117, "p20@pwr.nu.edu.pk", ob);
		
		s1.display();
		
	}
}

