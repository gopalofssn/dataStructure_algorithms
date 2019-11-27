package com.self.gs.digits;

import java.util.*;

public class TwoSum {
 public static void main(String[] args) {
	int array[] = {1,2,5,3,7,4,8,9};
	int[] sol = twosumOneCombination(array,10);
	if(sol!=null)
	 System.out.println("position  -" + "["+sol[0]+","+sol[1]+"]" + "--> [" + array[sol[0]] + "," + array[sol[1]] + "]");
	else
	 System.out.print("no target found");
	
	List<int[]> sols = twosumAllCombination(array,10);
	System.err.println("there are " + sols.size() + " combinations");
	for (int i = 0; i <= sol.length; i++) {
		sol = sols.get(i);
		 System.out.println("position  -" + "["+sol[0]+","+sol[1]+"]" + "--> [" + array[sol[0]] + "," + array[sol[1]] + "]");

	}
	
	
}

private static int[] twosumOneCombination(int[] array, int target) {
	
	HashMap<Integer,Integer> map = new HashMap<Integer,Integer>(); // ;[what i have , where i have]
	for(int i=0 ; i<array.length;i++) {
		int diff = target-array[i]; // 9-1 = 8
		
		if(map.containsKey(diff)) {
			return new int[] {map.get(diff),i};
			
		}else {
			map.put(array[i], i); //  [1,0] , [2,1], [5,3] etc
		}
	}
	
	return null;
}
private static List<int[]> twosumAllCombination(int[] array, int target) {
	
	ArrayList<int[]> results = new ArrayList<int []>();

	
	HashMap<Integer,Integer> map = new HashMap<Integer,Integer>(); // ;[what i have , where i have]
	
	for(int i=0 ; i<array.length;i++) {
		int diff = target-array[i]; // 9-1 = 8
		
		if(map.containsKey(diff)) {
			results.add(new int[] {map.get(diff),i});
			
		}else {
			map.put(array[i], i); //  [1,0] , [2,1], [5,3] etc
		}
	}
	
	return results;
}
}
