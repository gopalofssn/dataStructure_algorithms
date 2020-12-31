package com.gs.self.cache;

import java.util.*;

class DoublyLinkedList {
	int key;
	int val;
	DoublyLinkedList prev;
	DoublyLinkedList next;

	DoublyLinkedList() {
	}

	DoublyLinkedList(int key, int val) {
		this.val = val;
		this.key = key;
	}
}

/*
  DLL to maintain order 
  Map to maintain key val pair to perform O(1) get delete etc.
  Put still O(1)
 */
public class LRUCache {

	private DoublyLinkedList head;
	private DoublyLinkedList tail;
	private Map<Integer, DoublyLinkedList> cacheHolder; // <key, Node> - to
														// delete or insert
														// operation at O(1)
	private final int capacity;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		cacheHolder = new HashMap<Integer, DoublyLinkedList>(capacity);
		head = new DoublyLinkedList();
		tail = new DoublyLinkedList();
		head.prev = tail;
		tail.next = head;
	}

	public void put(int key, int value) {
		 if(cacheHolder.containsKey(key)){
			 DoublyLinkedList node = cacheHolder.get(key);
			 node.val = value;
			 MoveAsRecentlyUsedNode(node);
			 return;
		 }

		 DoublyLinkedList node = new DoublyLinkedList(key, value);
		 cacheHolder.put(key, node);
		 addAsHead(node); 
		 
		 if(cacheHolder.size() > capacity){
			 removeTail();
		 }
		 
	}

	
	private void removeTail() {
		DoublyLinkedList node = tail.next;
		
		tail.next.next = node.next;
		node.next.prev = tail;
		
		int key = node.key;
		cacheHolder.remove(key);
		node = null;
	}

	public int get(int key) {
		if(!cacheHolder.containsKey(key)) return -1;
		
		 DoublyLinkedList node = cacheHolder.get(key);
		 int val = node.val;
		 MoveAsRecentlyUsedNode(node);
		 return val;
	}

	private void MoveAsRecentlyUsedNode(DoublyLinkedList node) {
		DoublyLinkedList nodePrev = node.prev;
		DoublyLinkedList nodeNext = node.next;
		nodePrev.next = nodeNext;
		nodeNext.prev = nodePrev;
		addAsHead(node);
	}
	
	private void addAsHead(DoublyLinkedList node) {
		DoublyLinkedList headPrev = head.prev;
		headPrev.next = node;
		node.prev = headPrev;
		
		node.next = head;
		head.prev = node;
		
	}

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(2);
		cache.put(2, 1);
		cache.put(1, 1);
		cache.put(2, 3);
		cache.put(4, 1);
		System.err.println(cache.get(1));
		System.err.println(cache.get(2));

		 cache.put(2, 1); 
		 System.err.println(cache.get(2));
		 System.err.println(cache.get(4));

	}

}
