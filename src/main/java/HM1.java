public class HM1 {
	public static void main(String[] args) {
		int x1 = 4;
		int y1 = 5;
		System.out.println(HM1.evaluate(x1, y1));
		double x2 = 4.0;
		double y2 = 5.0;
		System.out.println(HM1.evaluate(x2, y2));
		byte x3 = 4;
		byte y3 = 5;
		System.out.println(HM1.evaluate(x3, y3));
	}
	
	static double evaluate(int x, int y) {
		return (double) 3 * x / (5 * y);
	}
	
	static double evaluate(double x, double y) {
		return 3 * x / (5 * y);
	}
	
	static double evaluate(byte x, byte y) {
		return (double) 3 * x / (5 * y);
	}
	
}
