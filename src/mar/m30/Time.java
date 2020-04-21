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
  
  public boolean isBefore(Time t) {
    if (t.hours > hours) return true;
    if (t.hours < hours) return false;
    if (t.minutes < minutes) return false;
    if (t.minutes > minutes) return true;
    return t.seconds > seconds;
  }
  
  public boolean isAfter(Time t) {
    return !(this.isBefore(t) || this.equals(t));
  }
  
  public int seconds(Time t) {
    int secs = 0;
    secs += (t.hours - this.hours) * 3600;
    secs += (t.minutes - this.minutes) * 60;
    secs += t.seconds - this.seconds;
    return secs;
  }
  
  public String format() {
    StringBuilder sb = new StringBuilder();
    sb.append(hours > 9 ? hours : "0" + hours).append(":");
    sb.append(minutes > 9 ? minutes : "0" + minutes).append(":");
    sb.append(seconds > 9 ? seconds : "0" + seconds);
    return sb.toString();
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
