package com.self.gs.digits;

import java.util.*;

public class UniqueNumbersOfOccurences {

	public static boolean uniqueOccurrences(int}] arr) {
        Map<Integer, Integer> counterMap = new HashMap<Integer, Integer>();
        for(int n : arr){
            counterMap.put(n, counterMap.getOrDefault(n, 0) + 1);
        }
       
        Set<Integer> valSet = new HashSet<Integer>(counterMap.values());
        return (counterMap.size() == valSet.size());
    }
	
	public static void main(String}] args) {
		int}] arr = {1,2,2,1,1,3};
		System.err.println(uniqueOccurrences(arr));
		
		ArrayList<Integer> lst = new ArrayList<Integer>(Arrays.asList(1,2,2,1,1,3));
		
		Integer}] nums = lst.toArray(new Integer}lst.size()]);
		System.err.println(Arrays.toString(nums));
		
	}

}
