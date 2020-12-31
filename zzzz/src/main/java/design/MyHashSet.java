package design;

public class MyHashSet {


  private class Node {
    int val;
    Node next;

    public Node(int _val) {
      val = _val;
    }
  }

  private Node[] nodes;
  private int capacity;

  /* your data structure here. */
  public MyHashSet() {
    capacity = 10000;
    initializeNodes();
  }

  public MyHashSet(int _capacity) {
    capacity = _capacity;
    initializeNodes();
  }

  private void initializeNodes() {
    nodes = new Node[capacity];
  }

  public void add(int key) {
    int idx = getIndex(key);
    Node node = new Node(key);
    if (nodes[idx] == null) {
      nodes[idx] = node;
    } else {
      node.next = nodes[idx];
      nodes[idx] = node;
    }
  }

  public void remove(int key) {
    int idx = getIndex(key);
    if (nodes[idx] == null) {
      return;
    }

    Node current = nodes[idx], prev = null;
    while (current != null) {
      if (current.val == key) {
        break;
      }
      prev = current;
      current = current.next;
    }

    if (prev == null) {
      nodes[idx] = null;
      return;
    }

    prev.next = (current.next == null) ? null : current.next;

  }

  /** Returns true if this set contains the specified element */
  public boolean contains(int key) {
    int idx = getIndex(key);
    if (nodes[idx] == null) {
      return false;
    }

    Node current = nodes[idx];
    while (current != null) {
      if (current.val == key) {
        return true;
      }
      current = current.next;
    }

    return false;
  }

  private int getIndex(int key) {
    return key % capacity;
  }

  public static void main(String[] args) {
    MyHashSet set = new MyHashSet();

    set.add(1);
    set.add(2);
    System.err.println(set.contains(1));
    System.err.println(set.contains(3));
    set.add(2);
    System.err.println(set.contains(2));
    set.remove(2);
    System.err.println(set.contains(2));

  }

}
