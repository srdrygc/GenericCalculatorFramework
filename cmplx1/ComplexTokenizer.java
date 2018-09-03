package edu.uab.cis.cmplx1;

import java.util.Scanner;

import edu.uab.cis.Number;
import edu.uab.cis.CalcTokenizer;

/**
 * Tokenizer for complex number.
 */
public class ComplexTokenizer extends CalcTokenizer
{
  /**
   * Constructs a ComplexTokenizer by invoking base class constructor.
   * @param s input
   */
  ComplexTokenizer(String s)
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

    if (hasNextPeriod())
    {
      val = val + scanner.next();

      while (hasNextDigit())
      {
        val = val + scanner.next();
      }
    }

    if (scanner.hasNext("e") || scanner.hasNext("E"))
    {
      val = val + scanner.next();

      if (scanner.hasNext("\\+") || scanner.hasNext("-"))
        val = val + scanner.next();

      while (hasNextDigit())
      {
        val = val + scanner.next();
      }
    }

    double  magnitude = Double.parseDouble(val);
    Complex res = null;

    if (!scanner.hasNext("i"))
    {
      res = new Complex(magnitude, 0);
    }
    else
    {
      scanner.next(); // consume "i"
      res = new Complex(0, magnitude);
    }

    assert res != null;
    return res;
  }
}