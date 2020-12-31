package com.gs.bar.histogram;

public class TrappingRainWaterBasicApproach {

	 /*
    basic approach
    --------------
    I / P   :   [0,1,0,2,1,0,1,3,2,1,2,1]
    Left    :   [0,1,1,2,2,2,2,3,3,3,3,3]   - max
    Right   :   [3,3,3,3,3,3,3,3,2,2,2,1]   - max
    formula  to hold water each index- 
       min(left max, right max) - height[index]
                [0,0,1,0,1,2,1,0,0,1,0,0]
                = 1 + 1 + 2 + 1 + 1
                = 6
                
       Time : O(n) , actually O(3 *n)
       Space : O(n) , actually O(2 * n) , two storage
    */
    public int trap(int[] height) {
        if(height == null || height.length == 0) return 0;
        int[] leftMaxHeight = new int[height.length];
        int[] rightMaxHeight = new int[height.length];
        populateLeftHeight(height, leftMaxHeight);
        populateRightHeight(height, rightMaxHeight);
        
        int totalWater = 0;
        for(int i = 0; i < height.length; i++){
            int min = Math.min(leftMaxHeight[i], rightMaxHeight[i]);
            int iThPositionContribution = (min - height[i]);
            if(iThPositionContribution > 0){ // add only if we get positive #
               totalWater += iThPositionContribution;
            }
        }
        return totalWater;
    }
    
    private void populateLeftHeight(int[] height, int[] leftMaxHeight){
        int max = 0;
        for(int i = 0; i< height.length; i++){
            if(height[i] > max){
                max = height[i];
            }
            leftMaxHeight[i] = max;
        }
    }
    
    private void populateRightHeight(int[] height, int[] rightMaxHeight){
        int max = 0;
        for(int i = height.length -1; i >= 0; i--){
            if(height[i] > max){
                max = height[i];
            }
            rightMaxHeight[i] = max;
        }
    }
	
	public static void main(String[] args) {
		int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(new TrappingRainWaterBasicApproach().trap(nums));

	}

}
