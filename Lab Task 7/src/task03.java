import java.util.Scanner;
abstract class Shape {
	 int width;
	 abstract void area();
}
//your code goes here
class Square extends Shape{
	double val;
	Square(int x){
		this.val = x;
	}
	
	void area() {
		System.out.println( (val*val));
	}
	
}

class Circle extends Shape{
	double val;
	double pi = 3.14;
	Circle(int x){
		this.val = x;
	}
	
	void area() {
		System.out.println( (pi*val*val));
	}
	
}




public class task03 {
	public static void main(String[ ] args) {
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		Square a = new Square(x);
		Circle b = new Circle(y);
		
		a.area();
		b.area();
	}
}

