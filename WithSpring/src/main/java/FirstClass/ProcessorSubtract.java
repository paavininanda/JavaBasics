package FirstClass;

import org.springframework.stereotype.Component;

@Component
public class ProcessorSubtract implements ProcessInterface{
	
	@Override
	public Integer[] arithmatic (Integer[] input) 
	{
		for (Integer i=0;i<2;i++) 
		{
			output [i] = input[i] - input[i+2];
		}
		return output;
	}
}
