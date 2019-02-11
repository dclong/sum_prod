package sum_prod;

public class Pair {
	private int x;
	private int y;
	/*
	 * Construct a Pair object from 2 numbers.
	 */
	public Pair(int aX, int aY){
		setPair(aX, aY);
	}
	/*
	 * Construct a Pair object from another Pair object.
	 */
	public Pair(Pair other){
		this(other.x, other.y);
	}

	public int sum(){
		return x + y;
	}
	
	public int prod(){
		return x * y;
	}
	
	public void setPair(int aX, int aY){
		x = aX;
		y = aY;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}

	@Override
	public String toString() {
		return "Pair (" + x + ", " + y + ")";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pair other = (Pair) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}	
}
