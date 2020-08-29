package com.gs.self.tips;

import java.util.Arrays;

public class ArrayCopy {

  public static void main(String[] args) {
    int[] src = {1,2,3,4,5,6};
    int[] dest = new int[src.length];
    
    System.arraycopy(src, 2, dest, 1, 2);
    
    src[3] = 44;
    System.err.println("dest " + Arrays.toString(dest));

    dest = src;
    src[3] = 44;
    
    System.err.println(Arrays.toString(src));
    System.err.println(Arrays.toString(dest));
    
    dest = src.clone();
    src[4] = 55;
    
    System.err.println(Arrays.toString(src));
    System.err.println(Arrays.toString(dest));
    
    
  }

}
