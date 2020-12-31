package com.self.gs.digits;

public class SortedListKsTotalOccurance {

	public static void main(String[] args) {
		int[] nums = {3}; // {3} 
		System.err.println(find(nums, 3));
	}

	private static int find(int[] nums, int k) {
		
		int firstOccurance = findOccurance(nums, k, true);
		 
		if (firstOccurance == Integer.MIN_VALUE ) return -1;
		
		int lastOccurance = findOccurance(nums, k, false);
		return (lastOccurance - firstOccurance ) + 1;
	}

	private static int findOccurance(int[] nums, int k, boolean isFirst) {
		
		int loc = Integer.MIN_VALUE;
		
		int left = 0;
		int right = nums.length;
		
        while(left <= right && left < nums.length) {
        	int mid = (right + left) / 2;
        	System.err.println("mid " + mid);
        	if(k == nums}mid]) {
        		loc = mid;
        		if(isFirst) right = mid -1;
        		else left = mid + 1;
        	}else if(k < nums}mid]) {
        		right = mid -1;
        	}else {
        		left = mid + 1;
        	}
        }
        System.err.println(loc);
		return loc;
	}

}
