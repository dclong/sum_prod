package sum_prod;

import java.util.ArrayList;

public class Range {
	private int lower;
	private int upper;
	private Pair pair;
	/*
	 * Construct a Range object from lower and upper limits.
	 */
    public Range(int aLower, int aUpper){
		pair = new Pair(0, 0);
		setRange(aLower, aUpper);
	}

	public int getLower(){
		return lower;
	}
	
	public int getUpper(){
		return upper;
	}
	
	public void setRange(int aLower, int aUpper){
		lower = aLower;
		upper = aUpper;
		resetPair();
	}
	/*
	 * Reset the state for generating (all possible) pairs.
	 * You have to call this method before you loop through all possible pairs in this range.
	 */
	public void resetPair(){
		pair.setPair(lower, lower-1);
	}
	/*
	 * Check whether there is still a pair available in this range.
	 */
	public boolean hasNextPair(){
		return pair.getX() < upper || pair.getY() < upper;
	}
	/*
	 * Return the next available pair.
	 * Note that you must first check the availability of a pair using the method hasNextPair.
	 */
	public Pair nextPair(){
		int x = pair.getX();
		int y = pair.getY() + 1;
		if(y>upper){
			++x;
			y = x;
		}
		pair.setPair(x, y);
		return new Pair(pair);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + lower;
		result = prime * result + upper;
		return result;
	}

	@Override
	public final boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Range)) {
			return false;
		}
		Range other = (Range) obj;
		return lower == other.lower && upper == other.upper;
	}
	/*
	 * Return an ArrayList of all pairs (x, y) in the given range such that x + y == sum, x <= y.
	 * @param sum the sum of the 2 numbers.
	 * @param rng a give range (with lower and upper limits).
	 */
    ArrayList<Pair> twoAddends(int sum){
		ArrayList<Pair> addends = new ArrayList<Pair>();
		int half = sum/2;
		if (half > upper || half < lower)
			return addends;
		for (int head = half; head >= lower; head --){
			if (sum - head > upper) break;
			else addends.add(new Pair(head, sum-head));
		}
		return addends;
	}   
	/*
	 * Return an ArrayList of all pairs (x, y) in a given range such that x * y == prod, x <= y.
	 * All the integers are assumed to be positive.
	 */
	ArrayList<Pair> twoFactors(int prod){
		ArrayList<Pair> factors = new ArrayList<Pair>();
		if (lower*lower > prod || upper*upper < prod) 
			return factors;
		for (int head = lower; head<=upper; ++head){
			if (head*head > prod) 
				break;
			else if (prod%head != 0) 
				continue;
			else if (prod/head > upper) 
				continue;
			else 
				factors.add(new Pair(head, prod/head));
		}
		return factors;
	}

	@Override
	public String toString() {
		return "Pair [" + lower + ", " + upper + "]";
	}
	
}
