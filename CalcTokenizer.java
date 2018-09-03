package edu.uab.cis;

import java.util.Scanner;

/**
 * Abstract Tokenizer that generates a token stream of an input string.
 *
 * The implementation attempts to match the token descriptions
 * against the input.
 *
 * It recognizes parenthesis, and operators +,-,/,*, but defers
 * the recognition of numbers to the concrete subclass.
 */
public abstract class CalcTokenizer
{
  /** Constructs a new scanner with the input that needs to be processed
   *
   *  @param s input
   */
  public CalcTokenizer(String s)
  {
    assert s != null : "Invalid input string";

    setScanner(new Scanner(s));
    getScanner().useDelimiter("");
  }

  /**
   * Tests whether token is a valid token.
   *
   * @param token a String that contains a candidate token
   * @return true, iff token is valid; false otherwise
   */
  private static boolean isValidToken(String token)
  {
    String[] validTokens = new String[] { "(", ")", "*", "-", "/", "+" };

    for (String aToken : validTokens) {
      if (aToken.equals(token)) return true;
    }
    return false;
  }

  /**
   * Auxiliary method that tests whether the next token starts
   * with a digit. Can be used by various subclasses.
   *
   * @return true, iff next token starts with a digit.
   */
  public boolean hasNextDigit()
  {
    for (int i = 0; i < 10; ++i)
      if (getScanner().hasNext(""+i)) return true;

    return false;
  }

  /**
   * Auxiliary method that tests whether the next token starts
   * with a period. Can be used by various subclasses.
   *
   * @return true, iff next token starts with a period.
   */
  public boolean hasNextPeriod()
  {
    return getScanner().hasNext("\\.");
  }

  /**
   * Abstract method that recognizes specific number formats.
   * Has to be overriden by subclass.
   */
  public abstract boolean hasNextNumber();

  /**
   * Abstract method that tokenizes a specific number formats.
   * Has to be overriden by subclass.
   */
  public  abstract Number nextNumber();

  /**
   * reads the next token from the input and matches
   * the kind of tokens.
   */
  public void consume()
  {
    if (!getScanner().hasNext())
    {
      tokenKnd = "invalidToken";
      return;
    }

    if (hasNextNumber())
    {
      tokenKnd = "Number";
      tokenVal = nextNumber();
      return;
    }

    tokenKnd = getScanner().next();
    if (" ".equals(tokenKnd))
    {
      consume();
      return;
    }

    assert isValidToken(tokenKnd);
  }

  /**
   * returns the current token kind.
   */
  public String currTokenKind()
  {
    return tokenKnd;
  }

  /**
   * Returns the Float representation of the token
   *
   * @return Float object for the current token
   */
  public Number getValue()
  {
    return tokenVal;
  }

  /**
   * returns the current scanner.
   *
   * @return scanner associated with this tokenizer
   */
  public Scanner getScanner()
  {
    return scanner;
  }

  /**
   * Sets the scanner. Note, we do not want sublcasses to modify or
   * use this method. Hence it is private.
   *
   * @param scanner a Scanner associated with this tokenizer
   */
  private void setScanner(Scanner scanner)
  {
    this.scanner = scanner;
  }

  /** Tokenizer that chops up the input string */
  private Scanner         scanner;

  /** Textual representation of last token matched */
  private Number         tokenVal;

  /** Describes the kind of token that was matched */
  private String          tokenKnd;
}