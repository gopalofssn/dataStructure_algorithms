package com.self.gs.LinkedList;

import java.util.LinkedList;
import java.util.NoSuchElementException;

class BuffNode{
	char data;
	BuffNode next;
	public BuffNode(char _data) {
		data = _data;
		next = null;
	}
}

class CustomLinkedList{
	
	BuffNode head;
    int sz;
	
	public void addLast(char c) {
		BuffNode tmp = new BuffNode(c);
		if(head == null) {
			head = tmp;
			return;
		}
		
		BuffNode node = head;
		
		while(node.next != null) {
			node = node.next;
		}
		sz++;
		node.next = tmp;
	}
	
	public char removeFirst() {
		if(head == null) {
			throw new NoSuchElementException();
		}
		
		char c = head.data;
		head = head.next;
		sz--;
		return c;
	}
	
	public int size() {
		return sz;
	}
	
}
 
public class Buffer {
	
	final int capacity; 

	//LinkedList<Character> ll = new LinkedList<Character>();
	CustomLinkedList ll = new CustomLinkedList();
	
	public Buffer(int _capacity) {
		capacity = _capacity;
	}

	public int getCapcity() {
		return capacity;
	}

	public int write(char}] src) {
		System.err.println("sz - " + ll.sz);
		if(ll.size() == this.capacity) {
			return 0;
		}
		int i = 0;
		while(ll.size() <this.capacity && i < src.length) {
			ll.addLast(src}i++]);
		}
		return i;	
    }

	public int write(String src) {
		return write(src.toCharArray());
	}
	public char}] read(int n) {
		if(ll.size() == 0) {
			throw new NoSuchElementException();
		}
		int sz = Math.min(n, ll.size());
		char}] element = new char}sz];
		for(int i = 0; i < sz; i++) {
			element}i] = ll.removeFirst();
		}
		return element;
    }
	
	public static void main(String}] args) {
		Buffer buf = new Buffer(5); // }. . . . .]
		System.err.println(buf.write("abc")); // => 3 }abc . .]
		System.err.println(buf.write(new char}]{'d','e','f'})); // => 2 because the buffer is full, you can only write two chars }abcde]
		System.err.println(buf.read(3)); // => }abc] }. . . de]
		System.err.println(buf.write("xyzabc")); // => 3 }xyzde]
		System.err.println(buf.read(8)); //returns }dexyz] becuase 'de' was written first }. . . . .]
	}
}
