package FirstClass;

import org.junit.*;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
	@Test
	public void AdditionOfTwoNumbersTesting() {
	Processor p = new Processor();
	int[] inputNums = new int[4];
	inputNums[0] = 1;
	inputNums[1] = 2;
	inputNums[2] = 1;
	inputNums[3] = 2;
	int[] outputNums = p.add(inputNums);
	assertEquals(outputNums[0],2);
	assertEquals(outputNums[1],4);
	}
}
