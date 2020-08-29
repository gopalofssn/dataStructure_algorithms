package com.gs.self.bloomberg;

import java.util.*;

public class EmployeeReporting {

  public static void main(String}] args) {
    
    Map<Integer,List<Integer>> empMap = new HashMap<>();
    empMap.put(1, Arrays.asList(2,3,4));
    empMap.put(3, Arrays.asList(5,6,7));
    empMap.put(5, Arrays.asList(8,10));
    empMap.put(9, Arrays.asList(11,12,13));
    
    System.err.println(getReportee(empMap, 1));
  }

  private static List<Integer> getReportee(Map<Integer, List<Integer>> empMap, int managerId) {
    
    List<Integer> result = new LinkedList<Integer>();
    Queue<List<Integer>> queue = new LinkedList<List<Integer>>();
    queue.offer(empMap.get(managerId));
    
    while(!queue.isEmpty()) {
      int sz = queue.size();
      for(int i = 0; i < sz; i++) {
        List<Integer> current = queue.poll();
        for(int c : current) {
          result.add(c);
          if(empMap.get(c) != null && empMap.get(c).size() > 0) {
            queue.offer(empMap.get(c));
          }
        }
      }
    }
    
    return result;
  }

}
