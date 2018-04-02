package FirstClass;

import org.springframework.stereotype.Component;

@Component
public class Printer implements PrintInterface{
	public void printSum (Integer[] output)
	{
		System.out.println(output[0] + "+" + output[1]+"i");
	}
}
