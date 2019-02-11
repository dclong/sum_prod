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
 * @author dclong
 *
 */
public class SumProductTest {

    ArrayList<Pair> solutions;
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
		solutions.clear();
	}
	
	public SumProductTest(){
        solutions = new ArrayList<Pair>();
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		solutions.clear();
	}

	@Test
	public void testFindSolutions() {
		assertEquals(SumProduct.findSolutions(new Range(2, 10)), solutions);
		assertEquals(SumProduct.findSolutions(new Range(2, 59)), solutions);
		assertEquals(SumProduct.findSolutions(new Range(2, 60)), solutions);
		assertEquals(SumProduct.findSolutions(new Range(2, 61)), solutions);
		solutions.add(new Pair(4, 13));
		assertEquals(SumProduct.findSolutions(new Range(2, 62)), solutions);
		assertEquals(SumProduct.findSolutions(new Range(2, 63)), solutions);
		assertEquals(SumProduct.findSolutions(new Range(2, 64)), solutions);
		assertEquals(SumProduct.findSolutions(new Range(2, 99)), solutions);
	}

}
