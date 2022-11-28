package sample;

public class For {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] s = {1,2};
		
		for(int a=0;a<s.length;a++) {
			System.out.println("for loop data : "+s[a]);
		}
		
		
		
		for( int d :  s) {
			System.out.println("for each data : " +d);
		}
	}

}
