package FirstClass;

import javax.inject.Inject;
import org.springframework.stereotype.Component;

@Component
public class ProcessorMulAdd implements ProcessInterface {
	private ProcessInterface pAdd,pMul;
	
	public Integer[] arithmatic (Integer[] input) {
		//	Multiplying and two and then adding the multiplaction to first, just for the sake of having multiple dependencies
		Integer[] temp = pMul.arithmatic(input);
		input[2] = temp[0];
		input[3] = temp[1];
		return pAdd.arithmatic(input);
	}
	
	@Inject
	public void setMulAddInterface(ProcessorAdd interfaceAdd, ProcessorMultiply interfaceMull) {
		this.pAdd=interfaceAdd;
		this.pMul=interfaceMull;
	}
}
