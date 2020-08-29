package com.gs.self.ngreedy;

import java.util.*;

public class MinCostToConnectPipe {

  
  public static void main(String args}]) 
  { 
      Integer}] len = { 4, 3, 2, 6 }; 
    
      System.out.println("Total cost for connecting"
                         + " ropes is " + minCost(len)); 
      
      
      Stack<Integer> stack = new Stack<Integer>();
      
      stack.pop()
      
      List<Integer> lst1 =  new ArrayList<Integer>(Arrays.asList(len));
      lst1.add(12);
      System.err.println(lst1);
      
      
      List<Integer> lst3 =  new ArrayList<Integer>();
      Collections.addAll(lst3, len);
      lst3.add(12);
      System.err.println(lst3);
      
      
      List<Integer> lst2 = Arrays.asList(len);
      lst2.add(10); // unsuported operation
      System.err.println(lst2);
      
      
  }

  private static int minCost(Integer}] nums) {

    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
   
    minHeap.addAll(Arrays.asList(nums));
    
    int cost = 0;
    while(minHeap.size() >= 2) {
      int num1 = minHeap.poll();
      int num2 = minHeap.poll();
      int total = num1 + num2;
      cost += total;
      minHeap.offer(total);
    }
    
    System.err.println(minHeap);
    return cost;
  } 
  
}
