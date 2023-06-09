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

          int col, row, index=0, startCol = 0, startRow = 0, N = matrix[0].length, lastRow = N-1, lastCol = N-1;
          boolean NIsEven = (N % 2 == 0);
          //empty matrix 0x0
          if (N == 0){
            return new int[]{};
          }
          //matrix 1x1
          if (N == 1){
            return new int[]{matrix[0][0]};
          }
          int[] res = new int[N*N];

          while (startCol!=lastCol && startRow!=lastRow){

              if (NIsEven && startRow != 0){
                  --lastRow;
                  //get first Col inverted
                  for (row = lastRow; row >= startRow; row--, index++){
                    res[index] = matrix[row][startCol];
                  }
                  ++startCol;
              }
              //get first Row
              for (col = startCol; col <= lastCol; col++, index++){
                  res[index] = matrix[startRow][col];
              }
              ++startRow;

              // get last Col
              for (row = startRow; row <= lastRow; row++, index++){
                  res[index] = matrix[row][lastCol];
              }
              --lastCol;

              //get last Row inverted
              for (col = lastCol; col >= startCol; col--, index++){
                  res[index] = matrix[lastRow][col];
              }
              if (!NIsEven){
                  --lastRow;
                  //get first Col inverted
                  for (row = lastRow; row >= startRow; row--, index++){
                      res[index] = matrix[row][startCol];
                  }
                  ++startCol;
              }

          }
          if (!NIsEven){
              res[index] = matrix[startRow][startCol];
          }
          return res;
      }
    };
    //create future variable
    Future<int[]> future = executorService.submit(callable);
    //return future
    return future;
  }

}

