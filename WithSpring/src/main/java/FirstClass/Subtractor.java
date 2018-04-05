package FirstClass;

import java.util.Vector;

import org.springframework.stereotype.Component;

@Component
public class Subtractor implements Processor<Vector<Integer>>{
	
	@Override
	public Vector<Integer> arithmatic (Integer[] input) 
	{
		for (Integer i=0;i<2;i++) 
		{
			output.add(i, input[i] - input[i+2]);
		}
		return output;
	}
}
