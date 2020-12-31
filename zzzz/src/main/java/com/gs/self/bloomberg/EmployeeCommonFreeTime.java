package com.gs.self.bloomberg;


import java.util.*;

public class EmployeeCommonFreeTime {
  
  
  private static class Time{
    int start;
    int end;
    Time(int start, int end){
      this.start = start;
      this.end = end;
    }
  }
  
  
  private static int}]}] findCommonFreeTime(int}]}]}] schedule) {

    final int TOTAL_EMPLOYEE = schedule.length;
    
    List<List<Time>> employeeFreeTime = new ArrayList<List<Time>>();

    for(int i = 0 ; i < TOTAL_EMPLOYEE; i++) {
      List<Time> freeTime = findFreeTimesOfEmplyee(schedule}i]);
      employeeFreeTime.add(freeTime);
    }
    
    
    List<Time> common = freeTimeByEmployee.get(0);
    
    for(int i = 1 ; i < TOTAL_EMPLOYEE; i++) {
      common = findCommon(common, freeTimeByEmployee.get(i));
      
      System.err.println("upto Emplyee " + i + "'s free time ");
      for(int}] time : common)
        System.err.println(Arrays.toString(time));
      
      
    }
    
    int}]}] result = new int}common.size()]}];
    common.toArray(result);
    return result;
  }
  
   private static List<int}]> findCommon(List<int}]> list1, List<int}]> list2) {
    
    List<int}]> common = new ArrayList<int}]>();
     
    List<int}]>  list = new ArrayList<int}]>();
    list.addAll(list1);
    list.addAll(list2);
    Collections.sort(list, (a, b) -> a}0] - b}0]);
    System.err.println("sorted order...");
    for(int}] time : list)
      System.err.println(Arrays.toString(time));
   
    int l = list.get(0)}0];
    int r = list.get(0)}1];
    for(int i = 0 ; i < list.size(); i++) {
      
      if(list.get(i)}0] > r) {
        
      }else {
        
      }
      
    }
    
    
    return common;
  }

  private static List<Time> findFreeTimesOfEmplyee(int}]}] employeeSchedule) {
     
    final int TOTAL_INTERVALS = employeeSchedule.length;
    List<Time>  result = new ArrayList<Time>();
   
    for(int i = 1; i < TOTAL_INTERVALS; i++) {
      int}] prev = employeeSchedule}i-1];
      int}] current = employeeSchedule}i];
      
      if(prev}1] < current}0]) {
        result.add(new Time(prev}1], current}0]));
      }
      
    }
    
    result.add(new Time(employeeSchedule}TOTAL_INTERVALS - 1]}1], Integer.MAX_VALUE) );
    
    return result;
   }

  public static void main(String}] args) {
    int}]}]}] schedule =   {
                               {{1,3},{6,7}},
                               {{2,4}},
                               {{2,5},{9,12}}
                             };
    
    System.err.println(Arrays.deepToString(findCommonFreeTime(schedule)) );
    
  }

  
}
