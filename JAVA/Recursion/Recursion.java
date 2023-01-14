import java.util.ArrayList;

/**
 * Recursion class that uses compareTo to compare two string to determine alphabetical order
 * and findMinimum to show which string comes first in the array.
 *
 * @author Dong Luu
 * @version 3 April 2018
 */
public class Recursion {
	private static int  index = 0;
	
	/**
	 * Compares two strings and returns either -1, 0, or 1 
	 * 
	 * @param String s1 first string
	 * @param String s2 second string
	 * @return value of -1, 0, or 1
	 */
	public static int compareTo(String s1, String s2) {
		String string1 = s1.toLowerCase();    // declare string and convert all characters to lowercase
		String string2 = s2.toLowerCase();
		Character c1 = string1.charAt(index);   // declare character and return at specified index
		Character c2 = string2.charAt(index);
		
		if(c1.compareTo(c2) < 0) {   // return -1 if s1 comes before s2
			index = 0;
			return -1;
		}
		
		else if(c1.compareTo(c2) > 0) { // return 1 if s1 comes after s2
			index = 0;
			return 1;
		}
		
		else if(c1.compareTo(c2) == 0 && string1.equalsIgnoreCase(string2)) { // return 0 if s1 == s2
			index = 0;
			return 0;
		}
		
		else {
			index++;
			return compareTo(s1,s2);
		}
	}
	
	/**
	 * Calls the findMinimum helper method which finds the first alphabetical string
	 *
	 * @param ArrayList<String> stringArray arraylist used
	 * @return first alphabetical string
	 */
	public static String findMinimum(ArrayList<String> stringArray) {
		return findMinimum(stringArray, "z");
	}
	
	/**
	 * The helper method of findMinimum that returns first alphabetical string
	 *
	 * @param ArrayList<String stringArray arraylist used
	 * @param String s1 string that holds characters 
	 * @return first alphabetical string
	 */
	public static String findMinimum(ArrayList<String> stringArray, String s1) {
		for(int counter = 0; counter < stringArray.size(); counter++) {
			if(Recursion.compareTo(s1,stringArray.get(counter)) == -1) {
				return findMinimum(stringArray, s1);
			}
			
			else if(Recursion.compareTo(s1,stringArray.get(counter)) == 1) {
				s1 = stringArray.get(counter);
				return findMinimum(stringArray, s1);
			}
			
			else {
				return s1;
			}
		}
		return s1;
	}
}