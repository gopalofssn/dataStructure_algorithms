package improve_coding_skills;

/*
 Input: 2736
Output: 7236
Explanation: Swap the number 2 and the number 7.
    2 7 3 6
    7 7 6 6
 */
public class MaximumSwap {

	public static int maximumSwap(int num) {
         char[] nums = String.valueOf(num).toCharArray();
         int[] rightMax = new int[nums.length];
         int max = 0;
         for(int i = nums.length - 1; i >=0 ; i--) {
        	 max = Math.max(max, nums[i] - '0');
        	 rightMax[i] = max;
         }
         
         for(int i = 0 ; i < nums.length; i++) {
        	 if( (nums[i] - '0') >= rightMax[i] )  continue;
        	 int pos1 = i;
        	 int val = rightMax[i];
        	 
        	 int pos2 = helper(nums, i, val);
        	 swap(pos1, pos2, nums);
        	 break;
         }
         
         return Integer.parseInt(String.valueOf(nums));
    }
	
	private static void swap(int pos1, int pos2, char[] nums) {
		char tmp1 = nums[pos1];
		char tmp2 = nums[pos2];
		nums[pos1] = tmp2;
		nums[pos2] = tmp1;
	}

	private static int helper(char[] nums, int i, int val) {
		int pos = -1;
		while(i < nums.length) {
			if( (nums[i] - '0') == val) {
				pos = i;
			}
			i++;
		}
		return pos;
	}

	public static void main(String[] args) {
		System.out.println(maximumSwap(2736));
	}

}
