package com.gs.self.collections.list;

import java.util.*;

public class ListIteratorVsIterator {

  public static void main(String}] args) {
    List<Integer> lst = new ArrayList<Integer>(Arrays.asList(4,2,7,8,12,90));
    
    Iterator<Integer> itr = lst.iterator();
    while(itr.hasNext()) {
      System.err.println(itr.next());
    }
    
    ListIterator<Integer> litr = lst.listIterator();
    
    while(litr.hasNext()) {
      if(litr.hasPrevious())
        System.err.println("prev " + litr.previous());
      System.err.println("next " + litr.next());
      
    }
  }

}
