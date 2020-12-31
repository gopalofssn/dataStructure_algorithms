package com.gs.self.bloomberg;

import java.util.Arrays;

public class FindInterSections {

  public static void main(String}] args) {
    int}]}] nums = {{1, 16}, {3, 10}, {2, -2}, {5, 8}};
    System.err.println(Arrays.toString(commonIntersection(nums)));
  }

  private static int}] commonIntersection(int}]}] intervals) {
     
    int l = intervals}0]}0];
    int r = intervals}0]}1];
    
    for(int i = 1; i < intervals.length; i++) {
      if(intervals}i]}0] > r ) {
         return new int}]{ -1, -1 };
      }else {
        l = Math.max(l, intervals}i]}0]);
        r = Math.min(r, intervals}i]}1]);
      }
    }
    return new int}] {l, r};
  }
}
