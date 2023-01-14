
/**
 * A class to model a complex number, including results after arithmetic.
 * 
 * @author Dong Luu
 * @version 3 February 2018
 */
public class ComplexNumber {
	// The instance variables a and b representing the real parts of the complex number
	private float a;
	private float b;
	
	/**
	 * Constructor that initializes <code>a</code> and <code>b</code> to values passed 
	 * as arguments.
	 * 
	 * @param a the new real a of the complex number
	 * @param b the new real b of the complex number
	 */
	public ComplexNumber(float a, float b) { 
		this.a = a; // a + bi
		this.b = b;
	}
	
	/**
	 * Returns value of the complex number's a
	 * 
	 * @return new a
	 */
	public float getA() {
		return this.a;
	}
	
	/**
	 * Returns value of the complex number's b
	 * 
	 * @return new b 
	 */
	public float getB() {
		return this.b;
	}
	
	/** 
	 * Adds complex numbers and returns the sum
	 *
	 * @param the other number that is added
	 * @return the sum of the complex numbers
	 */
	public ComplexNumber add(ComplexNumber otherNumber) {
		ComplexNumber newComplex;
		float newA = a + otherNumber.getA(); // new a of the complex number
		float newB = b + otherNumber.getB(); // new b of the complex number
		newComplex = new ComplexNumber(newA, newB); // new complex number
		return newComplex; // return the result
	}
	
	/**
	 * Subtracts complex numbers and return the difference
	 *
	 * @param the other number that will subtract
	 * @return the difference of the complex numbers
	 */
	public ComplexNumber subtract(ComplexNumber otherNumber) {
		ComplexNumber newComplex;
		float newA = a - otherNumber.getA();
		float newB = b - otherNumber.getB();
		newComplex = new ComplexNumber(newA, newB);
		return newComplex;
	}
	
	/**
	 * Multiplies complex numbers and returns the product
	 *
	 * @param the other number that will be multiplied
	 * @return the product of the complex numbers
	 */
	public ComplexNumber multiply(ComplexNumber otherNumber) {
		ComplexNumber newComplex;
		float newA = (a * otherNumber.getA()) - (b * otherNumber.getB());
		float newB = (b * otherNumber.getA()) + (a * otherNumber.getB());
		newComplex = new ComplexNumber(newA, newB);
		return newComplex;
	}
	
	/**
	 * Divides complex numbers and returns the quotient
	 *
	 * @param the other number that will be multiplied
	 * @return the quotient of the complex numbers
	 */
	public ComplexNumber divide(ComplexNumber otherNumber) {
		ComplexNumber newComplex;
		float newA = ((a * otherNumber.getA()) + (b * otherNumber.getB())) /
			((otherNumber.getA() * otherNumber.getA()) + (otherNumber.getB() * otherNumber.getB()));
		float newB = ((b * otherNumber.getA()) - (a * otherNumber.getB())) /
			((otherNumber.getA() * otherNumber.getA()) + (otherNumber.getB() * otherNumber.getB()));
		newComplex = new ComplexNumber(newA, newB);
		return newComplex;
	}
	
	/**
	 * Returns a string that represents and models a complex number
	 *
	 * @return representation of the complex number
	 */
	@Override
	public String toString() {
		return this.a + " + " + this.b + "i"; // a + bi
	}
	
	/**
	 * Makes sure that new complex are correct
	 *
	 * @param obj the complex number
	 * @return true for correct results and false for incorrect
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) { // check if instances are the same
			return true;
		}
		
		if (obj == null) { // check if parameter instance is null
			return false;
		}

		if (obj instanceof  ComplexNumber) { // make sure the two instances are of the same class
			ComplexNumber other = (ComplexNumber)obj; // cast instance to the tested class
			if (other.getA() == this.a && other.getB() == this.b) // check values
				return true;
		}
		return false;
	}
}