package apr.a21;

public class Main {
  public static void main(String[] args) {
    Point4D origin = new Point4D(0, 0, 0, 0);
    Point4D unit = new Point4D(1, 1, 1, 1);
    System.out.println(unit.distance(origin));
    System.out.println(origin.distance(unit));
  
    System.out.println();
    
    PointXD origin4D = new PointXD(origin);
    PointXD two = new PointXD(2, 2, 2, 2);
    System.out.println(two.distance(origin4D));
    System.out.println(two.toString());
    System.out.println(two.convert4D().toString());
  }
}
