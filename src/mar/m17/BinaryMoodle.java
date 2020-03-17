package mar.m17;

public class BinaryMoodle {
  /**
   * Performs a binary search in an array segment.
   * @param arr A sorted array
   * @param val The requested value
   * @param lo  The first index to look in
   * @param hi  The last index to look in
   * @return The index of <code>val</code> in the array, or <code>-1</code> if not found.
   */
  public static int bsLim(int[] arr, int val, int lo, int hi) {
    int min = lo;
    int max = hi;
    int index = -1;
    int prevIndex;
  
    // Don't search if the value is not in the array segment.
    if (arr[lo] > val) return -1;
    if (arr[hi] < val) return -1;
    
    // Search the array until reaching a single element
    while (min <= max) {
      if (arr[min] == val) return min; // Check for min index
      if (arr[max] == val) return max; // Check for max index
      prevIndex = index; // Solving problems when val is not in arr
      index = (min + max) / 2; // Jump to middle element
      if (arr[index] == val) return index; // Check the middle index
      else if (index == prevIndex) return -1; // If there has been no index change, abort
      else if (arr[index] > val) { // Search in lower elements
        max = index;
      } else { // Search in higher elements
        min = index;
      }
    }
  
    return -1; // If not found
  }
  
  public static void main(String[] args) {
    int[] sorted = new int[10];
    
    for (int i = 0; i < 10; i++)
      sorted[i] = i; // init array with values 0, 1, 2,...,9
      
      System.out.println(bsLim(sorted, 7, 0, 9)); // 7
      System.out.println(bsLim(sorted, 7, 0, 4)); // -1
  }
}
