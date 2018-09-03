package edu.uab.cis.expr;

import edu.uab.cis.Number;

/** An immutable class representing Expression values. */
abstract public class Expression extends Number
{
  /**
   * represents this+that.
   *
   * @param other another expression
   * @return an expression tree
   */
  public Expression add(Number other)
  {
    return new AddOp(this, (Expression) other);
  }

  /**
   * represents this-that.
   *
   * @param other another expression
   * @return an expression tree
   */
  public Expression sub(Number other)
  {
    return new SubOp(this, (Expression) other);
  }

  /**
   * represents this*that.
   *
   * @param other another expression
   * @return an expression tree
   */
  public Expression mul(Number other)
  {
    return new MulOp(this, (Expression) other);
  }

  /**
   * represents this/that.
   *
   * @param other another expression
   * @return an expression tree
   */
  public Expression div(Number other)
  {
    return new DivOp(this, (Expression) other);
  }
}
