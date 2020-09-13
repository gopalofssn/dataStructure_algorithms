package com.gs.buffer;

import java.util.Arrays;

/*
    poll should return oldest one
    offer should write next if capacity , otherwise overwrite oldest
    overwrite the data without waiting for it to be consumed.
 */
public class RingBuffer {
	
	private final char[] data;
	private int readPoiter;
	private int writePointer;
	
	public RingBuffer(int capacity) {
		this.data = new char[capacity];
		Arrays.fill(data, '.');
		this.readPoiter = 0;
		this.writePointer = 0;
	}

	private void offer(char c) {
		 writePointer = writePointer % data.length;
		 data[writePointer] = c;
		 writePointer++;
	}
	
	private char poll() {
		readPoiter = readPoiter % data.length;
		char val = data[readPoiter];
		data[readPoiter] = '.';
		readPoiter++;
		return val;
	}

	
	public static void main(String[] args) {
		RingBuffer buffer = new RingBuffer(5);
		
		System.out.println(String.valueOf(buffer.data)); // . . . . . 
		
		char c = 'a';
		int counter = 3;
		while(counter > 0) {
			buffer.offer(c++);
			counter--;
		}
		System.out.println(String.valueOf(buffer.data)); // a b c . .
		counter = 2;
		while(counter > 0) {
			char p = buffer.poll();
			System.out.println(p); // a b
			counter--;
		}
		System.out.println(String.valueOf(buffer.data)); // . . c . .
		
		counter = 5;
		while(counter > 0) {
			buffer.offer(c++);
			counter--;
		}
		
		System.out.println(String.valueOf(buffer.data)); // f g (c)h d e   ( h is replaced c)
		
		counter = 2;
		while(counter > 0) {
			char p = buffer.poll();
			System.out.println(p); // h d 
			counter--;
		}
		
		System.out.println(String.valueOf(buffer.data)); //  f g . . e
		
		counter = 1;
		while(counter > 0) {
			buffer.offer(c++);  // i
			counter--;
		}
		
		System.out.println(String.valueOf(buffer.data)); //  f g i . e
	}
	
}
