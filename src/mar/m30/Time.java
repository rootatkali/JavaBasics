package mar.m30;

public class Time {
  private int hours;
  private int minutes;
  private int seconds;
  
  public Time(int hours, int minutes, int seconds) {
    this.hours = hours;
    this.minutes = minutes;
    this.seconds = seconds;
  }
  
  public Time(Time t) {
    this(t.hours, t.minutes, t.seconds);
  }
  
  public int getHours() {
    return hours;
  }
  
  public void setHours(int hours) {
    this.hours = hours;
  }
  
  public int getMinutes() {
    return minutes;
  }
  
  public void setMinutes(int minutes) {
    this.minutes = minutes;
  }
  
  public int getSeconds() {
    return seconds;
  }
  
  public void setSeconds(int seconds) {
    this.seconds = seconds;
  }
  
  public int seconds(Time t) {
    int secs = 0;
    secs += (t.hours - this.hours) * 3600;
    secs += (t.minutes - this.minutes) * 60;
    secs += t.seconds - this.seconds;
    return secs;
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    
    Time t = (Time) o;
    
    return t.hours == hours && t.minutes == minutes && t.seconds == seconds;
  }
  
  @Override
  public String toString() {
    return "Time[hours=" + hours + ", minutes=" + minutes + ", seconds=" + seconds + "]";
  }
}
