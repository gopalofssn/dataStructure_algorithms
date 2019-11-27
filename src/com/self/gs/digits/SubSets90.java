package com.self.gs.digits;

import java.util.*;

/*
      1  2   2
    2    1
   2     2
   
   
 */
public class SubSets90 {
	public static List<List<Integer>> subsetsWithDup(int[] nums) {
       /* List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums!=null && nums.length!=0){
        	backtrack(result,new ArrayList<>(),nums,0);
        }
        Arrays.sort(nums);
        return result;
        */
        List<List<Integer>> list = new ArrayList<>();
	    Arrays.sort(nums);
	    backtrack(list, new ArrayList<>(), nums, 0);
	    return list;
	    
    }
    
	/*  private static void findSubSets(int[] nums,List<List<Integer>> list, List<Integer> tempList, int start){
    	list.add(new ArrayList<>(tempList));
	    for(int i = start; i < nums.length; i++){
	        if(i > start && nums[i] == nums[i-1]) 
	        	continue; // skip duplicates
	        tempList.add(nums[i]);
	        findSubSets(nums,list, tempList, i + 1);
	        tempList.remove(tempList.size() - 1);
	    }
    }
	/*public static List<List<Integer>> subsetsWithDup(int[] nums) {
	    List<List<Integer>> list = new ArrayList<>();
	    Arrays.sort(nums);
	    backtrack(list, new ArrayList<>(), nums, 0);
	    return list;
	}
*/
	private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int start){
	    list.add(new ArrayList<>(tempList));
	    for(int i = start; i < nums.length; i++){
	        if(i > start && nums[i] == nums[i-1]) 
	        	continue; // skip duplicates
	        tempList.add(nums[i]);
	        backtrack(list, tempList, nums, i + 1);
	        tempList.remove(tempList.size() - 1);
	    }
	} 
	
	public static void main(String[] args) {
		System.err.println(subsetsWithDup(new int[] {4,4,4,1,4}));
	}
}
