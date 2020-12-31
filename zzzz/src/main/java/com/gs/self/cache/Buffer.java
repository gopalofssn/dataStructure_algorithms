package com.gs.self.cache;

class Node{
	char val;
	Node next;
	Node(char val){
		this.val = val;
	}
}

public class Buffer {
    private final int CAPACITY;
    private int currentSize;
    private Node head;
    private Node tail;
	public Buffer(int capacity) {
		this.CAPACITY = capacity;
		head = tail;
		currentSize = 0;
	}

	// return how many char it wrote
	private int write(String s) {
		if(currentSize == CAPACITY) return 0;
		char[] cArray = s.toCharArray();
		int count = 0;
		if(head == null){
			head = new Node(cArray[count++]);
			tail = head;
			currentSize++;
		}
		while(count < cArray.length && currentSize < CAPACITY){
			Node node = new Node(cArray[count++]);
			tail.next = node;
			tail = node;
			currentSize++;
		}
		return count;
	}
	
	private String read(int numberOfChars) {
		if(head == tail ) return new String();
		StringBuilder sb = new StringBuilder();
		while(numberOfChars > 0 && currentSize > 0){
			sb.append(head.val);
			head = head.next;
			numberOfChars--;
			currentSize--;
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		Buffer buf = new Buffer(5); // [. . . . .]
		System.err.println(buf.write("abc")); // => 3 [a b c . .]
		System.err.println(buf.write("def")); // => 2 because the buffer is full, you can only write two chars [a b c d e]
		System.err.println(buf.read(3)); // => read 1st 3 [a b c]  &  resever additonal space for future [d e . . .]
		System.err.println(buf.write("xyzabc")); // => 3 [ d e x y z]
		System.err.println(buf.write("more")); // 0  it's full , no more write
		
		System.err.println(buf.read(8)); // returns [dexyz] becuase 'de' was written first [. . . . .]
		System.err.println(buf.read(8)); // empty
		
		System.err.println(buf.write("abc")); // => 3 [a b c . .]
		System.err.println(buf.write("def")); // => 2 because the buffer is full, you can only write two chars [a b c d e]
		System.err.println(buf.read(3)); // [ a b c ]
	}

	


}
