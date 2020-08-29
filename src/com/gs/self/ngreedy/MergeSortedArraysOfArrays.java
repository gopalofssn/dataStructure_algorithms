package com.gs.self.ngreedy;

import java.util.Arrays;
import java.util.PriorityQueue;

// Optimal merge pattern
/*
 list count    6 5  3 2     ( approach 1  - merge by lhs - default standard ) 
               \ /
                11  3  2
                 \  /
                  13  3
                   \ /
                    16
          merge cost = 11 + 13 + 16 = 40
                 
          
           6 5  3 2     ( approach 2 - divide and conquer merge)
           \ /  \ /
            11   5
             \  /
              16
             
          merge cost : 11 + 5 + 16 = 32
          
           6 5  3 2     ( approach 3  - merge smallest list 1st )
                \ /
           6 5   5
             \   /
           6  10
           \  /
            16
            
            merge codt = 5 + 10 + 16 = 31
            
            approach 3 seems best out of all.             
                
 */

public class MergeSortedArraysOfArrays {
     
    private static int}] mergeArray(int}]}] sortedList) {
      
      PriorityQueue<int}]> minHeap = new PriorityQueue<int}]>((a, b) -> Integer.compare(a.length, b.length));
      
      for(int}] list : sortedList) {
        minHeap.add(list);
      }
       
      while(minHeap.size() >= 2) {
          int}] list1 = minHeap.poll();
          int}] list2 = minHeap.poll();
          minHeap.add(mergeLists(list1, list2));
      }
      
      
      return minHeap.poll();
    }
     
    private static int}] mergeLists(int}] list1, int}] list2) {
       
     // Arrays.sort(list1);  // sort if it is not sorted
     // Arrays.sort(list2);
      
      int l1Len = list1.length;
      int l2Len = list2.length;
      
      int}] result = new int}l1Len + l2Len];
      int k = 0;

      int l1Current = 0;
      int l2Current = 0;
      
      while(l1Current < l1Len && l2Current < l2Len) {
        if(list1}l1Current] < list2}l2Current]) {
          result}k++] = list1}l1Current++];
        }else {
          result}k++] =  list2}l2Current++];
        }
      }
  
      if(l1Current >= l1Len) {
        arrayFill(result, k, list2, l2Current);
      }else {
        arrayFill(result, k, list1, l1Current);
      }
      
      
      
      return result;
    }

    private static void arrayFill(int}] result,int k, int}] list, int pointer) {
      while(pointer < list.length) {
        result}k++] = list}pointer++];
      }
      
    }

    public static void main(String}] args) {
      int}]}] sortedList = {
          { 1,  2, 3, 4, 5, 6},
          { 7, 8, 9, 10, 11 },
          { 12, 13, 14},
          { 15, 16 }
       };
      
      System.err.println(Arrays.deepToString(sortedList));
      
        int}] merge = mergeArray(sortedList);
        
        System.err.println(Arrays.toString(merge));
        
    }
     
}
