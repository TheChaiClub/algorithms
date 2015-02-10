import java.io.Serializable;


public class Palindrome<T> implements Serializable{

	private static final long serialVersionUID = 1L;

	static class Node<T> {
		private T element;
		private Node<T> next;
		
		public Node(T element, Node<T> next) {
			this.element = element;
			this.next = next;
		}
	}
	
	private Node<T> head;
	private transient Node<T> current;

	private transient boolean isPalindrome;

	public Palindrome(Node<T> head) {
		this.head = head;
		this.current = head;
		this.isPalindrome = true;	// true to start with. set to false when a mismatch is encountered.
	}
	
	private Node<T> recurse(final Node<T> n){
		
		// Base case, last element of the LinkedList
		if (n.next == null || !isPalindrome) {
			return n;
		}
		
		// returned is the next node (previous from last)
		final Node<T> returned = recurse(n.next);
		
		// check if they match
		if ((returned.element == null && current.element == null) || returned.element.equals(current.element)) {
			current = current.next;
		} else {
			isPalindrome = false;
		}
		return n;
	}
	
	public boolean checkIfPalindrome() {
		// check for valid input
		assert this.head != null;
		
		// reset current to head
		this.current = this.head;
		this.isPalindrome = true;
		
		// Check recursively
		recurse(head);
		return isPalindrome;
	}
	
	public static void main(String[] args) {
		// prepare
		Node<String> head = new Node<String>("~", new Node<String>("%", new Node<String>(null, new Node<String>(null, new Node<String>("%", new Node<String>("~", null))))));
		
		// test
		Palindrome<String> palindrome = new Palindrome<String>(head);
		
		// print
		System.out.println(palindrome.checkIfPalindrome());
		
	}
	
}
