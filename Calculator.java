package edu.uab.cis;

/**
 * Abstract Calculator class
 *
 * The calculator is invoked through { @link #compute }.
 * This class is abstract, so that it can be extended for specific
 * numeric types. Hence, we use abstract Number objects.
 */
public abstract class Calculator <N extends Number, T extends CalcTokenizer>
{
  public Calculator(String expr)
  {
    tokenizer = getTokenizer(expr);
  }

  /**
   * Abstract method that determines the tokenizer in use,
   * and consequently the numeric type that the calculator uses.
   */
  public abstract CalcTokenizer getTokenizer(String e);

  // calculation

  /**
   * Handles optional parenthesis, otherwise parses the next number.
   *
   * @return the next floating point value
   */
  private Number parVal()
  {
    Number res = null;
    String kind = tokenizer.currTokenKind();

    if ("(".equals(kind))
    {
      tokenizer.consume();
      res = addop();

      if (")".equals(tokenizer.currTokenKind()))
      {
        // consume closing parenthesis
        tokenizer.consume();
      }
      else
      {
        assert false : "wrong input";
      }
    }
    else
    {
      assert "Number".equals(kind) : "wrong input";

      res = tokenizer.getValue();
      tokenizer.consume();
    }

    assert res != null;
    return res;
  }

  /**
   * Tests whether a token is either mul or div
   *
   * @param k a token
   */
  static boolean isMulDivKind(String k)
  {
    return "*".equals(k) || "/".equals(k);
  }

  /**
   * Handles multiplication/division, otherwise returns next number
   *
   * @return computed value
   */
  private Number mulop()
  {
    Number res = parVal();
    String  op  = tokenizer.currTokenKind();

    while (isMulDivKind(op)) {
      tokenizer.consume();
      Number rhs = parVal();

      if ("*".equals(op))
      {
        res = res.mul(rhs);
      }
      else
      {
        assert "/".equals(op);
        res = res.div(rhs);
      }

      op = tokenizer.currTokenKind();
    }

    assert res != null;
    return res;
  }


  /**
   * Tests whether a token is either plus or minus
   *
   * @param k a token
   */
  static boolean isPlusMinusKind(String k)
  {
    return "+".equals(k) || "-".equals(k);
  }


  /**
   * Handles addition/subtraction, otherwise returns next number
   *
   * @return computed value
   */
  private Number addop()
  {
    Number res = mulop();
    String op  = tokenizer.currTokenKind();

    while (isPlusMinusKind(op))
    {
      tokenizer.consume();
      Number rhs = mulop();

      if ("+".equals(op))
      {
        res = res.add(rhs);
      }
      else
      {
        assert "-".equals(op);
        res = res.sub(rhs);
      }

      op = tokenizer.currTokenKind();
    }

    assert res != null;
    return res;
  }

  /**
   * Computes the value for a given expression.
   *
   * @param expr input expression
   * @return computed value
   * @throws RuntimeException if the input is not valid
   */
  public Number compute()
  {
    assert tokenizer != null;
    tokenizer.consume();
    return addop();
  }

  /** We use a simple tokenizer to chop up the input stream. */
  private CalcTokenizer tokenizer;
}