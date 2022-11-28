// same method name, same class and different parameters.

package sample;

public class Overloading {
	public static void main(String[] args) {
		
		System.out.println(Overloading.add(10,20));
		System.out.println(Overloading.add(10.5,20.5, 30.5));
	}
	public static int add(int a, int b) {
		return a+b;
		
	}
	
	public static double add(double a, double b, double c) {
		return a+b+c;
		
	}
	
}
