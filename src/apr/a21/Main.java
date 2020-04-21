package apr.a21;

public class Main {
  public static void main(String[] args) {
    Point4D origin = new Point4D(0, 0, 0, 0);
    Point4D unit = new Point4D(1, 1, 1, 1);
  
    System.out.println(unit.distance(origin));
    System.out.println(origin.distance(unit));
  }
}
