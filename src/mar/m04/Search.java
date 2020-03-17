package mar.m04;

import canvasML.Canvas;
import canvasML.Line;
import helper.Helper;

import java.util.Arrays;

public class Search {
  public static int linearSearch(int[] arr, int val) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == val) {
        return i;
      }
    }
    return -1;
  }
  
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
  
  // Works only on a sorted array
  public static int binarySearch(int[] arr, int val) {
    int min = 0;
    int max = arr.length - 1;
    int index = -1;
    int prevIndex;
    
    while (min <= max) {
      if (arr[min] == val) return min;
      if (arr[max] == val) return max;
      prevIndex = index;
      index = (min + max) / 2;
      if (arr[index] == val) return index;
      else if (index == prevIndex) return -1;
      else if (arr[index] > val) {
        max = index;
      } else {
        min = index;
      }
    }
    
    return -1;
  }
  
  public static void main(String[] args) {
    int[] arr = Helper.genArr(600, 0, 600);
    Arrays.sort(arr);
    System.out.println(Arrays.toString(arr));
    dispArr(arr, "blue");
    int binary = binarySearch(arr, 200);
    Canvas.getCanvas().wait(1000);
    Line line = new Line(binary, 400, binary, 400 - arr[binary], "green");
  }
}
