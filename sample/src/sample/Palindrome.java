package sample;

import java.util.Scanner;

public class Palindrome {
	
	public static void main (String[] args)
	{
		  
		  
		Scanner inuput = new Scanner(System.in);   
	      System.out.println("Enter a string to check if it is a palindrome");
	      
			String palindrome = inuput.nextLine();
		  if(palindrome.equalsIgnoreCase(palindrome(palindrome))) 
		  {
			  System.out.print(palindrome + " is the Palindrome");
		  }
		  else
		  {
			  
			  System.out.print(palindrome + " is not a Palindrome");
		  }
		  
		  
	}
	public static String palindrome(String n)
 	{
		String str="";
			for(int i= n.length()-1; i>=0; i--)
			{
				str = str + n.charAt(i);
			}
			System.out.println(str +"hhhh");
			return str;
	}

}
