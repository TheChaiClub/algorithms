import java.util.Scanner;

public class PowOfTwo {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long n;
		try {
			n = scanner.nextLong();
		} catch (Exception e) {
			System.out.println("Please enter a valid number");
			return;
		}

		System.out.println(isPowOfTwo(n));
	}

	private static boolean isPowOfTwo(long n) {

		boolean foundOne = false;
		while (n != 0) {
			boolean lastBitOne = (n & 1) == 1;
			if (lastBitOne) {
				if (foundOne) {
					return false;
				}
				foundOne = true;
			}
			n = n >> 1;
			System.out.println(n);
		}
		return foundOne;
	}
}
