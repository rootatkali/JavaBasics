package helper;

import java.io.Serializable;
import java.math.BigInteger;

public class Fraction extends Number implements Serializable, Comparable<Fraction> {
  private static final long serialVersionUID = 1L;
  
  public static final Fraction MAX_VALUE = new Fraction(Long.MAX_VALUE, 1);
  public static final Fraction MIN_VALUE = new Fraction(Long.MIN_VALUE, 1);
  public static final Fraction ZERO = new Fraction(0);
  public static final Fraction ONE = new Fraction(1);
  public static final Fraction MIN_POS_VALUE = MAX_VALUE.invert();
  public static final Fraction MAX_NEG_VALUE = MIN_VALUE.invert();
  
  private final long top;
  private final long bottom;
  
  public Fraction(int i) {
    this(i, 1);
  }
  
  public Fraction(long top, long bottom) {
    if (bottom == 0) throw new IllegalArgumentException("Bottom cannot be 0");
  
    long gcd = gcd(top, bottom);
    top /= gcd;
    bottom /= gcd;
    
    this.top = top;
    this.bottom = bottom;
  }
  
  /**
   * Mixed fraction
   * @param whole
   * @param fractional
   */
  public Fraction(int whole, Fraction fractional) {
    this(
        (whole * fractional.bottom) + fractional.top,
        fractional.bottom
    );
  }
  
  public long gcd(long top, long bottom) {
    BigInteger bTop = BigInteger.valueOf(top);
    BigInteger bBottom = BigInteger.valueOf(bottom);
    return bTop.gcd(bBottom).intValue();
  }
  
  public int getSign() {
    if (top == 0) return 0;
    int sign = 1;
    sign *= Math.abs(top) / top;
    sign *= Math.abs(bottom) / bottom;
    return sign;
  }
  
  public Fraction negate() {
    return new Fraction(-top, bottom);
  }
  
  public Fraction invert() {
    return new Fraction(bottom, top);
  }
  
  public Fraction abs() {
    return new Fraction(Math.abs(top), Math.abs(bottom));
  }
  
  public Fraction multiply(Fraction f) {
    return new Fraction(this.top * f.top, this.bottom * f.bottom);
  }
  
  public Fraction multiply(int i) {
    return multiply(new Fraction(i, 1));
  }
  
  public Fraction divide(Fraction f) {
    return this.multiply(f.invert());
  }
  
  public Fraction add(Fraction f) {
    long commonMultiplier = bottom * f.bottom;
    long newTop = (top * f.bottom) + (f.top * bottom);
    return new Fraction(newTop, commonMultiplier);
  }
  
  public Fraction subtract(Fraction f) {
    return this.add(f.negate());
  }
  
  @Override
  public int intValue() {
    return (int) Math.round(doubleValue());
  }
  
  @Override
  public long longValue() {
    return Math.round(doubleValue());
  }
  
  @Override
  public float floatValue() {
    return (float) top / (float) bottom;
  }
  
  @Override
  public double doubleValue() {
    return (double) top / (double) bottom;
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    
    Fraction f = (Fraction) o;
    
    return top == f.top && bottom == f.bottom;
  }
  
  @Override
  public String toString() {
    if (bottom == 1) return Long.toString(top);
    return String.format("%d/%d", top, bottom);
  }
  
  /**
   * Compares two Fractions by subtracting them and returning the sign of the result.
   * @param f The Fraction to subtract from this.
   * @return 1 if this is greater than f, 0 if this and f are equal, and -1 if f is greater.
   */
  @Override
  public int compareTo(Fraction f) {
    Fraction result = this.subtract(f);
    return result.getSign();
  }
}
