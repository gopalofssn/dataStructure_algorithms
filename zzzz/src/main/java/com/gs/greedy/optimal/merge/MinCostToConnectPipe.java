package com.gs.greedy.optimal.merge;

import java.util.*;

public class MinCostToConnectPipe {

	  private static int minCost(int[] nums) {
		    Comparator<Integer> cmp = (a, b) -> (a - b);
			PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(cmp);
			for(int num : nums){
				minHeap.offer(num);
			}
			int cost = 0;
			while(minHeap.size() >= 2){
				int num1 = minHeap.poll();
				int num2 = minHeap.poll();
				int totalNum = num1 + num2;
				cost += totalNum;
				minHeap.offer(totalNum);
			}
			return cost;
		}
 
	  public static void main(String args[]) 
	  { 
	      int[] nums = { 4, 3, 2, 6 }; 
	      System.out.println("Total cost for connecting"
	                         + " ropes is " + minCost(nums)); 
	  }
}
