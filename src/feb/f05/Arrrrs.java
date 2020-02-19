package feb.f05;

import java.util.Arrays;

public class Arrrrs {
  public static int[] sortLim(int[] arr) {
    int[] ret = new int[arr.length];
    int[] indx;
    int max = arr[0];
    int min = arr[0];
  
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] > max) {
        max = arr[i];
      }
      if (arr[i] < min) {
        min = arr[i];
      }
    }
    
    int size = max - min + 1;
    indx = new int[size];
    Arrays.fill(indx, 0);

    for (int i = 0; i < arr.length; i++) {
      indx[arr[i] - min]++;
    }

    System.out.println(Arrays.toString(indx));
    
    int cnt = 0;
    for (int i = min; i < size + min; i++) {
      for (int j = cnt; j < cnt + indx[i - min]; j++) {
        ret[j] = i;
      }
      cnt += indx[i - min];
    }
    
    return ret;
  }
  
  public static int[] genArr(int size, int lo, int hi) {
    int[] arr = new int[size];
    for (int i = 0; i < size; i++) {
      arr[i] = (int) (Math.random() * (hi - lo + 1) + lo);
    }
    return arr;
  }
  
  public static void swap(int[] arr, int idx1, int idx2) {
    int tmp = arr[idx1];
    arr[idx1] = arr[idx2];
    arr[idx2] = tmp;
  }
  
  public static void main(String[] args) {
    int[] a = {-7, 5, 8, 2, 4, 3};
    System.out.println(Arrays.toString(sortLim(a)));
  }
}
