package backtracking;

import java.util.ArrayList;
import java.util.List;

public class _78SubSets {

  public static void main(String[] args) {
    
   int n =  "abcd".indexOf("ced");
    System.err.println(n);
    
    int[] nums = { 1, 2, 3};
    System.err.println(subSets(nums));

  }

  private static List<List<Integer>> subSets(int[] nums) {
    
    List<List<Integer>> subsets = new ArrayList<List<Integer>>();
    generateSub(0, nums, new ArrayList<Integer>(), subsets);
    
    return subsets;
  }

  private static void generateSub(int index, int[] nums, ArrayList<Integer> current, List<List<Integer>> subsets) {
    
   
    subsets.add(new ArrayList<Integer>(current)); // must do copy, beacuse we are doing add and delete in below for loop
    
      for(int i = index; i < nums.length; i++) {
        current.add(nums[i]);
        generateSub(i + 1, nums, current, subsets);
        current.remove(current.size() - 1);
      }
      
      System.err.println(current); 
  }

}
