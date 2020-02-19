package helper;

import java.util.Arrays;

import static helper.Helper.*;

public class HelperTest {
  public static void main(String[] args) {
//    int[][] test = genMat(6, 9, 0, 9);
//    System.out.println(matToString(test));
    
    int[] src = {1, 2, 3};
    int[] dst = {0, 0, 0, 0, 0, 0};
    copyTo(src, dst);
    System.out.println(Arrays.toString(dst));
  }
}
