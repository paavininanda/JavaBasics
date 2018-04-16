package FirstClass;

import java.util.Vector;

import javax.inject.Inject;
import org.springframework.stereotype.Component;

@Component
public class MulAdder implements Processor<Vector<Integer>> {
	private Adder adder;
	private Multiplier multiplier;
	
	@Override
	public Vector<Integer> arithmatic (Integer[] input) {
		//	Multiplying and two and then adding the multiplaction to first, just for the sake of having multiple dependencies
		Vector<Integer> temp = multiplier.arithmatic(input);
		input[2] = temp.get(0);
		input[3] = temp.get(1);
		return adder.arithmatic(input);
	}
	
	@Inject
	public MulAdder(Adder adder, Multiplier multiplier) {
		this.adder=adder;
		this.multiplier=multiplier;
	}
}
