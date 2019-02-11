package sum_prod;

import java.util.ArrayList;

public class SumProduct {
	/**
	 * Check conditions set I.
	 * @param pair a pair of numbers in a given range.
	 * @param rng a range with lower and upper limit.
	 * @return true if conditions set I is satisfied.
	 */
	static private boolean s1(Pair pair, Range rng){
		ArrayList<Pair> candidate = rng.twoAddends(pair.sum());
		if (candidate.size() <= 1) {
			return false;
		}
		for (int i=candidate.size()-1; i>=0; --i) {
			Pair p = candidate.get(i);
			ArrayList<Pair> prod_list = rng.twoFactors(p.prod());
			if (prod_list.size() <= 1) {
				return false;
			}
		}
		return true;
	}
	/**
	 * Check conditions set II.
	 * @param pair
	 * @param rng
	 * @return true if conditions set II is satisfied.
	 */
	static private boolean p1(Pair pair, Range rng){
		ArrayList<Pair> candidate = rng.twoFactors(pair.prod());
		if (candidate.size() <= 1) {
			return false;
		}
		int count = 0;
		for (int i=candidate.size()-1; i>=0; --i) {
			if (s1(candidate.get(i), rng)) {
				++count;
			}
		}
		return count==1;
	}
	/**
	 * Check conditions set III.
	 * @param pair
	 * @param rng
	 * @return true if conditions set III is satisfied.
	 */
	static private boolean s2(Pair pair, Range rng){
		ArrayList<Pair> candidate = rng.twoAddends(pair.sum());
		if (candidate.size() <= 1) {
			return false;
		}
		int count = 0;
		for (int i=0; i<candidate.size(); i++) {
			if (p1(candidate.get(i), rng)) {
				++count;
			}
		}
		return count==1;
	}
	/**
	 * Search for solutions that satisfies conditions set I, II and III in a given range.
	 * @param rng
	 * @return an ArrayList of solutions.
	 */
	static public ArrayList<Pair> findSolutions(Range rng){
		ArrayList<Pair> solutions = new ArrayList<Pair>();
		rng.resetPair();
		while(rng.hasNextPair()){
			Pair pair = rng.nextPair();
			if(s1(pair, rng) && p1(pair, rng) && s2(pair, rng)){
				solutions.add(pair);
			}
		}
		return solutions;
	}
}
