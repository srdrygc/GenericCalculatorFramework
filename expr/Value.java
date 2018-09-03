package edu.uab.cis.expr;

public class Value<N extends Expression>
{
  public Value(N v)
  {
    val = v;
  }

  public N getValue() { return val; }

  private N val;
}
