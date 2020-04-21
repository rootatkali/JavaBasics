package apr.a21;

import java.util.Arrays;

public class PointXD {
  private int[] coord;
  
  public PointXD(int... coord) {
    setCoord(coord); // Creates new array
  }
  
  public PointXD(Point4D p) {
    this(p.getX(), p.getY(), p.getZ(), p.getT()); // Calls constructor with new array
  }
  
  public PointXD(PointXD p) {
    this(p.coord); // Calls constructor with other point
  }
  
  public int[] getCoord() {
    int[] coordNew = new int[coord.length];
    // copy array
    for (int i = 0; i < coord.length; i++) {
      coordNew[i] = coord[i];
    }
    return coordNew;
  }
  
  public void setCoord(int[] coord) {
    int[] coordNew = new int[coord.length];
    this.coord = coordNew;
    // Copy array
    for (int i = 0; i < coord.length; i++) {
      coordNew[i] = coord[i];
    }
  }
  
  public void setCoord(int idx, int val) {
    coord[idx] = val;
  }
  
  public int distance(PointXD p) {
    double result = 0.0;
    
    if (p.coord.length != this.coord.length) {
      throw new IllegalArgumentException("Dimensions do not match.");
    }
    
    for (int i = 0; i < coord.length; i++) {
      result += Math.pow(coord[i] - p.coord[i], 2);
    }
    result = Math.sqrt(result);
    return (int) result;
  }
  
  public Point4D convert4D() {
    int x = coord[0], y = 0, z = 0, t = 0;
    if (coord.length >= 2) { // Check for length, each check add another point. Defaults to 0.
      y = coord[1];
      if (coord.length >= 3) {
        z = coord[2];
        if (coord.length >= 4) {
          t = coord[3];
        }
      }
    }
    return new Point4D(x, y, z, t);
  }
  
  @Override
  public String toString() {
    return "PointXD{" + "coord=" + Arrays.toString(coord) + '}';
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    
    PointXD pointXD = (PointXD) o;
  
    return Arrays.equals(coord, pointXD.coord);
  }
}
