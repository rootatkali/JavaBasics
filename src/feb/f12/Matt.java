package feb.f12;

import java.util.Arrays;

import static helper.Helper.*;

public class Matt {
  public static double[] avgTemps(int[][] temps) {
    double[] ret = new double[temps.length];
    final int days = temps[0].length;
    double sum = 0;
    
    for (int i = 0; i < temps.length; i++) {
      sum = 0;
      for (int j = 0; j < temps[i].length; j++) {
        sum += temps[i][j];
      }
      ret[i] = sum / days;
    }
    
    return ret;
  }
  
  public static int cntCinema(int[][] square) {
    int ret = 0;
    
    // Count 1st row
    for (int i = 0; i < square.length; i++) {
      ret += square[i][0];
    }
    // Count last row
    for (int i = 0; i < square.length; i++) {
      ret += square[i][square.length - 1];
    }
    
    // Count 1st col
    for (int i = 1; i < square.length - 1; i++) {
      ret += square[0][i];
    }
    // Count last col
    for (int i = 1; i < square.length - 1; i++) {
      ret += square[square.length - 1][i];
    }
    
    // Count prim diagonal
    for (int i = 1; i < square.length - 1; i++) {
      ret += square[i][i];
    }
    // Count sec. diagonal
    for (int i = 1; i < square.length - 1; i++) {
      ret += square[i][square.length - 1 - i];
    }
    
    return ret;
  }
  
  public static String buySeats(int[][] stage, int seats) {
    StringBuilder ret = new StringBuilder();
    
    for (int i = 0; i < stage.length; i++) {
      if (largestSeq(stage[i])[0] >= seats) {
        for (int j = 0, idx = largestSeq(stage[i])[1];
             j < seats;
             j++) {
          stage[i][j + idx] = 1;
          ret.append("(").append(i).append(", ").append(j + idx).append(")\n");
        }
        return ret.toString().strip();
      }
    }
    
    return ret.toString().strip();
  }
  
  private static int[] largestSeq(int[] row) {
    int seq = 0, max = 0;
    int index = 0;
    
    for (int i = 0; i < row.length; i++) {
      if (row[i] == 0) {
        seq++;
        if (seq > max) {
          max = seq;
          index = i - max + 1;
        }
      } else {
        seq = 0;
      }
    }
    
    return new int[]{max, index};
  }
  
  public static void main(String[] args) {
//    int[][] tmps = {
//        {17, 18, 21, 19, 17, 17, 17, 17, 18, 18},
//        {14, 16, 17, 18, 14, 14, 13, 15, 17, 19},
//        {17, 22, 23, 24, 19, 18, 18, 20, 22, 23}
//    };
//    System.out.println(matToString(tmps));
//    System.out.println(Arrays.toString(avgTemps(tmps)));
    
    int[][] sq = new int[8][8];
    System.out.println(matToString(sq));
    
    
    for (int i = 0; i < 10; i++) {
      System.out.println(buySeats(sq, rand(1, 8)));
      System.out.println(matToString(sq));
    }
  }
}
