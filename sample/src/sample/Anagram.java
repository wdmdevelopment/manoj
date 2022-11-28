package sample;

public class Anagram {

	public static void main(String[] args) {
		
		String first ="mary";
		String second ="army";
		
		if( first.length() == second.length() ) {
		for (int i=0; i<first.length(); i++) {
			
			char possition = first.charAt(i);
			if(second.contains(String.valueOf(possition))) {
				
				System.out.println("it is anagram word");
			}
			
		}
		
		
		
		}else {
			
			System.out.print("it is not anagram word");
		}
	}

}
