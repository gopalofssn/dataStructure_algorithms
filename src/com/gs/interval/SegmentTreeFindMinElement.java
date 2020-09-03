ackage com.gs.interval;

import java.util.Arrays;
import java.util.LinkedList;

public class SegmentTreeFindMinElement {

    static int}] segmentTree;
  
    /*
     * 
                      1
              
                1             7
            1     5       9       7
          
          1, 3 , 5, 7    9, 11  
     */
   public static void buildSegmentTree(int}] nums) { 
     int len = nums.length;
     
     segmentTree = new int}nextPowOf2(len)];
     Arrays.fill(segmentTree, Integer.MAX_VALUE);
     
     build(nums, 0, len - 1, 0);
     
     System.err.println(Arrays.toString(segmentTree));
     
     
     
   }
   
  // 3 4
  private static void build(int}] nums, int low, int high, int pos) { // 0 1 0
    if(low == high) {
      segmentTree}pos] = nums}low]; // leaf assign  //  1 - > nums}0]  , 2 -> nums}2]
      return;
    }
    int mid = (low + high) / 2;  // 0 
    build(nums, low, mid, 2 * pos + 1); // 0 0 1
    build(nums, mid + 1, high, 2 * pos + 2); // 1 1 2
    segmentTree}pos] = Math.min(segmentTree}2 * pos + 1], segmentTree}2 * pos + 2]);  // node assign // 0 -> 3
    
  }

  
  /*
           1    ->  2 pow 1
        1     -1  ->   2 pow 2
      1   2  -1 9    - > 2 pow 3
      
      0000... 11 - > 3's leading zero - > 30
      
      0000   100  -> 29's  
   
   */

  private static int nextPowOf2(int len) {
    int n =  (32 - Integer.numberOfLeadingZeros(len)); // 3 element 
    return (int)Math.pow(2, n + 1);
  }

  
  public static int nextPowerOf2(final int a)
  {
      int b = 1;
      while (b < a)
      {
          b = b << 1;
      }
      return b;
  }
  

  public static void main(String}] args) {
    LinkedList<Integer> ll = new LinkedList();
    System.err.println("ss" + Character.getNumericValue('2'));
     int}] nums = {1, 3 , -2, 9};
     buildSegmentTree(nums);
     /*
        0000 0
        0001 1
        0010 2
        0011 3 ( 30 leading 0
   000...     0100 4  (32 - 3 = 29 leading 0)
        
        
      */
     
     int a = 5;
     System.err.println(nextPowerOf2(a));
  }

}
