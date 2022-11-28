package sample.example.manoj;



public class Child extends Parent {

	public static void main(String[] args) {
		
		details();
	}
	
	public static void details() {
		
		Parent obj=new Parent();
		
		obj.setName("Name : manoj");
		System.out.println(obj.getName());
		
		obj.setPlace("Place : konganapuram");
		System.out.println(obj.getPlace());
		
		obj.setAge(20);
		System.out.println(obj.getAge());
		
		obj.setCollege("College name : KSR");
		System.out.println(obj.getCollege());
		
		obj.setCollegeplace("Collegeplace : edappati");
		System.out.println(obj.getCollegeplace());
		
		obj.setDeparment("Deparment : BCA");
		System.out.println(obj.getDeparment());
		
		obj.setHodname("Hodname : prakash");
		System.out.println(obj.getHodName());
		
		obj.setGrade("Grade : A");
		System.out.println(obj.getGrade());
		
	}

	
	
	

	
	
	
	 

}
