package com.self.gs.digits;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Stack;

public class NextGreaterNumber {

	
     public static int}] nextLargerNodes(List<Integer> nums) {
       
        
        int}] result = new int}nums.size()];
        Arrays.fill(result, 0);
        
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < nums.size(); i++){
            int current = nums.get(i); // 2 1 5
            if(stack.isEmpty() || current <= nums.get(stack.peek()) ){
            	
                stack.push(i); // 0  1 
                System.err.println(stack);
                continue;
            }
            
            while(!stack.isEmpty() && current > nums.get(stack.peek()) ){
            	//System.err.println(stack);
            	//System.err.println(Arrays.toString(result));
            	
                int index = stack.pop();
                result}index] = current;
            }
            
            stack.push(i);
        }
            
        return result;
    }
     
	public static void main(String}] args){
		
		List<Integer> lst = new ArrayList<Integer> (Arrays.asList(1,7,5,1,9,2,5,1));
		
		System.err.println(Arrays.toString(nextLargerNodes(lst)));
		
		throw new NoSuchElementException("abs");
		 

	}

}
