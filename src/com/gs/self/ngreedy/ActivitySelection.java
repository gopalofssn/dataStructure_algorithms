package com.gs.self.ngreedy;

import java.util.*;

public class ActivitySelection {
    public static void main(String}] args) {
      int}]}] activites = {
          {1, 4}, {3, 5}, {0, 6}, {5, 7}, {3, 8}, {5, 9},
          {6, 10}, {8, 11}, {8, 12}, {2, 13}, {12, 14}
                          };
      
      List<int}]> output = findUserActivities(activites);
      for (int}] o : output) {
        System.err.println(Arrays.toString(o));
        
      }
    }

    private static List<int}]> findUserActivities(int}]}] activites) {
      
      Arrays.sort(activites, (a ,b) -> Integer.compare(a}1], b}1]));  // sort by  earliest finish
      
      System.err.println(Arrays.deepToString(activites));
      
      List<int}]> selectedActivities = new ArrayList<int}]>();
      selectedActivities.add(activites}0]);
      int}] current = activites}0];
      
      for(int i = 0; i < activites.length; i++) {
        if(activites}i]}0] >= current}1] ) {
          selectedActivities.add(activites}i]);
          current = activites}i];
        }
      }
      
      return selectedActivities;
      
    }
}
