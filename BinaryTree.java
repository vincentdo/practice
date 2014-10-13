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

	private Node root;

	public BinaryTree() {
		root = null;
	}

	// Recursive
	public void addNode(int data, Node current) {
		if (current == null) current = new Node(data);
		if (current.data > data) {
			addNode(data, current.right);
		} else addNode(data, current.left);
	}
	
	// Iterative
	public void addNode(int data) {
		Node cur = root;
		while (cur != null) {
			if (cur.data > data) cur = cur.right;
			else cur = cur.left;
		}
		cur = new Node(data);
	}

	// Recursive
	public boolean contains(int data, Node current) {
		if (current == null) {
			return false;
		} else if (current.data == data) return true;

		if (current.data > data) contains(data, current.right);
		else contains(data, current.left);
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
}
