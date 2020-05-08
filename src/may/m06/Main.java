package may.m06;

import mar.m30.Date;
import may.m05.Line4D;
import may.m05.Passport;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

import static helper.Helper.*;

public class Main {
  private static Scanner in = new Scanner(System.in);
  
  /**
   * Sort an array of Passport objects by the birth fields. O(n^2)
   *
   * @param arr An array
   */
  private static void sortByBirth(Passport[] arr) {
    int min = 0;
    for (int i = 0; i < arr.length - 1; i++) {
      min = i;
      
      for (int j = i + 1; j < arr.length; j++) { // Find the smallest value
        if (arr[j].getBirth().isBefore(arr[min].getBirth())) {
          min = j;
        }
      }
      
      swap(arr, i, min);
    }
  }
  
  /**
   * Sort an array of Passport objects by the lastName fields, in alphabetical order. O(n^2)
   *
   * @param arr An array
   */
  private static void sortBySurname(Passport[] arr) {
    int min = 0;
    for (int i = 0; i < arr.length - 1; i++) {
      min = i;
      
      for (int j = i + 1; j < arr.length; j++) { // Find the smallest value
        if (isBefore(arr[j].getLastName(), arr[min].getLastName())) {
          min = j;
        }
      }
      
      swap(arr, i, min);
    }
  }
  
  /**
   * Compares two strings, a and b, alphabetically.
   *
   * @param a A string.
   * @param b A string.
   * @return <code>true</code> if a comes before b in the dictionary, <code>false</code> otherwise.
   */
  private static boolean isBefore(String a, String b) {
    if (a.equals(b)) return false;
    String shorter = a.length() > b.length() ? b : a;
    
    // Loop until one character is different
    for (int i = 0; i < shorter.length(); i++) {
      if (a.charAt(i) != b.charAt(i)) {
        return a.charAt(i) < b.charAt(i);
      }
    }
    
    return shorter.equals(a); // If strings start at same substring, return shorter.
  }
  
  public static void main(String[] args) {
    String[] familyNames = {"Arthur", "Cohen", "Doe", "Dursley", "Jones", "Potter", "Roe", "Smith", "Williams"};
    String[] firstNames = {"Anne", "Ashley", "Dan", "Dan", "Hannah", "James", "Jane", "John",
        "Leah", "Margaret", "Rachel", "Steve"};
    
    System.out.print("Enter the length of the array: ");
    Passport[] arr = new Passport[in.nextInt()];
    
    // Populating the array
    for (int i = 0; i < arr.length; i++) {
      arr[i] = new Passport(firstNames[rand(0, firstNames.length - 1)],
          familyNames[rand(0, familyNames.length - 1)],
          "" + rand(10000000, 99999999),
          new Date(rand(1, 30), rand(1, 12), 2020),
          new Date(rand(1, 30), rand(1, 12), 2029),
          new Date(rand(1, 30), rand(1, 12), rand(1970, 2004)),
          "" + rand(100000000, 399999999)
      );
    }
    
    Arrays.stream(arr).forEach(System.out::println); // Print entire objects, before sorting
    System.out.println();
    
    // Sort by birth dates
    sortByBirth(arr);
    Arrays.stream(arr).forEach(p -> System.out.println(p.getBirth().format())); // Print only birthdays
    System.out.println();
    
    // Sort by surnames
    sortBySurname(arr);
    Arrays.stream(arr).forEach(p -> System.out.println(p.getName() + " " + p.getLastName())); // Print only names
    System.out.println();
  }
}
