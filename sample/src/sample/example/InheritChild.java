package sample.example;

import java.util.ArrayList;

import sample.EncapsulationExp;
import sample.InheritParent;

public class InheritChild extends InheritParent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
ArrayList<EncapsulationExp> list =new ArrayList<EncapsulationExp>() ;
EncapsulationExp jj=new EncapsulationExp();
jj.setAge(67);
jj.setName("mano");
jj.setPlace("salem");
EncapsulationExp jj1=new EncapsulationExp();
jj1.setAge(67);
jj1.setName("manofff");
jj1.setPlace("salem");
list.add(jj);
list.add(jj1);

System.out.println(list.toString());




	}

	
public void c1() {
		
	}
}
