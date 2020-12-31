package com.gs.buffer;

public class BufferUsingSinglyLinkedList {
	
	private class Node{
		private final char val;
		private Node next;
		Node(char val){
			this.val = val;
		}
	}
	
	private final int CAPACITY;
	private Node head;
	private Node tail;
	private int currentSize;
	
	public BufferUsingSinglyLinkedList(int capacity) {
		this.CAPACITY = capacity;
		head = tail;
		this.currentSize = 0;
	}

	private String read(int n) {
		if(currentSize == 0 || n == 0) return new String();
		int totalNumberToRead = Math.min(currentSize, n);
		char[] read = new char[totalNumberToRead];
		int counter = 0;
		while(counter < totalNumberToRead) {
			read[counter++] = readFromBuffer();
		}
		return String.valueOf(read);
	}


	private char readFromBuffer() {
		char val = head.val;
		head = head.next;
		currentSize--;
		return val;
	}

	private int write(char[] src) {
		if(currentSize == CAPACITY) return 0;
		int counter = 0;
		while(currentSize < CAPACITY && counter < src.length) {
			addToBuffer(new Node(src[counter++]));
		}
		return counter;
	}	
	
	private void addToBuffer(Node node) {
		if(head == null) {
			head = node;
			tail = node;  // a
		}else {	
			tail.next = node; //  a -> b, a->b->c
			tail = node;	 //  (H) a - >b(T)	, H(a) and c(T)
		}
		currentSize++;
	}

	public static void main(String[] args) {
		BufferUsingSinglyLinkedList buf = new BufferUsingSinglyLinkedList(5);
        System.out.println(buf.write(new char[]{'a','b','c'})); //3 
        System.out.println(buf.write(new char[]{'d','e','f'})); // 2
        System.out.println(buf.read(3)); // a b c
        System.out.println(buf.write(new char[]{'x','y','z','a','b','c'})); // 3
        System.out.println(buf.read(8)); // ef xyz
        System.out.println(buf.write(new char[]{'a','b','c'})); //3 
        System.out.println(buf.read(3)); // a b c
        System.out.println(buf.read(3)); // ""
	}
}
