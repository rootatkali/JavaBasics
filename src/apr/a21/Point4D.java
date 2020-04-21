package apr.a21;

public class Point4D {
  private int x;
  private int y;
  private int z;
  private int t;
  
  /*
   * Generates a 4-dimensional points with coordinates (x, y, z, t).
   */
  public Point4D(int x, int y, int z, int t) {
    this.x = x;
    this.y = y;
    this.z = z;
    this.t = t;
  }
  
  /*
   * Generates a 4-dimensional points from other point.
   */
  public Point4D(Point4D p) {
    this(p.x, p.y, p.z, p.t);
  }
  
  public int getX() {
    return x;
  }
  
  public void setX(int x) {
    this.x = x;
  }
  
  public int getY() {
    return y;
  }
  
  public void setY(int y) {
    this.y = y;
  }
  
  public int getZ() {
    return z;
  }
  
  public void setZ(int z) {
    this.z = z;
  }
  
  public int getT() {
    return t;
  }
  
  public void setT(int t) {
    this.t = t;
  }
  
  @Override
  public String toString() {
    return "Point4D{" + "x=" + x + ", y=" + y + ", z=" + z + ", t=" + t + '}';
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    
    Point4D p = (Point4D) o;
  
    return (x == p.x) && (y == p.y) && (z == p.z) && (t == p.t);
  }
  
  /*
   * Calculates the distance between this and another point.
   */
  public int distance(Point4D p) {
    double result = 0.0;
    
    result += Math.pow((x - p.x), 2);
    result += Math.pow((y - p.y), 2);
    result += Math.pow((z - p.z), 2);
    result += Math.pow((t - p.t), 2);
    
    result = Math.sqrt(result);
    return (int) result;
  }
}
