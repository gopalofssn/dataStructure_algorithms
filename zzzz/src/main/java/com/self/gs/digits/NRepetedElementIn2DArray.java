package com.self.gs.digits;
import java.util.*;
public class NRepetedElementIn2DArray {
   public static int repetedElement(int[] nums) {
	  
	   Set<Integer> holder = new HashSet<Integer>();
	   for(int n:nums) {
		  if(!holder.add(n)) {
			return n;  
		  }
		  
	   }
	   return Integer.MAX_VALUE;
   }
   public static void main(String arg[] ){
	 int[] input = {1,2,3,5,5,6,7,8};
	 System.out.println(repetedElement(input));
   }
}
