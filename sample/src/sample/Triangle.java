package sample;

import java.util.Iterator;

public class Triangle {
	
	public static final String HTTP_STATUS = "200";
	public String HTTP_ = "200";
	public static void main(String[] args) {
		Triangle t = new Triangle();
		Triangle t1 = new Triangle();
		Triangle t2 = new Triangle();
//		t.HTTP_="vijay";
//		t1.HTTP_="manoj";
//		System.out.println(t2.HTTP_);
//		System.out.println(t1.HTTP_);
		int rows = 5;
		for (int i = 0; true; i++) {
			Triangle t4 = new Triangle();
			Triangle t5 = t4;
		}
		
	}
	
	
	public static void fibo(int rows) {

		for (int i = 1;	i <= rows; i++) 
		{
			
			for (int j = rows; j >= i; j--)
			{
				System.out.print(" ");
			}
			
			for (int j = 1; j <= i; j++) 
			{
				System.out.print("* ");
			}
			
			System.out.println();
		}
	}

}