package FirstClass;

import java.util.Vector;

import org.springframework.stereotype.Component;

@Component
public class ConsolePrinter implements Writer<Vector<Integer>>{
	
	@Override
	public void print (Vector<Integer> output)
	{
		System.out.println(output.get(0) + "+" + output.get(1) + "i");
	}
}


