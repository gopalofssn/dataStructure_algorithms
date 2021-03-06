package com.self.gs.string;
/*
 Example 1:

Input: s = "RLRRLLRLRL"
Output: 4
Explanation: s can be split into "RL", "RRLL", "RL", "RL", each substring contains same number of 'L' and 'R'.
Example 2:

Input: s = "RLLLLRRRLR"
Output: 3
Explanation: s can be split into "RL", "LLLRRR", "LR", each substring contains same number of 'L' and 'R'.
Example 3:

Input: s = "LLLLRRRR"
Output: 1
Explanation: s can be split into "LLLLRRRR".
Example 4:

Input: s = "RLRRRLLRLL"
Output: 2
Explanation: s can be split into "RL", "RRRLLRLL", since each substring contains an equal number of 'L' and 'R'
 

Constraints:

1 <= s.length <= 1000
s}i] = 'L' or 'R'
 */
import java.util.Stack;

public class BalancedString1221 {
	/*
	 RLLLLRRRLRL
	 RL LLLRRR LR L
	   - totaly 3
	 */
	private static int balancedStringCount(String s) {
		if(s == null || s.isEmpty()){
			return 0;
		}
		Stack<Character> stack = new Stack<Character>();
		int result = 0;
		for(char c : s.toCharArray()){
			if(stack.isEmpty() || stack.peek() == c){
				stack.push(c);
			}else{
				stack.pop();
			}
			
			if(stack.isEmpty()){
				result++;
			}
		}
		
		return result;
	}

  public static void main(String[] args) {
	  String s = "RLLLLRRRLRLL";
	  System.err.println(balancedStringCount(s) ); // 3
  }

}
