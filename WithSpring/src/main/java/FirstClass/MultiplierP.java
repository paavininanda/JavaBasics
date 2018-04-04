package FirstClass;

import java.util.Vector;

import javax.inject.Inject;
import org.springframework.stereotype.Component;

@Component
public class MultiplierP implements Processor<Vector<Integer>>{
	private Multiplier multiplier;

	@Override
	public Vector<Integer> arithmatic (Integer[] input) {
		return multiplier.arithmatic(input);
	}
	
	@Inject
	public void setAddInterface(Multiplier multiplier) {
		this.multiplier = multiplier;
	}
}
