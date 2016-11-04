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
		if(n <= 0){
			return false;
		}
		int sum = 0;
		while (n != 0) {
			sum += n & 1;
			if (sum > 1) {
				return false;
			}
			n = n >> 1;
		}
		return true;
	}
}
