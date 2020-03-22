package mar.m22;

public class DateTest {
  public static void main(String[] args) {
    Date d1 = new Date(20, 2, 2004);
    Date d2 = new Date(22, 3, 2020);
    System.out.println(d1);
    System.out.println(d2);
    System.out.println(d1.isBefore(d2)); // true
    d1.setYear(2021);
    System.out.println(d2.isBefore(d1)); // true
    System.out.println(d1.isAfter(d2)); // true
    d1.setYear(2020);
    d1.setMonth(3);
    d1.setDay(22);
    System.out.println(d1.equals(d2)); // true
  }
}
