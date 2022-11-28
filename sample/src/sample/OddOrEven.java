package sample;

public abstract class OddOrEven implements InterfaceExp {

	String name;
	int age;

	public static void main(String[] args) {

		String s1 = "test";
		text(s1);
		int a = 10, b = 20, add, sub;
		addition(a, b);
		sub = sub(a, b);
		System.out.println(sub + "  sub numbers");
	}

	public static void addition(int a, int b) {
		int c = a + b;
		System.out.println(c + "  Added numbers");
	}

	public static int sub(int a, int b) {
		int c = a - b;
		return c;
	}

	public static String text(String s) {
		return s;
	}

	public abstract void m1();
}