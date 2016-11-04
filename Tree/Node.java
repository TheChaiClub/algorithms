import java.util.ArrayList;
import java.util.List;

public class Node<T> {
	
	private T value;
	
	private List<Node<T>> childNodes;
	
	private boolean visited = false;

	public Node<T> left;
	public Node<T> right;

	public Node(T value){
		this.value = value;
		childNodes = new ArrayList<>();
	}
	
	public void addChild(Node<T> node){
		this.childNodes.add(node);
	}
	
	public List<Node<T>> getChildNodes(){
		return childNodes;
	}
	
	public boolean isVisited() {
		return visited;
	}
	
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	
	public T getValue(){
		return value;
	}

}
