package edu.uab.cis;

/**
 * Abstract base class for any number + arithmetic operations.
 */
public class Number<N>
{
  /**
   * computes this+that.
   *
   * @param that anthat complex value
   * @return a number of the same type
   */
  public <N> Number add(Number<N> that) {
	return null;
}

  /**
   * computes this*that.
   *
   * @param that anthat complex value
   * @return a number of the same type
   */
  public <N> Number mul(Number<N> that) {
	return null;
}

  /**
   * computes this/that.
   *
   * @param that anthat complex value
   * @return a number of the same type
   */
  public <N> Number<?> div(Number<N> that) {
	return null;
}

  /**
   * computes this-that.
   *
   * @param that anthat complex value
   * @return a number of the same type
   */
  public <N> Number<?> sub(Number<N> that) {
	return null;
}
}