import java.util.*;

public class Trie {

  public class Node {
    Character key;
    ArrayList<Node> children;

    public Node(Character key) {
      this.key = key;
      children = new ArrayList<Node>();
    }
  }

  Node root;

  public Trie() {
    root = new Node(null);
  }

  public boolean contains(String s) {

    ArrayList<Node> current = new ArrayList<Node>();
    current = root.children;

    for (int i = 0; i < s.length(); i++) {
      boolean match = false;
      for (int j = 0; j < current.size(); j++) {
        Node currentNode = current.get(j);
        if (currentNode.key.equals(s.charAt(i))) {
          current = currentNode.children;
          match = true;
          break;
        }
      }
      if (!match) return false;
    } 
    return true;
  }

  public void add(String s) {
    ArrayList<Node> current = root.children;

    for (int i = 0; i < s.length(); i++) {
      boolean match = false;
      for (int j = 0; j < current.size(); j++) {
        Node currentNode = current.get(j);
        if (currentNode.key.equals(s.charAt(i))) {
          current = currentNode.children;
          match = true;
          break;
        }
      }
      if (!match) {
        Node newNode = new Node(s.charAt(i)); 
        current.add(newNode);
        current = newNode.children;
      }
    }
  }

  public static void main(String[] args) {
    Trie trie = new Trie();

    trie.add("a");
    trie.add("abc");
    System.out.println(trie.contains("a"));
    System.out.println(trie.contains("abc"));
    System.out.println(trie.contains("bc"));
  }
}