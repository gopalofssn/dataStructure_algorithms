package com.gs.buffer;

import java.util.ArrayDeque;
import java.util.Deque;

public class BufferUsingArrayDeque {

	private final int CAPACITY;
	private Deque<Character> queue;
	
	public BufferUsingArrayDeque(int capacity) {
		this.CAPACITY = capacity;
		this.queue = new ArrayDeque<Character>();
	}

	private String read(int n) {
		int totalCharToRead = Math.min(n, queue.size()); // 3
		char[] result = new char[totalCharToRead]; // [ . . .]
		int counter = 0;
		while(counter < totalCharToRead) {
			result[counter++] = queue.poll(); // a b c
		}
		return String.copyValueOf(result); // abc
	}

	private int write(char[] src) {
		if(queue.size() == CAPACITY) return 0;
		int counter = 0;
		while(queue.size() < CAPACITY && counter < src.length) { // 
			queue.add(src[counter++]); // a b c , d e 
		}
		return counter; // 3 , 2
	}
	
	public static void main(String[] args) {
		BufferUsingArrayDeque buf = new BufferUsingArrayDeque(5);
        System.out.println(buf.write(new char[]{'a','b','c'})); //3 
        System.out.println(buf.write(new char[]{'d','e','f'})); // 2
        System.out.println(buf.read(3)); // a b c
        System.out.println(buf.write(new char[]{'x','y','z','a','b','c'})); // 3
        System.out.println(buf.read(8)); // ef xyz
	}

}
