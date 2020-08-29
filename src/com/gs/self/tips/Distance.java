package com.gs.self.tips;

import java.util.*;

public class Distance {

  public static void main(String[] args) {
    String src = "ABCDEF";
    String target = "ABCEFFG";
    int p = 0;
    int q = 0;
    
    Stack<Character> sourceStack = new Stack<Character>();
    Stack<Character> targetStack = new Stack<Character>();
     
    populateStack(sourceStack, src);
    populateStack(targetStack, target);
    
    List<String> list = new ArrayList<String>();
    /*
     "ABCD";
     "ABC";
     */
    while(!sourceStack.isEmpty() && !targetStack.isEmpty()) {
      if(sourceStack.peek() == targetStack.peek()) {
        char c = sourceStack.pop();
        targetStack.pop();
        list.add(String.valueOf(c));
      }else {
        
        while(!targetStack.isEmpty() && sourceStack.peek() != targetStack.peek()) {
          char c = targetStack.pop();
          list.add("+" + String.valueOf(c));
        }
        
      }
    }

  }

  private static void populateStack(Stack<Character> stack, String S) {
     for(char c : S.toCharArray()) {
       stack.push(c);
     }
    
  }

}
