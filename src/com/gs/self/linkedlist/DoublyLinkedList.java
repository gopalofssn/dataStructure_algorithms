package com.gs.self.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class DoublyLinkedList {
  
  private class Node{
    int val;
    int freq;
    Node prev, next;
    Node(int val){
      this.val = val;
      this.freq = 1;
    }
    @Override
    public String toString() {
      return "Node }val=" + val + ", freq=" + freq + ", next=" + next + "]";
    }
     
  }

  private Node head, tail;
  private int length;
  /*
   3  2 -> 1
     < -
   */
  
  Map<Integer, Node> map = new HashMap<Integer, Node>();
  
  private void insert(int num) {
       Node node = new Node(num);
       if(tail == null) {
         tail = node;
       }else {
         node.next = head;
         head.prev = node;
       }
       head = node;
       length++;
       
       map.put(num, node);
       
       if(length > 4) {
         map.remove(tail.val, tail);
         tail = tail.prev;  
         tail.next = null;
         length--;
       }
  }
  
  private int get(int key) {
    if(!map.containsKey(key)) return -1;
    
    Node node = map.get(key);
    node.freq++;
    
    if(tail == node){
      System.err.println("its tail");
      tail = tail.prev;  
      tail.next = null;
    }else {
      Node prev = node.prev;
      Node next = node.next;
      
      prev.next = next;
      next.prev = prev;
    }
    
    node.next = head;
    head.prev = node;
    head = node;
    
    return node.val;
  }
  
  
  @Override
  public String toString() {
    //System.err.println(map);
    return "DoublyLinkedList }head=" + head + "]" ;// + "\n" + "DoublyLinkedList }tail=" + tail + "]";
  }




  public static void main(String}] args) {
     
    DoublyLinkedList dll = new DoublyLinkedList();
    dll.insert(1);
    dll.insert(2);
    dll.insert(3);
    dll.insert(4);
    
    System.err.println(dll.get(2));
    System.err.println(dll);
    
    System.err.println(dll.get(3));
    System.err.println(dll);
    
    
    System.err.println(dll.get(3));
    System.err.println(dll);
    
    
    System.err.println(dll.get(4));
    System.err.println(dll);
    
    System.err.println(dll.get(1));
    System.err.println(dll);
    
    
    System.err.println(dll.get(2));
    System.err.println(dll);
    
    dll.insert(5);
    System.err.println(dll);
    
    System.err.println(dll.get(3));
    System.err.println(dll);
    
    
  }

 

}
