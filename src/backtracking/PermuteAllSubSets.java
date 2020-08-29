package backtracking;

import java.util.ArrayList;
import java.util.List;

/*
      [ A, B, C]
      
                []
        [A]         [B]   [C]    l1   index :          0...2
    [A,B] [A,C]   [B,C]          l2   index : 1..2 on 0   2 on 1  just 2     
 [A,B,C]                         l2   index   2                  
 
     - Generate all , recursive call
     - 
     
 */
public class PermuteAllSubSets {

	private static List<List<Character>> subSets(char[] nums) {
           if(nums == null || nums.length == 0) return null;
           List<List<Character>> result = new ArrayList<List<Character>>();
           helper(nums, new ArrayList<Character>(), result, 0);
           return result;
	}

	private static void helper(char[] nums, ArrayList<Character> current, List<List<Character>> result, int start) {
		result.add(new ArrayList<Character>(current));  
		for(int index = start; index < nums.length; index++) {
			current.add(nums[index]);  
			helper(nums, current, result, index + 1);
			current.remove(current.size() - 1); 
		}
		
	}

	public static void main(String[] args) {
		char[] nums = { 'A', 'B', 'C', 'D'};
		List<List<Character>> result = subSets(nums);
		for(List<Character> l : result) {
			System.err.println(l);
		}
	}

}
