package edu.uab.cis.fraction;

import edu.uab.cis.Number;

/**
 * A class representing fraction of Integer.
 * @param <N>
 */
public abstract class Fraction<F extends Number>
{
  /**
   * Constructs a new Fraction.
   *
   * @param n numerator
   * @param d denominator
   * @precondition n != null && d != null && d != Integer(0)
   */
  public <F> Fraction(Integer n, Integer d)
  {
    num = n;
    denom = d;
  }

  /**
   * returns a String representation for the Fraction.
   * @return a textual representation of this fraction
   */
  public <F> String toString()
  {
    if (denom == 1) return "" + num;

    return num + " / " + denom;
  }

  /**
   * adds two fraction and simplifies the result.
 * @param <N>
   * @param that right hand side argument
   * @return this+that
   */
  public <F> Fraction add(F other)
  {
    Fraction that = (Fraction) other;
    Integer newDenom = this.getDenominator() * that.getDenominator();
    Integer thisNum  = this.getNumerator() * that.getDenominator();
    Integer thatNum  = that.getNumerator() * this.getDenominator();

    return simplify(thisNum + thatNum, newDenom);
  }

  /**
   * subtracts two fractions and simplifies the result.
   * @param that right hand side argument
 * @return 
   * @return this-that
   */
  public <F> Fraction sub(F other)
  {
    Fraction that = (Fraction) other;
    Integer newDenom = this.getDenominator() * that.getDenominator();
    Integer thisNum  = this.getNumerator()   * that.getDenominator();
    Integer thatNum  = that.getNumerator()   * this.getDenominator();

    return simplify(thisNum - thatNum, newDenom);
  }


  /**
   * multiplies two fraction and simplifies the result.
   * @param that right hand side argument
   * @return this*that
   */
  public <F> Fraction mul(F other)
  {
    Fraction that = (Fraction) other;
    Integer newNum   = this.getNumerator()   * that.getNumerator();
    Integer newDenom = this.getDenominator() * that.getDenominator();

    return simplify(newNum, newDenom);
  }

  /**
   * divides this fraction by another fraction.
   * @param that right hand side argument
   * @return this/that
   */
  public <F> Fraction div(F other)
  {
    Fraction that = (Fraction) other;
    Integer newNum   = this.getNumerator()   * that.getDenominator();
    Integer newDenom = this.getDenominator() * that.getNumerator();

    return simplify(newNum, newDenom);
  }

  /**
   * returns the numerator.
   * @return numerator
   */
  public Integer getNumerator()
  {
    return num;
  }

  /**
   * returns the denominator.
   * @return denominator
   */
  public Integer getDenominator()
  {
    return denom;
  }

  /**
   * Computes the quotient of the fraction.
   * @return a new object representing the quotient of this/that
   */
  public Integer getQuotient()
  {
    return num / denom;
  }

  /**
   * Computes the remainder of the fraction.
   * @return a new object representing the remainder of this/that
   */
  public Integer getRemainder()
  {
    return num % denom;
  }

  /**
   * Computes the floating point value of the fraction.
   * @result a floating point number that approximates this fraction
   */
  public Double doubleValue()
  {
    return (double)num / denom;
  }

  /* private utility methods */

  /**
   * computes the common greatest divisor of a and b.
   *
   * note, the method is static, since it does not access any
   * instance variables.
   *
   * @param a an integer
   * @param b an integer
   * @return an integer that is the greatest common divisor of a and b
   */
  private static Integer gcd(Integer a, Integer b)
  {
    if (0 == b) return a;

    return gcd(b, a % b);
  }

  /**
   * Simplifies the fraction num/denom by dividing both by their
   * greatest common divisor.
   *
   * note, the method is static, since it does not access any
   * instance variables.
   *
   * @param num numerator
   * @param denom denominator
   * @return new fraction (num / gcd(num,denom)) / (denom / gcd(num,denom))
   */
  private static Fraction simplify(Integer num, Integer denom)
  {
    Integer gcd        = gcd(num, denom);
    Integer numSimpl   = num / gcd;
    Integer denomSimpl = denom / gcd;

    if (denomSimpl < 0)
    {
      numSimpl = -numSimpl;
      denomSimpl = -denomSimpl;
    }

    return new Fraction(numSimpl, denomSimpl);
  }

  /* instance variables (fields) */

  /** the numerator. */
  private Integer num;

  /** the denominator. */
  private Integer denom;
}