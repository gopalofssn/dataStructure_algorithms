package com.gs.self.cache;

import java.util.*;

public class LRUCache {


private Node head;  
private Node tail; 
private Map<Integer, Node> cacheHolder; // <key, Node> - to delete or insert operation at O(1)
private final int capacity;

public LRUCache(int capacity) {
    this.capacity = capacity;
    cacheHolder = new HashMap<Integer, Node>();
    head = tail;
}

public int get(int key) {
  
  System.err.println("getting key " + key);
    // check if present
    if(!cacheHolder.containsKey(key)) return -1;
    
    // move node to head
      // a. tail ?
      // b. already head?
      // c. middle ?
     Node node = cacheHolder.get(key);
     if(node == tail && node != head){
       tail = tail.next;
       tail.prev = null;
       addToHead(node);
     }else if(node != head){
       node.prev.next = node.next;
       node.next.prev = node.prev;
       addToHead(node);
     } 
     return node.val;
}

public void put(int key, int value) {
  System.err.println("putting key " + key);
 
    Node node = new Node(key, value);
    if(cacheHolder.containsKey(key)) cacheHolder.remove(key);
    
    cacheHolder.put(key, node);
    addToHead(node);// add to map and D LL
    
    System.err.println(head);
    // check evict policy .and remove tail if necessary 
    if(cacheHolder.size() > capacity){
      System.err.println("cache limit exceeds ");
      cacheHolder.remove(tail.key);
        
       Node newTail = tail.next;
       newTail.prev = null;
       tail = newTail;
    }
    System.err.println(cacheHolder.entrySet());
   System.err.println(head); 
}

private void addToHead(Node node){
       if(head == null) {
         head = node;
         tail = node;
         return;
       }
       node.prev = head;
       head.next = node;
       head = node;
}


  public static void main(String[] args) {
    // TODO Auto-generated method stub
    LRUCache cache = new LRUCache(2);
    cache.put(2, 1);
    cache.put(1, 1);
    cache.put(2, 3);
    cache.put(4, 1);
    System.err.println(cache.get(1));
    System.err.println(cache.get(2));
    
    /*cache.put(2, 1);
    System.err.println(cache.get(2));
    */
    /*cache.put(2, 1);
    cache.put(0, 0);
    cache.put(2, 3); // evicts key 2, 1 combo
    cache.put(4, 1); // evict 1,1 camboo
    System.err.println(cache.get(1));
    System.err.println(cache.get(2));
    System.err.println(cache.get(4));*/
    
    /*
    cache.put(1 , 1);
    cache.put(2 , 2);
    System.err.println(cache.get(1));
    cache.put(3, 3);
    System.err.println(cache.get(2));
    cache.put(4 , 4);
    System.err.println(cache.get(1));
    System.err.println(cache.get(3));
    System.err.println(cache.get(4));*/
    
  }

}
