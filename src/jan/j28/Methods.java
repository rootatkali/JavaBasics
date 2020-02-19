package jan.j28;

import canvasML.Canvas;
import canvasML.Line;

import java.awt.*;
import java.util.Arrays;

public class Methods {
  public static int[] genArr(int size, int lo, int hi) {
    int[] arr = new int[size];
    for (int i = 0; i < size; i++) {
      arr[i] = (int) (Math.random() * (hi - lo + 1) + lo);
    }
    return arr;
  }
  
  public static int[] genGrades(int num) {
    return genArr(num, 1, 100);
  }
  
  public static int[] histGrades(int[] grades) {
    int[] hist = new int[10];
    Arrays.fill(hist, 0);
    for (int i = 0; i < grades.length; i++) {
      hist[(grades[i] - 1) / 10]++;
    }
    return hist;
  }
  
  public static void genHistogram(int[] hist) {
    Canvas c = Canvas.getCanvas();
    c.setFont(new Font("Consolas", Font.PLAIN, 9));
    int lenPerStudent = 0;
    for (int i = 0; i < 10; i++) {
      if (hist[i] > lenPerStudent) {
        lenPerStudent = hist[i];
      }
    }
    lenPerStudent = 400 / lenPerStudent;
    
    Line l = new Line(10, 400, 10, 400, "black");
    Line bar = new Line(0, 400, 600, 400, "magenta");
    // Draw bars
    for (int i = 0; i < 100; i++) {
      bar.move(0, -lenPerStudent);
      bar.draw();
    }
    // Draw Lines
    StringBuilder s;
    for (int i = 0; i < 10; i++) {
      s = new StringBuilder();
      l.erase();
      l.setPoints(l.getXs(), 400, l.getXe(), 400 - (lenPerStudent * hist[i]));
      l.draw();
      s.append(i * 10).append("-").append(i != 9 ? i * 10 + 9 : 100).append(":\n").append(hist[i]);
      c.drawString(s.toString(), l.getXe() + 2, 390);
      l.move(60, 0);
    }
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
  
  public static void main(String[] args) {
    Canvas.setWaitFast();
    int[] grades = genGrades(100);
    System.out.println(Arrays.toString(grades));
    int[] hist = histGrades(grades);
    System.out.println(Arrays.toString(hist));
    genHistogram(hist);
//    int[] arr = genArr(10, 0, 5);
//    System.out.println(Arrays.toString(arr));
//    System.out.println(existI(arr, 6));
//    System.out.println(exist(arr, 6));
//    swap(arr, 0, 9);
//    System.out.println(Arrays.toString(arr));
  }
}
