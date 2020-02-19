package jan.j29;

import canvasML.Canvas;
import canvasML.Line;

import java.awt.*;
import java.util.Arrays;

public class Arrs {
  public static int[] genArr(int size, int lo, int hi) {
    int[] arr = new int[size];
    for (int i = 0; i < size; i++) {
      arr[i] = (int) (Math.random() * (hi - lo + 1) + lo);
    }
    return arr;
  }
  
  public static int existI(int[] arr, int val) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == val)
        return i;
    }
    return -1;
  }
  
  public static boolean exist(int[] arr, int val) {
    return existI(arr, val) != -1;
  }
  
  public static void swap(int[] arr, int idx1, int idx2) {
    int tmp = arr[idx1];
    arr[idx1] = arr[idx2];
    arr[idx2] = tmp;
  }
  
  public static void dispArr(int[] arr) {
    int maxVal = Integer.MIN_VALUE, minVal = Integer.MAX_VALUE;
    // Find largest and smallest value
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] > maxVal)
        maxVal = arr[i];
      if (arr[i] < minVal)
        minVal = arr[i];
    }
    
    // Reduce by smallest
    for (int i = 0; i < arr.length; i++) {
      arr[i] -= minVal;
    }
    maxVal -= minVal;
    
    int len = Canvas.canvasSingleton.HEIGHT / maxVal;
    int dis = Canvas.canvasSingleton.WIDTH / arr.length;
    Line l = new Line(1, 400, 1, 400, "blue");
    for (int i = 0; i < arr.length; i++) {
      l.setPoints(l.getXs(), 400, l.getXs(), 400 - (arr[i] * len));
      l.draw();
      l.move(dis, 0);
    }
  }
  
  /**
   * n>0 - rotate right
   * n<0 - rotate left
   */
  public static void shiftArr(int[] arr, int n) {
    int[] tmp = Arrays.copyOf(arr, arr.length);
    if (n > 0) {
      for (int i = 0; i < arr.length; i++) {
        arr[(i + n) % arr.length] = tmp[i];
      }
    } else if (n == 0) {
      return;
    } else {
      n = -n;
      for (int i = 0; i < arr.length; i++) {
        arr[i] = tmp[(i + n) % arr.length];
      }
    }
  }
  
  public static int[] noDupes(int[] arr) {
    int[] tmp = new int[arr.length];
    Arrays.fill(tmp, Integer.MAX_VALUE);
    int[] ret;
    int cnt = 0;
    for (int i = 0; i < arr.length; i++) {
      if (!exist(tmp, arr[i])) {
        tmp[i] = arr[i];
      }
    }
    System.out.println(Arrays.toString(tmp));
    for (int i = 0; i < tmp.length; i++) {
      if (tmp[i] != Integer.MAX_VALUE) cnt++;
    }
    
    ret = new int[cnt];
    Arrays.fill(ret, Integer.MAX_VALUE);
    
    for (int i = 0; i < cnt; i++) {
      for (int j = 0; ret[i] == Integer.MAX_VALUE && j < tmp.length; j++) {
        if (tmp[i] != Integer.MAX_VALUE)
          ret[i] = tmp[i];
      }
    }
    
    return ret;
  }
  
  public static void main(String[] args) {
//    int[] a = genArr(200, 0, 100);
//    System.out.println(Arrays.toString(a));
//    dispArr(a);
    
//    int[] a = {1, 2, 3, 4, 5, 6, 7};
//    shiftArr(a, -3);
//    System.out.println(Arrays.toString(a));
//    shiftArr(a, 3);
//    System.out.println(Arrays.toString(a));
    
    int[] a = {1, 1, 1, 2, 2, 3};
    System.out.println(Arrays.toString(noDupes(a)));
  }
}
