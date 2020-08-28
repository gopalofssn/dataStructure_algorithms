package com.self.gs.utils;
import java.util.*;
import java.util.PriorityQueue;
public class MinHeap {

	public static void main(String}] args) {
		int}] nums = new int}] { 6, -1, 2, 7, 2 ,1 , 0, 9};
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((a,b) -> a-b);
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a,b) -> b-a);
		
		int counter = 0;
		for(int n:nums) {
			minHeap.offer(n);
			maxHeap.offer(n);
			if(++counter > 5) {
				minHeap.poll();
				maxHeap.poll();
			}
			
		}

		LinkedList<Integer> min = new LinkedList<Integer>();
		LinkedList<Integer> max = new LinkedList<Integer>();
		
		while(!minHeap.isEmpty()) {
		  min.addFirst(minHeap.poll());
		}
		
		while(!maxHeap.isEmpty()) {
			  max.addFirst(maxHeap.poll());
			}
		
		System.err.println("Min : " + min);
		System.err.println("Max : " + max);
	}

}
