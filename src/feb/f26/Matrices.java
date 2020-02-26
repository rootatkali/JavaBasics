package feb.f26;

import static helper.Helper.*;

public class Matrices {
  // TASK 1
  public static int sumMainDiag(int[][] mat) {
    int sum = 0;
    for (int r = 0; r < mat.length; r++) {
      sum += mat[r][r];
    }
    return sum;
  }
  
  // TASK 2
  public static int sumSecDiag(int[][] mat) {
    int sum = 0;
    for (int r = 0; r < mat.length; r++) {
      sum += mat[r][mat.length - r - 1];
    }
    return sum;
  }
  
  // TASK 3
  public static int sumPerimeter(int[][] mat) {
    int sum = 0;
    for (int c = 0; c < mat.length; c++) {
      sum += mat[0][c];
      sum += mat[mat.length - 1][c];
    }
    
    for (int r = 1; r < mat.length - 1; r++) {
      sum += mat[r][0];
      sum += mat[r][mat.length - 1];
    }
    
    return sum;
  }
  
  public static void main(String[] args) {
    int[][] test = genMat(10, 10, 0, 9);
    System.out.println(matToString(test));
    System.out.println(sumMainDiag(test));
    System.out.println(sumSecDiag(test));
    System.out.println(sumPerimeter(test));
  }
}
