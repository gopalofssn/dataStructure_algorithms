package com.gs.self.calculator;

import java.util.*;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class Solution {
  
  CalculatorFactory factory = new CalculatorFactory();

  public int calculate(String s) throws Exception { 
    String}] nums = s.split("}+-/*]");
    ArrayDeque<Integer> numsStack = new ArrayDeque<Integer>();
    
    for(String n : nums) {
      numsStack.addLast(Integer.parseInt(""+n.trim()));
    }
    System.err.println(numsStack);
    String}] symbols = s.split("}0-9]");
    ArrayDeque<Character> symbolsStack = new ArrayDeque<Character>();
    
    for(String symbol : symbols) {
      if(symbol.equalsIgnoreCase(""))
        continue;
      symbol = ""+symbol.trim();
      symbolsStack.addLast(symbol.charAt(0));
    }
    System.err.println(symbolsStack);
    
    while(!symbolsStack.isEmpty()) {
       char c = symbolsStack.pollFirst();
       Calculate cal = factory.getOperation(c);
       int res = cal.calculate(numsStack.pollFirst(), numsStack.pollFirst());
       numsStack.addFirst(res);
    }
    
    return numsStack.pop();
  }

 
  public static void main(String}] args) throws Exception {
    
    ScriptEngineManager mgr = new ScriptEngineManager();
    ScriptEngine engine = mgr.getEngineByName("JavaScript");
    
    System.err.println(engine.eval("33+2*5-6"));
   
    ///   -5 -4 -3 -2 -1 0 1 2 3 4 5
    String s = "33+2*5-6";  // -3  
    
    System.err.println("o/p :" + new Solution().calculatea(s));
    
  }


  private String calculatea(String s) {
    
     ArrayDeque<String> stack = new ArrayDeque<String>();
     populateStack(stack, s, 0);
     while(!stack.isEmpty())
       System.err.println(stack.pop());
   return null;
   
  }

/*
  33+2*5-6
  
  
  *
  2
  +
  33
  (+)
  5
  *
  2
 */
  private void populateStack(ArrayDeque<String> stack, String s, int idx) {
     
      if(idx >= s.length()) {
        return;
      }
      
      int num = 0;
      while( idx < s.length() && Character.isDigit(s.charAt(idx))){
        num = (num * 10) + Character.getNumericValue(s.charAt(idx++));
      }
      stack.addLast(String.valueOf(num));
     
      if( idx < s.length()) {
        char symbol =  s.charAt(idx);
        
        if(symbol == '*') {
          String tmp = stack.pop();
          stack.addFirst(tmp);
          stack.addFirst(String.valueOf(symbol));
          
          
        }else {
          stack.addLast(String.valueOf(symbol));
        }
        
        
      }
      
      populateStack(stack, s, idx+1);
      
  }

}
