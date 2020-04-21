package apr.a21;

import java.util.Arrays;

public class PointXD {
  private int[] coord;
  
  public PointXD(int... coord) {
    int[] coordNew = new int[coord.length];
    this.coord = coordNew;
    
    for (int i = 0; i < coord.length; i++) {
      coordNew[i] = coord[i];
    }
  }
  
  public int[] getCoord() {
    int[] coordNew = new int[coord.length];
    for (int i = 0; i < coord.length; i++) {
      coordNew[i] = coord[i];
    }
    return coordNew;
  }
  
  public void setCoord(int[] coord) {
    int[] coordNew = new int[coord.length];
    this.coord = coordNew;
  
    for (int i = 0; i < coord.length; i++) {
      coordNew[i] = coord[i];
    }
  }
  
  public void setCoord(int idx, int val) {
    coord[idx] = val;
  }
  
  @Override
  public String toString() {
    return "PointXD{" + "coord=" + Arrays.toString(coord) + '}';
  }
}
