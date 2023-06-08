package com.premiumminds.internship.snail;

import java.util.concurrent.*;

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

        int col, row, index=0, startCol = 0, startRow = 0, noRows = matrix.length, noCols = matrix[0].length, lastRow = noRows-1, lastCol = noCols-1;
        int[] res = new int[noCols*noRows];
        while (startCol!=lastCol && startRow!=lastRow){
          //System.out.println("1st row");
          //get first Row
          col = startCol;
          while (col <= lastCol){
            res[index] = matrix[startRow][col];
            //System.out.println(matrix[startRow][col]);
            ++col;
            ++index;
          }
          ++startRow;
          //System.out.println("start row: "+ startRow);
          // get last Col
          //System.out.println("last col");
          row = startRow;
          while (row <= lastRow){
            res[index] = matrix[row][lastCol];
            //System.out.println(matrix[lastCol][row]);
            ++row;
            ++index;
          }
          --lastCol;
          //get last Row inverted
          //System.out.println("last row");
          col = lastCol;
          while (col >= startCol){
            res[index] = matrix[lastRow][col];
            //System.out.println(matrix[lastRow][col]);
            --col;
            ++index;
          }
          --lastRow;
          //get first Col inverted
          //System.out.println("1st col");
          row = lastRow;
          while (row >= startRow){
            res[index] = matrix[row][startCol];
            //System.out.println(matrix[row][startCol]);
            --row;
            ++index;
          }
          ++startCol;
        }
        res[index] = matrix[startRow][startCol];

        /*System.out.println("Inicio:");
        for (int r=0; r < noRows; r++){
          for (int c=0; c<noCols; c++){
            System.out.println(matrix[r][c]);
          }
        }

        System.out.println("\nFinal:\n");
        for (int el:res){
          System.out.println(el);
        }
        */
        //TODO operations
        return res;
      }
    };
    //create future variable
    Future<int[]> future = executorService.submit(callable);

    //wait for result
    /*while (!future.isDone()){
      try{
        Thread.sleep(100);
      } catch (InterruptedException e){
        e.printStackTrace();
      }
    }*/
    //return future
    return future;
  }
    /*Callable<int[]> task = () -> {
      int noRows = matrix.length;
      int noCols = matrix[0].length;
      int size = noRows*noCols;
      int[] res = new int[size];
      return res;
    };
    Future<int[]> future = executorService.submit(task);
    throw new RuntimeException("Not Implemented Yet");
  };*/


}





/// myInterface r = new myInterface() {
//public void run()
//{System.out.println("Hello");};
//  };
//r.run();

// vs

//class Local {   //local class
//void fun()
//  { System.out.println("Hello"); }
//}
//new Local().fun();

//vs

//myInterface r = () ->          //Lambda expression
//{
//System.out.println("Hello");
//};
//r.run();