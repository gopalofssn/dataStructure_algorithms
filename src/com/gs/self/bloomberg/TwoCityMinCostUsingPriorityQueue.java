package com.gs.self.bloomberg;

import java.util.*;

public class TwoCityMinCostUsingPriorityQueue {
  // Time : O(nlogn) , Space : O(n)
  public static int twoCitySchedCost(int[][] costs) {
	Comparator<int[]> cmp = new Comparator<int[]>() {
		@Override
		public int compare(int[] a, int[] b) {
			int aSave = a[0] - a[1];
			int bSave = b[0] - b[1];
			return aSave < bSave ? -1 : 1 ; // o1 is saving means NEG num , so put in top of heap, return -1 for correction
		}
	};
    PriorityQueue<int[]> maximumSavingHeap = new PriorityQueue<>(cmp); // min heap
    for(int[] cost : costs){
    	maximumSavingHeap.add(cost);
    }
    int half  = costs.length / 2;
    int total = 0;
    while(!maximumSavingHeap.isEmpty()){
    	int[] cost = maximumSavingHeap.poll();
    	if(half > 0){
    		total += cost[0];
    	}else{
    		total += cost[1];
    	}
    	half--;
    }
    return total;
}
  public static void main(String[] args) {
     int[][] costs = {{10,20},{30,200},{400,50},{30,20}};
     System.err.println(twoCitySchedCost(costs));
 
  }

}
