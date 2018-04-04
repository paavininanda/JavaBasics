package FirstClass;

import java.util.Vector;

public interface Processor <T> {
	Vector<Integer> output = new Vector<Integer>();
	public T arithmatic (Integer[] input);
}
