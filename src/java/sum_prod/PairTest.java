package sum_prod;

import static org.junit.Assert.*;

import org.junit.Test;

public class PairTest {
	
	Pair aPair = new Pair( 5, 13 );
	
	@Test
	// Test Copy constructor
	public void testPair() {
		Pair bPair = new Pair( aPair );
		assertTrue( aPair.equals( bPair ) );
	}
	
	@Test
	// Test setPair
	public void testSetPair(){
		Pair bPair = new Pair( aPair );
		bPair.setPair(1, 2);
		Pair cPair = new Pair( 1, 2 );
		assertTrue( bPair.equals( cPair ) );
	}
}
