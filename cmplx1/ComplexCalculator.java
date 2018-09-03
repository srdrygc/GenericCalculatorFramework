package edu.uab.cis.cmplx1;

import java.util.Scanner;

import edu.uab.cis.Calculator;

/**
 * Concrete Calculator class for computing with complex numbers.
 *
 * It just provides its own constructor, and overrides the
 * "factory"-method getTokenizer. Note, a "factory"-method is
 * responsible for creating new objects of a certain kind.
 */
public class ComplexCalculator extends Calculator
{
  public ComplexCalculator(String s) {
     super(s);
  }

  public ComplexTokenizer getTokenizer(String e) {
    return new ComplexTokenizer(e);
  }
}
