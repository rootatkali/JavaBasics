package feb.f19;

import basics.Student;

import java.util.Arrays;

public class StudentArrays {
  // Task 1
  public static int findHeights(Student[] arr, int h) {
    int cnt = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i].getHeight() == h) {
        cnt++;
      }
    }
    return cnt;
  }
  
  // Task 2
  public static Student[] copyHeights(Student[] arr, int h) {
    Student[] ret = new Student[findHeights(arr, h)];
    for(int i = 0; i < arr.length; i++) {
      if (arr[i].getHeight() == h) {
        ret[firstNull(ret)] = // Copy student attributes to first empty place in new array
            new Student(arr[i].getAge(), arr[i].getHeight(), arr[i].getGender(), arr[i].getHair());
        arr[i] = null; // Delete from mem
      }
    }
    return ret;
  }
  
  // Helper method - find first null and return index
  private static int firstNull(Student[] arr) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == null) return i;
    }
    return -1;
  }
  
  // Task 3
  public static String goodToString(Student[] arr) {
    String ret = "[";
    
    for (int i = 0; i < arr.length; i++) {
      ret += arr[i].toString();
      if (i != arr.length - 1) {
        ret += ", ";
      }
    }
    
    return ret + "]";
  }
  
  public static String cheekyToString(Student[] arr) {
    return Arrays.toString(arr);
  }
  
  public static void main(String[] args) {
    // Task 1
//    Student[] stArr = new Student[10];
//
//    for (int i = 0; i < stArr.length; i++) {
//      stArr[i] = new Student(15, 170, "M", "Black");
//    }
//
//    System.out.println(findHeights(stArr, 170)); // Expected 10
    
    // Task 2
    Student[] stArr = new Student[10];

    for (int i = 0; i < 5; i++) {
      stArr[i] = new Student(15, 170, "M", "Black");
    }
    for (int i = 5; i < 10; i++) {
      stArr[i] = new Student(15, 160, "M", "Black");
    }
    
    Student[] task2 = copyHeights(stArr, 170);
    System.out.println(Arrays.toString(task2));
  }
}
