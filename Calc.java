package edu.uab.cis;

import java.util.Scanner;

import edu.uab.cis.cmplx1.ComplexCalculator;
import edu.uab.cis.fraction.FractionCalculator;

/**
 * Calculator Tester
 */
public class Calc <C, F>
{
  private static final int CMPLX_CALC = 1;
  private static final int FRACT_CALC  = 2;

  /**
   * Generates a new calculator object (factory function)
   */
  public static Calculator<?, ?> calculator(int calctype, String s)
  {
    Calculator<?, ?> res = null;

    switch (calctype)
    {
      case CMPLX_CALC: res = new ComplexCalculator(s);
                       break;

      case FRACT_CALC: res = new FractionCalculator(s);
                       break;

      default: assert(false);
    }

    assert res != null;
    return res;
  }

  /**
   * main - test driver
   *
   * Reads an expression from the standard input stream
   * and prints the output to the console
   *
   * @param args unused
   */
  public static void main(String[] args)
  {
    Scanner sc       = new Scanner(System.in);
    int     calctype = CMPLX_CALC;

    while (sc.hasNextLine())
    {
      String inp = sc.nextLine();

      if ("complex".equals(inp))
      {
        calctype = CMPLX_CALC;
      }
      else if ("fraction".equals(inp))
      {
        calctype = FRACT_CALC;
      }
      else
      {
        Number res = calculator(calctype, inp).compute();

        System.out.println(res.toString());
      }
    }
  }
}