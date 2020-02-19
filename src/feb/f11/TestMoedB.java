package feb.f11;

import java.util.Arrays;

import static helper.Helper.*;

public class TestMoedB {
  public static int squareBySum(int n) { // Q1.A
    int sqr = 0;
    for (int i = 1; i <= (2 * n - 1); i = i + 2) {
      sqr += i;
    }
    return sqr;
  }
  
  public static double baselSum() { // Q1.B
    double sum = 0;
    for (int i = 1; i <= 500; i++) {
      sum = sum + (1.0 / squareBySum(i));
    }
    return sum;
  }
  
  public static boolean hasMoreDollar(char[] arr) { // Q2
    int half1 = 0;
    int half2 = 0;
    
    for (int i = 0; i < arr.length / 2; i++) {
      if (arr[i] == '$') half1++;
    }
    
    for (int i = arr.length / 2; i < arr.length; i++) {
      if (arr[i] == '$') half2++;
    }
    
    return half1 > half2;
  }
  
  public static int sums(int[] arr1, int[] arr2) {
    int a = 0, b = 0;
    
    for (int i = 0; i < arr1.length; i = i + 2) {
      a = a + arr1[i];
    }
    
    for (int i = 1; i < arr2.length; i = i + 2) {
      b = b + arr2[i];
    }
    
    return a + b;
  }
  
  public static void main(String[] args) {
    System.out.println(baselSum());
    System.out.println(Math.pow(Math.PI, 2) / 6);
//
//    int basel = (int) (baselSum() * 100);
//    int pi2b6 = (int) ((Math.pow(Math.PI, 2) / 6) * 100);
//
//    if (baselSum() != (Math.pow(Math.PI, 2) / 6)) throw new AssertionError("ERR");
//
//    System.out.println(basel + "\n" + pi2b6);
//    System.out.println(basel == pi2b6);
    
    System.out.println(sameValue(baselSum(), Math.pow(Math.PI, 2) / 6, 2));
    
    System.out.println(hasMoreDollar(new char[]{'$', '4', '$', '$', '4', '4'}));
    System.out.println(hasMoreDollar(new char[]{'$', '4', '$', '$', '$', '$'}));
    
    int[] a = {1, 0, 1, 0};
    System.out.println(Arrays.toString(a));
    int[] b = {0, 1, 0, 1};
    System.out.println(Arrays.toString(b));
    
    System.out.println(sums(a, b));
  }
}
