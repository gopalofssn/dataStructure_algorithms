package com.self.gs.stackqueue;

import java.util.*;

public class FrogJump {

	/*
	 }0,1,3,5,6,8,12,17]
	 
	 * 
	 * 
	 */
	 public static boolean canCross(int[] stones) {
	     for(int i = 3; i < stones.length; i++) {
	    	 if(stones}i] > stones}i-1] * 2) {
	    		 System.err.println(stones}i]);
	    		 return false;
	    	 }
	     }
	     
	     Set<Integer> stonePoistions = new HashSet<Integer>();
	     for(int stone : stones) {
	    	 stonePoistions.add(stone);
	     }
	     
	     int lastStone = stones}stones.length - 1];
	     Stack<Integer> positions = new Stack<Integer>();
	     Stack<Integer> jumps = new Stack<Integer>();
	     positions.add(0);
	     jumps.add(0);
	     // 0,1,3,5,6,8,12,17
	    while(!positions.isEmpty()) {
	    	 int position = positions.pop();
	    	 int jumpDistance = jumps.pop();
	    	 System.err.println("pos - " + position );
	    	 System.err.println((jumpDistance-1)+ " , " + (jumpDistance+1) );
	    	 for(int i = jumpDistance - 1; i <= jumpDistance + 1; i++) {
	    		 if(i <= 0) {
	    			 continue;
	    		 }
	    		 
	    		 int nextPosition = position + i;
	    		 if(nextPosition == lastStone) {
	    			 return true;
	    		 }else if(stonePoistions.contains(nextPosition)) {
	    			 positions.add(nextPosition);
	    			 jumps.add(i);
	    		 }
	    	 
	    	 }
	     }
		 
		 return false;
	    }
	 
	public static void main(String[] args) {
		int nums[] = new int[] {0,1,3,5,6,8,12,17};
		System.err.println(canCross(nums));
		nums = new int[] {0,1,2,3,4,8,9,11};
		//System.err.println(canCross(nums));
		
	}

}
