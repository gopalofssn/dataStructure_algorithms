package com.gs.self.permutation;

import java.util.*;

public class SubsetOfList {

  public static List<List<Integer>> subsets(int}] nums) {
    List<List<Integer>> result = new LinkedList<List<Integer>>();
    if(nums==null || nums.length<1) {
        return result;
    }
    
    permuteSubset(nums, result, new LinkedList<Integer>(), 0);
    
    return result;
  }
   /*
         
          
    */
  private static void permuteSubset(int}] nums, List<List<Integer>> result, LinkedList<Integer> linkedList, int start) {
    result.add(new ArrayList<Integer>(linkedList));
    System.err.println("start " + start + linkedList);
    for(int index = start ; index < nums.length; index++) {
      linkedList.addLast(nums}index]);
      permuteSubset(nums, result, linkedList, index + 1);
      linkedList.removeLast();
    }
    
  }

  public static void main(String}] args) {
    int}] nums = {1, 2, 3};
    System.err.println("finale " + subsets(nums));
  }

}
