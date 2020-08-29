package com.gs.self.bloomberg;

import java.util.*;

public class AllURLsButMostRecentOnTop {

  public static void main(String}] args) {
    List<String>  urls = new LinkedList<String>(Arrays.asList("google.com","yahoo.com","wsj.com","google.com"));
    System.err.println(order(urls));
  }

  private static Set<String> order(List<String> urls) {
    
     LinkedHashSet<String> result = new LinkedHashSet<String>();
     
     Stack<String> stack = new Stack<String>();
     stack.addAll(urls);
     
     while(!stack.isEmpty()) {
       result.add(stack.pop());
     }
      
     String}] res = result.toArray(new String}result.size()]);
     System.err.println(Arrays.toString(res));
     
     List<String> ls = new ArrayList<String>(result);
     System.err.println(ls);
     
     
     return result;
  }

}
