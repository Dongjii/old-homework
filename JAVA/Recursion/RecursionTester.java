import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * Tester class for Recursion.
 * 
 * @author Dong Luu
 * @version 3 April 2018
 */
public class RecursionTester{
	String abc = "abcdefghijklmnopqrstuvwxyz";
	String test1 = "Dong";
	String test2 = "Luu";
	String test3 = "Slidell";
	String test4 = "Recursion";
	String test5 = "Heize";
	String test6 = "Younha";
	String test7 = "Brandon";
	String test8 = "California";
	
	ArrayList<String> stringArray = new ArrayList<>(Arrays.asList(abc, test1, test2, test3, test4, test5, test6, test7, test8));
	
	/**
	 * Tests example strings using compareTo method.
	 */
	@Test
	public void testCompareTo() {
		assertTrue(Recursion.compareTo(test1,abc) == 1);
		assertTrue(Recursion.compareTo(test4,test1) == 1);
		assertTrue(Recursion.compareTo(test1,test6) == -1);
		assertTrue(Recursion.compareTo(test5,test5) == 0);
		assertTrue(Recursion.compareTo(test1,test2) == -1);
		assertTrue(Recursion.compareTo(test3,test2) == 1);
		assertTrue(Recursion.compareTo(test1,test8) == 1);
		assertTrue(Recursion.compareTo(test7,test6) == -1);
		assertTrue(Recursion.compareTo(test5,test6) == -1);
		assertTrue(Recursion.compareTo(test4,test3) == -1);
		assertTrue(Recursion.compareTo(test7,test8) == -1);
	}
	
	/**
	 * Tests the findMinimum method.
	 */
	@Test
	public void testFindMinimum() {
		assertTrue((Recursion.findMinimum(stringArray)).equals(abc));
	}
}