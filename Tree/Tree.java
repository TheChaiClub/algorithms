import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Tree {
	
	public <T> Node<T> dfs(Node<T> node, T value, Stack<T> pathStack){
		if(node != null){
			node.setVisited(true);
			if(node.getValue().equals(value)){
				pathStack.push(node.getValue());
				return node;
			}
			for(Node<T> childNode : node.getChildNodes()){
				if(!childNode.isVisited()){
					Node<T> resultNode = dfs(childNode, value, pathStack);
					if(resultNode != null){
						pathStack.push(node.getValue());
						return resultNode;
					}
				}
			}
		}
		return null;
	}
	
	public <T> Node<T> bfs(Node<T> node, T value){
		Queue<Node<T>> queue = new LinkedList<>();
		
		queue.add(node);
		
		while(!queue.isEmpty()){
			Node<T> n = queue.poll();
			n.setVisited(true);
			if(n.getValue().equals(value)){
				return n;
			}
			for(Node<T> adj : n.getChildNodes()){
				if(!adj.isVisited()){
					queue.add(adj);
				}
			}
		}
		return null;
	}
	
	public <T> boolean isBalanced(Node<T> root){
		if(checkHeight(root) == -1) return false;
		return true;
	}

	private <T> int checkHeight(Node<T> root) {
		if(root == null) return 0;
		
		int leftHeight = checkHeight(root.left);
		if(leftHeight == -1) return -1;
		
		int rightHeight = checkHeight(root.right);
		if(rightHeight == -1) return -1;
		
		if(Math.abs(leftHeight - rightHeight) > 1){
			return -1;
		}
		
		return Math.max(leftHeight, rightHeight) + 1;
	}
	
	public <T> Node<T> createMinimalBST(T [] arr){
		return createMinimalBST(arr, 0 , arr.length-1);
	}

	private <T> Node<T> createMinimalBST(T[] arr, int i, int j) {
		if(i > j) return null;
		int middle = (i + j)/2;
		Node<T> node = new Node<>(arr[middle]);
		node.left = createMinimalBST(arr, i, middle-1);
		node.right = createMinimalBST(arr, middle+1, j);
		return node;
	}
	
	public <T extends Comparable<T>> boolean checkBST(Node<T> root){
		return checkBST(root, null, null);
	}

	private <T extends Comparable<T>> boolean checkBST(Node<T> root, T min, T max) {
		if(root == null) return true;
		if(min != null && root.getValue().compareTo(min) <= 0
				|| max != null && root.getValue().compareTo(max) > 0){
			return false;
		}
		
		if(!checkBST(root.left, min, root.getValue()) ||
				!checkBST(root.right, root.getValue(), max)){
			return false;
		}
		return true;
	}
}
