import static org.junit.Assert.*;
import org.junit.*;

/**
 * A class that tests the <code>ComplexNumber</code> class.
 *
 * @author Dong Luu
 * @version 3 February 2018
 */
public class ComplexNumberTest {
	private ComplexNumber cNum1;
	private ComplexNumber cNum2;
	private ComplexNumber cNum3;
	private ComplexNumber cNum4;
	
	/**
	 * Creates initial values for complex numbers.
	 */
	@Before
	public void setup() {
		cNum1 = new ComplexNumber(5.0f, 10.0f);
		cNum2 = new ComplexNumber(3.0f, 6.0f);
		cNum3 = new ComplexNumber(-1.0f, 5.0f);
		cNum4 = new ComplexNumber(3.0f, -15.0f);
	}
	
	/**
	 * Tests the <code>a</code> method.
	 */
	@Test
	public void testGetA() {
		assertEquals(5.0f, cNum1.getA(), 0.0f); // (value you expect, value you get)
		assertEquals(3.0f, cNum2.getA(), 0.0f);
		assertEquals(-1.0f, cNum3.getA(), 0.0f);
		assertEquals(3.0f, cNum4.getA(), 0.0f);	
	}
	
	/** 
	 * Tests the <code>b</code> method.
	 */
	@Test
	public void testGetB() {
		assertEquals(10.0f, cNum1.getB(), 0.0f);
		assertEquals(6.0f, cNum2.getB(), 0.0f);
		assertEquals(5.0f, cNum3.getB(), 0.0f);
		assertEquals(-15.0f, cNum4.getB(), 0.0f);
	}
	
	/**
	 * Tests the <code>add</code> method.
	 */
	@Test
	public void testAdd() {
		assertEquals(new ComplexNumber(8.0f, 16.0f), cNum1.add(cNum2));
		assertEquals(new ComplexNumber(-2.0f, -2.0f), new ComplexNumber(-1.0f, -1.0f).add(new ComplexNumber(-1.0f, -1.0f)));
		assertEquals(cNum4, cNum3.add(new ComplexNumber(4.0f, -20.0f)));
		assertEquals("3.0 + 6.0i", new ComplexNumber(0.0f, 21.0f).add(cNum4).toString()); // expect a string, result is a string
		assertEquals(new ComplexNumber(3.0f, 11.0f), cNum2.add(new ComplexNumber(0.0f, cNum3.getB())));
	}
	
	/**
	 * Tests the <code>subtract</code> method.
	 */
	@Test
	public void testSubtract() {
		assertEquals(new ComplexNumber(4.0f, 1.0f), cNum2.subtract(cNum3));
		assertEquals(new ComplexNumber(-5.0f, -5.0f), new ComplexNumber(5.0f, 5.0f).subtract(new ComplexNumber(10.0f, 10.0f)));
		assertEquals(cNum3, cNum1.subtract(new ComplexNumber(6.0f, 5.0f)));
		assertEquals("3.0 + 6.0i", new ComplexNumber(2.0f, 11.0f).subtract(cNum3).toString());
		assertEquals(cNum4, cNum2.subtract(new ComplexNumber(0.0f, 21.0f)));
	}
	
	/**
	 * Tests the <code>multiply</code> method.
	 */
	@Test
	public void testMultiply() {
		assertEquals(new ComplexNumber(-45.0f, 60.0f), cNum1.multiply(cNum2));
		assertEquals(new ComplexNumber(-12.0f, 8.0f), cNum3.multiply(new ComplexNumber (2.0f, 2.0f)));
		assertEquals("-12.0 + 8.0i", cNum3.multiply(new ComplexNumber (2.0f, 2.0f)).toString());
		assertEquals(new ComplexNumber(-6.0f, -48.0f), cNum4.multiply(new ComplexNumber(3.0f, -1.0f)));
	}
	
	/**
	 * Tests the <code>divide</code> method.
	 */
	@Test
	public void testDivide() {
		assertEquals(new ComplexNumber(1.7307693f, -1.3461539f), cNum1.divide(cNum3));
		assertEquals("-1.8 + -1.4i", cNum4.divide(cNum2).toString());
		assertEquals(new ComplexNumber(1.5f, -1.5f), cNum2.divide(new ComplexNumber(-1, 3)));
	}
	
	/**
	 * Tests the <code>toString</code> method.
	 */
	@Test
	public void testToString() {
		assertEquals("5.0 + 10.0i", cNum1.toString());
		assertEquals("3.0 + 6.0i", cNum2.toString());
		assertEquals("-1.0 + 5.0i", cNum3.toString());
		assertEquals("3.0 + -15.0i", cNum4.toString());
	}
	
	/**
	 * Tests the <code>equals</code> method. 
	 * Also checks for null.
	 */
	@Test
	public void testEquals() {
		assertEquals(new ComplexNumber(5.0f, 10.0f), cNum1);
		assertEquals(new ComplexNumber(3.0f, 6.0f), cNum2);
		assertEquals(new ComplexNumber(-1.0f, 5.0f), cNum3);
		assertEquals(new ComplexNumber(3.0f, -15.0f), cNum4);
		ComplexNumber cNum5 = null;
		assertFalse(cNum1.equals(cNum5));
	}
}