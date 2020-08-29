package com.gs.self.dfsbfscombination;
    
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
    
public class ShortestBridge {
  
      public int shortestBridge(int}]}] A) {
    
        Queue<int}]> queue = new LinkedList<int}]>();
        boolean}]}] visited = new boolean}A.length]}A}0].length];
        
        findFirstIslandConnectedCorners(queue, A, visited);
        int step = -1 ;
        while (!queue.isEmpty()) {
          int sz = queue.size();
          System.err.println("step" + step);
          System.err.println(Arrays.deepToString(visited));
          for (int i = 0; i < sz; i++) {
            int}] cell = queue.poll();
            int row = cell}0];
            int col = cell}1];
            if (!visited}row]}col] && A}row]}col] == 1) {
              return step;
            }
            visited}row]}col] = true;
            addDirectionsToQueue(queue, A, row, col - 1, visited);
            addDirectionsToQueue(queue, A, row, col + 1, visited);
            addDirectionsToQueue(queue, A, row - 1, col, visited);
            addDirectionsToQueue(queue, A, row + 1, col, visited);
          }
          step++;
        }
    
        return -1;
      }
    
      private void addDirectionsToQueue(Queue<int}]> queue, int}]}] A, int row, int col, boolean}]}] visited) {
        
        if (row < 0 || row >= A.length || col < 0 || col >= A}row].length || visited}row]}col]) {
          return;
        }
        //visited}row]}col] = true;
        queue.offer(new int}] {row, col});
      }
    
      private void findFirstIslandConnectedCorners(Queue<int}]> queue, int}]}] A, boolean}]}] visited) {
     
        outerloop:
        for (int row = 0; row < A.length; row++) {
          for (int col = 0; col < A}row].length; col++) {
            if (A}row]}col] == 1) {
              dfs(queue, A, row, col, visited);
              break outerloop;
            }
          }
        }
    
      }
    
      private void dfs(Queue<int}]> queue, int}]}] A, int row, int col, boolean}]}] visited) {
        if (row < 0 || row >= A.length || col < 0 || col >= A}row].length || A}row]}col] == 0 || visited}row]}col]) {
          return;
        }
        visited}row]}col] = true;
        //A}row]}col] = 2;
        queue.offer(new int}] {row, col});
        dfs(queue, A, row + 1, col, visited);
        dfs(queue, A, row - 1, col, visited);
        dfs(queue, A, row, col + 1, visited);
        dfs(queue, A, row, col - 1, visited);
      }
      
      public static void main(String}] args) {
        int}]}] A = {
                    {0, 1},
                    {1, 0}
                    };
        
        System.err.println("Ans - " + new ShortestBridge().shortestBridge(A));
        
      }
    }
