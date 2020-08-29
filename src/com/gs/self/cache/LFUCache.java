package com.gs.self.cache;

import java.util.*;

public class LFUCache {
  private class Node {
    int val;
    Node prev, next;

    Node(int val) {
      this.val = val;
    }
  }

  private int capacity;
  private Node head, tail;
  Map<Integer, Node> map = new HashMap<Integer, Node>();

  public LFUCache(int capacity) {
    this.capacity = capacity;
  }


  public int get(int key) {
    System.err.println("key " + key + " val " + getNode(key).val);
    return getNode(key).val;
  }

  private Node getNode(int key) {
    if (!map.containsKey(key))
      return new Node(-1);

    Node node = map.get(key);
    if (node == tail) {
      tail = tail.prev;
      tail.next = null;
    } else {
      Node prevNode = node.prev;
      Node nextNode = node.next;
      prevNode.next = nextNode;
      nextNode.prev = prevNode;
    }
    node.next = head;
    head.prev = node;
    head = node;

    return node;
  }



  public void put(int key, int value) {
    if(map.size() == 0) {
      Node node = new Node(value);
      head = node;
      tail = node;
      map.put(key, node);
      
    }else if (map.containsKey(key)) {
      Node node = getNode(key);
      node.val = value;
    } else {
      Node node = new Node(value);
      node.next = head;
      head.prev = node;
      head = node;

      map.put(key, node);

      if (map.size() > capacity) {
        tail = tail.prev;
        tail.next = null;
      }
    }

  }
  
  
  public static void main(String}] args) {
    LFUCache cache = new LFUCache( 2 /* capacity */ );

    cache.put(1, 1);
    cache.put(2, 2);
    cache.get(1);       // returns 1
    cache.put(3, 3);    // evicts key 2
    cache.get(2);       // returns -1 (not found)
    cache.get(3);       // returns 3.
    cache.put(4, 4);    // evicts key 1.
    cache.get(1);       // returns -1 (not found)
    cache.get(3);       // returns 3
    cache.get(4);       // returns 4
  }
}
