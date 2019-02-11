/**
 * 
 */
package sum_prod;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Ben Chuanlong Du
 *
 */
public class RangeTest {

	Range range;
    ArrayList<Pair> pairs;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	public RangeTest(){
		range = new Range(2, 99);
		pairs = new ArrayList<Pair>();
		pairs.add(new Pair(2, 2));
		pairs.add(new Pair(2, 3));
		pairs.add(new Pair(2, 4));
		pairs.add(new Pair(2, 5));
		pairs.add(new Pair(3, 3));
		pairs.add(new Pair(3, 4));
		pairs.add(new Pair(3, 5));
		pairs.add(new Pair(4, 4));
		pairs.add(new Pair(4, 5));
		pairs.add(new Pair(5, 5));
	}
	@Test
	public void testRange() {
		range = new Range(2, 99);
		assertEquals(range.getLower(), 2);
		assertEquals(range.getUpper(), 99);
	}
	
	@Test
	public void testNextPair() {
		range.setRange(2, 5);
		ArrayList<Pair> rangePairs = new ArrayList<Pair>();
		while(range.hasNextPair()){
			rangePairs.add(range.nextPair());
		}
		assertEquals(pairs, rangePairs);
		rangePairs.clear();
		range.resetPair();
		while(range.hasNextPair()){
			rangePairs.add(range.nextPair());
		}
		assertEquals(pairs, rangePairs);
	}
	Range rng = new Range(1,20); 			//Parameter: range of numbers
	@Test
	public void testTwoAddends() {
		int sum = 10;            			//Parameter: sum of addends
		ArrayList<Pair> addends = range.twoAddends(sum);
		System.out.println("Number of addends: " + addends.size());
		int length = addends.size();
		for (int i = 0; i < length; i++){
			assertEquals(addends.get(i).getX() + addends.get(i).getY(), sum);
			System.out.println("addends: " + addends.get(i).getX() + " " + addends.get(i).getY());
		}
	}

	@Test
	public void testTwoFactors() {
		int product = 20;					//Parameter: product of factors
		ArrayList<Pair> factors = range.twoFactors(product);
		System.out.println("Number of factors: " + factors.size());
		int length = factors.size();
		for (int i = 1; i < length; i++){
			assertEquals(factors.get(i).getX() * factors.get(i).getY(), product);
			System.out.println("factors: " + factors.get(i).getX() + " " + factors.get(i).getY());
		}
	}
}
