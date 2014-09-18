public class LinkedList {
	
	public class Node {
		private int data;
		private Node next;

		public Node(int data) {
			this.data = data;
			next = null;
		}	
		
		public String toString() {
			return data + " ";
		}
	}

	private Node head;
	
	public LinkedList() {
		head = null;
	}

	public void append(int data) {
		Node newNode = new Node(data);

		if (head == null) {
			head = newNode;
		}
		 else {
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
		}
	}

	public Node remove() {
		if (head == null) {
			return null;
		}
		else {
			Node temp = head;
			head = head.next;
			return temp;
		}
	}

	public int length() {
		if (head == null) {
			return 0;
		}
		int count = 0;
		Node temp = head;
		while (temp != null) {
			count++;
			temp = temp.next;
		}
		return count;
	}

	public String toString() {
		if (head == null) {
			return null;
		}
		String res = "";
		Node temp = head;
		while (temp != null) {
			res += temp.toString();
			temp = temp.next;
		}
		return res;	
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();

		list.append(1);
		list.append(2);
		list.append(3);

		System.out.println(list);
		System.out.println("Length = " + list.length());

		System.out.println(list.remove());
		System.out.println(list.remove());
		System.out.println(list.remove());

		System.out.println("Length = " + list.length());
	}	
}
