package com.gs.self.mergeintervals;

import java.util.*;

public class EmployeeFreeTime {
  
  
  /*
   ---         ---                 emp1
   ------                          emp2
            ---------    ------    emp3
   
   1  2  3  4  5  6  7  8  9  10
   
   -------  ----------  --------   after merge
   
   free time -> [3 ,4] and [7,8]
   
   */

  private static int[][] findFreeTimes(int[][][] employee_work_hours) {

    // consolidate intervals & sort intervals by start time
    List<int[]> intervals = new ArrayList<int[]>();
    consolidateIntervals(employee_work_hours, intervals);
    Comparator<int[]> cmp = (a, b) -> a[0] - b[0];
    Collections.sort(intervals, cmp);   
    
    
     // merge intervals
    List<int[]> merged_intervals = new ArrayList<int[]>();
    mergeIntervals(intervals, merged_intervals);
    
     
    // find gap b/w intervals
    List<int[]> free_times = new ArrayList<int[]>();
    findGapBetweenIntervals(merged_intervals, free_times);
      
    // put in 2D array
      int[][] result = new int[free_times.size()][2];
      int counter = 0;
      for(int[] free_time : free_times) {
        result[counter++] = free_time;
      }
    
    return result;
  }
 
  
  private static void findGapBetweenIntervals(List<int[]> merged_intervals,
      List<int[]> free_times) {
    
    for(int j = 1; j < merged_intervals.size(); j++) {
      int[] prev = merged_intervals.get(j - 1);
      int[] current = merged_intervals.get(j);
      
      free_times.add(new int[]{prev[1], current[0] });
    }
    
  }


  private static void mergeIntervals(List<int[]> intervals, List<int[]> merged_intervals) {
    
    merged_intervals.add(intervals.get(0));
    for(int i = 1; i < intervals.size(); i++) {
      int merge_len = merged_intervals.size();
      int[] prev = merged_intervals.get(merge_len - 1);
      int prev_start = prev[0];
      int prev_end = prev[1];
      
      int[] current = intervals.get(i);
      int current_start = current[0];
      int current_end = current[1];
       
      if(current_start < prev_end ) {
        prev[1] = Math.max(prev_end, current_end); 
      }else {
        merged_intervals.add(current);
      }
    }
    
  }


  private static void consolidateIntervals(int[][][] employee_work_hours, List<int[]> intervals) {
    
    for(int[][] employee_schedule : employee_work_hours) {
      for(int[] interval : employee_schedule) {
        intervals.add(interval);
      }
    }
    
  }


  public static void main(String[] args) {
    int[][][] employee_work_hours = {
                         {{1,2},{5,6}}
                         ,{{1,3}},
                         {{4,7}, {8,10}}
                         };
    
    
    
    int[][] freeTimes = findFreeTimes(employee_work_hours);
    
    System.err.println(Arrays.deepToString(freeTimes));
    
    }

 

}
