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
  };

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
  public void ScreenLockinPatternTestFirst2Length2Test()
          throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = {{1, 2}, {4, 3}};
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = { 1, 2, 3, 4};
    assertArrayEquals(result, expected);
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
}