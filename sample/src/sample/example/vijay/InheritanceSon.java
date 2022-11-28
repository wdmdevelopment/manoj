package sample;

public class InheritanceSon extends InheritanceFather {

	public static void main(String[] args) {
		InheritanceSon inherit = new InheritanceSon();
	 inherit.father();
	 inherit.son();
	 inherit.grandPa();
		}
	public void son() { 
		System.out.println("Hi...i am ur son");
		
		
}

}
