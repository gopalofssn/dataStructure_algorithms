package com.self.gs.stackqueue;
import java.util.*;

public class QueueOfferAdd {
  public static void main(String[] args) {
	int[] array = new int[] {1,-2,2,0,-2,-7};

	Comparator<Integer> comparator = new Comparator<Integer>() {
		public int compare(Integer current, Integer parent) {
			if(Math.abs(current)>Math.abs(parent)) 
				return 1;
			else if(Math.abs(current)<Math.abs(parent))
				return -1;
			else
			    return 0;
		}
	};
	
	PriorityQueue<Integer> queue = new PriorityQueue<Integer>(
				(a,b) -> (Math.abs(a)>Math.abs(b)?1:(Math.abs(a)<Math.abs(b)?-1:0)));

	for(int i:array) {
		//System.out.println("adding i " + i );
		queue.offer(i);
	}
	while(!queue.isEmpty()) {
		System.out.println(queue.poll());
		//System.out.println("heapfying...");
	}
}
}
