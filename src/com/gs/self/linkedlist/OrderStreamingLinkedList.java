package com.gs.self.linkedlist;

import java.util.*;

public class OrderStreamingLinkedList {

  private class Node{
    int val;
    Node next;
    Node(int val){
      this.val = val;
    }
    @Override
    public String toString() {
      return val + " -> " + next;
    }
    
  }
  
  private Node head;
  
  private List<Node> expressLane = new ArrayList<Node>();
  
  private void insert(int i) {
      Node node = new Node(i);
      if( head == null ) {
        head = node;
        return;
      }
      
      Node current = findStartNode(i);
      System.err.println(" placing " + node.val );
      Node prev = null;
      
      while(current != null) {
        
        if(current.val > node.val) {
          break;
        }
        prev = current;
        current = current.next;
      }
      
      if(prev == null) {
        node.next = head;
        head = node;
      }else {
        node.next = current;
        prev.next = node;
      }
      
      
      if(i % 5 == 0) {
        expressLane.add(node);
      }
      
  }
  
  
  private Node findStartNode(int i) {
     
    int left = 0, right = expressLane.size() - 1;
    
    while(left < right) {
      int mid = (left + right ) / 2;
      if(expressLane.get(mid).val > i && expressLane.get(mid -1).val < i) {
        System.err.println("strt pt " + expressLane.get(mid).val);
        return expressLane.get(mid);
      }else if(expressLane.get(mid).val > i ) {
        right = mid - 1;
      }else {
        left = mid + 1;
      }
    }
    
    
    return head;
  }


  public static void main(String}] args) {
    
    OrderStreamingLinkedList oll = new OrderStreamingLinkedList();
    
    for(int i = 1 ; i <= 100 ; i++) {
      if(i % 5 == 0)
        oll.insert(i);
    }
    oll.print();
    
    for(int i = 1 ; i <= 100 ; i++) {
      if(i % 5 != 0)
        oll.insert(i);
    }
    
    oll.print();
    
     
  }


  private void print() {
    System.err.println(head);
    for(Node express : expressLane)
      System.err.println(express);
  }



  

}
