package sample;
import java.util.Scanner;
public class Fibonacci {
	public static void main(String[] args) {
		
		
		Scanner inputNumber = new Scanner(System.in);
		 System.out.print("Enter a number: ");
		 int num = inputNumber.nextInt();
		int a=0, b=1, c;
		for(int i = 0; i < num; i++) {
			c = a + b;   
			a = b;       
			b = c;
		}
		System.out.println("The fibonacci number is : " + a);
			}

}
