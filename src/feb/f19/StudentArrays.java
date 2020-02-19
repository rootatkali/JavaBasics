package feb.f19;

import basics.Student;

public class StudentArrays {
  public static int findHeights(Student[] arr, int h) {
    int cnt = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i].getHeight() == h) {
        cnt++;
      }
    }
    return cnt;
  }
  
  public static void main(String[] args) {
    Student[] stArr = new Student[10];
    
    for (int i = 0; i < stArr.length; i++) {
      stArr[i] = new Student(15, 170, "M", "Black");
    }
    
    System.out.println(findHeights(stArr, 170)); // Expected 10
  }
}
