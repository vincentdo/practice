import java.util.*;

public class BinaryTree {

	class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}

	public Node root;

	public BinaryTree() {
		root = null;
	}

	// Recursive
	public void addNode(int data, Node current) {
		if (current == null) {
			current = new Node(data);
		}
		else {
			if (current.data > data) {
				if (current.left != null) addNode(data, current.left);
				else current.left = new Node(data);
			}
			else {
				if (current.right != null) addNode(data, current.right);
				else current.right = new Node(data);
			}
		}
	}
	
	// Iterative
	public void addNode(int data) {
		if (root == null) {
			root = new Node(data);
		}
		Node cur = root;
		while (cur != null) {
			if (cur.data > data) {
				if (cur.left != null) cur = cur.left;
				else {
					cur.left = new Node(data);
					return;
				}
			}
			else {
				if (cur.right != null) cur = cur.right;
				else {
					cur.right = new Node(data);
					return;
				}
			}	
		}
	}

	// Recursive
	public boolean contains(int data, Node current) {
		if (current == null) {
			return false;
		} else if (current.data == data) return true;

		if (current.data > data) return contains(data, current.right);
		else return contains(data, current.left);
	}

	// Iterative
	public boolean contains(int data) {
		Node cur = root;
		while (cur != null) {
			if (cur.data == data) return true;
			if (cur.data > data) cur = cur.right;
			else cur = cur.left;
		}
		return false;
	}

	// Recursive
	public String preOrderTraversal(Node current) {

		if (current != null) {
			return current.data + " " + preOrderTraversal(current.left) + " " + preOrderTraversal(current.right);
		}
		else return "";
	}

	// Iterative
	public String preOrderTraversal() {
		String res = "";
		Stack<Node> stack = new Stack<Node>();

		Node cur = root;

		while (!stack.empty() || cur != null) {
			if (cur != null) {
				res += cur.data + " ";
				if (cur.right != null) {
					stack.push(cur.right);
				}	
				cur = cur.left;
			}
			else cur = stack.pop();
			
		}
		return res;
	}

	// Recursive
	public String inOrderTraversal(Node current) {
		if (current != null) {
			return inOrderTraversal(current.left) + " " + current.data + " " + inOrderTraversal(current.right);
		}
		else return " ";
	}

	// Iterative
	public String inOrderTraversal() {
		String res = "";
		Stack<Node> stack = new Stack<Node>();

		Node cur = root;

		while (!stack.empty() || cur != null) {
			if (cur != null) {
				stack.push(cur);
				cur = cur.left;
			}
			else {
				cur = stack.pop();
				res += cur.data + " ";
				cur = cur.right;
			}
		}
		return res;
	}

	public int maxDepth(Node node) {
		if (node == null) {
			return 0;
		}
		return 1 + Math.max( maxDepth(node.left), maxDepth(node.right) );
	}

	public int minDepth(Node node) {
		if (node == null) {
			return 0;
		}
		return 1 + Math.min( minDepth(node.left), minDepth(node.right) );
	}

	public boolean isBalanced() {
		System.out.println("Max: " + maxDepth(root));
		System.out.println("Min: " + minDepth(root));

		return (maxDepth(root) - minDepth(root) <= 1);
	}

	public static void main(String[] args) {

		BinaryTree tree = new BinaryTree();

		tree.addNode(5);

		for (int i = 0; i < 11; i++) {
			if (i != 5) {
				tree.addNode(i);
			}
		}

		System.out.println(tree.isBalanced());

		System.out.println("Printing preOrder: ");
		System.out.println(tree.preOrderTraversal());

		System.out.println("Printing inOrder: ");
		System.out.println(tree.inOrderTraversal());

	}
}
