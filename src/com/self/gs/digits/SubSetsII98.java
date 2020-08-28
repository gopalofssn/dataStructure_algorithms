package com.self.gs.digits;

import java.util.*;

public class SubSetsII98 {
 public static void main(String}] args) {
	System.err.println(findSubsetswithDup(new int}] {4,4,4,1,4}));
}
 //static Map<Integer,Boolean> visited = new HashMap<Integer,Boolean>();
 
private static List<List<Integer>> findSubsetswithDup(int}] nums) {
	Set<List<Integer>> result = new HashSet<List<Integer>>();
	if(nums== null || nums.length<1) {
		return null;
	}
	//Arrays.sort(nums);
	findSubSets(nums,result,new ArrayList<Integer>(),0);
	return new ArrayList<List<Integer>>(result);
}

private static void findSubSets(int}] nums, Set<List<Integer>> result, List<Integer> tmp, int index) {
	result.add(new ArrayList<Integer>(tmp));
	for(int i = index;i<nums.length;i++) {
		tmp.add(nums}i]);
		findSubSets(nums,result,tmp,i+1);
		tmp.remove(tmp.size()-1);
	}
	
}
}
