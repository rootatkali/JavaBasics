package mar.m03;

import basics.Point2D;
import canvasML.Line;

import static helper.Helper.*;

public class Polygons {
  public static void draw(Point2D[][] mat) {
    Line line = new Line(0, 0, 0, 0, "black");
    for (int r = 0; r < mat.length; r++) {
      for (int c = 0; c < mat[r].length; c++) {
        line.setPoints(
            ((int) mat[r][c].getX()),
            ((int) mat[r][c].getY()),
            ((int) mat[r][(c + 1) % mat[r].length].getX()),
            ((int) mat[r][(c + 1) % mat[r].length].getY())
        );
        line.draw();
      }
    }
  }
  
  public static void main(String[] args) {
    Point2D[][] points = new Point2D[10][10];
    for (int i = 0; i < points.length; i++) {
      for (int j = 0; j < points[i].length; j++) {
        points[i][j] = new Point2D(rand(0, 600), rand(0, 400));
      }
    }
    draw(points);
  }
}
