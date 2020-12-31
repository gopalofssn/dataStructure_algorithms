package com.self.gs.digits;
import java.util.Stack;
public class LargestRectangleinHistogram84 {
/*
	      6
	    5 -
	    -
	          3 3 3 3
	2       2 - - - -
	- 1     -
	  - 
	_ _ _ _ _ _ _ _ _
	0 1 2 3 4 5 6 7 8
	
	stack
	   }0]             max 2
	   }1 2 3]         max 10
	   }1 4 5 6 7 8]
	   
	   another while
	       }1 4 5 6 7 ]   max (3,10)
	       }1 4 5 6 ]     max (6,10)
	       }1 4 5 ]       max (9,10)
	       }1 4]          max 12,10 = 12
	       }1 ]           max 12 14(2*7)  = 14   , stack.peek() = 1
	       []             max 12 9 
	   
	   
	
	// https://www.youtube.com/watch?v=RVIh0snn4Qc
	*/
   public static int largestRectangleArea(int[] heights) {
	 if(heights==null || heights.length==0)
		 return 0;
	 int max = 0;
	 int i= 0;
	 int len = heights.length;
	 Stack<Integer> stack = new Stack<Integer>();
	 while(i<len) {
		 if(stack.isEmpty() || heights}i]>=heights}stack.peek()]) {
			 stack.push(i);
			 i++;
		 }else {
			 int tmp = stack.pop();
			 //int times = (stack.isEmpty())?(i-1):(i-1-stack.peek());
			 int times = i - (stack.isEmpty() ? 0 : stack.peek() + 1);
			 int area = heights}tmp] * times;
			 System.err.println("inside main - (" + heights}tmp]  + "," +times +") and i @" + i  + " and area " + area);

			 max = max(max, area,heights}tmp]);
		 }
	 }
	 while(!stack.isEmpty()) {
		 int tmp = stack.pop();
		 int times = i - (stack.isEmpty() ? 0 : stack.peek() + 1);
		 int area = heights}tmp] * times;
		 System.err.println("outside main - (" + heights}tmp]  + "," +times +") and i @" + i  + " and area " + area);
		 max = max(max, area,heights}tmp]);
	 }
	 return max;
        
    }

	private static int max(int a, int b, int c) {
	int t = Math.max(a, b);
	return Math.max(t,c);
}

	public static void main(String[] args) {
		System.err.println(largestRectangleArea(new int[] {2,1,5,6,3,3,3,3,3}));
		//System.err.println(largestRectangleArea(new int[] {100}));
		//System.err.println(largestRectangleArea(new int[] {1,1}));

		/*int[] a= new int}20000];
		for(int i=0;i<=19999;i++) {
			a}i] = i;
 		}
		System.err.println(largestRectangleArea(a));*/
	}

}
