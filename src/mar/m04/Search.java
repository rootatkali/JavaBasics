package mar.m04;

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
    int[] arr = Helper.genArr(1000, 0, 2000);
    Arrays.sort(arr);
    
    System.out.println(linearSearch(arr, 1000));
    System.out.println(binarySearch(arr, 1000));
  }
}
