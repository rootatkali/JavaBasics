package may.m05;

import mar.m30.Date;

public class Main {
  public static boolean validIn(Passport p, Date d) {
    return !d.isAfter(p.getExpDate());
  }
  
  public static void main(String[] args) {
    Passport current = new Passport(
        "Rotem",
        "Moses",
        "34411980",
        new Date(8, 3, 2020),
        new Date(7, 3, 2025),
        new Date(20, 2, 2004),
        "325693455"
    );
    Passport prev = new Passport(
        "Rotem",
        "Moses",
        "22257295",
        new Date(2, 7, 2015),
        new Date(1, 7, 2020),
        new Date(20, 2, 2004),
        "325693455"
    );
    
    Date nextYear = new Date(1, 1, 2021);
    System.out.println(current);
    System.out.println(validIn(current, nextYear)); // Expected true
    System.out.println();
    System.out.println(prev);
    System.out.println(validIn(prev, nextYear)); // Expected false
  }
}
