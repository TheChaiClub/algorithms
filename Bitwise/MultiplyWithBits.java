import java.util.Scanner;

public class MultiplyWithBits {

	public static void main(String[] args) {
		
		long a = 0, b = 0;

		try(final Scanner scanner = new Scanner(System.in)) {
			a = scanner.nextLong();
			b = scanner.nextLong();
		} catch (Exception e) {
			System.out.println("Please enter valid numbers.");
			return;
		}

		System.out.println(multiply(a, b));
	}
	

	private static long multiplyRecursive(long a, long b, long sum) {
		if (b == 0) {
			return sum;
		}
		if ((b & 1) == 1) {
			sum = add(sum, a);
		}
		a = a << 1;
		b = b >> 1;
		
		return multiplyRecursive(a,b,sum);
	}
	private static long multiply(long a, long b) {	
	long sum = 0;
		while (b != 0 && a != 0) {
			System.out.println("a: "+ a);
			System.out.println("b: "+ b);
			if ((b & 1) == 1) {
				sum = add(sum, a);
			}
			a = a << 1;
			b = b >> 1;
		}
		return sum;
	}

	private static long add(final long sum, final long carry) {
		if (carry == 0) {
			return sum;
		}

		final long xor = sum ^ carry;
		final long and = sum & carry;
		final long andShifted = and<<1;

		return add(xor, andShifted);
	}

}
