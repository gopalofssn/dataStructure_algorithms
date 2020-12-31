package com.gs.stack;

import java.util.Stack;

/*
 * Time : O(m + n)
 * Space : O( m + n)
 *  where m and n are char length of strings s and t
 */
public class BackspaceStringTwoCompare {
	public boolean backspaceCompare(String S, String T) {
        if(isNullOrEmpty(S) || isNullOrEmpty(T)) return false;
        Stack<Character> sStack = new Stack<Character>();
        Stack<Character> tStack = new Stack<Character>();
        populateStack(sStack, S);
        populateStack(tStack, T);
        return compare(sStack, tStack);
    }
    
    private boolean isNullOrEmpty(String s){
        return (s == null || s.isEmpty());
    }
    
    private void populateStack(Stack<Character> stack, String s){
        for(char c : s.toCharArray()){
            if(c == '#'){
               if(!stack.isEmpty()) stack.pop();
            }else{
               stack.push(c);
            }
        }
    }
    
    private boolean compare(Stack<Character> sStack, Stack<Character> tStack){
        if(sStack.size() != tStack.size()) return false;
        while(!sStack.isEmpty() && !tStack.isEmpty()){
            char s = sStack.pop();
            char t = tStack.pop();
            if(s != t){
                return false;
            }
        }
        return true;
    }
	public static void main(String[] args) {
		System.out.println(new BackspaceStringTwoCompare().backspaceCompare("ab#c", "ad#c"));

	}

}
