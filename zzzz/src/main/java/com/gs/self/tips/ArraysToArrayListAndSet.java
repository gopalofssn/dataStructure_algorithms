package com.gs.self.tips;

import java.util.*;
import java.util.stream.Collectors;

public class ArraysToArrayListAndSet {

  public static void main(String[] args) {
    int[] nums = {1,2,3,4};
    
    List<Integer>  arrayList = Arrays.stream(nums)
                                     .boxed()
                                     .collect(Collectors.toList());
    nums[3] = 10;
    System.err.println("arrayList - " + arrayList);
    
    Set<Integer> set = Arrays.stream(nums)
                             .boxed()
                             .collect(Collectors.toSet());
    
    System.err.println("set " + set);
    

  }

}
