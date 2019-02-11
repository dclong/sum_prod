package sum_prod;

import java.util.ArrayList;

public class RunSumProduct {

	public static void main(String[] args) {
		Range rng = new Range(2, 99);
		ArrayList<Pair> solutions = SumProduct.findSolutions(rng);
		int size = solutions.size();
		for(int i=0; i<size; ++i){
			System.out.println(solutions.get(i));
		}
	}
}
