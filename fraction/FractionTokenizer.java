package edu.uab.cis.fraction;

import java.util.Scanner;

import edu.uab.cis.CalcTokenizer;
import edu.uab.cis.Number;

/**
 * Tokenizer for fractions.
 */
public class FractionTokenizer extends CalcTokenizer
{
  /**
   * Constructs a ComplexTokenizer by invoking base class constructor.
   * @param s input
   */
  FractionTokenizer(String s)
  {
    super(s);
  }

  /**
   * Tests whether next token is a number.
   */
  public boolean hasNextNumber()
  {
    return hasNextDigit();
  }

  /**
   * Tokenizes next number
   */
  public Number nextNumber()
  {
    Scanner scanner = getScanner();
    String  val = scanner.next();

    while (hasNextDigit())
    {
      val = val + scanner.next();
    }

    int      magnitude = Integer.parseInt(val);
    Fraction res = new Fraction(magnitude, 1);

    assert res != null;
    return res;
  }
}