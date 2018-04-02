package FirstClass;

public class processorMulAdd implements processInterface {
	public Integer[] arithmatic (Integer[] input) {
		processorMultiply mul = new processorMultiply();
		processorAdd add = new processorAdd();
//	Multiplying and two and then adding the multiplaction to first, just for the sake of having multiple dependencies
		Integer[] temp = mul.arithmatic(input);
		input[2] = temp[0];
		input[3] = temp[1];
		return add.arithmatic(input);
	}
}
