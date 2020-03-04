package mar.m04;

import canvasML.Canvas;
import canvasML.Line;

import java.util.Arrays;
import java.util.Scanner;

import static helper.Helper.*;

public class Sorting {
  public static void dispArr(int[] arr, String color) {
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
    Line l = new Line(1, 400, 1, 400, color);
    for (int i = 0; i < arr.length; i++) {
      l.setPoints(l.getXs(), 400, l.getXs(), 400 - (arr[i] * len));
      l.draw();
      l.move(dis, 0);
    }
  }
  
  public static void selectionSort(int[] arr) {
    int min = 0;
    for (int i = 0; i < arr.length - 1; i++) {
      min = i;
      
      for (int j = i + 1; j < arr.length; j++) { // Find the smallest value in the array
        if (arr[j] < arr[min]) {
          min = j;
        }
      }
      
      swap(arr, i, min);
    }
  }
  
  public static void bubbleSort(int[] arr) {
    int max = arr.length;
    int swaps;
    
    for (int i = 0; i < arr.length - 1; i++) {
      swaps = 0;
      
      for (int j = 0; j < max - 1; j++) {
        if (arr[j + 1] < arr[j]) { // Compare every pair
          swap(arr, j, j + 1);
          swaps++;
        }
      }
      
      max--;
      
      if (swaps == 0) return; // If no swaps, the array is sorted
    }
  }
  
  public static void main(String[] args) {
    int[] arr = genArr(600, 0, 400);
    dispArr(arr, "red");
    bubbleSort(arr);
//    System.out.println(Arrays.toString(arr));
    dispArr(arr, "green");
  }
}
