package edu.uab.cis.expr;

public class SubOp <N extends Expression<?>>
{
  public SubOp(Expression<?> left, Expression<?> right)
  {
    lhs = left;
    rhs = right;
  }

  public Expression<?> leftExp()  { return lhs; }
  public Expression<?> rightExp() { return rhs; }

  private Expression<?> lhs;
  private Expression<?> rhs;
}
