package jan.j22;

public class ArrMethods {
  public static boolean isZigZagU(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
      if (i % 2 == 0) {
        if (arr[i] >= arr[i - 1]) {
          return false;
        }
      } else if (arr[i] <= arr[i - 1]) {
        return false;
      }
    }
    return true;
  }
  
  public static boolean isPal(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] != arr[arr.length - i - 1]) return false;
    }
    return true;
  }
  
  public static int[] genArr(int size, int lo, int hi) {
    int[] arr = new int[size];
    for (int i = 0; i < size; i++) {
      arr[i] = (int) (Math.random() * (hi - lo + 1) + lo);
    }
    return arr;
  }
  
  public static boolean oneZigZag(int[] arr) {
    if (isZigZagU(arr)) return true;
    for (int i = 1; i < arr.length; i++) {
      if (i % 2 == 0) {
        if (arr[i] <= arr[i - 1]) {
          return false;
        }
      } else if (arr[i] >= arr[i - 1]) {
        return false;
      }
    }
    return true;
  }
  
  public static void main(String[] args) {
    System.out.println(oneZigZag(new int[]{1, 2, 1, 2, 1, 2}));
    System.out.println(oneZigZag(new int[]{2, 1, 2, 1, 2, 1}));
    System.out.println(oneZigZag(new int[]{3, 1, 2, 1, 2, 1}));
    System.out.println(oneZigZag(new int[]{0, 1, 2, 1, 2, 1}));
    System.out.println(oneZigZag(genArr(3, 0, 9)));
  }
}
