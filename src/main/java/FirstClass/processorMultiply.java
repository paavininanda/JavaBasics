package FirstClass;

public class processorMultiply implements processInterface{
	public Integer[] arithmatic (Integer[] input) {
//	The two complex numbers are input[0] + input[1] i and input[2] + input[3] i;
		Integer[] newInput = new Integer[4];
		newInput[0] = input[0]*input[2];
		newInput[1] = input[0]*input[3];
		newInput[2] = -1 * input[1]*input[3];
		newInput[3] = input[1]*input[2];
		processorAdd pAdd = new processorAdd();
		return pAdd.arithmatic(newInput);
	}
}
