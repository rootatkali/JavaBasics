package mar.m17;

public class SearchMoodle {
  
  /**
   * Finds the index of a value in a sorted array, between a starting index and a finishing index.
   *
   * @param arr A sorted array
   * @param val The requested value
   * @param lo  The first index to look in.
   * @param hi  The last index to look in.
   * @return The index of <code>val</code>, or <code>-1</code> if not found.
   */
  public static int linearSortedLim(int[] arr, int val, int lo, int hi) {
    // Don't loop if the value is not in the array segment.
    if (arr[lo] > val) return -1;
    if (arr[hi] < val) return -1;
    
    // Loop for every element in the array segment
    for (int i = lo; i <= hi; i++) {
      if (arr[i] == val) return i;
    }
    return -1; // If not found (shouldn't reach here)
  }
  
  public static void main(String[] args) {
    int[] sorted = new int[10];
    for (int i = 0; i < 10; i++)
      sorted[i] = i; // init array with values 0, 1, 2,...,9
    
    System.out.println(linearSortedLim(sorted, 5, 0, 4)); // -1
    System.out.println(linearSortedLim(sorted, 5, 0, 5)); // 5
  }
}
