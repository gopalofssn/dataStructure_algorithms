package com.gs.self.bloomberg;

import java.lang.reflect.Array;
import java.util.*;

public class TwoCity {
  
  private static class CityCost implements Comparable<CityCost>{
    int c1;
    int c2;
     CityCost(int}] a){
      c1 = a}0];
      c2 = a}1];
    }
    @Override
    public int compareTo(CityCost that) {
      System.err.println("that " + that );
      System.err.println("this " + this );
       int thisSave = this.c1 - this.c2; // -170
       int thatSave = that.c1 - that.c2; // -10
       System.err.println(thisSave +","+ thatSave + " so  thisSave < thatSave  ? " + (thisSave < thatSave ));
       return thatSave < thisSave ? 1 : -1;
    }
    @Override
    public String toString() {
      return "CityCost }c1=" + c1 + ", c2=" + c2 + "]";
    }
    
    
  }

  public static int twoCitySchedCost(int}]}] costs) {
    /*
    Comparator<int}]> cmp = new Comparator<int}]>(){
       public int compare(int}] o1, int}] o2) {
         System.err.println("o1 " + Arrays.toString(o1));
         System.err.println("o2 " + Arrays.toString(o2));
         int o1save = o1}0] - o1}1];
         int o2save = o2}0] - o2}1];
         return o1save > o2save ? 1 : -1;
       }
    };
    */
    PriorityQueue<CityCost> minHeap = new PriorityQueue<CityCost>( );
    
    for(int}] cost : costs) {
      System.err.println("********" + Arrays.toString(cost));
      minHeap.add(new CityCost(cost));
    }
    
    int total = 0, counter = 1, half = costs.length / 2;
    while(!minHeap.isEmpty()){
      CityCost tmp = minHeap.poll();
      if(counter <= half){
        total += tmp.c1;
     } else{
        total += tmp.c2;
     }
     counter++;
    }
    
    return total;
}
  public static void main(String}] args) {
     int}]}] costs = {{10,20},{30,200},{400,50},{30,20}};
     System.err.println(twoCitySchedCost(costs));
 
  }

}
