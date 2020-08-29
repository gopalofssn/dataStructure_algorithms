package com.gs.self.bloomberg;

import java.util.*;

public class AllOprationInO1Time {

  private class Node{
    int val;
    Node prev, next;
    public Node(int val) {
      this.val = val;
    }
    @Override
    public String toString() {
      return "Node }val=" + val + ", next=" + next + "]";
    }
    
  }
  
  Node head;
  Node tail;
  
  Map<Integer, Node> keyNodeMap = new HashMap<>();
  /*
      1
      2
      1 -> 2 -> 3
        <-   <-
   */
  public void insert(int key) {
    Node node = new Node(key);
    keyNodeMap.put(key, node);
    
    if(head == null) {
      head = node;
      tail = node;
      return;
    }
    
    node.prev = tail;
    tail.next = node;
    tail = node;  
  }
  
  public static void main(String}] args) {
    AllOprationInO1Time a = new AllOprationInO1Time();
    
    a.insert(1);
    a.insert(2);
    a.insert(3);
    a.insert(4);
    
    a.remove(2);
    a.remove(1);
    
    System.err.println(a.get(4));
    a.print();

  }

  private void remove(int key) {
    Node node = keyNodeMap.get(key);
    
    if(node == tail) {
      tail = node.prev;
      tail.next = null;
      return;
    }
    
    if(node == head) {
      head = head.next;
      head.prev = null;
      
      return;
    }
    
    Node prev = node.prev;
    Node next = node.next;
    prev.next = next;
    next.prev = prev;
  }

  private void print() {
    System.err.println(keyNodeMap);
    System.err.println(head);
    
  }

}
