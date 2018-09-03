package edu.uab.cis.fraction;

import java.util.Scanner;

import edu.uab.cis.Calculator;

/**
 * Concrete Calculator class for computing with fractions.
 *
 * It just provides its own constructor, and overrides the
 * "factory"-method getTokenizer. Note, a "factory"-method is
 * responsible for creating new objects of a certain kind.
 */
public class FractionCalculator extends Calculator
{
  public FractionCalculator(String s)
  {
     super(s);
  }

  public FractionTokenizer getTokenizer(String e)
  {
    return new FractionTokenizer(e);
  }
}
