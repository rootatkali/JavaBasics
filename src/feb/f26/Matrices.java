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
  
  // TASK 4
  public static boolean sym(int[][] mat) {
    for (int c = 0; c < mat.length; c++) {
      for (int r = 0; r < c; r++) {
        if (mat[r][c] != mat[c][r]) return false;
      }
    }
    return true;
  }
  
  // TASK 5
  public static boolean unitMat(int[][] mat) {
    for (int r = 0; r < mat.length; r++) {
      for (int c = 0; c < mat.length; c++) {
        if (r == c) {
          if (mat[r][c] != 1) return false;
        } else {
          if (mat[r][c] != 0) return false;
        }
      }
    }
    return true;
  }
  
  // TASK 6
  public static int[][] addMat(int[][] a, int[][] b) {
    int[][] ret = new int[a.length][a[0].length];
    
    for (int r = 0; r < a.length; r++) {
      for (int c = 0; c < a[r].length; c++) {
        ret[r][c] = a[r][c] + b[r][c];
      }
    }
    return ret;
  }
  
  // TASK 7
  public static void mulC(int[][] a, int val) {
    for (int r = 0; r < a.length; r++) {
      for (int c = 0; c < a[r].length; c++) {
        a[r][c] = a[r][c] * val;
      }
    }
  }
  
  // TASK 8
  public static int[][] subMat(int[][] a, int[][] b) {
    mulC(b, -1);
    return addMat(a, b);
  }
  
  public static void main(String[] args) {
    int[][] test = genMat(10, 10, 0, 9);
    System.out.println(matToString(test));
    System.out.println(sumMainDiag(test));
    System.out.println(sumSecDiag(test));
    System.out.println(sumPerimeter(test));
    
    int[][] sym = {
        {1, 2, 3},
        {2, 2, 2},
        {3, 2, 1}
    };
    
    int[][] notSym = {
        {1, 9, 3},
        {2, 2, 2},
        {3, 2, 1}
    };
    
    System.out.println(sym(sym));
    System.out.println(sym(notSym));
  }
}
