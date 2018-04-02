package FirstClass;

import javax.inject.Inject;
import org.springframework.stereotype.Component;

@Component
public class ProcessorMultiply implements ProcessInterface{
	private ProcessInterface pAdd;
	
	public Integer[] arithmatic (Integer[] input) {
		//	The two complex numbers are input[0] + input[1] i and input[2] + input[3] i;
		Integer[] newInput = new Integer[4];
		newInput[0] = input[0]*input[2];
		newInput[1] = input[0]*input[3];
		newInput[2] = -1 * input[1]*input[3];
		newInput[3] = input[1]*input[2];
		return pAdd.arithmatic(newInput);
	}
	
	@Inject
	public void setAddInterface(ProcessorAdd pInterface) {
		this.pAdd = pInterface;
	}
}
