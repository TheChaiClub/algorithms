import java.util.Scanner;

public class RotateImage {

	public static void main(final String[] args) {
		try (final Scanner scanner = new Scanner(System.in)) {

			final int n = scanner.nextInt();

			final int[][] array = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					array[i][j] = scanner.nextInt();
				}
			}
			rotate(array, n);
			print(n, array);
		}
	}

	private static void rotate(final int[][] array, final int n) {
		final int size = n - 1;
		for (int i = 0; i < n / 2; i++) {
			for (int j = i; j < n - i - 1; j++) {
				int temp1 = array[j][size - i];
				array[j][size - i] = array[i][j];

				final int temp2 = array[size - i][size - j];
				array[size - i][size - j] = temp1;

				temp1 = array[size - j][i];
				array[size - j][i] = temp2;

				array[i][j] = temp1;
			}
		}
	}

	private static void print(final int n, final int[][] array) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}
}

