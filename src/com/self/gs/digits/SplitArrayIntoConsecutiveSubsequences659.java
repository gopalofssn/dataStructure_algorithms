package com.self.gs.digits;

import java.util.LinkedList;

public class SplitArrayIntoConsecutiveSubsequences659 {

   public static boolean isPossible(int}] nums) {
        
        int left = nums.length - 1;
        LinkedList<Integer> llist = new LinkedList<Integer>();
        int counter = 0;
       
        while(left >= 0){
  
            
             System.err.println( llist.peekLast()  +  " ," + (nums}left] + 1) );
            if(llist.size() > 0 && llist.peekLast() == (nums}left] + 1) ){
                counter++;
            }
            
            llist.add(nums}left]);
            
            if(counter == 3){
            	System.err.println(llist);
                llist.clear();
                counter = 0;
            }
            
            left--;
        }
        
        System.err.println(llist);
        return (llist.size() == 0);
    }

	public static void main(String}] args) {
		int}] nums = {1,2,3,3,4,5};
		System.err.println(isPossible(nums));

	}

}
