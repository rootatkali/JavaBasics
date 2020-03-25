/*
Merge sorts.
Author: Rotem Moses, 21-March-2020
 */
package mar.m21;

import java.util.Arrays;

public class Merge {
  /**
   * Merge two sorted integer arrays using merge sort.
   * Complexity: O(n) where n is a.length + b.length
   * @param a A sorted array
   * @param b A sorted array
   * @return A sorted array consisting of all elements of each array, in correct order.
   */
  public static int[] mergeInt(int[] a, int[] b) {
    int[] ret = new int[a.length + b.length];
    int idxA = 0, idxB = 0, idxRet = 0; // Index pointers
    
    while (idxRet < ret.length) { // Until new array is full
      // add the smaller value from each array to the merged one.
      // advance the original and new array pointers by one.
      if (a[idxA] <= b[idxB]) {
        ret[idxRet] = a[idxA];
        idxRet++;
        idxA++;
      } else {
        ret[idxRet] = b[idxB];
        idxRet++;
        idxB++;
      }
      
      // For cases when a single array is finished, just copy all remaining elements of the other
      // array
      if (idxA == a.length) {
        for (int i = idxB; i < b.length; i++) {
          ret[idxRet] = b[i];
          idxRet++;
        }
      }
      if (idxB == b.length) {
        for (int i = idxA; i < a.length; i++) {
          ret[idxRet] = a[i];
          idxRet++;
        }
      }
    }
    
    return ret;
  }
  
  /**
   * Use a modified counting sort to merge two arrays without duplicate values.
   * Complexity: O(n) where n is a.length + b.length
   * @param a A sorted array
   * @param b A sorted array
   * @return A sorted array consisting of all unique elements of each array, in correct order.
   */
  public static int[] mergeNoRep(int[] a, int[] b) {
    int[] ret;
    int idxRet = 0; // Index pointer for the return array
    int min = Math.min(a[0], b[0]); // Overall min value
    int max = Math.max(a[a.length - 1], b[b.length - 1]); // Overall max value
    int cntValues = 0; // Counts unique values
    int[] cntArr = new int[max - min + 1]; // A counter array for all elements in the arrays
  
    Arrays.fill(cntArr, 0); // Same as for (int i = 0; i < cntArr.length; i++) {cntArr[i] = 0;}
    
    // Add all elements from a and b to the counter array
    for (int i = 0; i < a.length; i++) {
      cntArr[a[i] - min]++;
    }
    for (int i = 0; i < b.length; i++) {
      cntArr[b[i] - min]++;
    }
  
    // Count the number of unique values
    for (int i = 0; i < cntArr.length; i++) {
      if (cntArr[i] != 0) cntValues++;
    }
    
    // Return array contains only unique values
    ret = new int[cntValues];
    
    // Add values to return array, advancing pointer accordingly
    for (int i = 0; i < cntArr.length; i++) {
      if (cntArr[i] != 0) {
        ret[idxRet] = min + i;
        idxRet++;
      }
    }
    
    return ret;
  }
  
  /**
   * Merges two character arrays, sorted in descending order by their unicode values.
   * Complexity: O(n) where n is a.length + b.length
   * @param a A sorted flipped char array
   * @param b A sorted flipped char array
   * @return A sorted array consisting of all elements of each array, in descending order.
   */
  public static char[] mergeChar(char[] a, char[] b) {
    char[] ret = new char[a.length + b.length];
    int idxA = 0, idxB = 0, idxRet = 0; // Index pointers
    
    while (idxRet < ret.length) { // Until new array is full
      // add the larger value from each array to the merged one.
      // advance the original and new array pointers by one.
      if (a[idxA] >= b[idxB]) {
        ret[idxRet] = a[idxA];
        idxRet++;
        idxA++;
      } else {
        ret[idxRet] = b[idxB];
        idxRet++;
        idxB++;
      }
      
      // For cases when a single array is finished, just copy all remaining elements of the other
      // array
      if (idxA == a.length) {
        for (int i = idxB; i < b.length; i++) {
          ret[idxRet] = b[i];
          idxRet++;
        }
      }
      if (idxB == b.length) {
        for (int i = idxA; i < a.length; i++) {
          ret[idxRet] = a[i];
          idxRet++;
        }
      }
    }
    
    return ret;
  }
  
  public static void main(String[] args) {
    // For tasks 1 and 2
    int[] a = {1, 2, 3, 4};
    int[] b = {1, 2, 4, 6, 8};
    System.out.println(Arrays.toString(mergeInt(a, b))); // [1, 1, 2, 2, 3, 4, 4, 6, 8]
    System.out.println(Arrays.toString(mergeNoRep(a, b))); // [1, 2, 3, 4, 6, 8]
    
    // For task 3
    char[] ca = {'z', 'z', 'y', 'w', 'a'};
    char[] cb = {'d', 'c', 'b', 'a'};
    System.out.println(Arrays.toString(mergeChar(ca, cb))); // [z, z, y, w, d, c, b, a, a]
  }
}
