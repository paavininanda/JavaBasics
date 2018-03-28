package FirstClass;

public class Processor implements processInterface{
	
	public Integer[] add (Integer[] input) 
	{
		for (Integer i=0;i<2;i++) 
		{
			output [i] = input[i] + input[i+2];
		}
		return output;
	}
}
