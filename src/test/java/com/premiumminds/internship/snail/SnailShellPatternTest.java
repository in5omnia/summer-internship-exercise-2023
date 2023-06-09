package com.premiumminds.internship.snail;

import static org.junit.Assert.assertArrayEquals;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Created by aamado on 05-05-2023.
 */
@RunWith(JUnit4.class)
public class SnailShellPatternTest {

  /**
   * The corresponding implementations to test.
   *
   * If you want, you can make others :)
   *
   */
  public SnailShellPatternTest() {
  }

  @Test
  public void ScreenLockinPatternTestFirst0Length2Test()
          throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = {{}};
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = {};
    assertArrayEquals(result, expected);
  }

  @Test
  public void ScreenLockinPatternTestFirst1Length2Test()
          throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = {{1}};
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = {1};
    assertArrayEquals(result, expected);
  }

  @Test
  public void ScreenLockinPatternTestFirst2Length2Test()
          throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = {{1, 2}, {4, 3}};
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = { 1, 2, 3, 4};
    assertArrayEquals(result, expected);
  }

  @Test
  public void ScreenLockinPatternTestFirst3Length2Test()
      throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = { { 1, 2, 3 }, { 8, 9, 4 }, { 7, 6, 5 } };
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    assertArrayEquals(result, expected);
  }

  @Test
  public void ScreenLockinPatternTestFirst4Length2Test()
          throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = {{1, 2, 3, 9}, {4, 5, 6, 4}, {7, 8, 9, 1}, {1, 2, 3, 4}};
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = { 1, 2, 3, 9, 4, 1, 4, 3, 2, 1, 7, 4, 5, 6, 9, 8};
    assertArrayEquals(result, expected);
  }

  @Test
  public void ScreenLockinPatternTestFirst5Length2Test()
          throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = new int[5][5];
    int value = 1;
    for (int i=0; i<5; i++){
      for (int j=0; j<5; j++){
        matrix[i][j] = value;
      }
      ++value;
    }
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = { 1, 1, 1, 1, 1, 2, 3, 4, 5, 5, 5, 5, 5, 4, 3, 2, 2, 2, 2, 3, 4, 4, 4, 3, 3};
    assertArrayEquals(result, expected);
  }

  //makes 10x10 matrix whose snailSort result is numbers 1 to 100 in ascending order
  @Test
  public void ScreenLockinPatternTestFirst10Length2Test()
          throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = {{1, 2, 3, 4, 5, 6, 7, 8, 9, 10},{36, 37, 38, 39, 40, 41, 42, 43, 44, 11},
            {35, 64, 65, 66, 67, 68, 69, 70, 45, 12}, {34, 63, 84, 85, 86, 87, 88, 71, 46, 13},
            {33, 62, 83, 96, 97, 98, 89, 72, 47, 14}, {32, 61, 82, 95, 100, 99, 90, 73, 48, 15},
            {31, 60, 81, 94, 93, 92, 91, 74, 49, 16}, {30, 59, 80, 79, 78, 77, 76, 75, 50, 17},
            {29, 58, 57, 56, 55, 54, 53, 52, 51, 18}, {28, 27, 26, 25, 24, 23, 22, 21, 20, 19}};

    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27,
            28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54,
            55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81,
            82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100};
    assertArrayEquals(result, expected);
  }

}