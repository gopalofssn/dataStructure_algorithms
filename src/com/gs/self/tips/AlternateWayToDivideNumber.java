package com.gs.self.tips;

public class AlternateWayToDivideNumber {

  public static void main(String[] args) {
    //  8 -- bit val == 1000 , when we shift right >> 1 , it become 0100, which is 4
    //  9 - 1001 , 9/2 = 4, 100
    // 7, 0111 , divide by 2 , 11, 3
    
    System.err.println(8 >> 1);
    System.err.println( 9 >> 1);
    System.err.println( 7 >> 1);
     
    //  0100 >> 1,, 0010

  }

}
