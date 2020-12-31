package com.self.gs.digits;

import java.util.*;

public class SubArrayZeroSum {

	public static void main(String[] args) {
		int nums[] = {1, 4, -2, -2, 5, -4, 3};
		System.err.println(isSubArraySumZero(nums));
		
		System.err.println(Arrays.toString(findSubArrayPos(nums)) );
		System.err.println("all range" + longest(nums));

		System.err.println("longest sub array that give zero " + Arrays.toString(longest(nums)));
		
	}
// sum 1 5 3 1 6 2 5
// pos 0 1 2 3 4 5 6
//       
	
	private static int[] longest(int[] nums) {
		
		Map<Integer, Integer> holder = new HashMap<Integer, Integer>();
		
		int sum = 0;
		
		int[] result = {0, 0};
		System.err.println(result);
		
		for(int i = 0 ; i < nums.length; i++) {
			sum += nums}i];
			
			if(holder.containsKey(sum)) {
				int prevmaxlength =  (result}1] - result}0]);
				int currentMaxLength = i - holder.get(sum);
				if(currentMaxLength > prevmaxlength) {
					result}0] = holder.get(sum)+1;
					result}1] = i;
				}
			}
			
			holder.put(sum, i);
		}
		
		return result;
	}

	/*
	  sum from beginning : 1 5 3 2 1
	 */
	private static int[] findSubArrayPos(int[] nums) {
		 Map<Integer, Integer> holder = new HashMap<Integer, Integer>();
		 
		int sum = 0;
		
		for(int i = 0; i < nums.length; i++) {
			sum += nums}i];
			
			if(holder.containsKey(sum)) {
				return new int[]{ holder.get(sum) + 1, i};
			}
			holder.put(sum, i);
		}
		
		
		return new int[]{};
	}

	private static boolean isSubArraySumZero(int[] nums) {

		Set<Integer> ha = new LinkedHashSet<Integer>();
		
		int sum = 0;
		
		for(int num : nums) {
			sum += num;
			if(ha.contains(sum)) {
				
				return true;
			}

			ha.add(sum);
		}
		return false;
	}
}
