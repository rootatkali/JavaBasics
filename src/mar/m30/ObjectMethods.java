package mar.m30;

public class ObjectMethods {
  public static void add(Date d, int days) {
    int absDays = d.getYear() * 360 + d.getMonth() * 30 + d.getDay() + days;
    d.setYear(absDays / 360);
    d.setMonth ((absDays % 360 + 1) / 30);
    d.setDay(absDays % 30);
  }
  
  public static void copy(Date d1, Date d2) {
    d2.setDay(d1.getDay());
    d2.setMonth(d1.getMonth());
    d2.setYear(d1.getYear());
  }
  
  public static void main(String[] args) {
    Date d = new Date(1, 2, 2020);
    Date copy = new Date(d);
    d.add(90);
    System.out.println(d);
    add(d, 10);
    System.out.println(d);
    System.out.println(copy.days(d));
  }
}
