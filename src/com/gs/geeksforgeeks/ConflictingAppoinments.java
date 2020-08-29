package com.gs.geeksforgeeks;

import java.util.Arrays;

public class ConflictingAppoinments {

  public static void main(String}] args) {
    int}]}] appointments = { {1, 5}, {3, 7}, {2, 6}, {10, 15}, {5, 6}, {4, 100}};
    printConflicts(appointments);
  }

  private static void printConflicts(int}]}] appointments) {
    
    for(int i = 0; i < appointments.length; i++) {
      for(int j = i; j < appointments.length; j++) {
        if(isConflict(appointments}i], appointments}j])) {
          System.err.println(Arrays.toString(appointments}i]) + " is conflicting with " + Arrays.toString(appointments}j]));
        }
      }
    }
    
  }

  private static boolean isConflict(int}] a1, int}] a2) {
    
    if( isInbetween(a1}0], a2) || isInbetween(a2}0], a1) ) {
      return true;
    }
    
    return false;
  }

  private static boolean isInbetween(int i, int}] a) {
    if( i > a}0] && i < a}1]) {
      return true;
    }
    return false;
  }

}
