package may.m05;

import apr.a21.Point4D;

public class Line4D {
  private Point4D start;
  private Point4D end;
  
  public Line4D(Point4D start, Point4D end) {
    this.start = new Point4D(start);
    this.end = new Point4D(end);
  }
  
  public Line4D(int xs, int ys, int zs, int ts, int xe, int ye, int ze, int te) {
    this(new Point4D(xs, ys, zs, ts), new Point4D(xe, ye, ze, te));
  }
  
  public Line4D(Line4D l) {
    this(l.start, l.end);
  }
  
  public Point4D getStart() {
    return new Point4D(start);
  }
  
  public void setStart(Point4D start) {
    this.start = new Point4D(start);
  }
  
  public Point4D getEnd() {
    return new Point4D(end);
  }
  
  public void setEnd(Point4D end) {
    this.end = new Point4D(end);
  }
  
  @Override
  public String toString() {
    return "Line4D{" + "start=" + start + ", end=" + end + '}';
  }
  
  public boolean equals(Line4D l) {
    return toString().equals(l.toString());
  }
  
  /**
   * Calculates the length of the line.
   * @return A double.
   */
  public double length() {
    return end.distance(start);
  }
}
