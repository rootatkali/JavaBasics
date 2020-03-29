package exclude;

import canvasML.Canvas;
import canvasML.Circle;
import canvasML.Line;

public class CanvasML {
  public static void drawX(int x, int y, int size, String color) {
    Line l1 = new Line(x, y, x + size, y + size, color);
    Line l2 = new Line(x, y + size, x + size, y, color);
  }
  
  public static void drawO(int x, int y, int size, String color) {
    Circle c1 = new Circle(x, y, size + 2, color);
    Circle c2 = new Circle(x + 1, y + 1, size, "white");
  }
  
  public static void main(String[] args) {
    drawX(10, 10, 40, "black");
    drawO(60, 10, 40, "black");
  }
}
