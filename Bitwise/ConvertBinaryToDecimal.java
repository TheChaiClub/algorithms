import java.util.Scanner;

public class ConvertBinaryToDecimal {
	public static void main(String[] args) {
		System.out.println("Please enter a binary number");
		Scanner scanner = new Scanner(System.in);
		String binary;
		try {
			binary = scanner.next();
		} catch (Exception e) {
			System.out.println("Please enter a valid binary number");
			return;
		}

		System.out.println(convertBinaryToDecimal(binary));
	}

	public static int convertBinaryToDecimal(String binary){
		int sum =0;
		for(int i=0;i<binary.length();i++){
			sum += Math.pow(2, i) * Character.getNumericValue(binary.charAt(i));
		}
		return sum;
	}
}
