package com.gs.self.bloomberg;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsII {

  public static void main(String}] args) {
     int}]}] intervals = { 
                          {45,100},
                          {0,30},
                          {0,45},
                          {150,200}
                         };
     
     System.err.println(minConferenceRoom(intervals));
     }
  

  private static int minConferenceRoom(int}]}] intervals) {
    
    
     Arrays.sort(intervals, (a, b) -> a}0] - b}0]);
     System.err.println(Arrays.deepToString(intervals));
     
     PriorityQueue<int}]> earlyEndingMeetingQueue = new PriorityQueue<int}]>( (a, b) -> a}1] - b}1]);
     
     for(int}] interval : intervals) {
       
       
       if(earlyEndingMeetingQueue.isEmpty()) {
         earlyEndingMeetingQueue.offer(interval);
         continue;
       }

       int}] peek = earlyEndingMeetingQueue.peek();
       if(peek}1] <= interval}0]) {
         earlyEndingMeetingQueue.poll();
       }
       earlyEndingMeetingQueue.offer(interval);
      
       
     }
     
    return earlyEndingMeetingQueue.size();
  }

  }
