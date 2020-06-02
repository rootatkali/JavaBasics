package jun.j01;

public class Main {
  public static void main(String[] args) {
    Runner r1 = new Runner("012345678", 1990, 10);
    MrtnRace m1 = new MrtnRace("ISR", 2020, 100);
    m1.addRunner(r1);
    m1.addScoreToRunner(r1.getId(), 10);
    System.out.println(r1);
  }
}
