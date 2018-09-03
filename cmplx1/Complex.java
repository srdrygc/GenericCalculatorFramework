package edu.uab.cis.cmplx1;

import edu.uab.cis.Number;

/** An immutable class representing complex values. */
public class Complex extends Number
{
  /**
   * constructs a new Complex object.
   *
   * @param real real part
   * @param imag imaginary part
   * @return
   */
  public Complex(double real, double imag)
  {
    re = real;
    im = imag;
  }

  /**
   * computes this+that.
   *
   * @param that another complex value
   * @return a complex number
   */
  public Complex add(Number<?> other)
  {
    Complex that = (Complex) other;
    return new Complex(this.re + that.re, this.im + that.im);
  }

  /**
   * computes this-that.
   *
   * @param rhs another complex value
   * @return a complex number
   */
  public Complex sub(Number<?> other) {
	  Complex that = (Complex) other;
    return new Complex(this.re - that.re, this.im - that.im);
  }

  /**
   * computes this*that.
   *
   * @param that another complex value
   * @return a complex number
   */
  public Complex mul(Number<?> other) {
	  Complex that = (Complex) other;
    double real = this.re * that.re - this.im * that.im;
    double imag = this.re * that.im + this.im * that.re;

    return new Complex(real, imag);
  }

  /**
   * Computes the conjugate for division.
   *
   * @return a complex number
   */
  private Complex conjugate() {
    return new Complex(re, -im);
  }

  /**
   * computes this/that.
   *
   * @param that another complex value
   * @return a complex number
   */
  public Complex div(Number<?> other)
  {
    Complex that      = (Complex) other;
    Complex conj      = that.conjugate();
    Complex numerator = this.mul(conj);
    Complex divisor   = that.mul(conj);

    assert Math.abs(divisor.getImaginary()) < 0.0001;
    return new Complex(numerator.getReal() / divisor.getReal(),
                        numerator.getImaginary() / divisor.getReal()
                      );
  }

  /**
   * computes a String representation of the complex number.
   *
   * @param that another complex value
   * @return a string in the format of (re + im i)
   */
  public String toString()
  {
    String imstr = (im >= 0) ? " + " + im : " - " + (-im);

    return "(" + re + imstr + "i)";
  }

  /**
   * returns the imaginary part.
   * @return a double reflecting the imaginary component.
   */
  public double getImaginary()
  {
    return im;
  }

  /**
   * returns the real part.
   * @return a double reflecting the real component.
   */
  public double getReal()
  {
    return re;
  }

  private double re;
  private double im;
}
