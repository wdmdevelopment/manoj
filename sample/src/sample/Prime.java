package sample;

import java.util.Scanner;

public class Prime {

	public static void main(String[] args) {
		Scanner n = new Scanner(System.in);   
	      System.out.println("Enter the  number");
	      
			int num = n.nextInt();
		
		boolean prime = true;
		for(int i=2; i<num; i++)
		{
			if(num%i==0)
			{
				prime = false;
				break;
			}
		}
		
		if(prime)
		{
			System.out.println(num + " is prime");
		}
		else {
			System.out.println(num + " is not a prime");
		}
		

	}

}
