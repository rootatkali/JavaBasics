import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;

import canvasML.*;
public class Countdown {
  
  public static void countd() {
    Canvas c = Canvas.getCanvas();
    c.setFont(new Font("Assistant Light", Font.PLAIN, 24));
    int hrs;
    Color co = new Color(255,255,255);
    c.drawString("Rotem's birthday countdown!",120, 100);
    c.drawString("Seconds", 450, 250);
    c.drawString("Minutes", 330, 250);
    c.drawString("Hours", 190, 250);
    c.drawString("Days", 90, 250);
    c.setBackgroundColour(co);
    c.setFont(new Font("Consolas", Font.BOLD, 96));
    while (true) {
      
      Date date = new Date();
      SimpleDateFormat sidf = new SimpleDateFormat("dd/MM/yy");
      String t = sidf.format(date);
      String[] timee = t.split("/");
      SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
      Date da = new Date();
      String time = sdf.format(da);
      String[] times = time.split(":");
      int h = Integer.parseInt(times[0]);
      
      int m = Integer.parseInt(times[1]);
      
      int s = Integer.parseInt(times[2]);
      
      int d = Integer.parseInt(timee[0]);
      int mins;
      int day = (19 - d);
      int secs = (60 - s);
      if (m > 51)
        mins = 60 + 51 - m;
      else
        mins = (51 - m);
      
      if (secs == 60)
        secs = 0;
      if (h > 12)
        hrs = (36 - h);
      else
        hrs = 12 - h;
      
      
      c.drawString(Integer.toString(secs), 450, 200);
      c.drawString(Integer.toString(mins), 330, 200);
      c.drawString(Integer.toString(hrs), 190, 200);
      c.drawString(Integer.toString(day), 90, 200);
      c.wait(1000);
      c.setBackgroundColour(co);
      c.eraseString(Integer.toString(secs), 450, 200);
      c.eraseString(Integer.toString(mins), 330, 200);
      c.eraseString(Integer.toString(hrs), 210, 200);
    }
    
  }
  
  public static void main(String[] args) {
    countd();
  }
  
}