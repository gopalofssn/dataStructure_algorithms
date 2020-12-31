package com.self.gs.digits;
import java.util.*;
public class SecondLargestElementInArray {

	public static void main(String[] args) {
		int nums[] = new int[] {7,1,5,3,6,4};	
		System.err.println(second(nums));
	}

	private static int second(int[] nums) {
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		for(int n : nums) {
			minHeap.offer(n);
			if(minHeap.size() > 2)
				minHeap.poll();
		}
				
		return minHeap.poll();
	}

}
