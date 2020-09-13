package com.gs.bar.histogram;

import java.util.Arrays;

/*
 We are given an elevation map,heights[i]representing the height of the terrain at that index. 
 The width at each index is 1. AfterVunits of water fall at indexK, how much water is at each index?
Water first drops at index K and rests on top of the highest terrain or water at that index. 
Then, it flows according to the following rules:
     If the droplet would eventually fall by moving left, then move left.
     Otherwise, if the droplet would eventually fall by moving right, then move right.
     Otherwise, rise at it's current position.
     
     
     #               # 
     #       #   # # # 
     # #     #   # # # 
     # # # # # # # # # 
       2 1 1 2 1 2 2
  idx  0 1 2 3 4 5 6
  
  when 1st drop on index 3
     #               # 
     #       #   # # # 
     # #   W #   # # # 
     # # # # # # # # # 
       2 1 1 2 1 2 2
  idx  0 1 2 3 4 5 6  
  
  
    when 2nd drop on index 3
     #               # 
     #       #   # # # 
     # # W W #   # # # 
     # # # # # # # # # 
       2 1 1 2 1 2 2
  idx  0 1 2 3 4 5 6 
  
  
      when 3rd drop on index 3
     #               # 
     #       #   # # # 
     # # W W # W # # # 
     # # # # # # # # # 
       2 1 1 2 1 2 2
  idx  0 1 2 3 4 5 6 
  
  
        when 4th drop on index 3
     #       W       # 
     #       #   # # # 
     # # W W # W # # # 
     # # # # # # # # # 
       2 1 1 2 1 2 2
  idx  0 1 2 3 4 5 6 
  
 */
public class PourWater {

	private static int[] find(int[] heights, int v, int k) {
		
		int[] leftMaxHeight = findLeftMaxHeight(heights);
		int[] rightMaxHeight = findRightMaxHeight(heights);
		int[] heightWaterCapacity = findEachIndexCapacity(heights, leftMaxHeight, rightMaxHeight);
		//System.out.println(" capacityForWater " + Arrays.toString(heightWaterCapacity));
		//[0, 1, 1, 0, 1, 0, 0]
		// 0  1  2  3  4  5  6
		int[] heightAfterPour = heights.clone();
		
		int i = k - 1;
		while(i >= 0 && v >= 0) {
			if(heightWaterCapacity[i] > 0) {
				int add = (v > heightWaterCapacity[i]) ? heightWaterCapacity[i] : v;
				heightAfterPour[i] += add;
				v -= add;
			}
			i--;
		}
		
		i = k + 1;
		while(i < heights.length && v >= 0) {
			if(heightWaterCapacity[i] > 0) {
				int add = (v > heightWaterCapacity[i]) ? heightWaterCapacity[i] : v;
				heightAfterPour[i] += add;
				v -= add;
			}
			i++;
		}
		
		if(v > 0) {
			heightAfterPour[k] += v;
		}
		return heightAfterPour;
	}

	private static int[] findEachIndexCapacity(int[] heights, int[] leftMaxHeight, int[] rightMaxHeight) {
		int[] heightWaterCapacity = new int[heights.length];
		for(int i = 0; i < heights.length; i++) {
			int min = Math.min(leftMaxHeight[i], rightMaxHeight[i]);
			int capacityForWater = (min - heights[i]);
			if(capacityForWater > 0) {
				heightWaterCapacity[i] = capacityForWater;
			}
		}
		return heightWaterCapacity;
	}

	private static int[] findRightMaxHeight(int[] heights) {
		int[] rightMaxHeight = new int[heights.length];
		int max = 0;
		for(int i = heights.length - 1; i >=0; i--) {
			max = Math.max(max, heights[i]);
			rightMaxHeight[i] = max;
		}
		return rightMaxHeight;
	}

	private static int[] findLeftMaxHeight(int[] heights) {
		int[] leftMaxHeight = new int[heights.length];
		int max = 0;
		for(int i = 0; i < heights.length; i++) {
		  max = Math.max(max, heights[i]);
		  leftMaxHeight[i] = max;
		}
		return leftMaxHeight;
	}

	public static void main(String[] args) {
		int[] heights = { 2,1,1,2,1,2,2 }; 
	    int V = 4; // V units water poured 
	    int K = 3;// on index K
	    int[] heightAfterPour = find(heights, V, K);
	    System.out.println(Arrays.toString(heightAfterPour));
	}

}
