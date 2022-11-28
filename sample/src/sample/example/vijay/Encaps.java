package sample;
import java.util.Scanner;
public class Encaps {
	public static void main(String[] args) {
		
	
			Encapsulation getData=new Encapsulation();
			getData.setName("Vijay");
			getData.setAge(20);
			getData.setCity("Salem");
			System.out.println(getData.getName());
			System.out.println(getData.getAge());
			System.out.println(getData.getCity());
		}


}