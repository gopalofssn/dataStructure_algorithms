package com.gs.self.tips;

import java.util.*;
import java.util.stream.Collectors;

public class ArraysFill {
/* 
 idx  0 1 2 3 4 5 6 7 8 9 
      1 1 1 1 1 1 1 1 1 1
          2 2 2 2 2   
 */
  public static void main(String[] args) {
    int[] dp = new int[10];
    Arrays.fill(dp, 1);
    System.err.println(Arrays.toString(dp));
    
    Arrays.fill(dp, 2, 7, 2);
    System.err.println(Arrays.toString(dp));
    
   // call(new int[]{1,2,3,4});
    
  }

private static int[][] call(int[] nums) {
  
  Set<Integer> al = Arrays.stream(nums).boxed().collect(Collectors.toSet());
  
  System.err.println(al);
  
  Set<Integer> unique = new HashSet<Integer>(new ArrayList<Integer>());
  
  
   return new int[0][];
  
}

}
