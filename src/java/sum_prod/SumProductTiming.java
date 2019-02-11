package sum_prod;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class SumProductTiming {
	
	/**
	 * Return time needed for finding solutions, in milliseconds, averaged over numTest many runs
	 * @param lower 
	 * @param upper
	 * @param numTest number of runs
	 * @return
	 */
	public static double milliseconds(Range rng, long numTest){
		long startTime = System.nanoTime();
		for(int i=0; i<numTest; ++i){
			SumProduct.findSolutions(rng);
		}
		long endTime = System.nanoTime();
		return (double)(endTime-startTime) / 1E6 / numTest;
	}
	
	public static double milliseconds(Range rng){
		return milliseconds(rng, 100);
	}
	
	public static void main(String[] args){
		try(PrintWriter writer = new PrintWriter("speed_in_milliseconds.txt")) {
            for(int upper=50; upper<=300; upper+=5){
                Range range = new Range(2, upper);
                double timeEllapsed = milliseconds(range);
                writer.print(upper + " " + timeEllapsed + "\n");
                System.out.println(range + ": " + timeEllapsed + " milliseconds");
            }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
	}
}
