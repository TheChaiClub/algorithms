import java.util.Scanner;

public class ReverseString {
	
	public static void main(String [] args){
		System.out.println("Enter a string to reverse");
		String s;
		try(Scanner scanner = new Scanner(System.in)){
			s = scanner.nextLine();
		}
		
		System.out.println(reverseString(s));
	}
	
	public static String reverseString(String s){
		int size = s.length();
		StringBuffer builder = new StringBuffer(size);
		for(int i=size-1;i>=0;i--){
			builder.append(s.charAt(i));
		}
		return builder.toString();
	}
	
}
