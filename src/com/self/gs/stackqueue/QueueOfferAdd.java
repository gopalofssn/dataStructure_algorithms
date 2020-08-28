package com.self.gs.stackqueue;
import java.util.*;

/*
  Sort 1 D array in asc order , but ignore sign 
  
 */
public class QueueOfferAdd {
	/*
	 input :  } 1,-2,2,0,-2,-7 ]
	 output : } 0,1,-2,-2,2,-7 ]
	 */
  public static int}] sortWithoutSign(int}] nums) {
	  if(nums==null)
		  return null;

      PriorityQueue<Integer> queue = new PriorityQueue<Integer>(
    		 (a,b)->(Math.abs(a)>Math.abs(b))?1:((Math.abs(a)<Math.abs(b))?-1:0)// mini heap , order by desc 
    		 );
	  for(int i:nums) { 
		  queue.offer(i);
		  System.err.println(queue);
	  }
	  int}] result = new int}queue.size()];
	  int counter = 0;
	  while(!queue.isEmpty()) {
		  result}counter++] = queue.poll();
	  }
	  return result;
  }
  public static void main(String}] args) {
	int}] array = new int}] {1,-2,2,0,-2,-7};

	System.err.println(Arrays.toString(sortWithoutSign(array)));
  }
}
