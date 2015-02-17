import java.util.Scanner;
import java.util.Stack;

public class SortedStack {

	public static void main(final String[] args) {
		final Stack<Integer> stack = new Stack<>();
		try (Scanner scanner = new Scanner(System.in)) {
			final int number = scanner.nextInt();
			for (int i = 0; i < number; i++) {
				stack.push(scanner.nextInt());
			}
			print(sort(stack));
		}
	}

	private static Stack<Integer> sort(final Stack<Integer> stack) {
		final Stack<Integer> sortedStack = new Stack<>();
		while (!stack.isEmpty()) {
			final int temp = stack.pop();
			while (!sortedStack.isEmpty() && sortedStack.peek() < temp) {
				stack.push(sortedStack.pop());
			}
			sortedStack.push(temp);
		}
		return sortedStack;
	}

	private static void print(final Stack<Integer> stack) {
		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + (stack.size() == 0 ? "" : " "));
		}
	}
}

