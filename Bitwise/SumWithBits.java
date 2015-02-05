import java.util.Scanner;

public class SumWithBits {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long a = 0, b = 0;	// input values

		try {
			a = scanner.nextLong();
			b = scanner.nextLong();
		} catch (Exception e) {
			System.out.println("Please enter valid numbers");
		}

		System.out.println("" + a + " + " + b + " = " + sum(a, b));
	}

	private static long sum(long a, long b) {
		return addBits(a, b);
	}

	private static long addBits(long xor, long and) {

		if (and == 0) {
			return xor;
		}
		
		final long xor2 = xor ^ and;
		final long and2 = xor & and;
		final long shiftedAnd = and2 << 1;

		return addBits(xor2, shiftedAnd);
	}
}
