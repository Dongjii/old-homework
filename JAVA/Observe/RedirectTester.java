import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.*;
import org.junit.*;

/**
 * Test for <code>Dog</code> and <code>DogTrainer</code>.
 *
 *@author Dong Luu
 *@version 22 February 2018
 */
public class RedirectTester {
	private ByteArrayOutputStream output = new ByteArrayOutputStream();
	private ByteArrayOutputStream errorOutput =
	new ByteArrayOutputStream();
	
	private Dog kino;
	private Dog kien;
	private DogTrainer dongwoo;
	private DogTrainer dongji;
	
	/**
	 *Create test fixtures before run
	 */
	@Before
	public void setup() {
		kino = new Dog(15.0f, 25.0f, "Kino");
		kien = new Dog(12.0f, 24.0f, "Kien");
		dongwoo = new DogTrainer("Dongwoo");
		dongji = new DogTrainer("Dongji");
		kino.addObserver(dongwoo);
		kien.addObserver(dongji);

		
		System.setOut(new PrintStream(output));
		System.setErr(new PrintStream(errorOutput));
	} // end @Before method
	
	/**
	 * Test <code>poop</code> method for kino.
	 */
	@Test
	public void testStdOutOne() {		
		kino.poop();
		assertEquals("I pooped today!\r\nHey, Dongwoo was notified that Kino pooped.\r\n",
			output.toString());
	}
	
	/**
	 * Test <code>poop</code> method for kien.
	 */
	@Test
	public void testStdTwo() {
		kien.poop();
		assertEquals("I pooped today!\r\nHey, Dongji was notified that Kien pooped.\r\n", 
			output.toString());
	}
	
	/**
	 * Reset output and error.
	 */
	@After
	public void resetStreams() {
		System.setOut(System.out);
		System.setErr(System.err);
	} // end @After method
}