package code;

import java.util.*;
/*
  input [2 3 5] , target 8
  output
    [2 2 2 2]
    [2 3 3]
    [3 5]
 */
public class CombinationSum {
	/*
    approch 1
    ------
      7 can be made from 
        7 
          do we have 7? yes, one solution is just 7
          eliminate 7 
        < 7 numbers
           2 3 6 - SEARCH LIST
               to make 7 from 6 , what we need ? 1, 
                do we have 1 ? no,
                do we have numbers that make 1 ? no,
                 remove  6.
           2 3 - SEARCH LIST
              to make 7 from 3 , we need  4 , 
                  do we have 4? no 
                  do we have numbers that make 4? yes , 2 times 2
              one solution is ,, 3 2 2 
               remove 3
         2
           can we make 7 from just 2 ? no 
           
           this above approach is big and take lots of time to resolve/.. :(
  
  approach 2:
  ----
       prime number
         we can make any numbers from combinations of prime numbers.
          but how do we know what are prime number ? 
          but non prime numbers also can be aprt of it ... :)
          
  approach 3: dfs recurssive
  ---------
  keep using number untill , we can not use,
  what it mean ? 
    to form 8 , can i use 2? 
                        [2 3 5] 
       0/                 
   6  [2]   \              
    0 |
   4  [2 , 2]  \ 3 X  \ 5 X
    0 |
  2  [2, 2, 2]  \ 3   \ 5
     0 |          
  0  [2 ,2 ,2 ,2]  -1   -3
   
           
            
    */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0) return new ArrayList<List<Integer>>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        helper(candidates, 0, new LinkedList<Integer>(), target, result);
        return result;
    }
    
    private void helper(int[] candidates, int index, LinkedList<Integer> current, int target, List<List<Integer>> result){
        if(target == 0){
            result.add(new ArrayList<Integer>(current));
            return;
        }else if(target < 0 || index >= candidates.length){
            return;
        }else {
           int val = candidates[index];
           current.addLast(val);
           helper(candidates, index, current, target - val, result);
           current.removeLast();
           helper(candidates, index + 1, current, target, result);
        }
        
    }
    
    public static void main(String[] args) {
		System.out.println(new CombinationSum().combinationSum(new int[]{2, 3, 5}, 8));
	}
}
