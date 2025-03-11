public class HM2 {
	
	public static void main(String[] args) {
		for (int i = 1; i <= 45; i++) {
			int a = climbStairs(i);
			int b = climbStairsRecursive(i);
			System.out.println(a + " " + b);
			assert a == b;
		}
	}
	
	static int climbStairs(int n) {
		double m = n % 2 == 0 ? (double) n / 2 : (double) (n - 1) / 2;
		double k = n % 2 == 0 ? 0 : 1;
		double res = 0;
		double temp = m + k == m ? 1 : m + k;
		while (m + k <= n) {
			res += temp;
			temp *= (m + k + 1) * m / (k + 1) / (k + 2);
			m -= 1;
			k += 2;
		}
		return (int) Math.round(res);
	}
	
	static int climbStairsRecursive(int n) {
		if (n == 1) return 1;
		else if (n == 2) return 2;
		else if (n == 3) return 3;
		return climbStairsRecursive(n - 1) + climbStairsRecursive(n - 2);
	}
	
}
