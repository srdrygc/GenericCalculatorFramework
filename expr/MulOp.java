package edu.uab.cis.expr;

public class MulOp <N extends Expression<?>>
{
  public MulOp(Expression<?> left, Expression<?> right)
  {
    lhs = left;
    rhs = right;
  }

  public Expression<?> leftExp()  { return lhs; }
  public Expression<?> rightExp() { return rhs; }

  private Expression<?> lhs;
  private Expression<?> rhs;
}
