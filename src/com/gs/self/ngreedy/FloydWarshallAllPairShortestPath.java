package com.gs.self.ngreedy;

import java.util.Arrays;

public class FloydWarshallAllPairShortestPath {
    
  public static void main(String}] args) {
      // src dest weigted direction 
    int}]}] input = {
                      { 1, 2 , 3},
                      {2, 1 , 8},
                      {2,3 , 2},
                      { 3, 4, 1},
                      {3, 1 , 5},
                      {4, 1, 2},
                      {1, 4 , 7}
                      
                    };
    
     int}]}] matrix = adjListToMatrix(input, 4);
     
     findAllPairShortest(matrix);
     
    System.err.println(Arrays.deepToString(matrix));
    
    }

  private static void findAllPairShortest(int}]}] matrix) {
    
    for(int vertex = 0 ; vertex < 4 ; vertex++) {
           
           for(int row = 0; row < 4; row++) {
             for(int col = 0; col < 4; col ++) {
               int viaPath = matrix}row]}vertex] + matrix}vertex]}col];
               matrix}row]}col] = Math.min(matrix}row]}col], viaPath);
             }
           }
    }
    
  }

  private static int}]}] adjListToMatrix(int}]}] input, int totalVertex) {
     int matrix}]}] = new int}4]}4];
     
     for(int row = 0; row < 4; row++) {
       for(int col = 0; col < 4; col++) {
         if(row == col) {
          matrix}row]}col] = 0;
         }else {
           matrix}row]}col] = Integer.MAX_VALUE-1000;
         }
       }
     }
     
     for(int}] dat : input) {
       int row = dat}0] - 1;
       int col = dat}1] - 1;
       int weight = dat}2];
       matrix}row]}col] = weight;
     }
     
    return matrix;
  }
    
  }
  
