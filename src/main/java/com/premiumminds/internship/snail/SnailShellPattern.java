package com.premiumminds.internship.snail;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by aamado on 05-05-2023.
 */
class SnailShellPattern implements ISnailShellPattern {

  /**
   * Method to get snailshell pattern
   * 
   * @param matrix matrix of numbers to go through
   * @return order array of values thar represent a snail shell pattern
   */
  public Future<int[]> getSnailShell(final int[][] matrix) {
    //create executor
    ExecutorService executorService = Executors.newSingleThreadExecutor();
    //create callable
    Callable<int[]> callable = new Callable<int[]>() {
      @Override
      public int[] call() throws Exception {

          int col, row, N = matrix[0].length;
          //empty matrix 0x0
          if (N == 0) return new int[0];
          //matrix 1x1
          if (N == 1) return new int[]{matrix[0][0]};


          int[] res = new int[N*N];
          int index = 0, startPos = 0, lastPos = N-1;   // because always startRow = startCol and lastRow = lastCol

          while (startPos < lastPos){

              //get first Row
              for (col = startPos; col <= lastPos - 1; col++, index++) res[index] = matrix[startPos][col];

              // get last Col
              for (row = startPos; row <= lastPos - 1; row++, index++) res[index] = matrix[row][lastPos];

              //get last Row inverted
              for (col = lastPos; col >= startPos + 1; col--, index++) res[index] = matrix[lastPos][col];

              //get first Col inverted
              for (row = lastPos; row >= startPos + 1; row--, index++) res[index] = matrix[row][startPos];

              ++startPos;
              --lastPos;


          }
          if (!(N % 2 == 0)) res[index] = matrix[startPos][startPos];   // if N isn't an even number
          return res;
      }
    };
    //create future variable
    Future<int[]> future = executorService.submit(callable);

    //return future
    return future;
  }

}

