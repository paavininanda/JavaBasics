package FirstClass;

import java.util.Arrays;
import java.util.Vector;

import org.springframework.stereotype.Component;

@Component
public class PositiveNumsPlusOne implements Processor<Vector<Integer>>{

	@Override
	public Vector<Integer> arithmatic (Integer[] input) {
		Vector<Integer> output = new Vector<Integer>();
		Arrays.stream(input).filter(number -> number>0).map(num -> num+1).forEach(num -> output.add(num));
		return output;
	}
}
