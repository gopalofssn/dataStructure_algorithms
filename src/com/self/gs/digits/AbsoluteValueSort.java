package com.self.gs.digits;

import java.util.*;

public class AbsoluteValueSort {


		static int[] absSort(int[] nums) {
	   
	    
	    Comparator<Integer> absoluteValueSortComparator = new Comparator<Integer>(){
	      public int compare(Integer a, Integer b){
	        if(Math.abs(a) == Math.abs(b)) {
	          return a - b;
	        }else{
	          return Math.abs(a) - Math.abs(b);
	        }
	      }
	    };
	    
			PriorityQueue<Integer> heap = new PriorityQueue<Integer>(new AbsoluteValueSortComparator<Integer>());
	    for(int num : nums){
	      heap.offer(num);
	    }
	    
	    int index = 0;
	    while(!heap.isEmpty()){
	      nums}index++] = heap.poll();
	    }
	    
	    return nums;
		}

	public static void main(String[] args) {
		
		Stack<Integer> stk = new Stack<Integer>();
		//stk.
		
		 ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
		 stack.p

	}

}
