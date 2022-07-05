import java.util.Scanner;
import static java.lang.System.*;


class Engine{			// we will use composition relationship as Car can't exist without engine
	String type;
	int hoursePwr;
	
	void getInfo(String typ, int p){
		this.type = typ;
		this.hoursePwr = p;
	}
	
	void display() {
		System.out.println(this.type);
		System.out.println(this.hoursePwr);
		
	}
		
}
class Car {
	String name;
	String engine;
	Engine obj = new Engine();
	
	void getInfo(String n, String eng, Engine e){
		this.name = n;
		this.engine = eng;
		this.obj = e;
	}
	
	void display() {
		System.out.println(this.name);
		System.out.println(this.engine);
		obj.display();
		
	}
}




class class05 {
	public static void main(String[] args) {
		
		Engine ob = new Engine();
		ob.getInfo("car", 2000);
				
		Car s1 = new Car();
		s1.getInfo("BMW", "powered",ob);
		
		s1.display();
		
	}
}

