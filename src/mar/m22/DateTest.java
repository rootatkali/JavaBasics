package mar.m22;

public class DateTest {
  public static void main(String[] args) {
    Date d = new Date(10, 11, 2020);
    Date dt = new Date(9, 12, 2019);
    System.out.println(d.isBefore(dt));
  }
}
