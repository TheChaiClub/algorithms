import java.util.Scanner;

public class NumOfOneBits {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long n;
		try {
			n = scanner.nextLong();
		} catch (Exception e) {
			System.out.println("Please enter a valid number");
			return;
		}

		System.out.println(countNumOfTrueBits(n));
	}

	private static int countNumOfTrueBits(long n) {

		int sum = 0;
		while (n != 0) {
			sum += (n & 1);
			n = n >> 1;
		}
		return sum;
	}
}
