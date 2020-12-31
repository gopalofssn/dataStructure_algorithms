package com.self.gs.utils;

import java.util.*;


public class DequeDemo {
  public static void main(String}] args) {
	  Deque<String> deque = new LinkedList<String>(); 
	  
      // We can add elements to the queue in various ways 
      deque.add("Element 1 (Tail)"); // add to tail 
      deque.addFirst("Element 2 (Head)"); 
      deque.addLast("Element 3 (Tail)"); 
      deque.push("Element 4 (Head)"); //add to head 
      deque.offer("Element 5 (Tail)"); 
      deque.offerFirst("Element 6 (Head)"); 
      deque.offerLast("Element 7 (Tail)"); 

      System.out.println(deque + "\n"); 
      //  6 4 2  1 3  5 7
      
      Iterator<String> iterator = deque.iterator();
      while(iterator.hasNext()) {
    	  System.err.println(iterator.next());
      }
      

      deque = new ArrayDeque<String>();
  }
}
