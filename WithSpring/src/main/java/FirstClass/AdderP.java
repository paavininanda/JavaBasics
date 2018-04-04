package FirstClass;

import java.util.Vector;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

@Component
public class AdderP implements Processor<Vector<Integer>> {
	
	private Adder adder;
	
	@Override
	public Vector<Integer> arithmatic(Integer[] input) {
		return adder.arithmatic(input);
	}
	
	@Inject
	public void setAdder(Adder adder) {
		this.adder = adder;
	}
}
