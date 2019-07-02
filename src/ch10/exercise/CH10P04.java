package ch10.exercise;

import java.util.Arrays;

public class CH10P04 {

  public static void main(String[] args) {
    Matrix[] matrices = new Matrix[40];
    Arrays.parallelSetAll(matrices, i -> new Matrix(new int[][]{{1, 1}, {1, 0}}));
    Arrays.parallelPrefix(matrices, Matrix::multiply);

    System.out.println(Arrays.toString(matrices));
  }

  public static class Matrix {

    private int[][] f;

    public Matrix(int[][] f) {
      this.f = f;
    }

    public Matrix multiply(Matrix matrix) {
      int x1 = f[0][0] * matrix.f[0][0] + f[0][1] * matrix.f[1][0];
      int x2 = f[0][0] * matrix.f[0][1] + f[0][1] * matrix.f[1][1];
      int y1 = f[1][0] * matrix.f[0][0] + f[1][1] * matrix.f[1][0];
      int y2 = f[1][0] * matrix.f[0][1] + f[1][1] * matrix.f[1][1];
      return new Matrix(new int[][]{{x1, x2}, {y1, y2}});
    }

    @Override
    public String toString() {
      return f[0][0] + "";
    }
  }
}
