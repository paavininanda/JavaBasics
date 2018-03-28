package FirstClass;

public class Printer implements printInterface{
	public void printSum (Integer[] output)
	{
		System.out.println(output[0] + "+" + output[1]+"i");
	}
}
