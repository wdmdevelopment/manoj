package sample.example.manoj;

public class Show extends Child {

	public static void main(String[] args) {
		details();
	}
	
	public static void details() {
		
		Child obj1 = new Child();
		
		obj1.setName("Name : vijay");
		System.out.println(obj1.getName());
		
		obj1.setPlace("Place : konganapuram");
		System.out.println(obj1.getPlace());
		
		obj1.setAge(30);
		System.out.println(obj1.getAge());
		
		obj1.setCollege("College name : PSG");
		System.out.println(obj1.getCollege());
		
		obj1.setCollegeplace("Collegeplace : kovai");
		System.out.println(obj1.getCollegeplace());
		
		obj1.setDeparment("Deparment : BCA");
		System.out.println(obj1.getDeparment());
		
		obj1.setHodname("Hodname : Manoj");
		System.out.println(obj1.getHodName());
		
		obj1.setGrade("Grade : S");
		System.out.println(obj1.getGrade());
		
		
	}
	
	
}
