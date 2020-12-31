package com.gs.self.tips;

public class IntegerOverflow {

  public static void main(String[] args) {
    int left = 2126753390;
    int right = 1702766719;
    
    int mid = left + ( (right - left) / 2);
    
    System.err.println(mid);

  }

}
