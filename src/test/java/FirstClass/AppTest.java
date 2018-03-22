package FirstClass;

import org.junit.*;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.*;
import java.util.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
	@Test
	public void additionOfTwoNumbersTesting() {
	Processor p = new Processor();
	Integer[] inputNums = new Integer[4];
	inputNums[0] = 1;
	inputNums[1] = 2;
	inputNums[2] = 1;
	inputNums[3] = 2;
	Integer[] outputNums = p.add(inputNums);
	assertEquals(outputNums[0].intValue(),2);
	assertEquals(outputNums[1].intValue(),4);
	}
	
	@Test (expected=InputMismatchException.class)
	public void invalidInputTest() {
		ByteArrayInputStream in = new ByteArrayInputStream("My string".getBytes());
		System.setIn(in);
		Reader r = new Reader();
		r.takeInput();
	}
	
}
