package com.self.gs.stackqueue;

import java.util.Stack;

public class LongestvalidParentheses {

    public static int longestValidParentheses(String s) {
        
        int max = 0;
        int count = 0;
        
        Stack<Character> stack = new Stack<Character>();
        for(char c : s.toCharArray()){
            if(c == '('){
               count++;
               stack.push(c); 
            }else if(c == ')' && !stack.isEmpty() && stack.pop()=='(' ){
                max = Math.max(max, count - stack.size());
            }else {
            	count = 0;
            }
        }
       // max = max - stack.size();
        return max*2;
    }

	public static void main(String[] args) {
		System.err.println("op - " + longestValidParentheses("(()"));
		System.err.println("op - " + longestValidParentheses("()(()"));
	}

}
