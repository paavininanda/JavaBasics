package FirstClass;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class processorMulAdd implements processInterface {
	private processInterface pAdd,pMul;
	
	
	public Integer[] arithmatic (Integer[] input) {
		//	Multiplying and two and then adding the multiplaction to first, just for the sake of having multiple dependencies
		Integer[] temp = pMul.arithmatic(input);
		input[2] = temp[0];
		input[3] = temp[1];
		return pAdd.arithmatic(input);
	}
	
	@Autowired
	public void setMulAddInterface(processorAdd interfaceAdd, processorMultiply interfaceMull) {
		this.pAdd=interfaceAdd;
		this.pMul=interfaceMull;
	}
}
